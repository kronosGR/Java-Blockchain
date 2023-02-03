package blockchain;

import blockchain.Models.Block;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static blockchain.Manager.*;

public class Main {

    static final int MINERS = 4;
    static final int BLOCKS = 5;
    private static volatile Block previousBlock;

    static List<String> randomMsgs = new ArrayList<>(List.of(
            "Tom: Hey, I'm first!",
            "Tom: You're welcome :)",
            "Sarah: It's not fair!",
            "Sarah: You always will be first because it is your blockchain!",
            "Sarah: Anyway, thank you for this amazing chat.",
            "Tom: You're welcome :)",
            "Nick: Hey Tom, nice chat",
            "Tom: Hey, I'm first!",
            "Tom: You're welcome :)",
            "Sarah: It's not fair!",
            "Sarah: You always will be first because it is your blockchain!"
    ));

    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();
        ExecutorService miners = Executors.newFixedThreadPool(MINERS);
        Manager manager = new Manager(0, 0);
        List<String> msgs = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < MINERS; i++) {
            miners.submit(() -> {
               edo: while (blockchain.getSize() < BLOCKS) {
                    final int size = blockchain.getSize();
                    long startTime = System.nanoTime();
                    String magic;
                    String hash;
                    Random random = new Random();

                    do {
                        magic = String.valueOf(random.nextInt());
                        hash = createHash(magic);
                        if (size != blockchain.getSize()) {
                            continue edo;
                        }
                    } while (!isRight(hash));
                    int duration = (int) ((System.nanoTime() - startTime) / 1000000000);

                    Block block = manager.createBlock(magic, hash, duration, previousBlock, "no messages");
                    synchronized (Main.class) {
                        if (block != null && blockchain.getSize() == size) {
                            while (msgs.isEmpty()) { }
                            String msg = String.join("\n", msgs);
                            msgs.clear();
                            block.setMsg(msg);
                            previousBlock = block;
                            blockchain.addBlock(block);
                            System.out.println("Block:");
                            System.out.println("Created by miner # " + Thread.currentThread().getId());
                            System.out.println(block);
                            System.out.println("Block was generating for " + duration + " seconds");
                            manager.updateZeros(duration, size + 10);
                        }
                    }


                }
            });
        }
        addMessages(miners, msgs);

        try {
            miners.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    private static void addMessages(ExecutorService miners, List<String> msgs) {
        Random random = new Random();
        while (!miners.isTerminated()) {
            try {
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            msgs.add(randomMsgs.get(random.nextInt(randomMsgs.size())));
        }
    }
}

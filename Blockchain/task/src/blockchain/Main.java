package blockchain;

import blockchain.Models.Block;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static blockchain.Manager.*;

public class Main {

    static final int MINERS = 4;
    static final int BLOCKS = 5;
    private static volatile Block previousBlock;

    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();
        ExecutorService miners = Executors.newFixedThreadPool(MINERS);
        Manager manager = new Manager(0, 0);

        for (int i = 0; i < MINERS; i++) {
            miners.submit(() -> {
                while (blockchain.getSize() < BLOCKS) {
                    final int size = blockchain.getSize();
                    long startTime = System.nanoTime();
                    String magic;
                    String hash;
                    Random random = new Random();

                    do {
                        magic = String.valueOf(random.nextInt());
                        hash = createHash(magic);
                    } while (!isRight(hash));
                    int duration = (int) ((System.nanoTime() - startTime) / 1000000000);

                    synchronized (Main.class) {
                        Block block = manager.createBlock(magic, hash, duration, previousBlock);
                        if (block != null && blockchain.getSize() == size) {
                            previousBlock = block;
                            blockchain.addBlock(block);
                            System.out.println("Block:");
                            System.out.println("Created by miner # " + Thread.currentThread().getId());
                            System.out.println(block);
                            System.out.println("Block was generating for " + duration + " seconds");
                            manager.updateZeros(duration, size + 1);
                        }
                    }


                }
            });
        }
        try {
            miners.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

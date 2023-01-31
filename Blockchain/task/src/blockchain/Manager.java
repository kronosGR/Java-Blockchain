package blockchain;

import blockchain.Models.Block;

import java.util.Date;
import java.util.Random;

public class Manager {
    Random random;
    static volatile int zeros;
    volatile int lastTime;

    public Manager(int z, int lastTime) {
        this.zeros = z;
        this.lastTime = lastTime;
        random = new Random();
    }

    public Block createBlock(String magic, String hash, long duration, Block previousBlock) {
        long timeStamp = getTimeStamp();
        int id = getNewId(previousBlock);
        String prevHash = getPreviousHash(previousBlock);
        Block nextBlock;

        nextBlock = new Block(id, timeStamp, hash, prevHash, magic, duration);
        return nextBlock;
    }


    private int getNewId(Block previousBlock) {
        return previousBlock == null ? 1 : previousBlock.getId() + 1;
    }



    public static boolean isRight(String hash) {
        return hash.startsWith("0".repeat(zeros));
    }

    public static String createHash(String txt) {
        return StringUtil.applySha256(txt);
    }

    private String getPreviousHash(Block previousBlock) {
        if (previousBlock != null) return previousBlock.getHash();
        else return "0";
    }

    public static long getTimeStamp() {
        return new Date().getTime();
    }

    public void updateZeros(int duration, int size) {
        this.lastTime = (lastTime + duration) / size;
        if (lastTime > duration) {
            zeros++;
            System.out.println("N was increased to " + zeros);
        } else if (lastTime == duration) {
            System.out.println("N stays the same");
        } else {
            this.zeros = zeros == 0 ? 0 : zeros - 1;
            System.out.println("N was decreased to " + zeros);
        }
        System.out.println();
    }

}

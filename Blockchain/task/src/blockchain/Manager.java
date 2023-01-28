package blockchain;

import blockchain.Models.Block;

import java.util.Date;
import java.util.Random;

public class Manager {
    Random random;
    Blockchain blockchain;
    Block previousBlock;
    volatile int zeros;
    int blockID = 0;

    public Manager(int z) {
        this.zeros = z;
        random = new Random();
        blockchain = new Blockchain();
    }

    public Block createBlock() {
        long timeStamp = getTimeStamp();
        int id = getNewId();
        String prevHash = getPreviousHash();
        Block nextBlock;

        long magic;
        long startTime = getTimeStamp();
        String hash;

        do {
            magic = random.nextLong();
            hash = createHash(String.valueOf(magic));
        } while (!isRight(hash));

        long endTime = getTimeStamp();
        long duration = endTime - startTime;

        nextBlock = new Block(id, timeStamp, hash, prevHash, magic, duration);
        blockchain.addBlock(nextBlock);
        previousBlock = nextBlock;
        return nextBlock;
    }

    private int getNewId() {
        return blockID++;
    }

    private Block getLastBlock() {
        if (blockchain.getSize() > 0)
            return blockchain.getBlock(blockchain.getSize() - 1);
        else
            return null;
    }


    private boolean isRight(String hash) {
        return hash.startsWith("0".repeat(zeros));
    }

    private String createHash(String txt) {
        return StringUtil.applySha256(txt);
    }

    private String getPreviousHash() {
        if (previousBlock != null) return previousBlock.getHash();
        else return "0";
    }

    private long getTimeStamp() {
        return new Date().getTime();
    }

    public void updateZeros(){

    }

}

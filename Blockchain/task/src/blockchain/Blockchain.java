package blockchain;

import blockchain.Models.Block;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Blockchain {
    int blockID;
    List<Block> blocks;
    int zeros;
    Block previousBlock;
    Random random;

    public Blockchain(int zeros) {
        blocks = new ArrayList<>();
        this.zeros = zeros;
        random = new Random();
    }

    private Block getLastBlock() {
        if (blocks.size() > 0)
            return blocks.get(blocks.size() - 1);
        else
            return null;
    }


    public void createNewBlock() {
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

        nextBlock = new Block(id,timeStamp,hash,prevHash,magic,duration);
        previousBlock = nextBlock;
        blocks.add(nextBlock);
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

    private int getNewId() {
        return blockID++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block block : blocks) {
            sb.append(block.toString());
            sb.append("\n\n");
        }
        return sb.toString();
    }
}

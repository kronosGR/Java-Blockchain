package blockchain;

import blockchain.Models.Block;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blockchain {
    int blockID = 1;
    List<Block> blocks = new ArrayList<>();

    private Block getLastBlock() {
        if (blocks.size() > 0)
            return blocks.get(blocks.size() - 1);
        else
            return null;
    }

    private int getNewId() {
        return blockID++;
    }

    private String createHash() {
        return StringUtil.applySha256(String.valueOf(new Date().getTime() + blockID));
    }


    public void createNewBlock() {
        Block lastBlock = getLastBlock();
        Block nextBlock;

        if (lastBlock == null)
            nextBlock = new Block(getNewId(), new Date().getTime(), createHash());
        else
            nextBlock = new Block(getNewId(), new Date().getTime(), createHash(), lastBlock.getHash());

        blocks.add(nextBlock);
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

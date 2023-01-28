package blockchain;

import blockchain.Models.Block;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Blockchain {
    List<Block> blocks;

    public Blockchain() {
        blocks = new ArrayList<>();
    }

    public int getSize(){
        return  blocks.size();
    }

    public void addBlock(Block block){
        blocks.add(block);
    }

    public Block getBlock(int id){
        return blocks.get(id);
    }


//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        for (Block block : blocks) {
//            sb.append(block.toString());
//            sb.append("\n\n");
//        }
//        return sb.toString();
//    }
}

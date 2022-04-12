package com.ftc;

import java.util.Date;
import java.util.LinkedList;

public class Blockchain {
    private Block genesisBlock;
    private LinkedList<Block> chain;

    public Blockchain() {
        this.genesisBlock = new Block("0000", "genesis block", 0);
        chain = new LinkedList<>();
        chain.add(this.genesisBlock);
    }

    public Block getGenesisBlock() {
        return genesisBlock;
    }

    public void setGenesisBlock(Block genesisBlock) {
        this.genesisBlock = genesisBlock;
    }

    public LinkedList<Block> getChain() {
        return chain;
    }

    public void setChain(LinkedList<Block> chain) {
        this.chain = chain;
    }

    public void addBlock(String data) {
        System.out.println();
        Block block = new Block(chain.getLast().getPrevHash(), data, new Date().getTime());
        if(block.mineBlock(5).equals(block.getHash())) {
            chain.add(block);
            System.out.println("Done Mining -> New block created | " + new Date(block.getTimestamp()));
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block block : chain) {
            sb.append(block.getData() + "\n");
        }
        return sb.toString();
    }
}

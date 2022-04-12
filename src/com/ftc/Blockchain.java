package com.ftc;

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
}

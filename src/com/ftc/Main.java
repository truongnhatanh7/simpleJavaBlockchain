package com.ftc;

public class Main {

    public static void main(String[] args) {
        Block genesisBlock = new Block("0000", "github", 0);
        System.out.println(genesisBlock.getNonce());
        System.out.println(genesisBlock.calculateHash());
        System.out.println(genesisBlock.getHash());
    }
}

package com.ftc;

public class Main {

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        for (int i = 0; i < 100; i++) { // Create 100 block
            blockchain.addBlock(i + " transaction");
        }
    }
}

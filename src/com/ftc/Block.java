package com.ftc;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Block {
    private String hash;
    private String prevHash;
    private String data;
    private long timestamp;
    private int nonce;

    public Block(String prevHash, String data, long timestamp) {
        this.prevHash = prevHash;
        this.data = data;
        this.timestamp = timestamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String calculateHash() {
        byte[] encodedhash = null;
        try {
            String combinedString = data
                                + timestamp
                                + nonce
                                + prevHash;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            encodedhash = digest.digest(
                    combinedString.getBytes(StandardCharsets.UTF_8));
        } catch (Exception exception) {
            System.out.println("Failed to hash");
        }
        StringBuilder finalString = new StringBuilder();
        for (byte b : encodedhash) {
            finalString.append(String.format("%02x", b));
        }
        return finalString.toString();
    }

    public String mineBlock(int difficulty) {
        System.out.println("Mining...");
        String key = "00000000000000000";
        hash = calculateHash();
        while (!hash.substring(0,difficulty).equals(key.substring(0, difficulty))) {
            nonce++;
            hash = calculateHash();
        }
        return hash;
    }
}

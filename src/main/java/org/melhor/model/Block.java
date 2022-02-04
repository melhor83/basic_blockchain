package org.melhor.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Block {
    private int index;
    private long timestamp;
    private long proof;
    private String prevHash;
    private List<Transaction> transactions;

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public long getProof() {
        return proof;
    }
    public void setProof(long proof) {
        this.proof = proof;
    }
    public String getPrevHash() {
        return prevHash;
    }
    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transaction) {
        this.transactions = transaction;
    }

    
}



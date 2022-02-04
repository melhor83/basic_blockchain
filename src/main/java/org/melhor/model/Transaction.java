package org.melhor.model;

public class Transaction {
    private String sender;
    private String receiver;
    private String amount;
    
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Transaction sender(String sender) {
        this.sender = sender;
        return this;
    }

    public Transaction receiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public Transaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    
}

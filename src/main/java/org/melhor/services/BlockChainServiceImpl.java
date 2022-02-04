package org.melhor.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.codec.digest.DigestUtils;
import org.melhor.model.Block;
import org.melhor.model.Transaction;

import io.vertx.core.json.Json;

@ApplicationScoped
class BlockChainServiceImpl implements BlockChainService {

    private LinkedList<Block> chain;
    private List<Transaction> current_transactions;

    public BlockChainServiceImpl() {
        chain = new LinkedList<>();
        current_transactions = new ArrayList<>();

        newBlock(100L, "1");
    }

    public Block newBlock(long proof, String previousHash) {
        Block block = new Block();
        block.setIndex(this.chain.size() + 1);
        block.setTimestamp(System.currentTimeMillis());
        block.setTransactions(new ArrayList<>(current_transactions));
        block.setProof(proof);
        block.setPrevHash(previousHash);
        chain.add(block);
        current_transactions.clear();
        return block;
    }

    public int newTransaction(Transaction transaction) {
        this.current_transactions.add(transaction);
        return lastBlock().getIndex() + 1;
    }

    public Block lastBlock() {
     return this.chain.getLast();
    }

    public String hash(Block block) {
        return new DigestUtils("SHA3-256").digestAsHex(Json.encode(block));
    }

    public List<Block> getChain() {
        return this.chain;
    }
    
}

package org.melhor.services;

import java.util.List;

import org.melhor.model.Block;
import org.melhor.model.Transaction;

public interface BlockChainService {
    

    List<Block> getChain();

    int newTransaction(Transaction transaction);

    Block newBlock(long proof, String previousHash);

    Block lastBlock();

    String hash(Block block);
}

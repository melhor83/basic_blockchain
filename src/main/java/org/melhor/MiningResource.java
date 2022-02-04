package org.melhor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.melhor.model.Block;
import org.melhor.model.Transaction;
import org.melhor.services.BlockChainService;
import org.melhor.services.PoWService;


@Path("/mine")
public class MiningResource {
    
    @Inject
    private BlockChainService blockChainService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<Block> mine() {
        return CompletableFuture.supplyAsync(() -> doMining());
    }

    private Block doMining() {
        Block lastBlock = blockChainService.lastBlock();

        long proof = PoWService.proofOfWork(lastBlock.getProof());

        blockChainService.newTransaction(new Transaction().amount("1").sender("0").receiver("Node"));

        String prevHash = blockChainService.hash(lastBlock);
        Block newBlock = blockChainService.newBlock(proof, prevHash);
        return newBlock;
    }
}

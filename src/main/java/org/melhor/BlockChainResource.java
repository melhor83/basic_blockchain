package org.melhor;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.melhor.model.Block;
import org.melhor.services.BlockChainService;

@Path("/chain")
public class BlockChainResource {

    @Inject
    private BlockChainService blockChainService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Block> getChain(String sender, String recipient, String amount) {
        return blockChainService.getChain();
    }
    
}

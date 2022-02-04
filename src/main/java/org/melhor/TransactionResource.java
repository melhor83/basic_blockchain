package org.melhor;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.melhor.model.Transaction;
import org.melhor.services.BlockChainService;

@Path("/transaction")
public class TransactionResource {

    @Inject
    private BlockChainService blockChainService;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public long newTransaction(@NotNull Transaction transaction) {
        return blockChainService.newTransaction(transaction);
    }

}

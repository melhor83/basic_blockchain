package org.melhor.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoWService {

    private static DigestUtils DIGEST = new DigestUtils("SHA3-256");
    private static Logger LOGGER = LoggerFactory.getLogger(PoWService.class);
    
    /**
     * Simple Proof of Work Algorithm:
     * - Find a number p' such that hash(pp') contains leading 4 zeroes, where p is the previous p'
     * - p is the previous proof, and p' is the new proof
     * @param lastProof the previous proof
     * @return the proof
     */
    public static long proofOfWork(long lastProof) {
        long proof = 0;
        while (!validProof(lastProof, proof)) {
            proof++;
        }
        return proof;
    }

    /**
     * Validates the Proof: Does hash(last_proof, proof) contain 3 leading zeroes?
     * @param lastProof
     * @param proof
     * @return {@code true} if proof is valid
     */
    public static boolean validProof(long lastProof, long proof) {
        String guess = String.format("%1$s%2$s", lastProof, proof);
        String data = DIGEST.digestAsHex(guess);
        LOGGER.trace("GUESS: "+guess+" DATA: " + data);
        return data.startsWith("0000");
    }
}

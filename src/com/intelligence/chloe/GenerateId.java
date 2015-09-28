package com.intelligence.chloe;

/**
 * Created by didier leonard-jean charles on 9/21/15
 *
 * Please note: the following method uses SecureRandom and MessageDigest
 */

import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenerateId {

    private String id;

    public GenerateId() {
        setId();
    }

    public String getId() {
        return id;
    }

    private void setId() {
        try {
            // Initialize SecureRandom
            // This is a lengthy operation, to be done only upon
            // initialization of the application
            SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");

            // generate a random number
            String randomNum = new Integer(prng.nextInt()).toString();

            // get its digest
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] result =  sha.digest(randomNum.getBytes());

            id = hexEncode(result);
        }
        catch (NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
    }

    /**
     * The byte[] returned by MessageDigest does not have a nice
     * textual representation, so some form of encoding is usually performed.
     *
     * This implementation follows the example of David Flanagan's book
     * "Java In A Nutshell", and converts a byte array into a String
     * of hex characters.
     *
     * Another popular alternative is to use a "Base64" encoding.
     */
    private String hexEncode(byte[] aInput){
        StringBuilder result = new StringBuilder();
        char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','a','b','c','d','e','f'};
        for (int idx = 0; idx < aInput.length; ++idx) {
            byte b = aInput[idx];
            result.append(digits[ (b&0xf0) >> 4 ]);
            result.append(digits[ b&0x0f]);
        }
        return result.toString();
    }
}

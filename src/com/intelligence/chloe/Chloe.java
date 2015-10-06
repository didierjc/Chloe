package com.intelligence.chloe;

import java.util.Scanner;

/**
 * @author Didier Leonard-Jean Charles
 * @version Chlöe 1.0.0
 *
 */

public class Chloe {

    public static void main(String[] args) {
        ChloeFile cf = new ChloeFile();
        AboutChloe chloe = new AboutChloe();
        ChloeAndI iam = new ChloeAndI();
        Scanner scan = new Scanner(System.in);
        String answers = null;

        // ask to connect to Social Media, browsing history, etc.
        if(!cf.checkIfKeyExist("permission_facebook")) {
            System.out.println("I want to learn more about you, may I connect to your Facebook, Twitter, Instagram and " +
                    "LinkedIn accounts?\n Just enter Yes if I can connect to all of them, or No if you don't want me connecting " +
                    "to any of them, or a comma separated list of the individual accounts that I can connect to...");
            answers = scan.nextLine();

            if (answers.equalsIgnoreCase("Yes")) {
                System.out.println("Sweet! I'm on it...\n");
                // append to SM object to iterate over
            }else if(answers.equalsIgnoreCase("No")) {
                System.out.println("Ok, no problem...\n");
            }else if(answers.toLowerCase().contains("facebook") || answers.toLowerCase().contains("twitter") || answers.toLowerCase().contains("instagram")|| answers.toLowerCase().contains("linkedin")){
                //
            }else{
                System.out.println("I'm not sure what you mean...\n");
            }
        }
    }

}

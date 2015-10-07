package com.intelligence.chloe;

import java.util.HashMap;
import java.util.Map;
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
        _SocialMedia _sm = new _SocialMedia();
        String answers = null;
        String perm = null;

        // ask to connect to Social Media, browsing history, etc.
        if(!cf.checkIfKeyExist("permission_socialmedia")) {
            Map<String,String> permElements = new HashMap<String,String>();

            System.out.println("\n\nI want to learn more about you, may I connect to your Facebook, Twitter, Instagram and" +
                    "LinkedIn accounts?\nJust enter Yes if I can connect to all of them, or No if you don't want me connecting" +
                    "to any of them,\nor enter a comma separated list of the individual accounts that I can connect to\n" +
                    "[ex. Facebook,Twitter,Instagram,LinkedIn]...");
            answers = scan.nextLine();

            if (answers.toLowerCase().contains("yes") || answers.toLowerCase().contains("sure")) {
                System.out.println("Sweet! I'm on it...\n");
                perm = "true";

            }else if(answers.toLowerCase().contains("facebook") || answers.toLowerCase().contains("twitter") || answers.toLowerCase().contains("instagram")|| answers.toLowerCase().contains("linkedin")){
                perm = "true";
                _sm.parseSocialList(answers);

            }else if(answers.toLowerCase().contains("no")) {
                System.out.println("Ok, no problem...\n");
                perm = "false";

            }else{
                System.out.println("I'm not sure what you mean...\n");
            }

            if(perm.equals("true")){
                permElements.put("permission_socialmedia", "true");
            }else if(perm.equals("false")){
                permElements.put("permission_socialmedia", "false");
            }

            if(perm != null){
                cf.writeCF(permElements);
            }
        }
    }

}

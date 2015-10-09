package com.intelligence.chloe;

import java.util.HashMap;
import java.util.List;
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
        String answers = null;
        String perm = null;
        List<String> smList = null;

        __CMisc cmisc = new __CMisc();
        _SocialMedia _sm = new _SocialMedia();

        // ask to connect to Social Media, browsing history, etc.
        if(!cf.checkIfKeyExist("permission_socialmedia")) {
            Map<String,String> permElements = new HashMap<String,String>();

            System.out.println("\n\nI want to learn more about you, may I connect to your Facebook, Twitter, Instagram and" +
                    "LinkedIn accounts?\nJust enter Yes if I can connect to all of them, or No if you don't want me connecting" +
                    "to any of them,\nor enter a comma separated list of the individual accounts that I can connect to\n" +
                    "[ex. Facebook,Twitter,Instagram,LinkedIn]...");
            answers = scan.nextLine();

            if (answers.toLowerCase().contains("yes") || answers.toLowerCase().contains("sure") || answers.toLowerCase().contains("facebook") || answers.toLowerCase().contains("twitter") || answers.toLowerCase().contains("instagram") || answers.toLowerCase().contains("linkedin")) {
                System.out.println("Sweet! I'm on it...\n");
                perm = "true";

            }else if(answers.toLowerCase().contains("no")) {
                System.out.println("Ok, no problem...\n");
                perm = "false";

            }else{
                System.out.println("I'm not sure what you mean...\n");
            }

            switch (perm) {
                case "true":
                    permElements.put("permission_socialmedia", "true");
                    break;
                case "false":
                    permElements.put("permission_socialmedia", "false");
                    break;
            }

            if(perm != null){
                cf.writeCF(permElements);
                _sm.parseSocialList(answers);
                smList = _sm.getSocialList();
            }

            if(cmisc.blnContains("facebook",smList)){
                String p = "user_friends,public_profile,user_about_me,user_actions.books,user_actions.fitness,user_actions.music,user_actions.news,user_actions.video,user_birthday,user_events,user_games_activity,user_hometown,user_likes,user_location,user_posts,user_relationships,user_relationship_details,user_tagged_places,user_work_history,rsvp_event";
                Boolean s = true;
                Boolean j = true;
                _sm.fbConnect(p,s,j);
            }
        }
    }

}

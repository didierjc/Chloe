package com.intelligence.chloe;

import facebook4j.*;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import java.util.*;

/**
 * Created by didier leonard-jean charles on 10/6/15.
 */
public class _SocialMedia {

    private List<String> socialList = new ArrayList();
    __CConfig config = new __CConfig();
    __CMisc cmisc = new __CMisc();
    ChloeFile cf = new ChloeFile();
    ConfigurationBuilder fbConfBuilder = new ConfigurationBuilder();

    private void facebookConfig(){
        fbConfBuilder.setDebugEnabled(true);
        // Set application id, secret key and access token
        fbConfBuilder.setOAuthAppId(String.valueOf(config.getFbAppid()));
        fbConfBuilder.setOAuthAppSecret(config.getFbAppsecret());
        fbConfBuilder.setOAuthAccessToken(config.getFbApptoken());
        //fbConfBuilder.setOAuthAccessToken(new AccessToken(config.getFbApptoken(), null));
    }

    private void facebookPermissions(String perm, Boolean ssl, Boolean json){
        fbConfBuilder.setOAuthPermissions(perm);
        fbConfBuilder.setUseSSL(ssl);
        fbConfBuilder.setJSONStoreEnabled(json);

    }

    public _SocialMedia() {}

    public void parseSocialList(String list){
        socialList = Arrays.asList(list.split(","));
    }

    public List<String> getSocialList() {
        return socialList;
    }

    public void addToSocialList(String s) {
        socialList.add(s);
    }

    public void fbConnect(String perm, Boolean ssl, Boolean json){
        facebookConfig();
        facebookPermissions(perm,ssl,json);

        // Create configuration object
        Configuration configuration = fbConfBuilder.build();

        // Create facebook instance
        FacebookFactory ff = new FacebookFactory(configuration);
        Facebook facebook = ff.getInstance();

        try{
            // Get facebook posts
            String results = getFacebookPosts(facebook, "me");
            String response = cmisc.stringToJson(results);
            Map<String,String> fbRes = new HashMap<String,String>();
            fbRes.put("facebook_movie_posts", response);
            cf.writeCF(fbRes);

        } catch (FacebookException e) {
            e.printStackTrace();
        }
    }

    public static String getFacebookPosts(Facebook facebook, String posts) throws FacebookException {
        // Get posts for a particular search
        ResponseList<Post> results = facebook.getPosts(posts);
        return results.toString();
    }

}

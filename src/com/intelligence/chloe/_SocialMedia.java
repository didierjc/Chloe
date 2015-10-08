package com.intelligence.chloe;

import facebook4j.conf.ConfigurationBuilder;
import java.util.*;

/**
 * Created by didier leonard-jean charles on 10/6/15.
 */
public class _SocialMedia {

    private List<String> socialList = new ArrayList();
    __CConfig config = new __CConfig();
    __CMisc cmisc = new __CMisc();
    ConfigurationBuilder fbconfBuilder = new ConfigurationBuilder();


    public _SocialMedia() {

    }

    public void parseSocialList(String list){
        socialList = Arrays.asList(list.split(","));
    }

    public List<String> getSocialList() {
        return socialList;
    }

    private void facebookConfig(){
        fbconfBuilder.setDebugEnabled(true);
        // Set application id, secret key and access token
        fbconfBuilder.setOAuthAppId(String.valueOf(config.getFbAppid()));
        fbconfBuilder.setOAuthAppSecret(config.getFbAppsecret());
        fbconfBuilder.setOAuthAccessToken(config.getFbApptoken());
    }
}

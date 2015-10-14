package com.intelligence.chloe;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.User;

/**
 * Created by didier leonard-jean charles on 10/12/15.
 */
public class _SocialMedia_Facebook extends DefaultFacebookClient {

    __CConfig config = new __CConfig();

    public _SocialMedia_Facebook() {
        AccessToken accessToken = obtainAppAccessToken(String.valueOf(config.getFbAppid()), config.getFbAppsecret());
        //AccessToken userAccessToken = obtainUserAccessToken(String.valueOf(config.getFbAppid()), config.getFbAppsecret(), "http://localhost:3000/", );
        FacebookClient facebookClient = new DefaultFacebookClient(config.getFbUsertoken(), config.getFbAppsecret(), config.getFbApiversion()); //String.valueOf(accessToken.getAccessToken())
        User user = facebookClient.fetchObject("me", User.class, Parameter.with("metadata", 1));
        System.out.println(user.getFirstName() + " " + user.getLastName());
    }


}

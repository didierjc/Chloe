package com.intelligence.chloe;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.User;

/**
 * Created by didier leonard-jean charles on 10/12/15.
 */
public class _SocialMedia_Facebook extends DefaultFacebookClient {

    __CConfig config = new __CConfig();

    public _SocialMedia_Facebook() {
        AccessToken accessToken = obtainAppAccessToken(String.valueOf(config.getFbAppid()), config.getFbAppsecret());
        FacebookClient facebookClient = new DefaultFacebookClient(String.valueOf(accessToken), config.getFbAppsecret(), config.getFbApiversion());
        User user = facebookClient.fetchObject("me", User.class);
        System.out.println(user.getFirstName() + " " + user.getLastName());
    }


}

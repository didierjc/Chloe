package com.intelligence.chloe;

import com.restfb.DefaultFacebookClient;

/**
 * Created by didier leonard-jean charles on 10/18/15.
 */
public class LogInFB extends DefaultFacebookClient {

    public LogInFB(){}

    public String LoggedInFacebookClient(String appId, String appSecret) {
        AccessToken accessToken = this.obtainUserAccessToken(appId, appSecret, "http://facebook/fboauth.php");
        return accessToken.getAccessToken();
    }

}
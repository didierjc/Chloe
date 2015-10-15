package com.intelligence.chloe;

import com.restfb.Version;

/**
 * Created by didier leonard-jean charles on 10/7/15.
 */
public class __CConfig {

    private static final long FB_APPID = 1503891386597329L;
    private static final String FB_APPSECRET = "3e64df46c06d9641900ac72a11e9f14d";
    private static final Version FB_APIVERSION = Version.VERSION_2_4;
    private static final String FB_APPTOKEN = "1503891386597329|wF3IVVc8JfdzfdDRBbDV9-IYzo8";
    private static final String FB_USERTOKEN = "CAAVXxZCZCgZC9EBAAWyZAfqhyumfmi3z4LRAhDYOSkV7wfuC5GOEoaDhu99LsCt4jgU9aayrC8p6VL4BgD3wykW3sEZCEtXZAdCJsXznq0qjcG6LNLZCi0ZBFYxlbFMNihEc0t0Ji2RTtW1PGOQbyvLbAtlIYGMOJiEjlQwEjj8VJBwWcF5cwTOZB1kmZAJz2UZAXNdHZCA92pr2KwZDZD";
    private static final String FB_REDIRECTURI = "http://www.facebook.com/connect/login_success.html";

    public __CConfig() {}

    public static long getFbAppid() {
        return FB_APPID;
    }

    public static String getFbAppsecret() {
        return FB_APPSECRET;
    }

    public static Version getFbApiversion() {
        return FB_APIVERSION;
    }

    public static String getFbApptoken(){
        return FB_APPTOKEN;
    }

    public static String getFbUsertoken() { return FB_USERTOKEN; }

    public static String getFbRedirecturi() {
        return FB_REDIRECTURI;
    }
}

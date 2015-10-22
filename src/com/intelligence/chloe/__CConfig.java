package com.intelligence.chloe;

import com.restfb.Version;

/**
 * Created by didier leonard-jean charles on 10/7/15.
 */
public class __CConfig {

    private static final long FB_APPID = 1683077831978416L;
    private static final String FB_APPSECRET = "a0fdb850bb9df2c587695e670b0dbf30";
    private static final Version FB_APIVERSION = Version.VERSION_2_5;
    private static final String FB_APPTOKEN = "1683077831978416|04RDW2VFVfZof8LoSvBqeWbPezg";
    private static final String FB_REDIRECTURI = "http://localhost/connect/login_success.html";
    private static final String FB_SCOPE = "public_profile,publish_actions,user_about_me,user_actions.books,user_actions.fitness,user_actions.music,user_actions.news,user_actions.video,user_birthday,user_education_history,user_events,user_games_activity,user_hometown,user_religion_politics,user_status,user_tagged_places,user_work_history,rsvp_event,user_relationships,user_relationship_details,user_location,user_likes,user_posts";

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

    public static String getFbScope() {
        return FB_SCOPE;
    }

    public static String getFbApptoken(){
        return FB_APPTOKEN;
    }

    public static String getFbRedirecturi() {
        return FB_REDIRECTURI;
    }
}


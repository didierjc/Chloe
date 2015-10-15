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
        FacebookClient facebookClient = new DefaultFacebookClient(config.getFbUsertoken(), config.getFbAppsecret(), config.getFbApiversion());
        User user = facebookClient.fetchObject("me", User.class, Parameter.with("metadata", 1), Parameter.with("fields","id, name, about, email, age_range, birthday, bio, currency, education, favorite_athletes, favorite_teams, first_name, last_name, middle_name, gender, hometown, inspirational_people, interested_in, languages, locale, meeting_for, political, relationship_status, religion, significant_other, sports, quotes, timezone, work, books, events, games, groups, likes, movies, music, television"));
        System.out.println("First Name: " + user.getFirstName() + "\nLast Name: " + user.getLastName());
        System.out.println("DOB: "+ user.getBirthday());
        System.out.println("Relationship Status: "+ user.getRelationshipStatus());
        System.out.println("Significant Other: "+ user.getSignificantOther());
    }

}

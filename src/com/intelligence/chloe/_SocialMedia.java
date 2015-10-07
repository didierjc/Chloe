package com.intelligence.chloe;

import java.util.*;

/**
 * Created by didier leonard-jean charles on 10/6/15.
 */
public class _SocialMedia {

    private List<String> socialList = new ArrayList();

    public _SocialMedia() {}

    public void parseSocialList(String list){
        socialList = Arrays.asList(list.split(","));
    }

    public List<String> getSocialList() {
        return socialList;
    }
}

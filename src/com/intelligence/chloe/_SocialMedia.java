package com.intelligence.chloe;

import java.util.*;

/**
 * Created by didier leonard-jean charles on 10/12/15.
 */
public class _SocialMedia {
    private List<String> socialList = new ArrayList();
    __CMisc cmisc = new __CMisc();
    _SocialMedia_Facebook fb = new _SocialMedia_Facebook();
    ChloeFile cf = new ChloeFile();

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
}

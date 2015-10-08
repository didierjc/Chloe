package com.intelligence.chloe;

import java.util.List;

/**
 * Created by didier leonard-jean charles on 10/8/15.
 */
public class __CMisc {
    public __CMisc() {}

    public boolean blnContains(String s, List<String> l){
        for(String str: l) {
            if(str.trim().toLowerCase().contains(s))
                return true;
        }
        return false;
    }
}

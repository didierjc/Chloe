package com.intelligence.chloe;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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

    public String stringToJson(String data) {
        // Create JSON object
        JSONObject jsonObject = JSONObject.fromObject(data);
        JSONArray message = (JSONArray) jsonObject.get("message");
        System.out.println("Message : "+message);
        return "Done";
    }
}

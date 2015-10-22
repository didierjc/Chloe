package com.intelligence.chloe;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by didier leonard-jean charles on 10/8/15.
 */
public class __CMisc {
    public __CMisc() {}

    public static boolean blnContains(String s, List<String> l){
        for(String str: l) {
            if(str.trim().toLowerCase().contains(s))
                return true;
        }
        return false;
    }

    public static String stringToJson(String data) {
        // Create JSON object
        JSONObject jsonObject = JSONObject.fromObject(data);
        JSONArray message = (JSONArray) jsonObject.get("message");
        System.out.println("Message : "+message);
        return "Done";
    }

    public static Map<String, List<String>> splitQuery(URL url) throws UnsupportedEncodingException {
        final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
        final String[] pairs = url.getQuery().split("&");

        for (String pair : pairs) {
            final int index = pair.indexOf("=");
            final String key = index > 0 ? URLDecoder.decode(pair.substring(0, index), "UTF-8") : pair;

            if (!query_pairs.containsKey(key)) {
                query_pairs.put(key, new LinkedList<String>());
            }

            final String value = index > 0 && pair.length() > index + 1 ? URLDecoder.decode(pair.substring(index + 1), "UTF-8") : null;
            query_pairs.get(key).add(value);
        }

        return query_pairs;
    }
}

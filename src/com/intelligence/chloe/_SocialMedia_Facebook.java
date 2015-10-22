package com.intelligence.chloe;

import com.restfb.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by didier leonard-jean charles on 10/12/15.
 */
public class _SocialMedia_Facebook extends DefaultFacebookClient {

    __CConfig config = new __CConfig();
    __CMisc misc = new __CMisc();

    private static String fbloginurl = "http://www.facebook.com/dialog/oauth?client_id=";
    private URL fbauthurl;
    private URLConnection fbconnection;
    private BufferedReader in;
    private String inputLine;
    StringBuffer b = new StringBuffer();
    private String fbcode = null;

    public _SocialMedia_Facebook(){
        try {
            fbauthurl = new URL(getFBAuthUrl());
            fbconnection = fbauthurl.openConnection();
            fbconnection.setRequestProperty("Accept-Charset", "UTF-8");
            in = new BufferedReader(new InputStreamReader(fbconnection.getInputStream()));
            while ((inputLine = in.readLine()) != null)
                b.append(inputLine + "\n");
                System.out.println(inputLine);
            in.close();

            misc.splitQuery(fbauthurl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect with Facebook: " + e);
        }
    }

    public String getFBAuthUrl() throws UnsupportedEncodingException {
        fbloginurl += String.valueOf(config.getFbAppid())+"&redirect_uri="+URLEncoder.encode(config.getFbRedirecturi(),"UTF-8")+"&scope="+URLEncoder.encode(config.getFbScope(),"UTF-8");
        return fbloginurl;
    }

}

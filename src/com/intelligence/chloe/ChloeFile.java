package com.intelligence.chloe;

/**
 * Created by didier leonard-jean charles on 9/25/15.
 */

import org.joda.time.LocalDate;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Iterator;
import java.util.Map;

public class ChloeFile {

    private File f = new File("/_chloe/abt/_chloeandi.chloe");
    private LocalDate dateWeMet = null;
    private String ipAddress = null;
    private String macAddress = null;
    private String id = null;
    private String time_zone = null;
    private String chloeId = null;
    private JSONObject iAm = new JSONObject();

    public boolean firstTime = true;

    public ChloeFile() {
        if(!checkIfFileExist()){
            createCF();
        }

        try {
            getCFcontents();
            if(f.length() > 0){
                firstTime = false;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private void createCF(){
        try{
            FileWriter file = new FileWriter(this.f);
            file.flush();
            file.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeCF(Map<String,String> map){
        for(Map.Entry<String, String> chloeEntry : map.entrySet()){
            this.iAm.put(chloeEntry.getKey(), chloeEntry.getValue());
        }

        try{
            //read file
            BufferedReader in = new BufferedReader(new FileReader(this.f));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while((line = in.readLine()) != null){
                sb.append(line);
            }
            in.close();

            //create a json object
            JSONParser parser = new JSONParser();
            JSONObject json = new JSONObject();
            if(sb.length() != 0) {
                json = (JSONObject) parser.parse(sb.toString());
            }

            for(Iterator iterator = json.keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                this.iAm.put(key, json.get(key));
            }

            FileWriter file = new FileWriter(this.f);
            file.write(this.iAm.toJSONString());
            file.flush();
            file.close();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void getCFcontents() throws FileNotFoundException {
        JSONParser parser = new JSONParser();

        if(f.length() > 0) {
            try {
                Object jsonChloe = parser.parse(new FileReader(f));
                JSONObject objectChloe = (JSONObject) jsonChloe;

                this.ipAddress = (String) objectChloe.get("ip_address");
                this.macAddress = (String) objectChloe.get("mac_address");
                this.id = (String) objectChloe.get("owner_id");
                this.dateWeMet = new LocalDate(objectChloe.get("date_we_met"));
                this.time_zone = (String) objectChloe.get("timezone");
                this.chloeId = (String) objectChloe.get("chloe_id");

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkIfFileExist(){
        // if the file exists
        if(f.exists()) {
            return true;
        }else{
            return false;
        }
    }

    public boolean checkIfKeyExist(String key){
        JSONParser parser = new JSONParser();
        Object jsonChloe = null;

        try {
            jsonChloe = parser.parse(new FileReader(f));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            e.printStackTrace();
        }

        JSONObject objectChloe = (JSONObject) jsonChloe;

        if(objectChloe.containsKey(key)){
            return true;
        }

        return false;
    }

    public LocalDate getDateWeMet() {
        return dateWeMet;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public String getId() { return id; }

    public String getTime_zone() {
        return time_zone;
    }

    public String getChloeId() {
        return chloeId;
    }

    public File getFile() {
        return f;
    }
}

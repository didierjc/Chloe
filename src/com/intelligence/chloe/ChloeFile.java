package com.intelligence.chloe;

/**
 * Created by didier leonard-jean charles on 9/25/15.
 */

import org.joda.time.LocalDate;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
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
            FileWriter file = new FileWriter(this.f);
            file.write(this.iAm.toJSONString());
            file.flush();
            file.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getCFcontents() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        try {
            Object jsonChloe = parser.parse(new FileReader(f));
            JSONObject objectChloe = (JSONObject) jsonChloe;

            this.ipAddress = (String) objectChloe.get("ip_address");
            this.macAddress = (String) objectChloe.get("mac_address");
            this.id = (String) objectChloe.get("owner_id");
            this.dateWeMet = (LocalDate) new LocalDate(objectChloe.get("date_we_met"));
            this.time_zone = (String) objectChloe.get("timezone");
            this.chloeId = (String) objectChloe.get("chloe_id");

        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
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

    public LocalDate getDateWeMet() {
        return dateWeMet;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public String getId() {
        return id;
    }

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

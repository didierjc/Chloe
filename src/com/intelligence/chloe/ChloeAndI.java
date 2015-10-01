package com.intelligence.chloe;

/**
 * @author Didier Leonard-Jean Charles
 * @version Chlöe 1.0.0
 *
 */

import java.io.FileNotFoundException;
import java.net.*;
import org.joda.time.LocalDate;

import java.util.*;

public class ChloeAndI {

    private String ipAddress = null;
    private String macAddress = null;
    private NetworkInterface network = null;
    private String id = null;
    private String time_zone = null;
    private LocalDate dateWeMet = null;
    private ChloeFile file = new ChloeFile();

    public boolean firstTime = true;

    public ChloeAndI() {
        if(checkIfFirstTime()){
            try {
                setNetworkElements();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (SocketException e) {
                e.printStackTrace();
            }

            // set new owner info
            GenerateId newId = new GenerateId();
            this.id = newId.getId();
            Calendar calendar = new GregorianCalendar();
            TimeZone timeZone = calendar.getTimeZone();
            time_zone = timeZone.getID();

        }else{
            // get owner info
            this.ipAddress = file.getIpAddress();
            this.macAddress = file.getMacAddress();
            this.id = file.getId();
            this.time_zone = file.getTime_zone();
            this.dateWeMet = file.getDateWeMet();
        }
    }

    private void setNetworkElements() throws UnknownHostException, SocketException {
        try{
            ipAddress = InetAddress.getLocalHost().toString();
            network = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }

            macAddress = sb.toString();
            writeElements();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private boolean checkIfFirstTime(){
        boolean bool = false; // by default this IS that first time we've met; the owner file DOES NOT exist

        // if the file exists
        if(file.checkIfFileExist()) {
            bool = true; // yes the file already exists
            this.firstTime = false; // not the first time
            return false; // not the first time
        }else{
            this.firstTime = true; // yep! it's the first time
            return true; // yep! it's the first time
        }
    }

    private void writeElements() {
        Map<String,String> mapElements = new HashMap<String,String>();
        mapElements.put("ip_address", this.ipAddress);
        mapElements.put("mac_address", this.macAddress);
        mapElements.put("owner_id", this.id);
        mapElements.put("date_we_met", this.dateWeMet.toString());
        mapElements.put("timezone", this.time_zone);

        file.writeCF(mapElements);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public NetworkInterface getNetwork() {
        return network;
    }

    public String getId() {
        return id;
    }

    public String getTimeZone() {
        return time_zone;
    }

    public LocalDate getDateWeMet() {
        return dateWeMet;
    }
}

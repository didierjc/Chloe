package com.intelligence.chloe;

/**
 * @author Didier Leonard-Jean Charles
 * @version Chlöe 1.0.0
 *
 */

import java.io.*;
import java.net.*;
import org.joda.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ChloeAndI {

    private File f = new File("/_chloe/abt/_chloeandi.chloe");
    private String ipAddress = null;
    private String macAddress = null;
    private NetworkInterface network = null;
    private String id = null;
    private String time_zone = null;
    private LocalDate dateWeMet = null;

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

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private boolean checkIfFirstTime(){
        boolean bool = false; // by default this IS that first time we've met; there owner file DOES NOT exist

        // if the file exists
        if(f.exists()) {
            bool = true;
            this.firstTime = false;
            return false;
        }else{
            this.firstTime = true;
        }

        return true;
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

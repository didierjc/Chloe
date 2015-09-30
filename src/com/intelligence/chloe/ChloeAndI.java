package com.intelligence.chloe;

/**
 * @author Didier Leonard-Jean Charles
 * @version Chlöe 1.0.0
 *
 */

import java.io.FileNotFoundException;
import java.net.*;
import org.joda.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ChloeAndI {

    private String ipAddress = null;
    private String macAddress = null;
    private NetworkInterface network = null;
    private String id = null;
    private String time_zone = null;
    private LocalDate dateWeMet = null;
    private ChloeFile f = new ChloeFile();

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
            this.ipAddress = f.getIpAddress();
            this.macAddress = f.getMacAddress();
            this.id = f.getId();
            this.time_zone = f.getTime_zone();
            this.dateWeMet = f.getDateWeMet();
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
        if(f.checkIfFileExist()) {
            bool = true; // yes the file already exists
            this.firstTime = false; // not the first time
            return false; // not the first time
        }else{
            this.firstTime = true; // yep! it's the first time
            return true; // yep! it's the first time
        }
    }

    private void writeElements() {
        String[] arrElements = new String[5];
        arrElements[0] = this.ipAddress;
        arrElements[1] = this.macAddress;
        arrElements[2] = this.id;
        arrElements[3] = this.dateWeMet.toString();
        arrElements[4] = this.time_zone;

        f.writeCF(arrElements);
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

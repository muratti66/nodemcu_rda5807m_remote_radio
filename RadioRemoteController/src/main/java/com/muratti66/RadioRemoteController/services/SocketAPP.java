package com.muratti66.RadioRemoteController.services;

import com.muratti66.RadioRemoteController.enc.ConfigClass;
import com.muratti66.RadioRemoteController.enc.DefineClass;
import com.muratti66.RadioRemoteController.enc.msg.OutputMsgs;
import java.io.*;
import javax.annotation.PostConstruct;
import org.apache.commons.net.telnet.TelnetClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SocketAPP {

    private OutputStream out;
    private InputStream in;
    private TelnetClient client;
    

    @PostConstruct
    public void init() throws InterruptedException, IOException, ClassNotFoundException {
        System.out.println(OutputMsgs.FIRST_INIT.toString());
        this.client = new TelnetClient();
        this.tryToConnect(false);
    }
    
    public void tryToConnect(boolean retry) {
        if (retry) {
            this.client = new TelnetClient();
        }
        System.out.println(OutputMsgs.CONN_TRY.toString());
        try {
            this.client.setDefaultTimeout(ConfigClass.CLIENT_DEF_TIMEOUT);
            this.client.setConnectTimeout(ConfigClass.CLIENT_TIMEOUT);
            this.client.connect(ConfigClass.HOST, ConfigClass.PORT);
            this.client.setSoTimeout(ConfigClass.CLIENT_SO_TIMEOUT);
            this.client.setSoLinger(true, 1);
            this.client.setKeepAlive(true);
            this.in = this.client.getInputStream();
            this.out = this.client.getOutputStream();
            System.out.println(OutputMsgs.CONN_SUCC.toString());
        } catch (IOException | IllegalArgumentException  e) {
            System.err.print("TTC : ");
            System.err.println(e);
            e.printStackTrace();
        }        
    }
    
    public boolean isOnline() {
        try {
            return this.client.isAvailable() && 
                    this.client.isConnected();
        } catch (Exception e) {
            System.err.print("IS ONLINE : ");
            System.err.println(e);
            e.printStackTrace();
            System.out.println(OutputMsgs.DISCONN.toString());
            return false;
        }
    }
    
    public String sendDataReadResponse(String data) throws IOException {
        try {
            this.out.write(data.getBytes());
            this.out.flush();
            this.out.write(DefineClass.NL.getBytes());
            this.out.flush();
        } catch (IOException ex) {
            throw ex;
        }
        byte[] receivedDataBuffer = new byte[1024];
        int receivedDataLength = this.client.getInputStream().read(receivedDataBuffer);
        String out = new String(receivedDataBuffer, 0, receivedDataLength).strip();
        if (out.isBlank()) {
            return this.sendDataReadResponse(data);
        }
        return out;
    }
    
    public void sendData(String data) {
        if (this.out == null) {
            System.out.println(OutputMsgs.ONL_ERR.toString());
        }
        try {
            this.out.write(data.getBytes());
            this.out.flush();
            this.out.write(DefineClass.NL.getBytes());
            this.out.flush();
        } catch (IOException e) {
            System.err.print("Send Data : ");
            System.err.println(e);
            e.printStackTrace();
        }
    }

}


package com.muratti66.RadioRemoteController.services;

import com.muratti66.RadioRemoteController.enc.msg.StatusMsgs;
import java.awt.Color;
import javax.swing.JTextField;

public class StatusUpdater implements Runnable {
    
    private final SocketAPP socketBean;
    private final JTextField jtfStatus;
    
    public StatusUpdater(JTextField jTextFieldStatus, SocketAPP socketBean) {
        this.socketBean = socketBean;
        this.jtfStatus = jTextFieldStatus;
    }
    
    @Override
    public void run(){ 
        while (true) {
            if (this.socketBean == null) {
                continue;
            }
            if (this.socketBean.isOnline()) {
                this.jtfStatus.setBackground(Color.green);
                this.jtfStatus.setForeground(Color.white);
                this.jtfStatus.setText(StatusMsgs.CONNECTED.toString());
                this.jtfStatus.setFont(new java.awt.Font("Andale Mono", 1, 14));
            } else {
                this.jtfStatus.setBackground(Color.red);
                this.jtfStatus.setForeground(Color.white);
                this.jtfStatus.setText(StatusMsgs.DISCONNECTED.toString());
                this.jtfStatus.setFont(new java.awt.Font("Andale Mono", 1, 12));
                this.socketBean.tryToConnect(true);
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                ;;
            }
        }
    }  
}

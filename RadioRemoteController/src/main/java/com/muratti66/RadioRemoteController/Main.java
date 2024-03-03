package com.muratti66.RadioRemoteController;

import com.muratti66.RadioRemoteController.enc.msg.OutputMsgs;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.muratti66.RadioRemoteController")
public class Main {

    public static void main(String[] args) {
        System.out.println(OutputMsgs.APP_STARTING.toString());
        RadioJFrame rFrame = new RadioJFrame();
        RadioMemoryJFrame memFrame = new RadioMemoryJFrame(rFrame);
        
        rFrame.toFront();
        rFrame.transferFocus();
        
        rFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                Point locationA = rFrame.getLocation();
                memFrame.setLocation(locationA.x + 490, locationA.y);
            }
        });
        
    }
}
package com.muratti66.RadioRemoteController;

import com.muratti66.RadioRemoteController.enc.msg.StatusMsgs;
import com.muratti66.RadioRemoteController.services.StatusUpdater;
import com.muratti66.RadioRemoteController.services.SocketAPP;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JSlider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RadioJFrame extends javax.swing.JFrame {

    private static SocketAPP socketBean;

    
    /**
     * Creates new form TVJFrame
     */
    public RadioJFrame() {  
        this.setVisible(true);
        initComponents();
        
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        socketBean = ctx.getBean(SocketAPP.class);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ;;
        }
        try {
            int frequance = Integer.parseInt(socketBean.sendDataReadResponse("GETFREQ")) / 10;
            Thread.sleep(500);
            int volume = Integer.parseInt(socketBean.sendDataReadResponse("GETVOL"));
            if (volume == 0) {
                volume = 1;
            }
            int n_freq = frequance;
            if (frequance >= 1080) {
                n_freq = 1080;
            } else if (frequance <= 875) {
                n_freq = 875;
            }
            String numberString = String.valueOf(frequance);
            String firstPart = numberString.substring(0, numberString.length() - 1);
            String lastDigit = numberString.substring(numberString.length() - 1);
            this.jFreqTextField1.setText(firstPart);
            this.jFreqTextField2.setText(lastDigit);
            this.jFreqSlider.setValue(n_freq);
            this.jVolSlider.setValue(volume);
        } catch (IOException | InterruptedException ex) {
            System.err.print("Frame : ");
            System.err.println(ex);
            ex.printStackTrace();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ;;
        }
        new Thread(new StatusUpdater(jTextFieldStatus, socketBean)).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldStatus = new javax.swing.JTextField();
        jVolSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jFreqSlider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jFreqTextField1 = new javax.swing.JTextField();
        jFreqTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        restartButton = new javax.swing.JButton();
        jAFCCheckBox = new javax.swing.JCheckBox();
        muteButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wifi Radyo Ekranı");
        setLocation(new java.awt.Point(40, 70));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jTextFieldStatus.setEditable(false);
        jTextFieldStatus.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldStatus.setFont(new java.awt.Font("Andale Mono", 1, 12)); // NOI18N
        jTextFieldStatus.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldStatus.setText(StatusMsgs.CONNECTING.toString());
        jTextFieldStatus.setToolTipText("Bağlantı Durumu");
        jTextFieldStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextFieldStatus.setDisabledTextColor(new java.awt.Color(242, 242, 242));
        jTextFieldStatus.setEnabled(false);
        jTextFieldStatus.setMinimumSize(new java.awt.Dimension(118, 37));
        jTextFieldStatus.setPreferredSize(new java.awt.Dimension(127, 37));
        jTextFieldStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStatusActionPerformed(evt);
            }
        });
        jTextFieldStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldStatusKeyPressed(evt);
            }
        });

        jVolSlider.setMajorTickSpacing(1);
        jVolSlider.setMaximum(10);
        jVolSlider.setMinimum(1);
        jVolSlider.setMinorTickSpacing(1);
        jVolSlider.setPaintLabels(true);
        jVolSlider.setPaintTicks(true);
        jVolSlider.setSnapToTicks(true);
        jVolSlider.setToolTipText("Ses 1 - 10");
        jVolSlider.setValue(1);
        jVolSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jVolSliderStateChanged(evt);
            }
        });
        jVolSlider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jVolSliderKeyPressed(evt);
            }
        });

        jLabel1.setText("Ses Seviyesi");

        jFreqSlider.setMajorTickSpacing(206);
        jFreqSlider.setMaximum(1080);
        jFreqSlider.setMinimum(875);
        jFreqSlider.setMinorTickSpacing(1);
        jFreqSlider.setPaintTicks(true);
        jFreqSlider.setToolTipText("Frekanslar 87.5 - 108.0");
        jFreqSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jFreqSliderStateChanged(evt);
            }
        });
        jFreqSlider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFreqSliderKeyPressed(evt);
            }
        });

        jLabel2.setText(".");
        jLabel2.setPreferredSize(new java.awt.Dimension(1, 10));
        jLabel2.setSize(new java.awt.Dimension(42, 12));

        jFreqTextField1.setEditable(false);
        jFreqTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFreqTextField1.setText("87");
        jFreqTextField1.setBorder(null);
        jFreqTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFreqTextField1ActionPerformed(evt);
            }
        });
        jFreqTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFreqTextField1KeyPressed(evt);
            }
        });

        jFreqTextField2.setEditable(false);
        jFreqTextField2.setText("5");
        jFreqTextField2.setBorder(null);
        jFreqTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFreqTextField2ActionPerformed(evt);
            }
        });
        jFreqTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFreqTextField1KeyPressed(evt);
            }
        });

        jLabel3.setText(" FM Frekans:");

        restartButton.setBackground(new java.awt.Color(242, 242, 242));
        restartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reboot.png"))); // NOI18N
        restartButton.setToolTipText("Donanım Reset..");
        restartButton.setBorder(null);
        restartButton.setBorderPainted(false);
        restartButton.setMaximumSize(new java.awt.Dimension(118, 37));
        restartButton.setMinimumSize(new java.awt.Dimension(118, 37));
        restartButton.setPreferredSize(new java.awt.Dimension(127, 37));
        restartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restartButtonMouseClicked(evt);
            }
        });
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });
        restartButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                restartButtonKeyPressed(evt);
            }
        });

        jAFCCheckBox.setSelected(true);
        jAFCCheckBox.setText("AFC Enabled");
        jAFCCheckBox.setToolTipText("Otomatik Frekans Kontrolü, çekişi iyileştirmek için frekansda küçük değişiklikler yapar.");
        jAFCCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jAFCCheckBoxİtemStateChanged(evt);
            }
        });
        jAFCCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAFCCheckBoxActionPerformed(evt);
            }
        });
        jAFCCheckBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRDSFifoCheckBoxKeyPressed(evt);
            }
        });

        muteButton.setBackground(new java.awt.Color(242, 242, 242));
        muteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mute.png"))); // NOI18N
        muteButton.setToolTipText("Sessize Al");
        muteButton.setBorder(null);
        muteButton.setBorderPainted(false);
        muteButton.setMaximumSize(new java.awt.Dimension(118, 37));
        muteButton.setMinimumSize(new java.awt.Dimension(118, 37));
        muteButton.setPreferredSize(new java.awt.Dimension(127, 37));
        muteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muteButtonMouseClicked(evt);
            }
        });
        muteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muteButtonActionPerformed(evt);
            }
        });
        muteButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                muteButtonKeyPressed(evt);
            }
        });

        jLabel4.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jFreqSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(341, 341, 341)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFreqTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFreqTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jAFCCheckBox)))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jVolSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(muteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAFCCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jFreqTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFreqTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(muteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jVolSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addComponent(jFreqSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        this.globalKeyChecker(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowDeactivated

    private void jFreqTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFreqTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFreqTextField1ActionPerformed

    private void jFreqTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFreqTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFreqTextField2ActionPerformed

    private void jFreqSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jFreqSliderStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        this.setFrequance(source.getValue());
    }//GEN-LAST:event_jFreqSliderStateChanged

    private void restartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restartButtonMouseClicked
        if (socketBean.isOnline()) {
            socketBean.sendData("restart");
        }
    }//GEN-LAST:event_restartButtonMouseClicked

    private void jAFCCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAFCCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAFCCheckBoxActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_restartButtonActionPerformed

    private void muteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muteButtonMouseClicked
        if (socketBean.isOnline()) {
            this.setVolume(0);
        }
    }//GEN-LAST:event_muteButtonMouseClicked

    private void muteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_muteButtonActionPerformed

    private void jVolSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jVolSliderStateChanged
        JSlider source = (JSlider) evt.getSource();
        this.setVolume(source.getValue());
    }//GEN-LAST:event_jVolSliderStateChanged

    private void jFreqSliderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFreqSliderKeyPressed
        // TODO add your handling code here:
        this.globalKeyChecker(evt);
    }//GEN-LAST:event_jFreqSliderKeyPressed

    private void jVolSliderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jVolSliderKeyPressed
        this.globalKeyChecker(evt);
    }//GEN-LAST:event_jVolSliderKeyPressed

    private void restartButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_restartButtonKeyPressed
        this.globalKeyChecker(evt);
    }//GEN-LAST:event_restartButtonKeyPressed

    private void muteButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_muteButtonKeyPressed
        this.globalKeyChecker(evt);
    }//GEN-LAST:event_muteButtonKeyPressed

    private void jRDSFifoCheckBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRDSFifoCheckBoxKeyPressed
        this.globalKeyChecker(evt);
    }//GEN-LAST:event_jRDSFifoCheckBoxKeyPressed

    private void jTextFieldStatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldStatusKeyPressed
        this.globalKeyChecker(evt);
    }//GEN-LAST:event_jTextFieldStatusKeyPressed

    private void jFreqTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFreqTextField1KeyPressed
        this.globalKeyChecker(evt);
    }//GEN-LAST:event_jFreqTextField1KeyPressed

    private void jAFCCheckBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jAFCCheckBoxİtemStateChanged
        if (socketBean.isOnline()) {
            String sel = "0";
            if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                sel = "1";
            }
            socketBean.sendData("AFCSET" + sel);
        }
    }//GEN-LAST:event_jAFCCheckBoxİtemStateChanged

    private void jTextFieldStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStatusActionPerformed
    
    private void setVolume(int volume) {
        if (socketBean.isOnline()) {
            socketBean.sendData("VOL" + String.valueOf(volume));
        }
    }
    
    public void setFrequance(int frequance) {
        if (socketBean.isOnline()) {
            int n_freq = frequance;
            if (frequance >= 1080) {
                n_freq = 1080;
            } else if (frequance <= 875) {
                n_freq = 875;
            }
            String numberString = String.valueOf(frequance);
            String firstPart = numberString.substring(0, numberString.length() - 1);
            String lastDigit = numberString.substring(numberString.length() - 1);
            this.jFreqTextField1.setText(firstPart);
            this.jFreqTextField2.setText(lastDigit);
            this.jFreqSlider.setValue(n_freq);
            socketBean.sendData("FREQ" + String.valueOf(n_freq) + "0");
        }
    }
    
    public String getFrequance1() {
        return this.jFreqTextField1.getText();
    }
    
    public String getFrequance2() {
        return this.jFreqTextField2.getText();
    }
    
    private void globalKeyChecker(java.awt.event.KeyEvent evt) {
        if ((evt.getKeyCode() == KeyEvent.VK_UP) && ((evt.getModifiersEx()& KeyEvent.ALT_DOWN_MASK) != 0)) {
                int current = this.jVolSlider.getValue();
                if ((10 > current) && (current > 0)) {
                    current += 1;
                    this.setVolume(current);
                    this.jVolSlider.setValue(current);
                }
            } else if ((evt.getKeyCode() == KeyEvent.VK_DOWN) && ((evt.getModifiersEx()& KeyEvent.ALT_DOWN_MASK) != 0)) {
                int current = this.jVolSlider.getValue();
                if ((10 > current) && (current > 0)) {
                    current -= 1;
                    this.setVolume(current);
                    this.jVolSlider.setValue(current);
                }
            } else if ((evt.getKeyCode() == KeyEvent.VK_RIGHT) && ((evt.getModifiersEx()& KeyEvent.ALT_DOWN_MASK) != 0)) {
                int current = this.jFreqSlider.getValue();
                if (1079 >= current) {
                    current += 1;
                    this.setFrequance(current);
                    this.jFreqSlider.setValue(current);
                }
            } else if ((evt.getKeyCode() == KeyEvent.VK_LEFT) && ((evt.getModifiersEx()& KeyEvent.ALT_DOWN_MASK) != 0)) {
                int current = this.jFreqSlider.getValue();
                if (current >= 786) {
                    current -= 1;
                    this.setFrequance(current);
                    this.jFreqSlider.setValue(current);
                }
            }
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_M -> this.setVolume(0);
            }
        }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RadioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RadioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RadioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RadioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RadioJFrame();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jAFCCheckBox;
    private javax.swing.JSlider jFreqSlider;
    private javax.swing.JTextField jFreqTextField1;
    private javax.swing.JTextField jFreqTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JSlider jVolSlider;
    private javax.swing.JButton muteButton;
    private javax.swing.JButton restartButton;
    // End of variables declaration//GEN-END:variables
}
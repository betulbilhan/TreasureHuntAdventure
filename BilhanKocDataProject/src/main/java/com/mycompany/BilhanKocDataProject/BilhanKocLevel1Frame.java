/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dataprojedeneme;

import static com.mycompany.dataprojedeneme.BilhanKocFunctions1.functions;
import static com.mycompany.dataprojedeneme.BilhanKocFunctions1.scoreRecord;

import static com.mycompany.dataprojedeneme.BilhanKocStartFrame.sayi;
import static com.mycompany.dataprojedeneme.BilhanKocStartFrame.userName;

import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import org.w3c.dom.Node;
import static com.mycompany.dataprojedeneme.BilhanKocFunctions1.totalScore;
import javax.swing.JOptionPane;

/**
 *
 * @author beyzakoc
 */
public class BilhanKocLevel1Frame extends javax.swing.JFrame {

    static int die;
    static int step = 0;

  boolean isScoreSaved = false;

//------------------------------------------------------------------------------
    //karakteri hareket ettirir
    public int move() {

        Point currentLocation = charPanel.getLocation();
        int x = currentLocation.x;
        int y = currentLocation.y;

        // saveScore sadece step 30'a ulaştığında ya da geçtiğinde bir kez çalışacak şekilde kontrol ekle
        if (!isScoreSaved) {

            for (int i = 0; i < die; i++) {
                if (step >= 31) {
                    break; // 31'u geçmesin
                }
                if (step >= 0 && step <= 8) {
                    x += 70;
                } else if (step >= 9 && step <= 14) {
                    y += 70;
                } else if (step >= 15 && step <= 23) {
                    x -= 70;
                } else if (step >= 24 && step <= 26) {
                    y -= 70;
                } else if (step >= 27 && step <= 30) {
                    x += 70;
                }

                step++;
                if (step <= 31) {
                    stepShow.setText(String.valueOf(step));
                }
            }

// Spot 30’a ulaştıysak, puan bir kere eklenmeli
            if (step == 31 && !isScoreSaved) {
                totalScore += BilhanKocFunctions1.current.spot_point;
                scoreShow.setText(String.valueOf(totalScore));
                //saveScore(startFrame.userName);
                isScoreSaved = true;
            }

            charPanel.setLocation(x, y);
            return step;
        }

        return -1;

    }

//------------------------------------------------------------------------------
    public int dice() {
        shark_lbl.setVisible(false);
        gold_lbl.setVisible(false);
        empty_lbl.setVisible(false);
        Random random = new Random();
        die = random.nextInt(6) + 1;

        switch (die) {
            case 1:
                bir.setVisible(true);
                break;
            case 2:
                ikii.setVisible(true);
                break;
            case 3:
                uc.setVisible(true);
                break;
            case 4:
                dort.setVisible(true);
                break;
            case 5:
                bes.setVisible(true);
                break;
            case 6:
                altı.setVisible(true);
                break;
        }
        return die;
    }
//------------------------------------------------------------------------------

    static void saveScore(String username) {
        try {
            if (step == 31) {
                FileWriter writer = new FileWriter("output.txt", true);
                writer.write(BilhanKocStartFrame.userName + ", level1, " + BilhanKocFunctions1.totalScore + "\n");
                writer.close();
                System.out.println("Score saved to file.");

            }
        } catch (IOException e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }
//------------------------------------------------------------------------------
  
//---------------------------
    public BilhanKocLevel1Frame() {

        initComponents();
        BilhanKocFunctions1.functions();
      
        bir.setVisible(false);
        ikii.setVisible(false);
        uc.setVisible(false);
        dort.setVisible(false);
        bes.setVisible(false);
        altı.setVisible(false);
        shark_lbl.setVisible(false);
        gold_lbl.setVisible(false);
        empty_lbl.setVisible(false);

        piriReis.setVisible(false);
        captainLaz.setVisible(false);
        seyyideHurra.setVisible(false);
        vahsiKelebek.setVisible(false);

        switch (sayi) {
            case 1:
                piriReis.setVisible(true);
                break;
            case 2:
                captainLaz.setVisible(true);
                break;
            case 3:
                seyyideHurra.setVisible(true);
                break;
            case 4:
                vahsiKelebek.setVisible(true);
                break;
            default:
                break;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shark_lbl = new javax.swing.JLabel();
        scoreShow = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        uc = new javax.swing.JLabel();
        bir = new javax.swing.JLabel();
        dort = new javax.swing.JLabel();
        bes = new javax.swing.JLabel();
        altı = new javax.swing.JLabel();
        ikii = new javax.swing.JLabel();
        stepShow = new javax.swing.JLabel();
        gold_lbl = new javax.swing.JLabel();
        empty_lbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        charPanel = new javax.swing.JPanel();
        captainLaz = new javax.swing.JLabel();
        piriReis = new javax.swing.JLabel();
        vahsiKelebek = new javax.swing.JLabel();
        seyyideHurra = new javax.swing.JLabel();
        iki = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shark_lbl.setFont(new java.awt.Font("Luminari", 0, 20)); // NOI18N
        shark_lbl.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/shark.png")); // NOI18N
        shark_lbl.setText("  Shark -5");
        getContentPane().add(shark_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 290, 220));

        scoreShow.setFont(new java.awt.Font("Luminari", 3, 48)); // NOI18N
        getContentPane().add(scoreShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 100, 70));

        jButton1.setBackground(new java.awt.Color(155, 101, 62));
        jButton1.setFont(new java.awt.Font("Luminari", 3, 18)); // NOI18N
        jButton1.setText("Throw the dice");
        jButton1.setPressedIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/lazo.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, -1, 50));

        uc.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/üç.jpg")); // NOI18N
        getContentPane().add(uc, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, -1, -1));

        bir.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/bir.jpg")); // NOI18N
        getContentPane().add(bir, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, -1, -1));

        dort.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/dört.jpg")); // NOI18N
        getContentPane().add(dort, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, -1, -1));

        bes.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/beş.jpg")); // NOI18N
        getContentPane().add(bes, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, -1, -1));

        altı.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/altı.jpg")); // NOI18N
        getContentPane().add(altı, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, -1, -1));

        ikii.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/iki.jpg")); // NOI18N
        getContentPane().add(ikii, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, 120, 120));

        stepShow.setFont(new java.awt.Font("Luminari", 3, 48)); // NOI18N
        getContentPane().add(stepShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 110, 80));

        gold_lbl.setFont(new java.awt.Font("Luminari", 3, 20)); // NOI18N
        gold_lbl.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/gıold.png")); // NOI18N
        gold_lbl.setText("    Gold +10");
        getContentPane().add(gold_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 280, 230));

        empty_lbl.setFont(new java.awt.Font("Luminari", 0, 20)); // NOI18N
        empty_lbl.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/empty.png")); // NOI18N
        empty_lbl.setText("    Empty 0");
        getContentPane().add(empty_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 280, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/skor.jpeg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 320, -1));

        jPanel1.setBackground(new java.awt.Color(4, 79, 154));
        jPanel1.setLayout(null);

        charPanel.setOpaque(false);
        charPanel.setLayout(null);

        captainLaz.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/lazo.png")); // NOI18N
        charPanel.add(captainLaz);
        captainLaz.setBounds(20, 20, 28, 74);

        piriReis.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/pirio.png")); // NOI18N
        charPanel.add(piriReis);
        piriReis.setBounds(20, 20, 28, 71);

        vahsiKelebek.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/selimo.png")); // NOI18N
        charPanel.add(vahsiKelebek);
        vahsiKelebek.setBounds(20, 30, 28, 66);

        seyyideHurra.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/seyyideo.png")); // NOI18N
        charPanel.add(seyyideHurra);
        seyyideHurra.setBounds(20, 10, 30, 90);

        iki.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/iki.jpg")); // NOI18N
        charPanel.add(iki);
        iki.setBounds(900, 420, 118, 118);

        jPanel1.add(charPanel);
        charPanel.setBounds(0, 0, 50, 110);
        jPanel1.setOpaque(false);

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/l1back.jpg")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 720, 548);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        bir.setVisible(false);
        ikii.setVisible(false);
        uc.setVisible(false);
        dort.setVisible(false);
        bes.setVisible(false);
        altı.setVisible(false);

        if (!isScoreSaved) {

            if (BilhanKocFunctions1.current.spot_num <= 31) {
                die = dice();

                step = move();

                if (step != 31) {
                    totalScore = scoreRecord(die);
                    scoreShow.setText(String.valueOf(totalScore));
                } else if (step >= 31) {
                    System.out.println("kanka geldik. 31deki data=" + BilhanKocFunctions1.current.spot_point);
                    totalScore = BilhanKocFunctions1.scoreRecordForLast();
                    isScoreSaved = true;

                    scoreShow.setText(String.valueOf(totalScore));
                    saveScore(BilhanKocStartFrame.userName);
                    jButton1.setEnabled(false);

                    int secim = JOptionPane.showConfirmDialog(this,
                            "Level 2'ye geçmek ister misiniz?",
                            "Devam Et",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (secim == JOptionPane.YES_OPTION) {
                        BilhanKocFunctions1.current=BilhanKocFunctions1.head;
                                 step=0;
                                 totalScore=0;
                        this.dispose();

// Level 1'i kapat
                        // Level 2'yi başlat
                        BilhanKocLevel2Warning level2Uyarı = new BilhanKocLevel2Warning();
                      
                        level2Uyarı.setVisible(true);

                    }
                    if (secim == JOptionPane.NO_OPTION) {
                        BilhanKocFunctions1.current=BilhanKocFunctions1.head;
                                 step=0;
                                 totalScore=0;
                                  
                        this.dispose();
                        BilhanKocMain main = new BilhanKocMain();
                        main.setVisible(true);

// Level 1'i kapat
                    }

                }

            }
        } else {
 
            //functions.current = functions.head; 
            jButton1.setEnabled(false);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BilhanKocLevel1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BilhanKocLevel1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BilhanKocLevel1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BilhanKocLevel1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BilhanKocLevel1Frame().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altı;
    private javax.swing.JLabel bes;
    private javax.swing.JLabel bir;
    private javax.swing.JLabel captainLaz;
    private javax.swing.JPanel charPanel;
    private javax.swing.JLabel dort;
    public static javax.swing.JLabel empty_lbl;
    public static javax.swing.JLabel gold_lbl;
    private javax.swing.JLabel iki;
    private javax.swing.JLabel ikii;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel piriReis;
    private javax.swing.JLabel scoreShow;
    private javax.swing.JLabel seyyideHurra;
    public static javax.swing.JLabel shark_lbl;
    public static javax.swing.JLabel stepShow;
    private javax.swing.JLabel uc;
    private javax.swing.JLabel vahsiKelebek;
    // End of variables declaration//GEN-END:variables
}

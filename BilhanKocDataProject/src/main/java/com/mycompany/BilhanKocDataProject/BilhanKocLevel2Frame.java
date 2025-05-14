/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dataprojedeneme;

import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author beyzakoc
 */
public class BilhanKocLevel2Frame extends javax.swing.JFrame {

    static int die;
    static int step = 0;
    boolean isScoreSaved = false; //statici de sildim
    static int currStep = 0;

//------------------------------------------------------------------------------
    //karakteri hareket ettirir
    public int move() {
        Point currentLocation = charPanel.getLocation();
        int x = currentLocation.x;
        int y = currentLocation.y;
        //4
        for (int i = 0; i < die; i++) {
            if (step >= 31) {
                break;
            }

            // NORMAL HAREKET
            if (step >= 0 && step <= 9) {
                x += 65;
            } else if (step >= 10 && step <= 13) {
                y += 65;
            } else if (step >= 14 && step <= 22) {
                x -= 65;
            } else if (step >= 23 && step <= 24) {
                y += 65;
            } else if (step >= 25 && step <= 30) {
                x += 65;
            }
            step++;
        }
// ÖZEL DURUMLARI KONTROL ET
        if (step == 2) {
            x += 65 * 8;
            step += 8;
            //burda artmamalı 
            stepShow.setText(String.valueOf(step));
        } else if (step == 5) {
            x += 65 * 2;
            step += 2;
            stepShow.setText(String.valueOf(step));
        } else if (step == 9) {
            x -= 65 * 3;
            step -= 3;
            stepShow.setText(String.valueOf(step));
        } else if (step == 15) {
            x -= 65 * 8;
            y += 65 * 2;
            step += 10;
            stepShow.setText(String.valueOf(step));
        } else if (step == 16) {
            x += 65 * 2;
            y -= 65 * 3;
            step -= 5;
            stepShow.setText(String.valueOf(step));
        } else if (step == 18) {
            x -= 65 * 4;
            step += 4;
            stepShow.setText(String.valueOf(step));
        } else if (step == 19) {
            x -= 65 * 2;
            step += 2;
            stepShow.setText(String.valueOf(step));
        } else if (step == 26) {
            x += 65;
            step++;
            stepShow.setText(String.valueOf(step));
        } else if (step == 30) {
            x -= 65 * 5;
            y -= 65 * 2;
            step -= 7;
            stepShow.setText(String.valueOf(step));
        }
        if (step < 30) {
            stepShow.setText(String.valueOf(step));
        }

        // PUAN KONTROLÜ
        if (step >= 30 && !isScoreSaved) {
            BilhanKocFunctions2.totalScore += BilhanKocFunctions2.current.spot_point;
            System.out.print("move icindeki current spot num="+BilhanKocFunctions2.current.spot_num);
            scoreShow.setText(String.valueOf(BilhanKocFunctions2.totalScore));
            isScoreSaved = true;
        }

        charPanel.setLocation(x, y);
        currStep = step;
        return step;
    }

    public int moveForward(int num) {
        Point currentLocation = charPanel.getLocation();
        int x = currentLocation.x;
        int y = currentLocation.y;

        for (int i = 0; i < num; i++) {
            if (step >= 0 && step <= 9) {

                x += 65;
            } else if (step >= 10 && step <= 13) {
                // Sağ kenar: aşağı
                y += 65;
            } else if (step >= 14 && step <= 22) {
                // Alt sıra: sola
                x -= 65;
            } else if (step >= 23 && step <= 24) {
                // Sağ kenar: aşağı
                y += 65;

            } else if (step >= 25 && step <= 30) {
                // Üst sıra devam: sağa
                x += 65;
            }

            step++;

        }
        charPanel.setLocation(x, y);
        return step;

    }

//------------------------------------------------------------------------------
    public int dice() {
// shark_lbl.setVisible(false);
//        gold_lbl.setVisible(false);
//        empty_lbl.setVisible(false);
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

//------------------------------------------------------------------------------
    /**
     * Creates new form level2Frame
     */
    public BilhanKocLevel2Frame() {

        initComponents();
        if(BilhanKocFunctions2.current!=null) {
             System.out.println("su an current num:"+BilhanKocFunctions2.current.spot_num);
        } 
           
        

        BilhanKocFunctions2.functions2();

        bir.setVisible(false);
        ikii.setVisible(false);
        uc.setVisible(false);
        dort.setVisible(false);
        bes.setVisible(false);
        altı.setVisible(false);
        
        
        forward.setVisible(false);
        backward.setVisible(false);
        empty.setVisible(false);
        gold.setVisible(false);
        kurukafa.setVisible(false);
      

        piriReis.setVisible(false);
        piriReis.setVisible(false);
        seyyideHurra.setVisible(false);
        vahsiKelebek.setVisible(false);
        
        switch (BilhanKocStartFrame.sayi) {
            case 1:
                piriReis.setVisible(true);
                break;
            case 2:
                piriReis.setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        charPanel = new javax.swing.JPanel();
        piriReis = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        seyyideHurra = new javax.swing.JLabel();
        vahsiKelebek = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bir = new javax.swing.JLabel();
        ikii = new javax.swing.JLabel();
        uc = new javax.swing.JLabel();
        dort = new javax.swing.JLabel();
        bes = new javax.swing.JLabel();
        altı = new javax.swing.JLabel();
        stepShow = new javax.swing.JLabel();
        scoreShow = new javax.swing.JLabel();
        gold = new javax.swing.JLabel();
        empty = new javax.swing.JLabel();
        kurukafa = new javax.swing.JLabel();
        forward = new javax.swing.JLabel();
        backward = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        charPanel.setOpaque(false);
        charPanel.setLayout(null);

        piriReis.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/lazo.png")); // NOI18N
        charPanel.add(piriReis);
        piriReis.setBounds(20, 20, 40, 80);

        jLabel4.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/pirio.png")); // NOI18N
        charPanel.add(jLabel4);
        jLabel4.setBounds(20, 30, 28, 71);

        seyyideHurra.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/seyyideo.png")); // NOI18N
        charPanel.add(seyyideHurra);
        seyyideHurra.setBounds(20, 30, 30, 70);

        vahsiKelebek.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/selimo.png")); // NOI18N
        charPanel.add(vahsiKelebek);
        vahsiKelebek.setBounds(20, 30, 28, 66);

        jPanel1.add(charPanel);
        charPanel.setBounds(-10, 20, 70, 120);
        jPanel1.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/l2back.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 40, 730, 548);

        jButton1.setBackground(new java.awt.Color(153, 102, 0));
        jButton1.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        jButton1.setText("Throw the dice");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(710, 520, 153, 50);

        bir.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/bir.jpg")); // NOI18N
        jPanel1.add(bir);
        bir.setBounds(870, 460, 118, 118);

        ikii.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/iki.jpg")); // NOI18N
        jPanel1.add(ikii);
        ikii.setBounds(870, 460, 118, 118);

        uc.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/üç.jpg")); // NOI18N
        jPanel1.add(uc);
        uc.setBounds(870, 460, 118, 118);

        dort.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/dört.jpg")); // NOI18N
        jPanel1.add(dort);
        dort.setBounds(870, 460, 118, 118);

        bes.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/beş.jpg")); // NOI18N
        jPanel1.add(bes);
        bes.setBounds(870, 460, 118, 118);

        altı.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/altı.jpg")); // NOI18N
        jPanel1.add(altı);
        altı.setBounds(870, 460, 118, 118);

        stepShow.setFont(new java.awt.Font("Luminari", 0, 24)); // NOI18N
        stepShow.setText("-");
        jPanel1.add(stepShow);
        stepShow.setBounds(900, 60, 80, 80);

        scoreShow.setText("-");
        jPanel1.add(scoreShow);
        scoreShow.setBounds(930, 150, 70, 70);

        gold.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        gold.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/gıold.png")); // NOI18N
        gold.setText("Gold +10");
        jPanel1.add(gold);
        gold.setBounds(750, 240, 270, 190);

        empty.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/empty.png")); // NOI18N
        empty.setText("Empty 0");
        jPanel1.add(empty);
        empty.setBounds(750, 220, 230, 230);

        kurukafa.setFont(new java.awt.Font("Luminari", 0, 14)); // NOI18N
        kurukafa.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/kurukafa-fotor-bg-remover-20250425153155.png")); // NOI18N
        kurukafa.setText("Damage -5");
        jPanel1.add(kurukafa);
        kurukafa.setBounds(700, 240, 310, 180);

        forward.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        forward.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/polis.png")); // NOI18N
        forward.setText("Go Forward!");
        jPanel1.add(forward);
        forward.setBounds(700, 210, 340, 220);

        backward.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        backward.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/monster.png")); // NOI18N
        backward.setText("Run Back!");
        jPanel1.add(backward);
        backward.setBounds(710, 200, 287, 280);

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/beyzakoc/data/skor.jpeg")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(700, 40, 310, 548);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1050, 590));

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
                    BilhanKocFunctions2.moveForward(die);//fonksiyon içinde total scorea otomATİK EKLER
                    scoreShow.setText(String.valueOf(BilhanKocFunctions2.totalScore));
                } else if (step >= 31) {
                    // Skor hesaplama ve gösterim
//                    functions2.scoreRecordForLast(); // Gerekirse aç

                    System.out.println("kanka geldik. 30daki data=" + BilhanKocFunctions2.current.spot_point);
                    scoreShow.setText(String.valueOf(BilhanKocFunctions2.totalScore));
                    BilhanKocFunctions2.saveScore();
                    jButton1.setEnabled(false);

                    // Sadece bilgi mesajı göster, OK'a basınca devam et
                    JOptionPane.showMessageDialog(
                            this,
                            "Ana menüye dönülüyor...",
                            "Bilgilendirme",
                            JOptionPane.INFORMATION_MESSAGE
                    );

// Mevcut pencereyi kapat
                    BilhanKocMain main = new BilhanKocMain();
                    main.setVisible(true);
//                level2Frame level2Frame = new level2Frame();  
//                level2Frame.dispose(); 
//                level2Frame.setSize(990, 560);
                    this.dispose();

                    //    functions2.current=functions2.head;
                }
            }
        } 
        else {

            jButton1.setEnabled(true);

        }
        // TODO add your handling code here:

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
            java.util.logging.Logger.getLogger(BilhanKocLevel2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BilhanKocLevel2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BilhanKocLevel2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BilhanKocLevel2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BilhanKocLevel2Frame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altı;
    public static javax.swing.JLabel backward;
    private javax.swing.JLabel bes;
    private javax.swing.JLabel bir;
    private javax.swing.JPanel charPanel;
    private javax.swing.JLabel dort;
    public static javax.swing.JLabel empty;
    public static javax.swing.JLabel forward;
    public static javax.swing.JLabel gold;
    private javax.swing.JLabel ikii;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel kurukafa;
    private javax.swing.JLabel piriReis;
    private javax.swing.JLabel scoreShow;
    private javax.swing.JLabel seyyideHurra;
    private javax.swing.JLabel stepShow;
    private javax.swing.JLabel uc;
    private javax.swing.JLabel vahsiKelebek;
    // End of variables declaration//GEN-END:variables
}

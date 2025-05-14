/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.dataprojedeneme;

/**
 *
 * @author beyzakoc
 */
public class BilhanKocDataProject {

    public static void main(String[] args) {
        // GUI işlemleri Event Dispatch Thread içinde yapılmalı
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BilhanKocMain().setVisible(true); // Main frame’i aç
            }
        });
    }
}

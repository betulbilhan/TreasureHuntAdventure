/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dataprojedeneme;

import static java.awt.image.ImageObserver.ABORT;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author beyzakoc
 */
public class BilhanKocFunctionsScore {
static ScoreNode root;//en üsteki node temsil eder

    public static boolean isTreeCreated = false;
    public static String lastSearchedName = ""; // <<< BURAYA

    static void insert(int score, String username, String level) {
        root = insertRec(root, score, username, level);
    }

    static private ScoreNode insertRec(ScoreNode root, int score, String username, String level) {
        if (root == null) {
            root = new ScoreNode(score, username, level);
            return root;
        }

        if (score < root.score) {
            root.left = insertRec(root.left, score, username, level);
        } else {
            root.right = insertRec(root.right, score, username, level);
        }

        return root;
    }
    
    

    static void inorderTraversal(ScoreNode root) {
        if (root != null) { 
    
             inorderTraversal(root.left);
        String currentText = BilhanKocScores.allScores_lb.getText();
        BilhanKocScores.allScores_lb.setText(currentText + root.score + ", (" + root.level + ") , \n");    
      
        inorderTraversal(root.right);
    
        }
        
        //optionpane
    }

    static int findMinScore(ScoreNode node) {
        while (node.left != null) {
            node = node.left;
        }
        BilhanKocScores.lowest_lb.setText(String.valueOf(node.score));
        return node.score;
    }

    static int findMaxScore(ScoreNode node) {
        while (node.right != null) {
            node = node.right;
        }
        BilhanKocScores.highest_lb.setText(String.valueOf(node.score));
        return node.score;
    }

    public static void createTree() {
String currentSearchName = BilhanKocScores.searchName.getText();

    // Eğer zaten bu kullanıcı için oluşturulduysa tekrar oluşturma
    if (isTreeCreated && lastSearchedName.equalsIgnoreCase(currentSearchName)) {
        return;
    }

    // Tree'yi sıfırla
    root = null;

    try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3 && parts[0].trim().equalsIgnoreCase(currentSearchName)) {
                String level = parts[1].trim();
                int score = Integer.parseInt(parts[2].trim());
                insert(score, currentSearchName, level);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    if (root != null) {
        System.out.println("Best score: " + findMaxScore(root));
        System.out.println("Worst score: " + findMinScore(root));
    } else {
        System.out.println("No scores found for user: " + currentSearchName);
    }

    // Kontrol değişkenlerini güncelle
    isTreeCreated = true;
    lastSearchedName = currentSearchName;
}}

class ScoreNode {

    int score;
    String username;
    String level;
    ScoreNode left, right;

    public ScoreNode(int score, String username, String level) {
        this.score = score;
        this.username = username;
        this.level = level;
        left = right = null;
    }
}

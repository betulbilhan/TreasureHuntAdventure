/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dataprojedeneme;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author beyzakoc
 */
public class BilhanKocFunctions2 {

    static doubleNode head, tail;
    static doubleNode current;
    static int totalScore = 0;
    static doubleNode lastNode;

    public static void functions2() {
        System.out.println("Level 2 constructor çağrıldı");
        BilhanKocLevel2Frame.step = BilhanKocLevel2Frame.currStep = 0;
        head = tail = current = lastNode = null;
        totalScore = 0;

        head = generate(); //31 spot oluşturur random pointlerle(treasure, empt,trap)

        current = head;
        System.out.println("su an current num:" + current.spot_num);

    }

    static void saveScore() {
        try {
            if (BilhanKocLevel2Frame.step == 31) {
                FileWriter writer = new FileWriter("output.txt", true);
                writer.write(BilhanKocStartFrame.userName + ", level2, " + totalScore + "\n");
                writer.close();
                System.out.println("Score saved to file.");
                 BilhanKocFunctions2.current = BilhanKocFunctions2.head;
BilhanKocLevel1Frame.step = 0;
     BilhanKocFunctions2.totalScore = 0;
            }
        } catch (IOException e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }

    static doubleNode generate() {
        Random random = new Random();
        int arr[] = {0, 10, -5};
        System.out.println("Yeni generate çalıştı!");
 
        doubleNode head = new doubleNode(1, arr[random.nextInt(3)]);
        System.out.print("1="+head.spot_point+", ");
        doubleNode temp = head;

        for (int i = 2; i <= 31; i++) {
            doubleNode newN = new doubleNode(i, arr[random.nextInt(3)]);
                    System.out.print((i-1)+"="+newN.spot_point+", ");

            temp.next = newN;
            newN.prev = temp;
            temp = newN;
        }
        tail = temp;
        lastNode = tail;
        head = swc(head);
        return head;
    }

    static doubleNode swc(doubleNode head) {
        doubleNode temp = head;
        while (temp != null) {
            switch (temp.spot_num) {
                case 3:
                case 6:
                case 10:
                case 16:
                case 17:
                case 19:
                case 20:
                case 27:
                case 31:
                    temp.spot_point = 1;
                    break;
                default:
                    break;
            }
            temp = temp.next;
        }
        return head;
    }

    static void moveForward(int move) {
        int num = 0;
        BilhanKocLevel2Frame.empty.setVisible(false);
        BilhanKocLevel2Frame.gold.setVisible(false);
        BilhanKocLevel2Frame.kurukafa.setVisible(false);
        BilhanKocLevel2Frame.forward.setVisible(false);
        BilhanKocLevel2Frame.backward.setVisible(false);
        

        while (current.next != null && num < move) {
            current = current.next;
            num++;
        }

        if (current.spot_point != 1) {
            totalScore += current.spot_point;
            System.out.println("Landed on spot " + (current.spot_num - 1) + " with point " + current.spot_point);

            if (BilhanKocFunctions2.current.spot_point == 10) {
                BilhanKocLevel2Frame.gold.setVisible(true);
            } else if (BilhanKocFunctions2.current.spot_point == 0) {
                BilhanKocLevel2Frame.empty.setVisible(true);
            } else if (BilhanKocFunctions2.current.spot_point == -5) {
                BilhanKocLevel2Frame.kurukafa.setVisible(true);
            }
            
          
            

        } else if (current.spot_point == 1) {//SPECIAL CASES
            System.out.println("YOU CANNOT STOP (" + (current.spot_num - 1) + ") HERE!!!");
            current = specialCaseMove(current.spot_num);
        }

    }

    static doubleNode specialCaseMove(int spot_num) {
        doubleNode temp = head;
        switch (spot_num) {
            case 3:
                temp = cantStopF(spot_num, 8);

                BilhanKocLevel2Frame.backward.setVisible(false);
                BilhanKocLevel2Frame.empty.setVisible(false);
                BilhanKocLevel2Frame.gold.setVisible(false);
                BilhanKocLevel2Frame.kurukafa.setVisible(false);
                BilhanKocLevel2Frame.forward.setVisible(true);

                break;
            case 6:
                temp = cantStopF(spot_num, 2);

                BilhanKocLevel2Frame.backward.setVisible(false);
                BilhanKocLevel2Frame.empty.setVisible(false);
                BilhanKocLevel2Frame.gold.setVisible(false);
                BilhanKocLevel2Frame.kurukafa.setVisible(false);
                BilhanKocLevel2Frame.forward.setVisible(true);

                break;
            case 10:
                temp = cantStopB(spot_num, 3);

                BilhanKocLevel2Frame.forward.setVisible(false);
                BilhanKocLevel2Frame.empty.setVisible(false);
                BilhanKocLevel2Frame.gold.setVisible(false);
                BilhanKocLevel2Frame.kurukafa.setVisible(false);
                BilhanKocLevel2Frame.backward.setVisible(true);

                break;
            case 16:
                temp = cantStopF(spot_num, 10);

                BilhanKocLevel2Frame.backward.setVisible(false);
                BilhanKocLevel2Frame.empty.setVisible(false);
                BilhanKocLevel2Frame.gold.setVisible(false);
                BilhanKocLevel2Frame.kurukafa.setVisible(false);
                BilhanKocLevel2Frame.forward.setVisible(true);

                break;
            case 17:
                temp = cantStopB(spot_num, 5);

                BilhanKocLevel2Frame.forward.setVisible(false);
                BilhanKocLevel2Frame.empty.setVisible(false);
                BilhanKocLevel2Frame.gold.setVisible(false);
                BilhanKocLevel2Frame.kurukafa.setVisible(false);
                BilhanKocLevel2Frame.backward.setVisible(true);

                break;
            case 19:
                temp = cantStopF(spot_num, 23);

                BilhanKocLevel2Frame.backward.setVisible(false);
                BilhanKocLevel2Frame.empty.setVisible(false);
                BilhanKocLevel2Frame.gold.setVisible(false);
                BilhanKocLevel2Frame.kurukafa.setVisible(false);
                BilhanKocLevel2Frame.forward.setVisible(true);

                break;
            case 20:
                temp = cantStopF(spot_num, 2);

                BilhanKocLevel2Frame.backward.setVisible(false);
                BilhanKocLevel2Frame.empty.setVisible(false);
                BilhanKocLevel2Frame.gold.setVisible(false);
                BilhanKocLevel2Frame.kurukafa.setVisible(false);
                BilhanKocLevel2Frame.forward.setVisible(true);

                break;
            case 27:
                temp = cantStopF(spot_num, 1);

                BilhanKocLevel2Frame.backward.setVisible(false);
                BilhanKocLevel2Frame.empty.setVisible(false);
                BilhanKocLevel2Frame.gold.setVisible(false);
                BilhanKocLevel2Frame.kurukafa.setVisible(false);
                BilhanKocLevel2Frame.forward.setVisible(true);

                break;
            case 31:
                temp = cantStopB(spot_num, 7);

                BilhanKocLevel2Frame.forward.setVisible(false);
                BilhanKocLevel2Frame.empty.setVisible(false);
                BilhanKocLevel2Frame.gold.setVisible(false);
                BilhanKocLevel2Frame.kurukafa.setVisible(false);
                BilhanKocLevel2Frame.backward.setVisible(true);

                break;
            default:
                break;
        }
        return temp;
    }

    /*aslında bu fonksiyon current ile de çalışır ve hata vermez ama çağrıldığı fonksiyonda parametre
    olarak tüm listeyi alıyor. Böyle de öyle de çalışır*/
    static doubleNode cantStopF(int spot_num, int f) {
        int num = 0;
        doubleNode temp = current;
        while (temp.next != null && num < f) {
            temp = temp.next;
            num++;
        }
        System.out.println("GO " + f + " STEP FORWARD!");
        return temp;
    }

    /*bu fonksiyon parametre olarak head almak zorunda. çünkü geriye giden specal caseler
    için yazılmış ve geriyle olan bağlantıyı da görmek gerekir. search ile istenen spottan 
    itibaren belirtilen sayıda geriye gitme işlemi yapılır*/
    static doubleNode cantStopB(int spot_num, int b) {
        doubleNode temp = current;
        int n = 0;
        while (temp.prev != null && n < b) {
            temp = temp.prev;
            n++;
        }
        System.out.println("GO " + b + " STEP BACK!");

        return temp;
    }
//
//    static void scoreRecordForLast() {
//
//        totalScore += current.spot_point;
//
//       
//
////        level1Frame.step = 0;
////        functions2.totalScore = 0;
//        //BEYZA BURAYA ASKER K0Y 
//
//        if (functions2.current.spot_point == 10) {
//            level2Frame.gold.setVisible(true);
//        } else if (functions2.current.spot_point == 0) {
//            level2Frame.empty.setVisible(true);
//        } else if (functions2.current.spot_point == -5) {
//            level2Frame.kurukafa.setVisible(true);
//        }
//
//    }
}

class doubleNode {

    doubleNode next, prev;
    int spot_num, spot_point;

    public doubleNode(int spot_num, int spot_point) {
        this.spot_num = spot_num;
        this.spot_point = spot_point;
        this.next = null;
        this.prev = null;
    }

}

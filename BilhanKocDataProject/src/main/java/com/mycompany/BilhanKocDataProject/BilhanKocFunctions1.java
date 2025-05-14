
 package com.mycompany.dataprojedeneme;
//import static com.mycompany.dataprojedeneme.level1Frame.score;
import java.util.Random;
 

public class BilhanKocFunctions1 {
 static Node lastNode;     
    static Node head;
    static Node current;
    static int totalScore = 0;
    
        
    public static void functions(){
      head=generate(); //31 spot oluşturur random pointlerle(treasure, empt,trap)
        current=head;
         lastNode =  current;
    while (lastNode.next != null) {
        lastNode =  lastNode.next;
    }   
    }
    static Node generate() {
       
        Random random = new Random();
        int p[] = {0, 10, -5};

        Node head = new Node(1, p[random.nextInt(3)]);
        Node temp = head;
        for (int i = 2; i <= 31; i++) {
            Node newN = new Node(i, p[random.nextInt(3)]);
            temp.next = newN;
            temp = newN;
        }
        return head;
    }
 
    //linked list spotları hareket ettirir
  static int scoreRecord(int num_dice){
         
      int num=0;
        while(current.next!=null&&num<num_dice){
            current=current.next;
            num++;
        }
        totalScore+=current.spot_point;
       
       
        System.out.println("current spot num:"+current.spot_num);
        System.out.println("num dice : "+num_dice+"    total score "+totalScore+"Landed on spot " + BilhanKocLevel1Frame.stepShow.getText() + " current point " + current.spot_point);
        System.out.println("curr:"+current.spot_num);          
        
        if (BilhanKocFunctions1.current.spot_point == 10) {
                BilhanKocLevel1Frame.gold_lbl.setVisible(true);
          } else if (BilhanKocFunctions1.current.spot_point == 0) {
                BilhanKocLevel1Frame.empty_lbl.setVisible(true);
            } else if (BilhanKocFunctions1.current.spot_point == -5) {
                BilhanKocLevel1Frame.shark_lbl.setVisible(true);
            }
           
        return totalScore;
    }
  
  
  static int scoreRecordForLast(){
          
    
        totalScore+=lastNode.spot_point;
                      
               
        
        if (BilhanKocFunctions1.current.spot_point == 10) {
                BilhanKocLevel1Frame.gold_lbl.setVisible(true);
          } else if (BilhanKocFunctions1.current.spot_point == 0) {
                BilhanKocLevel1Frame.empty_lbl.setVisible(true);
            } else if (BilhanKocFunctions1.current.spot_point == -5) {
                BilhanKocLevel1Frame.shark_lbl.setVisible(true);
            }
       
        return totalScore;
    }
}
 
class Node {

    Node next;
    int spot_num;
    int spot_point;

    public Node(int spot_num, int spot_value) {
        this.spot_num = spot_num;
        this.spot_point = spot_value;
        this.next = null;
    }

}

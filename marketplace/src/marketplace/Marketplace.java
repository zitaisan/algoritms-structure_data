/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package marketplace;

/**
 *
 * @author taisi
 */
public class Marketplace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Shop myShop = new Shop();
        double time=0;
        double NextMoment=0;
        while (time<24){
            System.out.println("====== Current" + time + " ======");
            myShop.Work(time);
            
            if (time>NextMoment){
                myShop.GenerateClients((int)(Math.random()*10+5), time);
                NextMoment = time+Math.random()*0.16;                
            }
            time=time+0.016;
        }
    
    System.out.println("Orderlist");
    Client.list.PrintOrderList();
    System.out.println("Total quantity of orders " + Client.list.orders.size());
    System.out.println("Average time = " + Client.list.AverageLength());
    
    }
    
}

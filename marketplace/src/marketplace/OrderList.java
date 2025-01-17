/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marketplace;

/**
 *
 * @author taisi
 */
import java.util.ArrayList;
public class OrderList {
    ArrayList<Order> orders;
    
    public OrderList() {
        orders = new ArrayList<Order>();
    }
    public void AddOrder (Order NewOrder){
        orders.add(NewOrder);
    }
    public void PrintOrderList(){
        for(int i=0; i<orders.size(); i++){
         orders.get(i).PrintOrder();
        }
    }
    public double AverageLength(){
        double totalTime=0;
        for(int i=0; i<orders.size(); i++)
        {
            totalTime=totalTime+orders.get(i).Length;
        }
        
        return totalTime/orders.size();
    }
}      


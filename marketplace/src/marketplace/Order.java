/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marketplace;

/**
 *
 * @author taisi
 */
public class Order {
    double StartTime;
    double FinishTime;
    Client client;
    double Length;
    public Order(Client client, double StartTime, double FinishTime){
        this.client = client;
        this.StartTime = StartTime;
        this.FinishTime = FinishTime;
        Length = this.FinishTime-this.StartTime;
    }
    public void PrintOrder(){
        System.out.println("Order of client #" + client.id + " " + StartTime + " " + FinishTime + " " + Length);
    }
}

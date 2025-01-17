package marketplace;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author taisi
 */
enum ClientState { csOrderInProcess, csWaitOrder, csFinishOrder, csCancelOrder}
public class Client {
    int id;
    String name, surname;
    ClientState state;
    double SelectTime;
    static OrderList list = new OrderList();
    public void AcceptOrder(){
        System.out.println(id + " " + name + " " + surname + " accepted order");
        double FinishTime = SelectTime + Math.random()*48 + 12;
        list.AddOrder(new Order(this, SelectTime, FinishTime));
        SelectTime = FinishTime;
        state = ClientState.csWaitOrder;
    }
    public void GetOrder(){
        System.out.println(id + " " + name + " " + surname + " got order");
        state = ClientState.csFinishOrder;
    }
    public void CancelOrder(){
        System.out.println(id + " " + name + " " + surname + " cancelled order");
        state = ClientState.csCancelOrder;
    }
    public void Activity(double CurrentTime){
        if (state == ClientState.csOrderInProcess)
        {
            if (CurrentTime>SelectTime)
            {
                if (Math.random()<0.7)
                {
                    AcceptOrder();
                    SelectTime = CurrentTime + Math.random()*48 + 12;
                }
            }
        }
    }  
    public Client(int id, String name, String surname, double CurrentTime){
        this.id = id;
        this.name=name;
        this.surname=surname;
        state=ClientState.csOrderInProcess;
        SelectTime = CurrentTime + Math.random()*5 +0.032;
        
    }
    public void PrintState()
    {
        System.out.println(id+ " " + name + " " + surname + " " + state);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marketplace;

import java.util.ArrayList;

/**
 *
 * @author taisi
 */
public class Shop {
    ArrayList<Client> clients;
    int NumberOfClients;
    
    public Shop(){
        NumberOfClients=0;
        clients = new ArrayList<Client>();
    }
    public void GenerateClients(int NumberOfNewClients, double CurrentTime){
        String randomNames[] = {"Olya", "Kilya", "Jim", "Jorge"};
        String randomSurnames[] = {"Ibragimova", "Killich", "Jimich", "Bush"};
        for (int i=NumberOfClients; i<NumberOfClients + NumberOfNewClients; i++){
            clients.add(new Client(i, randomNames[(int)(Math.random()*randomNames.length)],
                                      randomSurnames[(int)(Math.random()*randomSurnames.length)],
                                      CurrentTime));
            clients.get(i).PrintState();
        }
        NumberOfClients=NumberOfClients+NumberOfNewClients;
        
    }
    public void Work(double CurrentTime){
        
        for(int i = 0; i < NumberOfClients; i++){
            clients.get(i).Activity(CurrentTime);
        }
    }  
}

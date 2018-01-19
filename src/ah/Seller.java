package ah;

import java.util.ArrayList;


public class Seller implements Observable{
    private ArrayList<Observer> bidders;
    private String name;
    
    public Seller(String name){
        this.name = name;
        bidders = new ArrayList<Observer>();
    }
    
    public int subscribe (Observer bidder){
        bidders.add(bidder);
        return bidders.size();
    }
    
    
    public void notifyObserver(){
        for (Bidder bidder : bidders){
            
        }
    }
   
}

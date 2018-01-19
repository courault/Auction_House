package ah;

import java.util.ArrayList;


public class Seller implements Observable{
    private ArrayList<Observer> bidders;
    private ArrayList<Item> items;
    private final String name;
    private int biggestValue;
    private Bidder HighestBidder;
    
    public Seller(String name, ArrayList<Item> listItem){
        this.name = name;
        bidders = new ArrayList<Observer>();
        items = listItem;
        nextItem();
    }
    
    private void nextItem(){
        if(items.isEmpty())
            endAuction();
        
    }
    
    private void endAuction(){
        
    }
    @Override
    public int subscribe (Observer bidder){
        bidders.add(bidder);
        return bidders.size();
    }
    
    
    @Override
    public void notifyObserver(){
        for (Observer bidder : bidders){
            bidder.refresh(biggestValue);
        }
    }
   
}

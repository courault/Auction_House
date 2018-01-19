package ah;

import java.util.ArrayList;


public class Seller implements Observable{
    private ArrayList<Observer> bidders;
    private ArrayList<Item> items;
    private final String name;
    private int biggestValue;
    private Bidder HighestBidder;
    
    public Seller(String name, ArrayList<Item> listItem) throws EmptyItemListException{
        this.name = name;
        bidders = new ArrayList<>();
        items = listItem;
        if(items.isEmpty())
            throw new EmptyItemListException();
        nextItem();
    }
    
    private void nextItem(){
        items.remove(0);
        if(items.isEmpty())
            endAuction();
        else{     
            biggestValue=items.get(0).getPrice();
            HighestBidder = null;
        }
    }
    
    private void endAuction(){
        
    }
    
    //Observervable functions 
    
    @Override
    public void subscribe (Observer bidder){
        bidders.add(bidder);
    }
    
    
    @Override
    public void notifyObserver(){
        for (Observer bidder : bidders){
            bidder.refresh();
        }
    }
   
    // Getters
    public String getCurrentItem(){return items.get(0).getName();}
    public int getCurrentPrice(){return biggestValue;}
    public int getCurrentBuyer(){return HighestBidder.getID();}
}

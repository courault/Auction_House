package ah;

import java.util.ArrayList;

public class Seller implements Observable {

    private ArrayList<Observer> bidders;
    private ArrayList<Item> items;
    private final String name;
    private int biggestValue;
    private Bidder HighestBidder;

    public Seller(String name, ArrayList<Item> listItem) throws EmptyItemListException {
        this.name = name;
        bidders = new ArrayList<>();
        items = listItem;
        if (items.isEmpty()) {
            throw new EmptyItemListException();
        }
        biggestValue = items.get(0).getPrice();
        HighestBidder = null;
    }

    private void nextItem() {
        items.remove(0);
        if (items.isEmpty()) {
            biggestValue = -1;
        } else {
            biggestValue = items.get(0).getPrice();
        }
        HighestBidder = null;
        notifyObserver();
    }

    public boolean bid(Bidder bidder, int price) {
        if (price >= biggestValue + items.get(0).getMinBid()
                && bidder.bidMonney(price)) {
            if(HighestBidder!=null)
                HighestBidder.bidRefund(biggestValue);
            biggestValue = price;
            HighestBidder = bidder;
            return true;
        }
        return false;
    }

    //Observervable functions
    @Override
    public void subscribe(Observer bidder) {
        bidders.add(bidder);
        System.out.println("Room : " + this.name + "\nBidder :" + bidder.toString() + "\n");
    }

    @Override
    public void notifyObserver() {
        for (Observer bidder : bidders) {
            bidder.refresh(this);
        }
    }

    @Override
    public void unsubscribe(Observer o) {
        bidders.remove(o);
    }

    // Getters
    public Item getCurrentItem() throws EmptyItemListException {
        if (items.isEmpty()) {
            throw new EmptyItemListException();
        }
        return items.get(0);
    }

    public int getCurrentPrice() {
        return biggestValue;
    }

    public int getCurrentBuyer() {
        if(HighestBidder!=null)
            return HighestBidder.getID();
        return -1;
    }
}

package ah;

import java.util.ArrayList;

public class Seller implements Observable {

    private ArrayList<Observer> bidders;
    private ArrayList<Item> items;
    private final String name;
    private int biggestValue;
    private Bidder HighestBidder;
    private ArrayList<Offer> offers;
    private short calls = 0;

    public Seller(String name, ArrayList<Item> listItem) throws EmptyItemListException {
        this.name = name;
        bidders = new ArrayList<>();
        offers = new ArrayList<>();
        items = listItem;
        if (items.isEmpty()) {
            throw new EmptyItemListException();
        }
        biggestValue = items.get(0).getPrice();
        HighestBidder = null;
    }

    public void start(){
        notifyObserver();
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

    public void bid(Offer offer) {
        offers.add(offer);
    }

    private void getBestOffer() {
        if (!offers.isEmpty()) {
            Bidder bidder = null;
            int price = 0;
            for (Offer offer : offers) {
                if (offer.getOffer() > price) {
                    bidder = offer.getBidder();
                    price = offer.getOffer();
                }
            }
            if (price >= biggestValue + items.get(0).getMinBid()
                    && bidder.bidMonney(price)) {
                if (HighestBidder != null) {
                    HighestBidder.bidRefund(biggestValue);
                }
                biggestValue = price;
                HighestBidder = bidder;
                offers.clear();
                notifyObserver();
            }
        } 
        else if (calls < 3) {
            ++calls;
            notifyObserver();
        }
//        else
//            nextItem();

    }

    //Observervable functions
    @Override
    public void subscribe(Observer bidder) {
        bidders.add(bidder);
        System.out.println("Room : " + this.name + "\nBidder :" + bidder.toString() + "\n");
        calls=0;
    }

    @Override
    public void notifyObserver() {
        bidders.stream().forEach((bidder) -> {
            bidder.refresh(this);
        });
        getBestOffer();
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
        if (HighestBidder != null) {
            return HighestBidder.getID();
        }
        return -1;
    }
}

package ah;

import java.util.ArrayList;

public class Seller implements Observable {

    private ArrayList<Observer> bidders;
    private ArrayList<Item> items;
    private Bidder HighestBidder;
    private ArrayList<Offer> offers;
    private short calls = 0;
    private boolean newbid = true;

    public Seller(ArrayList<Item> listItem) throws EmptyItemListException {
        bidders = new ArrayList<>();
        offers = new ArrayList<>();
        items = listItem;
        if (items.isEmpty()) {
            throw new EmptyItemListException();
        }
        HighestBidder = null;
    }

    public void start() {
        notifyObserver();
    }

    private void nextItem() {
        items.remove(0);
        HighestBidder = null;
        offers.clear();
        if (!items.isEmpty()) {
            newbid = true;
        }
    }

    public void bid(Offer offer) {
        offers.add(offer);
    }

    private void getBestOffer() {
        if (!offers.isEmpty()) {
            offers.sort((f1, f2) -> Integer.compare(f2.getOffer(), f1.getOffer()));
            int price = offers.get(0).getOffer();
            Bidder bidder = offers.get(0).getBidder();
            if (price >= items.get(0).getPrice() + items.get(0).getMinBid()
                    && bidder.bidMonney(price)) {
                if (HighestBidder != null) {
                    HighestBidder.bidRefund(items.get(0).getPrice());
                }
                items.get(0).setPrice(price);
                HighestBidder = bidder;
                newbid = true;
                calls = 0;
            }

        }
        offers.clear();
    }

    //Observervable functions
    @Override
    public void subscribe(Observer bidder) {
        bidders.add(bidder);
        System.out.println("Bidder :" + bidder.toString() + "\n");
        calls = 0;
    }

    @Override
    public void notifyObserver() {
        while (newbid) {
            newbid = false;
            bidders.stream().forEach((bidder)
                    -> {
                bidder.refresh(this);
            });
            getBestOffer();
            if (!newbid) {
                if (calls < 3) {
                    ++calls;
                    newbid = true;
                } else {
                    nextItem();
                    calls = 0;
                }
            }
            System.out.println();
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

    public int getCurrentPrice() throws EmptyItemListException {
        if (items.isEmpty()) {
            throw new EmptyItemListException();
        } else {
            return items.get(0).getPrice();
        }
    }

    public int getCurrentBuyer() {
        if (HighestBidder != null) {
            return HighestBidder.getID();
        }
        return -1;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}

package ah;

import java.util.ArrayList;

public class Seller implements Observable {

    private ArrayList<Observer> bidders;
    private ArrayList<Item> items;
    private Bidder highestBidder;
    private ArrayList<Offer> offers;
    private short calls = 0;
    private int item = 0;
    private boolean newbid = true;

    public Seller(ArrayList<Item> listItem) throws EmptyItemListException {
        bidders = new ArrayList<>();
        offers = new ArrayList<>();
        items = listItem;
        if (items.isEmpty()) {
            throw new EmptyItemListException();
        }
        item = 0;
        highestBidder = null;
    }

    public void start() {
        notifyObserver();
    }

    private void nextItem() {
        items.get(item).isSold(true);
        if (highestBidder != null)
            items.get(item).setBuyer(highestBidder.getID());
        if (item < items.size() - 1) {
            this.highestBidder = null;
            calls = 0;
        } else {
            calls = 4;
        }
        newbid = true;
        ++item;
        offers.clear();
    }

    public void bid(Offer offer) {
        offers.add(offer);
    }

    private void getBestOffer() {
        if (!offers.isEmpty()) {
            offers.sort((f1, f2) -> Integer.compare(f2.getOffer(), f1.getOffer()));
            int price = offers.get(0).getOffer();
            Bidder bidder = offers.get(0).getBidder();
            if (price >= items.get(item).getPrice() + items.get(item).getMinBid()
                    && bidder.bidMonney(price)) {
                if (highestBidder != null) {
                    highestBidder.bidRefund(items.get(item).getPrice());
                }
                items.get(item).setPrice(price);
                highestBidder = bidder;
                System.out.println("The best offer comes from : "
                        + (bidder.getID())
                        + "\nHis offer was : " + (price));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {}
                newbid = true;
                calls = 0;
            }

        }
        if(item<items.size())
            items.get(item).addOffer(offers);
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
                } else if (calls == 3) {
                    nextItem();
                } else {
                    newbid = false;
                }
            }
            System.out.println();
            System.out.flush();
        }

    }

    @Override
    public void unsubscribe(Observer o) {
        bidders.remove(o);
    }

    // Getters
    public Item getCurrentItem() throws EmptyItemListException {
        if (items.isEmpty() || item >= items.size()) {
            throw new EmptyItemListException();
        }
        return items.get(item);
    }

    public int getCurrentPrice() throws EmptyItemListException {
        if (items.isEmpty() || item >= items.size()) {
            throw new EmptyItemListException();
        } else {
            return items.get(item).getPrice();
        }
    }

    public int getCurrentBuyer() {
        if (highestBidder != null) {
            return highestBidder.getID();
        }
        return -1;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}

package ah;

import java.util.ArrayList;

public class Item {

    private final String name;
    private int price;
    private final int minBid;
    private final int commonPrice;
    private boolean sold;
    private int buyer = -1;
    private ArrayList<Offer> offers;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
        commonPrice = price * 2;
        minBid = (int) (price / 10) + (int) (Math.random() * (((price / 20) - (price / 10)) + 1));
        sold = false;
        offers = new ArrayList<>();
    }

    //Getters
    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getMinBid() {
        return minBid;
    }

    public int getCommonPrice() {
        return commonPrice;
    }
    
    public ArrayList<Offer> getOffers(){
        return offers;
    }

    //Setters
    public void setPrice(int price) {
        this.price = price;
    }

    public void setBuyer(int bidderID) {
        buyer = bidderID;
    }

    public void isSold(boolean value) {
        this.sold = value;
    }

    public void addOffer(ArrayList<Offer> offers){
        this.offers.addAll(offers);
    }
    
    //Others functions 
    @Override
    public String toString() {
        String ch = "";
        if (sold) {
            ch = " | Acquired by : " + buyer;
        }
        return "[In progress] " + name + " | Current price : " + price + "€ | Market price : " + commonPrice + " | Minimum bid : " + minBid + " | Sold : " + sold + ch;
    }
}

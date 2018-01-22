package ah;

import java.util.Random;

public class Bidder implements Observer {

    private int wallet;
    public int ID;
    private int commonPrice;
    private int currentPrice;
    public static Random rand = new Random();

    public Bidder(int wallet, int ID) {
        this.wallet = wallet;
        this.ID = ID;
        AuctionHouse.getListSellers().get(0).subscribe(this);
        //regarder si il y a un item si oui est ce que je bid ? puis appeler bid()
        whoBid();
    }

    public boolean bidMonney(int bid) {
        if (wallet >= bid) {
            wallet -= bid;
            return true;
        }
        return false;
    }

    public void bidRefund(int bid) {
        wallet += bid;
    }

    public void whoBid() {
        try {
            commonPrice = AuctionHouse.getListSellers().get(0).getCurrentItem().getCommonPrice();
            currentPrice = AuctionHouse.getListSellers().get(0).getCurrentItem().getCommonPrice();
            if (commonPrice > currentPrice) {
                if (rand.nextInt(1000) > 500) {
                    bid(this, currentPrice + 20);
                }
            } else if (commonPrice * 1.3 < currentPrice) {
                if (rand.nextInt(1000) > 800) {
                    bid(this, currentPrice + 10);
                }
            } else if (rand.nextInt(1000) > 950) {
                bid(this, currentPrice + 5);
            }

        } catch (EmptyItemListException e) {
            System.out.println("List empty: end of sales");
        }
    }

    

    @Override
    public void refresh() {
        whoBid();
    }

    @Override
    public String toString() {
        return String.valueOf(ID);
    }
    
    //Getters
    
    public int getID() {
        return ID;
    }

    public int getWallet() {
        return wallet;
    }
}

package ah;

import java.util.Random;

public class Bidder implements Observer {

    private int wallet;
    private final int ID;
    private static Random rand = new Random();

    public Bidder(int wallet, int ID) {
        this.wallet = wallet;
        this.ID = ID;
        AuctionHouse.getListSellers().get(0).subscribe(this);                   //TODO : Changes that to connect correctly to room
//        whoBid(AuctionHouse.getListSellers().get(0));
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

    private void whoBid(Seller seller) {
        try {
            int commonPrice = seller.getCurrentItem().getCommonPrice();
            int currentPrice = seller.getCurrentPrice();
            int minBid = seller.getCurrentItem().getMinBid();
            int IDBuyer = seller.getCurrentBuyer();
            int aleatoire = rand.nextInt(1000);
            System.out.println("commonPrice :" + commonPrice + ", currentPrice : " + currentPrice + ", minBid :" + minBid + ", IDBuyer :" + IDBuyer + ", ID :" + ID + ", aleatoire :" + aleatoire + "\n");
            if (ID != IDBuyer) {
                if (commonPrice > currentPrice) {
                    if (aleatoire > 500) {
                        seller.bid(new Offer(this, currentPrice + minBid * 4));
                    }
                } else if (commonPrice * 1.3 > currentPrice) {
                    if (aleatoire > 800) {
                        System.out.println("action 2, commonPrice :" + commonPrice + ", currentPrice : " + currentPrice + ", minBid :" + minBid + ", IDBuyer :" + IDBuyer + ", ID :" + ID + ", aleatoire :" + aleatoire + "\n");
                        seller.bid(new Offer(this, currentPrice + minBid * 2));
                    }
                } else if (commonPrice * 3 > currentPrice) {
                    if (aleatoire > 950) {
                        System.out.println("action 3, commonPrice :" + commonPrice + ", currentPrice : " + currentPrice + ", minBid :" + minBid + ", IDBuyer :" + IDBuyer + ", ID :" + ID + ", aleatoire :" + aleatoire + "\n");
                        seller.bid(new Offer(this, currentPrice + minBid));
                    }
                }
            }
        } catch (EmptyItemListException e) {
            System.out.println("List empty: end of sales");
        }
    }

    @Override
    public void refresh(Seller seller) {
        whoBid(seller);
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

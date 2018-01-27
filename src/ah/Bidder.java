package ah;

import java.util.Random;

public class Bidder implements Observer {

    private int wallet;
    private int ID;
	private int IDBuyer;
    private int minBid;
    private int commonPrice;
    private int currentPrice;
    public static Random rand = new Random();

    public Bidder(int wallet, int ID) {
        this.wallet = wallet;
        this.ID = ID;
        AuctionHouse.getListSellers().get(0).subscribe(this);
        //regarder si il y a un item si oui est ce que je bid ? puis appeler bid()
        whoBid(AuctionHouse.getListSellers().get(0));
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

    public void whoBid(Seller seller) {
        try {
            commonPrice = AuctionHouse.getListSellers().get(0).getCurrentItem().getCommonPrice();
            currentPrice = AuctionHouse.getListSellers().get(0).getCurrentItem().getCommonPrice();
			minBid = AuctionHouse.getListSellers().get(0).getCurrentItem().getminBid();
            IDBuyer = AuctionHouse.getListSellers().get(0).getCurrentBuyer();
            if (commonPrice > currentPrice && ID != IDBuyer) {
                if (rand.nextInt(1000) > 500) {
                    seller.bid(this, currentPrice + minBid*4);
                }
            } else if (commonPrice * 1.3 < currentPrice && ID != IDBuyer) {
                if (rand.nextInt(1000) > 800) {
                    seller.bid(this, currentPrice + minBid*2);
                }
            } else if (commonPrice * 3 < currentPrice && ID != IDBuyer) {
                if (rand.nextInt(1000) > 950) {
                    seller.bid(this, currentPrice + minBid);
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

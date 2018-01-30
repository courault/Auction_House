package ah;

public class Offer {

    private final Bidder bidder;
    private final int offer;
    private boolean winBid;

    public Offer(Bidder bidder, int offer) {
        this.bidder = bidder;
        this.offer = offer;
        this.winBid = false;
    }

    //Getters
    
    public Bidder getBidder() {
        return bidder;
    }

    public int getOffer() {
        return offer;
    }

    public boolean win(){
        return winBid;
    }
    
    //Setters
    
    public void setWin(boolean win){
        this.winBid=win;
    }
    
    @Override
    public String toString() {
        return "" + offer;
    }
}

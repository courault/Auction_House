package ah;

public class Offer {
    private final Bidder bidder;
    private final int offer;
    
    public Offer(Bidder bidder, int offer){
        this.bidder=bidder;
        this.offer=offer;
    }
    
    public Bidder getBidder(){return bidder;}
    public int getOffer(){return offer;}
}

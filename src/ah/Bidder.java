package ah;


public class Bidder implements Observer{

	private int wallet;
	public int ID;


	public int getID() {
		return ID;
	}

	public int getWallet() {
		return wallet;
	}

	public void BidMonney(int bid){
		wallet -= bid;
	}

	public void BidRefund(int bid){
		wallet += bid;
	}

	public Bidder(int wallet ,int ID) {
		this.wallet = wallet;
		this.ID = ID;
		AuctionHouse.getListSellers().get(0).subscribe(this);
	}
	@Override
    public void refresh(int newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

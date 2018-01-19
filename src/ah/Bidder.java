package ah;

public class Bidder implements Observer{

	private int wallet;
	public String ID;


	public String getID() {
		return ID;
	}

	public int getWallet() {
		return wallet;
	}

	public void BidMonney(int bid){
		wallet -= bid;
	}

	public void bidrefund(int bid){
		wallet += bid;
	}

	private Bidder(int wallet ) {
		this.wallet = wallet;
		this.ID = ID;

	}

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

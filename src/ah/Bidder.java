package ah;

public class Bidder {

	private int wallet;
	public String ID;


	public String getID() {
		return ID;
	}

	public int getWallet() {
		return wallet;
	}

	private Bidder(int wallet ) {
		this.wallet = wallet;
		this.ID = ID;
	}


}

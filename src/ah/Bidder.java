

public class Bidder {

	private int wallet;
	public String ID;


	public String getID() {
		return ID.createID();
	}

	public int getWallet() {
		return wallet.getWallet();
	}

	private Bidder(int wallet ) {
		this.wallet = wallet;
		this.ID = ID;
	}


}

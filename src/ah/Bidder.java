package ah;

public class Bidder implements Observer {

    private int wallet;
    public int ID;

    public int getID() {
        return ID;
    }

    public int getWallet() {
        return wallet;
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

    public Bidder(int wallet, int ID) {
        this.wallet = wallet;
        this.ID = ID;
        AuctionHouse.getListSellers().get(0).subscribe(this);
        //regarder si il y a un item si oui est ce que je bid ? puis appeler bid()
		if(items.isEmpty()) {

		} else {
			
		}

    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return String.valueOf(ID);
    }
}

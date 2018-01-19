package ah;

import java.util.ArrayList;

public class AuctionHouse {

	private static ArrayList<Seller> sellers;


	static public void main(String[] args){
		sellers = new ArrayList<Seller>();
		for(int i=0; i<5;i++) {
			sellers.add(new Seller("", null));
		}
	}



}

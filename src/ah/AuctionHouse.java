package ah;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class AuctionHouse {

	private static ArrayList<Seller> sellers;
	private static List<String> sellerName = new ArrayList<String>();
	private static int count =0;
	public static Random rand = new Random();


	static public void main(String[] args){
		sellers = new ArrayList<Seller>();
		sellerName.add("Jack");
		sellerName.add("Jack");
		sellerName.add("Jack");
		sellerName.add("Jack");
		sellerName.add("Jack");
		for(int i=0; i<5;i++) {
			sellers.add(new Seller(sellerName.get(i), null));
		}
		Bidder jean = new Bidder(InitiateWallet(), InitiateID());
		Bidder kevin = new Bidder(InitiateWallet(), InitiateID());
		Bidder nicolas = new Bidder(InitiateWallet(), InitiateID());
		Bidder trump = new Bidder(InitiateWallet(), InitiateID());
		Bidder bertrand = new Bidder(InitiateWallet(), InitiateID());
		Bidder carole = new Bidder(InitiateWallet(), InitiateID());
	}

	public static ArrayList<Seller> getListSellers(){
		return sellers;
	}

	public static int InitiateWallet() {
		return  rand.nextInt(1000);
	}

	public static int InitiateID(){
		return count++;
	}

}

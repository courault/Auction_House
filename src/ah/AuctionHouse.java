package ah;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class AuctionHouse {

    private static ArrayList<Seller> sellers;
    private static List<String> sellerName;
    private static int count = 0;
    private static int nomberSeller = 0;
    public static Random rand = new Random();

    static {
        sellers = new ArrayList<>();
        sellerName = new ArrayList<>();
    }

    static public void main(String[] args) {
        InitiateRoom();
        sellers.get(0).start();
    }

    public static ArrayList<Seller> getListSellers() {
        return sellers;
    }

    public static int InitiateWallet() {
        return rand.nextInt(1000);
    }

    public static int InitiateID() {
        return count++;
    }

    public static void InitiateRoom() {
        sellerName.add("Jack");
        sellerName.add("Jack");
        sellerName.add("Jack");
        sellerName.add("Jack");
        sellerName.add("Jack");
        ArrayList<Item> listItem = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            listItem.add(new Item("item1", 100));
        }
        for (int i = 0; i < 5; i++) {
            try {
                sellers.add(new Seller(sellerName.get(i), listItem));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Bidder jean = new Bidder(InitiateWallet(), InitiateID());
        Bidder kevin = new Bidder(InitiateWallet(), InitiateID());
        Bidder nicolas = new Bidder(InitiateWallet(), InitiateID());
        Bidder trump = new Bidder(InitiateWallet(), InitiateID());
        Bidder bertrand = new Bidder(InitiateWallet(), InitiateID());
        Bidder carole = new Bidder(InitiateWallet(), InitiateID());

        sellers.get(0).subscribe(carole);
        sellers.get(0).subscribe(bertrand);
        sellers.get(0).subscribe(nicolas);
        sellers.get(0).subscribe(kevin);
        sellers.get(0).subscribe(trump);
        sellers.get(0).subscribe(jean);

    }

}

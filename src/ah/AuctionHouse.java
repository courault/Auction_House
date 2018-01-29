package ah;

import ah.ui.Window;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class AuctionHouse
{
	private static AuctionHouse instance = null;

	private Seller seller;
	private List<String> sellerName;
	private int count = 0;
	private int nomberSeller = 0;
	private Random rand = new Random();
	private Window win;

	private AuctionHouse()
	{
	}

	public static void main(String[] args)
	{
		getInstance().start();
	}

	public static AuctionHouse getInstance()
	{
		if(instance == null)
			instance = new AuctionHouse();
		return instance;
	}

	private void start()
	{
		win = Window.getInstance();
		win.showPanel(Window.SELL_PANEL);
	}

	public Seller getSeller()
	{
		return seller;
	}

	public int initiateWallet()
	{
		return rand.nextInt(1000000000);
	}

	public int initiateID()
	{
		return count++;
	}

	public void initiateRoom(ArrayList<Item> listItem)
	{
		try
		{
			seller = new Seller(listItem);
		}
		catch(EmptyItemListException ex)
		{
			ex.printStackTrace();
		}

		Bidder jean = new Bidder(initiateWallet(), initiateID());
		Bidder kevin = new Bidder(initiateWallet(), initiateID());
		Bidder nicolas = new Bidder(initiateWallet(), initiateID());
		Bidder trump = new Bidder(initiateWallet(), initiateID());
		Bidder bertrand = new Bidder(initiateWallet(), initiateID());
		Bidder carole = new Bidder(initiateWallet(), initiateID());

		seller.subscribe(carole);
		seller.subscribe(bertrand);
		seller.subscribe(nicolas);
		seller.subscribe(kevin);
		seller.subscribe(trump);
		seller.subscribe(jean);

	}

}

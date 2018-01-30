package ah;

import java.util.ArrayList;

public class Item
{

	private final String name;
	private final int startPrice;
	private int price;
	private final int minBid;
	private final int commonPrice;
	private boolean sold;
	private int buyer = -1;
	private ArrayList<Offer> offers;

	public Item(String name, int price)
	{
		this.name = name;
		startPrice = price;
		this.price = price;
		commonPrice = price * 2;
		minBid = (int) (price / 10) + (int) (Math.random() * (((price / 20) - (price / 10)) + 1));
		sold = false;
		offers = new ArrayList<>();
	}
	
	//Getters

	public int getPrice()
	{
		return price;
	}

	public String getName()
	{
		return name;
	}

	public int getMinBid()
	{
		return minBid;
	}

	public int getCommonPrice()
	{
		return commonPrice;
	}

	public ArrayList<Offer> getOffers()
	{
		return offers;
	}

	//Setters
	public void setPrice(int price)
	{
		this.price = price;
	}

	public void setBuyer(int bidderID)
	{
		buyer = bidderID;
	}

	public void isSold(boolean value)
	{
		this.sold = value;
	}
	
	public void addOffer(ArrayList<Offer> offers)
	{
		this.offers.addAll(offers);
	}

	//Others functions 
	@Override
	public String toString()
	{
		String ch = "";
		if(buyer != -1)
			ch = " | Acquired by : " + buyer;
		String head = "[Waiting] ";
		if(sold && buyer == -1)
			head = "[Unsold] ";
		else if(sold)
			head = "[Sold] ";
		else if(!sold && startPrice != price)
			head = "[In progress] ";
		return head + name + " | Current price : " + price + "€ | Market price : " + commonPrice + " | Minimum bid : " + minBid + ch;
	}
}

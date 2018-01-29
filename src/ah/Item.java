package ah;

public class Item
{

	private final String name;
	private int price;
	private final int minBid;
	private final int commonPrice;
        private boolean sold;

	public Item(String name, int price)
	{
		this.name = name;
		this.price = price;
		commonPrice = price * 2;
		minBid = (int) (price / 10) + (int) (Math.random() * (((price / 20) - (price / 10)) + 1));
                sold = false;

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

        //Setters
        
	public void setPrice(int price)
	{
		this.price = price;
	}

        public void isSold(boolean value){
            this.sold=value;
        }
        
        //Others functions 
        
	@Override
	public String toString()
	{
		return name + " : " + price + " : " + commonPrice + " : " + minBid;
	}
}

package ah.ui;

import ah.Observer;
import ah.Seller;
import javax.swing.JFrame;

public class Window extends JFrame implements Observer
{

	private static final String TITLE = "Auction House";
	private static final int W = 800;
	private static final int H = 500;

	public static final int SELL_PANEL = 0;
	public static final int AUCT_PANEL = 1;
	public static final int DETA_PANEL = 2;

	private static Window instance = null;	//Contains the unique instance of class Window

	//Differents intances of the application views
	private final SellItemPan sellItemPan;
	private final AuctionPan auctionPan;
	private final DetailsPan detailsPan;
	private int panel = 0;

	private Window()
	{
		super(TITLE);
		setSize(W, H);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		sellItemPan = new SellItemPan();
		auctionPan = new AuctionPan();
		detailsPan = new DetailsPan();
		setVisible(true);
	}

	//To use to change the application view
	public void showPanel(int panel)
	{
		this.panel = panel;
		getContentPane().removeAll();
		switch(panel)
		{
			case SELL_PANEL:
				getContentPane().add(sellItemPan);
				break;
			case AUCT_PANEL:
				getContentPane().add(auctionPan);
				break;
			case DETA_PANEL:
				getContentPane().add(detailsPan);
				detailsPan.setItemIndex(auctionPan.getItemIndex());
				break;
		}
		validate();
		repaint();
	}

	public SellItemPan getSellItemPan()
	{
		return sellItemPan;
	}

	public final static Window getInstance()
	{
		if(instance == null)
			instance = new Window();
		return instance;
	}

	@Override
	public void refresh(Seller seller)
	{
		switch(panel)
		{
			case SELL_PANEL:
				break;
			case AUCT_PANEL:
				auctionPan.refresh(seller);
				break;
			case DETA_PANEL:
				detailsPan.refresh(seller);
				break;
		}
	}
}

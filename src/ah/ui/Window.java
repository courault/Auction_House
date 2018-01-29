package ah.ui;

import ah.Observer;
import ah.Seller;
import javax.swing.JFrame;

public class Window extends JFrame implements Observer
{

	private static final String TITLE = "Auction House";
	private static final int W = 600;
	private static final int H = 500;

	public static final int SELL_PANEL = 0;
	public static final int AUCT_PANEL = 1;
	public static final int DETA_PANEL = 2;

	private static Window instance = null;	//Contient l'unique instance de la classe Window

	private SellItemPan sellItemPan;
	private AuctionPan auctionPan;

	private Window()
	{
		super(TITLE);
		setSize(W, H);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		sellItemPan = new SellItemPan();
		auctionPan = new AuctionPan();
		setVisible(true);
	}

	public void showPanel(int panel)
	{
		getContentPane().removeAll();
		switch(panel)
		{
			case SELL_PANEL:
				getContentPane().add(sellItemPan);
				break;
			case AUCT_PANEL:
				getContentPane().add(auctionPan);
				break;
			/*case MAIN_PANEL:
				getContentPane().add(mainPan);
				break;*/
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
		auctionPan.refresh(seller);
	}
}

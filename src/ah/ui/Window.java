package ah.ui;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final String TITLE = "Auction House";
	private static final int W = 600;
	private static final int H = 500;
	
	public static final int SELL_PANEL = 0;
	public static final int AUCT_PANEL = 1;
	public static final int DETA_PANEL = 2;
	
	private static Window instance = null;	//Contient l'unique instance de la classe Window
	
	private SellItemPan sellItemPan;
	
	private Window() {
		super(TITLE);
		setSize(W, H);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		sellItemPan = new SellItemPan();
		setVisible(true);
	}
	
	public void showPanel(int panel) {
		getContentPane().removeAll();
		switch(panel){
			case SELL_PANEL:
				getContentPane().add(sellItemPan);
				break;
			/*case AUTH_PANEL:
				getContentPane().add(authPan);
				break;
			case MAIN_PANEL:
				getContentPane().add(mainPan);
				break;*/
		}
		validate();
		repaint();
	}
	
	public SellItemPan getSellItemPan() {
		return sellItemPan;
	}
	
	public final static Window getInstance() {
		if (instance == null) {
			instance = new Window();
		}
		return instance;
	}
}

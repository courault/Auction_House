package ah.ui;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final String TITLE = "Liscord";
	private static final int W = 865;
	private static final int H = 500;
	
	private static Window instance = null;	//Contient l'unique instance de la classe Window
	
	private Window() {
		super(TITLE);
		setSize(W, H);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public final static Window getInstance() {
		if (instance == null) {
			instance = new Window();
		}
		return instance;
	}
}

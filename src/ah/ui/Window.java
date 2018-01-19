package ah.ui;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final String TITLE = "Liscord";
	private static final int W = 865;
	private static final int H = 500;
	
	public Window() {
		super(TITLE);
		setSize(W, H);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}

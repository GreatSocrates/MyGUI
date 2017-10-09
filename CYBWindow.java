package MyGUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JWindow;
import javax.swing.border.Border;

public class CYBWindow extends JWindow {
	private int stockID;
	private MyPanel testPanel;

	public CYBWindow(int stockID) {
		// TODO Auto-generated constructor stub
		this.stockID = stockID;
		Border windowBorder=BorderFactory.createLineBorder(Color.GRAY, 3);
		testPanel=new MyPanel(windowBorder);
		testPanel.paint(testPanel.getGraphics());
	}
}

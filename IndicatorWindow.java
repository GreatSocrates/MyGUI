package MyGUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JWindow;
import javax.swing.border.Border;

public class IndicatorWindow extends JWindow
{
	private int stockID;
	private MyJPanel testPanel;
	
	
	public IndicatorWindow(int stockID) {
		// TODO Auto-generated constructor stub
		this.stockID = stockID;
		Border windowBorder=BorderFactory.createLineBorder(Color.GRAY, 3);
		testPanel=new MyJPanel(windowBorder);
		testPanel.paint(getGraphics());
	}
}

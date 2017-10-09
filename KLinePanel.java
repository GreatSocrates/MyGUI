package MyGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JWindow;
import javax.swing.border.Border;

public class KLinePanel extends MyPanel {
	private LinkedList<Stock>[] stocks;

	private int stockID;

	public KLinePanel() {
		// TODO Auto-generated constructor stub

		getChartPreferenceSetting();
		getStocksData();

	}

	public void init() {
		setRuler();
		setTopPanel();
		setKLinePanel();
		setErPanel();
	}

	public void drawContent(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		drawCoordinateSystem(graphics);
		drawKLines(graphics);
		drawEr(graphics);
		drawTrendLine(graphics);
		drawSecondaryStock(graphics);
		drawOtherIndicator(graphics);
	}









	private void setRuler() {
		// TODO Auto-generated method stub

	}
	private void setTopPanel() {
		// TODO Auto-generated method stub
		
	}
	private void setKLinePanel() {
		// TODO Auto-generated method stub

	}
	private void setErPanel() {
		// TODO Auto-generated method stub

	}
	private void getChartPreferenceSetting() {
		// TODO Auto-generated method stub

	}
	private void getStocksData() {
		// TODO Auto-generated method stub

	}

	private void drawCoordinateSystem(Graphics2D graphics) {
		// TODO Auto-generated method stub

	}
	private void drawKLines(Graphics2D graphics) {
		// TODO Auto-generated method stub

	}
	private void drawEr(Graphics2D graphics) {
		// TODO Auto-generated method stub

	}
	private void drawTrendLine(Graphics2D graphics) {
		// TODO Auto-generated method stub

	}
	private void drawSecondaryStock(Graphics2D graphics) {
		// TODO Auto-generated method stub

	}
	private void drawOtherIndicator(Graphics2D graphics) {
		// TODO Auto-generated method stub

	}



	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		drawContent(g);
	}

}

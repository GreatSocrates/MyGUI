package MyGUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.border.Border;

class MyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bufferWidth;
	private int bufferHeight;
	private Graphics bufferGraphics;
	private Image bufferImage;
	
	private Point pos;

	public MyPanel() {
		// TODO Auto-generated constructor stub
		pos=new Point();
	}

	protected void drawCrossLine(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics=(Graphics2D) g;
		graphics.setColor(Color.LIGHT_GRAY);
		
		graphics.drawLine(pos.x, 0, pos.x, pos.y-10);
		graphics.drawLine(pos.x, pos.y+10, pos.x, getHeight());
		graphics.drawLine(0, pos.y, pos.x-10, pos.y);
		graphics.drawLine(pos.x+10, pos.y, getWidth(), pos.y);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if (bufferWidth != getSize().width || bufferHeight != getSize().height || bufferImage == null
				|| bufferGraphics == null)
			resetBuffer();
		drawCrossLine(g);

	}

	private void resetBuffer() {
		// TODO Auto-generated method stub
		// always keep track of the image size
		bufferWidth = getSize().width;
		bufferHeight = getSize().height;

		// clean up the previous image
		if (bufferGraphics != null) {
			bufferGraphics.dispose();
			bufferGraphics = null;
		}
		if (bufferImage != null) {
			bufferImage.flush();
			bufferImage = null;
		}
		System.gc();
		// create the new image with the size of the panel
		bufferImage = createImage(bufferWidth, bufferHeight);
		bufferGraphics = bufferImage.getGraphics();
	}
	
	public void setPos(Point pos) {
		this.pos = pos;
	}
}
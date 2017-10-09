package MyGUI;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MyGUIMain {
	private int width;
	private int height;
	private MyFrame myFrame;
	private MyDesktopPane myDesktopPane;
	
	private KLineFrame kLineFrame;
	// private Homepage homepage;

	public MyGUIMain(int width, int height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;

		myDesktopPane = new MyDesktopPane(this.width, this.height);
		myFrame = new MyFrame("My Frame", myDesktopPane);
		myFrame.setSize(this.width, this.height);

		MyMenuBar myMenuBar = myFrame.getMyMenuBar();
		kLineFrame = new KLineFrame(600001, this.width, this.height, myMenuBar);
		myDesktopPane.add(kLineFrame);

		myFrame.add(myDesktopPane);
		myFrame.pack();
		myFrame.setVisible(true);


		// Container c=kLineFrame.getParent();
		// while (c!=null&&!c.getClass().equals(MyFrame.class)) {
		// c=c.getParent();
		// }
		// System.out.println(c.toString());

		Point crossPoint = new Point((int) (kLineFrame.getContentPane().getWidth() * kLineFrame.getMINxRate()),
				(int) (kLineFrame.getContentPane().getHeight() * kLineFrame.getMINyRate()));
		kLineFrame.setCrossPoint(crossPoint);
		kLineFrame.resizePanels(crossPoint);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable startMainGUI = () -> {
			new MyGUIMain(800, 600);
		};
		SwingUtilities.invokeLater(startMainGUI);
	}

}

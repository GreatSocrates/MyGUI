package MyGUI;

import java.awt.BorderLayout;
import java.awt.MenuBar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyFrame extends JFrame {
	private MyFrame myFrame;

	private MyMenuBar myMenuBar;
	private MyToolBar myToolBar;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame(String name, MyDesktopPane myJDesktopPane) {
		myMenuBar = new MyMenuBar(this, myJDesktopPane);
		myToolBar = new MyToolBar();
		setTitle(name);

		// setSize(getParent().WIDTH, getParent().HEIGHT);
		this.setJMenuBar(myMenuBar);
		this.add(myToolBar, BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBorder(BorderFactory.createEmptyBorder());
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ����f�����ڶ��������Լ��ڲ����������UI
		SwingUtilities.updateComponentTreeUI(this.getContentPane()); // ��
		// ����mb�˵����Լ��ڲ����������UI
		SwingUtilities.updateComponentTreeUI(myMenuBar);
		// ����pop�Ҽ��˵��Լ��ڲ����������UI
		SwingUtilities.updateComponentTreeUI(myToolBar);
	}

	public MyMenuBar getMyMenuBar() {
		return myMenuBar;
	}

}

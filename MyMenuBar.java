package MyGUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
public class MyMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyFrame myFrame;
	private MyDesktopPane myDesktopPanel;

	private JMenu fileMenu;
	JMenu scoreMenu;
	JMenu helpMenu;

	JMenuItem singleGame;
	JMenuItem multiPlayerGame;
	JMenuItem vsComputerGame;
	JMenuItem restartGame;
	JMenuItem backHomepage;
	JMenuItem exit;

	JMenuItem scoreOfSinglegame;
	JMenuItem scoreOfMultiPlayerGame;
	JMenuItem scoreOfVsComputer;

	JMenuItem about;
	JMenuItem help;

	JButton minimizeWindow;
	JButton restoreWindow;
	JButton closeWindow;

	// 下面的Panel用来在最大化时隐藏标题栏并将最小化，最大化，关闭按钮放在菜单栏的右侧
	private JPanel windowControlPane;

	public MyMenuBar(MyFrame myFrame, MyDesktopPane myJDesktopPane) {
		this.myFrame = myFrame;
		this.myDesktopPanel = myJDesktopPane;

		// 下面来设置菜单栏
		fileMenu = new JMenu("游戏");
		scoreMenu = new JMenu("记分牌");
		helpMenu = new JMenu("帮助");

		singleGame = new JMenuItem("单人游戏");
		multiPlayerGame = new JMenuItem("双人游戏");
		vsComputerGame = new JMenuItem("人机对战");
		restartGame = new JMenuItem("重新开始");
		backHomepage = new JMenuItem("回到首页");
		exit = new JMenuItem("退出游戏");

		fileMenu.add(singleGame);
		fileMenu.add(multiPlayerGame);
		fileMenu.add(vsComputerGame);
		fileMenu.addSeparator();
		fileMenu.add(restartGame);
		fileMenu.add(backHomepage);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		scoreOfSinglegame = new JMenuItem("单人游戏纪录");
		scoreOfMultiPlayerGame = new JMenuItem("双人游戏纪录");
		scoreOfVsComputer = new JMenuItem("人机对战纪录");

		scoreMenu.add(scoreOfSinglegame);
		scoreMenu.add(scoreOfMultiPlayerGame);
		scoreMenu.add(scoreOfVsComputer);

		JMenuItem about = new JMenuItem("关于");
		JMenuItem help = new JMenuItem("帮助");

		helpMenu.add(about);
		helpMenu.addSeparator();
		helpMenu.add(help);

		// 下面的代码用来自定义个窗口控制按钮区
		windowControlPane = new JPanel(new FlowLayout(FlowLayout.TRAILING, -1, 0));
		windowControlPane.setOpaque(true);
		windowControlPane.setVisible(false);
		minimizeWindow = new JButton(new ImageIcon("./src/ico/minimize.jpg"));
		minimizeWindow.setMargin(new Insets(0, 0, 0, 0));
		minimizeWindow.setSize(new Dimension(28, 10));
		minimizeWindow.setRolloverEnabled(true);
		minimizeWindow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		minimizeWindow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KLineFrame selectedFrame = (KLineFrame) myDesktopPanel.getSelectedFrame();
//				Dimension windowControlPaneDimension = windowControlPane.getPreferredSize();
				try {
					selectedFrame.setIcon(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				windowControlPane.setVisible(false);
			}
		});
		restoreWindow = new JButton(new ImageIcon("./src/ico/restore.jpg"));
		restoreWindow.setMargin(new Insets(0, 0, 0, 0));
		restoreWindow.setSize(new Dimension(28, 10));
		restoreWindow.setRolloverEnabled(true);
		restoreWindow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		restoreWindow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KLineFrame selectedFrame = (KLineFrame) myDesktopPanel.getSelectedFrame();
				try {
					selectedFrame.setMaximum(false);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				selectedFrame.showNorthPanel();
				windowControlPane.setVisible(false);
			}
		});
		closeWindow = new JButton(new ImageIcon("./src/ico/close.jpg"));
		closeWindow.setMargin(new Insets(0, 0, 0, 0));
		closeWindow.setSize(new Dimension(28, 10));
		closeWindow.setRolloverEnabled(true);
		closeWindow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		closeWindow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KLineFrame selectedFrame = (KLineFrame) myDesktopPanel.getSelectedFrame();
				selectedFrame.dispose();
				windowControlPane.setVisible(false);
			}
		});
		windowControlPane.add(minimizeWindow);
		windowControlPane.add(restoreWindow);
		windowControlPane.add(closeWindow);
		// 默认是隐藏的
		

		this.add(fileMenu);
		this.add(scoreMenu);
		this.add(helpMenu);
		this.add(windowControlPane);
		System.out.println(this.getLayout());
		Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		this.setBorder(etchedBorder);
		// this.setBorderPainted(false);

	}

	public JPanel getWindowControlPane() {
		return windowControlPane;
	}
}

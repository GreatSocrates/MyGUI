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

	// �����Panel���������ʱ���ر�����������С������󻯣��رհ�ť���ڲ˵������Ҳ�
	private JPanel windowControlPane;

	public MyMenuBar(MyFrame myFrame, MyDesktopPane myJDesktopPane) {
		this.myFrame = myFrame;
		this.myDesktopPanel = myJDesktopPane;

		// ���������ò˵���
		fileMenu = new JMenu("��Ϸ");
		scoreMenu = new JMenu("�Ƿ���");
		helpMenu = new JMenu("����");

		singleGame = new JMenuItem("������Ϸ");
		multiPlayerGame = new JMenuItem("˫����Ϸ");
		vsComputerGame = new JMenuItem("�˻���ս");
		restartGame = new JMenuItem("���¿�ʼ");
		backHomepage = new JMenuItem("�ص���ҳ");
		exit = new JMenuItem("�˳���Ϸ");

		fileMenu.add(singleGame);
		fileMenu.add(multiPlayerGame);
		fileMenu.add(vsComputerGame);
		fileMenu.addSeparator();
		fileMenu.add(restartGame);
		fileMenu.add(backHomepage);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		scoreOfSinglegame = new JMenuItem("������Ϸ��¼");
		scoreOfMultiPlayerGame = new JMenuItem("˫����Ϸ��¼");
		scoreOfVsComputer = new JMenuItem("�˻���ս��¼");

		scoreMenu.add(scoreOfSinglegame);
		scoreMenu.add(scoreOfMultiPlayerGame);
		scoreMenu.add(scoreOfVsComputer);

		JMenuItem about = new JMenuItem("����");
		JMenuItem help = new JMenuItem("����");

		helpMenu.add(about);
		helpMenu.addSeparator();
		helpMenu.add(help);

		// ����Ĵ��������Զ�������ڿ��ư�ť��
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
		// Ĭ�������ص�
		

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

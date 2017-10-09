package MyGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Homepage extends JPanel {
	private int width;
	private int height;
	private Dimension screenSize;
	private JLabel welcome;
	private JButton singlePlayer;
	private JButton twoPlayers;
	private JButton vsComputer;

	/**
	 * 
	 * @param width
	 *            The width of the homepage.
	 * @param height
	 *            The height of the homepage.
	 */
	public Homepage(int width, int height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
		init();
	}

	public void init() {
		// jFrame = new JFrame("Pinball Game");
		screenSize = new Dimension(width, height);
		this.setPreferredSize(screenSize);

		JPanel panelNorth = new JPanel();
		// JPanel panelMiddle = new JPanel();

		welcome = new JLabel("欢迎来玩卜卜弹球游戏", JLabel.CENTER);
		welcome.setFont(new Font("Times", Font.BOLD, 40));
		welcome.setForeground(Color.RED);
		// welcome.setBounds(width/2-150, height/2-offset, 300, 40);

		singlePlayer = new JButton("单人游戏");
		twoPlayers = new JButton("双人游戏");
		vsComputer = new JButton("人机对战");

		// 如何放置文本框和按钮十分麻烦，还没有找到便利的方法。
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();

		// 下面的border只是为了看清楚控件的位置，没有其他用处
		// Border solidBorder =
		// BorderFactory.createBevelBorder(BevelBorder.RAISED);
		// box1.setBorder(solidBorder);
		box1.add(welcome);

		// box2.setBorder(solidBorder);
		// 下面可以看出Glue和Strut的区别
		// box2.add(Box.createHorizontalGlue());
		box2.add(singlePlayer);
		box2.add(Box.createHorizontalStrut(60));
		box2.add(twoPlayers);
		box2.add(Box.createHorizontalStrut(60));
		box2.add(vsComputer);
		// box2.add(Box.createHorizontalGlue());

		panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.Y_AXIS));
		// 下面的语句如果加Glue是无法将控件撑下去的，因为BorderLayout。North区域的尺寸是按比例预设的，放Glue不会超过预设，因此只能用Strut来占位置
		// panelNorth.add(Box.createVerticalGlue());
		panelNorth.add(Box.createVerticalStrut(150));
		panelNorth.add(box1);
		panelNorth.add(Box.createVerticalStrut(30));
		panelNorth.add(box2);

		this.add(panelNorth, BorderLayout.NORTH);
		// jFrame.add(panelMiddle);

		// singlePlayer.addActionListener(e->new OnePlayerUI(width,
		// height).init());
		// singleGame.addActionListener(e->new OnePlayerUI(width,
		// height).init());

	}

	public JButton getButtonSinglePlayer() {
		return singlePlayer;
	}

	public void setButtonSinglePlayer(JButton singlePlayer) {
		this.singlePlayer = singlePlayer;
	}

}
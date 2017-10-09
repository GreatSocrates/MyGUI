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

		welcome = new JLabel("��ӭ���沷��������Ϸ", JLabel.CENTER);
		welcome.setFont(new Font("Times", Font.BOLD, 40));
		welcome.setForeground(Color.RED);
		// welcome.setBounds(width/2-150, height/2-offset, 300, 40);

		singlePlayer = new JButton("������Ϸ");
		twoPlayers = new JButton("˫����Ϸ");
		vsComputer = new JButton("�˻���ս");

		// ��η����ı���Ͱ�ťʮ���鷳����û���ҵ������ķ�����
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();

		// �����borderֻ��Ϊ�˿�����ؼ���λ�ã�û�������ô�
		// Border solidBorder =
		// BorderFactory.createBevelBorder(BevelBorder.RAISED);
		// box1.setBorder(solidBorder);
		box1.add(welcome);

		// box2.setBorder(solidBorder);
		// ������Կ���Glue��Strut������
		// box2.add(Box.createHorizontalGlue());
		box2.add(singlePlayer);
		box2.add(Box.createHorizontalStrut(60));
		box2.add(twoPlayers);
		box2.add(Box.createHorizontalStrut(60));
		box2.add(vsComputer);
		// box2.add(Box.createHorizontalGlue());

		panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.Y_AXIS));
		// �������������Glue���޷����ؼ�����ȥ�ģ���ΪBorderLayout��North����ĳߴ��ǰ�����Ԥ��ģ���Glue���ᳬ��Ԥ�裬���ֻ����Strut��ռλ��
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
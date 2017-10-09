package MyGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainWindowSettings extends JTabbedPane{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final int WIDTH=650;
	public final int HEIGHT=400;
	
	private JPanel jPanel1=new JPanel();
	private JPanel jPanel2=new JPanel();
	private JPanel jPanel3=new JPanel();
	private JPanel jPanel4=new JPanel();
	private JPanel jPanel5=new JPanel();
	
	
	
	public MainWindowSettings() {
		// TODO Auto-generated constructor stub
		setSize(WIDTH, HEIGHT);
		addTab("K��ͼ����", jPanel1);
		addTab("ָ������", jPanel2);
		addTab("������", jPanel3);
		addTab("������ʾ", jPanel4);
		addTab("��������", jPanel5);
		
//		addTab("��������", jPanel2);
//		addTab("ͼ�ߵ���", jPanel2);
//		addTab("ָ�괰", jPanel2);
//		addTab("F7ָ��ѭ��", jPanel2);
//		addTab("F8����ѭ��", jPanel2);
//		addTab("����K��", jPanel1);
	
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton okButton=new JButton("ȷ��(O)");
		JButton cancelButton=new JButton("ȡ��(C)");
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		
		add(buttonPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public MainWindowSettings createTabbedPane(){
		return this;
	}

}

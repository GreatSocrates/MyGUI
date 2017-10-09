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
		addTab("K线图设置", jPanel1);
		addTab("指数叠加", jPanel2);
		addTab("参数窗", jPanel3);
		addTab("决策提示", jPanel4);
		addTab("界面设置", jPanel5);
		
//		addTab("操作设置", jPanel2);
//		addTab("图线叠加", jPanel2);
//		addTab("指标窗", jPanel2);
//		addTab("F7指标循环", jPanel2);
//		addTab("F8周期循环", jPanel2);
//		addTab("立体K线", jPanel1);
	
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton okButton=new JButton("确定(O)");
		JButton cancelButton=new JButton("取消(C)");
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		
		add(buttonPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public MainWindowSettings createTabbedPane(){
		return this;
	}

}

package MyGUI;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.border.Border;

/**
 * 
 * @author Allen
 * 
 */
public class MyToolBar extends JToolBar {
	/**
	 * @
	 */
	private ImageIcon standardIcon;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ��ȡϵͳ������
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

	public MyToolBar() {
		// TODO Auto-generated constructor stub
		// �������ͼ��ͼƬ�ĳߴ�
		standardIcon = new ImageIcon("./src/ico/paste.png");

		this.add(pasteAction);
		this.add(new MyToolBarSeparator(standardIcon));
		this.add(pasteAction);
		this.add(new MyToolBarSeparator(standardIcon));
		this.add(pasteAction);
		this.add(pasteAction);

		Border emptyBorder = BorderFactory.createEmptyBorder();
		this.setBorder(emptyBorder);
		this.setFloatable(false);
		this.setRollover(true);
	}
	//Ĭ�ϰ�ť��ͼ��Ḳ�����ֵģ����Ҫ����ʾ��������ʾͼƬ�����Ը�AbstractAction���һ����������������ʾ�������ͼ����ʾ�ڰ�ť��
	//��������ʾ�����ǣ�������ƶ�����ͼ���ϣ���һ�����ͻῴ��һ������ʾ����
	Action pasteAction = new MyToolBarAction("ճ��", new ImageIcon("./src/ico/paste.png")) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {

		}
	
	};

	//ͨ����JToolBar��Դ�룬�����add������ԭ����д�����������buttton�ı߿�ȥ����
    @Override
    public JButton add(Action a) {
        JButton b = createActionComponent(a);
        b.setAction(a);
        b.setBorderPainted(false);
        add(b);
        return b;
    }

}

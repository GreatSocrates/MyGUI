package MyGUI;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

/**
 * �����������ʾ������ͼ���ϵ����֣�������Ƶ���ť�Ϻ󣬻���ʾ����������
 * @author Allen
 *
 */
abstract class MyToolBarAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyToolBarAction(String name, ImageIcon imageIcon) {
		// TODO Auto-generated constructor stub
		super(name, imageIcon);
		putValue(SHORT_DESCRIPTION, name);
		}

}
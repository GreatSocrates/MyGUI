package MyGUI;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JSeparator;

/**
 * ������������������ķָ�����ע��JSeparator��ʾһ���ָ��ߣ����Ҫ���Ӷ�������Ҫ���JSeparatorʵ����
 * �����ֻ��������һ���ӷָ����ĵط� ��JToolBarĬ�ϵ�addSeparator()�������������ǿհ׵ġ�
 * 
 * @author Allen
 *
 */

class MyToolBarSeparator extends JSeparator {
	
	public MyToolBarSeparator(ImageIcon standardIcon) {
		// TODO Auto-generated constructor stub
		this.setOrientation(VERTICAL);
		this.setMaximumSize(new Dimension(2, standardIcon.getIconWidth()));
	}

}

package MyGUI;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JSeparator;

/**
 * 这个类用来画工具栏的分隔符，注意JSeparator表示一条分隔线，如果要增加多条，需要多个JSeparator实例，
 * 否则就只会放在最后一个加分隔符的地方 而JToolBar默认的addSeparator()方法画出来的是空白的。
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

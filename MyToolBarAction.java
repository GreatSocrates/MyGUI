package MyGUI;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

/**
 * 这个类用来显示工具栏图标上的文字，当鼠标移到按钮上后，会显示浮动的文字
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
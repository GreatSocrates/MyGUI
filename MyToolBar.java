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
	// 获取系统剪贴板
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

	public MyToolBar() {
		// TODO Auto-generated constructor stub
		// 用来获得图标图片的尺寸
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
	//默认按钮的图标会覆盖文字的，如果要既显示文字又显示图片，可以给AbstractAction添加一个描述，把文字显示在描述里，图标显示在按钮上
	//描述的显示方法是：把鼠标移动到该图标上，过一会儿你就会看到一行字显示出来
	Action pasteAction = new MyToolBarAction("粘贴", new ImageIcon("./src/ico/paste.png")) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {

		}
	
	};

	//通过看JToolBar的源码，搞清楚add操作的原理，重写这个方法，把buttton的边框去掉。
    @Override
    public JButton add(Action a) {
        JButton b = createActionComponent(a);
        b.setAction(a);
        b.setBorderPainted(false);
        add(b);
        return b;
    }

}

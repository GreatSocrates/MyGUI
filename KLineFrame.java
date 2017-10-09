package MyGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;

import javax.management.OperationsException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class KLineFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// These rates are used to control the position of 4 panels
	private final double MAXxRate = 0.9;
	private final double MINxRate = 0.7;

	private final double MAXyRate = 0.9;
	private final double MINyRate = 0.5;

	// 用来确保缩放过程中各窗口比例保持不变
	private double crossPointXRate;
	private double crossPointYRate;

	/** The is hidden. */
	boolean isHidden = false;

	/** The old ui. */
	BasicInternalFrameUI oldUi = null;

	private KLinePanel kLinePanel;
	private JettonWindow jettonWindow;
	private IndicatorWindow indicatorWindow;
	private CYBWindow cybWindow;

	private Cursor cursor;

	private MyMenuBar myMenuBar;

	private JLabel statusBar;
	private Box northBox;
	private Box middleBox;
	private Box southBox;

	private int width;
	private int height;
	private int menuHeight;

	private int stockID;

	private Point crossPoint;
	private Point mousePosition;

	// these point are prepared to convert a relative position for repaint of
	// jettonWindow, indicatorWindow and cybWindow
	private Point quadrant1Pos = new Point();
	private Point quadrant3Pos = new Point();
	private Point quadrant4Pos = new Point();

	JPanel jPanelAll;
	MyPanel jPanel1;
	MyPanel jPanel2;
	MyPanel jPanel3;
	MyPanel jPanel4;

	private MainWindowSettings mainWindowSettings;

	public KLineFrame(int stockID, int width, int height, MyMenuBar menuBar) {

		// 保留去除标题栏时的UI状态
		oldUi = (BasicInternalFrameUI) getUI();

		this.myMenuBar = menuBar;
		this.width = width;
		this.height = height;

		setSize(width, height);
		this.setStockID(stockID);

		// 去除边框
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		// 依次为可最大化，可关闭，可变尺寸，可最小化
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		// 很重要，否则画出来就是(0，0，0，0)
		pack();
		reshape(0, 0, width, height);

		show();
		init();
	}

	public void init() {

		jPanelAll = new JPanel();
		jPanel1 = new MyPanel();
		jPanel2 = new MyPanel();
		jPanel3 = new MyPanel();
		jPanel4 = new MyPanel();
		kLinePanel = new KLinePanel();

		Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
		jPanel1.setBorder(lineBorder);
		jPanel2.setBorder(lineBorder);
		jPanel3.setBorder(lineBorder);
		jPanel4.setBorder(lineBorder);
		kLinePanel.setBorder(lineBorder);

		jPanel1.setBackground(Color.RED);
		jPanel2.setBackground(Color.BLACK);
		kLinePanel.setBackground(Color.BLACK);
		jPanel3.setBackground(Color.YELLOW);
		jPanel4.setBackground(Color.DARK_GRAY);

		jPanelAll.setLayout(null);

		JLabel jLabel1 = new JLabel("1");
		jLabel1.setForeground(Color.LIGHT_GRAY);
		JLabel jLabelKLine = new JLabel("KLine Window");
		jLabelKLine.setForeground(Color.LIGHT_GRAY);
		JLabel jLabel3 = new JLabel("3");
		jLabel1.setForeground(Color.LIGHT_GRAY);
		JLabel jLabel4 = new JLabel("4");
		jLabel1.setForeground(Color.LIGHT_GRAY);

		jPanel1.add(jLabel1);
		jPanel2.add(jLabelKLine);
		kLinePanel.add(jLabelKLine);
		jPanel3.add(jLabel3);
		jPanel4.add(jLabel4);

		jPanelAll.add(kLinePanel);
		jPanelAll.add(jPanel1);
		jPanelAll.add(jPanel4);
		jPanelAll.add(jPanel3);

		statusBar = new JLabel("Hello");

		this.add(jPanelAll);
		this.add(statusBar, BorderLayout.SOUTH);
		addMyListener();
		
//		jOptionPane.setLocation((getWidth()-jOptionPane.WIDTH)/2, (getHeight()-jOptionPane.HEIGHT)/2);
	}

	/**
	 * Hide north panel.
	 */
	public void hideNorthPanel() {
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		// this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
		isHidden = true;
		menuHeight = 0;
		// crossPoint.setLocation(crossPoint.getX(), crossPoint.getY() +
		// menuHeight);
	}

	/**
	 * Show north panel.
	 */
	public void showNorthPanel() {
		this.setUI(oldUi);
		// this.putClientProperty("JInternalFrame.isPalette", Boolean.FALSE);
		// 去除边框
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		menuHeight = oldUi.getNorthPane().getHeight();
		// crossPoint.setLocation(crossPoint.getX(), crossPoint.getY() +
		// menuHeight);
		System.out.println(menuHeight);
		isHidden = false;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JInternalFrame#updateUI()
	 */
	public void updateUI() {
		if (isHidden) {
			hideNorthPanel();
		}
		super.updateUI();
	}

	/**
	 * @author Allen This method to resize all 4 panels once the container size
	 *         is changed.
	 * @param crossPoint
	 *            the point that split the window into 4 jPanels.
	 * @param jPanel1
	 *            the panel in the first (top right) of the four quadrant
	 * @param jPanel2
	 *            the pane2 in the second (top left) of the four quadrant
	 * @param jPanel3
	 *            the pane3 in the third (down left) of the four quadrant
	 * @param jPanel4
	 *            the pane4 in the forth (down right) of the four quadrant
	 */
	public void resizePanels(Point crossPoint) {
		kLinePanel.setBounds(new Rectangle(0, 0, (int) crossPoint.getX(), (int) crossPoint.getY()));
		jPanel1.setBounds(new Rectangle((int) crossPoint.getX(), 0, getWidth(), (int) crossPoint.getY()));
		jPanel3.setBounds(new Rectangle(0, (int) crossPoint.getY(), (int) crossPoint.getX(), getHeight()));
		jPanel4.setBounds(new Rectangle((int) crossPoint.getX(), (int) crossPoint.getY(), getWidth(), getHeight()));

	}

	public void addMyListener() {
		// 下面的代码用来调整4个窗口的尺寸
		mousePosition = new Point();
		MouseMotionListener borderAdjustment = new MouseAdapter() {
			// 用来区分沿x轴或y轴的边框调整
			private boolean xAxis = false;
			private boolean yAxis = false;

			@Override
			public void mouseMoved(MouseEvent e) {
				if (Math.abs(e.getPoint().getX() - (int) crossPoint.getX()) <= 1) {
					setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
					xAxis = true;
				} else if (Math.abs((e.getPoint().getY()) - (int) crossPoint.getY()) <= 1) {
					setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
					yAxis = true;
				} else {
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					xAxis = false;
					yAxis = false;

					statusBar.setText("Mouse location is " + mousePosition.getX() + "," + mousePosition.getY()
							+ " Crosspoint is " + crossPoint.getX() + "," + crossPoint.getY());
				}

				// 下面开始处理移动鼠标时的十字线绘图
				mousePosition = (Point) e.getPoint().clone();
				kLinePanel.setPos(mousePosition);
				quadrant1Pos.setLocation(mousePosition.x - kLinePanel.getWidth(), mousePosition.y);
				quadrant3Pos.setLocation(mousePosition.x, mousePosition.y - kLinePanel.getHeight());
				quadrant4Pos.setLocation(mousePosition.x - kLinePanel.getWidth(),
						mousePosition.y - kLinePanel.getHeight());
				jPanel1.setPos(quadrant1Pos);
				jPanel3.setPos(quadrant3Pos);
				jPanel4.setPos(quadrant4Pos);

				// repaint() 会重绘所有组件
				repaint();
				// jPanel1.repaint();
				// kLinePanel.repaint();
				// jPanel3.repaint();
				// jPanel4.repaint();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if (xAxis) {
					// k线窗口的宽度不小于总宽度的比例
					crossPointReLocation(e.getPoint().getX(), crossPoint.getY(), crossPoint);
					resizePanels(crossPoint);

				} else if (yAxis) {
					// k线窗口的高度不小于总高度的比例
					crossPointReLocation(crossPoint.getX(), e.getPoint().getY(), crossPoint);
					resizePanels(crossPoint);
				}

				mousePosition = (Point) e.getPoint().clone();
				kLinePanel.setPos(mousePosition);
				quadrant1Pos.setLocation(mousePosition.x - kLinePanel.getWidth(), mousePosition.y);
				quadrant3Pos.setLocation(mousePosition.x, mousePosition.y - kLinePanel.getHeight());
				quadrant4Pos.setLocation(mousePosition.x - kLinePanel.getWidth(),
						mousePosition.y - kLinePanel.getHeight());
				jPanel1.setPos(quadrant1Pos);
				jPanel3.setPos(quadrant3Pos);
				jPanel4.setPos(quadrant4Pos);

				repaint();
				// jPanel1.repaint();
				// kLinePanel.repaint();
				// jPanel3.repaint();
				// jPanel4.repaint();
			}
		};
		this.getContentPane().addMouseMotionListener(borderAdjustment);

		// 下面的代码用来在最大化时隐藏标题栏并将最小化，最大化，关闭按钮放在菜单栏的右侧
		ComponentListener windowControl = new ComponentAdapter() {
			int preWidth = getWidth();
			int preHeight = getHeight();

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				KLineFrame selectedFrame = (KLineFrame) e.getSource();

				if (selectedFrame.isMaximum()) {
					selectedFrame.hideNorthPanel();
					myMenuBar.getWindowControlPane().setVisible(true);
					try {
						selectedFrame.setMaximum(true);
					} catch (PropertyVetoException ex) {
						ex.printStackTrace();
					}

				}

				if (selectedFrame.isIcon()) {
					selectedFrame.showNorthPanel();
					myMenuBar.getWindowControlPane().setVisible(false);
					try {
						selectedFrame.setIcon(true);
					} catch (PropertyVetoException ex) {
						ex.printStackTrace();
					}
				}

				// 窗口更改大小后，相应调整4个panels的位置。
				Dimension newSize = e.getComponent().getSize();
				System.out.println("newSize is " + newSize.getWidth() + " , " + newSize.getHeight());
				System.out.println(preWidth + " , " + preHeight);
				crossPoint = crossPointReLocation(crossPointXRate * newSize.getWidth(),
						crossPointYRate * newSize.getHeight(), crossPoint);
				// crossPoint = crossPointReLocation(crossPoint.getX() *
				// newSize.getWidth() / preWidth,
				// crossPoint.getY() * newSize.getHeight() / preHeight,
				// crossPoint);
				resizePanels(crossPoint);
			}
		};
		this.addComponentListener(windowControl);
		
	}

	public void addPopupMenu(Component c) {
		JPopupMenu pMenu = new JPopupMenu();
	}

	private Point crossPointReLocation(double x, double y, Point point) {
		if (x >= getWidth() * MAXxRate) {
			x = getWidth() * MAXxRate;
		} else if (x <= getWidth() * MINxRate) {
			x = getWidth() * MINxRate;
		}

		if (y <= getHeight() * MINyRate) {
			y = getHeight() * MINyRate;
		} else if (y >= getHeight() * MAXyRate) {
			y = getHeight() * MAXyRate;
		}
		point.setLocation(x, y);
		crossPointXRate = x / getWidth();
		crossPointYRate = y / getHeight();
		return point;
	}

	public void setCrossPoint(Point crossPoint) {
		this.crossPoint = crossPoint;
		crossPointXRate = crossPoint.getX() / getWidth();
		crossPointYRate = crossPoint.getY() / getHeight();
	}

	public int getStockID() {
		return stockID;
	}

	public void setStockID(int stockID) {
		this.stockID = stockID;
	}

	public Point getCrossPoint() {
		return crossPoint;

	}

	public double getMINxRate() {
		// TODO Auto-generated method stub
		return MINxRate;
	}

	public double getMINyRate() {
		// TODO Auto-generated method stub
		return MINyRate;
	}
}

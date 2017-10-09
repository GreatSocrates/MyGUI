package MyGUI;

import java.awt.Dimension;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

class MyDesktopPane extends JDesktopPane
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyDesktopPane(int width, int height) {
		// TODO Auto-generated constructor stub
		this.setSize(width, height);
		this.setPreferredSize(new Dimension(width, height));
	}
	// �����д����Լ�����ʽ��ʾ,
	// ����offset���������ڵ�λ�ƾ���, s
	// cale���ڲ�������JDesktopPane�Ĵ�С����
	public void cascadeWindows(int offset , double scale)
	{
		// ���弶����ʾ����ʱ�ڲ����ڵĴ�С
		int width = (int)(getWidth() * scale);
		int height = (int)(getHeight() * scale);
		// ���ڱ��漶������ʱÿ�����ڵ�λ��
		int x = 0;
		int y = 0;
		for (JInternalFrame frame : getAllFrames())
		{
			try
			{
				// ȡ���ڲ����ڵ����,��С��
				frame.setMaximum(false);
				frame.setIcon(false);
				// �Ѵ������·�����ָ��λ��
				frame.reshape(x, y, width, height);
				x += offset;
				y += offset;
				// ���������������߽�
				if (x + width > getWidth()) x = 0;
				if (y + height > getHeight()) y = 0;
			}
			catch (PropertyVetoException e)
			{}
		}
	}
	// �����д�����ƽ�̷�ʽ��ʾ
	public void tileWindows()
	{
		// ͳ�����д���
		int frameCount = 0;
		for (JInternalFrame frame : getAllFrames())
		{
			frameCount++;
		}
		// ������Ҫ�����С������вſ���ƽ�����д���
		int rows = (int) Math.sqrt(frameCount);
		int cols = frameCount / rows;
		// ��Ҫ�������ӵ��������еĴ���
		int extra = frameCount % rows;
		// ����ƽ��ʱ�ڲ����ڵĴ�С
		int width = getWidth() / cols;
		int height = getHeight() / rows;
		// ���ڱ���ƽ�̴���ʱÿ�������ں��������ϵ�����
		int x = 0;
		int y = 0;
		for (JInternalFrame frame : getAllFrames())
		{
			try
			{
				// ȡ���ڲ����ڵ����,��С��
				frame.setMaximum(false);
				frame.setIcon(false);
				// �����ڷ���ָ��λ��
				frame.reshape(x * width, y * height, width, height);
				y++;
				// ÿ����һ�д���
				if (y == rows)
				{
					// ��ʼ�ŷ���һ�д���
					y = 0;
					x++;
					// ����������Ĵ�����ʣ�µ�������ȣ�
					// ����������ж���Ҫ������һ������
					if (extra == cols - x)
					{
						rows++;
						height = getHeight() / rows;
					}
				}
			}
			catch (PropertyVetoException e)
			{}
		}
	}
	// ѡ����һ����ͼ�괰��
	public void selectNextWindow()
	{
		JInternalFrame[] frames = getAllFrames();
		for (int i = 0; i < frames.length; i++)
		{
			if (frames[i].isSelected())
			{
				//  �ҳ���һ������С���Ĵ��ڣ�����ѡ������
				// ���ѡ��ʧ�ܣ����������ѡ����һ������
				int next = (i + 1) % frames.length;
				while (next != i)
				{
					// ����ô��ڲ��Ǵ�����С��״̬
					if (!frames[next].isIcon())
					{
						try
						{
							frames[next].setSelected(true);
							frames[next].toFront();
							frames[i].toBack();
							return;
						}
						catch (PropertyVetoException e)
						{}
					}
					next = (next + 1) % frames.length;
				}
			}
		}
	}
}

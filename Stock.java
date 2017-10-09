package MyGUI;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedList;

public class Stock {
	private String name;
	private String stockID;
	private EnumSet<MarketName> marketName=EnumSet.of(MarketName.SHANGHAI,MarketName.SHENZHEN);
	// zq=�ܹɱ���tq=��ͨ�̣�xstq=������ͨA�ɣ�jgq=�����ֲ� ��zyq=��Ѻ��ͨA��
	private int zq;
	private int tq;
	private int xstq;
	private int jgq;
	private int zyq;
	
	//����
	private boolean rong;
	
	//���
	private ArrayList<String>[] banKuai;
	
	//��Ʊ�۸�
	private LinkedList<StockPrice> stockPrices;

}

enum MarketName{
	SHANGHAI,SHENZHEN,HONGKONG
}
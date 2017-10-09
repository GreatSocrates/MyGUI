package MyGUI;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedList;

public class Stock {
	private String name;
	private String stockID;
	private EnumSet<MarketName> marketName=EnumSet.of(MarketName.SHANGHAI,MarketName.SHENZHEN);
	// zq=总股本，tq=流通盘，xstq=限售流通A股，jgq=机构持仓 ，zyq=质押流通A股
	private int zq;
	private int tq;
	private int xstq;
	private int jgq;
	private int zyq;
	
	//两融
	private boolean rong;
	
	//板块
	private ArrayList<String>[] banKuai;
	
	//股票价格
	private LinkedList<StockPrice> stockPrices;

}

enum MarketName{
	SHANGHAI,SHENZHEN,HONGKONG
}
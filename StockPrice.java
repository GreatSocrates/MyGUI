package MyGUI;

import java.util.Date;

public class StockPrice {
	// 交易时间，开盘价，收盘价，最高价，最低价，成交量
	private Date date;
	private double open;
	private double close;
	private double high;
	private double low;
	private int vol;
	
	
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	} 
}

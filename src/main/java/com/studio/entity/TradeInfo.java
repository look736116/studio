package com.studio.entity;

public class TradeInfo {
	
	private String tradeId;
	
	private String tradeServer;
	
	private int tradeCurrency;
	
	private int tradeMoney;
	
	private String tradeTime;
	
	private String tradeComment;

	public TradeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TradeInfo(String tradeId, String tradeServer, int tradeCurrency, int tradeMoney, String tradeTime,
			String tradeComment) {
		super();
		this.tradeId = tradeId;
		this.tradeServer = tradeServer;
		this.tradeCurrency = tradeCurrency;
		this.tradeMoney = tradeMoney;
		this.tradeTime = tradeTime;
		this.tradeComment = tradeComment;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getTradeServer() {
		return tradeServer;
	}

	public void setTradeServer(String tradeServer) {
		this.tradeServer = tradeServer;
	}

	public int getTradeCurrency() {
		return tradeCurrency;
	}

	public void setTradeCurrency(int tradeCurrency) {
		this.tradeCurrency = tradeCurrency;
	}

	public int getTradeMoney() {
		return tradeMoney;
	}

	public void setTradeMoney(int tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getTradeComment() {
		return tradeComment;
	}

	public void setTradeComment(String tradeComment) {
		this.tradeComment = tradeComment;
	}

	@Override
	public String toString() {
		return "TradeInfo [tradeId=" + tradeId + ", tradeServer=" + tradeServer + ", tradeCurrency=" + tradeCurrency
				+ ", tradeMoney=" + tradeMoney + ", tradeTime=" + tradeTime + ", tradeComment=" + tradeComment + "]";
	}	

}

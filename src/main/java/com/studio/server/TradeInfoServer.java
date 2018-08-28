package com.studio.server;

import java.util.List;

import com.studio.entity.TradeInfo;

public interface TradeInfoServer {
	
	 public Boolean addTradeInfo(TradeInfo tradeInfo);
	 
	 public List<TradeInfo> getAllTradeInfo();
	 
	 public List<TradeInfo> getTradeInfoByServer(String serverName);
		

}

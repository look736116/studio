package com.studio.dao;

import java.util.List;

import com.studio.entity.TradeInfo;

public interface TradeInfoDao {
	
//add new trade info
 public Boolean addTradeInfo(TradeInfo tradeInfo);
 
 //get all trades
 public List<TradeInfo> getAllTradeInfo();
 
 //get trades by server name
 public List<TradeInfo> getTradeInfoByServer(String serverName);
	

}

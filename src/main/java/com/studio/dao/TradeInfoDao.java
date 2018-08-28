package com.studio.dao;

import java.util.List;

import com.studio.entity.TradeInfo;

public interface TradeInfoDao {
	
 public Boolean addTradeInfo(TradeInfo tradeInfo);
 
 public List<TradeInfo> getAllTradeInfo();
 
 public List<TradeInfo> getTradeInfoByServer(String serverName);
	

}

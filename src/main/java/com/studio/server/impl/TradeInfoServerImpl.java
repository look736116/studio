package com.studio.server.impl;

import java.util.List;

import com.studio.dao.TradeInfoDao;
import com.studio.dao.impl.TradeInfoDaoImpl;
import com.studio.entity.TradeInfo;
import com.studio.server.TradeInfoServer;

public class TradeInfoServerImpl implements TradeInfoServer {
	private TradeInfoDao tid = new TradeInfoDaoImpl();

	@Override
	public Boolean addTradeInfo(TradeInfo tradeInfo) {
		// TODO Auto-generated method stub
		return tid.addTradeInfo(tradeInfo);
	}

	@Override
	public List<TradeInfo> getAllTradeInfo() {
		// TODO Auto-generated method stub
		return tid.getAllTradeInfo();
	}

	@Override
	public List<TradeInfo> getTradeInfoByServer(String serverName) {
		// TODO Auto-generated method stub
		return tid.getTradeInfoByServer(serverName);
	}

}

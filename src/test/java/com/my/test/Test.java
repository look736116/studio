package com.my.test;

import com.studio.dao.impl.RoleInfoDaoImpl;
import com.studio.dao.impl.TradeInfoDaoImpl;
import com.studio.entity.TradeInfo;

public class Test {
	public static void main(String[] args) {
		RoleInfoDaoImpl ridi = new RoleInfoDaoImpl();
		TradeInfoDaoImpl tidi = new TradeInfoDaoImpl();
		
		//System.out.println(roleInfoDaoImpl.getAllRoleInfo().size());
		//RoleInfo roleInfo = new RoleInfo("R06", "A03", "Pipi．", "逍遥", 50, "守望江湖");
		//System.out.println(roleInfoDaoImpl.addNewRole(roleInfo));
		//System.out.println(roleInfoDaoImpl.getRecordByRoleId("R02"));
		//System.out.println("2018年08月28日 17:41:55".substring(0,11));
		System.out.println(tidi.getAllTradeInfo().size());
		
		TradeInfo tradeInfo = new TradeInfo();
		tradeInfo.setTradeId("222");
		tradeInfo.setTradeServer("守望江湖");
		tradeInfo.setTradeCurrency(4485);
		tradeInfo.setTradeMoney(100);
		tradeInfo.setTradeTime("2018年8月29日 00:04:30");
		tradeInfo.setTradeComment("");
		System.out.println(tidi.addTradeInfo(tradeInfo));
	 
	}

}

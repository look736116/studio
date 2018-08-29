package com.my.test;

import com.studio.dao.impl.RoleInfoDaoImpl;
import com.studio.dao.impl.TradeInfoDaoImpl;
import com.studio.dao.impl.WeightInfoDaoImpl;
import com.studio.entity.TradeInfo;
import com.studio.entity.WeightInfo;

public class Test {
	public static void main(String[] args) {
		RoleInfoDaoImpl ridi = new RoleInfoDaoImpl();
		TradeInfoDaoImpl tidi = new TradeInfoDaoImpl();
		WeightInfoDaoImpl widi = new WeightInfoDaoImpl();

		// System.out.println(roleInfoDaoImpl.getAllRoleInfo().size());
		// RoleInfo roleInfo = new RoleInfo("R06", "A03", "Pipi．", "逍遥", 50,
		// "守望江湖");
		// System.out.println(roleInfoDaoImpl.addNewRole(roleInfo));
		// System.out.println(roleInfoDaoImpl.getRecordByRoleId("R02"));
		// System.out.println("2018年08月28日 17:41:55".substring(0,11));
		// System.out.println(tidi.getAllTradeInfo().size());
		//
		// TradeInfo tradeInfo = new TradeInfo();
		// tradeInfo.setTradeId("222");
		// tradeInfo.setTradeServer("守望江湖");
		// tradeInfo.setTradeCurrency(4485);
		// tradeInfo.setTradeMoney(100);
		// tradeInfo.setTradeTime("2018年8月29日 00:04:30");
		// tradeInfo.setTradeComment("");
		// System.out.println(tidi.addTradeInfo(tradeInfo));
		// System.out.println(widi.getAllWeightInfo().size());

		/*
		 * WeightInfo weightInfo = new WeightInfo(); weightInfo.setInfoId("22");
		 * weightInfo.setInfoHost("光光"); weightInfo.setInfoTime("20180909");
		 * weightInfo.setInfoDetails("肉肉"); weightInfo.setInfoNum(86.33);
		 * weightInfo.setInfoComment("就看见卡片机哦jojo品牌");
		 * 
		 * widi.addNewWeightInfo(weightInfo);
		 */
		System.out.println("2018年08月28日 17:41:55".subSequence(5, 11));

	}

}

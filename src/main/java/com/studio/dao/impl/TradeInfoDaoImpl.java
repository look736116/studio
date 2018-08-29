package com.studio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.studio.dao.TradeInfoDao;
import com.studio.entity.TradeInfo;
import com.studio.util.Utils;

public class TradeInfoDaoImpl implements TradeInfoDao {
	
	private static Logger logger = LogManager.getLogger(TradeInfoDaoImpl.class);


	@Override
	public Boolean addTradeInfo(TradeInfo tradeInfo) {
		// TODO Auto-generated method stub
		logger.info("Add tradeInfo to table!");
		PreparedStatement pre = null;
		ResultSet result = null;
		Boolean addFlag = false;
		int num = 0;

		Connection con = Utils.getConection();
		String sql = "insert into trade_info values (?,?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, tradeInfo.getTradeId());
			pre.setString(2, tradeInfo.getTradeServer());
			pre.setInt(3, tradeInfo.getTradeCurrency());
			pre.setInt(4, tradeInfo.getTradeMoney());
			pre.setString(5, tradeInfo.getTradeTime());
			pre.setString(6, tradeInfo.getTradeComment());
			num = pre.executeUpdate();
			if (num > 0) {
				addFlag = true;
				logger.info("Have added to table!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pre != null) {
					pre.close();
				}
				if (con != null) {
					con.close();
				}
				logger.info("Have closed database connetcion!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return addFlag;
	}

	@Override
	public List<TradeInfo> getAllTradeInfo() {
		// TODO Auto-generated method stub
		logger.info("Get all trade info form trade_info!");

		PreparedStatement pre = null;
		ResultSet result = null;

		TradeInfo tradeInfo = null;
		List<TradeInfo> trades = new ArrayList<>();
		Connection con = Utils.getConection();
		String sql = "select * from trade_info order by trade_server,trade_time";
		try {
			pre = con.prepareStatement(sql);
			result = pre.executeQuery();
			while (result.next()) {
				tradeInfo = new TradeInfo();
				tradeInfo.setTradeId(result.getString("trade_id"));
				tradeInfo.setTradeServer(result.getString("trade_server"));
				tradeInfo.setTradeCurrency(Integer.parseInt(result.getString("trade_game_currency")));
				tradeInfo.setTradeMoney(Integer.parseInt(result.getString("trade_money")));
				tradeInfo.setTradeTime(result.getString("trade_time"));
				tradeInfo.setTradeComment(result.getString("trade_comment"));
				trades.add(tradeInfo);		
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
					if (pre != null) {
						pre.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return trades;
	}

	@Override
	public List<TradeInfo> getTradeInfoByServer(String serverName) {
		// TODO Auto-generated method stub
		logger.info("Get all trade info form trade_info by server!");

		PreparedStatement pre = null;
		ResultSet result = null;

		TradeInfo tradeInfo = null;
		List<TradeInfo> trades = new ArrayList<>();
		Connection con = Utils.getConection();
		String sql = "select * from trade_info where trade_server = ?  order by trade_server,trade_time";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, serverName);
			result = pre.executeQuery();
			while (result.next()) {
				tradeInfo = new TradeInfo();
				tradeInfo.setTradeId(result.getString("trade_id"));
				tradeInfo.setTradeServer(result.getString("trade_server"));
				tradeInfo.setTradeCurrency(Integer.parseInt(result.getString("trade_game_currency")));
				tradeInfo.setTradeMoney(Integer.parseInt(result.getString("trade_money")));
				tradeInfo.setTradeTime(result.getString("trade_time"));
				tradeInfo.setTradeComment(result.getString("trade_comment"));
				trades.add(tradeInfo);						
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
					if (pre != null) {
						pre.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return trades;
	}

}

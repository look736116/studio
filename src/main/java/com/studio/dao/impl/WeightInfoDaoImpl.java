package com.studio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.studio.dao.WeightInfoDao;
import com.studio.entity.WeightInfo;
import com.studio.util.Utils;

public class WeightInfoDaoImpl implements WeightInfoDao {
	
	private static Logger logger = LogManager.getLogger(WeightInfoDaoImpl.class);


	@Override
	public Boolean addNewWeightInfo(WeightInfo weightInfo) {
		// TODO Auto-generated method stub
		logger.info("Add roleInfo to table!");
		PreparedStatement pre = null;
		Boolean addFlag = false;
		int num = 0;

		Connection con = Utils.getConection();
		String sql = "insert into weight_info values (?,?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, weightInfo.getInfoId());
			pre.setString(2, weightInfo.getInfoHost());
			pre.setString(3, weightInfo.getInfoTime());
			pre.setString(4, weightInfo.getInfoDetails());
			pre.setDouble(5, weightInfo.getInfoNum());
			pre.setString(6, weightInfo.getInfoComment());
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
	public List<WeightInfo> getAllWeightInfo() {
		// TODO Auto-generated method stub
		logger.info("Get all weight info  form weight_info!");

		PreparedStatement pre = null;
		ResultSet result = null;

		WeightInfo weightInfo = null;
		List<WeightInfo> infos = new ArrayList<>();
		Connection con = Utils.getConection();
		String sql = "select * from weight_info order by info_host,info_time";
		try {
			pre = con.prepareStatement(sql);
			result = pre.executeQuery();
			while (result.next()) {
				weightInfo = new WeightInfo();
				weightInfo.setInfoId(result.getString("info_id"));
				weightInfo.setInfoHost(result.getString("info_host"));
				weightInfo.setInfoTime(result.getString("info_time"));
				weightInfo.setInfoDetails(result.getString("info_details"));
				weightInfo.setInfoNum(Double.parseDouble(result.getString("info_num")));
				String comment = result.getString("info_comment");
				if(comment!=null){
				weightInfo.setInfoComment(comment);
				}else{
					weightInfo.setInfoComment("");	
				}
				infos.add(weightInfo);
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
		
		return infos;
	}

}

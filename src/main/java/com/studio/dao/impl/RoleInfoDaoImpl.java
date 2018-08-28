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

import com.studio.dao.RoleInfoDao;
import com.studio.entity.Record;
import com.studio.entity.RoleInfo;
import com.studio.util.DataBaseUtils;

public class RoleInfoDaoImpl implements RoleInfoDao {

	private static Logger logger = LogManager.getLogger(RoleInfoDaoImpl.class);

	@Override
	public List<RoleInfo> getAllRoleInfo() {
		// TODO Auto-generated method stub
		logger.info("Get all role info form my_info!");

		PreparedStatement pre = null;
		ResultSet result = null;
		ResultSetMetaData metaData = null;

		RoleInfo roleInfo = null;
		List<RoleInfo> roles = new ArrayList<>();
		Connection con = DataBaseUtils.getConection();
		String sql = "select * from role_info order by role_server,role_account,role_order";
		try {
			pre = con.prepareStatement(sql);
			result = pre.executeQuery();
			metaData = result.getMetaData();
			while (result.next()) {
				roleInfo = new RoleInfo();
				roleInfo.setRole_id(result.getString("role_id"));
				roleInfo.setRole_account(result.getString("role_account"));
				roleInfo.setRole_name(result.getString("role_name"));
				roleInfo.setRole_sect(result.getString("role_sect"));
				roleInfo.setRole_grade(result.getInt("role_grade"));
				roleInfo.setRole_server(result.getString("role_server"));
				roles.add(roleInfo);
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

		return roles;
	}

	@Override
	public boolean addNewRole(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		logger.info("Add roleInfo to table!");
		PreparedStatement pre = null;
		ResultSet result = null;
		ResultSetMetaData metaData = null;
		Boolean addFlag = false;
		int num = 0;

		Connection con = DataBaseUtils.getConection();
		String sql = "insert into role_info values (?,?,?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, roleInfo.getRole_id());
			pre.setString(2, roleInfo.getRole_account());
			pre.setString(3, roleInfo.getRole_name());
			pre.setString(4, roleInfo.getRole_sect());
			pre.setInt(5, roleInfo.getRole_grade());
			pre.setString(6, roleInfo.getRole_server());
			pre.setInt(7,roleInfo.getRole_order());
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
	public RoleInfo findRoleInfoById(String roleId) {
		// TODO Auto-generated method stub
		logger.info("Find roleInfo by id!");
		PreparedStatement pre = null;
		ResultSet result = null;

		RoleInfo roleInfo = null;
		Connection con = DataBaseUtils.getConection();
		String sql = "select * from role_info where role_id = ?";		
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, roleId);
			result = pre.executeQuery();
			while (result.next()) {
				roleInfo = new RoleInfo();
				roleInfo.setRole_id(result.getString("role_id"));
				roleInfo.setRole_account(result.getString("role_account"));
				roleInfo.setRole_name(result.getString("role_name"));
				roleInfo.setRole_sect(result.getString("role_sect"));
				roleInfo.setRole_grade(result.getInt("role_grade"));
				roleInfo.setRole_server(result.getString("role_server"));
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
		
		return roleInfo;
	}

	@Override
	public boolean addNewRecord(Record record) {
		// TODO Auto-generated method stub
		logger.info("Add record!");
		PreparedStatement pre = null;
		Boolean addFlag = false;
		int num = 0;

		Connection con = DataBaseUtils.getConection();
		String sql = "insert into record values (?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1,record.getRecordId());
			pre.setString(2, record.getRoleId());
			pre.setString(3,record.getRecordTime());
			pre.setString(4,record.getRecordNum());	
			pre.setString(5,"暂无！");	
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
	public Record getRecordByRoleId(String roleId) {
		// TODO Auto-generated method stub
		logger.info("Get records info form record!");

		PreparedStatement pre = null;
		ResultSet result = null;

		Record record = null;
		Connection con = DataBaseUtils.getConection();
		String sql = "select * from record where role_id = ?  order by record_time desc limit 1";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, roleId);
			result = pre.executeQuery();
			while (result.next()) {
				record = new Record();
				record.setRecordId(result.getString("record_id"));
				record.setRoleId(result.getString("role_id"));
				record.setRecordTime(result.getString("record_time"));
				record.setRecordNum(result.getString("record_num"));
				record.setRecordComment(result.getString("record_comment"));
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

		return record;
	}

	@Override
	public List<RoleInfo> getRolesByServer(String roleServer) {
		// TODO Auto-generated method stub
		logger.info("Get all role info form my_info!");

		PreparedStatement pre = null;
		ResultSet result = null;
		ResultSetMetaData metaData = null;

		RoleInfo roleInfo = null;
		List<RoleInfo> roles = new ArrayList<>();
		Connection con = DataBaseUtils.getConection();
		String sql = "select * from role_info where role_server =? order by role_server,role_account,role_order";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, roleServer);
			result = pre.executeQuery();
			metaData = result.getMetaData();
			while (result.next()) {
				roleInfo = new RoleInfo();
				roleInfo.setRole_id(result.getString("role_id"));
				roleInfo.setRole_account(result.getString("role_account"));
				roleInfo.setRole_name(result.getString("role_name"));
				roleInfo.setRole_sect(result.getString("role_sect"));
				roleInfo.setRole_grade(result.getInt("role_grade"));
				roleInfo.setRole_server(result.getString("role_server"));
				roles.add(roleInfo);
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

		return roles;
	}

}

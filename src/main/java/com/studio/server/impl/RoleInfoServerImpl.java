package com.studio.server.impl;

import java.util.List;

import com.studio.dao.RoleInfoDao;
import com.studio.dao.impl.RoleInfoDaoImpl;
import com.studio.entity.Record;
import com.studio.entity.RoleInfo;
import com.studio.server.RoleInfoServer;

public class RoleInfoServerImpl implements RoleInfoServer {
 private RoleInfoDao rid = new RoleInfoDaoImpl();
	@Override
	public List<RoleInfo> getAllRoleInfo() {
		// TODO Auto-generated method stub
		return rid.getAllRoleInfo();
	}

	@Override
	public boolean addNewRole(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		return rid.addNewRole(roleInfo);
	}

	@Override
	public RoleInfo getRoleInfoById(String roleId) {
		// TODO Auto-generated method stub
		return rid.findRoleInfoById(roleId);
	}

	@Override
	public boolean addNewRecord(Record record) {
		// TODO Auto-generated method stub
		return rid.addNewRecord(record);
	}

	@Override
	public Record getRecordByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return rid.getRecordByRoleId(roleId);
	}

	@Override
	public List<RoleInfo> getRolesByServer(String roleServer) {
		// TODO Auto-generated method stub
		return rid.getRolesByServer(roleServer);
	}
	
	

	

}

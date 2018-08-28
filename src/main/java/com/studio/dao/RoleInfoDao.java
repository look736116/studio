package com.studio.dao;

import java.util.List;

import com.studio.entity.Record;
import com.studio.entity.RoleInfo;

public interface RoleInfoDao {
	public List<RoleInfo> getAllRoleInfo();
	
	public boolean addNewRole(RoleInfo roleInfo);
	
	public RoleInfo findRoleInfoById(String roleId);
	
	public boolean addNewRecord(Record record);
	
	public Record getRecordByRoleId(String roleId);
	
	public List<RoleInfo> getRolesByServer(String roleServer);

}

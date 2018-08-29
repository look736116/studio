package com.studio.dao;

import java.util.List;

import com.studio.entity.RecordInfo;
import com.studio.entity.RoleInfo;

public interface RoleInfoDao {
	
	//get all roles info
	public List<RoleInfo> getAllRoleInfo();
	
	//add new role 
	public boolean addNewRole(RoleInfo roleInfo);
	
	//find role by id
	public RoleInfo findRoleInfoById(String roleId);
	
	//add new record
	public boolean addNewRecord(RecordInfo recordInfo);
	
	//get records by id
	public RecordInfo getRecordByRoleId(String roleId);
	
	//get role by server name
	public List<RoleInfo> getRolesByServer(String roleServer);

}

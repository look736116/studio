package com.studio.server;

import java.util.List;

import com.studio.entity.Record;
import com.studio.entity.RoleInfo;

public interface RoleInfoServer {
	
	public List<RoleInfo> getAllRoleInfo();
	
	public boolean addNewRole(RoleInfo roleInfo);
	
	public RoleInfo getRoleInfoById(String roleId);
	
	public boolean addNewRecord(Record record);
	
	public Record getRecordByRoleId(String roleId);
	
	//get roles by server name
	public List<RoleInfo> getRolesByServer(String roleServer);

}

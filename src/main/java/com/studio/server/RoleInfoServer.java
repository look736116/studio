package com.studio.server;

import java.util.List;

import com.studio.entity.RecordInfo;
import com.studio.entity.RoleInfo;

public interface RoleInfoServer {
	
	public List<RoleInfo> getAllRoleInfo();
	
	public boolean addNewRole(RoleInfo roleInfo);
	
	public RoleInfo getRoleInfoById(String roleId);
	
	public boolean addNewRecord(RecordInfo recordInfo);
	
	public RecordInfo getRecordByRoleId(String roleId);
	
	//get roles by server name
	public List<RoleInfo> getRolesByServer(String roleServer);

}

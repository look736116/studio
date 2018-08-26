package com.studio.server;

import java.util.List;

import com.studio.entity.RoleInfo;

public interface RoleInfoServer {
	public List<RoleInfo> getAllRoleInfo();
	public boolean addNewRole(RoleInfo roleInfo);

}

package com.studio.server.impl;

import java.util.List;

import com.studio.dao.impl.RoleInfoDaoImpl;
import com.studio.entity.RoleInfo;
import com.studio.server.RoleInfoServer;

public class RoleInfoServerImpl implements RoleInfoServer {

	@Override
	public List<RoleInfo> getAllRoleInfo() {
		// TODO Auto-generated method stub
		return new RoleInfoDaoImpl().getAllRoleInfo();
	}

	@Override
	public boolean addNewRole(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		return new RoleInfoDaoImpl().addNewRole(roleInfo);
	}

}

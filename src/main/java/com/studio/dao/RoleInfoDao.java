package com.studio.dao;

import java.util.List;

import com.studio.entity.RoleInfo;

public interface RoleInfoDao {
	public List<RoleInfo> getAllRoleInfo();
	public boolean addNewRole(RoleInfo roleInfo);

}

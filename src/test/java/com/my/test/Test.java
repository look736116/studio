package com.my.test;

import com.studio.dao.impl.RoleInfoDaoImpl;
import com.studio.entity.RoleInfo;

public class Test {
	public static void main(String[] args) {
		RoleInfoDaoImpl roleInfoDaoImpl = new RoleInfoDaoImpl();
		
		//System.out.println(roleInfoDaoImpl.getAllRoleInfo().size());
		RoleInfo roleInfo = new RoleInfo("R06", "A03", "Pipi．", "逍遥", 50, "守望江湖");
		System.out.println(roleInfoDaoImpl.addNewRole(roleInfo));
	 
	}

}

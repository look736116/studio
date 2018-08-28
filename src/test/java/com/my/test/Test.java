package com.my.test;

import com.studio.dao.impl.RoleInfoDaoImpl;
import com.studio.entity.RoleInfo;

public class Test {
	public static void main(String[] args) {
		RoleInfoDaoImpl ridi = new RoleInfoDaoImpl();
		
		//System.out.println(roleInfoDaoImpl.getAllRoleInfo().size());
		//RoleInfo roleInfo = new RoleInfo("R06", "A03", "Pipi．", "逍遥", 50, "守望江湖");
		//System.out.println(roleInfoDaoImpl.addNewRole(roleInfo));
		//System.out.println(roleInfoDaoImpl.getRecordByRoleId("R02"));
		//System.out.println("2018年08月28日 17:41:55".substring(0,11));
		System.out.println(ridi.getRolesByServer("一梦十年"));
	 
	}

}

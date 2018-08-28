package com.studio.entity;

public class RoleInfo {
	private String role_id;
	private String role_account;
	private String role_name;
	private String role_sect;
	private int role_grade;
	private String role_server;
	private int role_order;
	
	

	public RoleInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleInfo(String role_id, String role_account, String role_name, String role_sect, int role_grade,
			String role_server) {
		super();
		this.role_id = role_id;
		this.role_account = role_account;
		this.role_name = role_name;
		this.role_sect = role_sect;
		this.role_grade = role_grade;
		this.role_server = role_server;
	}

	
	public RoleInfo(String role_id, String role_account, String role_name, String role_sect, int role_grade,
			String role_server, int role_order) {
		super();
		this.role_id = role_id;
		this.role_account = role_account;
		this.role_name = role_name;
		this.role_sect = role_sect;
		this.role_grade = role_grade;
		this.role_server = role_server;
		this.role_order = role_order;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_account() {
		return role_account;
	}

	public void setRole_account(String role_account) {
		this.role_account = role_account;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_sect() {
		return role_sect;
	}

	public void setRole_sect(String role_sect) {
		this.role_sect = role_sect;
	}

	public int getRole_grade() {
		return role_grade;
	}

	public void setRole_grade(int role_grade) {
		this.role_grade = role_grade;
	}

	public String getRole_server() {
		return role_server;
	}

	public void setRole_server(String role_server) {
		this.role_server = role_server;
	}

	public int getRole_order() {
		return role_order;
	}

	public void setRole_order(int role_order) {
		this.role_order = role_order;
	}

	@Override
	public String toString() {
		return "RoleInfo [role_id=" + role_id + ", role_account=" + role_account + ", role_name=" + role_name
				+ ", role_sect=" + role_sect + ", role_grade=" + role_grade + ", role_server=" + role_server + "]";
	}

}

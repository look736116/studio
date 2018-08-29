package com.studio.entity;

public class RecordInfo {
	private String recordId;
	private String roleId;
	private String recordTime;
	private String recordNum;
	private String recordComment;
	public RecordInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RecordInfo(String recordId, String roleId, String recordTime, String recordNum) {
		super();
		this.recordId = recordId;
		this.roleId = roleId;
		this.recordTime = recordTime;
		this.recordNum = recordNum;
	}

	public RecordInfo(String recordId, String roleId, String recordTime, String recordNum, String recordComment) {
		super();
		this.recordId = recordId;
		this.roleId = roleId;
		this.recordTime = recordTime;
		this.recordNum = recordNum;
		this.recordComment = recordComment;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	public String getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}

	public String getRecordComment() {
		return recordComment;
	}

	public void setRecordComment(String recordComment) {
		this.recordComment = recordComment;
	}

	@Override
	public String toString() {
		return "Record [recordId=" + recordId + ", roleId=" + roleId + ", recordTime=" + recordTime + ", recordNum="
				+ recordNum + ", recordComment=" + recordComment + "]";
	}
	

}

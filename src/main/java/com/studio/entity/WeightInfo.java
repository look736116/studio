package com.studio.entity;

public class WeightInfo {
	
	private String  infoId;
	
	private String infoHost;
	
	private String infoTime;
	
	private String infoDetails;
	
	private Double infoNum;
	
	private String infoComment;

	public WeightInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public WeightInfo(String infoId, String infoHost, String infoTime, String infoDetails, Double infoNum,
			String infoComment) {
		super();
		this.infoId = infoId;
		this.infoHost = infoHost;
		this.infoTime = infoTime;
		this.infoDetails = infoDetails;
		this.infoNum = infoNum;
		this.infoComment = infoComment;
	}



	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public String getInfoHost() {
		return infoHost;
	}

	public void setInfoHost(String infoHost) {
		this.infoHost = infoHost;
	}

	
	public String getInfoTime() {
		return infoTime;
	}



	public void setInfoTime(String infoTime) {
		this.infoTime = infoTime;
	}



	public String getInfoDetails() {
		return infoDetails;
	}

	public void setInfoDetails(String infoDetails) {
		this.infoDetails = infoDetails;
	}

	public Double getInfoNum() {
		return infoNum;
	}

	public void setInfoNum(Double infoNum) {
		this.infoNum = infoNum;
	}

	public String getInfoComment() {
		return infoComment;
	}

	public void setInfoComment(String infoComment) {
		this.infoComment = infoComment;
	}



	@Override
	public String toString() {
		return "WeightInfo [infoId=" + infoId + ", infoHost=" + infoHost + ", infoTime=" + infoTime + ", infoDetails="
				+ infoDetails + ", infoNum=" + infoNum + ", infoComment=" + infoComment + "]";
	}

	
	
	
}

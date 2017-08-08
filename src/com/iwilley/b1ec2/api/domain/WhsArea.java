package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class WhsArea extends B1EC2Object {
	private static final long serialVersionUID = 2206401702136385704L;

	// ����ID
	@ApiField("WhsAreaId")
	private int whsAreaId;

	// �������,10
	@ApiField("WhsAreaCode")
	private String whsAreaCode;

	// ������,10
	@ApiField("AreaName")
	private String areaName;

	// ����Ƿ����
	@ApiField("IsAvailable")
	private Boolean available;

	public int getWhsAreaId() {
		return whsAreaId;
	}

	public String getWhsAreaCode() {
		return whsAreaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setWhsAreaId(int whsAreaId) {
		this.whsAreaId = whsAreaId;
	}

	public void setWhsAreaCode(String whsAreaCode) {
		this.whsAreaCode = whsAreaCode;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}

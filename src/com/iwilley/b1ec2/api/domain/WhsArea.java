package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class WhsArea extends B1EC2Object {
	private static final long serialVersionUID = 2206401702136385704L;

	// 库区ID
	@ApiField("WhsAreaId")
	private int whsAreaId;

	// 库区编号,10
	@ApiField("WhsAreaCode")
	private String whsAreaCode;

	// 库区名,10
	@ApiField("AreaName")
	private String areaName;

	// 库存是否可用
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

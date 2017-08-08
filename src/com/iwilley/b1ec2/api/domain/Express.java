package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class Express extends B1EC2Object {
	
	private static final long serialVersionUID = 895457757675322378L;

	//快递ID
    @ApiField("ExpressId")
    public int expressId;

    //快递编码,8,不唯一
    @ApiField("ExpressCode")
    public String expressCode;

    //快递名称
    @ApiField("ExpressName")
    public String expressName;

    //配送优先级
    @ApiField("ShipLevel")
    public int shipLevel;

	public int getExpressId() {
		return expressId;
	}

	public void setExpressId(int expressId) {
		this.expressId = expressId;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public int getShipLevel() {
		return shipLevel;
	}

	public void setShipLevel(int shipLevel) {
		this.shipLevel = shipLevel;
	}
    
    
    
}

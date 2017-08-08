package com.iwilley.b1ec2.api.response;

import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class BomCreateResponse extends B1EC2Response {

	private static final long serialVersionUID = 8855458336863795935L;
	
	@ApiField("BomId")
	public String bomId;

	public String getBomId() {
		return bomId;
	}

	public void setBomId(String bomId) {
		this.bomId = bomId;
	}
}

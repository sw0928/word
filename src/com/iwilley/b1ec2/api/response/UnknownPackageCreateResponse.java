package com.iwilley.b1ec2.api.response;

import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class UnknownPackageCreateResponse extends B1EC2Response {

	private static final long serialVersionUID = -9090253975563534021L;

	@ApiField("AfterSaleServiceNo")
	public String afterSaleServiceNo;

	public String getAfterSaleServiceNo() {
		return afterSaleServiceNo;
	}

	public void setAfterSaleServiceNo(String afterSaleServiceNo) {
		this.afterSaleServiceNo = afterSaleServiceNo;
	}
}

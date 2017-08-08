package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

//订单拦截原因
public class HoldingReason extends B1EC2Object {

	private static final long serialVersionUID = 9087749773348764448L;

	//原因ID
    @ApiField("ReasonId")
    public int reasonId;

    //原因名称
    @ApiField("ReasonName")
    public String reasonName;

	public int getReasonId() {
		return reasonId;
	}

	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}

	public String getReasonName() {
		return reasonName;
	}

	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}
}

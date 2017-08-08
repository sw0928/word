package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

//��������ԭ��
public class HoldingReason extends B1EC2Object {

	private static final long serialVersionUID = 9087749773348764448L;

	//ԭ��ID
    @ApiField("ReasonId")
    public int reasonId;

    //ԭ������
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

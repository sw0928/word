package com.iwilley.b1ec2.api;

import java.io.Serializable;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

/**
 * 基础响应信息
 * 
 */
public abstract class B1EC2Response implements Serializable {

	private static final long serialVersionUID = -7409053753353171766L;

	@ApiField("ErrorCode")
	private int errorCode;

	@ApiField("ErrorMsg")
	private String errorMsg;

	private String body;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}

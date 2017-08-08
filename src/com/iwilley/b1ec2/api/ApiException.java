package com.iwilley.b1ec2.api;

/**
 * øÕªß∂À“Ï≥£°£
 * 
 */
public class ApiException extends Exception {

	private static final long serialVersionUID = 3292591336033190903L;
	
	private int errCode;
	private String errMsg;

	public ApiException() {
		super();
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiException(String message) {
		super(message);
	}

	public ApiException(Throwable cause) {
		super(cause);
	}

	public ApiException(int errCode, String errMsg) {
		super(errCode + ":" + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public int getErrCode() {
		return this.errCode;
	}

	public String getErrMsg() {
		return this.errMsg;
	}

}

package com.iwilley.b1ec2.api;

import java.io.IOException;

import com.iwilley.b1ec2.api.internal.util.*;
import com.iwilley.b1ec2.api.parser.*;

/**
 * SDK客户端对象
 *
 */
public class B1EC2Client {
    private static final String COMPANY = "Company";
    private static final String LOGIN_NAME = "LoginName";
    private static final String PASSWORD = "Password";
    private static final String METHOD = "Method";
    private static final String VERSION = "Version";
    
	private int connectTimeout = 3000;//3秒
	private int readTimeout = 15000;//15秒
	
	private String url;
	private String company;
	private String loginName;
	private String password;
	private String proxyHostName=null;
	private int proxyPort;
	
	public B1EC2Client(String url, String company, String loginName, String password) {
		this.url = url;
		this.company = company;
		this.loginName = loginName;
		this.password = password;
	}
	
	public B1EC2Client(String url, String company, String loginName, String password,String proxyHostName,int proxyPort) {
		this.url = url;
		this.company = company;
		this.loginName = loginName;
		this.password = password;
		this.proxyHostName = proxyHostName;
		this.proxyPort = proxyPort;
	}
	
	public <T extends B1EC2Response> T execute(B1EC2Request<T> request) throws ApiException {
		String body = doPost(request);
		if(StringUtils.isEmpty(body)) {
			return null;
		}
		
		B1EC2Parser<T> parser = new B1EC2JsonParser<T>(request.getResponseClass());
		T response = parser.parse(body);
		response.setBody(body);
		return response;
	}
	
	private <T extends B1EC2Response> String doPost(B1EC2Request<T> request) throws ApiException {
		try {
			B1EC2HashMap headerMap = new B1EC2HashMap();
	        headerMap.put(COMPANY, Base64.encodeToString(company.getBytes(Constants.CHARSET_UTF8), false));
	        headerMap.put(LOGIN_NAME, Base64.encodeToString(loginName.getBytes(Constants.CHARSET_UTF8), false));
	        headerMap.put(PASSWORD, Base64.encodeToString(password.getBytes(Constants.CHARSET_UTF8), false));//简单加密处理
			headerMap.put(METHOD, request.getApiMethodName());
			headerMap.put(VERSION, "1.0");
	        
			B1EC2HashMap parameters = new B1EC2HashMap(request.GetParameters());
			return WebUtils.doPost(url,proxyHostName, proxyPort,parameters, Constants.CHARSET_UTF8, connectTimeout, readTimeout, headerMap);
		} catch (IOException e) {
			throw new ApiException(e);
		}
	}
	
}

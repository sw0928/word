package com.iwilley.b1ec2.sample;

import java.text.ParseException;
import java.util.Date;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.SalesOrderUpdateRequest;
import com.iwilley.b1ec2.api.response.SalesOrderUpdateResponse;

public class SalesOrderUpdateSample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		SalesOrderUpdateRequest request = new SalesOrderUpdateRequest();
		request.setOrderId(63);
		request.setUserDefinedField1("test1");
		request.setUserDefinedField8(new Date());
		request.setUserDefinedField11("我是最后一个自定义字段");

		SalesOrderUpdateResponse response = client.execute(request);
		System.out.println(response.getBody());
	}

}
package com.iwilley.b1ec2.sample;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.SalesOrderCancelRequest;
import com.iwilley.b1ec2.api.response.SalesOrderCancelResponse;

public class SalesOrderCancelSample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		
		SalesOrderCancelRequest request = new SalesOrderCancelRequest();
		//request.orderId = 1;
		request.shopOrderNo = "969408746532838";
		SalesOrderCancelResponse response = client.execute(request);
		System.out.println(response.getBody());
	}
}

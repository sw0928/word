package com.iwilley.b1ec2.sample;

import java.text.ParseException;
import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.SalesOrderDeliverRequest;
import com.iwilley.b1ec2.api.response.SalesOrderDeliverResponse;

public class SalesOrderDeliverSample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		SalesOrderDeliverRequest request = new SalesOrderDeliverRequest();
		request.setOrderId(63);
		request.setExpressId(8);
		request.setExpressTrackNo("1234554321");
		request.setWeight(15.5);

		SalesOrderDeliverResponse response = client.execute(request);
		System.out.println(response.getBody());
	}

}
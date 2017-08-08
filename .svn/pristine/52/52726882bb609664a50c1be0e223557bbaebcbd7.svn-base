package com.iwilley.b1ec2.sample;

import java.text.ParseException;
import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.StockUpdateRequest;
import com.iwilley.b1ec2.api.response.StockUpdateResponse;

public class StockUpdateSample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		StockUpdateRequest request = new StockUpdateRequest();
		request.setStock("1010:5040168250:1:2.5;1020:5040168250:2:2.5;");

		StockUpdateResponse response = client.execute(request);
		System.out.println(response.getBody());
	}

}
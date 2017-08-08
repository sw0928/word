package com.iwilley.b1ec2.sample;

import java.util.ArrayList;
import java.util.List;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.StockQueryRequest;
import com.iwilley.b1ec2.api.response.StockQueryResponse;

public class StockQuerySample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		StockQueryRequest request = new StockQueryRequest();
		List<String> list = new ArrayList<String>();
		list.add("NB0201M01");
		request.setSkus(list);
		StockQueryResponse response = client.execute(request);
		System.out.println(response.getBody());
	}
}

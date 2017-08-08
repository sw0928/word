package com.iwilley.b1ec2.sample;

import java.util.ArrayList;
import java.util.List;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.SalesOrderCreateLine;
import com.iwilley.b1ec2.api.request.SalesOrderCreateRequest;
import com.iwilley.b1ec2.api.response.SalesOrderCreateResponse;

public class SalesOrderCreateSample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		SalesOrderCreateRequest request = new SalesOrderCreateRequest();
		request.shopId = 4;
		request.whsId = 1;
		request.expressId = 8;
		request.customerName = "yoha";
		List<SalesOrderCreateLine> lineList = new ArrayList<SalesOrderCreateLine>();
		SalesOrderCreateLine line1 = new SalesOrderCreateLine();
		line1.skuCode = "test01001002";
		line1.quantity = 10;
		line1.price = 10.2;
		lineList.add(line1);
		SalesOrderCreateLine line2 = new SalesOrderCreateLine();
		line2.skuCode = "test01001002";
		line2.quantity = 10;
		line2.price = 10.2;
		lineList.add(line2);
		request.setItemLines(lineList);
		SalesOrderCreateResponse response = client.execute(request);
		System.out.println(response.getBody());
	}
}

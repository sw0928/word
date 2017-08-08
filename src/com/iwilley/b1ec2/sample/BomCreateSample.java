package com.iwilley.b1ec2.sample;

import java.util.ArrayList;
import java.util.List;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.BomCreateLine;
import com.iwilley.b1ec2.api.request.BomCreateRequest;
import com.iwilley.b1ec2.api.response.BomCreateResponse;

public class BomCreateSample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		
		BomCreateRequest request = new BomCreateRequest();
		
		request.setSkuCode("CQ00411");
		
		List<BomCreateLine> bomLines = new ArrayList<BomCreateLine>();
		BomCreateLine sku1 = new BomCreateLine();
		sku1.setSkuCode("cqcs001");
		sku1.setQuantity(10);
		bomLines.add(sku1);
		BomCreateLine sku2 = new BomCreateLine();
		sku2.setSkuCode("cqcs002");
		sku2.setQuantity(5);
		bomLines.add(sku2);
		request.setBomLines(bomLines);
		
		BomCreateResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println("errorCode:" + response.getErrorCode() + ",errorMessage" + response.getErrorMsg());
	}
}

package com.iwilley.b1ec2.sample;

import java.text.ParseException;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.AfterSalesServiceReceiptRequest;
import com.iwilley.b1ec2.api.response.AfterSalesServiceReceiptResponse;

public class AfterSalesServiceReceiptSample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		AfterSalesServiceReceiptRequest request = new AfterSalesServiceReceiptRequest();
		request.setAfterSaleServiceId(1);

		AfterSalesServiceReceiptResponse response = client.execute(request);
		System.out.println(response.getBody());
	}

}
package com.iwilley.b1ec2.sample;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.RefundReasonQueryRequest;
import com.iwilley.b1ec2.api.response.RefundReasonQueryResponse;

public class RefundReasonQuerySample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		RefundReasonQueryRequest request = new RefundReasonQueryRequest();
		RefundReasonQueryResponse response = client.execute(request);
		System.out.println(response.getBody());
	}
}

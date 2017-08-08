package com.iwilley.b1ec2.sample;
import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.SalesOrderPickOutRequest;
import com.iwilley.b1ec2.api.response.SalesOrderPickOutResponse;
public class SalesOrderPickOutSample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		SalesOrderPickOutRequest request = new SalesOrderPickOutRequest();
		request.OrderNo = "20160302003565";
		SalesOrderPickOutResponse response = client.execute(request);
		System.out.println(response.getBody());
	}
}

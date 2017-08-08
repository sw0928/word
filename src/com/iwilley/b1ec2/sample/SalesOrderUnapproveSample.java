package com.iwilley.b1ec2.sample;
import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.SalesOrderUnapproveRequest;
import com.iwilley.b1ec2.api.response.SalesOrderUnapproveResponse;
public class SalesOrderUnapproveSample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		SalesOrderUnapproveRequest request = new SalesOrderUnapproveRequest();
		request.OrderNo = "11367907983";
		SalesOrderUnapproveResponse response = client.execute(request);
		System.out.println(response.getBody());
	}
}

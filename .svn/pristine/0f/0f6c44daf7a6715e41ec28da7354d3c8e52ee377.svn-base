package com.iwilley.b1ec2.sample;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.AfterSalesServiceUpdateRequest;
import com.iwilley.b1ec2.api.response.AfterSalesServiceUpdateResponse;

public class AfterSalesServiceUpdateSample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		
		AfterSalesServiceUpdateRequest request = new AfterSalesServiceUpdateRequest();
		
		request.setAfterSaleServiceId(80);
		request.setUserDefinedField1("java ÐÞ¸Ä1");
		request.setUserDefinedField2("java ÐÞ¸Ä2");
		
		AfterSalesServiceUpdateResponse response = client.execute(request);
		System.out.println(response.getBody());
        System.out.println("errorCode:"+response.getErrorCode()+",errorMessage"+response.getErrorMsg());
	}
}

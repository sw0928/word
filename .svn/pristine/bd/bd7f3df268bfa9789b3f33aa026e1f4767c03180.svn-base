package com.iwilley.b1ec2.sample;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.Category;
import com.iwilley.b1ec2.api.request.CategoryQueryRequest;
import com.iwilley.b1ec2.api.response.CategoryQueryResponse;

public class CategoryQuerySample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		
		CategoryQueryRequest request = new CategoryQueryRequest();
		
		CategoryQueryResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println("errorCode:" + response.getErrorCode()
				+ ",errorMessage" + response.getErrorMsg());
		for (Category info : response.getCategories()) {
			System.out.println(info.getCatCode()+ " , " + info.getCatName());
		}
	}
}

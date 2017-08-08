package com.iwilley.b1ec2.sample;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.CustomerCreateRequest;
import com.iwilley.b1ec2.api.response.CustomerCreateResponse;

public class CustomerCreateSample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		
		CustomerCreateRequest request = new CustomerCreateRequest();
		request.setCustomerName("444");
		request.setShopId(10);
		request.setCity("北京市");
		request.setDistrict("东城区");
		request.setAddress("新街口外大街4-103");
		request.setMobile("18614088260");
		request.setZipCode("200333");
		request.setReceiverName("黄县僧");
		request.userDefinedField1 = "u1";
		request.userDefinedField2 = "u2";
		//request.customerCode="";
		CustomerCreateResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println("errorCode:" + response.getErrorCode()
				+ ",errorMessage" + response.getErrorMsg());
	}
}

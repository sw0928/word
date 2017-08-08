package com.iwilley.b1ec2.sample;

import java.util.ArrayList;
import java.util.List;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.UnknownPackageItemLine;
import com.iwilley.b1ec2.api.request.UnknownPackageCreateRequest;
import com.iwilley.b1ec2.api.response.UnknownPackageCreateResponse;

public class UnKnownPackageCreateSample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		
		UnknownPackageCreateRequest request = new UnknownPackageCreateRequest();
		
		request.returnWhsId = 1;
		request.returnExpressId = 15;
        request.expressTrackNo ="1234567890";
        request.userDefinedField1 = "UserDefinedField1";
        request.userDefinedField2 = "UserDefinedField2";
        request.userDefinedField3 = "UserDefinedField3";
        request.userDefinedField4= "UserDefinedField4";
        
        List<UnknownPackageItemLine> line1 = new ArrayList<UnknownPackageItemLine>();
        UnknownPackageItemLine itemLine1 = new UnknownPackageItemLine();
        itemLine1.skuCode = "testSku1";
        itemLine1.quantity = 5;
        line1.add(itemLine1);
        UnknownPackageItemLine itemLine2 = new UnknownPackageItemLine();
        itemLine2.skuCode = "testSku1";
        itemLine2.quantity = 10;
        line1.add(itemLine2);
        
        request.setItemLines(line1);
        
        UnknownPackageCreateResponse response = client.execute(request);
        
        System.out.println(response.getBody());
	}
}	

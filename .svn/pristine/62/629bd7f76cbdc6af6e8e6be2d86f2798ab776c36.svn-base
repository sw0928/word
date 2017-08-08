package com.iwilley.b1ec2.sample;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.PurchaseReturnLineInfo;
import com.iwilley.b1ec2.api.request.PurchaseReturnRequest;
import com.iwilley.b1ec2.api.response.PurchaseReturnResponse;

public class PurchaseReturnSample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		PurchaseReturnRequest request = new PurchaseReturnRequest();
		request.setReturnId(10);
		request.setWhsAreaCode("1010");

		List<PurchaseReturnLineInfo> lines=new ArrayList<PurchaseReturnLineInfo>();
		
		PurchaseReturnLineInfo line=new PurchaseReturnLineInfo();
		line.setLineNum(0);
		line.setQuantity(200);
		line.setSerialNumbers("dasdsadsad,fafdsfds");
		lines.add(line);
		
		PurchaseReturnLineInfo line2=new PurchaseReturnLineInfo();
		line2.setLineNum(1);
		line2.setQuantity(20);
		line2.setSerialNumbers("fdsafsd,23232");
		lines.add(line2);
		
		request.setReceiptLines(lines);
		
		PurchaseReturnResponse response = client.execute(request);
		System.out.println(response.getBody());
	}

}
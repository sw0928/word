package com.iwilley.b1ec2.sample;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.PurchaseReceiptLine;
import com.iwilley.b1ec2.api.request.PurchaseReceiptRequest;
import com.iwilley.b1ec2.api.response.PurchaseReceiptResponse;

public class PurchaseReceiptSample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		PurchaseReceiptRequest request = new PurchaseReceiptRequest();
		request.setPurchaseOrderId(6);
		request.setWhsAreaCode("1010");

		List<PurchaseReceiptLine> lines=new ArrayList<PurchaseReceiptLine>();
		
		PurchaseReceiptLine line=new PurchaseReceiptLine();
		line.setLineNum(0);
		line.setQuantity(200);
		line.setSerialNumbers("dasdsadsad,fafdsfds");
		lines.add(line);
		
		PurchaseReceiptLine line2=new PurchaseReceiptLine();
		line2.setLineNum(1);
		line2.setQuantity(20);
		line2.setSerialNumbers("fdsafsd,23232");
		lines.add(line2);
		
		request.setReceiptLines(lines);
		
		PurchaseReceiptResponse response = client.execute(request);
		System.out.println(response.getBody());
	}

}
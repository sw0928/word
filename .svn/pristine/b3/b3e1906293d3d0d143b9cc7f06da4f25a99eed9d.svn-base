package com.iwilley.b1ec2.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;

import com.iwilley.b1ec2.api.domain.Supplier;
import com.iwilley.b1ec2.api.request.SupplierQueryRequest;
import com.iwilley.b1ec2.api.response.SupplierQueryResponse;

public class SupplierQuerySample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		DateFormat format = new SimpleDateFormat(
				com.iwilley.b1ec2.api.Constants.DATE_TIME_FORMAT);

		SupplierQueryRequest request = new SupplierQueryRequest();
		request.setStartTime(format.parse("2014-04-20 00:00:00"));
		request.setEndTime(format.parse("2014-06-28 00:00:00"));
		SupplierQueryResponse response = client.execute(request);
		System.out.println(response.getBody());

		if (response.getErrorCode() == 0) {
			for (Supplier supplier : response.getSuppliers()) {
				System.out.println("Supplier:" + supplier.getSupplierId() + ","
						+ supplier.getSupplierName());
			}
		}
	}

}
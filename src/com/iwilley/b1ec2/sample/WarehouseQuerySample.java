package com.iwilley.b1ec2.sample;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.Warehouse;
import com.iwilley.b1ec2.api.domain.WhsArea;
import com.iwilley.b1ec2.api.request.WarehouseQueryRequest;
import com.iwilley.b1ec2.api.response.WarehouseQueryResponse;

public class WarehouseQuerySample {

	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		WarehouseQueryRequest request = new WarehouseQueryRequest();
		WarehouseQueryResponse response = client.execute(request);
		System.out.println(response.getBody());

		if (response.getErrorCode() == 0) {
			for (Warehouse whs : response.getWarehouses()) {
				System.out.println("Warehouse:" + whs.getWhsId() + ","
						+ whs.getWhsName());

				for (WhsArea area : whs.getWhsAreas()) {
					System.out.println("  Area:" + area.getWhsAreaCode() + ","
							+ area.getAreaName());
				}
			}
		}
	}

}
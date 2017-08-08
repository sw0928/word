package com.iwilley.b1ec2.sample;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.Shop;
import com.iwilley.b1ec2.api.request.ShopQueryRequest;
import com.iwilley.b1ec2.api.response.ShopQueryResponse;

public class ShopQuerySample {

	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		ShopQueryRequest request = new ShopQueryRequest();
		ShopQueryResponse response = client.execute(request);
		System.out.println(response.getBody());

		if (response.getErrorCode() == 0) {
			for (Shop shop : response.getShops()) {
				System.out.println("Shop:" + shop.getShopId() + ","
						+ shop.getShopName());
			}
		}
	}

}
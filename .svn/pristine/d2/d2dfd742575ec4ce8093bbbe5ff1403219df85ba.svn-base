package com.iwilley.b1ec2.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.ShopItem;
import com.iwilley.b1ec2.api.domain.ShopSku;
import com.iwilley.b1ec2.api.request.ShopItemQueryRequest;
import com.iwilley.b1ec2.api.response.ShopItemQueryResponse;

public class ShopItemQuerySample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		int pageSize = 5;
		DateFormat format = new SimpleDateFormat(
				com.iwilley.b1ec2.api.Constants.DATE_TIME_FORMAT);

		ShopItemQueryRequest request = new ShopItemQueryRequest();
		request.setStartTime(format.parse("2014-01-20 00:00:00"));
		request.setEndTime(format.parse("2014-06-30 00:00:00"));
		/*request.setProperty2("XLL");*/
		request.setPageSize(pageSize);

		ShopItemQueryResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println("结果数:" + response.getTotalResults());

		if (response.getErrorCode() == 0 && response.getTotalResults() > 0) {
			int totalPages = (int) Math.ceil((double) response
					.getTotalResults() / pageSize);

			// 最多取5页数据
			for (int i = 1; i <= totalPages && i <= 5; i++) {
				request.setPageNum(i);
				response = client.execute(request);
				System.out.println("请求页数:" + i + "/" + totalPages);

				for (ShopItem shopItem : response.getShopItems()) {
					System.out.println("商品信息:" + shopItem.getShopItemCode() + ","
							+ shopItem.getShopItemName());

					for (ShopSku shopSku : shopItem.getLines()) {
						System.out.println("  SKU信息:" + shopSku.getShopSkuCode()
								+ "," + shopSku.getProperties());
					}
				}
				System.out.println();
			}
		}
	}

}
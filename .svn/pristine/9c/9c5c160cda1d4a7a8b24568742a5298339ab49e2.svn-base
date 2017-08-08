package com.iwilley.b1ec2.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.ItemInfo;
import com.iwilley.b1ec2.api.domain.SkuInfo;
import com.iwilley.b1ec2.api.request.ItemInfoQueryRequest;
import com.iwilley.b1ec2.api.response.ItemInfoQueryResponse;

public class ItemInfoQuerySample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		int pageSize = 5;
		DateFormat format = new SimpleDateFormat(
				com.iwilley.b1ec2.api.Constants.DATE_TIME_FORMAT);

		ItemInfoQueryRequest request = new ItemInfoQueryRequest();
		request.setStartTime(format.parse("2014-05-20 00:00:00"));
		request.setEndTime(format.parse("2014-06-30 00:00:00"));
		/*request.setProperty2("XLL");*/
		request.setPageSize(pageSize);

		ItemInfoQueryResponse response = client.execute(request);
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

				for (ItemInfo itemInfo : response.getItemInfos()) {
					System.out.println("商品信息:" + itemInfo.getItemCode() + ","
							+ itemInfo.getItemName());

					for (SkuInfo skuInfo : itemInfo.getLines()) {
						System.out.println("  SKU信息:" + skuInfo.getSkuCode()
								+ "," + skuInfo.getSkuName());
					}
				}
				System.out.println();
			}
		}
	}

}
package com.iwilley.b1ec2.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.Bom;
import com.iwilley.b1ec2.api.domain.BomLine;
import com.iwilley.b1ec2.api.request.BomQueryRequest;
import com.iwilley.b1ec2.api.response.BomQueryResponse;

public class BomQuerySample {

	public static void main(String[] args) throws ParseException, ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		BomQueryRequest request = new BomQueryRequest();
		int pageSize = 5;
		DateFormat format = new SimpleDateFormat(
				com.iwilley.b1ec2.api.Constants.DATE_TIME_FORMAT);
		request.setStartTime(format.parse("2014-05-20 00:00:00"));
		request.setEndTime(format.parse("2015-06-30 00:00:00"));
		request.setPageSize(pageSize);

		BomQueryResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println("errorCode:" + response.getErrorCode()
				+ ",errorMessage" + response.getErrorMsg());
		System.out.println("结果数:" + response.getTotalResults());

		if (response.getErrorCode() == 0 && response.getTotalResults() > 0) {
			int totalPages = (int) Math.ceil((double) response
					.getTotalResults() / pageSize);

			// 最多取5页数据
			for (int i = 1; i <= totalPages && i <= 5; i++) {
				request.setPageNum(i);
				response = client.execute(request);
				System.out.println("请求页数:" + i + "/" + totalPages);

				for (Bom bom : response.getBoms()) {
					System.out.println("组合商品信息:" + bom.getItemCode() + ","
							+ bom.getItemName());

					for (BomLine line : bom.getLines()) {
						System.out.println("组合商品行信息:" + line.getSkuCode() + ","
								+ line.getSkuName());
					}
				}
				System.out.println();
			}

		}

	}
}

package com.iwilley.b1ec2.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.AfterSaleItemLine;
import com.iwilley.b1ec2.api.domain.AfterSaleService;
import com.iwilley.b1ec2.api.request.AfterSalesServiceQueryRequest;
import com.iwilley.b1ec2.api.response.AfterSalesServiceQueryResponse;

public class AfterSalesServiceQuerySample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		int pageSize = 5;
		DateFormat format = new SimpleDateFormat(
				com.iwilley.b1ec2.api.Constants.DATE_TIME_FORMAT);

		AfterSalesServiceQueryRequest request = new AfterSalesServiceQueryRequest();
		request.setStartTime(format.parse("2014-05-20 00:00:00"));
		request.setEndTime(format.parse("2014-06-22 00:00:00"));
		request.setPageSize(pageSize);

		AfterSalesServiceQueryResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println("结果数:" + response.getTotalResults());

		if (response.getErrorCode() == 0 && response.getTotalResults() > 0) {
			// 最多取5页数据
			int totalPages = (int) Math.ceil((double) response
					.getTotalResults() / pageSize);
			totalPages = totalPages > 5 ? 5 : totalPages;

			for (int i = totalPages; i >= 1; i--) {
				request.setPageNum(i);
				response = client.execute(request);
				System.out.println("请求页数:" + i + "/" + totalPages);

				for (AfterSaleService afterSaleService : response
						.getAfterSaleServices()) {
					System.out.println("订单信息:"
							+ afterSaleService.getAfterSaleServiceNo() + ","
							+ afterSaleService.getGoodsTotal());

					for (AfterSaleItemLine itemLine : afterSaleService
							.getItemLines()) {
						System.out.println("  订单行信息:"
								+ itemLine.getItemInfo().itemCode + ","
								+ itemLine.getSkuCode() + ","
								+ itemLine.getQuantity());
					}
				}
				System.out.println();
			}
		}
	}

}
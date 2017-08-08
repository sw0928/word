package com.iwilley.b1ec2.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.PurchaseOrder;
import com.iwilley.b1ec2.api.domain.PurchaseOrderLine;
import com.iwilley.b1ec2.api.request.PurchaseOrderQueryRequest;
import com.iwilley.b1ec2.api.response.PurchaseOrderQueryResponse;

public class PurchaseOrderQuerySample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		int pageSize = 5;
		DateFormat format = new SimpleDateFormat(
				com.iwilley.b1ec2.api.Constants.DATE_TIME_FORMAT);

		PurchaseOrderQueryRequest request = new PurchaseOrderQueryRequest();
		request.setStartTime(format.parse("2014-04-20 00:00:00"));
		request.setEndTime(format.parse("2014-07-30 00:00:00"));
		request.setPageSize(pageSize);

		PurchaseOrderQueryResponse response = client.execute(request);
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

				for (PurchaseOrder purchaseOrder : response.getPurchaseOrders()) {
					System.out.println("订单信息:" + purchaseOrder.getOrderNo() + ","
							+ purchaseOrder.getTotalQuantity());

					for (PurchaseOrderLine poLine : purchaseOrder.getLines()) {
						System.out.println("  订单行信息:"
								+ poLine.getItemInfo().itemCode + ","
								+ poLine.getSkuCode() + ","
								+ poLine.getQuantity());
					}
				}
				System.out.println();
			}
		}
	}

}
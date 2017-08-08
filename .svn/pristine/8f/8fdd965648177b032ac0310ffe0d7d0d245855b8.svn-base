package com.iwilley.b1ec2.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.SalesOrder;
import com.iwilley.b1ec2.api.domain.SalesOrderLine;
import com.iwilley.b1ec2.api.request.SalesOrderQueryRequest;
import com.iwilley.b1ec2.api.response.SalesOrderQueryResponse;

public class SalesOrderQuerySample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		int pageSize = 5;
		DateFormat format = new SimpleDateFormat(
				com.iwilley.b1ec2.api.Constants.DATE_TIME_FORMAT);

		SalesOrderQueryRequest request = new SalesOrderQueryRequest();
		request.setStartTime(format.parse("2010-04-20 00:00:00"));
		request.setEndTime(format.parse("2020-05-22 00:00:00"));
		request.setPageSize(pageSize);
		request.setShopId(4);		
		request.setShopOrderNo("1000026115362461711956933");
		
		SalesOrderQueryResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println("结果数:" + response.getTotalResults());

//		if (response.getErrorCode() == 0 && response.getTotalResults() > 0) {
//			// 最多取5页数据
//			int totalPages = (int) Math.ceil((double) response
//					.getTotalResults() / pageSize);
//			totalPages = totalPages > 5 ? 5 : totalPages;
//
//			for (int i = totalPages; i >= 1; i--) {
//				request.setPageNum(i);
//				response = client.execute(request);
//				System.out.println("请求页数:" + i + "/" + totalPages);
//
//				for (SalesOrder salesOrder : response.getSalesOrders()) {
//					System.out.println("订单信息:" + salesOrder.getOrderNo() + ","
//							+ salesOrder.getOrderTotal());
//
//					for (SalesOrderLine soLine : salesOrder.getLines()) {
//						System.out.println("  订单行信息:"
//								+ soLine.getIteminfo().itemCode + ","
//								+ soLine.getSkuCode() + ","
//								+ soLine.getQuantity());
//					}
//				}
//				System.out.println();
//			}
//		}
	}

}
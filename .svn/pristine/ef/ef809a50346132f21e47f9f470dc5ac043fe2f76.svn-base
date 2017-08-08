package com.iwilley.b1ec2.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.StockTransfer;
import com.iwilley.b1ec2.api.domain.StockTransferLine;
import com.iwilley.b1ec2.api.request.StockTransferQueryRequest;
import com.iwilley.b1ec2.api.response.StockTransferQueryResponse;

public class StockTransferQuerySample {
	
	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		int pageSize = 5;
		DateFormat format = new SimpleDateFormat(
				com.iwilley.b1ec2.api.Constants.DATE_TIME_FORMAT);
		
		StockTransferQueryRequest request = new StockTransferQueryRequest();
		request.setStartTime(format.parse("2010-04-20 00:00:00"));
		request.setEndTime(format.parse("2020-05-22 00:00:00"));
		request.setPageSize(pageSize);
		request.setStockTransferNo("34150423000017");
		request.setStockTransferStatus(30);
		request.setStockTransferType(10);
		
		StockTransferQueryResponse response = client.execute(request);
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

				for (StockTransfer stockTransfer : response.getStockTransfers()) {
					System.out.println("转储单信息:" + stockTransfer.getStockTransferNo() + ","
							+ stockTransfer.getCreateUser());

					for (StockTransferLine line : stockTransfer.getLines()) {
						System.out.println("  转储单行信息:"
								+ line.getTransferId() + ","
								+ line.getSkuCode()+ ","
								+ line.getSkuName());
					}
				}
				System.out.println();
			}
		}
	}
}

package com.iwilley.b1ec2.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.FinJournal;
import com.iwilley.b1ec2.api.request.FinJournalQueryRequest;
import com.iwilley.b1ec2.api.response.FinJournalQueryResponse;

public class FinJournalQuerySample {

	public static void main(String[] args) throws ApiException, ParseException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);

		int pageSize = 5;
		DateFormat format = new SimpleDateFormat(
				com.iwilley.b1ec2.api.Constants.DATE_TIME_FORMAT);

		FinJournalQueryRequest request = new FinJournalQueryRequest();
		request.setStartTime(format.parse("2014-07-22 00:00:00"));
		request.setEndTime(format.parse("2015-08-16 00:00:00"));
		request.setPageSize(pageSize);

		FinJournalQueryResponse response = client.execute(request);
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

				for (FinJournal finJournal : response
						.getFinJournals()) {
					System.out.println("订单信息:"
							+ finJournal.getFinJournalId() + ","
							+ finJournal.getAccountCode() + ","
							+ finJournal.getFinAccount().getAccountName());

				}
				System.out.println();
			}
		}
	}

}
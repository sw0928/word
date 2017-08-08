package com.iwilley.b1ec2.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.ShopOrderCreateDiscount;
import com.iwilley.b1ec2.api.domain.ShopOrderCreateLine;
import com.iwilley.b1ec2.api.domain.ShopOrderCreatePayment;
import com.iwilley.b1ec2.api.request.ShopOrderCreateRequest;
import com.iwilley.b1ec2.api.response.ShopOrderCreateResponse;

public class ShopOrderCreateSample {
	public static void main(String[] args) throws ParseException, ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY, Constants.LOGIN_NAME,
				Constants.PASSWORD);
		ShopOrderCreateRequest request = new ShopOrderCreateRequest();
		DateFormat format = new SimpleDateFormat(com.iwilley.b1ec2.api.Constants.DATE_TIME_FORMAT);
		request.memberNick = "4";
		request.shopOrderNo = "20160519";
		request.shopId = 4;
		request.orderStatus = 10;
		request.shopCreatedTime = format.parse("2015-05-07 00:00:00");
		request.customPaymentName = "微信";
		request.customPaymentNo = "11";
		request.customTax = 1111;
		request.customIdNo = "4489809284093284";
		request.customPaymentName = "微信";
		request.customPaymentNo = "123213";
		
		List<ShopOrderCreateLine> line1 = new ArrayList<ShopOrderCreateLine>();
		ShopOrderCreateLine shopOrderCreateLine1 = new ShopOrderCreateLine();
		shopOrderCreateLine1.shopLineNo = "ShopLineNo";
		shopOrderCreateLine1.outerId = "OuterId";
		shopOrderCreateLine1.price = 123.45;
		shopOrderCreateLine1.quantity = 3;
		shopOrderCreateLine1.lineUdf1 = "我是自定义字段1";
		shopOrderCreateLine1.lineUdf2 = "我是自定义字段2";
		shopOrderCreateLine1.skuName = "1";
		shopOrderCreateLine1.itemName = "2";
		shopOrderCreateLine1.lineTotal = 0;
		shopOrderCreateLine1.lineCustomTax = 0;
		shopOrderCreateLine1.lineCustomTotal = 0;
		line1.add(shopOrderCreateLine1);

		List<ShopOrderCreateDiscount> line2 = new ArrayList<ShopOrderCreateDiscount>();
		ShopOrderCreateDiscount shopOrderCreateDiscount1 = new ShopOrderCreateDiscount();
		shopOrderCreateDiscount1.discountName = "老板结婚，所有东西打7折";
		shopOrderCreateDiscount1.discountFee = 2;
		line2.add(shopOrderCreateDiscount1);

		List<ShopOrderCreatePayment> line3 = new ArrayList<ShopOrderCreatePayment>();
		ShopOrderCreatePayment shopOrderCreatePayment1 = new ShopOrderCreatePayment();
		shopOrderCreatePayment1.paymentId = 3;
		shopOrderCreatePayment1.paymentTotal = 3;
		shopOrderCreatePayment1.paymentNo = "2134324234324";
		line3.add(shopOrderCreatePayment1);

		request.setItemLines(line1);
		request.setDiscountLines(line2);
		request.setPaymentLines(line3);

		ShopOrderCreateResponse response = client.execute(request);
		System.out.println(response.getBody());
	}
}

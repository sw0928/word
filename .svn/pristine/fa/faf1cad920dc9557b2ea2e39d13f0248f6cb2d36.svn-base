package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class ShopOrderPayment extends B1EC2Object {

	private static final long serialVersionUID = 9148055093585047262L;
	// 平台订单编号
	@ApiField("ShopOrderNo")
	public String shopOrderNo;

	// 行号
	@ApiField("LineNum")
	public int lineNum;

	@ApiField("ShopOrder")
	public ShopOrder shopOrder;

	public String getShopOrderNo() {
		return shopOrderNo;
	}

	public void setShopOrderNo(String shopOrderNo) {
		this.shopOrderNo = shopOrderNo;
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public ShopOrder getShopOrder() {
		return shopOrder;
	}

	public void setShopOrder(ShopOrder shopOrder) {
		this.shopOrder = shopOrder;
	}

	public int getPaymentId() {
		return PaymentId;
	}

	public void setPaymentId(int paymentId) {
		PaymentId = paymentId;
	}

	public double getPaymentTotal() {
		return paymentTotal;
	}

	public void setPaymentTotal(double paymentTotal) {
		this.paymentTotal = paymentTotal;
	}

	// 付款方式
	@ApiField("paymentId")
	public int PaymentId;

	// 付款金额
	@ApiField("PaymentTotal")
	public double paymentTotal;
}

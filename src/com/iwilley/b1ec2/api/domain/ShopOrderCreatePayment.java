package com.iwilley.b1ec2.api.domain;

public class ShopOrderCreatePayment extends B1EC2Object {

	private static final long serialVersionUID = -6513874017378216251L;

	// 1:现金支付 2:银行转账 3:网上支付 4:支付宝 5:天猫积分 6:货到付款 7:账户支付
	// 付款方式
	public int paymentId;

	// 付款金额
	public double paymentTotal;
	
	// 付款单号
	public String paymentNo;

	public int getPaymentId() {
		return paymentId;
	}

	public double getPaymentTotal() {
		return paymentTotal;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public void setPaymentTotal(double paymentTotal) {
		this.paymentTotal = paymentTotal;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}
}

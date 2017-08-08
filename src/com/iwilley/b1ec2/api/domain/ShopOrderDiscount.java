package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class ShopOrderDiscount extends B1EC2Object {

	private static final long serialVersionUID = 6810011033383777398L;

	// ∆ΩÃ®∂©µ•±‡∫≈
	@ApiField("ShopOrderNo")
	public String shopOrderNo;

	// ––∫≈
	@ApiField("LineNum")
	public int lineNum;

	@ApiField("ShopOrder")
	public ShopOrder shopOrder;

	// ’€ø€√˚≥∆
	@ApiField("DiscountName")
	public String discountName;

	// ’€ø€∂Ó
	@ApiField("DiscountFee")
	public double discountFee;

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

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public double getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(double discountFee) {
		this.discountFee = discountFee;
	}
}

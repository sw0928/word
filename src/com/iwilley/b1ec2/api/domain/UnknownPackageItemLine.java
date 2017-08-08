package com.iwilley.b1ec2.api.domain;

public class UnknownPackageItemLine extends B1EC2Object {

	private static final long serialVersionUID = 3404409893804963264L;
	// SkuCode
	public String skuCode;

	// ÊýÁ¿
	public int quantity;

	public String getSkuCode() {
		return skuCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

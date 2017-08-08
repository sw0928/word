package com.iwilley.b1ec2.api.domain;

public class BomCreateLine extends B1EC2Object {

	private static final long serialVersionUID = -3503659820374693128L;

	// SkuCode
	public String skuCode;

	// ÊýÁ¿
	public int quantity;

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

package com.iwilley.b1ec2.api.domain;

public class SkuCreateLine extends B1EC2Object {

	private static final long serialVersionUID = 3628741699151938463L;

	// SkuCode
	public String skuCode;

	// 条形码
	public String barCode;

	// 销售属性1
	public String property1;

	// 销售属性2
	public String property2;

	// 销售价格
	public double salesPrice;

	// 单位
	public String unit;

	public String getSkuCode() {
		return skuCode;
	}

	public String getBarCode() {
		return barCode;
	}

	public String getProperty1() {
		return property1;
	}

	public String getProperty2() {
		return property2;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public String getUnit() {
		return unit;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}

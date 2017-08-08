package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class BomLine extends B1EC2Object {

	private static final long serialVersionUID = -2956796093790463332L;

	// 组合商品
	@ApiField("BomId")
	public int bomId;

	// 行号
	@ApiField("LineNum")
	public int lineNum;

	// 行商品
	@ApiField("LineItemId")
	public int lineItemId;

	@ApiField("LineItem")
	public ItemInfo lineItem;

	// Sku
	@ApiField("SkuCode")
	public String skuCode;

	// 商品名称
	@ApiField("ItemName")
	public String itemName;

	// 型号
	@ApiField("SkuName")
	public String skuName;

	// 商品数量
	@ApiField("Quantity")
	public int quantity;

	// 单位
	@ApiField("Unit")
	public String unit;

	// 销售价格
	@ApiField("SalesPrice")
	public double salesPrice;

	public int getBomId() {
		return bomId;
	}

	public void setBomId(int bomId) {
		this.bomId = bomId;
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public int getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}

	public ItemInfo getLineItem() {
		return lineItem;
	}

	public void setLineItem(ItemInfo lineItem) {
		this.lineItem = lineItem;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
}

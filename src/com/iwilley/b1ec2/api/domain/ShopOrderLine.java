package com.iwilley.b1ec2.api.domain;

import java.util.Date;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class ShopOrderLine extends B1EC2Object {

	private static final long serialVersionUID = 5628516418176760753L;
	// 平台订单编号
	@ApiField("ShopOrderNo")
	public String shopOrderNo;

	// 行号
	@ApiField("LineNum")
	public int lineNum;

	@ApiField("ShopOrder")
	public ShopOrder shopOrder;

	// 平台订单行编号
	@ApiField("ShopLineNo")
	public String shopLineNo;

	// 平台订单行状态
	@ApiField("LineStatusName")
	public String lineStatusName;

	// 外部代码
	@ApiField("OuterId")
	public String outerId;

	// 商品名称
	@ApiField("ItemName")
	public String itemName;

	// 规格名称
	@ApiField("SkuName")
	public String skuName;

	// 网站商品Id
	@ApiField("ShopItemId")
	public String shopItemId;

	// 网站Sku Id
	@ApiField("ShopSkuId")
	public String shopSkuId;

	// 单价
	@ApiField("price")
	public double Price;

	// 数量
	@ApiField("Quantity")
	public double quantity;

	// 行折扣
	@ApiField("LineDiscountFee")
	public double lineDiscountFee;

	// 行调整金额
	@ApiField("LineAdjustFee")
	public double lineAdjustFee;

	// 发货时间
	@ApiField("DeliveryTime")
	public Date deliveryTime;

	// 行总计
	@ApiField("LineTotal")
	public double lineTotal;

	// 自定义行字段1
	@ApiField("LineUdf1")
	public String lineUdf1;
	// 自定义行字段2
	@ApiField("LineUdf2")
	public String lineUdf2;

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

	public String getShopLineNo() {
		return shopLineNo;
	}

	public void setShopLineNo(String shopLineNo) {
		this.shopLineNo = shopLineNo;
	}

	public String getLineStatusName() {
		return lineStatusName;
	}

	public void setLineStatusName(String lineStatusName) {
		this.lineStatusName = lineStatusName;
	}

	public String getOuterId() {
		return outerId;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
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

	public String getShopItemId() {
		return shopItemId;
	}

	public void setShopItemId(String shopItemId) {
		this.shopItemId = shopItemId;
	}

	public String getShopSkuId() {
		return shopSkuId;
	}

	public void setShopSkuId(String shopSkuId) {
		this.shopSkuId = shopSkuId;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getLineDiscountFee() {
		return lineDiscountFee;
	}

	public void setLineDiscountFee(double lineDiscountFee) {
		this.lineDiscountFee = lineDiscountFee;
	}

	public double getLineAdjustFee() {
		return lineAdjustFee;
	}

	public void setLineAdjustFee(double lineAdjustFee) {
		this.lineAdjustFee = lineAdjustFee;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public String getLineUdf1() {
		return lineUdf1;
	}

	public void setLineUdf1(String lineUdf1) {
		this.lineUdf1 = lineUdf1;
	}

	public String getLineUdf2() {
		return lineUdf2;
	}

	public void setLineUdf2(String lineUdf2) {
		this.lineUdf2 = lineUdf2;
	}
}

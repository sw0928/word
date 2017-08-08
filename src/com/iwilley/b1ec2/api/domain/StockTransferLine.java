package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

// 库存转储单
public class StockTransferLine extends B1EC2Object {

	private static final long serialVersionUID = 1L;

	// 转储单
	@ApiField("TransferId")
	public int transferId;

	@ApiField("StockTransfer")
	public StockTransfer stockTransfer;

	// 行号
	@ApiField("LineNum")
	public int lineNum;

	// 商品Id
	@ApiField("ItemId")
	public int itemId;

	// 商品信息
	@ApiField("ItemInfo")
	public ItemInfo itemInfo;

	// 商品编码
	@ApiField("SkuCode")
	public String skuCode;

	// 商品规格
	@ApiField("SkuName")
	public String skuName;

	// 商品名称
	@ApiField("ItemName")
	public String itemName;

	// 单位
	@ApiField("Unit")
	public String unit;

	// 转储时 需要用户输入转储数量，否则不会验证
	// 商品数量
	@ApiField("Quantity")
	public int quantity;

	// 从库区
	@ApiField("FromWhsArea")
	public int fromWhsArea;

	@ApiField("WhsAreaFrom")
	public WhsArea whsAreaFrom;

	// 从库区名称
	@ApiField("FromWhsAreaName")
	public String fromWhsAreaName;

	// 至库区
	@ApiField("ToWhsArea")
	public int toWhsArea;

	@ApiField("WhsAreaTo")
	public WhsArea whsAreaTo;

	// 至库区名称
	@ApiField("ToWhsAreaName")
	public String toWhsAreaName;

	// 行备注
	@ApiField("LineMemo")
	public String lineMemo;

	// 序列号
	@ApiField("SerialNumbers")
	public String serialNumbers;

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public StockTransfer getStockTransfer() {
		return stockTransfer;
	}

	public void setStockTransfer(StockTransfer stockTransfer) {
		this.stockTransfer = stockTransfer;
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public ItemInfo getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(ItemInfo itemInfo) {
		this.itemInfo = itemInfo;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getFromWhsArea() {
		return fromWhsArea;
	}

	public void setFromWhsArea(int fromWhsArea) {
		this.fromWhsArea = fromWhsArea;
	}

	public WhsArea getWhsAreaFrom() {
		return whsAreaFrom;
	}

	public void setWhsAreaFrom(WhsArea whsAreaFrom) {
		this.whsAreaFrom = whsAreaFrom;
	}

	public String getFromWhsAreaName() {
		return fromWhsAreaName;
	}

	public void setFromWhsAreaName(String fromWhsAreaName) {
		this.fromWhsAreaName = fromWhsAreaName;
	}

	public int getToWhsArea() {
		return toWhsArea;
	}

	public void setToWhsArea(int toWhsArea) {
		this.toWhsArea = toWhsArea;
	}

	public WhsArea getWhsAreaTo() {
		return whsAreaTo;
	}

	public void setWhsAreaTo(WhsArea whsAreaTo) {
		this.whsAreaTo = whsAreaTo;
	}

	public String getToWhsAreaName() {
		return toWhsAreaName;
	}

	public void setToWhsAreaName(String toWhsAreaName) {
		this.toWhsAreaName = toWhsAreaName;
	}

	public String getLineMemo() {
		return lineMemo;
	}

	public void setLineMemo(String lineMemo) {
		this.lineMemo = lineMemo;
	}

	public String getSerialNumbers() {
		return serialNumbers;
	}

	public void setSerialNumbers(String serialNumbers) {
		this.serialNumbers = serialNumbers;
	}
}

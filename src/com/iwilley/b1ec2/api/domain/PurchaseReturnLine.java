package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

import java.util.Date;

public class PurchaseReturnLine extends B1EC2Object {

	private static final long serialVersionUID = -8109499955122936213L;

	// ���ⵥID
	@ApiField("ReturnId")
	public int returnId;

	// �к�
	@ApiField("LineNum")
	public int lineNum;

	// ��������ID
	@ApiField("BaseOrderId")
	public Integer baseOrderId;

	// ��������Line
	@ApiField("BaseLineId")
	public Integer baseLineId;

	// ��������No
	@ApiField("BaseOrderNo")
	public String baseOrderNo;
	// ��ƷID
	@ApiField("ItemId")
	public Integer itemId;
	@ApiField("ItemInfo")
	public ItemInfo itemInfo;

	// ��Ʒ����
	@ApiField("SkuCode")
	public String skuCode;

	// ��Ʒ���
	@ApiField("SkuName")
	public String skuName;

	// ��Ʒ����
	@ApiField("ItemName")
	public String itemName;

	// ��λ
	@ApiField("Unit")
	public String unit;

	// ��Ʒ����
	@ApiField("Quantity")
	public double quantity;

	// ���ɱ�
	@ApiField("StockPrice")
	public double stockPrice;

	// �����
	@ApiField("StockValue")
	public double stockValue;

	// ����
	@ApiField("Price")
	public double price;

	// ���ܼ�
	@ApiField("LineTotal")
	public double lineTotal;

	// ����ID
	@ApiField("WhsAreaId")
	public int whsAreaId;

	@ApiField("WhsArea")
	public WhsArea whsArea;

	// �б�ע
	@ApiField("LineMemo")
	public String lineMemo;

	// ��Ʒ��ע
	@ApiField("ItemInfoMemo")
	public String itemInfoMemo;

	// ������������
	@ApiField("BatchProductDate")
	public Date batchProductDate;

	// ������Ч����
	@ApiField("BatchExpiryDate")
	public Date batchExpiryDate;

	// ���α�ע
	@ApiField("BatchMemo")
	public String batchMemo;

	// �Ƿ����кŹ���
	@ApiField("NeedSerial")
	public Boolean needSerial;

	// ���к�
	@ApiField("SerialNumbers")
	public String serialNumbers;

	// ����
	@ApiField("Proportion")
	public int proportion;

	// ��Ʒ����
	@ApiField("BarCode")
	public String barCode;

	public int getReturnId() {
		return returnId;
	}

	public int getLineNum() {
		return lineNum;
	}

	public Integer getBaseOrderId() {
		return baseOrderId;
	}

	public Integer getBaseLineId() {
		return baseLineId;
	}

	public String getBaseOrderNo() {
		return baseOrderNo;
	}

	public Integer getItemId() {
		return itemId;
	}

	public ItemInfo getItemInfo() {
		return itemInfo;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public String getSkuName() {
		return skuName;
	}

	public String getItemName() {
		return itemName;
	}

	public String getUnit() {
		return unit;
	}

	public double getQuantity() {
		return quantity;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public double getStockValue() {
		return stockValue;
	}

	public double getPrice() {
		return price;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public int getWhsAreaId() {
		return whsAreaId;
	}

	public WhsArea getWhsArea() {
		return whsArea;
	}

	public String getLineMemo() {
		return lineMemo;
	}

	public String getItemInfoMemo() {
		return itemInfoMemo;
	}

	public Date getBatchProductDate() {
		return batchProductDate;
	}

	public Date getBatchExpiryDate() {
		return batchExpiryDate;
	}

	public String getBatchMemo() {
		return batchMemo;
	}

	public Boolean getNeedSerial() {
		return needSerial;
	}

	public String getSerialNumbers() {
		return serialNumbers;
	}

	public int getProportion() {
		return proportion;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public void setBaseOrderId(Integer baseOrderId) {
		this.baseOrderId = baseOrderId;
	}

	public void setBaseLineId(Integer baseLineId) {
		this.baseLineId = baseLineId;
	}

	public void setBaseOrderNo(String baseOrderNo) {
		this.baseOrderNo = baseOrderNo;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public void setItemInfo(ItemInfo itemInfo) {
		this.itemInfo = itemInfo;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public void setWhsAreaId(int whsAreaId) {
		this.whsAreaId = whsAreaId;
	}

	public void setWhsArea(WhsArea whsArea) {
		this.whsArea = whsArea;
	}

	public void setLineMemo(String lineMemo) {
		this.lineMemo = lineMemo;
	}

	public void setItemInfoMemo(String itemInfoMemo) {
		this.itemInfoMemo = itemInfoMemo;
	}

	public void setBatchProductDate(Date batchProductDate) {
		this.batchProductDate = batchProductDate;
	}

	public void setBatchExpiryDate(Date batchExpiryDate) {
		this.batchExpiryDate = batchExpiryDate;
	}

	public void setBatchMemo(String batchMemo) {
		this.batchMemo = batchMemo;
	}

	public void setNeedSerial(Boolean needSerial) {
		this.needSerial = needSerial;
	}

	public void setSerialNumbers(String serialNumbers) {
		this.serialNumbers = serialNumbers;
	}

	public void setProportion(int proportion) {
		this.proportion = proportion;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

}

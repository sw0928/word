package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class SalesOrderLine extends B1EC2Object {

	private static final long serialVersionUID = 3014118401019289394L;

	// ����ID
	@ApiField("OrderId")
	public int orderId;

	// �к�
	@ApiField("LineNum")
	public int lineNum;

	// ��־�汾
	@ApiField("Version")
	public int version;

	// ��״̬(10:δ��;20:����;30:��ȡ��;)
	@ApiField("LineStatus")
	public int lineStatus;

	// ƽ̨�������,20
	@ApiField("ShopOrderNo")
	public String shopOrderNo;

	// ƽ̨�����б��,20
	@ApiField("ShopLineNo")
	public String shopLineNo;

	// ƽ̨������״̬,10
	@ApiField("ShopLineStatus")
	public String shopLineStatus;

	// ƽ̨������״̬,100
	@ApiField("ShopItemName")
	public String shopItemName;

	// ��ƷID
	@ApiField("ItemId")
	public Integer itemId;

	// ��Ʒ(ע:ֻ������Ʒ����)
	@ApiField("ItemInfo")
	public ItemInfo iteminfo;

	// ��Ʒ����,100,Not Null
	@ApiField("ItemName")
	public String itemName;

	// ��Ʒ����,50
	// ���Ϊitemû��sku,��skucode���ڻ���
	@ApiField("SkuCode")
	public String skuCode;

	// �������,100
	@ApiField("SkuName")
	public String skuName;

	// ��Ʒ����,254
	@ApiField("BarCode")
	public String barCode;

	// ��λ,20
	@ApiField("Unit")
	public String unit;

	// ����
	@ApiField("Price")
	public double price;

	// ����,Normal int
	@ApiField("Quantity")
	public double quantity;

	// ���ۿ�
	@ApiField("LineDiscountFee")
	public double lineDiscountFee;

	// �е������
	@ApiField("LineAdjustFee")
	public double lineAdjustFee;

	// ���ܼ�
	@ApiField("LineTotal")
	public double lineTotal;

	// ���ɱ�
	@ApiField("StockPrice")
	public double stockPrice;

	// �����
	@ApiField("StockValue")
	public double stockValue;

	// �Ƿ�����
	@ApiField("IsVirtual")
	public Boolean virtual;

	// �Ƿ����кŹ���
	@ApiField("IsSerialNumber")
	public Boolean serialNumber;

	// ���к�,LongText
	@ApiField("SerialNumbers")
	public String serialNumbers;

	// �����λ,100
	@ApiField("Location")
	public String location;

	// �Զ������ֶ�1,50
	@ApiField("LineUdf1")
	public String lineUdf1;

	// �Զ���������2
	@ApiField("LineUdf2")
	public Double lineUdf2;

	// �б�ע
	@ApiField("LineMemo")
	public String lineMemo;

	public int getOrderId() {
		return orderId;
	}

	public int getLineNum() {
		return lineNum;
	}

	public int getVersion() {
		return version;
	}

	public int getLineStatus() {
		return lineStatus;
	}

	public String getShopOrderNo() {
		return shopOrderNo;
	}

	public String getShopLineNo() {
		return shopLineNo;
	}

	public String getShopLineStatus() {
		return shopLineStatus;
	}

	public String getShopItemName() {
		return shopItemName;
	}

	public Integer getItemId() {
		return itemId;
	}

	public ItemInfo getIteminfo() {
		return iteminfo;
	}

	public String getItemName() {
		return itemName;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public String getSkuName() {
		return skuName;
	}

	public String getBarCode() {
		return barCode;
	}

	public String getUnit() {
		return unit;
	}

	public double getPrice() {
		return price;
	}

	public double getQuantity() {
		return quantity;
	}

	public double getLineDiscountFee() {
		return lineDiscountFee;
	}

	public double getLineAdjustFee() {
		return lineAdjustFee;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public double getStockValue() {
		return stockValue;
	}

	public Boolean getVirtual() {
		return virtual;
	}

	public Boolean getSerialNumber() {
		return serialNumber;
	}

	public String getSerialNumbers() {
		return serialNumbers;
	}

	public String getLocation() {
		return location;
	}

	public String getLineUdf1() {
		return lineUdf1;
	}

	public Double getLineUdf2() {
		return lineUdf2;
	}

	public String getLineMemo() {
		return lineMemo;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setLineStatus(int lineStatus) {
		this.lineStatus = lineStatus;
	}

	public void setShopOrderNo(String shopOrderNo) {
		this.shopOrderNo = shopOrderNo;
	}

	public void setShopLineNo(String shopLineNo) {
		this.shopLineNo = shopLineNo;
	}

	public void setShopLineStatus(String shopLineStatus) {
		this.shopLineStatus = shopLineStatus;
	}

	public void setShopItemName(String shopItemName) {
		this.shopItemName = shopItemName;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public void setIteminfo(ItemInfo iteminfo) {
		this.iteminfo = iteminfo;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setLineDiscountFee(double lineDiscountFee) {
		this.lineDiscountFee = lineDiscountFee;
	}

	public void setLineAdjustFee(double lineAdjustFee) {
		this.lineAdjustFee = lineAdjustFee;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}

	public void setVirtual(Boolean virtual) {
		this.virtual = virtual;
	}

	public void setSerialNumber(Boolean serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setSerialNumbers(String serialNumbers) {
		this.serialNumbers = serialNumbers;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLineUdf1(String lineUdf1) {
		this.lineUdf1 = lineUdf1;
	}

	public void setLineUdf2(Double lineUdf2) {
		this.lineUdf2 = lineUdf2;
	}

	public void setLineMemo(String lineMemo) {
		this.lineMemo = lineMemo;
	}

}

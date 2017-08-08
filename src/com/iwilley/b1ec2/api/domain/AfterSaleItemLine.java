package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class AfterSaleItemLine extends B1EC2Object {

	private static final long serialVersionUID = -6148452458041696445L;

	//售后单ID
    @ApiField("AfterSaleServiceId")
    public int afterSaleServiceId;

    //行号
    @ApiField("LineNum")
    public int lineNum;

    //版本
    @ApiField("Version")
    public int version;

    //平台订单编号,20
    @ApiField("ShopOrderNo")
    public String shopOrderNo;

    //平台订单行编号,20
    @ApiField("ShopLineNo")
    public String shopLineNo;

    //商品ID
    @ApiField("ItemId")
    public Integer itemId;

    //商品(注:只返回商品编码)
    @ApiField("ItemInfo")
    public ItemInfo itemInfo;

    //Sku,50
    @ApiField("SkuCode")
    public String skuCode;

    //商品名称,100
    @ApiField("ItemName")
    public String itemName;

    //商品条码,100
    @ApiField("BarCode")
    public String barCode;
    

	//型号,100
    @ApiField("ExpressId")
    public String skuName;

    //商品数量
    @ApiField("Quantity")
    public double quantity;

    //价格
    @ApiField("Price")
    public double price;

    //单位,20
    @ApiField("Unit")
    public String unit;

    //行总计
    @ApiField("LineTotal")
    public double lineTotal;

    //库存成本
    @ApiField("StockPrice")
    public double stockPrice;

    //库存金额
    @ApiField("StockValue")
    public double stockValue;

    //是否序列号管理
    @ApiField("NeedSerial")
    public boolean needSerial;

    //序列号
    @ApiField("SerialNumbers")
    public String serialNumbers;

    //原订单序列号
    @ApiField("SalesOrderSN")
    public String salesOrderSN;

	public int getAfterSaleServiceId() {
		return afterSaleServiceId;
	}

	public void setAfterSaleServiceId(int afterSaleServiceId) {
		this.afterSaleServiceId = afterSaleServiceId;
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

    public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	
	public String getShopOrderNo() {
		return shopOrderNo;
	}

	public void setShopOrderNo(String shopOrderNo) {
		this.shopOrderNo = shopOrderNo;
	}

	public String getShopLineNo() {
		return shopLineNo;
	}

	public void setShopLineNo(String shopLineNo) {
		this.shopLineNo = shopLineNo;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public double getStockValue() {
		return stockValue;
	}

	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}

	public boolean isNeedSerial() {
		return needSerial;
	}

	public void setNeedSerial(boolean needSerial) {
		this.needSerial = needSerial;
	}

	public String getSerialNumbers() {
		return serialNumbers;
	}

	public void setSerialNumbers(String serialNumbers) {
		this.serialNumbers = serialNumbers;
	}

	public String getSalesOrderSN() {
		return salesOrderSN;
	}

	public void setSalesOrderSN(String salesOrderSN) {
		this.salesOrderSN = salesOrderSN;
	}


}

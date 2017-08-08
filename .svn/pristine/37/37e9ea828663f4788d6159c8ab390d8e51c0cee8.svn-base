package com.iwilley.b1ec2.api.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

// 组合商品
public class Bom extends B1EC2Object {

	private static final long serialVersionUID = 5209861128857751738L;

	// 组合商品ID
	@ApiField("BomId")
	public int bomId;

	// 商品
	@ApiField("ItemId")
	public int itemId;

	@ApiField("ItemInfo")
	public ItemInfo itemInfo;

	// 商品编码
	@ApiField("ItemCode")
	public String itemCode;

	// 商品名称
	@ApiField("ItemName")
	public String itemName;

	// 规格编码
	@ApiField("SkuCode")
	public String skuCode;

	// 规格名称
	@ApiField("SkuName")
	public String skuName;

	// 单位
	@ApiField("Unit")
	public String unit;

	// 库存数量
	@ApiField("StockNum")
	public int stockNum;

	// 销售价格
	@ApiField("SalesPrice")
	public double salesPrice;

	// 备注
	@ApiField("Memo")
	public String memo;

	// 最后修改日期
	@ApiField("LastModifiedTime")
	public Date lastModifiedTime;

	// 最后修改人
	@ApiField("LastModifiedUser")
	public String lastModifiedUser;

	@ApiListField("Lines")
	@ApiField("BomLine")
	public List<BomLine> lines;

	public int getBomId() {
		return bomId;
	}

	public void setBomId(int bomId) {
		this.bomId = bomId;
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

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getStockNum() {
		return stockNum;
	}

	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public List<BomLine> getLines() {
		return lines;
	}

	public void setLines(List<BomLine> lines) {
		this.lines = lines;
	}
	
	public Bom() {
		lines = new ArrayList<BomLine>();
	}
}

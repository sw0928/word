package com.iwilley.b1ec2.api.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public class ShopItem extends B1EC2Object {

	private static final long serialVersionUID = 3902836561933167147L;

	// 宝贝编码，50
	@ApiField("ShopItemCode")
	public String shopItemCode;

	// 宝贝名称，100
	@ApiField("ShopItemName")
	public String shopItemName;

	// 发布类型，5
	@ApiField("Type")
	public String type;

	// 所属网店ID
	@ApiField("ShopId")
	public int shopId;

	@ApiField("Shop")
	public Shop shop;

	// 是否虚拟商品
	@ApiField("IsVirtual")
	public Boolean virtual;

	// 是否代销
	@ApiField("IsAgent")
	public Boolean agent;

	// 是否违规
	@ApiField("IsViolative")
	public Boolean violative;

	// 主图Url，254
	@ApiField("PictureUrl")
	public String pictureUrl;

	// 商家编码，50
	@ApiField("OuterId")
	public String outerId;

	// 商品数量
	@ApiField("Quantity")
	public int quantity;

	// 商品价格
	@ApiField("Price")
	public double price;

	// 体积(立方米）
	@ApiField("Size")
	public double size;

	// 重量（千克）
	@ApiField("Weight")
	public double weight;

	// onsale出售中；instock库中
	// 状态，20
	@ApiField("Status")
	public String status;

	// 备注，254
	@ApiField("Memo")
	public String memo;

	// 创建时间
	@ApiField("CreatedTime")
	public Date createdTime;

	// 修改时间
	@ApiField("UpdateTime")
	public Date updateTime;

	// 修改人，20
	@ApiField("UserSign")
	public String userSign;

	@ApiListField("Lines")
	@ApiField("ShopSku")
	public List<ShopSku> lines;

	public ShopItem() {
		lines = new ArrayList<ShopSku>();
	}

	public String getShopItemCode() {
		return shopItemCode;
	}

	public String getShopItemName() {
		return shopItemName;
	}

	public String getType() {
		return type;
	}

	public int getShopId() {
		return shopId;
	}

	public Shop getShop() {
		return shop;
	}

	public Boolean getVirtual() {
		return virtual;
	}

	public Boolean getAgent() {
		return agent;
	}

	public Boolean getViolative() {
		return violative;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public String getOuterId() {
		return outerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public double getSize() {
		return size;
	}

	public double getWeight() {
		return weight;
	}

	public String getStatus() {
		return status;
	}

	public String getMemo() {
		return memo;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public String getUserSign() {
		return userSign;
	}

	public List<ShopSku> getLines() {
		return lines;
	}

	public void setShopItemCode(String shopItemCode) {
		this.shopItemCode = shopItemCode;
	}

	public void setShopItemName(String shopItemName) {
		this.shopItemName = shopItemName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public void setVirtual(Boolean virtual) {
		this.virtual = virtual;
	}

	public void setAgent(Boolean agent) {
		this.agent = agent;
	}

	public void setViolative(Boolean violative) {
		this.violative = violative;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

	public void setLines(List<ShopSku> lines) {
		this.lines = lines;
	}

}

package com.iwilley.b1ec2.api.domain;

import java.util.Date;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

// 客户信息
public class Customer extends B1EC2Object {

	private static final long serialVersionUID = -7656982312624678740L;
	// 内部ID
	@ApiField("customerId")
	public int CustomerId;

	// 客户编码
	@ApiField("CustomerCode")
	public String customerCode;

	// 客户名称
	@ApiField("CustomerName")
	public String customerName;

	// 手机
	@ApiField("Mobile")
	public String mobile;

	// 收货人姓名
	@ApiField("ReceiverName")
	public String receiverName;

	// 省份
	@ApiField("Province")
	public String province;

	// 市
	@ApiField("City")
	public String city;

	// 区(县)
	@ApiField("District")
	public String district;

	// 详细地址
	@ApiField("Address")
	public String address;

	// 邮箱
	@ApiField("Email")
	public String email;

	// 邮编
	@ApiField("ZipCode")
	public String zipCode;

	// 渠道
	@ApiField("ShopType")
	public String shopType;

	// 来源店铺
	@ApiField("ShopId")
	public int shopId;

	@ApiField("Shop")
	public Shop shop;

	// 备注
	@ApiField("Memo")
	public String memo;

	// 买家信誉
	@ApiField("BuyerCredit")
	public String buyerCredit;

	// 会员等级
	@ApiField("LevelId")
	public int levelId;

	// 是否分销商
	@ApiField("IsFenXiao")
	public Boolean isFenXiao;

	// 最后修改日期
	@ApiField("LastModifiedTime")
	public Date lastModifiedTime;

	// 最后修改人
	@ApiField("LastModifiedUser")
	public String lastModifiedUser;

	// 自定义字段1
	@ApiField("UserDefinedField1")
	public String userDefinedField1;

	// 自定义字段2
	@ApiField("UserDefinedField2")
	public String userDefinedField2;

	public int getCustomerId() {
		return CustomerId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getMobile() {
		return mobile;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getShopType() {
		return shopType;
	}

	public int getShopId() {
		return shopId;
	}

	public Shop getShop() {
		return shop;
	}

	public String getMemo() {
		return memo;
	}

	public String getBuyerCredit() {
		return buyerCredit;
	}

	public int getLevelId() {
		return levelId;
	}

	public Boolean getIsFenXiao() {
		return isFenXiao;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public String getUserDefinedField1() {
		return userDefinedField1;
	}

	public String getUserDefinedField2() {
		return userDefinedField2;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setBuyerCredit(String buyerCredit) {
		this.buyerCredit = buyerCredit;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public void setIsFenXiao(Boolean isFenXiao) {
		this.isFenXiao = isFenXiao;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public void setUserDefinedField1(String userDefinedField1) {
		this.userDefinedField1 = userDefinedField1;
	}

	public void setUserDefinedField2(String userDefinedField2) {
		this.userDefinedField2 = userDefinedField2;
	}

}

package com.iwilley.b1ec2.api.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

// 平台订单
public class ShopOrder extends B1EC2Object {

	private static final long serialVersionUID = -2140339483271411744L;

	// 平台订单编号
	@ApiField("ShopOrderNo")
	public String shopOrderNo;

	// 网店
	@ApiField("ShopId")
	public int shopId;

	@ApiField("Shop")
	public Shop shop;

	// 转换状态
	@ApiField("ConvertStatus")
	public int convertStatus;

	// 网店订单状态
	// 0:草稿 10：未发货 20：已发货 30：已完结 40：已关闭 50：已取消
	@ApiField("OrderStatus")
	public int orderStatus;

	// 平台订单状态描述，如已付款，等待发货等等。都为中文描述，仅备注作用
	// 每次订单下载时，更新本字段
	// 平台订单状态
	@ApiField("OrderStatusName")
	public String orderStatusName;

	// 货到付款订单
	@ApiField("IsDistribution")
	public Boolean isCod;

	// 是否分销
	@ApiField("IsDistribution")
	public Boolean isDistribution;

	// 是否聚划算
	@ApiField("IsJhs")
	public Boolean isJhs;

	// 是否预售
	@ApiField("IsPresale")
	public Boolean isPresale;

	// 是否手机订单
	@ApiField("IsMobile")
	public Boolean isMobile;

	// 会员昵称
	@ApiField("MemberNick")
	public String memberNick;

	// 折扣金额
	@ApiField("DiscountFee")
	public double discountFee;

	// 邮费
	@ApiField("PostFee")
	public double postFee;

	// 调整金额
	@ApiField("AdjustFee")
	public double adjustFee;

	// 商品总额
	@ApiField("GoodsTotal")
	public double goodsTotal;

	// 应付金额
	@ApiField("OrderTotal")
	public double orderTotal;

	// 实际收款
	@ApiField("ReceivedTotal")
	public double receivedTotal;

	// 网站下单时间
	@ApiField("ShopCreatedTime")
	public Date shopCreatedTime;

	// 网站付款时间
	@ApiField("ShopPayTime")
	public Date shopPayTime;

	// 买家留言
	@ApiField("BuyerMemo")
	public String buyerMemo;

	// 卖家备注
	@ApiField("SellerMemo")
	public String sellerMemo;

	// 合法值为: blue,green,orange,pink,purple,red,yellow
	// 卖家旗帜
	@ApiField("ShopFlag")
	public String shopFlag;

	// 发票抬头
	@ApiField("InvoiceName")
	public String invoiceName;

	// 开票备注
	@ApiField("InvoiceMemo")
	public String invoiceMemo;

	// 0:无需发票;10:普通发票;20:增值税普通发票;25:增值税专用发票;30:收据;
	// 发票类型
	@ApiField("InvoiceType")
	public int invoiceType;

	// 快递公司
	@ApiField("ExpressName")
	public String expressName;

	// 快递单号
	@ApiField("ExpressTrackNo")
	public String expressTrackNo;

	// 买家支付宝
	@ApiField("BuyerAlipayNo")
	public String buyerAlipayNo;

	// 买家邮箱
	@ApiField("BuyerEmail")
	public String buyerEmail;

	// 支付宝付款编号
	@ApiField("AlipayOrderNo")
	public String alipayOrderNo;

	// 收货人姓名
	@ApiField("ReceiverName")
	public String receiverName;

	// 收货人省份
	@ApiField("ReceiverState")
	public String receiverState;

	// 收货人城市
	@ApiField("ReceiverCity")
	public String receiverCity;

	// 收货人地区
	@ApiField("ReceiverDistrict")
	public String receiverDistrict;

	// 收货人地址
	@ApiField("ReceiverAddress")
	public String receiverAddress;

	// 收货人邮编
	@ApiField("ReceiverZip")
	public String receiverZip;

	// 收货人手机
	@ApiField("ReceiverMobile")
	public String receiverMobile;

	// 收货人电话
	@ApiField("ReceiverPhone")
	public String receiverPhone;

	// 发货时间
	@ApiField("DeliveryTime")
	public Date deliveryTime;

	// 交易完成时间
	@ApiField("EndTime")
	public Date endTime;

	// 创建时间
	@ApiField("CreatedTime")
	public Date createdTime;

	// 自定义字段1
	@ApiField("UserDefinedField1")
	public String userDefinedField1;

	// 自定义字段2
	@ApiField("UserDefinedField2")
	public String userDefinedField2;

	@ApiListField("Lines")
	@ApiField("ShopOrderLine")
	public List<ShopOrderLine> lines;

	@ApiListField("Discounts")
	@ApiField("ShopOrderDiscount")
	public List<ShopOrderDiscount> discounts;

	@ApiListField("Payments")
	@ApiField("ShopOrderPayment")
	public List<ShopOrderPayment> payments;
	
	  @ApiField("CustomTax")
	    public double customTax;

	    @ApiField("CustomIdNo")
	    public String customIdNo;
	    
	    public String getCustomIdNo() {
			return customIdNo;
		}

		public void setCustomIdNo(String customIdNo) {
			this.customIdNo = customIdNo;
		}
	    
	    public double getCustomTax() {
			return customTax;
		}

		public void setCustomTax(int customTax) {
			this.customTax = customTax;
		}

	public ShopOrder() {
		lines = new ArrayList<ShopOrderLine>();
		discounts = new ArrayList<ShopOrderDiscount>();
		payments = new ArrayList<ShopOrderPayment>();
	}

	public String getShopOrderNo() {
		return shopOrderNo;
	}

	public int getShopId() {
		return shopId;
	}

	public Shop getShop() {
		return shop;
	}

	public int getConvertStatus() {
		return convertStatus;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public Boolean getIsCod() {
		return isCod;
	}

	public Boolean getIsDistribution() {
		return isDistribution;
	}

	public Boolean getIsJhs() {
		return isJhs;
	}

	public Boolean getIsPresale() {
		return isPresale;
	}

	public Boolean getIsMobile() {
		return isMobile;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public double getDiscountFee() {
		return discountFee;
	}

	public double getPostFee() {
		return postFee;
	}

	public double getAdjustFee() {
		return adjustFee;
	}

	public double getGoodsTotal() {
		return goodsTotal;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public double getReceivedTotal() {
		return receivedTotal;
	}

	public Date getShopCreatedTime() {
		return shopCreatedTime;
	}

	public Date getShopPayTime() {
		return shopPayTime;
	}

	public String getBuyerMemo() {
		return buyerMemo;
	}

	public String getSellerMemo() {
		return sellerMemo;
	}

	public String getShopFlag() {
		return shopFlag;
	}

	public String getInvoiceName() {
		return invoiceName;
	}

	public String getInvoiceMemo() {
		return invoiceMemo;
	}

	public int getInvoiceType() {
		return invoiceType;
	}

	public String getExpressName() {
		return expressName;
	}

	public String getExpressTrackNo() {
		return expressTrackNo;
	}

	public String getBuyerAlipayNo() {
		return buyerAlipayNo;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public String getAlipayOrderNo() {
		return alipayOrderNo;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverState() {
		return receiverState;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public String getReceiverDistrict() {
		return receiverDistrict;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public String getReceiverZip() {
		return receiverZip;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public String getUserDefinedField1() {
		return userDefinedField1;
	}

	public String getUserDefinedField2() {
		return userDefinedField2;
	}

	public List<ShopOrderLine> getLines() {
		return lines;
	}

	public List<ShopOrderDiscount> getDiscounts() {
		return discounts;
	}

	public List<ShopOrderPayment> getPayments() {
		return payments;
	}

	public void setShopOrderNo(String shopOrderNo) {
		this.shopOrderNo = shopOrderNo;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public void setConvertStatus(int convertStatus) {
		this.convertStatus = convertStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public void setIsCod(Boolean isCod) {
		this.isCod = isCod;
	}

	public void setIsDistribution(Boolean isDistribution) {
		this.isDistribution = isDistribution;
	}

	public void setIsJhs(Boolean isJhs) {
		this.isJhs = isJhs;
	}

	public void setIsPresale(Boolean isPresale) {
		this.isPresale = isPresale;
	}

	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public void setDiscountFee(double discountFee) {
		this.discountFee = discountFee;
	}

	public void setPostFee(double postFee) {
		this.postFee = postFee;
	}

	public void setAdjustFee(double adjustFee) {
		this.adjustFee = adjustFee;
	}

	public void setGoodsTotal(double goodsTotal) {
		this.goodsTotal = goodsTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public void setReceivedTotal(double receivedTotal) {
		this.receivedTotal = receivedTotal;
	}

	public void setShopCreatedTime(Date shopCreatedTime) {
		this.shopCreatedTime = shopCreatedTime;
	}

	public void setShopPayTime(Date shopPayTime) {
		this.shopPayTime = shopPayTime;
	}

	public void setBuyerMemo(String buyerMemo) {
		this.buyerMemo = buyerMemo;
	}

	public void setSellerMemo(String sellerMemo) {
		this.sellerMemo = sellerMemo;
	}

	public void setShopFlag(String shopFlag) {
		this.shopFlag = shopFlag;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public void setInvoiceMemo(String invoiceMemo) {
		this.invoiceMemo = invoiceMemo;
	}

	public void setInvoiceType(int invoiceType) {
		this.invoiceType = invoiceType;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public void setExpressTrackNo(String expressTrackNo) {
		this.expressTrackNo = expressTrackNo;
	}

	public void setBuyerAlipayNo(String buyerAlipayNo) {
		this.buyerAlipayNo = buyerAlipayNo;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public void setAlipayOrderNo(String alipayOrderNo) {
		this.alipayOrderNo = alipayOrderNo;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public void setReceiverDistrict(String receiverDistrict) {
		this.receiverDistrict = receiverDistrict;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public void setUserDefinedField1(String userDefinedField1) {
		this.userDefinedField1 = userDefinedField1;
	}

	public void setUserDefinedField2(String userDefinedField2) {
		this.userDefinedField2 = userDefinedField2;
	}

	public void setLines(List<ShopOrderLine> lines) {
		this.lines = lines;
	}

	public void setDiscounts(List<ShopOrderDiscount> discounts) {
		this.discounts = discounts;
	}

	public void setPayments(List<ShopOrderPayment> payments) {
		this.payments = payments;
	}
}

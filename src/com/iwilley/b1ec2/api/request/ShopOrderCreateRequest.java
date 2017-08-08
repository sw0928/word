package com.iwilley.b1ec2.api.request;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.domain.ShopOrderCreateDiscount;
import com.iwilley.b1ec2.api.domain.ShopOrderCreateLine;
import com.iwilley.b1ec2.api.domain.ShopOrderCreatePayment;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.ShopOrderCreateResponse;

// 平台锟斤拷锟斤拷锟斤拷锟斤拷
public class ShopOrderCreateRequest implements
		B1EC2Request<ShopOrderCreateResponse> {

	// 平台锟斤拷锟斤拷锟斤拷锟�
	public String shopOrderNo;

	// 锟斤拷锟斤拷ID
	public Integer shopId;

	// 锟斤拷锟疥订锟斤拷状态
	// 0:锟捷革拷 10锟斤拷未锟斤拷锟斤拷 20锟斤拷锟窖凤拷锟斤拷 30锟斤拷锟斤拷锟斤拷锟� 40锟斤拷锟窖关憋拷 50锟斤拷锟斤拷取锟斤拷
	public Integer orderStatus;

	// 平台锟斤拷锟斤拷状态锟斤拷锟斤拷锟斤拷锟斤拷锟窖革拷锟筋，锟饺达拷锟斤拷锟斤拷锟饺等★拷锟斤拷为锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷注锟斤拷锟斤拷
	// 每锟轿讹拷锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷锟铰憋拷锟街讹拷
	// 平台锟斤拷锟斤拷状态
	public String orderStatusName;

	// 锟斤拷锟斤拷锟斤拷锟筋订锟斤拷
	public Boolean isCod;

	// 锟角凤拷锟斤拷锟�
	public Boolean isDistribution;

	// 锟角凤拷刍锟斤拷锟�
	public Boolean isJhs;

	// 锟角凤拷预锟斤拷
	public Boolean isPresale;

	// 锟角凤拷锟街伙拷锟斤拷锟斤拷
	public Boolean isMobile;

	// 锟斤拷员锟角筹拷
	public String memberNick;

	// 锟桔扣斤拷锟�
	public Double discountFee;

	// 锟绞凤拷
	public Double postFee;

	// 锟斤拷锟斤拷锟斤拷锟�
	public Double adjustFee;

	// 锟斤拷品锟杰讹拷
	public Double goodsTotal;

	// 应锟斤拷锟斤拷锟�
	public Double orderTotal;

	// 实锟斤拷锟秸匡拷
	public Double receivedTotal;

	// 锟斤拷站锟铰碉拷时锟斤拷
	public Date shopCreatedTime;

	// 锟斤拷站锟斤拷锟斤拷时锟斤拷
	public Date shopPayTime;

	// 锟斤拷锟斤拷锟斤拷锟�
	public String buyerMemo;

	// 锟斤拷锟揭憋拷注
	public String sellerMemo;

	// 锟较凤拷值为: blue,green,orange,pink,purple,red,yellow
	// 锟斤拷锟斤拷锟斤拷锟斤拷
	public String shopFlag;

	// 锟斤拷票抬头
	public String invoiceName;

	// 锟斤拷票锟斤拷注
	public String invoiceMemo;

	// 0:锟斤拷锟借发票;10:锟斤拷通锟斤拷票;20:锟斤拷值税锟斤拷通锟斤拷票;25:锟斤拷值税专锟矫凤拷票;30:锟秸撅拷;
	// 锟斤拷票锟斤拷锟斤拷
	public Integer invoiceType;

	// 锟斤拷莨锟剿�
	public String expressName;

	// 锟斤拷莸锟斤拷锟�
	public String expressTrackNo;

	// 锟斤拷锟街э拷锟斤拷锟�
	public String buyerAlipayNo;

	// 锟斤拷锟斤拷锟斤拷锟�
	public String buyerEmail;

	// 支锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	public String alipayOrderNo;

	// 锟秸伙拷锟斤拷锟斤拷锟斤拷
	public String receiverName;

	// 锟秸伙拷锟斤拷省锟斤拷
	public String receiverState;

	// 锟秸伙拷锟剿筹拷锟斤拷
	public String receiverCity;

	// 锟秸伙拷锟剿碉拷锟斤拷
	public String receiverDistrict;

	// 锟秸伙拷锟剿碉拷址
	public String receiverAddress;

	// 锟秸伙拷锟斤拷锟绞憋拷
	public String receiverZip;

	// 锟秸伙拷锟斤拷锟街伙拷
	public String receiverMobile;

	// 锟秸伙拷锟剿电话
	public String receiverPhone;

	// 锟斤拷锟斤拷时锟斤拷
	public Date reliveryTime;

	// 锟斤拷锟斤拷锟斤拷锟绞憋拷锟�
	public Date endTime;

	// 锟皆讹拷锟斤拷锟街讹拷1
	public String userDefinedField1;

	// 锟皆讹拷锟斤拷锟街讹拷2
	public String userDefinedField2;
	
	//税锟斤拷
    public double customTax;
    //锟斤拷锟街わ拷锟斤拷锟�
	public String customIdNo;
	
	
	public String customName;
	//税锟斤拷
    public String customPaymentName;
    //锟斤拷锟街わ拷锟斤拷锟�
	public String customPaymentNo;
	

	private List<ShopOrderCreateLine> itemLines;

	private List<ShopOrderCreateDiscount> discountLines;

	private List<ShopOrderCreatePayment> paymentLines;
	
	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getApiMethodName() {
		return "B1EC2.ShopOrder.Push";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("ShopOrderNo", shopOrderNo);
		parameters.put("ShopId", shopId);
		parameters.put("OrderStatus", orderStatus);
		parameters.put("OrderStatusName", orderStatusName);
		parameters.put("IsCod", isCod);
		parameters.put("IsDistribution", isDistribution);
		parameters.put("IsJhs", isJhs);
		parameters.put("IsPresale", isPresale);
		parameters.put("IsMobile", isMobile);
		parameters.put("MemberNick", memberNick);
		parameters.put("DiscountFee", discountFee);
		parameters.put("PostFee", postFee);
		parameters.put("AdjustFee", adjustFee);
		parameters.put("GoodsTotal", goodsTotal);
		parameters.put("OrderTotal", orderTotal);
		parameters.put("ReceivedTotal", receivedTotal);
		parameters.put("ShopCreatedTime", shopCreatedTime);
		parameters.put("ShopPayTime", shopPayTime);
		parameters.put("BuyerMemo", buyerMemo);
		parameters.put("SellerMemo", sellerMemo);
		parameters.put("ShopFlag", shopFlag);
		parameters.put("InvoiceName", invoiceName);
		parameters.put("InvoiceMemo", invoiceMemo);
		parameters.put("InvoiceType", invoiceType);
		parameters.put("ExpressName", expressName);
		parameters.put("ExpressTrackNo", expressTrackNo);
		parameters.put("BuyerAlipayNo", buyerAlipayNo);
		parameters.put("BuyerEmail", buyerEmail);
		parameters.put("AlipayOrderNo", alipayOrderNo);
		parameters.put("ReceiverName", receiverName);
		parameters.put("ReceiverState", receiverState);
		parameters.put("ReceiverCity", receiverCity);
		parameters.put("ReceiverDistrict", receiverDistrict);
		parameters.put("ReceiverAddress", receiverAddress);
		parameters.put("ReceiverZip", receiverZip);
		parameters.put("ReceiverMobile", receiverMobile);
		parameters.put("ReceiverPhone", receiverPhone);
		parameters.put("ReliveryTime", reliveryTime);
		parameters.put("EndTime", endTime);
		parameters.put("UserDefinedField1", userDefinedField1);
		parameters.put("UserDefinedField2", userDefinedField2);
		parameters.put("CustomTax", customTax);
		parameters.put("CustomIdNo", customIdNo);
		parameters.put("customName", customName);
		parameters.put("CustomPaymentName", customPaymentName);
		parameters.put("CustomPaymentNo", customPaymentNo);
		if (itemLines != null && itemLines.size() > 0) {
			StringBuffer lineInfo = new StringBuffer();
			for (ShopOrderCreateLine itemLine : itemLines) {
				lineInfo.append(itemLine.getShopLineNo());
				lineInfo.append(":");
				lineInfo.append(itemLine.getOuterId());
				lineInfo.append(":");
				lineInfo.append(itemLine.getQuantity());
				lineInfo.append(":");
				lineInfo.append(itemLine.getPrice());
				lineInfo.append(":");
				lineInfo.append(itemLine.getLineUdf1());
				lineInfo.append(":");
				lineInfo.append(itemLine.getLineUdf2());
				lineInfo.append(":");
				lineInfo.append(itemLine.getitemName());
				lineInfo.append(":");
				lineInfo.append(itemLine.getskuName());
				lineInfo.append(":");
				lineInfo.append(itemLine.getLineTotal());
				lineInfo.append(":");
				lineInfo.append(itemLine.getLineCustomTotal());
				lineInfo.append(":");
				lineInfo.append(itemLine.getLineCustomTax());
				lineInfo.append(";");
			}
			parameters.put("ItemLineInfo", lineInfo.toString());
		}
		if (discountLines != null && discountLines.size() > 0) {
			StringBuffer lineInfo = new StringBuffer();
			for (ShopOrderCreateDiscount itemLine : discountLines) {
				lineInfo.append(itemLine.getDiscountName());
				lineInfo.append(":");
				lineInfo.append(itemLine.getDiscountFee());
				lineInfo.append(";");
			}
			parameters.put("DiscountLineInfo", lineInfo.toString());
		}
		if (paymentLines != null && paymentLines.size() > 0) {
			StringBuffer lineInfo = new StringBuffer();
			for (ShopOrderCreatePayment itemLine : paymentLines) {
				lineInfo.append(itemLine.getPaymentId());
				lineInfo.append(":");
				lineInfo.append(itemLine.getPaymentTotal());
				lineInfo.append(":");
				lineInfo.append(itemLine.getPaymentNo());
				lineInfo.append(";");
			}
			parameters.put("PaymentLineInfo", lineInfo.toString());
		}
		return parameters;
	}

	public Class<ShopOrderCreateResponse> getResponseClass() {
		return ShopOrderCreateResponse.class;
	}

	public String getShopOrderNo() {
		return shopOrderNo;
	}

	public Integer getShopId() {
		return shopId;
	}

	public Integer getOrderStatus() {
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

	public Double getDiscountFee() {
		return discountFee;
	}

	public Double getPostFee() {
		return postFee;
	}

	public Double getAdjustFee() {
		return adjustFee;
	}

	public Double getGoodsTotal() {
		return goodsTotal;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public Double getReceivedTotal() {
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

	public Integer getInvoiceType() {
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

	public Date getReliveryTime() {
		return reliveryTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public String getUserDefinedField1() {
		return userDefinedField1;
	}

	public String getUserDefinedField2() {
		return userDefinedField2;
	}

	public List<ShopOrderCreateLine> getItemLines() {
		return itemLines;
	}

	public List<ShopOrderCreateDiscount> getDiscountLines() {
		return discountLines;
	}

	public List<ShopOrderCreatePayment> getPaymentLines() {
		return paymentLines;
	}

	public void setShopOrderNo(String shopOrderNo) {
		this.shopOrderNo = shopOrderNo;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public void setOrderStatus(Integer orderStatus) {
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

	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}

	public void setPostFee(Double postFee) {
		this.postFee = postFee;
	}

	public void setAdjustFee(Double adjustFee) {
		this.adjustFee = adjustFee;
	}

	public void setGoodsTotal(Double goodsTotal) {
		this.goodsTotal = goodsTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public void setReceivedTotal(Double receivedTotal) {
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

	public void setInvoiceType(Integer invoiceType) {
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

	public void setReliveryTime(Date reliveryTime) {
		this.reliveryTime = reliveryTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setUserDefinedField1(String userDefinedField1) {
		this.userDefinedField1 = userDefinedField1;
	}

	public void setUserDefinedField2(String userDefinedField2) {
		this.userDefinedField2 = userDefinedField2;
	}

	public void setItemLines(List<ShopOrderCreateLine> itemLines) {
		this.itemLines = itemLines;
	}

	public void setDiscountLines(List<ShopOrderCreateDiscount> discountLines) {
		this.discountLines = discountLines;
	}

	public void setPaymentLines(List<ShopOrderCreatePayment> paymentLines) {
		this.paymentLines = paymentLines;
	}
   
	
	public String getCustomIdNo() {
		return customIdNo;
	}

	public void setCustomIdNo(String customIdNo) {
		this.customIdNo = customIdNo;
	}
    
    public double getCustomTax() {
		return customTax;
	}

	public void setCustomTax(double customTax) {
		this.customTax = customTax;
	}
	
	
	public String getCustomPaymentName() {
			return customPaymentName;
		}

    public void setCustomPaymentName(String customPaymentName) {
			this.customPaymentName = customPaymentName;
		}
		
    public String getCustomPaymentNo() {
		   return customPaymentNo;
	}

	public void setCustomPaymentNo(String customPaymentNo) {
		   this.customPaymentNo = customPaymentNo;
	}
	
	
}

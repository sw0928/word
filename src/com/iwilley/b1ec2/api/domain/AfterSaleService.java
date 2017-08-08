package com.iwilley.b1ec2.api.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

//售后单主表
public class AfterSaleService extends B1EC2Object {

	private static final long serialVersionUID = 608467493460864875L;

	//售后单ID
    @ApiField("AfterSaleServiceId")
    public int afterSaleServiceId;

    //版本
    @ApiField("Version")
    public int version;

    //40+年月日+六位流水号,14
    @ApiField("AfterSaleServiceNo")
    public String afterSaleServiceNo;

    //店铺ID
    @ApiField("ShopId")
    public Integer shopId;

    //店铺(注:只返回店铺名称)
    @ApiField("Shop")
    public Shop shop;

    //客户代码,10
    @ApiField("CustomerCode") 
    public String customerCode;

    //客户名称,50
    @ApiField("CustomerName")
    public String customerName;

    //售后类型
    //退货退款10 仅退款20  换货 30 疑难 40 补发货 50
    @ApiField("Type")
    public int type;

    //售后状态
    // 草稿 10  待处理 20  已完结  30   删除 90
    @ApiField("Status")
    public int status;

    //发货仓库 补发货/换货 才有
    @ApiField("DeliverWhsId")
    public Integer deliverWhsId;

    //退货仓库
    @ApiField("ReturnWhsId")
    public Integer returnWhsId;

    //退货仓库(注:只返回仓库名称 id)
    @ApiField("ReturnWarehouse")
    public  Warehouse returnWarehouse;

    //订单id
    @ApiField("OrderId")
    public Integer  orderId;

    //系统订单号,14
    @ApiField("OrderNo")
    public String orderNo;

    //网站订单状态,10
    @ApiField("ShopOrderStatus")
    public String shopOrderStatus;

    //换货新订单单ID
    @ApiField("ExchangeOrderId")
    public Integer exchangeOrderId;

    //网站售后单号,30
    @ApiField("ShopRefundNo")
    public String shopRefundNo;

    //退回原因
    @ApiField("ReasonId")
    public Integer  reasonId;

    //退回备注,254
    @ApiField("RefundMemo")
    public String refundMemo;

    //应退金额
    @ApiField("RefundFeeTotal")
    public double refundFeeTotal;

    //实退金额
    @ApiField("ActualRefundFee")
    public double actualRefundFee;

    //实补金额
    @ApiField("ActualFillUpFee")
    public double actualFillUpFee;

    //应补金额
    @ApiField("FillUpFee")
    public double fillUpFee;

    //商品应退总计
    @ApiField("GoodsTotal")
    public double goodsTotal;

    //收货人姓名,50
    @ApiField("ReceiverName")
    public String receiverName;

    //收货人省份,32
    @ApiField("ReceiverState")
    public String receiverState;

    //收货人城市,32
    @ApiField("ReceiverCity")
    public String receiverCity;

    //收货人地区,32
    @ApiField("ReceiverDistrict")
    public String receiverDistrict;

    //收货人地址,228
    @ApiField("ReceiverAddress")
    public String receiverAddress;

    //收货人邮编,6
    @ApiField("ReceiverZip")
    public String receiverZip;

    //收货人手机,30
    @ApiField("ReceiverMobile")
    public String receiverMobile;

    //收货人电话,30
    @ApiField("ReceiverPhone")
    public String receiverPhone;

    //卖家备注,1000
    @ApiField("SellerMemo")
    public String sellerMemo;

    //发货快递公司 换货/补发货 才有
    @ApiField("DeliverExpressId")
    public Integer deliverExpressId;

    //退回快递公司id
    @ApiField("ReturnExpressId")
    public Integer returnExpressId;

    //快递公司 (注:只返回快递名称)
    @ApiField("ReturnExpress")
    public  Express returnExpress;

    //退货快递单号,20
    @ApiField("ExpressTrackNo")
    public String expressTrackNo;

    //买家支付宝,100
    @ApiField("BuyerAlipayNo")
    public String buyerAlipayNo;

    //创建时间
    @ApiField("CreatedTime")
    public Date createdTime;

    //更新时间
    @ApiField("UpdateTime")
    public Date updateTime;

    //最后修改人,20
    @ApiField("LastModifiedUser")
    public String lastModifiedUser;

    //最后修改类型
    //10,制单;21,入库;22,确认;30,打款；60,更新；90，删除;
    @ApiField("LastModifiedType")
    public int lastModifiedType;
    
    @ApiField("UserDefinedField1")
    public String userDefinedField1;
    
    //退货行
    @ApiListField("ItemLines")
    @ApiField("AfterSaleItemLine")
    public List<AfterSaleItemLine> itemLines;

    public AfterSaleService()
    {
    	itemLines = new ArrayList<AfterSaleItemLine>();
    }

	public int getAfterSaleServiceId() {
		return afterSaleServiceId;
	}

	public void setAfterSaleServiceId(int afterSaleServiceId) {
		this.afterSaleServiceId = afterSaleServiceId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getAfterSaleServiceNo() {
		return afterSaleServiceNo;
	}

	public void setAfterSaleServiceNo(String afterSaleServiceNo) {
		this.afterSaleServiceNo = afterSaleServiceNo;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getDeliverWhsId() {
		return deliverWhsId;
	}

	public void setDeliverWhsId(Integer deliverWhsId) {
		this.deliverWhsId = deliverWhsId;
	}

	public Integer getReturnWhsId() {
		return returnWhsId;
	}

	public void setReturnWhsId(Integer returnWhsId) {
		this.returnWhsId = returnWhsId;
	}

	public Warehouse getReturnWarehouse() {
		return returnWarehouse;
	}

	public void setReturnWarehouse(Warehouse returnWarehouse) {
		this.returnWarehouse = returnWarehouse;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getShopOrderStatus() {
		return shopOrderStatus;
	}

	public void setShopOrderStatus(String shopOrderStatus) {
		this.shopOrderStatus = shopOrderStatus;
	}

	public Integer getExchangeOrderId() {
		return exchangeOrderId;
	}

	public void setExchangeOrderId(Integer exchangeOrderId) {
		this.exchangeOrderId = exchangeOrderId;
	}

	public String getShopRefundNo() {
		return shopRefundNo;
	}

	public void setShopRefundNo(String shopRefundNo) {
		this.shopRefundNo = shopRefundNo;
	}

	public Integer getReasonId() {
		return reasonId;
	}

	public void setReasonId(Integer reasonId) {
		this.reasonId = reasonId;
	}

	public String getRefundMemo() {
		return refundMemo;
	}

	public void setRefundMemo(String refundMemo) {
		this.refundMemo = refundMemo;
	}

	public double getRefundFeeTotal() {
		return refundFeeTotal;
	}

	public void setRefundFeeTotal(double refundFeeTotal) {
		this.refundFeeTotal = refundFeeTotal;
	}

	public double getActualRefundFee() {
		return actualRefundFee;
	}

	public void setActualRefundFee(double actualRefundFee) {
		this.actualRefundFee = actualRefundFee;
	}

	public double getActualFillUpFee() {
		return actualFillUpFee;
	}

	public void setActualFillUpFee(double actualFillUpFee) {
		this.actualFillUpFee = actualFillUpFee;
	}

	public double getFillUpFee() {
		return fillUpFee;
	}

	public void setFillUpFee(double fillUpFee) {
		this.fillUpFee = fillUpFee;
	}

	public double getGoodsTotal() {
		return goodsTotal;
	}

	public void setGoodsTotal(double goodsTotal) {
		this.goodsTotal = goodsTotal;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverState() {
		return receiverState;
	}

	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverDistrict() {
		return receiverDistrict;
	}

	public void setReceiverDistrict(String receiverDistrict) {
		this.receiverDistrict = receiverDistrict;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverZip() {
		return receiverZip;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getSellerMemo() {
		return sellerMemo;
	}

	public void setSellerMemo(String sellerMemo) {
		this.sellerMemo = sellerMemo;
	}

	public Integer getDeliverExpressId() {
		return deliverExpressId;
	}

	public void setDeliverExpressId(Integer deliverExpressId) {
		this.deliverExpressId = deliverExpressId;
	}

	public Integer getReturnExpressId() {
		return returnExpressId;
	}

	public void setReturnExpressId(Integer returnExpressId) {
		this.returnExpressId = returnExpressId;
	}

	public Express getReturnExpress() {
		return returnExpress;
	}

	public void setReturnExpress(Express returnExpress) {
		this.returnExpress = returnExpress;
	}

	public String getExpressTrackNo() {
		return expressTrackNo;
	}

	public void setExpressTrackNo(String expressTrackNo) {
		this.expressTrackNo = expressTrackNo;
	}

	public String getBuyerAlipayNo() {
		return buyerAlipayNo;
	}

	public void setBuyerAlipayNo(String buyerAlipayNo) {
		this.buyerAlipayNo = buyerAlipayNo;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public int getLastModifiedType() {
		return lastModifiedType;
	}

	public void setLastModifiedType(int lastModifiedType) {
		this.lastModifiedType = lastModifiedType;
	}

	public List<AfterSaleItemLine> getItemLines() {
		return itemLines;
	}

	public void setItemLines(List<AfterSaleItemLine> itemLines) {
		this.itemLines = itemLines;
	}

	public String getUserDefinedField1() {
		return userDefinedField1;
	}

	public void setUserDefinedField1(String userDefinedField1) {
		this.userDefinedField1 = userDefinedField1;
	}


}

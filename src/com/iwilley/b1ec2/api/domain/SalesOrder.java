package com.iwilley.b1ec2.api.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

//销售订单主表
public class SalesOrder extends B1EC2Object {

	private static final long serialVersionUID = -8800777970088480989L;

	//订单ID
    @ApiField("OrderId")
    public int orderId;

    //版本
    @ApiField("Version")
    public int version;

    //系统订单号
    @ApiField("OrderNo")
    public String orderNo;

    //店铺ID
    @ApiField("ShopId")
    public int shopId;

    //店铺(注:只返回店铺名称)
    @ApiField("Shop")
    public Shop shop;

    //会员代码
    @ApiField("CustomerCode")
    public String customerCode;

    //会员名称
    @ApiField("CustomerName")
    public String customerName;

    //仓库ID
    @ApiField("WhsId")
    public int whsId;

    //仓库(注:只返回仓库名称)
    @ApiField("Warehouse")
    public Warehouse warehouse;

    //订单类型(10:正常订单;20:货到付款;30:虚拟订单;40:代销订单)
    @ApiField("OrderType")
    public int orderType;

    //系统订单状态 
    //10:待客审;20:待财审;30:审批通过;40:开始拣货;43:已验货;45:已称重;60:已交货;70:已完成;80:已关闭;90:已取消;99:已删除;
    @ApiField("OrderStatus")
    public int orderStatus;

    //订单标签
    //使用组合码体现, 如1表示合单,2表示拆单,4表示急单; 3表示合单+拆单,5表示合单+急单,7表示合单+拆单+急单
    // 1,合;2,拆;4,聚;8,急;16,退;32,换;64,手;128,分;256,预;512,超;1024,途;2048,补;
    @ApiField("OrderTag")
    public int orderTag;

    //拦截原因
    @ApiField("ReasonId")
    public Integer reasonId;

    //拦截原因
    @ApiField("HoldingReason")
    public HoldingReason holdingReason;

    //拦截备注,254
    @ApiField("HoldingMemo")
    public String holdingMemo;

    //总件数
    //注意, 虚拟商品不放入总件数中
    @ApiField("TotalNum")
    public double totalNum;

    //折扣金额
    @ApiField("DiscountFee")
    public double discountFee;

    //调整金额
    @ApiField("AdjustFee")
    public double adjustFee;

    //商品总额
    @ApiField("GoodsTotal")
    public double goodsTotal;

    //应付金额
    @ApiField("OrderTotal")
    public double orderTotal;

    //计算金额
    //按此金额计算是否进入财审
    //金额具体计算规则参考设置中ApprovalOrder2Type字段
    @ApiField("CalcTotal")
    public double calcTotal;

    //成本总计
    @ApiField("StockTotal")
    public double stockTotal;

    //平台订单编号,254
    //网店订单编号，如果合单则多个订单通过逗号分隔
    @ApiField("ShopOrderNo")
    public String shopOrderNo;

    //平台订单状态,10
    //平台订单状态描述，如已付款，等待发货等等。都为中文描述，仅备注作用
    //每次订单下载时，更新本字段
    @ApiField("ShopOrderStatus")
    public String shopOrderStatus;

    //网站下单时间
    @ApiField("ShopCreatedTime")
    public Date shopCreatedTime;

    //网站付款时间
    @ApiField("ShopPayTime")
    public Date shopPayTime;

    //买家留言,1000
    @ApiField("BuyerMemo")
    public String buyerMemo;

    //卖家备注,1000
    @ApiField("SellerMemo")
    public String sellerMemo;

    //系统备注,254
    @ApiField("OrderMemo")
    public String orderMemo;

    //网店旗帜,6;red;green;yellow...
    @ApiField("ShopFlag")
    public String shopFlag;

    //开票状态(10:未开票;20:已开票;)
    @ApiField("InvoiceStatus")
    public int invoiceStatus;

    //开票类型(10:普票;20:增票;)
    @ApiField("InvoiceType")
    public int invoiceType;

    //开票金额
    @ApiField("InvoiceTotal")
    public double invoiceTotal;

    //发票抬头,100
    @ApiField("InvoiceName")
    public String invoiceName;

    //开票备注,254
    @ApiField("InvoiceMemo")
    public String invoiceMemo;

    //发票快递号,20
    @ApiField("InvoiceExpressNo")
    public String invoiceExpressNo;

    //买家支付宝,100
    @ApiField("BuyerAlipayNo")
    public String buyerAlipayNo;

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

    //快递公司ID
    @ApiField("ExpressId")
    public int expressId;

    //快递公司 (注:只返回快递名称)
    @ApiField("Express")
    public Express express;

    //快递单号,20
    @ApiField("ExpressTrackNo")
    public String expressTrackNo;

    //打印标签
    //使用组合码体现, 范例参考订单标签
    // 1,打印快递单;2,打印交货单;4,打印拣货单;
    @ApiField("PrintTag")
    public int printTag;

    //快递单打印批次
    @ApiField("PrintBatchNo")
    public String printBatchNo;

    //要求发货日
    @ApiField("ExpectedDeliveryDate")
    public Date expectedDeliveryDate;

    //实际发货时间
    @ApiField("DeliveryTime")
    public Date deliveryTime;

    //交易完成时间
    @ApiField("EndTime")
    public Date endTime;

    //标准物流成本
    @ApiField("StdPostFee")
    public double stdPostFee;

    //称重物流成本
    @ApiField("CostPostFee")
    public double costPostFee;

    //物流费用
    @ApiField("ActPostFee")
    public double actPostFee;

    //包裹标准重量
    @ApiField("EstimatedWeight")
    public double estimatedWeight;

    //包裹称重重量
    @ApiField("ActualWeight")
    public double actualWeight;

    //创建人,20,Not Null
    @ApiField("Creator")
    public String creator;

    //创建时间
    @ApiField("CreatedTime")
    public Date createdTime;

    //最后修改时间
    @ApiField("LastModifiedTime")
    public Date lastModifiedTime;

    //最后修改人,20
    @ApiField("LastModifiedUser")
    public String lastModifiedUser;

    //最后修改类型
    //10,制单;12,合单;14,拆单;20,客审;21财审;22,打回待审;23客审进财审;24,配货;25,验货;26,称重;27,交货;28,交易完成;29,关闭订单;30,取消;
    //40,拦截;42解除拦截;50,打印物流;52,打印发货;54,打印拣货;60,更新;
    @ApiField("LastModifiedType")
    public int lastModifiedType;

    //自定义字段1
    @ApiField("UserDefinedField1")
    public String userDefinedField1;

    //自定义字段2
    @ApiField("UserDefinedField2")
    public String userDefinedField2;

    //自定义字段3
    @ApiField("UserDefinedField3")
    public String userDefinedField3;

    //自定义字段4
    @ApiField("UserDefinedField4")
    public String userDefinedField4;

    //自定义字段5
    @ApiField("UserDefinedField5")
    public String userDefinedField5;

	//自定义数字6
    @ApiField("UserDefinedField6")
    public Double userDefinedField6;

    //自定义数字7
    @ApiField("UserDefinedField7")
    public Double userDefinedField7;

    //自定义数字8
    @ApiField("UserDefinedField8")
    public Date userDefinedField8;
    
    //自定义字段9
    @ApiField("UserDefinedField9")
    public String userDefinedField9;
    
    //自定义字段10
    @ApiField("UserDefinedField10")
    public String userDefinedField10;
    
    //自定义字段11
    @ApiField("UserDefinedField11")
    public String userDefinedField11;

    @ApiListField("Lines")
    @ApiField("SalesOrderLine")
    public List<SalesOrderLine> lines;
    
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
	
    
    public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
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

	public int getWhsId() {
		return whsId;
	}

	public void setWhsId(int whsId) {
		this.whsId = whsId;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderTag() {
		return orderTag;
	}

	public void setOrderTag(int orderTag) {
		this.orderTag = orderTag;
	}

	public Integer getReasonId() {
		return reasonId;
	}

	public void setReasonId(Integer reasonId) {
		this.reasonId = reasonId;
	}

	public HoldingReason getHoldingReason() {
		return holdingReason;
	}

	public void setHoldingReason(HoldingReason holdingReason) {
		this.holdingReason = holdingReason;
	}

	public String getHoldingMemo() {
		return holdingMemo;
	}

	public void setHoldingMemo(String holdingMemo) {
		this.holdingMemo = holdingMemo;
	}

	public double getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(double totalNum) {
		this.totalNum = totalNum;
	}

	public double getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(double discountFee) {
		this.discountFee = discountFee;
	}

	public double getAdjustFee() {
		return adjustFee;
	}

	public void setAdjustFee(double adjustFee) {
		this.adjustFee = adjustFee;
	}

	public double getGoodsTotal() {
		return goodsTotal;
	}

	public void setGoodsTotal(double goodsTotal) {
		this.goodsTotal = goodsTotal;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public double getCalcTotal() {
		return calcTotal;
	}

	public void setCalcTotal(double calcTotal) {
		this.calcTotal = calcTotal;
	}

	public double getStockTotal() {
		return stockTotal;
	}

	public void setStockTotal(double stockTotal) {
		this.stockTotal = stockTotal;
	}

	public String getShopOrderNo() {
		return shopOrderNo;
	}

	public void setShopOrderNo(String shopOrderNo) {
		this.shopOrderNo = shopOrderNo;
	}

	public String getShopOrderStatus() {
		return shopOrderStatus;
	}

	public void setShopOrderStatus(String shopOrderStatus) {
		this.shopOrderStatus = shopOrderStatus;
	}

	public Date getShopCreatedTime() {
		return shopCreatedTime;
	}

	public void setShopCreatedTime(Date shopCreatedTime) {
		this.shopCreatedTime = shopCreatedTime;
	}

	public Date getShopPayTime() {
		return shopPayTime;
	}

	public void setShopPayTime(Date shopPayTime) {
		this.shopPayTime = shopPayTime;
	}

	public String getBuyerMemo() {
		return buyerMemo;
	}

	public void setBuyerMemo(String buyerMemo) {
		this.buyerMemo = buyerMemo;
	}

	public String getSellerMemo() {
		return sellerMemo;
	}

	public void setSellerMemo(String sellerMemo) {
		this.sellerMemo = sellerMemo;
	}

	public String getOrderMemo() {
		return orderMemo;
	}

	public void setOrderMemo(String orderMemo) {
		this.orderMemo = orderMemo;
	}

	public String getShopFlag() {
		return shopFlag;
	}

	public void setShopFlag(String shopFlag) {
		this.shopFlag = shopFlag;
	}

	public int getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(int invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public int getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(int invoiceType) {
		this.invoiceType = invoiceType;
	}

	public double getInvoiceTotal() {
		return invoiceTotal;
	}

	public void setInvoiceTotal(double invoiceTotal) {
		this.invoiceTotal = invoiceTotal;
	}

	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public String getInvoiceMemo() {
		return invoiceMemo;
	}

	public void setInvoiceMemo(String invoiceMemo) {
		this.invoiceMemo = invoiceMemo;
	}

	public String getInvoiceExpressNo() {
		return invoiceExpressNo;
	}

	public void setInvoiceExpressNo(String invoiceExpressNo) {
		this.invoiceExpressNo = invoiceExpressNo;
	}

	public String getBuyerAlipayNo() {
		return buyerAlipayNo;
	}

	public void setBuyerAlipayNo(String buyerAlipayNo) {
		this.buyerAlipayNo = buyerAlipayNo;
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

	public int getExpressId() {
		return expressId;
	}

	public void setExpressId(int expressId) {
		this.expressId = expressId;
	}

	public Express getExpress() {
		return express;
	}

	public void setExpress(Express express) {
		this.express = express;
	}

	public String getExpressTrackNo() {
		return expressTrackNo;
	}

	public void setExpressTrackNo(String expressTrackNo) {
		this.expressTrackNo = expressTrackNo;
	}

	public int getPrintTag() {
		return printTag;
	}

	public void setPrintTag(int printTag) {
		this.printTag = printTag;
	}

	public String getPrintBatchNo() {
		return printBatchNo;
	}

	public void setPrintBatchNo(String printBatchNo) {
		this.printBatchNo = printBatchNo;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public double getStdPostFee() {
		return stdPostFee;
	}

	public void setStdPostFee(double stdPostFee) {
		this.stdPostFee = stdPostFee;
	}

	public double getCostPostFee() {
		return costPostFee;
	}

	public void setCostPostFee(double costPostFee) {
		this.costPostFee = costPostFee;
	}

	public double getActPostFee() {
		return actPostFee;
	}

	public void setActPostFee(double actPostFee) {
		this.actPostFee = actPostFee;
	}

	public double getEstimatedWeight() {
		return estimatedWeight;
	}

	public void setEstimatedWeight(double estimatedWeight) {
		this.estimatedWeight = estimatedWeight;
	}

	public double getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(double actualWeight) {
		this.actualWeight = actualWeight;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
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

	public int getLastModifiedType() {
		return lastModifiedType;
	}

	public void setLastModifiedType(int lastModifiedType) {
		this.lastModifiedType = lastModifiedType;
	}

	public String getUserDefinedField1() {
		return userDefinedField1;
	}

	public void setUserDefinedField1(String userDefinedField1) {
		this.userDefinedField1 = userDefinedField1;
	}

	public String getUserDefinedField2() {
		return userDefinedField2;
	}

	public void setUserDefinedField2(String userDefinedField2) {
		this.userDefinedField2 = userDefinedField2;
	}

	public String getUserDefinedField3() {
		return userDefinedField3;
	}

	public void setUserDefinedField3(String userDefinedField3) {
		this.userDefinedField3 = userDefinedField3;
	}

	public String getUserDefinedField4() {
		return userDefinedField4;
	}

	public void setUserDefinedField4(String userDefinedField4) {
		this.userDefinedField4 = userDefinedField4;
	}

	public String getUserDefinedField5() {
		return userDefinedField5;
	}

	public void setUserDefinedField5(String userDefinedField5) {
		this.userDefinedField5 = userDefinedField5;
	}

	public Double getUserDefinedField6() {
		return userDefinedField6;
	}

	public void setUserDefinedField6(Double userDefinedField6) {
		this.userDefinedField6 = userDefinedField6;
	}

	public Double getUserDefinedField7() {
		return userDefinedField7;
	}

	public void setUserDefinedField7(Double userDefinedField7) {
		this.userDefinedField7 = userDefinedField7;
	}

	public Date getUserDefinedField8() {
		return userDefinedField8;
	}

	public void setUserDefinedField8(Date userDefinedField8) {
		this.userDefinedField8 = userDefinedField8;
	}

	public String getUserDefinedField9() {
		return userDefinedField9;
	}

	public void setUserDefinedField9(String userDefinedField9) {
		this.userDefinedField9 = userDefinedField9;
	}

	public String getUserDefinedField10() {
		return userDefinedField10;
	}

	public void setUserDefinedField10(String userDefinedField10) {
		this.userDefinedField10 = userDefinedField10;
	}

	public String getUserDefinedField11() {
		return userDefinedField11;
	}

	public void setUserDefinedField11(String userDefinedField11) {
		this.userDefinedField11 = userDefinedField11;
	}

	public List<SalesOrderLine> getLines() {
		return lines;
	}

	public void setLines(List<SalesOrderLine> lines) {
		this.lines = lines;
	}

    public SalesOrder()
    {
        lines = new ArrayList<SalesOrderLine>();
    }

}

package com.iwilley.b1ec2.api.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

//���۶�������
public class SalesOrder extends B1EC2Object {

	private static final long serialVersionUID = -8800777970088480989L;

	//����ID
    @ApiField("OrderId")
    public int orderId;

    //�汾
    @ApiField("Version")
    public int version;

    //ϵͳ������
    @ApiField("OrderNo")
    public String orderNo;

    //����ID
    @ApiField("ShopId")
    public int shopId;

    //����(ע:ֻ���ص�������)
    @ApiField("Shop")
    public Shop shop;

    //��Ա����
    @ApiField("CustomerCode")
    public String customerCode;

    //��Ա����
    @ApiField("CustomerName")
    public String customerName;

    //�ֿ�ID
    @ApiField("WhsId")
    public int whsId;

    //�ֿ�(ע:ֻ���زֿ�����)
    @ApiField("Warehouse")
    public Warehouse warehouse;

    //��������(10:��������;20:��������;30:���ⶩ��;40:��������)
    @ApiField("OrderType")
    public int orderType;

    //ϵͳ����״̬ 
    //10:������;20:������;30:����ͨ��;40:��ʼ���;43:�����;45:�ѳ���;60:�ѽ���;70:�����;80:�ѹر�;90:��ȡ��;99:��ɾ��;
    @ApiField("OrderStatus")
    public int orderStatus;

    //������ǩ
    //ʹ�����������, ��1��ʾ�ϵ�,2��ʾ��,4��ʾ����; 3��ʾ�ϵ�+��,5��ʾ�ϵ�+����,7��ʾ�ϵ�+��+����
    // 1,��;2,��;4,��;8,��;16,��;32,��;64,��;128,��;256,Ԥ;512,��;1024,;;2048,��;
    @ApiField("OrderTag")
    public int orderTag;

    //����ԭ��
    @ApiField("ReasonId")
    public Integer reasonId;

    //����ԭ��
    @ApiField("HoldingReason")
    public HoldingReason holdingReason;

    //���ر�ע,254
    @ApiField("HoldingMemo")
    public String holdingMemo;

    //�ܼ���
    //ע��, ������Ʒ�������ܼ�����
    @ApiField("TotalNum")
    public double totalNum;

    //�ۿ۽��
    @ApiField("DiscountFee")
    public double discountFee;

    //�������
    @ApiField("AdjustFee")
    public double adjustFee;

    //��Ʒ�ܶ�
    @ApiField("GoodsTotal")
    public double goodsTotal;

    //Ӧ�����
    @ApiField("OrderTotal")
    public double orderTotal;

    //������
    //���˽������Ƿ�������
    //������������ο�������ApprovalOrder2Type�ֶ�
    @ApiField("CalcTotal")
    public double calcTotal;

    //�ɱ��ܼ�
    @ApiField("StockTotal")
    public double stockTotal;

    //ƽ̨�������,254
    //���궩����ţ�����ϵ���������ͨ�����ŷָ�
    @ApiField("ShopOrderNo")
    public String shopOrderNo;

    //ƽ̨����״̬,10
    //ƽ̨����״̬���������Ѹ���ȴ������ȵȡ���Ϊ��������������ע����
    //ÿ�ζ�������ʱ�����±��ֶ�
    @ApiField("ShopOrderStatus")
    public String shopOrderStatus;

    //��վ�µ�ʱ��
    @ApiField("ShopCreatedTime")
    public Date shopCreatedTime;

    //��վ����ʱ��
    @ApiField("ShopPayTime")
    public Date shopPayTime;

    //�������,1000
    @ApiField("BuyerMemo")
    public String buyerMemo;

    //���ұ�ע,1000
    @ApiField("SellerMemo")
    public String sellerMemo;

    //ϵͳ��ע,254
    @ApiField("OrderMemo")
    public String orderMemo;

    //��������,6;red;green;yellow...
    @ApiField("ShopFlag")
    public String shopFlag;

    //��Ʊ״̬(10:δ��Ʊ;20:�ѿ�Ʊ;)
    @ApiField("InvoiceStatus")
    public int invoiceStatus;

    //��Ʊ����(10:��Ʊ;20:��Ʊ;)
    @ApiField("InvoiceType")
    public int invoiceType;

    //��Ʊ���
    @ApiField("InvoiceTotal")
    public double invoiceTotal;

    //��Ʊ̧ͷ,100
    @ApiField("InvoiceName")
    public String invoiceName;

    //��Ʊ��ע,254
    @ApiField("InvoiceMemo")
    public String invoiceMemo;

    //��Ʊ��ݺ�,20
    @ApiField("InvoiceExpressNo")
    public String invoiceExpressNo;

    //���֧����,100
    @ApiField("BuyerAlipayNo")
    public String buyerAlipayNo;

    //�ջ�������,50
    @ApiField("ReceiverName")
    public String receiverName;

    //�ջ���ʡ��,32
    @ApiField("ReceiverState")
    public String receiverState;

    //�ջ��˳���,32
    @ApiField("ReceiverCity")
    public String receiverCity;

    //�ջ��˵���,32
    @ApiField("ReceiverDistrict")
    public String receiverDistrict;

    //�ջ��˵�ַ,228
    @ApiField("ReceiverAddress")
    public String receiverAddress;

    //�ջ����ʱ�,6
    @ApiField("ReceiverZip")
    public String receiverZip;

    //�ջ����ֻ�,30
    @ApiField("ReceiverMobile")
    public String receiverMobile;

    //�ջ��˵绰,30
    @ApiField("ReceiverPhone")
    public String receiverPhone;

    //��ݹ�˾ID
    @ApiField("ExpressId")
    public int expressId;

    //��ݹ�˾ (ע:ֻ���ؿ������)
    @ApiField("Express")
    public Express express;

    //��ݵ���,20
    @ApiField("ExpressTrackNo")
    public String expressTrackNo;

    //��ӡ��ǩ
    //ʹ�����������, �����ο�������ǩ
    // 1,��ӡ��ݵ�;2,��ӡ������;4,��ӡ�����;
    @ApiField("PrintTag")
    public int printTag;

    //��ݵ���ӡ����
    @ApiField("PrintBatchNo")
    public String printBatchNo;

    //Ҫ�󷢻���
    @ApiField("ExpectedDeliveryDate")
    public Date expectedDeliveryDate;

    //ʵ�ʷ���ʱ��
    @ApiField("DeliveryTime")
    public Date deliveryTime;

    //�������ʱ��
    @ApiField("EndTime")
    public Date endTime;

    //��׼�����ɱ�
    @ApiField("StdPostFee")
    public double stdPostFee;

    //���������ɱ�
    @ApiField("CostPostFee")
    public double costPostFee;

    //��������
    @ApiField("ActPostFee")
    public double actPostFee;

    //������׼����
    @ApiField("EstimatedWeight")
    public double estimatedWeight;

    //������������
    @ApiField("ActualWeight")
    public double actualWeight;

    //������,20,Not Null
    @ApiField("Creator")
    public String creator;

    //����ʱ��
    @ApiField("CreatedTime")
    public Date createdTime;

    //����޸�ʱ��
    @ApiField("LastModifiedTime")
    public Date lastModifiedTime;

    //����޸���,20
    @ApiField("LastModifiedUser")
    public String lastModifiedUser;

    //����޸�����
    //10,�Ƶ�;12,�ϵ�;14,��;20,����;21����;22,��ش���;23���������;24,���;25,���;26,����;27,����;28,�������;29,�رն���;30,ȡ��;
    //40,����;42�������;50,��ӡ����;52,��ӡ����;54,��ӡ���;60,����;
    @ApiField("LastModifiedType")
    public int lastModifiedType;

    //�Զ����ֶ�1
    @ApiField("UserDefinedField1")
    public String userDefinedField1;

    //�Զ����ֶ�2
    @ApiField("UserDefinedField2")
    public String userDefinedField2;

    //�Զ����ֶ�3
    @ApiField("UserDefinedField3")
    public String userDefinedField3;

    //�Զ����ֶ�4
    @ApiField("UserDefinedField4")
    public String userDefinedField4;

    //�Զ����ֶ�5
    @ApiField("UserDefinedField5")
    public String userDefinedField5;

	//�Զ�������6
    @ApiField("UserDefinedField6")
    public Double userDefinedField6;

    //�Զ�������7
    @ApiField("UserDefinedField7")
    public Double userDefinedField7;

    //�Զ�������8
    @ApiField("UserDefinedField8")
    public Date userDefinedField8;
    
    //�Զ����ֶ�9
    @ApiField("UserDefinedField9")
    public String userDefinedField9;
    
    //�Զ����ֶ�10
    @ApiField("UserDefinedField10")
    public String userDefinedField10;
    
    //�Զ����ֶ�11
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

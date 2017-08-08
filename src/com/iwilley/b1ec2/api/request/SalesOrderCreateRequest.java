package com.iwilley.b1ec2.api.request;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.domain.SalesOrderCreateLine;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.SalesOrderCreateResponse;

public class SalesOrderCreateRequest implements
		B1EC2Request<SalesOrderCreateResponse> {

	// / ����ID
	public Integer shopId;

	// ��ݹ�˾ID
	public Integer expressId;

	// �ֿ�ID
	public Integer whsId;

	// �ͻ�����
	public String customerName;

	// ƽ̨�������
	public String shopOrderNo;

	// ��������
	public Double actPostFee;

	// ������ע
	public String sellerMemo;

	// �Ƿ�������� Ĭ��false
	public Boolean isCod;

	// �ջ�������
	public String receiverName;

	// �ջ����ֻ�
	public String receiverMobile;

	// �ջ���ʡ��
	public String receiverState;

	// �ջ��˳���
	public String receiverCity;

	// �ջ��˵���
	public String receiverDistrict;

	// �ջ��˵�ַ
	public String receiverAddress;

	// �ջ����ʱ�
	public String receiverZip;

	// ��Ʊ̧ͷ
	public String invoiceName;

	// ��Ʊ����
	// 0:���跢Ʊ;10:��ͨ��Ʊ;20:��ֵ˰��ͨ��Ʊ;25:��ֵ˰ר�÷�Ʊ;30:�վ�;
	// Ĭ��Ϊ0
	public Integer invoiceType;

	// ��Ʊ���
	public Double invoiceTotal;

	// ��Ʊ��ݺ�
	public String invoiceExpressNo;

	// ��Ʊ��ע
	public String invoiceMemo;

	// ��Ʊ����
	public String invoiceNo;

	// �Զ����ֶ�1
	public String userDefinedField1;

	// �Զ����ֶ�2
	public String userDefinedField2;

	// �Զ����ֶ�3
	public String userDefinedField3;

	// �Զ����ֶ�4
	public String userDefinedField4;

	// �Զ����ֶ�5
	public String userDefinedField5;

	// �Զ����ֶ�6
	public Double userDefinedField6;

	// �Զ����ֶ�7
	public Double userDefinedField7;

	// �Զ����ֶ�8
	public Date userDefinedField8;

	// �Զ����ֶ�9
	public String userDefinedField9;

	// �Զ����ֶ�10
	public String userDefinedField10;

	// �Զ����ֶ�11
	public String userDefinedField11;

	// �ۿ۽��
	public Double discountFee;

	// Ӧ�����
	public Double orderTotal;

	// ƽ̨����״̬
	public String shopOrderStatus;

	// ��վ����ʱ��
	public Date shopPayTime;
	
	// �������
	public String adjustFee;

    // ��Ʒ�ܶ�
	public String goodsTotal;
	
	//˰��
    public double customTax;
    //���֤����
	public String customIdNo;
	   

	private List<SalesOrderCreateLine> itemLines;

	public String getApiMethodName() {
		return "B1EC2.SalesOrder.Create";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("ShopId", shopId);
		parameters.put("ExpressId", expressId);
		parameters.put("WhsId", whsId);
		parameters.put("CustomerName", customerName);
		parameters.put("ShopOrderNo", shopOrderNo);
		parameters.put("ActPostFee", actPostFee);
		parameters.put("SellerMemo", sellerMemo);
		parameters.put("IsCod", isCod);
		parameters.put("ReceiverName", receiverName);
		parameters.put("ReceiverMobile", receiverMobile);
		parameters.put("ReceiverState", receiverState);
		parameters.put("ReceiverCity", receiverCity);
		parameters.put("ReceiverDistrict", receiverDistrict);
		parameters.put("ReceiverAddress", receiverAddress);
		parameters.put("ReceiverZip", receiverZip);
		parameters.put("InvoiceName", invoiceName);
		parameters.put("InvoiceType", invoiceType);
		parameters.put("InvoiceTotal", invoiceTotal);
		parameters.put("InvoiceExpressNo", invoiceExpressNo);
		parameters.put("InvoiceMemo", invoiceMemo);
		parameters.put("InvoiceNo", invoiceNo);
		parameters.put("UserDefinedField1", userDefinedField1);
		parameters.put("UserDefinedField2", userDefinedField2);
		parameters.put("UserDefinedField3", userDefinedField3);
		parameters.put("UserDefinedField4", userDefinedField4);
		parameters.put("UserDefinedField5", userDefinedField5);
		parameters.put("UserDefinedField6", userDefinedField6);
		parameters.put("UserDefinedField7", userDefinedField7);
		parameters.put("UserDefinedField8", userDefinedField8);
		parameters.put("UserDefinedField9", userDefinedField9);
		parameters.put("UserDefinedField10", userDefinedField10);
		parameters.put("UserDefinedField11", userDefinedField11);
		parameters.put("DiscountFee", discountFee);
		parameters.put("OrderTotal", orderTotal);
		parameters.put("ShopOrderStatus", shopOrderStatus);
		parameters.put("ShopPayTime", shopPayTime);
		parameters.put("AdjustFee", adjustFee);
		parameters.put("GoodsTotal", goodsTotal);
		parameters.put("CustomTax", customTax);
		parameters.put("CustomIdNo", customIdNo);
		if (itemLines != null && itemLines.size() > 0) {
			StringBuffer lineInfo = new StringBuffer();
			for (SalesOrderCreateLine itemLine : itemLines) {
				lineInfo.append(itemLine.getSkuCode());
				lineInfo.append("~");
				lineInfo.append(itemLine.getQuantity());
				lineInfo.append("~");
				lineInfo.append(itemLine.getPrice());
				lineInfo.append("~");
				lineInfo.append(itemLine.getLineMemo());
				lineInfo.append("~");
				lineInfo.append(itemLine.getLineUdf1());
				lineInfo.append("~");
				lineInfo.append(itemLine.getLineUdf2());
				lineInfo.append("~");
				lineInfo.append(itemLine.getIsVirtual());
				lineInfo.append("~");
				lineInfo.append(itemLine.getParentSku());
				lineInfo.append("^");
			}
			parameters.put("ItemLineInfo", lineInfo.toString());
		}
		return parameters;
	}

	public Class<SalesOrderCreateResponse> getResponseClass() {
		return SalesOrderCreateResponse.class;
	}

	public Integer getShopId() {
		return shopId;
	}

	public Integer getExpressId() {
		return expressId;
	}

	public Integer getWhsId() {
		return whsId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getShopOrderNo() {
		return shopOrderNo;
	}

	public Double getActPostFee() {
		return actPostFee;
	}

	public String getSellerMemo() {
		return sellerMemo;
	}

	public Boolean getIsCod() {
		return isCod;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverMobile() {
		return receiverMobile;
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

	public String getInvoiceName() {
		return invoiceName;
	}

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public Double getInvoiceTotal() {
		return invoiceTotal;
	}

	public String getInvoiceExpressNo() {
		return invoiceExpressNo;
	}

	public String getInvoiceMemo() {
		return invoiceMemo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public String getUserDefinedField1() {
		return userDefinedField1;
	}

	public String getUserDefinedField2() {
		return userDefinedField2;
	}

	public String getUserDefinedField3() {
		return userDefinedField3;
	}

	public String getUserDefinedField4() {
		return userDefinedField4;
	}

	public String getUserDefinedField5() {
		return userDefinedField5;
	}

	public Double getUserDefinedField6() {
		return userDefinedField6;
	}

	public Double getUserDefinedField7() {
		return userDefinedField7;
	}

	public Date getUserDefinedField8() {
		return userDefinedField8;
	}

	public String getUserDefinedField9() {
		return userDefinedField9;
	}

	public String getUserDefinedField10() {
		return userDefinedField10;
	}

	public String getUserDefinedField11() {
		return userDefinedField11;
	}

	public Double getDiscountFee() {
		return discountFee;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public String getShopOrderStatus() {
		return shopOrderStatus;
	}

	public Date getShopPayTime() {
		return shopPayTime;
	}
	
	public String getAdjustFee() {
		return adjustFee;
	}

	public String getGoodsTotal() {
		return goodsTotal;
	}

	public List<SalesOrderCreateLine> getItemLines() {
		return itemLines;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}

	public void setWhsId(Integer whsId) {
		this.whsId = whsId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setShopOrderNo(String shopOrderNo) {
		this.shopOrderNo = shopOrderNo;
	}

	public void setActPostFee(Double actPostFee) {
		this.actPostFee = actPostFee;
	}

	public void setSellerMemo(String sellerMemo) {
		this.sellerMemo = sellerMemo;
	}

	public void setIsCod(Boolean isCod) {
		this.isCod = isCod;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
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

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public void setInvoiceTotal(Double invoiceTotal) {
		this.invoiceTotal = invoiceTotal;
	}

	public void setInvoiceExpressNo(String invoiceExpressNo) {
		this.invoiceExpressNo = invoiceExpressNo;
	}

	public void setInvoiceMemo(String invoiceMemo) {
		this.invoiceMemo = invoiceMemo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public void setUserDefinedField1(String userDefinedField1) {
		this.userDefinedField1 = userDefinedField1;
	}

	public void setUserDefinedField2(String userDefinedField2) {
		this.userDefinedField2 = userDefinedField2;
	}

	public void setUserDefinedField3(String userDefinedField3) {
		this.userDefinedField3 = userDefinedField3;
	}

	public void setUserDefinedField4(String userDefinedField4) {
		this.userDefinedField4 = userDefinedField4;
	}

	public void setUserDefinedField5(String userDefinedField5) {
		this.userDefinedField5 = userDefinedField5;
	}

	public void setUserDefinedField6(Double userDefinedField6) {
		this.userDefinedField6 = userDefinedField6;
	}

	public void setUserDefinedField7(Double userDefinedField7) {
		this.userDefinedField7 = userDefinedField7;
	}

	public void setUserDefinedField8(Date userDefinedField8) {
		this.userDefinedField8 = userDefinedField8;
	}

	public void setUserDefinedField9(String userDefinedField9) {
		this.userDefinedField9 = userDefinedField9;
	}

	public void setUserDefinedField10(String userDefinedField10) {
		this.userDefinedField10 = userDefinedField10;
	}

	public void setUserDefinedField11(String userDefinedField11) {
		this.userDefinedField11 = userDefinedField11;
	}

	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public void setShopOrderStatus(String shopOrderStatus) {
		this.shopOrderStatus = shopOrderStatus;
	}

	public void setShopPayTime(Date shopPayTime) {
		this.shopPayTime = shopPayTime;
	}
	
	public void setAdjustFee(String adjustFee) {
		this.adjustFee = adjustFee;
	}
	public void setGoodsTotal(String goodsTotal) {
		this.goodsTotal = goodsTotal;
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

	public void setCustomTax(int customTax) {
		this.customTax = customTax;
	}
	

	public void setItemLines(List<SalesOrderCreateLine> itemLines) {
		this.itemLines = itemLines;
	}
	

}

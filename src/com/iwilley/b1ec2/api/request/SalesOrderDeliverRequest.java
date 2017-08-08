package com.iwilley.b1ec2.api.request;

import java.util.Map;
import java.util.Date;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.SalesOrderDeliverResponse;

public class SalesOrderDeliverRequest implements B1EC2Request<SalesOrderDeliverResponse>{

    //����ID
    public Integer orderId;
    
    //������
    public String orderNo;

    //��ݹ�˾ID(�ο�ExpressQuery�ӿ�)
    //���Ϊ��, ���ʾ������������
    public Integer expressId;

    //��ݵ���
    public String expressTrackNo;

    //��������
    public Double weight;
    
    //����ԭ��
    public Integer reasonId;

    //���ر�ע
    public String holdingMemo;

    /// ���к�,����: ����LineNum�����к�;
    /// ��������: 0:XXXXXX;1:ZZZZZ;
    public String serialNumberList;

    /// ��Ʊ����
    public String invoiceNo;
    
    /// ��Ʊ����
    public Date invoiceDate;
    
    /// ϵͳ��ע
    public String orderMemo;

    /// �Զ����ֶ�1
    public String userDefinedField1;

    /// �Զ����ֶ�2
    public String userDefinedField2;

    /// �Զ����ֶ�3
    public String userDefinedField3;

    /// �Զ����ֶ�4
    public String userDefinedField4;

    /// �Զ����ֶ�5
    public String userDefinedField5;

    /// �Զ����ֶ�6
    public Double userDefinedField6;

    /// �Զ����ֶ�7
    public Double userDefinedField7;

    /// �Զ����ֶ�8
    public Date userDefinedField8;
    
	public String getApiMethodName() {
        return "B1EC2.SalesOrder.Deliver";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("OrderId", orderId);
		parameters.put("OrderNo", orderNo);
		parameters.put("ExpressId", expressId);
		parameters.put("ExpressTrackNo", expressTrackNo);
		parameters.put("Weight", weight);
		parameters.put("InvoiceNo", invoiceNo);
		parameters.put("InvoiceDate", invoiceDate);
		parameters.put("OrderMemo", orderMemo);
		parameters.put("ReasonId", reasonId);
		parameters.put("HoldingMemo", holdingMemo);
		parameters.put("SerialNumberList", serialNumberList);
		parameters.put("UserDefinedField1", userDefinedField1);
		parameters.put("UserDefinedField2", userDefinedField2);
		parameters.put("UserDefinedField3", userDefinedField3);
		parameters.put("UserDefinedField4", userDefinedField4);
		parameters.put("UserDefinedField5", userDefinedField5);
		parameters.put("UserDefinedField6", userDefinedField6);
		parameters.put("UserDefinedField7", userDefinedField7);
		parameters.put("UserDefinedField8", userDefinedField8);
		return parameters;
	}

	public Class<SalesOrderDeliverResponse> getResponseClass() {
		return SalesOrderDeliverResponse.class;
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

	public Integer getExpressId() {
		return expressId;
	}

	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}

	public String getExpressTrackNo() {
		return expressTrackNo;
	}

	public void setExpressTrackNo(String expressTrackNo) {
		this.expressTrackNo = expressTrackNo;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public String getSerialNumberList() {
		return serialNumberList;
	}

	public void setSerialNumberList(String serialNumberList) {
		this.serialNumberList = serialNumberList;
	}
	
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	public String getHoldingMemo() {
		return holdingMemo;
	}

	public void setHoldingMemo(String holdingMemo) {
		this.holdingMemo = holdingMemo;
	}

	public Integer getReasonId() {
		return reasonId;
	}

	public void setReasonId(Integer reasonId) {
		this.reasonId = reasonId;
	}
	
	public String getOrderMemo() {
		return orderMemo;
	}

	public void setOrderMemo(String orderMemo) {
		this.orderMemo = orderMemo;
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

	public Date getInvoiceDate() {
		return invoiceDate;
	}


	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	
}

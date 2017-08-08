package com.iwilley.b1ec2.api.request;

import java.util.List;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.domain.AfterSaleServiceReturnItemLine;
import com.iwilley.b1ec2.api.domain.AfterSaleServiceExchangeAndRedeliveryItemLine;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.AfterSalesServiceCreateResponse;

public class AfterSalesServiceCreateRequest implements B1EC2Request<AfterSalesServiceCreateResponse> {

	// / �˻��˿�10�����˿�20 ���� 30 ���� 40 ������ 50 ά�� 60
	public int type;

	// / ����ID
	public Integer orderId;

	// / ����ϵͳ����
	public String orderNo;

	// / �˻��ֿ�
	public Integer returnWhsId;

	// / �����ֿ�
	public Integer deliverWhsId;

	// /�ۺ�ԭ��Id
	public Integer refundReasonId;

	// / �˻ر�ע
	public String refundMemo;

	// / Ӧ�˽��
	public Double refundFeeTotal;

	// / Ӧ�����
	public Double fillUpFee;

	// / �˻ؿ�ݹ�˾
	public Integer returnExpressId;

	// / �˻���ݵ���
	public String expressTrackNo;

	// / �Զ����ֶ�1
	public String userDefinedField1;

	// / �Զ����ֶ�2
	public String userDefinedField2;

	// / �Զ����ֶ�3
	public String userDefinedField3;

	// / �Զ����ֶ�4
	public String userDefinedField4;

	// / �ջ�������
	public String receiverName;

	// / �ջ���ʡ��
	public String receiverState;

	// / �ջ��˳���
	public String receiverCity;

	// / �ջ��˵���
	public String receiverDistrict;

	// / �ջ��˵�ַ
	public String receiverAddress;

	// / �ջ����ʱ�
	public String receiverZip;

	// / �ջ����ֻ�
	public String receiverMobile;

	// / �ջ��˵绰
	public String receiverPhone;

	// / �˻���Ʒ��ϸ
	public List<AfterSaleServiceReturnItemLine> returnItemLines;

	// ����/������Ʒ��ϸ
	public List<AfterSaleServiceExchangeAndRedeliveryItemLine> exchangeAndRedeliveryItemLines;

	public String getApiMethodName() {
		return "B1EC2.AfterSalesService.Create";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("Type", type);
		parameters.put("OrderId", orderId);
		parameters.put("RefundReasonId", refundReasonId);
		parameters.put("OrderNo", orderNo);
		parameters.put("RefundMemo", refundMemo);
		parameters.put("ReturnWhsId", returnWhsId);
		parameters.put("DeliverWhsId", deliverWhsId);
		parameters.put("RefundFeeTotal", refundFeeTotal);
		parameters.put("FillUpFee", fillUpFee);
		parameters.put("ReturnExpressId", returnExpressId);
		parameters.put("ExpressTrackNo", expressTrackNo);
		parameters.put("UserDefinedField1", userDefinedField1);
		parameters.put("UserDefinedField2", userDefinedField2);
		parameters.put("UserDefinedField3", userDefinedField3);
		parameters.put("UserDefinedField4", userDefinedField4);
		parameters.put("ReceiverName", receiverName);
		parameters.put("ReceiverState", receiverState);
		parameters.put("ReceiverCity", receiverCity);
		parameters.put("ReceiverDistrict", receiverDistrict);
		parameters.put("ReceiverAddress", receiverAddress);
		parameters.put("ReceiverZip", receiverZip);
		parameters.put("ReceiverMobile", receiverMobile);
		parameters.put("ReceiverPhone", receiverPhone);
		if (returnItemLines != null && returnItemLines.size() > 0) {
			StringBuffer lineInfo = new StringBuffer();
			for (AfterSaleServiceReturnItemLine returnItemLine : returnItemLines) {
				lineInfo.append(returnItemLine.getOrderLineNum());
				lineInfo.append(":");
				lineInfo.append(returnItemLine.getQuantity());
				lineInfo.append(":");
			}
			parameters.put("ReturnLineInfo", lineInfo.toString());
		}
		if (exchangeAndRedeliveryItemLines != null
				&& exchangeAndRedeliveryItemLines.size() > 0) {
			StringBuffer lineInfo = new StringBuffer();
			for (AfterSaleServiceExchangeAndRedeliveryItemLine exchangeAndRedeliveryItemLine : exchangeAndRedeliveryItemLines) {
				lineInfo.append(exchangeAndRedeliveryItemLine.getOrderLineNum());
				lineInfo.append(":");
				lineInfo.append(exchangeAndRedeliveryItemLine.getQuantity());
				lineInfo.append(":");
			}
			parameters.put("ExchangeAndRedeliveryLineInfo", lineInfo.toString());
		}
		return parameters;
	}

	public Class<AfterSalesServiceCreateResponse> getResponseClass() {
		return AfterSalesServiceCreateResponse.class;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public Integer getReturnWhsId() {
		return returnWhsId;
	}

	public void setReturnWhsId(Integer returnWhsId) {
		this.returnWhsId = returnWhsId;
	}

	public Integer getDeliverWhsId() {
		return deliverWhsId;
	}

	public void setDeliverWhsId(Integer deliverWhsId) {
		this.deliverWhsId = deliverWhsId;
	}

	public String getRefundMemo() {
		return refundMemo;
	}

	public void setRefundMemo(String refundMemo) {
		this.refundMemo = refundMemo;
	}

	public Double getRefundFeeTotal() {
		return refundFeeTotal;
	}

	public void setRefundFeeTotal(Double refundFeeTotal) {
		this.refundFeeTotal = refundFeeTotal;
	}

	public Double getFillUpFee() {
		return fillUpFee;
	}

	public void setFillUpFee(Double fillUpFee) {
		this.fillUpFee = fillUpFee;
	}

	public Integer getReturnExpressId() {
		return returnExpressId;
	}

	public void setReturnExpressId(Integer returnExpressId) {
		this.returnExpressId = returnExpressId;
	}

	public String getExpressTrackNo() {
		return expressTrackNo;
	}

	public void setExpressTrackNo(String expressTrackNo) {
		this.expressTrackNo = expressTrackNo;
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

	public List<AfterSaleServiceReturnItemLine> getReturnItemLines() {
		return returnItemLines;
	}

	public void setReturnItemLines(
			List<AfterSaleServiceReturnItemLine> returnItemLines) {
		this.returnItemLines = returnItemLines;
	}

	public List<AfterSaleServiceExchangeAndRedeliveryItemLine> getExchangeAndRedeliveryItemLines() {
		return exchangeAndRedeliveryItemLines;
	}

	public void setExchangeAndRedeliveryItemLines(
			List<AfterSaleServiceExchangeAndRedeliveryItemLine> exchangeAndRedeliveryItemLines) {
		this.exchangeAndRedeliveryItemLines = exchangeAndRedeliveryItemLines;
	}

	public Integer getRefundReasonId() {
		return refundReasonId;
	}

	public void setRefundReasonId(Integer refundReasonId) {
		this.refundReasonId = refundReasonId;
	}

}

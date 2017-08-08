package com.iwilley.b1ec2.api.request;

import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.SalesOrderCancelResponse;

// �����رսӿ�
public class SalesOrderCancelRequest implements
		B1EC2Request<SalesOrderCancelResponse> {

	// / ����ID
	public Integer orderId;

	// ����ϵͳ����
	public String orderNo;

	// ƽ̨������
	public String shopOrderNo;

	public String getApiMethodName() {
		return "B1EC2.SalesOrder.Cancel";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("OrderId", orderId);
		parameters.put("OrderNo", orderNo);
		parameters.put("ShopOrderNo", shopOrderNo);
		return parameters;
	}

	public Class<SalesOrderCancelResponse> getResponseClass() {
		return SalesOrderCancelResponse.class;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getShopOrderNo() {
		return shopOrderNo;
	}

	public void setShopOrderNo(String shopOrderNo) {
		this.shopOrderNo = shopOrderNo;
	}

}

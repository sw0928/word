package com.iwilley.b1ec2.api.request;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.SalesOrderUnapproveResponse;

public class SalesOrderUnapproveRequest implements B1EC2Request<SalesOrderUnapproveResponse> {

	//����ID
    public int OrderId;

    // ����ϵͳ����
    public String OrderNo;

    // ƽ̨������
    public String ShopOrderNo ;
	
	public String getApiMethodName() {
		return "B1EC2.SalesOrder.Unapprove";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("OrderId", OrderId);
		parameters.put("OrderNo", OrderNo);
		parameters.put("ShopOrderNo", ShopOrderNo);
		return parameters;
	}

	public Class<SalesOrderUnapproveResponse> getResponseClass() {
		return SalesOrderUnapproveResponse.class;
	}
	
	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer OrderId) {
		this.OrderId = OrderId;
	}

	public String getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(String OrderNo) {
		this.OrderNo = OrderNo;
	}

	public String getShopOrderNo() {
		return ShopOrderNo;
	}

	public void setShopOrderNo(String ShopOrderNo) {
		this.ShopOrderNo = ShopOrderNo;
	}

}

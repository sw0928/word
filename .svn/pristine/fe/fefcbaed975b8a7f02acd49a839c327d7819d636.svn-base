package com.iwilley.b1ec2.api.request;

import java.util.Map;
import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.StockUpdateResponse;

public class StockUpdateRequest implements B1EC2Request<StockUpdateResponse> {

	// �����Ϣ,����: ��������:��Ʒ����:����:�ɱ�;
	// ��������: 1010:1201:10:12.5;1010:1202:5:0;
	// ע��:
	// 1. �����������ֻ�ܸ���100�����, �����򱨴�
	// 2. �����ϣ�����¿��ɱ�,��ɱ��ֶ�����Ϊ0;
	public String stock;

	// �Ƿ�ȷ�� Ĭ��Ϊtrue
	public Boolean confirmed;

	public String getApiMethodName() {
		return "B1EC2.Stock.Update";
	}

	public StockUpdateRequest() {
		confirmed = true;
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("Stock", stock);
		parameters.put("Confirmed", confirmed);
		return parameters;
	}

	public Class<StockUpdateResponse> getResponseClass() {
		return StockUpdateResponse.class;
	}

	public String getStock() {
		return stock;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

}

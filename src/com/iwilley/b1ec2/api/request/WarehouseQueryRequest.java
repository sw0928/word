package com.iwilley.b1ec2.api.request;

import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.response.WarehouseQueryResponse;

public class WarehouseQueryRequest implements B1EC2Request<WarehouseQueryResponse>{

	public String getApiMethodName() {
        return "B1EC2.Warehouse.Query";
	}

	public Map<String, String> GetParameters() {
		return null;
	}

	public Class<WarehouseQueryResponse> getResponseClass() {
		return WarehouseQueryResponse.class;
	}
}

package com.iwilley.b1ec2.api.request;

import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.response.ShopQueryResponse;

public class ShopQueryRequest implements B1EC2Request<ShopQueryResponse>{

	public String getApiMethodName() {
        return "B1EC2.Shop.Query";
	}

	public Map<String, String> GetParameters() {
		return null;
	}

	public Class<ShopQueryResponse> getResponseClass() {
		return ShopQueryResponse.class;
	}
}

package com.iwilley.b1ec2.api.request;

import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.response.CategoryQueryResponse;

// ��Ŀ��ѯ�ӿ�
public class CategoryQueryRequest implements B1EC2Request<CategoryQueryResponse> {

	public String getApiMethodName() {
		return "B1EC2.Category.Query";
	}

	public Map<String, String> GetParameters() {
		return null;
	}

	public Class<CategoryQueryResponse> getResponseClass() {
		return CategoryQueryResponse.class;
	}

}

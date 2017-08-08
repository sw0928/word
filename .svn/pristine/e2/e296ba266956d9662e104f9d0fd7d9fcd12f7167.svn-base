package com.iwilley.b1ec2.api.internal.mapping;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Response;

/**
 * 动态格式转换器。
 */
public interface Converter {

	/**
	 * 把字符串转换为响应对象。
	 * 
	 * @param <T> 领域泛型
	 * @param rsp 响应字符串
	 * @param clazz 领域类型
	 * @return 响应对象
	 */
	public <T extends B1EC2Response> T toResponse(String rsp, Class<T> clazz) throws ApiException;

}
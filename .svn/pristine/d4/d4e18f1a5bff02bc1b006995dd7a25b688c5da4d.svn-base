package com.iwilley.b1ec2.api.parser;

import com.iwilley.b1ec2.api.*;

/**
 * 响应解释器接口。响
 * 
 */
public interface B1EC2Parser<T extends B1EC2Response> {

	/**
	 * 把响应字符串解释成相应的领域对象。
	 * 
	 * @param rsp 响应字符串
	 * @return 领域对象
	 */
	public T parse(String rsp) throws ApiException;

	/**
	 * 获取响应类类型。
	 */
	public Class<T> getResponseClass() throws ApiException;

}

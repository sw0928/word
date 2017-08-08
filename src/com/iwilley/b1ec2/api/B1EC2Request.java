package com.iwilley.b1ec2.api;

import java.util.Map;

/**
 * 请求接口
 * 
 */
public interface B1EC2Request<T extends B1EC2Response> {
	
	/**
	 * 获取API名称。
	 * 
	 * @return API名称
	 */
	public String getApiMethodName();

	/**
	 * 获取所有的Key-Value形式的文本请求参数集合。其中：
	 * <ul>
	 * <li>Key: 请求参数名</li>
	 * <li>Value: 请求参数值</li>
	 * </ul>
	 * 
	 * @return 文本请求参数集合
	 */
	public Map<String, String> GetParameters();
	
	public Class<T> getResponseClass();
}

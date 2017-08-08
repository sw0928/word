package com.iwilley.b1ec2.api;

import java.util.Map;

/**
 * ����ӿ�
 * 
 */
public interface B1EC2Request<T extends B1EC2Response> {
	
	/**
	 * ��ȡAPI���ơ�
	 * 
	 * @return API����
	 */
	public String getApiMethodName();

	/**
	 * ��ȡ���е�Key-Value��ʽ���ı�����������ϡ����У�
	 * <ul>
	 * <li>Key: ���������</li>
	 * <li>Value: �������ֵ</li>
	 * </ul>
	 * 
	 * @return �ı������������
	 */
	public Map<String, String> GetParameters();
	
	public Class<T> getResponseClass();
}

package com.iwilley.b1ec2.api.parser;

import com.iwilley.b1ec2.api.*;

/**
 * ��Ӧ�������ӿڡ���
 * 
 */
public interface B1EC2Parser<T extends B1EC2Response> {

	/**
	 * ����Ӧ�ַ������ͳ���Ӧ���������
	 * 
	 * @param rsp ��Ӧ�ַ���
	 * @return �������
	 */
	public T parse(String rsp) throws ApiException;

	/**
	 * ��ȡ��Ӧ�����͡�
	 */
	public Class<T> getResponseClass() throws ApiException;

}

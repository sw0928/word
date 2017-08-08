package com.iwilley.b1ec2.api.parser;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.internal.mapping.Converter;

/**
 * ����JSON�����������
 * 
 */
public class B1EC2JsonParser<T extends B1EC2Response> implements B1EC2Parser<T> {

	private Class<T> clazz;
	private boolean simplify;

	public B1EC2JsonParser(Class<T> clazz) {
		this.clazz = clazz;
	}

	public B1EC2JsonParser(Class<T> clazz, boolean simplify) {
		this.clazz = clazz;
		this.simplify = simplify;
	}

	public T parse(String rsp) throws ApiException {
		Converter converter;
		if (this.simplify) {
			converter = new SimplifyJsonConverter();
		} else {
			converter = new NormalJsonConverter();
		}
		return converter.toResponse(rsp, clazz);
	}

	public Class<T> getResponseClass() {
		return clazz;
	}

}
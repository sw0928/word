package com.iwilley.b1ec2.api.parser;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.internal.mapping.Converter;
import com.iwilley.b1ec2.api.internal.mapping.Converters;
import com.iwilley.b1ec2.api.internal.mapping.Reader;
import com.iwilley.b1ec2.api.internal.util.json.ExceptionErrorListener;
import com.iwilley.b1ec2.api.internal.util.json.JSONReader;
import com.iwilley.b1ec2.api.internal.util.json.JSONValidatingReader;

/**
 * JSON��ʽת������
 * 
 */
public class NormalJsonConverter implements Converter {

	public <T extends B1EC2Response> T toResponse(String rsp, Class<T> clazz) throws ApiException {
		JSONReader reader = new JSONValidatingReader(new ExceptionErrorListener());
		Object rootObj = reader.read(rsp);
		if (rootObj instanceof Map<?, ?>) {
			return fromJson((Map<?, ?>) rootObj, clazz);
		}
		return null;
	}

	/**
	 * ��JSON��ʽ������ת��Ϊ����
	 * 
	 * @param <T> �����������
	 * @param json JSON��ʽ������
	 * @param clazz ������������
	 * @return �������
	 */
	public <T> T fromJson(final Map<?, ?> json, Class<T> clazz) throws ApiException {
		return Converters.convert(clazz, new Reader() {
			public boolean hasReturnField(Object name) {
				return json.containsKey(name);
			}

			public Object getPrimitiveObject(Object name) {
				return json.get(name);
			}

			public Object getObject(Object name, Class<?> type) throws ApiException {
				Object tmp = json.get(name);
				if (tmp instanceof Map<?, ?>) {
					Map<?, ?> map = (Map<?, ?>) tmp;
					return fromJson(map, type);
				} else {
					return null;
				}
			}

			public List<?> getListObjects(Object listName, Object itemName, Class<?> subType) throws ApiException {
				List<Object> listObjs = null;

				Object listTmp = json.get(listName);
				if (listTmp instanceof List<?>) {
					listObjs = new ArrayList<Object>();
					List<?> tmpList = (List<?>) listTmp;
					for (Object subTmp : tmpList) {
						if (subTmp instanceof Map<?, ?>) {// object
							Map<?, ?> subMap = (Map<?, ?>) subTmp;
							Object subObj = fromJson(subMap, subType);
							if (subObj != null) {
								listObjs.add(subObj);
							}
						} else if (subTmp instanceof List<?>) {// array
							// TODO not support yet
						} else {// boolean, long, double, string, null
							listObjs.add(subTmp);
						}
					}
				}
				
				return listObjs;
			}
		});
	}

}
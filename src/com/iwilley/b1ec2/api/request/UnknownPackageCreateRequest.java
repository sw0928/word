package com.iwilley.b1ec2.api.request;

import java.util.List;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.domain.UnknownPackageItemLine;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.UnknownPackageCreateResponse;

// �ۺ󵥴���
public class UnknownPackageCreateRequest implements
		B1EC2Request<UnknownPackageCreateResponse> {

	// / �˻��ֿ�
	public Integer returnWhsId;

	// / �˻ؿ�ݹ�˾
	public Integer returnExpressId;

	// / �˻���ݵ���

	public String expressTrackNo;

	// / �Զ����ֶ�1
	public String userDefinedField1;

	// / �Զ����ֶ�2
	public String userDefinedField2;

	// / �Զ����ֶ�3
	public String userDefinedField3;

	// / �Զ����ֶ�4
	public String userDefinedField4;

	// �˻�����Ϣ
	private List<UnknownPackageItemLine> itemLines;

	public String getApiMethodName() {
		return "B1EC2.UnknownPackage.Create";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("ReturnWhsId", returnWhsId);
		parameters.put("ReturnExpressId", returnExpressId);
		parameters.put("ExpressTrackNo", expressTrackNo);
		parameters.put("UserDefinedField1", userDefinedField1);
		parameters.put("UserDefinedField2", userDefinedField2);
		parameters.put("UserDefinedField3", userDefinedField3);
		parameters.put("UserDefinedField4", userDefinedField4);
		if (itemLines != null && itemLines.size() >0) {
			StringBuffer lineInfo = new StringBuffer();
			for (UnknownPackageItemLine returnLine : itemLines) {
				 lineInfo.append(returnLine.getSkuCode());
                 lineInfo.append(":");
                 lineInfo.append(returnLine.getQuantity());
                 lineInfo.append(";");
			}
			parameters.put("ItemLineInfo", lineInfo.toString());
		}
		return parameters;
	}

	public Class<UnknownPackageCreateResponse> getResponseClass() {
		return UnknownPackageCreateResponse.class;
	}

	public Integer getReturnWhsId() {
		return returnWhsId;
	}

	public Integer getReturnExpressId() {
		return returnExpressId;
	}

	public String getExpressTrackNo() {
		return expressTrackNo;
	}

	public String getUserDefinedField1() {
		return userDefinedField1;
	}

	public String getUserDefinedField2() {
		return userDefinedField2;
	}

	public String getUserDefinedField3() {
		return userDefinedField3;
	}

	public String getUserDefinedField4() {
		return userDefinedField4;
	}

	public List<UnknownPackageItemLine> getItemLines() {
		return itemLines;
	}

	public void setReturnWhsId(Integer returnWhsId) {
		this.returnWhsId = returnWhsId;
	}

	public void setReturnExpressId(Integer returnExpressId) {
		this.returnExpressId = returnExpressId;
	}

	public void setExpressTrackNo(String expressTrackNo) {
		this.expressTrackNo = expressTrackNo;
	}

	public void setUserDefinedField1(String userDefinedField1) {
		this.userDefinedField1 = userDefinedField1;
	}

	public void setUserDefinedField2(String userDefinedField2) {
		this.userDefinedField2 = userDefinedField2;
	}

	public void setUserDefinedField3(String userDefinedField3) {
		this.userDefinedField3 = userDefinedField3;
	}

	public void setUserDefinedField4(String userDefinedField4) {
		this.userDefinedField4 = userDefinedField4;
	}

	public void setItemLines(List<UnknownPackageItemLine> itemLines) {
		this.itemLines = itemLines;
	}

}

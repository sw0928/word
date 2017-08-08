package com.iwilley.b1ec2.api.request;

import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.CustomerCreateResponse;

// �ͻ�����
public class CustomerCreateRequest implements
		B1EC2Request<CustomerCreateResponse> {

	// �ͻ�����
	public String customerName;

	// ����Id
	public Integer shopId;

	// �ֻ�
	public String mobile;

	// �ջ�������
	public String receiverName;

	// / ʡ��
	public String province;

	// ��
	public String city;

	// ��(��)
	public String district;

	// ��ϸ��ַ
	public String address;

	// ����
	public String email;

	// �ʱ�
	public String zipCode;

	// ��ע
	public String memo;

	// / �������
	public String buyerCredit;

	// ��Ա�ȼ�
	public Integer levelId;

	// �Ƿ������
	public Boolean isFenXiao;

	// �Զ����ֶ�1
	public String userDefinedField1;

	// �Զ����ֶ�2
	public String userDefinedField2;

	// �Զ����ֶ�3
	public String userDefinedField3;

	// �Զ����ֶ�4
	public String userDefinedField4;
	
	// �Զ����ֶ�5
	public String userDefinedField5;
	
	// �Զ����ֶ�6
	public String userDefinedField6;
  
	//�ͻ�����
	public String customerCode;
	
	public String getApiMethodName() {
		return "B1EC2.Customer.Create";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("CustomerName", customerName);
		parameters.put("ShopId", shopId);
		parameters.put("Mobile", mobile);
		parameters.put("ReceiverName", receiverName);
		parameters.put("Province", province);
		parameters.put("City", city);
		parameters.put("District", district);
		parameters.put("Address", address);
		parameters.put("Email", email);
		parameters.put("ZipCode", zipCode);
		parameters.put("Memo", memo);
		parameters.put("BuyerCredit", buyerCredit);
		parameters.put("LevelId", levelId);
		parameters.put("IsFenXiao", isFenXiao);
		parameters.put("UserDefinedField1", userDefinedField1);
		parameters.put("UserDefinedField2", userDefinedField2);
		parameters.put("UserDefinedField3", userDefinedField3);
		parameters.put("UserDefinedField4", userDefinedField4);
		parameters.put("UserDefinedField5", userDefinedField5);
		parameters.put("UserDefinedField6", userDefinedField6);
		parameters.put("CustomerCode", customerCode);
		return parameters;
	}

	public Class<CustomerCreateResponse> getResponseClass() {
		return CustomerCreateResponse.class;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Integer getShopId() {
		return shopId;
	}

	public String getMobile() {
		return mobile;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getMemo() {
		return memo;
	}

	public String getBuyerCredit() {
		return buyerCredit;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public Boolean getIsFenXiao() {
		return isFenXiao;
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

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setBuyerCredit(String buyerCredit) {
		this.buyerCredit = buyerCredit;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public void setIsFenXiao(Boolean isFenXiao) {
		this.isFenXiao = isFenXiao;
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

	public String getUserDefinedField5() {
		return userDefinedField5;
	}

	public String getUserDefinedField6() {
		return userDefinedField6;
	}

	public void setUserDefinedField5(String userDefinedField5) {
		this.userDefinedField5 = userDefinedField5;
	}

	public void setUserDefinedField6(String userDefinedField6) {
		this.userDefinedField6 = userDefinedField6;
	}
	
	
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	

}

package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class ShopSku extends B1EC2Object {


	private static final long serialVersionUID = 7180140976854749130L;

	 //��������,50
	@ApiField("ShopItemCode")
    public String shopItemCode ;

    //����SkuCode,20
	@ApiField("ShopSkuCode")
    public String shopSkuCode ;

    //�̼Ҵ���,50
	@ApiField("OuterId")
    public String outerId ;

    //��������1,100
	@ApiField("Property1")
    public String property1 ;

    //��������2,100
	@ApiField("Property2")
    public String property2;

    //�Ա�����,200
	@ApiField("Properties")
    public String properties;

    //�۸�
	@ApiField("Price")
    public double price ;

    //���(������)
	@ApiField("Size")
    public double size ;

    //������ǧ�ˣ�
	@ApiField("Weight")
    public double weight ;

    //��Ʒ����
	@ApiField("Quantity")
    public int quantity;

	public String getShopItemCode() {
		return shopItemCode;
	}

	public void setShopItemCode(String shopItemCode) {
		this.shopItemCode = shopItemCode;
	}

	public String getShopSkuCode() {
		return shopSkuCode;
	}

	public void setShopSkuCode(String shopSkuCode) {
		this.shopSkuCode = shopSkuCode;
	}

	public String getOuterId() {
		return outerId;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	public String getProperty2() {
		return property2;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}

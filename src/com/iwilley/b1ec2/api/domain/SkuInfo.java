package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class SkuInfo extends B1EC2Object {

	private static final long serialVersionUID = -2423076069218435545L;

	//SKU ID
    @ApiField("SkuId")
    public int skuId;

    //������,50
    @ApiField("SkuCode")
    public String skuCode;

    //�������,100
    @ApiField("SkuName")
    public String skuName;

    //������,100
    @ApiField("BarCode")
    public String barCode;

    //��������1,100
    @ApiField("Property1")
    public String property1;

    //��������2,100
    @ApiField("Property2")
    public String property2;

    //�ɹ��۸�
    @ApiField("PurchasePrice")
    public double purchasePrice;

    //���ۼ۸�
    @ApiField("SalesPrice")
    public double salesPrice;

    //����ۼ�
    @ApiField("LowestPrice")
    public double lowestPrice;

    //���Ƽ۸�
    @ApiField("LowestPrice")
    public double marketPrice;

    //���(������)
    @ApiField("LowestPrice")
    public double size;

    //������ǧ�ˣ�
    @ApiField("Weight")
    public double weight;

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
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

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public double getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
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


}

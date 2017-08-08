package com.iwilley.b1ec2.api.domain;

public class ShopOrderCreateLine extends B1EC2Object {

	private static final long serialVersionUID = 5031294517950609621L;

	// 平台订单行编号
	public String shopLineNo;

	// 外部代码
	public String outerId;

	// 数量
	public int quantity;

	// 单价
	public double price;

	// 自定义行字段1
	public String lineUdf1;

	// 自定义行字段2
	public String lineUdf2;
	
	// 商品名称
    public String itemName;

   //名称  
    public String skuName;
    
    // 含税行总价
    public double lineTotal;

   //行税金  
    public double lineCustomTax;

    public double lineCustomTotal;
    
	public double getLineCustomTotal() {
		return lineCustomTotal;
	}

	public void setLineCustomTotal(double lineCustomTotal) {
		this.lineCustomTotal = lineCustomTotal;
	}

	public String getShopLineNo() {
		return shopLineNo;
	}

	public void setShopLineNo(String shopLineNo) {
		this.shopLineNo = shopLineNo;
	}

	public String getOuterId() {
		return outerId;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLineUdf1() {
		return lineUdf1;
	}

	public void setLineUdf1(String lineUdf1) {
		this.lineUdf1 = lineUdf1;
	}

	public String getLineUdf2() {
		return lineUdf2;
	}

	public void setLineUdf2(String lineUdf2) {
		this.lineUdf2 = lineUdf2;
	}
	public String getitemName() {
		return itemName;
	}
	public void setitemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getskuName() {
		return skuName;
	}
	public void setskuName(String skuName) {
		this.skuName = skuName;
	}
	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal =lineTotal;
	}
	
	public double getLineCustomTax() {
		return lineCustomTax;
	}

	public void setLineCustomTax(double lineCustomTax) {
		this.lineCustomTax =lineCustomTax;
	}
	
}

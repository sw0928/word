package com.iwilley.b1ec2.api.domain;


public class AfterSaleServiceReturnItemLine extends B1EC2Object {
	

	private static final long serialVersionUID = 3169273906233895728L;

	/// orderLineNum
    public int orderLineNum;

    /// ÊýÁ¿
    public int quantity;

	public int getOrderLineNum() {
		return orderLineNum;
	}
	

	public void setOrderLineNum(int orderLineNum) {
		this.orderLineNum = orderLineNum;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


    
    
    
}

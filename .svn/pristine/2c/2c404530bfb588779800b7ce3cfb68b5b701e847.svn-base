package com.iwilley.b1ec2.api.response;

import java.util.List;

import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.domain.PurchaseReturn;
import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public class PurchaseReturnQueryResponse extends B1EC2Response {


	private static final long serialVersionUID = -6244996777109600052L;

	//搜索到的商品总数
	@ApiField("TotalResults")
    public int totalResults;
    
	@ApiListField("PurchaseReturns")
	@ApiField("PurchaseReturn")
	private List<PurchaseReturn> purchaseReturns;

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	
	public List<PurchaseReturn> getPurchaseReturns() {
		return purchaseReturns;
	}

	public void setPurchaseReturns(List<PurchaseReturn> purchaseReturns) {
		this.purchaseReturns = purchaseReturns;
	}

}

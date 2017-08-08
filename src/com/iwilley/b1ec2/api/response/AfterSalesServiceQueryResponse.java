package com.iwilley.b1ec2.api.response;

import java.util.List;

import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.domain.AfterSaleService;
import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public class AfterSalesServiceQueryResponse extends B1EC2Response {

	private static final long serialVersionUID = -7467665837693450654L;

	//搜索到的商品总数
	@ApiField("TotalResults")
    public int totalResults;
    
	@ApiListField("AfterSaleServices")
	@ApiField("AfterSaleService")
	private List<AfterSaleService> afterSaleServices;

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public List<AfterSaleService> getAfterSaleServices() {
		return afterSaleServices;
	}

	public void setAfterSaleServices(List<AfterSaleService> afterSaleServices) {
		this.afterSaleServices = afterSaleServices;
	}


}

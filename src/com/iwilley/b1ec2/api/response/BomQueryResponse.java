package com.iwilley.b1ec2.api.response;

import java.util.List;

import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.domain.Bom;
import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public class BomQueryResponse extends B1EC2Response {

	private static final long serialVersionUID = -4622761616597490820L;
	// 搜索到的商品总数
	@ApiField("TotalResults")
	public int totalResults;

	@ApiListField("Boms")
	@ApiField("Bom")
	private List<Bom> boms;

	public int getTotalResults() {
		return totalResults;
	}

	public List<Bom> getBoms() {
		return boms;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public void setBoms(List<Bom> boms) {
		this.boms = boms;
	}
}

package com.iwilley.b1ec2.api.response;

import java.util.List;

import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.domain.ItemInfo;
import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public class ItemInfoQueryResponse extends B1EC2Response {

	private static final long serialVersionUID = 108820312694268821L;

	//搜索到的商品总数
	@ApiField("TotalResults")
    public int totalResults;
    
	@ApiListField("ItemInfos")
	@ApiField("ItemInfo")
	private List<ItemInfo> itemInfos;

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	
	public List<ItemInfo> getItemInfos() {
		return itemInfos;
	}

	public void setItemInfos(List<ItemInfo> itemInfos) {
		this.itemInfos = itemInfos;
	}

}

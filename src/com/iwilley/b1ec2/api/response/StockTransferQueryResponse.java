package com.iwilley.b1ec2.api.response;

import java.util.List;

import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.domain.StockTransfer;
import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public class StockTransferQueryResponse extends B1EC2Response {

	private static final long serialVersionUID = -8235625657666488303L;

	// 搜索到的商品总数
	@ApiField("TotalResults")
	public int totalResults;

	@ApiListField("StockTransfers")
	@ApiField("StockTransfer")
	private List<StockTransfer> stockTransfers;

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public List<StockTransfer> getStockTransfers() {
		return stockTransfers;
	}

	public void setStockTransfers(List<StockTransfer> stockTransfers) {
		this.stockTransfers = stockTransfers;
	}
}

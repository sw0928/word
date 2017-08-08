package com.iwilley.b1ec2.api.response;

import java.util.List;

import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.domain.FinJournal;
import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public class FinJournalQueryResponse extends B1EC2Response {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4420761874054016003L;

	//搜索到的商品总数
	@ApiField("TotalResults")
    public int totalResults;
    
	@ApiListField("FinJournals")
	@ApiField("FinJournal")
	private List<FinJournal> finJournals;

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public List<FinJournal> getFinJournals() {
		return finJournals;
	}

	public void setFinJournals(List<FinJournal> finJournals) {
		this.finJournals = finJournals;
	}


}

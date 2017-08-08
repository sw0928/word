package com.iwilley.b1ec2.api.request;

import java.util.Date;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.StockTransferQueryResponse;

public class StockTransferQueryRequest implements B1EC2Request<StockTransferQueryResponse> {

	// ������ʼʱ��
	public Date startTime;

	// ��������ʱ��
	public Date endTime;

	// ҳ�롣ȡֵ��Χ:�����������;Ĭ��ֵ:1��
	public Integer pageNum;

	// ÿҳ������ȡֵ��Χ��1~100��Ĭ��ֵ��50
	public Integer pageSize;

	// ת������
	public String stockTransferNo;

	// ת������ 10:���ڵ�����20�������
	public Integer stockTransferType;

	// ת��״̬
	public Integer stockTransferStatus;

	public String getApiMethodName() {
		return "B1EC2.StockTransfer.Query";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("StartTime", startTime);
		parameters.put("EndTime", endTime);
		parameters.put("PageNum", pageNum);
		parameters.put("PageSize", pageSize);
		parameters.put("StockTransferNo", stockTransferNo);
		parameters.put("StockTransferType", stockTransferType);
		parameters.put("StockTransferStatus", stockTransferStatus);
		return parameters;
	}

	public Class<StockTransferQueryResponse> getResponseClass() {
		return StockTransferQueryResponse.class;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getStockTransferNo() {
		return stockTransferNo;
	}

	public void setStockTransferNo(String stockTransferNo) {
		this.stockTransferNo = stockTransferNo;
	}

	public Integer getStockTransferType() {
		return stockTransferType;
	}

	public void setStockTransferType(Integer stockTransferType) {
		this.stockTransferType = stockTransferType;
	}

	public Integer getStockTransferStatus() {
		return stockTransferStatus;
	}

	public void setStockTransferStatus(Integer stockTransferStatus) {
		this.stockTransferStatus = stockTransferStatus;
	}

}

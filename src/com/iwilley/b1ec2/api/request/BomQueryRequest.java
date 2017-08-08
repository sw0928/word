package com.iwilley.b1ec2.api.request;

import java.util.Date;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.BomQueryResponse;

// ��ѯ�����Ʒ�ӿ�
public class BomQueryRequest implements B1EC2Request<BomQueryResponse> {
	
    // �޸Ŀ�ʼʱ��
    public Date startTime;

    // �޸Ľ���ʱ��
    public Date endTime;

    // ҳ�롣ȡֵ��Χ:�����������;Ĭ��ֵ:1��
    public Integer pageNum;

    // ÿҳ������ȡֵ��Χ��1~100��Ĭ��ֵ��50
    public Integer pageSize;
	
	public String getApiMethodName() {
		return "B1EC2.Bom.Query";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("StartTime", startTime);
		parameters.put("EndTime", endTime);
		parameters.put("PageNum", pageNum);
		parameters.put("PageSize", pageSize);
		return parameters;
	}

	public Class<BomQueryResponse> getResponseClass() {
		return BomQueryResponse.class;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}

package com.iwilley.b1ec2.api.request;

import java.util.Date;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.AfterSalesServiceQueryResponse;

public class AfterSalesServiceQueryRequest implements B1EC2Request<AfterSalesServiceQueryResponse>{

    //����״̬��Ĭ�ϲ�ѯ����״̬�����ݣ�����Ĭ��ֵ��ÿ��ֻ�ܲ�ѯһ��״̬�� (�ݸ� 10,������ 20,��� 30,ɾ�� 90)
    public Integer status;
    
    //���˿�10�����˿�20  ���� 30 ���� 40 ������ 50
    public Integer type;

	//�����޸Ŀ�ʼʱ��
    public Date startTime;

    //�����޸Ľ���ʱ��
    public Date endTime;

    // ҳ�롣ȡֵ��Χ:�����������;Ĭ��ֵ:1��
    // ע��������õ���ķ�ҳ��ʽ�������һҳ����ȡ�����ܱ���©�����⡣
    public Integer pageNum;

    //ÿҳ������ȡֵ��Χ��1~100��Ĭ��ֵ��50
    public Integer pageSize;
    
	public String getApiMethodName() {
        return "B1EC2.AfterSalesService.Query";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("Status", status);
		parameters.put("Type", type);
		parameters.put("StartTime", startTime);
		parameters.put("EndTime", endTime);
		parameters.put("PageNum", pageNum);
		parameters.put("PageSize", pageSize);
		return parameters;
	}

	public Class<AfterSalesServiceQueryResponse> getResponseClass() {
		return AfterSalesServiceQueryResponse.class;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
	
	
}

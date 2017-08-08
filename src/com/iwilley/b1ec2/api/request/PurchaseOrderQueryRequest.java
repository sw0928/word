package com.iwilley.b1ec2.api.request;

import java.util.Date;
import java.util.Map;
import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.PurchaseOrderQueryResponse;

public class PurchaseOrderQueryRequest implements B1EC2Request<PurchaseOrderQueryResponse>{

	//�ֿ�ID��Ĭ�ϲ�ѯ���вֿ�����ݣ�����Ĭ��ֵ��ÿ��ֻ�ܲ�ѯһ���ֿ⡣ 
    public Integer whsId;
  
    /// ״̬��Ĭ�ϲ�ѯ���н���״̬�����ݣ�����Ĭ��ֵ��ÿ��ֻ�ܲ�ѯһ��״̬�� 
    /// 10:open;20:closed;30:canceled;40:draft;
    public Integer status;
    
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
        return "B1EC2.PurchaseOrder.Query";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("WhsId", whsId);
		parameters.put("Status", status);
		parameters.put("StartTime", startTime);
		parameters.put("EndTime", endTime);
		parameters.put("PageNum", pageNum);
		parameters.put("PageSize", pageSize);
		return parameters;
	}

	public Class<PurchaseOrderQueryResponse> getResponseClass() {
		return PurchaseOrderQueryResponse.class;
	}

	public Integer getWhsId() {
		return whsId;
	}

	public void setWhsId(Integer whsId) {
		this.whsId = whsId;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

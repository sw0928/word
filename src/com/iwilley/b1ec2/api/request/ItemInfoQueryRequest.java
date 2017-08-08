package com.iwilley.b1ec2.api.request;

import java.util.Date;
import java.util.Map;
import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.ItemInfoQueryResponse;

public class ItemInfoQueryRequest implements B1EC2Request<ItemInfoQueryResponse>{

	//��Ʒ�޸Ŀ�ʼʱ��
    public Date startTime;

    //��Ʒ�޸Ľ���ʱ��
    public Date endTime;

    //ҳ�롣ȡֵ��Χ:�����������;Ĭ��ֵ:1��
    public Integer pageNum;

    //ÿҳ������ȡֵ��Χ��1~100��Ĭ��ֵ��50
    public Integer pageSize;
    
    /// //�Զ�������1
    public String property1;

    /// //�Զ�������2
    public String property2;
    
	public String getApiMethodName() {
        return "B1EC2.ItemInfo.Query";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("StartTime", startTime);
		parameters.put("EndTime", endTime);
		parameters.put("PageNum", pageNum);
		parameters.put("PageSize", pageSize);
		parameters.put("Property1", property1);
		parameters.put("Property2", property2);
		return parameters;
	}

	public Class<ItemInfoQueryResponse> getResponseClass() {
		return ItemInfoQueryResponse.class;
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
	
	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}
	
	public String getProperty2() {
		return property2;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
	}
}

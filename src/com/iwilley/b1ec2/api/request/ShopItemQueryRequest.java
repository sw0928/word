package com.iwilley.b1ec2.api.request;

import java.util.Date;
import java.util.Map;
import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.ShopItemQueryResponse;

public class ShopItemQueryRequest implements B1EC2Request<ShopItemQueryResponse>{

	//��Ʒ�޸Ŀ�ʼʱ��
    public Date startTime;

    //��Ʒ�޸Ľ���ʱ��
    public Date endTime;

    //ҳ�롣ȡֵ��Χ:�����������;Ĭ��ֵ:1��
    public Integer pageNum;

    //ÿҳ������ȡֵ��Χ��1~100��Ĭ��ֵ��50
    public Integer pageSize;
    
    ///����id
    public Integer shopId;

    
	public String getApiMethodName() {
        return "B1EC2.ShopItem.Query";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("StartTime", startTime);
		parameters.put("EndTime", endTime);
		parameters.put("PageNum", pageNum);
		parameters.put("PageSize", pageSize);
		parameters.put("ShopId", shopId);
		return parameters;
	}

	public Class<ShopItemQueryResponse> getResponseClass() {
		return ShopItemQueryResponse.class;
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

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

}

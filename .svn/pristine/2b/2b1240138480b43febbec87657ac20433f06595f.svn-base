package com.iwilley.b1ec2.api.request;

import java.util.Date;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.SalesOrderQueryResponse;

public class SalesOrderQueryRequest implements B1EC2Request<SalesOrderQueryResponse>{

	//锟街匡拷ID锟斤拷默锟较诧拷询锟斤拷锟叫仓匡拷锟斤拷锟斤拷荩锟斤拷锟斤拷锟侥拷锟街碉拷锟矫匡拷锟街伙拷懿锟窖伙拷锟斤拷挚狻� 
    public Integer whsId;

   //锟斤拷锟斤拷ID锟斤拷默锟较诧拷询锟斤拷锟叫碉拷锟教碉拷锟斤拷锟捷ｏ拷
    public Integer shopId;
    
    /// 时锟斤拷锟斤拷锟酵ｏ拷默锟斤拷10
    /// 10:锟斤拷锟斤拷锟斤拷时锟斤拷;20:锟斤拷锟斤拷锟斤拷时锟斤拷
    public Integer timeType;
    
    // 锟斤拷锟斤拷状态锟斤拷默锟较诧拷询锟斤拷锟叫斤拷锟斤拷状态锟斤拷锟斤拷锟捷ｏ拷锟斤拷锟斤拷默锟斤拷值锟斤拷每锟斤拷只锟杰诧拷询一锟斤拷状态锟斤拷 
    // 10:锟斤拷锟斤拷锟斤拷;20:锟斤拷锟斤拷锟斤拷;30:锟斤拷锟斤拷通锟斤拷;40:锟斤拷始锟斤拷锟�;43:锟斤拷锟斤拷锟�;45:锟窖筹拷锟斤拷;60:锟窖斤拷锟斤拷;70:锟斤拷锟斤拷锟�;80:锟斤拷取锟斤拷;99:锟斤拷删锟斤拷;
    public Integer status;
    
    //锟斤拷锟斤拷锟斤拷
    public String orderNo;
   
    public String shopOrderNo;

	//锟斤拷锟斤拷锟睫改匡拷始时锟斤拷
    public Date startTime;

    //锟斤拷锟斤拷锟睫改斤拷锟斤拷时锟斤拷
    public Date endTime;

    // 页锟诫。取值锟斤拷围:锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�;默锟斤拷值:1锟斤拷
    // 注锟斤拷锟斤拷锟斤拷锟斤拷玫锟斤拷锟侥凤拷页锟斤拷式锟斤拷锟斤拷锟斤拷锟揭灰筹拷锟斤拷锟饺★拷锟斤拷锟斤拷鼙锟斤拷锟铰╋拷锟斤拷锟斤拷狻�
    public Integer pageNum;

    //每页锟斤拷锟斤拷锟斤拷取值锟斤拷围锟斤拷1~100锟斤拷默锟斤拷值锟斤拷50
    public Integer pageSize;
    
    /// //锟皆讹拷锟斤拷锟斤拷锟斤拷1
    public String userDefinedField1;

    /// //锟皆讹拷锟斤拷锟斤拷锟斤拷2
    public String userDefinedField2;
    
    // 锟斤拷票锟斤拷
    public String invoiceNo;
    
	public String getApiMethodName() {
        return "B1EC2.SalesOrder.Query";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("WhsId", whsId);
		parameters.put("TimeType", timeType);
		parameters.put("OrderNo", orderNo);
		parameters.put("ShopOrderNo", shopOrderNo);
		parameters.put("ShopId", shopId);
		parameters.put("Status", status);
		parameters.put("StartTime", startTime);
		parameters.put("EndTime", endTime);
		parameters.put("PageNum", pageNum);
		parameters.put("PageSize", pageSize);
		parameters.put("UserDefinedField1", userDefinedField1);
		parameters.put("UserDefinedField2", userDefinedField2);
		parameters.put("InvoiceNo", invoiceNo);
		return parameters;
	}

	public Class<SalesOrderQueryResponse> getResponseClass() {
		return SalesOrderQueryResponse.class;
	}

	public String getShopOrderNo() {
		return shopOrderNo;
	}

	public void setShopOrderNo(String shopOrderNo) {
		this.shopOrderNo = shopOrderNo;
	}

	public Integer getWhsId() {
		return whsId;
	}

	public void setWhsId(Integer whsId) {
		this.whsId = whsId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
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
	
	public String getUserDefinedField1() {
		return userDefinedField1;
	}

	public void setUserDefinedField1(String userDefinedField1) {
		this.userDefinedField1 = userDefinedField1;
	}
	
	public String getUserDefinedField2() {
		return userDefinedField2;
	}

	public void setUserDefinedField2(String userDefinedField2) {
		this.userDefinedField2 = userDefinedField2;
	}

	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}
	
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
}

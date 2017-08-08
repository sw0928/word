package com.iwilley.b1ec2.api.request;

import java.util.Date;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.PrintTaskQueryResponse;

// 
public class PrintTaskQueryRequest implements B1EC2Request<PrintTaskQueryResponse> {

	public Integer taskId;

	public Byte taskStatus;

	public Byte printType;

	public Date startTime;

	public Date endTime;

	public String getApiMethodName() {
		return "B1EC2.PrintTask.Query";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("TaskId", taskId);
		parameters.put("TaskStatus", taskStatus);
		parameters.put("PrintType", printType);
		parameters.put("StartTime", startTime);
		parameters.put("EndTime", endTime);
		return parameters;
	}

	public Class<PrintTaskQueryResponse> getResponseClass() {
		return PrintTaskQueryResponse.class;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public Byte getTaskStatus() {
		return taskStatus;
	}

	public Byte getPrintType() {
		return printType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public void setTaskStatus(Byte taskStatus) {
		this.taskStatus = taskStatus;
	}

	public void setPrintType(Byte printType) {
		this.printType = printType;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}

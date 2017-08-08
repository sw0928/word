package com.iwilley.b1ec2.api.request;

import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.PrintTaskUpdateResponse;

public class PrintTaskUpdateRequest implements B1EC2Request<PrintTaskUpdateResponse> {

	public Integer taskId;

	public Integer taskStatus;

	public String memo;

	public String getApiMethodName() {
		return "B1EC2.PrintTask.Update";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("TaskId", taskId);
		parameters.put("TaskStatus", taskStatus);
		parameters.put("Memo", memo);
		return parameters;
	}

	public Class<PrintTaskUpdateResponse> getResponseClass() {
		return PrintTaskUpdateResponse.class;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public Integer getTaskStatus() {
		return taskStatus;
	}

	public String getMemo() {
		return memo;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public void setTaskStatus(Integer taskStatus) {
		this.taskStatus = taskStatus;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}

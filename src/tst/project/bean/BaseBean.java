package tst.project.bean;

public class BaseBean {
	private String status;
	private String error;
	private Object data;
	private int total;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Object getObject() {
		return data;
	}
	public void setObject(Object object) {
		this.data = object;
	}
	public Object getData() {
		return data;
	}
	public BaseBean setData(Object data) {
		this.data = data;
		return this;
	}
	public int getTotal() {
		return total;
	}
	public BaseBean setTotal(int total) {
		this.total = total;
		return this;
	}
	
	
}

package tst.project.bean.order;

public class InviseBean {
	private int invise_id;
	private String invise_desc;
	private String is_delete;
	private String create_time;
	public int getInvise_id() {
		return invise_id;
	}
	public InviseBean setInvise_id(int invise_id) {
		this.invise_id = invise_id;
		return this;
	}
	public String getInvise_desc() {
		return invise_desc;
	}
	public InviseBean setInvise_desc(String invise_desc) {
		this.invise_desc = invise_desc;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public InviseBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public InviseBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	
}

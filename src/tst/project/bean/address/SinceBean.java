package tst.project.bean.address;

public class SinceBean {
	private int since_id;
	private String city_id;
	private String since_name;
	private String since_address;
	private String is_delete;
	private String create_time;
	
	public String getSince_address() {
		return since_address;
	}
	public SinceBean setSince_address(String since_address) {
		this.since_address = since_address;
		return this;
	}
	public int getSince_id() {
		return since_id;
	}
	public SinceBean setSince_id(int since_id) {
		this.since_id = since_id;
		return this;
	}
	public String getCity_id() {
		return city_id;
	}
	public SinceBean setCity_id(String city_id) {
		this.city_id = city_id;
		return this;
	}
	public String getSince_name() {
		return since_name;
	}
	public SinceBean setSince_name(String since_name) {
		this.since_name = since_name;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SinceBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SinceBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	
	
}

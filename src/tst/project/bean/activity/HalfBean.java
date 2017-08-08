package tst.project.bean.activity;

public class HalfBean {
	private int half_id;
	private int activity_id;
	private int half_count;
	private String create_time;
	private String is_delete;
	private String sort;
	private String is_add;

	
	public String getIs_add() {
		return is_add;
	}
	public HalfBean setIs_add(String is_add) {
		this.is_add = is_add;
		return this;
	}
	public int getHalf_id() {
		return half_id;
	}
	public HalfBean setHalf_id(int half_id) {
		this.half_id = half_id;
		return this;
	}
	public int getActivity_id() {
		return activity_id;
	}
	public HalfBean setActivity_id(int activity_id) {
		this.activity_id = activity_id;
		return this;
	}
	public int getHalf_count() {
		return half_count;
	}
	public HalfBean setHalf_count(int half_count) {
		this.half_count = half_count;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public HalfBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public HalfBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public HalfBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	
}

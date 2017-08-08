package tst.project.bean.activity;

public class GiveBean {
	private int give_id;
	private int activity_id;
	private int give_need_count;
	private int give_count;
	private String create_time;
	private int is_delete;
	private int sort;
	private String is_add;

	
	public String getIs_add() {
		return is_add;
	}
	public GiveBean setIs_add(String is_add) {
		this.is_add = is_add;
		return this;
	}
	public int getGive_id() {
		return give_id;
	}
	public GiveBean setGive_id(int give_id) {
		this.give_id = give_id;
		return this;
	}
	public int getActivity_id() {
		return activity_id;
	}
	public GiveBean setActivity_id(int activity_id) {
		this.activity_id = activity_id;
		return this;
	}
	public int getGive_need_count() {
		return give_need_count;
	}
	public GiveBean setGive_need_count(int give_need_count) {
		this.give_need_count = give_need_count;
		return this;
	}
	public int getGive_count() {
		return give_count;
	}
	public GiveBean setGive_count(int give_count) {
		this.give_count = give_count;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GiveBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public GiveBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public int getSort() {
		return sort;
	}
	public GiveBean setSort(int sort) {
		this.sort = sort;
		return this;
	}
}

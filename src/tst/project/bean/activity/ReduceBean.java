package tst.project.bean.activity;

public class ReduceBean {
	private int reduce_id;
	private int activity_id;
	private float reduce_need_price;
	private float reduce_price;
	private String create_time;
	private int is_delete;
	private int sort;
	private String is_add;

	
	public String getIs_add() {
		return is_add;
	}
	public ReduceBean setIs_add(String is_add) {
		this.is_add = is_add;
		return this;
	}
	
	public int getReduce_id() {
		return reduce_id;
	}
	public ReduceBean setReduce_id(int reduce_id) {
		this.reduce_id = reduce_id;
		return this;
	}
	public int getActivity_id() {
		return activity_id;
	}
	public ReduceBean setActivity_id(int activity_id) {
		this.activity_id = activity_id;
		return this;
	}
	public float getReduce_need_price() {
		return reduce_need_price;
	}
	public ReduceBean setReduce_need_price(float reduce_need_price) {
		this.reduce_need_price = reduce_need_price;
		return this;
	}
	public float getReduce_price() {
		return reduce_price;
	}
	public ReduceBean setReduce_price(float reduce_price) {
		this.reduce_price = reduce_price;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ReduceBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public ReduceBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public int getSort() {
		return sort;
	}
	public ReduceBean setSort(int sort) {
		this.sort = sort;
		return this;
	}
	
	
	
}

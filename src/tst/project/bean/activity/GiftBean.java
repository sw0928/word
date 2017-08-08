package tst.project.bean.activity;

public class GiftBean {
	private int gift_id;
	private int activity_id;
	private float gift_need_price;
	private String gift_desc;
	private String create_time;
	private int is_delete;
	private int sort;
	private String is_add;

	
	public String getIs_add() {
		return is_add;
	}
	public GiftBean setIs_add(String is_add) {
		this.is_add = is_add;
		return this;
	}
	
	public int getGift_id() {
		return gift_id;
	}
	public GiftBean setGift_id(int gift_id) {
		this.gift_id = gift_id;
		return this;
	}
	public int getActivity_id() {
		return activity_id;
	}
	public GiftBean setActivity_id(int activity_id) {
		this.activity_id = activity_id;
		return this;
	}
	public float getGift_need_price() {
		return gift_need_price;
	}
	public GiftBean setGift_need_price(float gift_need_price) {
		this.gift_need_price = gift_need_price;
		return this;
	}
	public String getGift_desc() {
		return gift_desc;
	}
	public GiftBean setGift_desc(String gift_desc) {
		this.gift_desc = gift_desc;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GiftBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public GiftBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public int getSort() {
		return sort;
	}
	public GiftBean setSort(int sort) {
		this.sort = sort;
		return this;
	}
	
	
}

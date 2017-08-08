package tst.project.bean.goods;

public class TimingGoodsBean {
	private int timing_id;
	private String goods_sku;
	private String goods_now_price;
	private String goods_origin_price;
	private String goods_new_price;
	private String create_time;
	private String is_delete;
	private String modify_time;
	private String timing_state;
	private String remark;
	
	public String getTiming_state() {
		return timing_state;
	}
	public TimingGoodsBean setTiming_state(String timing_state) {
		this.timing_state = timing_state;
		return this;
	}
	public String getRemark() {
		return remark;
	}
	public TimingGoodsBean setRemark(String remark) {
		this.remark = remark;
		return this;
	}
	public int getTiming_id() {
		return timing_id;
	}
	public TimingGoodsBean setTiming_id(int timing_id) {
		this.timing_id = timing_id;
		return this;
	}
	public String getGoods_sku() {
		return goods_sku;
	}
	public TimingGoodsBean setGoods_sku(String goods_sku) {
		this.goods_sku = goods_sku;
		return this;
	}
	public String getGoods_now_price() {
		return goods_now_price;
	}
	public TimingGoodsBean setGoods_now_price(String goods_now_price) {
		this.goods_now_price = goods_now_price;
		return this;
	}
	public String getGoods_origin_price() {
		return goods_origin_price;
	}
	public TimingGoodsBean setGoods_origin_price(String goods_origin_price) {
		this.goods_origin_price = goods_origin_price;
		return this;
	}
	public String getGoods_new_price() {
		return goods_new_price;
	}
	public TimingGoodsBean setGoods_new_price(String goods_new_price) {
		this.goods_new_price = goods_new_price;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public TimingGoodsBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public TimingGoodsBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getModify_time() {
		return modify_time;
	}
	public TimingGoodsBean setModify_time(String modify_time) {
		this.modify_time = modify_time;
		return this;
	}
	
}

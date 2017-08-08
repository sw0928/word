package tst.project.bean.order;

public class OrderSWBean {
	public int order_id;
	private String member_name;
	private String member_mobile;
	private String goods_name;
	private String goods_num;
	private String order_price;
	private String order_state;
	private String order_state_show;
	private String create_time;
	private String member_id;
	private String address;
	private String member_order_id;
	private String grab_state;
	private String grab_state_show;
	private String grab_member_account;
	private String grab_nick_name;
	private String grab_hx_account;
	private String grab_hx_nick_name;
	

	public String getGrab_member_account() {
		return grab_member_account;
	}
	public OrderSWBean setGrab_member_account(String grab_member_account) {
		this.grab_member_account = grab_member_account;
		return this;
	}
	public String getGrab_nick_name() {
		return grab_nick_name;
	}
	public OrderSWBean setGrab_nick_name(String grab_nick_name) {
		this.grab_nick_name = grab_nick_name;
		return this;
	}
	public String getGrab_hx_account() {
		return grab_hx_account;
	}
	public OrderSWBean setGrab_hx_account(String grab_hx_account) {
		this.grab_hx_account = grab_hx_account;
		return this;
	}
	public String getGrab_hx_nick_name() {
		return grab_hx_nick_name;
	}
	public OrderSWBean setGrab_hx_nick_name(String grab_hx_nick_name) {
		this.grab_hx_nick_name = grab_hx_nick_name;
		return this;
	}
	public String getOrder_state_show() {
		return order_state_show;
	}
	public OrderSWBean setOrder_state_show(String order_state_show) {
		this.order_state_show = order_state_show;
		return this;
	}
	public String getGrab_state_show() {
		return grab_state_show;
	}
	public OrderSWBean setGrab_state_show(String grab_state_show) {
		this.grab_state_show = grab_state_show;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public OrderSWBean setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getMember_order_id() {
		return member_order_id;
	}
	public OrderSWBean setMember_order_id(String member_order_id) {
		this.member_order_id = member_order_id;
		return this;
	}
	public String getGrab_state() {
		return grab_state;
	}
	public OrderSWBean setGrab_state(String grab_state) {
		this.grab_state = grab_state;
		this.grab_state_show="wait_grab".equals(grab_state)?"等待抢单":
							("end".equals(grab_state)?"已抢单":"");
		return this;
	}
	public int getOrder_id() {
		return order_id;
	}
	public OrderSWBean setOrder_id(int order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getMember_name() {
		return member_name;
	}
	public OrderSWBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public String getMember_mobile() {
		return member_mobile;
	}
	public OrderSWBean setMember_mobile(String member_mobile) {
		this.member_mobile = member_mobile;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public OrderSWBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_num() {
		return goods_num;
	}
	public OrderSWBean setGoods_num(String goods_num) {
		this.goods_num = goods_num;
		return this;
	}
	public String getOrder_price() {
		return order_price;
	}
	public OrderSWBean setOrder_price(String order_price) {
		this.order_price = order_price;
		return this;
	}
	public String getOrder_state() {
		return order_state;
	}
	public OrderSWBean setOrder_state(String order_state) {
		this.order_state = order_state;
		this.order_state_show="wait_grab".equals(order_state)?"等待抢单":
								("end".equals(order_state)?"已抢单":
									("cancel".equals(order_state)?"取消订单":"未知"));
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public OrderSWBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public OrderSWBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}

}

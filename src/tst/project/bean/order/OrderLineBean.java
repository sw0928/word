package tst.project.bean.order;
/**
 * 线下订单
 * @author shenjiabo
 *
 */
public class OrderLineBean {
	private int order_id;
	private String order_no;
	private String create_time;
	private int is_delete;
	private float order_total_price;
	private String order_state;
	private int member_id;
	
	public int getMember_id() {
		return member_id;
	}
	public OrderLineBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getOrder_id() {
		return order_id;
	}
	public OrderLineBean setOrder_id(int order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getOrder_no() {
		return order_no;
	}
	public OrderLineBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public OrderLineBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public OrderLineBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public float getOrder_total_price() {
		return order_total_price;
	}
	public OrderLineBean setOrder_total_price(float order_total_price) {
		this.order_total_price = order_total_price;
		return this;
	}
	public String getOrder_state() {
		return order_state;
	}
	public OrderLineBean setOrder_state(String order_state) {
		this.order_state = order_state;
		return this;
	}
}

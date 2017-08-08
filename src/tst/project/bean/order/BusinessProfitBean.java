package tst.project.bean.order;

public class BusinessProfitBean{
	private int business_profit_id;
	private int business_id;
	private int member_id;
	private int order_goods_id;
	private double profit_price;
	private String create_time;
	private String profit_state;
	private String profit_type;
	private String percent_value;
	private int merchants_account_id;
	private String goods_name;
	private String order_no;
	private String total_price;
	
	private String start_time;
	private String end_time;
	

	public String getStart_time() {
		return start_time;
	}
	public BusinessProfitBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public BusinessProfitBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public BusinessProfitBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getOrder_no() {
		return order_no;
	}
	public BusinessProfitBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}
	public String getTotal_price() {
		return total_price;
	}
	public BusinessProfitBean setTotal_price(String total_price) {
		this.total_price = total_price;
		return this;
	}
	public int getMerchants_account_id() {
		return merchants_account_id;
	}
	public BusinessProfitBean setMerchants_account_id(int merchants_account_id) {
		this.merchants_account_id = merchants_account_id;
		return this;
	}
	public String getPercent_value() {
		return percent_value;
	}
	public BusinessProfitBean setPercent_value(String percent_value) {
		this.percent_value = percent_value;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public BusinessProfitBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getProfit_type() {
		return profit_type;
	}
	public BusinessProfitBean setProfit_type(String profit_type) {
		this.profit_type = profit_type;
		return this;
	}
	public int getBusiness_profit_id() {
		return business_profit_id;
	}
	public BusinessProfitBean setBusiness_profit_id(int business_profit_id) {
		this.business_profit_id = business_profit_id;
		return this;
	}
	public int getBusiness_id() {
		return business_id;
	}
	public BusinessProfitBean setBusiness_id(int business_id) {
		this.business_id = business_id;
		return this;
	}
	public int getOrder_goods_id() {
		return order_goods_id;
	}
	public BusinessProfitBean setOrder_goods_id(int order_goods_id) {
		this.order_goods_id = order_goods_id;
		return this;
	}
	public double getProfit_price() {
		return profit_price;
	}
	public BusinessProfitBean setProfit_price(double profit_price) {
		this.profit_price = profit_price;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public BusinessProfitBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getProfit_state() {
		return profit_state;
	}
	public BusinessProfitBean setProfit_state(String profit_state) {
		this.profit_state = profit_state;
		return this;
	}
	
}

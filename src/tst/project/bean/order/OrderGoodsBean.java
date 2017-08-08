package tst.project.bean.order;

import java.util.List;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsImgBean;

public class OrderGoodsBean {
	private int order_goods_id;
	private String order_id;
	private String order_no;
	private String goods_id;
	private int goods_num;
	private double total_price;
	private String is_deduct_integral;
	private String assessment_state;
	private String goods_price;
	private String deduct_integral_value;
	private String deduct_integral_price;
	private String is_express;
	private String express_price;
	private String is_give_integral;
	private String give_integral_value;
	private String goods_name;
	private String goods_img;
	private String merchants_id;
	private String goods_url;
	private String goods_address;

	private String group_buy_price;
	private String promotion_price;
	private String promotion_goods_id;
	private String promotion_id;
	
	private String is_pre_sale;
	private String send_goods_time;

	private String refund_state;
	private String business_id;
	private String merchants_account_id;
	private String goods_sku;
	private String is_refund;//是否有退款
	private String refund_id;//退款申请id
	
	private float profits_price;
	
	
	private String activity_type;//活动类型
	private int give_need_count;//需要件数
	private int give_count;//赠送件数
	private float reduce_need_price;//满多少减免金额
	private float reduce_price;//减免金额
	private String reduce_total_price;//满减活动总和
	private String reduce_actual_price;//实际减免金额
	private String gift_desc;//礼物描述
	private String is_add;//是否递增
	private String half_count;//第几件半价
	private String half_price;//半价减免的钱
	private String exempt_need_count;//减免需要件数
	private String exempt_count;//减免件数
	
	private String is_profit;//是否已分配奖金
	
	private int is_cross_border;//是否跨境
	private float cross_border_tax;//跨境税
	
	private String goods_parameters_name;
	
	private String share_car_id;
	
	

	private String order_total_price;
	private String order_actual_price;
	private String name;
	private String mobile;
	private String detailed_address;
	private String order_state;
	private String order_state_show;
	private String pay_way;
	private String remark;
	private String create_time;
	private String job_unit;
	private String apply_company;
	private GoodsBean goodsBean;
	private OrderActivityBean orderActivityBean;
	private List<GoodsImgBean> goodsImgBeans;
	
	/*
	 * 新增属性
	 */
	private String order_goods_state;
	private String order_goods_state_show;
	private String supplier_id;
	private String start_time;
	private String end_time;
	private String city;
	private String storehouse_id;
	private String storehouse_name;
	private String merchants_type;
	public String getApply_company() {
		return apply_company;
	}
	public OrderGoodsBean setApply_company(String apply_company) {
		this.apply_company = apply_company;
		return this;
	}
	public String getJob_unit() {
		return job_unit;
	}
	public OrderGoodsBean setJob_unit(String job_unit) {
		this.job_unit = job_unit;
		return this;
	}
	public String getOrder_total_price() {
		return order_total_price;
	}
	public OrderGoodsBean setOrder_total_price(String order_total_price) {
		this.order_total_price = order_total_price;
		return this;
	}
	public String getOrder_actual_price() {
		return order_actual_price;
	}
	public OrderGoodsBean setOrder_actual_price(String order_actual_price) {
		this.order_actual_price = order_actual_price;
		return this;
	}
	public String getName() {
		return name;
	}
	public OrderGoodsBean setName(String name) {
		this.name = name;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public OrderGoodsBean setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public String getDetailed_address() {
		return detailed_address;
	}
	public OrderGoodsBean setDetailed_address(String detailed_address) {
		this.detailed_address = detailed_address;
		return this;
	}
	public String getOrder_state() {
		return order_state;
	}
	public OrderGoodsBean setOrder_state(String order_state) {
		this.order_state = order_state;
		this.order_state_show = "cancel".equals(order_state)?"已取消":
			("wait_pay".equals(order_state)?"待付款":
				("wait_group_buy".equals(order_state)?"待团购人满":
				("wait_send".equals(order_state)?"待发货":
					("wait_receive".equals(order_state)?"待确认收货":
						("wait_assessment".equals(order_state)?"待评价":"已完成")))));
		return this;
	}
	public String getOrder_state_show() {
		return order_state_show;
	}
	public OrderGoodsBean setOrder_state_show(String order_state_show) {
		this.order_state_show = order_state_show;
		return this;
	}
	public String getPay_way() {
		return pay_way;
	}
	public OrderGoodsBean setPay_way(String pay_way) {
		this.pay_way = pay_way;
		return this;
	}
	public String getRemark() {
		return remark;
	}
	public OrderGoodsBean setRemark(String remark) {
		this.remark = remark;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public OrderGoodsBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getShare_car_id() {
		return share_car_id;
	}
	public OrderGoodsBean setShare_car_id(String share_car_id) {
		this.share_car_id = share_car_id;
		return this;
	}
	public OrderActivityBean getOrderActivityBean() {
		return orderActivityBean;
	}
	public OrderGoodsBean setOrderActivityBean(OrderActivityBean orderActivityBean) {
		this.orderActivityBean = orderActivityBean;
		return this;
	}
	public String getReduce_total_price() {
		return reduce_total_price;
	}
	public OrderGoodsBean setReduce_total_price(String reduce_total_price) {
		this.reduce_total_price = reduce_total_price;
		return this;
	}
	public String getReduce_actual_price() {
		return reduce_actual_price;
	}
	public OrderGoodsBean setReduce_actual_price(String reduce_actual_price) {
		this.reduce_actual_price = reduce_actual_price;
		return this;
	}
	public String getHalf_price() {
		return half_price;
	}
	public OrderGoodsBean setHalf_price(String half_price) {
		this.half_price = half_price;
		return this;
	}
	public String getHalf_count() {
		return half_count;
	}
	public OrderGoodsBean setHalf_count(String half_count) {
		this.half_count = half_count;
		return this;
	}
	public String getExempt_need_count() {
		return exempt_need_count;
	}
	public OrderGoodsBean setExempt_need_count(String exempt_need_count) {
		this.exempt_need_count = exempt_need_count;
		return this;
	}
	public String getExempt_count() {
		return exempt_count;
	}
	public OrderGoodsBean setExempt_count(String exempt_count) {
		this.exempt_count = exempt_count;
		return this;
	}
	public String getIs_add() {
		return is_add;
	}
	public OrderGoodsBean setIs_add(String is_add) {
		this.is_add = is_add;
		return this;
	}
	public String getGoods_parameters_name() {
		return goods_parameters_name;
	}
	public OrderGoodsBean setGoods_parameters_name(String goods_parameters_name) {
		this.goods_parameters_name = goods_parameters_name;
		return this;
	}
	public int getIs_cross_border() {
		return is_cross_border;
	}
	public OrderGoodsBean setIs_cross_border(int is_cross_border) {
		this.is_cross_border = is_cross_border;
		return this;
	}
	public float getCross_border_tax() {
		return cross_border_tax;
	}
	public OrderGoodsBean setCross_border_tax(float cross_border_tax) {
		this.cross_border_tax = cross_border_tax;
		return this;
	}
	public String getIs_profit() {
		return is_profit;
	}
	public OrderGoodsBean setIs_profit(String is_profit) {
		this.is_profit = is_profit;
		return this;
	}
	public String getGift_desc() {
		return gift_desc;
	}
	public OrderGoodsBean setGift_desc(String gift_desc) {
		this.gift_desc = gift_desc;
		return this;
	}
	public String getActivity_type() {
		return activity_type;
	}
	public OrderGoodsBean setActivity_type(String activity_type) {
		this.activity_type = activity_type;
		return this;
	}
	public int getGive_need_count() {
		return give_need_count;
	}
	public OrderGoodsBean setGive_need_count(int give_need_count) {
		this.give_need_count = give_need_count;
		return this;
	}
	public int getGive_count() {
		return give_count;
	}
	public OrderGoodsBean setGive_count(int give_count) {
		this.give_count = give_count;
		return this;
	}
	public float getReduce_need_price() {
		return reduce_need_price;
	}
	public OrderGoodsBean setReduce_need_price(float reduce_need_price) {
		this.reduce_need_price = reduce_need_price;
		return this;
	}
	public float getReduce_price() {
		return reduce_price;
	}
	public OrderGoodsBean setReduce_price(float reduce_price) {
		this.reduce_price = reduce_price;
		return this;
	}

	
	public float getProfits_price() {
		return profits_price;
	}
	public OrderGoodsBean setProfits_price(float profits_price) {
		this.profits_price = profits_price;
		return this;
	}
	public String getOrder_no() {
		return order_no;
	}
	public OrderGoodsBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}
	public double getTotal_price() {
		return total_price;
	}
	public OrderGoodsBean setTotal_price(double total_price) {
		this.total_price = total_price;
		return this;
	}
	public String getMerchants_account_id() {
		return merchants_account_id;
	}
	public OrderGoodsBean setMerchants_account_id(String merchants_account_id) {
		this.merchants_account_id = merchants_account_id;
		return this;
	}
	public String getIs_refund() {
		return is_refund;
	}
	public OrderGoodsBean setIs_refund(String is_refund) {
		this.is_refund = is_refund;
		return this;
	}
	
	public String getRefund_id() {
		return refund_id;
	}
	public OrderGoodsBean setRefund_id(String refund_id) {
		this.refund_id = refund_id;
		return this;
	}
	public String getGoods_sku() {
		return goods_sku;
	}
	public OrderGoodsBean setGoods_sku(String goods_sku) {
		this.goods_sku = goods_sku;
		return this;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public OrderGoodsBean setBusiness_id(String business_id) {
		this.business_id = business_id;
		return this;
	}
	public String getRefund_state() {
		return refund_state;
	}
	public OrderGoodsBean setRefund_state(String refund_state) {
		this.refund_state = refund_state;
		return this;
	}
	public String getIs_pre_sale() {
		return is_pre_sale;
	}
	public OrderGoodsBean setIs_pre_sale(String is_pre_sale) {
		this.is_pre_sale = is_pre_sale;
		return this;
	}
	public String getSend_goods_time() {
		return send_goods_time;
	}
	public OrderGoodsBean setSend_goods_time(String send_goods_time) {
		this.send_goods_time = send_goods_time;
		return this;
	}
	public String getPromotion_id() {
		return promotion_id;
	}
	public OrderGoodsBean setPromotion_id(String promotion_id) {
		this.promotion_id = promotion_id;
		return this;
	}
	public String getGroup_buy_price() {
		return group_buy_price;
	}
	public OrderGoodsBean setGroup_buy_price(String group_buy_price) {
		this.group_buy_price = group_buy_price;
		return this;
	}
	public String getPromotion_price() {
		return promotion_price;
	}
	public OrderGoodsBean setPromotion_price(String promotion_price) {
		this.promotion_price = promotion_price;
		return this;
	}
	public String getPromotion_goods_id() {
		return promotion_goods_id;
	}
	public OrderGoodsBean setPromotion_goods_id(String promotion_goods_id) {
		this.promotion_goods_id = promotion_goods_id;
		return this;
	}
	public List<GoodsImgBean> getGoodsImgBeans() {
		return goodsImgBeans;
	}
	public OrderGoodsBean setGoodsImgBeans(List<GoodsImgBean> goodsImgBeans) {
		this.goodsImgBeans = goodsImgBeans;
		return this;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public OrderGoodsBean setGoods_price(String goods_price) {
		this.goods_price = goods_price;
		return this;
	}
	public String getDeduct_integral_value() {
		return deduct_integral_value;
	}
	public OrderGoodsBean setDeduct_integral_value(String deduct_integral_value) {
		this.deduct_integral_value = deduct_integral_value;
		return this;
	}
	public String getDeduct_integral_price() {
		return deduct_integral_price;
	}
	public OrderGoodsBean setDeduct_integral_price(String deduct_integral_price) {
		this.deduct_integral_price = deduct_integral_price;
		return this;
	}
	public String getIs_express() {
		return is_express;
	}
	public OrderGoodsBean setIs_express(String is_express) {
		this.is_express = is_express;
		return this;
	}
	public String getExpress_price() {
		return express_price;
	}
	public OrderGoodsBean setExpress_price(String express_price) {
		this.express_price = express_price;
		return this;
	}
	public String getIs_give_integral() {
		return is_give_integral;
	}
	public OrderGoodsBean setIs_give_integral(String is_give_integral) {
		this.is_give_integral = is_give_integral;
		return this;
	}
	public String getGive_integral_value() {
		return give_integral_value;
	}
	public OrderGoodsBean setGive_integral_value(String give_integral_value) {
		this.give_integral_value = give_integral_value;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public OrderGoodsBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public OrderGoodsBean setGoods_img(String goods_img) {
		this.goods_img = goods_img;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public OrderGoodsBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getGoods_url() {
		return goods_url;
	}
	public OrderGoodsBean setGoods_url(String goods_url) {
		this.goods_url = goods_url;
		return this;
	}
	public String getGoods_address() {
		return goods_address;
	}
	public OrderGoodsBean setGoods_address(String goods_address) {
		this.goods_address = goods_address;
		return this;
	}
	private List<OrderParameterBean> orderParameterBeans;
	private List<OrderServiceBean> orderServiceBeans;
	
	public List<OrderServiceBean> getOrderServiceBeans() {
		return orderServiceBeans;
	}
	public OrderGoodsBean setOrderServiceBeans(List<OrderServiceBean> orderServiceBeans) {
		this.orderServiceBeans = orderServiceBeans;
		return this;
	}
	public List<OrderParameterBean> getOrderParameterBeans() {
		return orderParameterBeans;
	}
	public OrderGoodsBean setOrderParameterBeans(List<OrderParameterBean> orderParameterBeans) {
		this.orderParameterBeans = orderParameterBeans;
		return this;
	}
	public String getIs_deduct_integral() {
		return is_deduct_integral;
	}
	public OrderGoodsBean setIs_deduct_integral(String is_deduct_integral) {
		this.is_deduct_integral = is_deduct_integral;
		return this;
	}
	public int getOrder_goods_id() {
		return order_goods_id;
	}
	public OrderGoodsBean setOrder_goods_id(int order_goods_id) {
		this.order_goods_id = order_goods_id;
		return this;
	}
	public String getOrder_id() {
		return order_id;
	}
	public OrderGoodsBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public OrderGoodsBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public OrderGoodsBean setGoods_num(int goods_num) {
		this.goods_num = goods_num;
		return this;
	}
	public GoodsBean getGoodsBean() {
		return goodsBean;
	}
	public OrderGoodsBean setGoodsBean(GoodsBean goodsBean) {
		this.goodsBean = goodsBean;
		return this;
	}
	public String getAssessment_state() {
		return assessment_state;
	}
	public OrderGoodsBean setAssessment_state(String assessment_state) {
		this.assessment_state = assessment_state;
		return this;
	}
	
	
	/*
	 * 新增
	 */
	public String getOrder_goods_state() {
		return order_goods_state;
	}
	public OrderGoodsBean setOrder_goods_state(String order_goods_state) {
		this.order_goods_state = order_goods_state;
		this.order_goods_state_show = "cancel".equals(order_goods_state)?"已取消":
			("wait_pay".equals(order_goods_state)?"待付款":
				("wait_group_buy".equals(order_goods_state)?"待团购人满":
				("wait_send".equals(order_goods_state)?"待发货":
					("wait_receive".equals(order_goods_state)?"待确认收货":
						("wait_assessment".equals(order_goods_state)?"待评价":"已完成")))));
		return this;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public OrderGoodsBean setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public OrderGoodsBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public OrderGoodsBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getOrder_goods_state_show() {
		return order_goods_state_show;
	}
	public String getCity() {
		return city;
	}
	public OrderGoodsBean setCity(String city) {
		this.city = city;
		return this;
	}
	public String getStorehouse_id() {
		return storehouse_id;
	}
	public OrderGoodsBean setStorehouse_id(String storehouse_id) {
		this.storehouse_id = storehouse_id;
		return this;
	}
	public String getStorehouse_name() {
		return storehouse_name;
	}
	public OrderGoodsBean setStorehouse_name(String storehouse_name) {
		this.storehouse_name = storehouse_name;
		return this;
	}
	public String getMerchants_type() {
		return merchants_type;
	}
	public OrderGoodsBean setMerchants_type(String merchants_type) {
		this.merchants_type = merchants_type;
		return this;
	}	
	
}

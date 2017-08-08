package tst.project.bean.order;

import java.util.List;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.member.MemberBean;

public class RefundBean {
	private int refund_id;
	private String refund_no;
	private String member_id;
	private String nick_name;
	private String order_id;
	private String name;
	private String mobile;
	private String order_goods_id;
	private String goods_id;
	private String goods_name;
	private String refund_count;
	private String refund_desc;
	private String refund_state;
	private String refund_state_show;
	private String create_time;
	private String merchants_id;
	private String merchants_name;
	private String refund_price;
	private String refund_deduct_integral;
	private String refund_give_integral;
	private String refund_order_no;
	private String hx_account;
	private String merchants_img;
	private String refund_reason_id;
	private String reason_name;
	private String order_no;
	private String start_time;
	private String end_time;
	private String member_coupon_id;//退还优惠卷id
	private String refuse_desc;
	private String refund_integral_value;//退还的积分
	private String order_actual_price;

	private String goods_sku;
	private String custom_remark;
	private GoodsBean goodsBean;
	private MemberBean memberBean;
	private List<OrderParameterBean> orderParameterBeans;
	private List<OrderServiceBean> orderServiceBeans;
	private OrderGoodsBean orderGoodsBean;

	public String getCustom_remark() {
		return custom_remark;
	}
	public RefundBean setCustom_remark(String custom_remark) {
		this.custom_remark = custom_remark;
		return this;
	}
	public String getGoods_sku() {
		return goods_sku;
	}
	public RefundBean setGoods_sku(String goods_sku) {
		this.goods_sku = goods_sku;
		return this;
	}
	public String getOrder_actual_price() {
		return order_actual_price;
	}
	public RefundBean setOrder_actual_price(String order_actual_price) {
		this.order_actual_price = order_actual_price;
		return this;
	}
	public String getRefund_integral_value() {
		return refund_integral_value;
	}
	public RefundBean setRefund_integral_value(String refund_integral_value) {
		this.refund_integral_value = refund_integral_value;
		return this;
	}
	public String getRefund_no() {
		return refund_no;
	}
	public RefundBean setRefund_no(String refund_no) {
		this.refund_no = refund_no;
		return this;
	}
	public OrderGoodsBean getOrderGoodsBean() {
		return orderGoodsBean;
	}
	public RefundBean setOrderGoodsBean(OrderGoodsBean orderGoodsBean) {
		this.orderGoodsBean = orderGoodsBean;
		return this;
	}
	public String getRefuse_desc() {
		return refuse_desc;
	}
	public RefundBean setRefuse_desc(String refuse_desc) {
		this.refuse_desc = refuse_desc;
		return this;
	}
	public String getMember_coupon_id() {
		return member_coupon_id;
	}
	public RefundBean setMember_coupon_id(String member_coupon_id) {
		this.member_coupon_id = member_coupon_id;
		return this;
	}
	public String getRefund_deduct_integral() {
		return refund_deduct_integral;
	}
	public RefundBean setRefund_deduct_integral(String refund_deduct_integral) {
		this.refund_deduct_integral = refund_deduct_integral;
		return this;
	}
	public String getRefund_give_integral() {
		return refund_give_integral==null||refund_give_integral.equals("")?"0":refund_give_integral;
	}
	public RefundBean setRefund_give_integral(String refund_give_integral) {
		this.refund_give_integral = refund_give_integral;
		return this;
	}
	public String getName() {
		return name;
	}
	public RefundBean setName(String name) {
		this.name = name;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public RefundBean setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public RefundBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getRefund_state() {
		return refund_state;
	}
	public RefundBean setRefund_state(String refund_state) {
		this.refund_state = refund_state;
		this.refund_state_show = "wait_review".equals(refund_state)?"待审核":
			  ("accept".equals(refund_state)?"已接受":
		      ("refuse".equals(refund_state)?"已拒绝":
		      ("end".equals(refund_state)?"已退款":"待审核")));
		return this;
	}
	
	public String getRefund_state_show() {
		return refund_state_show;
	}

	public RefundBean setRefund_state_show(String refund_state_show) {
		this.refund_state_show = "wait_review".equals(refund_state)?"待审核":
								  ("accept".equals(refund_state)?"已接受":
							      ("refuse".equals(refund_state)?"已拒绝":
							      ("end".equals(refund_state)?"已退款":"待审核")));
		return this;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public RefundBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}

	public List<OrderParameterBean> getOrderParameterBeans() {
		return orderParameterBeans;
	}

	public RefundBean setOrderParameterBeans(List<OrderParameterBean> orderParameterBeans) {
		this.orderParameterBeans = orderParameterBeans;
		return this;
	}

	public List<OrderServiceBean> getOrderServiceBeans() {
		return orderServiceBeans;
	}

	public RefundBean setOrderServiceBeans(List<OrderServiceBean> orderServiceBeans) {
		this.orderServiceBeans = orderServiceBeans;
		return this;
	}

	public String getStart_time() {
		return start_time;
	}

	public RefundBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}

	public String getEnd_time() {
		return end_time;
	}

	public RefundBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public RefundBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}

	public String getOrder_no() {
		return order_no;
	}

	public RefundBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}

	public GoodsBean getGoodsBean() {
		return goodsBean;
	}

	public RefundBean setGoodsBean(GoodsBean goodsBean) {
		this.goodsBean = goodsBean;
		return this;
	}

	public String getRefund_reason_id() {
		return refund_reason_id;
	}

	public RefundBean setRefund_reason_id(String refund_reason_id) {
		this.refund_reason_id = refund_reason_id;
		return this;
	}

	public String getReason_name() {
		return reason_name;
	}

	public RefundBean setReason_name(String reason_name) {
		this.reason_name = reason_name;
		return this;
	}
	private List<RefundImgBean> refundImgBeans;		
	
	public String getMerchants_img() {
		return merchants_img;
	}

	public RefundBean setMerchants_img(String merchants_img) {
		this.merchants_img = merchants_img;
		return this;
	}

	public String getHx_account() {
		return hx_account;
	}

	public RefundBean setHx_account(String hx_account) {
		this.hx_account = hx_account;
		return this;
	}

	public String getRefund_order_no() {
		return refund_order_no;
	}
	
	public RefundBean setRefund_order_no(String refund_order_no) {
		this.refund_order_no = refund_order_no;
		return this;
	}
	
	public List<RefundImgBean> getRefundImgBeans() {
		return refundImgBeans;
	}
	public RefundBean setRefundImgBeans(List<RefundImgBean> refundImgBeans) {
		this.refundImgBeans = refundImgBeans;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public RefundBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	
	public String getRefund_price() {
		return refund_price;
	}
	public RefundBean setRefund_price(String refund_price) {
		this.refund_price = refund_price;
		return this;
	}
	public String getNick_name() {
		return nick_name;
	}
	public RefundBean setNick_name(String nick_name) {
		this.nick_name = nick_name;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public RefundBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public int getRefund_id() {
		return refund_id;
	}
	public RefundBean setRefund_id(int refund_id) {
		this.refund_id = refund_id;
		return this;
	}
		
	public String getMember_id() {
		return member_id;
	}
	public RefundBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getOrder_id() {
		return order_id;
	}
	public RefundBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}

	
	
	
	public String getOrder_goods_id() {
		return order_goods_id;
	}

	public RefundBean setOrder_goods_id(String order_goods_id) {
		this.order_goods_id = order_goods_id;
		return this;
	}

	public String getRefund_count() {
		return refund_count;
	}
	public RefundBean setRefund_count(String refund_count) {
		this.refund_count = refund_count;
		return this;
	}
	public String getRefund_desc() {
		return refund_desc;
	}
	public RefundBean setRefund_desc(String refund_desc) {
		this.refund_desc = refund_desc;
		return this;
	}
	
	public String getCreate_time() {
		return create_time;
	}
	public RefundBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}		
}

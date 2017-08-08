package tst.project.bean.order;

import java.util.List;

import tst.project.bean.address.AddressBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;

public class OrderBean {
	private int order_id;
	private String merchants_id;
	private String supplier_id;
	private String merchants_name;
	private String merchants_account_name;
	private String member_id;
	private String nick_name;
	private String order_no;
	private String address_id;
	private String mobile;
	private String name;
	private String province;
	private String city;
	private String country;
	private String detailed_address;
	private String zip_code;
	private String order_state;
	private String order_state_show;
	private String create_time;
	private String is_delete;
	private String remark;
	private String assessment_state;
	private String order_total_price;
	private String order_actual_price;//实际支付金额
	private String order_pay_no;
	private String order_type;
	private String order_type_show;
	private String member_group_buy_id;//团购id	
	private String order_charge;
	
	private String start_time;
	private String end_time;
	private String order_states;
	private String logistics_no;
	private String logistics_pinyin;
	private String logistics_name;
	private String give_integral_value;//赠送积分 

	private String is_deduct_integral;//是否抵扣积分
	private String deduct_integral_value;//抵扣多少积分
	private String deduct_integral_price;//抵扣的钱
	private String deduct_integral_percent;//抵扣现金的百分比

	private String member_coupon_id;//用户优惠券id
	private String coupon_full_price;//优惠卷 满多少包邮
	private String coupon_price;//优惠卷 优惠金额
	
	private String is_free_express;//是否免邮
	private String express_free_price;//满多少免邮
	private String express_price;//邮费
	
	private String refund_price;//用户退款记录金额
	private String refund_deduct_integral;//用户退款 记录 返回给用户的积分
	private String refund_give_integral;//用户退款 记录 返回给平台的积分
	private String refund_coupon_id;//退款记录 优惠卷id
	private String valid_time;
	
	private String business_id;
	private String merchants_account_id;
	private String member_discount;//会员折扣
	private String member_discount_price;//会员折扣的钱

	
	private String is_allopatry;//是否异地
	
	private String distribution_price;
	private String is_profit;//是否已经分配收益
	
	private String invoice_type;//发票类型 no:不开票   paper:纸质发票（个人，单位），electron:电子发票  increment:增值税发票
	private String invoice_rise_type;//发票抬头类型    personal:个人   company:公司  
	private String invoice_company_name;//发票抬头是 单位时， 所需要的单位名称   个人时 个人姓名
	private String invoice_content;//发票内容
	private String invise_ticket_phone;//收票人手机号
	private String invise_ticket_email;//接受发票邮箱
	private String invise_taxpayer_code;//纳税人识别码
	private String invise_register_time;//注册时间
	private String invise_register_phone;//注册电话
	private String invise_register_address;
	private String invise_bank_name;//开户银行
	private String invise_bank_code;//银行账号
	
	private String pay_way;
	private String order_source_way;//订单来源方式   goods:商品   recharge:充值
	
	private String is_add_assessment;//是否可追加评价
	
	private String cross_border_tax;//税收费
	
	private String since_id;//自提ID
	private String since_name;//字体地点
	private String since_mobile;//自提人手机号
	private String since_fixed_mobile;//自提人固定手机号
	private String since_people_name;//自提点姓名
	
	private String custom_remark;//客服备注
	
	private String goods_num;
	private String goods_price;
	private String goods_sku;
	private String refund_time;
	private String card_id;
	private MemberBean memberBean;
	private AddressBean addressBean;
	private MerchantsBean merchantsBean;
	private List<OrderGoodsBean> orderGoodsBeans;
	private List<LogisticsDetailBean> logisticsDetailBeans;
	
	public String getLogistics_name() {
		return logistics_name;
	}
	public OrderBean setLogistics_name(String logistics_name) {
		this.logistics_name = logistics_name;
		return this;
	}
	
	public String getSupplier_id() {
		return supplier_id;
	}
	public OrderBean setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
		return this;
	}
	public List<LogisticsDetailBean> getLogisticsDetailBeans() {
		return logisticsDetailBeans;
	}
	public OrderBean setLogisticsDetailBeans(List<LogisticsDetailBean> logisticsDetailBeans) {
		this.logisticsDetailBeans = logisticsDetailBeans;
		return this;
	}
	public String getCard_id() {
		return card_id;
	}
	public OrderBean setCard_id(String card_id) {
		this.card_id = card_id;
		return this;
	}
	public String getGoods_num() {
		return goods_num;
	}
	public OrderBean setGoods_num(String goods_num) {
		this.goods_num = goods_num;
		return this;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public OrderBean setGoods_price(String goods_price) {
		this.goods_price = goods_price;
		return this;
	}
	public String getGoods_sku() {
		return goods_sku;
	}
	public OrderBean setGoods_sku(String goods_sku) {
		this.goods_sku = goods_sku;
		return this;
	}
	public String getRefund_time() {
		return refund_time;
	}
	public OrderBean setRefund_time(String refund_time) {
		this.refund_time = refund_time;
		return this;
	}
	public String getCustom_remark() {
		return custom_remark;
	}
	public OrderBean setCustom_remark(String custom_remark) {
		this.custom_remark = custom_remark;
		return this;
	}
	public String getSince_mobile() {
		return since_mobile;
	}
	public OrderBean setSince_mobile(String since_mobile) {
		this.since_mobile = since_mobile;
		return this;
	}
	public String getSince_fixed_mobile() {
		return since_fixed_mobile;
	}
	public OrderBean setSince_fixed_mobile(String since_fixed_mobile) {
		this.since_fixed_mobile = since_fixed_mobile;
		return this;
	}
	public String getSince_people_name() {
		return since_people_name;
	}
	public OrderBean setSince_people_name(String since_people_name) {
		this.since_people_name = since_people_name;
		return this;
	}
	public String getSince_id() {
		return since_id;
	}
	public OrderBean setSince_id(String since_id) {
		this.since_id = since_id;
		return this;
	}
	public String getSince_name() {
		return since_name;
	}
	public OrderBean setSince_name(String since_name) {
		this.since_name = since_name;
		return this;
	}
	public String getMember_discount_price() {
		return member_discount_price;
	}
	public OrderBean setMember_discount_price(String member_discount_price) {
		this.member_discount_price = member_discount_price;
		return this;
	}
	public String getCross_border_tax() {
		return cross_border_tax;
	}
	public OrderBean setCross_border_tax(String cross_border_tax) {
		this.cross_border_tax = cross_border_tax;
		return this;
	}
	public String getOrder_source_way() {
		return order_source_way;
	}
	public OrderBean setOrder_source_way(String order_source_way) {
		this.order_source_way = order_source_way;
		return this;
	}
	public String getIs_add_assessment() {
		return is_add_assessment;
	}
	public OrderBean setIs_add_assessment(String is_add_assessment) {
		this.is_add_assessment = is_add_assessment;
		return this;
	}
	public String getPay_way() {
		return pay_way;
	}
	public OrderBean setPay_way(String pay_way) {
		this.pay_way = pay_way;
		return this;
	}
	public String getInvise_register_address() {
		return invise_register_address;
	}
	public OrderBean setInvise_register_address(String invise_register_address) {
		this.invise_register_address = invise_register_address;
		return this;
	}
	public String getOrder_actual_price() {
		return order_actual_price;
	}
	public OrderBean setOrder_actual_price(String order_actual_price) {
		this.order_actual_price = order_actual_price;
		return this;
	}
	public String getInvoice_type() {
		return invoice_type;
	}
	public OrderBean setInvoice_type(String invoice_type) {
		this.invoice_type = invoice_type;
		return this;
	}
	public String getInvoice_rise_type() {
		return invoice_rise_type;
	}
	public OrderBean setInvoice_rise_type(String invoice_rise_type) {
		this.invoice_rise_type = invoice_rise_type;
		return this;
	}
	public String getInvoice_company_name() {
		return invoice_company_name;
	}
	public OrderBean setInvoice_company_name(String invoice_company_name) {
		this.invoice_company_name = invoice_company_name;
		return this;
	}
	public String getInvoice_content() {
		return invoice_content;
	}
	public OrderBean setInvoice_content(String invoice_content) {
		this.invoice_content = invoice_content;
		return this;
	}
	public String getInvise_ticket_phone() {
		return invise_ticket_phone;
	}
	public OrderBean setInvise_ticket_phone(String invise_ticket_phone) {
		this.invise_ticket_phone = invise_ticket_phone;
		return this;
	}
	public String getInvise_ticket_email() {
		return invise_ticket_email;
	}
	public OrderBean setInvise_ticket_email(String invise_ticket_email) {
		this.invise_ticket_email = invise_ticket_email;
		return this;
	}
	public String getInvise_taxpayer_code() {
		return invise_taxpayer_code;
	}
	public OrderBean setInvise_taxpayer_code(String invise_taxpayer_code) {
		this.invise_taxpayer_code = invise_taxpayer_code;
		return this;
	}
	public String getInvise_register_time() {
		return invise_register_time;
	}
	public OrderBean setInvise_register_time(String invise_register_time) {
		this.invise_register_time = invise_register_time;
		return this;
	}
	public String getInvise_register_phone() {
		return invise_register_phone;
	}
	public OrderBean setInvise_register_phone(String invise_register_phone) {
		this.invise_register_phone = invise_register_phone;
		return this;
	}
	public String getInvise_bank_name() {
		return invise_bank_name;
	}
	public OrderBean setInvise_bank_name(String invise_bank_name) {
		this.invise_bank_name = invise_bank_name;
		return this;
	}
	public String getInvise_bank_code() {
		return invise_bank_code;
	}
	public OrderBean setInvise_bank_code(String invise_bank_code) {
		this.invise_bank_code = invise_bank_code;
		return this;
	}
	public String getNick_name() {
		return nick_name;
	}
	public OrderBean setNick_name(String nick_name) {
		this.nick_name = nick_name;
		return this;
	}
	public String getDistribution_price() {
		return distribution_price;
	}
	public OrderBean setDistribution_price(String distribution_price) {
		this.distribution_price = distribution_price;
		return this;
	}
	public String getIs_profit() {
		return is_profit;
	}
	public OrderBean setIs_profit(String is_profit) {
		this.is_profit = is_profit;
		return this;
	}
	public String getIs_allopatry() {
		return is_allopatry;
	}
	public OrderBean setIs_allopatry(String is_allopatry) {
		this.is_allopatry = is_allopatry;
		return this;
	}
	public String getMerchants_account_name() {
		return merchants_account_name;
	}
	public OrderBean setMerchants_account_name(String merchants_account_name) {
		this.merchants_account_name = merchants_account_name;
		return this;
	}
	public String getLogistics_pinyin() {
		return logistics_pinyin;
	}
	public OrderBean setLogistics_pinyin(String logistics_pinyin) {
		this.logistics_pinyin = logistics_pinyin;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public OrderBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public OrderBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}
	public String getOrder_charge() {
		return order_charge;
	}
	public OrderBean setOrder_charge(String order_charge) {
		this.order_charge = order_charge;
		return this;
	}
	public String getMember_discount() {
		return member_discount;
	}
	public OrderBean setMember_discount(String member_discount) {
		this.member_discount = member_discount;
		return this;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public OrderBean setBusiness_id(String business_id) {
		this.business_id = business_id;
		return this;
	}
	public String getMerchants_account_id() {
		return merchants_account_id;
	}
	public OrderBean setMerchants_account_id(String merchants_account_id) {
		this.merchants_account_id = merchants_account_id;
		return this;
	}
	public String getValid_time() {
		return valid_time;
	}
	public OrderBean setValid_time(String valid_time) {
		this.valid_time = valid_time;
		return this;
	}
	public String getRefund_coupon_id() {
		return refund_coupon_id;
	}
	public OrderBean setRefund_coupon_id(String refund_coupon_id) {
		this.refund_coupon_id = refund_coupon_id;
		return this;
	}
	public String getRefund_price() {
		return refund_price;
	}
	public OrderBean setRefund_price(String refund_price) {
		this.refund_price = refund_price;
		return this;
	}
	public String getRefund_deduct_integral() {
		return refund_deduct_integral;
	}
	public OrderBean setRefund_deduct_integral(String refund_deduct_integral) {
		this.refund_deduct_integral = refund_deduct_integral;
		return this;
	}
	public String getRefund_give_integral() {
		return refund_give_integral;
	}
	public OrderBean setRefund_give_integral(String refund_give_integral) {
		this.refund_give_integral = refund_give_integral;
		return this;
	}
	public String getGive_integral_value() {
		return give_integral_value;
	}
	public OrderBean setGive_integral_value(String give_integral_value) {
		this.give_integral_value = give_integral_value;
		return this;
	}
	
	public String getCoupon_full_price() {
		return coupon_full_price;
	}
	public OrderBean setCoupon_full_price(String coupon_full_price) {
		this.coupon_full_price = coupon_full_price;
		return this;
	}
	public String getCoupon_price() {
		return coupon_price;
	}
	public OrderBean setCoupon_price(String coupon_price) {
		this.coupon_price = coupon_price;
		return this;
	}
	public String getDeduct_integral_price() {
		return deduct_integral_price;
	}
	public OrderBean setDeduct_integral_price(String deduct_integral_price) {
		this.deduct_integral_price = deduct_integral_price;
		return this;
	}
	public String getIs_deduct_integral() {
		return is_deduct_integral;
	}
	public OrderBean setIs_deduct_integral(String is_deduct_integral) {
		this.is_deduct_integral = is_deduct_integral;
		return this;
	}
	public String getDeduct_integral_value() {
		return deduct_integral_value;
	}
	public OrderBean setDeduct_integral_value(String deduct_integral_value) {
		this.deduct_integral_value = deduct_integral_value;
		return this;
	}
	public String getDeduct_integral_percent() {
		return deduct_integral_percent;
	}
	public OrderBean setDeduct_integral_percent(String deduct_integral_percent) {
		this.deduct_integral_percent = deduct_integral_percent;
		return this;
	}
	public String getMember_coupon_id() {
		return member_coupon_id;
	}
	public OrderBean setMember_coupon_id(String member_coupon_id) {
		this.member_coupon_id = member_coupon_id;
		return this;
	}
	public String getIs_free_express() {
		return is_free_express;
	}
	public OrderBean setIs_free_express(String is_free_express) {
		this.is_free_express = is_free_express;
		return this;
	}
	
	public String getExpress_price() {
		return express_price;
	}
	public OrderBean setExpress_price(String express_price) {
		this.express_price = express_price;
		return this;
	}
	public String getOrder_state() {
		return order_state;
	}
	public OrderBean setOrder_state(String order_state) {
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
	public OrderBean setOrder_state_show(String order_state_show) {
		return this;
	}
	public String getLogistics_no() {
		return logistics_no;
	}
	public OrderBean setLogistics_no(String logistics_no) {
		this.logistics_no = logistics_no;
		return this;
	}
	public String getOrder_states() {
		return order_states;
	}
	public OrderBean setOrder_states(String order_states) {
		this.order_states = order_states;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public OrderBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public OrderBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getMember_group_buy_id() {
		return member_group_buy_id;
	}
	public OrderBean setMember_group_buy_id(String member_group_buy_id) {
		this.member_group_buy_id = member_group_buy_id;
		return this;
	}
	public MerchantsBean getMerchantsBean() {
		return merchantsBean;
	}
	public OrderBean setMerchantsBean(MerchantsBean merchantsBean) {
		this.merchantsBean = merchantsBean;
		return this;
	}
	public List<OrderGoodsBean> getOrderGoodsBeans() {
		return orderGoodsBeans;
	}
	public OrderBean setOrderGoodsBeans(List<OrderGoodsBean> orderGoodsBeans) {
		this.orderGoodsBeans = orderGoodsBeans;
		return this;
	}
	
	
	public AddressBean getAddressBean() {
		return addressBean;
	}
	public OrderBean setAddressBean(AddressBean addressBean) {
		this.addressBean = addressBean;
		return this;
	}
	public int getOrder_id() {
		return order_id;
	}
	public OrderBean setOrder_id(int order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id==null?"0":merchants_id;
	}
	public OrderBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public OrderBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getOrder_no() {
		return order_no;
	}
	public OrderBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}
	public String getAddress_id() {
		return address_id;
	}
	public OrderBean setAddress_id(String address_id) {
		this.address_id = address_id;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public OrderBean setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public String getName() {
		return name;
	}
	public OrderBean setName(String name) {
		this.name = name;
		return this;
	}
	public String getProvince() {
		return province;
	}
	public OrderBean setProvince(String province) {
		this.province = province;
		return this;
	}
	public String getCity() {
		return city;
	}
	public OrderBean setCity(String city) {
		this.city = city;
		return this;
	}
	public String getCountry() {
		return country;
	}
	public OrderBean setCountry(String country) {
		this.country = country;
		return this;
	}
	public String getDetailed_address() {
		return detailed_address;
	}
	public OrderBean setDetailed_address(String detailed_address) {
		this.detailed_address = detailed_address;
		return this;
	}
	public String getZip_code() {
		return zip_code;
	}
	public OrderBean setZip_code(String zip_code) {
		this.zip_code = zip_code;
		return this;
	}
	
	public String getCreate_time() {
		return create_time;
	}
	public OrderBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public OrderBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getRemark() {
		return remark;
	}
	public OrderBean setRemark(String remark) {
		this.remark = remark;
		return this;
	}
	public String getAssessment_state() {
		return assessment_state;
	}
	public OrderBean setAssessment_state(String assessment_state) {
		this.assessment_state = assessment_state;
		return this;
	}
	public String getOrder_total_price() {
		return order_total_price;
	}
	public OrderBean setOrder_total_price(String order_total_price) {
		this.order_total_price = order_total_price;
		return this;
	}
	
	public String getOrder_pay_no() {
		return order_pay_no;
	}
	public OrderBean setOrder_pay_no(String order_pay_no) {
		this.order_pay_no = order_pay_no;
		return this;
	}
	
	public String getExpress_free_price() {
		return express_free_price;
	}
	public OrderBean setExpress_free_price(String express_free_price) {
		this.express_free_price = express_free_price;
		return this;
	}
	
	public String getOrder_type() {
		return order_type;
	}
	public OrderBean setOrder_type(String order_type) {
		this.order_type = order_type;
		this.order_type_show ="goods".equals(order_type)?"普通商品":
								("time_limit".equals(order_type)?"促销商品":
								("group_buy".equals(order_type)?"团购商品":
								("zssg".equals(order_type)?"svip升级":"普通商品")));
		return this;
	}
	public String getOrder_type_show() {
		return order_type_show;
	}
	public OrderBean setOrder_type_show(String order_type_show) {
		this.order_type_show = order_type_show;
		return this;
	}
}

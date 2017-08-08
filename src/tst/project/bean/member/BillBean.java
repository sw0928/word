package tst.project.bean.member;

public class BillBean {
	private String bill_type;
	private String bill_type_show;
	private String bill_price;
	private String bill_remark;
	private String bill_time;
	private String member_id;
	
	public String getMember_id() {
		return member_id;
	}
	public BillBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getBill_time() {
		return bill_time;
	}
	public BillBean setBill_time(String bill_time) {
		this.bill_time = bill_time;
		return this;
	}
	public String getBill_type() {
		return bill_type;
	}
	public BillBean setBill_type(String bill_type) {
		this.bill_type = bill_type;
		this.bill_type_show="order_pay".equals(bill_type)?"余额订单支付":
							("balance_recharge".equals(bill_type)?"余额充值":
							("balance_apply".equals(bill_type)?"余额提现":
							("order_trust_pay".equals(bill_type)?"信用额度订单支付":
							("stored_order_pay".equals(bill_type)?"储值卡订单支付":
							("stored_recharge".equals(bill_type)?"储值卡充值":"未知")))));
		return this;
	}
	public String getBill_type_show() {
		return bill_type_show;
	}
	public BillBean setBill_type_show(String bill_type_show) {
		this.bill_type_show = bill_type_show;
		return this;
	}
	public String getBill_price() {
		return bill_price;
	}
	public BillBean setBill_price(String bill_price) {
		this.bill_price = bill_price;
		return this;
	}
	public String getBill_remark() {
		return bill_remark;
	}
	public BillBean setBill_remark(String bill_remark) {
		this.bill_remark = bill_remark;
		return this;
	}
	
}

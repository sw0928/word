package tst.project.bean.finance;

import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;

public class CashApplyBean {
	private int cash_id;//
	private String merchants_id;//供应商id
	private String merchants_name;//供应商名称
	private String cash_time;//提现时间
	private String cash_price;//提现金额
	private String brank_name;//银行名称
	private String brank_code;//银行卡号
	private String brank_open_name;//开户行
	private String brank_open_usr;//开户人
	private String brank_open_mobile;//开户手机
	private String apply_state;//申请状态  wait_review：等待审核  accept:通过  refuse：不通过  end:打款成功
	private String apply_state_show;
	private String create_time;//申请时间
	
	private String start_time;//搜索开始时间
	private String end_time;//搜索的结束时间
	private String cash_type;
	private int merchants_account_id;

	private MerchantsBean merchantsBean;
	private MerchantsAccountBean merchantsAccountBean;
	private MemberBean memberBean;
	

	public MemberBean getMemberBean() {
		return memberBean;
	}
	public CashApplyBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}
	public MerchantsBean getMerchantsBean() {
		return merchantsBean;
	}
	public CashApplyBean setMerchantsBean(MerchantsBean merchantsBean) {
		this.merchantsBean = merchantsBean;
		return this;
	}
	public MerchantsAccountBean getMerchantsAccountBean() {
		return merchantsAccountBean;
	}
	public CashApplyBean setMerchantsAccountBean(MerchantsAccountBean merchantsAccountBean) {
		this.merchantsAccountBean = merchantsAccountBean;
		return this;
	}
	public int getMerchants_account_id() {
		return merchants_account_id;
	}
	public CashApplyBean setMerchants_account_id(int merchants_account_id) {
		this.merchants_account_id = merchants_account_id;
		return this;
	}
	public String getCash_type() {
		return cash_type;
	}
	public CashApplyBean setCash_type(String cash_type) {
		this.cash_type = cash_type;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public CashApplyBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public CashApplyBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public CashApplyBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	public String getApply_state_show() {
		return apply_state_show;
	}
	public CashApplyBean setApply_state_show(String apply_state_show) {
		this.apply_state_show = apply_state_show;
		return this;
	}
	public int getCash_id() {
		return cash_id;
	}
	public CashApplyBean setCash_id(int cash_id) {
		this.cash_id = cash_id;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public CashApplyBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getCash_time() {
		return cash_time;
	}
	public CashApplyBean setCash_time(String cash_time) {
		this.cash_time = cash_time;
		return this;
	}
	public String getCash_price() {
		return cash_price;
	}
	public CashApplyBean setCash_price(String cash_price) {
		this.cash_price = cash_price;
		return this;
	}
	public String getBrank_name() {
		return brank_name;
	}
	public CashApplyBean setBrank_name(String brank_name) {
		this.brank_name = brank_name;
		return this;
	}
	public String getBrank_code() {
		return brank_code;
	}
	public CashApplyBean setBrank_code(String brank_code) {
		this.brank_code = brank_code;
		return this;
	}
	public String getBrank_open_name() {
		return brank_open_name;
	}
	public CashApplyBean setBrank_open_name(String brank_open_name) {
		this.brank_open_name = brank_open_name;
		return this;
	}
	public String getBrank_open_usr() {
		return brank_open_usr;
	}
	public CashApplyBean setBrank_open_usr(String brank_open_usr) {
		this.brank_open_usr = brank_open_usr;
		return this;
	}
	public String getBrank_open_mobile() {
		return brank_open_mobile;
	}
	public CashApplyBean setBrank_open_mobile(String brank_open_mobile) {
		this.brank_open_mobile = brank_open_mobile;
		return this;
	}
	public String getApply_state() {
		return apply_state;
	}
	public CashApplyBean setApply_state(String apply_state) {
		//wait_review：等待审核  accept:通过  refuse：不通过  end:打款成功
		this.apply_state = apply_state;
		this.apply_state_show="wait_review".equals(apply_state)?"等待审核":
										("accept".equals(apply_state)?"已通过":
										("refuse".equals(apply_state)?"已拒绝":"打款成功"));
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public CashApplyBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	
	
}

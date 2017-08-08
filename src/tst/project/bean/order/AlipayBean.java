package tst.project.bean.order;

public class AlipayBean {
	private String service;//接口名称
	private String partner;// pid
	private String input_charset;
	private String sign_type;// 签名方式
	private String out_trade_no;// 本地系统订单号()
	private String subject;
	private String payment_type;
	private String seller_id;//支付宝账号
	private String total_fee;// 支付金额
	private String forex_biz;
	private String currency;// 币种
	private String body;
	private String notify_url;// 异步通知,可以理解为后台处理逻辑程序
	private String return_url;
	private String sign;
	public String getService() {
		return service;
	}
	public AlipayBean setService(String service) {
		this.service = service;
		return this;
	}
	public String getPartner() {
		return partner;
	}
	public AlipayBean setPartner(String partner) {
		this.partner = partner;
		return this;
	}
	public String getInput_charset() {
		return input_charset;
	}
	public AlipayBean setInput_charset(String input_charset) {
		this.input_charset = input_charset;
		return this;
	}
	public String getSign_type() {
		return sign_type;
	}
	public AlipayBean setSign_type(String sign_type) {
		this.sign_type = sign_type;
		return this;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public AlipayBean setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public AlipayBean setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	
	
	public String getPayment_type() {
		return payment_type;
	}
	public AlipayBean setPayment_type(String payment_type) {
		this.payment_type = payment_type;
		return this;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public AlipayBean setSeller_id(String seller_id) {
		this.seller_id = seller_id;
		return this;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public AlipayBean setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
		return this;
	}
	public String getForex_biz() {
		return forex_biz;
	}
	public AlipayBean setForex_biz(String forex_biz) {
		this.forex_biz = forex_biz;
		return this;
	}
	public String getCurrency() {
		return currency;
	}
	public AlipayBean setCurrency(String currency) {
		this.currency = currency;
		return this;
	}
	public String getBody() {
		return body;
	}
	public AlipayBean setBody(String body) {
		this.body = body;
		return this;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public AlipayBean setNotify_url(String notify_url) {
		this.notify_url = notify_url;
		return this;
	}
	public String getReturn_url() {
		return return_url;
	}
	public AlipayBean setReturn_url(String return_url) {
		this.return_url = return_url;
		return this;
	}
	public String getSign() {
		return sign;
	}
	public AlipayBean setSign(String sign) {
		this.sign = sign;
		return this;
	}
	
}

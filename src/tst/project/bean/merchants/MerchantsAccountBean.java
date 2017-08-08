package tst.project.bean.merchants;

public class MerchantsAccountBean {
	private int merchants_relation_account_id;
	private int merchants_account_id;
	private String merchants_account_id1;
	private String merchants_id;
	private String merchants_account;
	private String password;
	private String new_password;
	private String role_id;
	private String merchants_token;
	private String hx_account;
	private String hx_pass;
	private String hx_nick_name;
	private String create_time;
	private String is_delete;
	private String is_default;
	private String is_relation_defalut;
	private String merchants_type;
	private String merchants_name;
	private String merchants_img;

	private String is_extension;//是否推广员
	private String is_extension_show;
	private String qrcode_img;
	private String merchants_qrcode_img;
		
	private double balance;
	private double merchants_balance;
	
	private String search_start_time;
	private String search_end_time;
	private String city;
	
	public String getSearch_start_time() {
		return search_start_time;
	}
	public MerchantsAccountBean setSearch_start_time(String search_start_time) {
		this.search_start_time = search_start_time;
		return this;
	}
	public String getSearch_end_time() {
		return search_end_time;
	}
	public MerchantsAccountBean setSearch_end_time(String search_end_time) {
		this.search_end_time = search_end_time;
		return this;
	}
	public String getCity() {
		return city;
	}
	public MerchantsAccountBean setCity(String city) {
		this.city = city;
		return this;
	}
	public double getMerchants_balance() {
		return merchants_balance;
	}
	public MerchantsAccountBean setMerchants_balance(double merchants_balance) {
		this.merchants_balance = merchants_balance;
		return this;
	}
	private int follower_count;//粉丝数
	
	public double getBalance() {
		return balance;
	}
	public MerchantsAccountBean setBalance(double balance) {
		this.balance = balance;
		return this;
	}
	public int getFollower_count() {
		return follower_count;
	}
	public MerchantsAccountBean setFollower_count(int follower_count) {
		this.follower_count = follower_count;
		return this;
	}
	public String getMerchants_qrcode_img() {
		return merchants_qrcode_img;
	}
	public MerchantsAccountBean setMerchants_qrcode_img(String merchants_qrcode_img) {
		this.merchants_qrcode_img = merchants_qrcode_img;
		return this;
	}
	
	public String getIs_extension_show() {
		return is_extension_show;
	}
	public MerchantsAccountBean setIs_extension_show(String is_extension_show) {
		this.is_extension_show = is_extension_show;
		return this;
	}
	public String getIs_extension() {
		return is_extension;
	}
	public MerchantsAccountBean setIs_extension(String is_extension) {
		this.is_extension = is_extension;
		this.is_extension_show="1".equals(is_extension)?"是":"否";
		return this;
	}
	public String getQrcode_img() {
		return qrcode_img;
	}
	public MerchantsAccountBean setQrcode_img(String qrcode_img) {
		this.qrcode_img = qrcode_img;
		return this;
	}
	public String getIs_relation_defalut() {
		return is_relation_defalut;
	}
	public MerchantsAccountBean setIs_relation_defalut(String is_relation_defalut) {
		this.is_relation_defalut = is_relation_defalut;
		return this;
	}
	public String getIs_default() {
		return is_default;
	}
	public MerchantsAccountBean setIs_default(String is_default) {
		this.is_default = is_default;
		return this;
	}
	public int getMerchants_relation_account_id() {
		return merchants_relation_account_id;
	}
	public MerchantsAccountBean setMerchants_relation_account_id(int merchants_relation_account_id) {
		this.merchants_relation_account_id = merchants_relation_account_id;
		return this;
	}
	public String getNew_password() {
		return new_password;
	}
	public MerchantsAccountBean setNew_password(String new_password) {
		this.new_password = new_password;
		return this;
	}
	public String getMerchants_img() {
		return merchants_img;
	}
	public MerchantsAccountBean setMerchants_img(String merchants_img) {
		this.merchants_img = merchants_img;
		return this;
	}
	public String getMerchants_type() {
		return merchants_type;
	}
	public MerchantsAccountBean setMerchants_type(String merchants_type) {
		this.merchants_type = merchants_type;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public MerchantsAccountBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	public int getMerchants_account_id() {
		return merchants_account_id;
	}
	public MerchantsAccountBean setMerchants_account_id(int merchants_account_id) {
		this.merchants_account_id = merchants_account_id;
		return this;
	}
	
	public String getMerchants_account_id1() {
		return merchants_account_id1;
	}
	public MerchantsAccountBean setMerchants_account_id1(String merchants_account_id1) {
		this.merchants_account_id1 = merchants_account_id1;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public MerchantsAccountBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getMerchants_account() {
		return merchants_account;
	}
	public MerchantsAccountBean setMerchants_account(String merchants_account) {
		this.merchants_account = merchants_account;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public MerchantsAccountBean setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getRole_id() {
		return role_id;
	}
	public MerchantsAccountBean setRole_id(String role_id) {
		this.role_id = role_id;
		return this;
	}
	public String getMerchants_token() {
		return merchants_token;
	}
	public MerchantsAccountBean setMerchants_token(String merchants_token) {
		this.merchants_token = merchants_token;
		return this;
	}
	public String getHx_account() {
		return hx_account;
	}
	public MerchantsAccountBean setHx_account(String hx_account) {
		this.hx_account = hx_account;
		return this;
	}
	public String getHx_pass() {
		return hx_pass;
	}
	public MerchantsAccountBean setHx_pass(String hx_pass) {
		this.hx_pass = hx_pass;
		return this;
	}
	public String getHx_nick_name() {
		return hx_nick_name;
	}
	public MerchantsAccountBean setHx_nick_name(String hx_nick_name) {
		this.hx_nick_name = hx_nick_name;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MerchantsAccountBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MerchantsAccountBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	
}

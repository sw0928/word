package tst.project.bean.member;

import tst.project.utils.TimeUtils;

public class MemberBean {	
	private int member_id;
	private int user_id;
	private String wx_pub_openid;
	private String member_account;
	private String member_token;
	private String nick_name;
	private String real_name;
	private String user_name;
	private double user_money;
	private String headimg;
	private String mobile_phone;
	private String password;
	private String head_path;
	private String age;
	private String sex;
	private String phone;
	private String balance;
	private String hostUrl;
	private String job_unit;
	private String position;
	private String hobby;
	private String member_role;
	private String integral;
	private String invitation_code;
	private String fill_invitation_code;
	private String fill_member_account;
	private String hx_account;
	private String hx_pass;
	private String hx_nick_name;	
	private String total_count;
	private String wait_pay_count;
	private String wait_send_count;
	private String wait_receive_count;
	private String wait_assessment_count;
	private String backgroup_img;//个人中心 背景图
	private String member_channel;//用户注册聚到  mobile:手机注册  wx:微信注册 wx_pub:微信公众号注册  qq:qq注册
	private String create_time;
	private String start_time;
	private String end_time;
	private String business_id;//店铺id 家纺专用
	private String merchants_account_id;//推广员id 家纺专用
	private String is_remind_group;//是否提醒团购
	private String is_remind_pre;//是否提醒预购

	
	private String is_vip;
	private String vip_level;//vip等级   vip_common:普卡   vip_silver 银卡  vip_golden  金卡   vip_platinum:白金卡  vip_extreme:至尊卡
	private String user_rank;
	private String vip_start_time;
	private long cviptime;//vip开始时间
	private String vip_end_time;
	private long indate;//vip截止时间
	
	private int month_integral;//当月获得积分
	private String month_time;//获得积分的月份

	private String member_level;
	

	private String country;//国
	private String province;//省
	private String city;//区
	private String district;//县	
	private String qrcode_img;
	
	private String card_id;//身份证号
	
	private String recommend_id;//推荐人ID
	private String recommend_name;//推荐人姓名
	private String recommend_phone;//推荐人手机号
	
	private String balance_password;//余额支付密码
	private String trust_password;//信用支付密码
	private String trust_balance;//信用额度
	
	private String member_code;//会员卡号
	private String stored_code;//储值卡号
	private String merchants_no;//
	
	public String getFill_member_account() {
		return fill_member_account;
	}
	public MemberBean setFill_member_account(String fill_member_account) {
		this.fill_member_account = fill_member_account;
		return this;
	}
	public String getMember_level() {
		return member_level;
	}
	public MemberBean setMember_level(String member_level) {
		this.member_level = member_level;
		return this;
	}
	public String getMerchants_no() {
		return merchants_no;
	}
	public MemberBean setMerchants_no(String merchants_no) {
		this.merchants_no = merchants_no;
		return this;
	}
	public String getVip_level() {
		return vip_level;
	}
	public MemberBean setVip_level(String vip_level) {
		this.vip_level = vip_level;
		return this;
	}
	public String getReal_name() {
		return real_name;
	}
	public MemberBean setReal_name(String real_name) {
		this.real_name = real_name;
		return this;
	}
	public String getMember_code() {
		return member_code;
	}
	public MemberBean setMember_code(String member_code) {
		this.member_code = member_code;
		return this;
	}
	public String getStored_code() {
		return stored_code;
	}
	public MemberBean setStored_code(String stored_code) {
		this.stored_code = stored_code;
		return this;
	}
	public String getTrust_balance() {
		return trust_balance;
	}
	public MemberBean setTrust_balance(String trust_balance) {
		this.trust_balance = trust_balance;
		return this;
	}
	public String getBalance_password() {
		return balance_password;
	}
	public MemberBean setBalance_password(String balance_password) {
		this.balance_password = balance_password;
		return this;
	}
	public String getTrust_password() {
		return trust_password;
	}
	public MemberBean setTrust_password(String trust_password) {
		this.trust_password = trust_password;
		return this;
	}
	public String getRecommend_id() {
		return recommend_id;
	}
	public MemberBean setRecommend_id(String recommend_id) {
		this.recommend_id = recommend_id;
		return this;
	}
	public String getRecommend_name() {
		return recommend_name;
	}
	public MemberBean setRecommend_name(String recommend_name) {
		this.recommend_name = recommend_name;
		return this;
	}
	public String getRecommend_phone() {
		return recommend_phone;
	}
	public MemberBean setRecommend_phone(String recommend_phone) {
		this.recommend_phone = recommend_phone;
		return this;
	}
	public String getCard_id() {
		return card_id;
	}
	public MemberBean setCard_id(String card_id) {
		this.card_id = card_id;
		return this;
	}
	public String getQrcode_img() {
		return qrcode_img;
	}
	public MemberBean setQrcode_img(String qrcode_img) {
		this.qrcode_img = qrcode_img;
		return this;
	}
	public String getCountry() {
		return country;
	}
	public MemberBean setCountry(String country) {
		this.country = country;
		return this;
	}
	public String getProvince() {
		return province;
	}
	public MemberBean setProvince(String province) {
		this.province = province;
		return this;
	}
	public String getCity() {
		return city;
	}
	public MemberBean setCity(String city) {
		this.city = city;
		return this;
	}
	public String getDistrict() {
		return district;
	}
	public MemberBean setDistrict(String district) {
		this.district = district;
		return this;
	}
	public String getMerchants_account_id() {
		return merchants_account_id;
	}
	public MemberBean setMerchants_account_id(String merchants_account_id) {
		this.merchants_account_id = merchants_account_id;
		return this;
	}
	public String getUser_rank() {
		return user_rank;
	}
	public MemberBean setUser_rank(String user_rank) {
		this.user_rank = user_rank;
		return this;
	}
	public int getUser_id() {
		return user_id;
	}
	public MemberBean setUser_id(int user_id) {
		this.user_id = user_id;
		this.member_id=user_id;
		return this;
	}
	public String getHeadimg() {
		return headimg;
	}
	public MemberBean setHeadimg(String headimg) {
		this.headimg = headimg;
		this.head_path=headimg;
		return this;
	}
	public String getUser_name() {
		return user_name;
	}
	public MemberBean setUser_name(String user_name) {
		this.user_name = user_name;
		this.nick_name=user_name;
		return this;
	}
	public double getUser_money() {
		return user_money;
	}
	public MemberBean setUser_money(double user_money) {
		this.user_money = user_money;
		this.balance=user_money+"";
		return this;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public MemberBean setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
		this.member_account=mobile_phone;
		return this;
	}
	public long getCviptime() {
		return cviptime;
	}
	public MemberBean setCviptime(long cviptime) {
		this.cviptime = cviptime;
		this.vip_start_time=cviptime==0?"":TimeUtils.getTimeFromMis(cviptime*1000, "yyyy-MM-dd HH:mm:ss");
		return this;
	}
	public long getIndate() {
		return indate;
	}
	public MemberBean setIndate(long indate) {
		this.indate = indate;
		this.vip_end_time=cviptime==0?"":TimeUtils.getTimeFromMis(indate*1000, "yyyy-MM-dd HH:mm:ss");
		return this;
	}
	
	
	public int getMonth_integral() {
		return month_integral;
	}
	public MemberBean setMonth_integral(int month_integral) {
		this.month_integral = month_integral;
		return this;
	}
	public String getMonth_time() {
		return month_time;
	}
	public MemberBean setMonth_time(String month_time) {
		this.month_time = month_time;
		return this;
	}
	public String getIs_vip() {
		return is_vip;
	}
	public MemberBean setIs_vip(String is_vip) {
		this.is_vip = is_vip;
		return this;
	}
	public String getVip_start_time() {
		return vip_start_time;
	}
	public MemberBean setVip_start_time(String vip_start_time) {
		this.vip_start_time = vip_start_time;
		return this;
	}
	
	public String getVip_end_time() {
		return vip_end_time;
	}
	public MemberBean setVip_end_time(String vip_end_time) {
		this.vip_end_time = vip_end_time;
		return this;
	}
	public String getIs_remind_group() {
		return is_remind_group;
	}
	public MemberBean setIs_remind_group(String is_remind_group) {
		this.is_remind_group = is_remind_group;
		return this;
	}
	public String getIs_remind_pre() {
		return is_remind_pre;
	}
	public MemberBean setIs_remind_pre(String is_remind_pre) {
		this.is_remind_pre = is_remind_pre;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public MemberBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public MemberBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public MemberBean setBusiness_id(String business_id) {
		this.business_id = business_id;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getMember_channel() {
		return member_channel;
	}
	public MemberBean setMember_channel(String member_channel) {
		this.member_channel = member_channel;
		return this;
	}
	public String getBackgroup_img() {
		return backgroup_img;
	}
	public MemberBean setBackgroup_img(String backgroup_img) {
		this.backgroup_img = backgroup_img;
		return this;
	}
	public String getWx_pub_openid() {
		return wx_pub_openid;
	}
	public MemberBean setWx_pub_openid(String wx_pub_openid) {
		this.wx_pub_openid = wx_pub_openid;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public MemberBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getMember_account() {
		return member_account;
	}
	public MemberBean setMember_account(String member_account) {
		this.member_account = member_account;
		return this;
	}
	public String getMember_token() {
		return member_token;
	}
	public MemberBean setMember_token(String member_token) {
		this.member_token = member_token;
		return this;
	}
	public String getNick_name() {
		return nick_name;
	}
	public MemberBean setNick_name(String nick_name) {
		this.nick_name = nick_name;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public MemberBean setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getHead_path() {
		return head_path;
	}
	public MemberBean setHead_path(String head_path) {
		this.head_path = head_path;
		return this;
	}
	public String getAge() {
		return age;
	}
	public MemberBean setAge(String age) {
		this.age = age;
		return this;
	}
	public String getSex() {
		return sex;
	}
	public MemberBean setSex(String sex) {
		this.sex = sex;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public MemberBean setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getBalance() {
		return balance;
	}
	public MemberBean setBalance(String balance) {
		this.balance = balance;
		return this;
	}
	public String getHostUrl() {
		return hostUrl;
	}
	public MemberBean setHostUrl(String hostUrl) {
		this.hostUrl = hostUrl;
		return this;
	}
	public String getJob_unit() {
		return job_unit;
	}
	public MemberBean setJob_unit(String job_unit) {
		this.job_unit = job_unit;
		return this;
	}
	public String getPosition() {
		return position;
	}
	public MemberBean setPosition(String position) {
		this.position = position;
		return this;
	}
	public String getHobby() {
		return hobby;
	}
	public MemberBean setHobby(String hobby) {
		this.hobby = hobby;
		return this;
	}
	
	public String getMember_role() {
		return member_role;
	}
	public MemberBean setMember_role(String member_role) {
		this.member_role = member_role;
		return this;
	}
	public String getIntegral() {
		return integral==null||integral.equals("")?"0":integral;
	}
	public MemberBean setIntegral(String integral) {
		this.integral = integral;
		return this;
	}
	public String getInvitation_code() {
		return invitation_code;
	}
	public MemberBean setInvitation_code(String invitation_code) {
		this.invitation_code = invitation_code;
		return this;
	}
	public String getFill_invitation_code() {
		return fill_invitation_code;
	}
	public MemberBean setFill_invitation_code(String fill_invitation_code) {
		this.fill_invitation_code = fill_invitation_code;
		return this;
	}
	public String getHx_account() {
		return hx_account;
	}
	public MemberBean setHx_account(String hx_account) {
		this.hx_account = hx_account;
		return this;
	}
	public String getHx_pass() {
		return hx_pass;
	}
	public MemberBean setHx_pass(String hx_pass) {
		this.hx_pass = hx_pass;
		return this;
	}
	public String getHx_nick_name() {
		return hx_nick_name;
	}
	public MemberBean setHx_nick_name(String hx_nick_name) {
		this.hx_nick_name = hx_nick_name;
		return this;
	}
	public String getTotal_count() {
		return total_count;
	}
	public MemberBean setTotal_count(String total_count) {
		this.total_count = total_count;
		return this;
	}
	public String getWait_pay_count() {
		return wait_pay_count;
	}
	public MemberBean setWait_pay_count(String wait_pay_count) {
		this.wait_pay_count = wait_pay_count;
		return this;
	}
	public String getWait_send_count() {
		return wait_send_count;
	}
	public MemberBean setWait_send_count(String wait_send_count) {
		this.wait_send_count = wait_send_count;
		return this;
	}
	public String getWait_receive_count() {
		return wait_receive_count;
	}
	public MemberBean setWait_receive_count(String wait_receive_count) {
		this.wait_receive_count = wait_receive_count;
		return this;
	}
	public String getWait_assessment_count() {
		return wait_assessment_count;
	}
	public MemberBean setWait_assessment_count(String wait_assessment_count) {
		this.wait_assessment_count = wait_assessment_count;
		return this;
	}
	
}

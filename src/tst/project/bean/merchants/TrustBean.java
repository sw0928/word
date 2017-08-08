package tst.project.bean.merchants;

import java.util.List;

public class TrustBean {
	private int trust_id;
	private String member_id;
	private String apply_name;
	private String apply_sex;
	private String apply_position;
	private String apply_fixed_mobile;
	private String apply_mobile;
	private String apply_email;
	private String create_time;	
	private String apply_price;//已经申请到的金额
	private String apply_company;//申请人单位
	private List<TrustItemBean> trustItemBeans;
	

	public String getApply_price() {
		return apply_price;
	}
	public TrustBean setApply_price(String apply_price) {
		this.apply_price = apply_price;
		return this;
	}
	
	public String getApply_company() {
		return apply_company;
	}
	public TrustBean setApply_company(String apply_company) {
		this.apply_company = apply_company;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public TrustBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public List<TrustItemBean> getTrustItemBeans() {
		return trustItemBeans;
	}
	public TrustBean setTrustItemBeans(List<TrustItemBean> trustItemBeans) {
		this.trustItemBeans = trustItemBeans;
		return this;
	}
	public int getTrust_id() {
		return trust_id;
	}
	public TrustBean setTrust_id(int trust_id) {
		this.trust_id = trust_id;
		return this;
	}
	public String getApply_name() {
		return apply_name;
	}
	public TrustBean setApply_name(String apply_name) {
		this.apply_name = apply_name;
		return this;
	}
	public String getApply_sex() {
		return apply_sex;
	}
	public TrustBean setApply_sex(String apply_sex) {
		this.apply_sex = apply_sex;
		return this;
	}
	public String getApply_position() {
		return apply_position;
	}
	public TrustBean setApply_position(String apply_position) {
		this.apply_position = apply_position;
		return this;
	}
	public String getApply_fixed_mobile() {
		return apply_fixed_mobile;
	}
	public TrustBean setApply_fixed_mobile(String apply_fixed_mobile) {
		this.apply_fixed_mobile = apply_fixed_mobile;
		return this;
	}
	public String getApply_mobile() {
		return apply_mobile;
	}
	public TrustBean setApply_mobile(String apply_mobile) {
		this.apply_mobile = apply_mobile;
		return this;
	}
	public String getApply_email() {
		return apply_email;
	}
	public TrustBean setApply_email(String apply_email) {
		this.apply_email = apply_email;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public TrustBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
		
}

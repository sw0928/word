package tst.project.bean.system;

import java.util.List;


public class MoudleBean {
	private int moudle_id;
	private String parent_id;
	private String moudle_name;
	private String moudle_type;
	private String moudle_url;
	private String sort;
	private String merchants_id;
	private String is_delete;
	private List<MoudleBean> menuBeans;
	private String moudle_remark;
	private String moudle_uuid;
	private String moudle_parent_uuid;
	private String role_id;
	private String is_authority;
	private String is_end;
	
	
	public String getIs_end() {
		return is_end;
	}
	public MoudleBean setIs_end(String is_end) {
		this.is_end = is_end;
		return this;
	}
	public String getRole_id() {
		return role_id;
	}
	public MoudleBean setRole_id(String role_id) {
		this.role_id = role_id;
		return this;
	}
	public String getIs_authority() {
		return is_authority;
	}
	public MoudleBean setIs_authority(String is_authority) {
		this.is_authority = is_authority;
		return this;
	}
	public String getMoudle_uuid() {
		return moudle_uuid;
	}
	public MoudleBean setMoudle_uuid(String moudle_uuid) {
		this.moudle_uuid = moudle_uuid;
		return this;
	}
	public String getMoudle_parent_uuid() {
		return moudle_parent_uuid;
	}
	public MoudleBean setMoudle_parent_uuid(String moudle_parent_uuid) {
		this.moudle_parent_uuid = moudle_parent_uuid;
		return this;
	}
	public int getMoudle_id() {
		return moudle_id;
	}
	public MoudleBean setMoudle_id(int moudle_id) {
		this.moudle_id = moudle_id;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public MoudleBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public String getMoudle_name() {
		return moudle_name;
	}
	public MoudleBean setMoudle_name(String moudle_name) {
		this.moudle_name = moudle_name;
		return this;
	}
	public String getMoudle_type() {
		return moudle_type;
	}
	public MoudleBean setMoudle_type(String moudle_type) {
		this.moudle_type = moudle_type;
		return this;
	}
	public String getMoudle_url() {
		return moudle_url;
	}
	public MoudleBean setMoudle_url(String moudle_url) {
		this.moudle_url = moudle_url;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public MoudleBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public MoudleBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MoudleBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public List<MoudleBean> getMenuBeans() {
		return menuBeans;
	}
	public MoudleBean setMenuBeans(List<MoudleBean> menuBeans) {
		this.menuBeans = menuBeans;
		return this;
	}
	public String getMoudle_remark() {
		return moudle_remark;
	}
	public MoudleBean setMoudle_remark(String moudle_remark) {
		this.moudle_remark = moudle_remark;
		return this;
	}
	
	
}

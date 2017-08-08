package tst.project.bean.goods;

public class SSPClassBean {
	private int class_id;
	private String class_name;
	private String class_type;//is_pre_sale:预售商品 ssp_promotion:限时促销 ssp_gift:礼品 
								//ssp_fresh:生鲜 ssp_baby:母婴 ssp_lady:女士 ssp_feature:特色推荐 ssp_import:进口
	private String is_delete;
	private String create_time;
	private String sort;
	
	public String getIs_delete() {
		return is_delete;
	}
	public SSPClassBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SSPClassBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public SSPClassBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public int getClass_id() {
		return class_id;
	}
	public SSPClassBean setClass_id(int class_id) {
		this.class_id = class_id;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public SSPClassBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getClass_type() {
		return class_type;
	}
	public SSPClassBean setClass_type(String class_type) {
		this.class_type = class_type;
		return this;
	}
		
}

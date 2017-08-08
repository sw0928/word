package tst.project.bean.merchants;

import java.util.List;

public class MerchantsLabelBean {
	private int label_id;
	private String label_name;
	private String is_delete;
	private String create_time;
	private String sort;
	private List<LabelQualificationBean> labelQualificationBeans;
	
	
	public List<LabelQualificationBean> getLabelQualificationBeans() {
		return labelQualificationBeans;
	}
	public MerchantsLabelBean setLabelQualificationBeans(List<LabelQualificationBean> labelQualificationBeans) {
		this.labelQualificationBeans = labelQualificationBeans;
		return this;
	}
	public int getLabel_id() {
		return label_id;
	}
	public MerchantsLabelBean setLabel_id(int label_id) {
		this.label_id = label_id;
		return this;
	}
	public String getLabel_name() {
		return label_name;
	}
	public MerchantsLabelBean setLabel_name(String label_name) {
		this.label_name = label_name;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MerchantsLabelBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MerchantsLabelBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public MerchantsLabelBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	
}

package tst.project.bean.merchants;

/**
 * 商家 标签资质证明
 * @author shenjiabo
 *
 */
public class LabelQualificationBean {
	private int label_qualification_id;
	private String qualification_id;
	private String qualification_name;
	private String create_time;
	private String is_delete;
	private String label_id;
	
	public int getLabel_qualification_id() {
		return label_qualification_id;
	}
	public LabelQualificationBean setLabel_qualification_id(int label_qualification_id) {
		this.label_qualification_id = label_qualification_id;
		return this;
	}
	public String getQualification_id() {
		return qualification_id;
	}
	public LabelQualificationBean setQualification_id(String qualification_id) {
		this.qualification_id = qualification_id;
		return this;
	}
	public String getQualification_name() {
		return qualification_name;
	}
	public LabelQualificationBean setQualification_name(String qualification_name) {
		this.qualification_name = qualification_name;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public LabelQualificationBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public LabelQualificationBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getLabel_id() {
		return label_id;
	}
	public LabelQualificationBean setLabel_id(String label_id) {
		this.label_id = label_id;
		return this;
	}
	
	
}

package tst.project.bean.goods;

public class TagBean {
	private int tag_id;
	private String tag_name;
	private String parent_id;
	private String is_delete;
	private String create_time;
	private String sort;
	
	public String getSort() {
		return sort;
	}
	public TagBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public int getTag_id() {
		return tag_id;
	}
	public TagBean setTag_id(int tag_id) {
		this.tag_id = tag_id;
		return this;
	}
	public String getTag_name() {
		return tag_name;
	}
	public TagBean setTag_name(String tag_name) {
		this.tag_name = tag_name;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public TagBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public TagBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public TagBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}	
}

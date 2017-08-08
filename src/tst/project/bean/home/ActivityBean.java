package tst.project.bean.home;

import java.util.List;

public class ActivityBean {
	private int activity_id;
	private String activity_name;
	private String activity_type;
	private String activity_img;
	private String activity_url;
	private String create_time;
	private String is_delete;
	private String parent_id;
	private String sort;
	private String relation_id;
	private String home_type;
	private String activity_state;
	private List<ActivityBean> activityBeans;

	public String getActivity_state() {
		return activity_state;
	}
	public ActivityBean setActivity_state(String activity_state) {
		this.activity_state = activity_state;
		return this;
	}
	public String getHome_type() {
		return home_type;
	}
	public ActivityBean setHome_type(String home_type) {
		this.home_type = home_type;
		return this;
	}
	public String getRelation_id() {
		return relation_id;
	}
	public ActivityBean setRelation_id(String relation_id) {
		this.relation_id = relation_id;
		return this;
	}
	public List<ActivityBean> getActivityBeans() {
		return activityBeans;
	}
	public ActivityBean setActivityBeans(List<ActivityBean> activityBeans) {
		this.activityBeans = activityBeans;
		return this;
	}
	public int getActivity_id() {
		return activity_id;
	}
	public ActivityBean setActivity_id(int activity_id) {
		this.activity_id = activity_id;
		return this;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public ActivityBean setActivity_name(String activity_name) {
		this.activity_name = activity_name;
		return this;
	}
	public String getActivity_type() {
		return activity_type;
	}
	public ActivityBean setActivity_type(String activity_type) {
		this.activity_type = activity_type;
		return this;
	}
	public String getActivity_img() {
		return activity_img;
	}
	public ActivityBean setActivity_img(String activity_img) {
		this.activity_img = activity_img;
		return this;
	}
	public String getActivity_url() {
		return activity_url;
	}
	public ActivityBean setActivity_url(String activity_url) {
		this.activity_url = activity_url;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ActivityBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public ActivityBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public ActivityBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public ActivityBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	
	
	
}

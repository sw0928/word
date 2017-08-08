package tst.project.bean.system;

public class ListBean {
	private int id;
	private String name;
	private int flex;
	private String list_key;
	private String list_keys;
	private int sort;
	private int is_delete;
	private String type;
	private String list_type;
	private String type_name;
	private String state;
	private String state_show;
	private String key;
	
	private int role_list_id;
	private String list_id;
	private String create_time;
	private String role_id;
	private String list_state;


	public String getList_state() {
		return list_state;
	}
	public ListBean setList_state(String list_state) {
		this.list_state = list_state;
		return this;
	}
	public int getRole_list_id() {
		return role_list_id;
	}
	public ListBean setRole_list_id(int role_list_id) {
		this.role_list_id = role_list_id;
		return this;
	}
	public String getList_id() {
		return list_id;
	}
	public ListBean setList_id(String list_id) {
		this.list_id = list_id;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ListBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getRole_id() {
		return role_id;
	}
	public ListBean setRole_id(String role_id) {
		this.role_id = role_id;
		return this;
	}
	public String getState_show() {
		return state_show;
	}
	public ListBean setState_show(String state_show) {
		this.state_show = state_show;
		return this;
	}
	public String getKey() {
		return key;
	}
	public ListBean setKey(String key) {
		this.key = key;
		return this;
	}
	
	public String getList_key() {
		return list_key;
	}
	public ListBean setList_key(String list_key) {
		this.list_key = list_key;
		this.key=list_key;
		return this;
	}
	public String getList_keys() {
		return list_keys;
	}
	public ListBean setList_keys(String list_keys) {
		this.list_keys = list_keys;
		return this;
	}
	public String getState() {
		return state;
	}
	public ListBean setState(String state) {
		this.state = state;
		this.state_show="1".equals(state)?"开启":"关闭";
		return this;
	}
	public String getType_name() {
		return type_name;
	}
	public ListBean setType_name(String type_name) {
		this.type_name = type_name;
		return this;
	}
	
	public int getId() {
		return id;
	}
	public ListBean setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public ListBean setName(String name) {
		this.name = name;
		return this;
	}
	public int getFlex() {
		return flex;
	}
	public ListBean setFlex(int flex) {
		this.flex = flex;
		return this;
	}
	
	public int getSort() {
		return sort;
	}
	public ListBean setSort(int sort) {
		this.sort = sort;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public ListBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getType() {
		return type;
	}
	public ListBean setType(String type) {
		this.type = type;
		return this;
	}
	public String getList_type() {
		return list_type;
	}
	public ListBean setList_type(String list_type) {
		this.list_type = list_type;
		return this;
	}	
	
}

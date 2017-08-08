package tst.project.bean.address;

import java.util.List;

public class CityBean {
	private int id;
	private String name;
	private String parent_id;
	private String create_time;
	private String is_delete;
	private String full_pinyin;
	private String first_pingyin;
	private List<CityBean> cityBeans;
	

	public List<CityBean> getCityBeans() {
		return cityBeans;
	}
	public CityBean setCityBeans(List<CityBean> cityBeans) {
		this.cityBeans = cityBeans;
		return this;
	}
	public int getId() {
		return id;
	}
	public CityBean setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public CityBean setName(String name) {
		this.name = name;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public CityBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public CityBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public CityBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getFull_pinyin() {
		return full_pinyin;
	}
	public CityBean setFull_pinyin(String full_pinyin) {
		this.full_pinyin = full_pinyin;
		return this;
	}
	public String getFirst_pingyin() {
		return first_pingyin;
	}
	public CityBean setFirst_pinyin(String first_pinyin) {
		this.first_pingyin = first_pinyin;
		return this;
	}
}

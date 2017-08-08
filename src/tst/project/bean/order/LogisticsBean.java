package tst.project.bean.order;

public class LogisticsBean {
	private int logistics_id;
	private String logistics_name;
	private String logistics_pinyin;
	private String is_delete;
	private String create_time;
	
	public int getLogistics_id() {
		return logistics_id;
	}
	public LogisticsBean setLogistics_id(int logistics_id) {
		this.logistics_id = logistics_id;
		return this;
	}
	public String getLogistics_name() {
		return logistics_name;
	}
	public LogisticsBean setLogistics_name(String logistics_name) {
		this.logistics_name = logistics_name;
		return this;
	}
	public String getLogistics_pinyin() {
		return logistics_pinyin;
	}
	public LogisticsBean setLogistics_pinyin(String logistics_pinyin) {
		this.logistics_pinyin = logistics_pinyin;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public LogisticsBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public LogisticsBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	
}

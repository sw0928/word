package tst.project.bean.order;

public class PingSettingBean {
	private int ping_id;
	private String ping_app_key;
	private String ping_app_id;
	private String ping_type;
	public int getPing_id() {
		return ping_id;
	}
	public PingSettingBean setPing_id(int ping_id) {
		this.ping_id = ping_id;
		return this;
	}
	public String getPing_app_key() {
		return ping_app_key;
	}
	public PingSettingBean setPing_app_key(String ping_app_key) {
		this.ping_app_key = ping_app_key;
		return this;
	}
	public String getPing_app_id() {
		return ping_app_id;
	}
	public PingSettingBean setPing_app_id(String ping_app_id) {
		this.ping_app_id = ping_app_id;
		return this;
	}
	public String getPing_type() {
		return ping_type;
	}
	public PingSettingBean setPing_type(String ping_type) {
		this.ping_type = ping_type;
		return this;
	}
}

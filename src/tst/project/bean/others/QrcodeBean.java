package tst.project.bean.others;

public class QrcodeBean {
	private int qrcode_id;
	private String qrcode_desc;
	private String qrcode_type;
	private String is_delete;
	private String create_time;
	public int getQrcode_id() {
		return qrcode_id;
	}
	public QrcodeBean setQrcode_id(int qrcode_id) {
		this.qrcode_id = qrcode_id;
		return this;
	}
	public String getQrcode_desc() {
		return qrcode_desc;
	}
	public QrcodeBean setQrcode_desc(String qrcode_desc) {
		this.qrcode_desc = qrcode_desc;
		return this;
	}
	public String getQrcode_type() {
		return qrcode_type;
	}
	public QrcodeBean setQrcode_type(String qrcode_type) {
		this.qrcode_type = qrcode_type;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public QrcodeBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public QrcodeBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}	
}

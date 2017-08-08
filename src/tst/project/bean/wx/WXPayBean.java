package tst.project.bean.wx;

public class WXPayBean {
	private String appId;
	private String timeStamp;
	private String nonceStr;
	private String packageStr;
	private String signType;
	private String paySign;
	public String getAppId() {
		return appId;
	}
	public WXPayBean setAppId(String appId) {
		this.appId = appId;
		return this;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public WXPayBean setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public WXPayBean setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
		return this;
	}
	public String getPackageStr() {
		return packageStr;
	}
	public WXPayBean setPackageStr(String packageStr) {
		this.packageStr = packageStr;
		return this;
	}
	public String getSignType() {
		return signType;
	}
	public WXPayBean setSignType(String signType) {
		this.signType = signType;
		return this;
	}
	public String getPaySign() {
		return paySign;
	}
	public WXPayBean setPaySign(String paySign) {
		this.paySign = paySign;
		return this;
	}
	
	
}

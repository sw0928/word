package tst.project.bean.wx;

/**
 * 接受微信推送事件自定义消息
 * @author shenjiabo
 *
 */
public class WXMsgBean {
	private String wx_type;
	private String business_id;
	private String goods_id;
	private String merchants_id;
	public String getWx_type() {
		return wx_type;
	}
	public WXMsgBean setWx_type(String wx_type) {
		this.wx_type = wx_type;
		return this;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public WXMsgBean setBusiness_id(String business_id) {
		this.business_id = business_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public WXMsgBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public WXMsgBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
}

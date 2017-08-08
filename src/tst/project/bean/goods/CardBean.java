package tst.project.bean.goods;

/**
 * 特殊的商品 卡
 * @author shenjiabo
 *
 */
public class CardBean {
	private String member_id;
	private String card_code;//激活码
	private String valid_time;//有效时间 单位天数
	private String card_price;//卡的价格
	private String is_used;//是否已经被用过
	private String is_used_show;
	private String is_delete;//是否删除
	private String create_time;//生成时间
	private String card_type;//activity:活动  不用付钱  goods:商品 需要付钱
	private String card_type_show;
	
	public String getMember_id() {
		return member_id;
	}

	public CardBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}

	public String getIs_used_show() {
		return is_used_show;
	}

	public CardBean setIs_used_show(String is_used_show) {
		this.is_used_show = is_used_show;
		return this;
	}

	public String getCard_type_show() {
		return card_type_show;
	}

	public CardBean setCard_type_show(String card_type_show) {
		this.card_type_show = card_type_show;
		return this;
	}

	public String getCard_type() {
		return card_type;
	}
	
	public CardBean setCard_type(String card_type) {
		this.card_type = card_type;
		this.card_type_show="goods".equals(card_type)?"收费":"活动";
		return this;
	}
	
	
	public String getValid_time() {
		return valid_time;
	}

	public CardBean setValid_time(String valid_time) {
		this.valid_time = valid_time;
		return this;
	}

	public String getCard_code() {
		return card_code;
	}
	public CardBean setCard_code(String card_code) {
		this.card_code = card_code;
		return this;
	}
	public String getCard_price() {
		return card_price;
	}
	public CardBean setCard_price(String card_price) {
		this.card_price = card_price;
		return this;
	}
	public String getIs_used() {
		return is_used;
	}
	public CardBean setIs_used(String is_used) {
		this.is_used = is_used;
		this.is_used_show="1".equals(is_used)?"已使用":"未使用";
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public CardBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public CardBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}	
}

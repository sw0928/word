package tst.project.bean.activity;

public class PromotionBean {
	private int promotion_id;
	private String promotion_name;
	private String promotion_img;
	private String promotion_url;
	private String create_time;
	private String start_time;
	private String end_time;
	private String is_delete;
	private String promotion_type;
	private PromotionGoodsBean promotionGoodsBean;
	
	
	
	public String getPromotion_type() {
		return promotion_type;
	}
	public PromotionBean setPromotion_type(String promotion_type) {
		this.promotion_type = promotion_type;
		return this;
	}
	public PromotionGoodsBean getPromotionGoodsBean() {
		return promotionGoodsBean;
	}
	public PromotionBean setPromotionGoodsBean(PromotionGoodsBean promotionGoodsBean) {
		this.promotionGoodsBean = promotionGoodsBean;
		return this;
	}
	public int getPromotion_id() {
		return promotion_id;
	}
	public PromotionBean setPromotion_id(int promotion_id) {
		this.promotion_id = promotion_id;
		return this;
	}
	public String getPromotion_name() {
		return promotion_name;
	}
	public PromotionBean setPromotion_name(String promotion_name) {
		this.promotion_name = promotion_name;
		return this;
	}
	public String getPromotion_img() {
		return promotion_img;
	}
	public PromotionBean setPromotion_img(String promotion_img) {
		this.promotion_img = promotion_img;
		return this;
	}
	public String getPromotion_url() {
		return promotion_url;
	}
	public PromotionBean setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public PromotionBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public PromotionBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public PromotionBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public PromotionBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	
	
}

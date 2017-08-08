package tst.project.bean.activity;

import java.util.List;

public class ActivityBean {
	private int activity_id;
	private int goods_id;
	private int activity_goods_id;
	private String activity_goods_ids;
	private String goods_name;
	private String goods_sku;
	private String activity_name;
	private String activity_desc;
	private String activity_type;
	private String activity_type_show;
	private String activity_img;
	private String activity_url;
	private String activity_state;
	private String sort;
	private String is_delete;
	private String goods_uuid;
	private String create_time;
	private GiveBean giveBean;
	private ReduceBean reduceBean;
	private GiftBean giftBean;
	private HalfBean halfBean;
	private ExemptBean exemptBean;
	
	public String getGoods_uuid() {
		return goods_uuid;
	}
	public ActivityBean setGoods_uuid(String goods_uuid) {
		this.goods_uuid = goods_uuid;
		return this;
	}
	public String getActivity_state() {
		return activity_state;
	}
	public ActivityBean setActivity_state(String activity_state) {
		this.activity_state = activity_state;
		return this;
	}
	public ExemptBean getExemptBean() {
		return exemptBean;
	}
	public ActivityBean setExemptBean(ExemptBean exemptBean) {
		this.exemptBean = exemptBean;
		return this;
	}
	public HalfBean getHalfBean() {
		return halfBean;
	}
	public ActivityBean setHalfBean(HalfBean halfBean) {
		this.halfBean = halfBean;
		return this;
	}
	public String getActivity_goods_ids() {
		return activity_goods_ids;
	}
	public ActivityBean setActivity_goods_ids(String activity_goods_ids) {
		this.activity_goods_ids = activity_goods_ids;
		return this;
	}
	
	public GiftBean getGiftBean() {
		return giftBean;
	}
	public ActivityBean setGiftBean(GiftBean giftBean) {
		this.giftBean = giftBean;
		return this;
	}
	public ReduceBean getReduceBean() {
		return reduceBean;
	}
	public ActivityBean setReduceBean(ReduceBean reduceBean) {
		this.reduceBean = reduceBean;
		return this;
	}
	public GiveBean getGiveBean() {
		return giveBean;
	}
	public ActivityBean setGiveBean(GiveBean giveBean) {
		this.giveBean = giveBean;
		return this;
	}
	public int getActivity_goods_id() {
		return activity_goods_id;
	}
	public ActivityBean setActivity_goods_id(int activity_goods_id) {
		this.activity_goods_id = activity_goods_id;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public ActivityBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_sku() {
		return goods_sku;
	}
	public ActivityBean setGoods_sku(String goods_sku) {
		this.goods_sku = goods_sku;
		return this;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public ActivityBean setGoods_id(int goods_id) {
		this.goods_id = goods_id;
		return this;
	}

	public String getActivity_type_show() {
		return activity_type_show;
	}
	public ActivityBean setActivity_type_show(String activity_type_show) {
		this.activity_type_show = activity_type_show;
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
	public String getActivity_desc() {
		return activity_desc;
	}
	public ActivityBean setActivity_desc(String activity_desc) {
		this.activity_desc = activity_desc;
		return this;
	}
	
	public String getActivity_type() {
		return activity_type;
	}
	public ActivityBean setActivity_type(String activity_type) {
		this.activity_type = activity_type;
		this.activity_type_show="give".equals(activity_type)?"满送活动":
								("reduce".equals(activity_type)?"满减活动":
								("gift".equals(activity_type)?"礼物活动":
								("half".equals(activity_type)?"半价活动":
								("exempt".equals(activity_type)?"满免活动":"未知活动"))));
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
	public String getSort() {
		return sort;
	}
	public ActivityBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public ActivityBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ActivityBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}	
}

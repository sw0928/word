package tst.project.bean.goods;

import java.util.List;

import tst.project.bean.activity.ActivityBean;
import tst.project.bean.activity.GroupBuyGoodsBean;
import tst.project.bean.banner.ClassBannerBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.utils.NumberUtils;

public class GoodsBean implements Comparable {
	private int goods_id;
	private int goods_class_id;
	private int activity_goods_id;
	private int order_goods_id;
	private String member_id;
	private String merchants_id;
	private String merchants_name;
	private String goods_name;
	private String goods_img;
	private String goods_imgs;
	private String goods_now_price;
	private String goods_origin_price;
	private String goods_pc_price;
	private String price_cut;// 差价
	private String discount_value;
	private String goods_grade;
	private String goods_state;
	private String goods_state_show;
	private int goods_stock;
	private String goods_type;
	private String goods_address;
	private String goods_url;
	private String goods_url_content;
	private int day_sales;
	private int month_sales;
	private int year_sales;
	private String is_business_buy;
	private String brand_id;
	private String brand_name;
	private String parent_id;
	private String parent_name;
	private String parent_uuid;
	private String class_id;// 顺手拍7个分类的id
	private String class1_id;
	private String class1_name;
	private String class2_id;
	private String class2_name;
	private String create_time;
	private String is_recommend;
	private String is_recommend_show;
	private String is_give_integral;
	private String give_integral_value;
	private String is_deduct_integral;
	private String deduct_integral_value;
	private String deduct_integral_price;
	private String is_express;
	private String express_price;

	private String is_delete;
	private String goods_uuid;
	private String goods_parent_uuid;
	private String sort_time;
	private String sort;

	private String is_end;// 判断分类是否结束

	private String size_id;
	private String year_id;
	private String label_id;
	private String season_id;
	private String min_price;
	private String max_price;
	private String min_pc_price;
	private String max_pc_price;
	private String sort_type;
	private String sort_way;
	private String is_selling;
	private String is_hot;
	private String express_free_price;
	private String goods_desc;
	private String is_collection;
	private String collection_id;

	private String see_num;

	private String is_group_buy;
	private String group_buy_count;// 所有成功的团购
	private String group_buy_now_count;// 现在正在团购的数量
	private String group_buy_price;

	private String is_pre_sale;
	private String is_pre_sale_id;
	private String send_goods_time;
	private String promotion_price;
	private String promotion_goods_id;

	private String goods_story_url;
	private String ssp_gift;
	private String ssp_gift_id;
	private String ssp_fresh;
	private String ssp_fresh_id;
	private String ssp_baby;
	private String ssp_baby_id;
	private String ssp_lady;
	private String ssp_lady_id;
	private String ssp_feature;
	private String ssp_feature_id;
	private String ssp_import;
	private String ssp_import_id;
	private String ssp_promotion;
	private String ssp_promotion_id;

	private String is_cross_border;
	private String cross_border_tax;
	private String goods_sku;
	private String goods_skus;
	private String goods_storehouse;// 仓库
	private String goods_excise_tax;// 消费税

	private String start_time;
	private String end_time;
	private String is_new;// 最新商品
	private String goods_title;
	private String type;// 顺手拍 用户区分 礼品等标签

	private String goods_star1;
	private String goods_star2;
	private String goods_star3;
	private String satisfied_count;// 满意数
	private String dissatisfied_count;// 不满意数

	private String business_id;// 店铺id

	private String is_share;// 是否可以分享
	private int share_integral;// 分享赠送积分

	private int is_price_cut_ranking;
	private int is_discount_ranking;

	private String goods_no;
	private String goods_parameters;
	private String goods_parameters_name;

	private String is_class_recommend;// 分类下 推荐商品 pc端 首页 广告位
	private String class_recommend_img;// 分类下 推荐商品 pc端 首页 广告位图片
	private String qrcode_img;// 商品二维码

	private String activity_id;
	private String storehouse_name;

	private String is_merchants_recommend;
	private String is_exact;// 是否精品
	private String is_goods_exact;
	private String is_sales_ranking;// 是否参加排行
	private String is_directly;// 是否直营

	private String good_assessment_percent;// 好评率
	private int good_assessment_count;// 好评数
	private String bad_assessment_percent;// 差评率
	private int bad_assessment_count;// 差评数
	private String in_assessment_percent;// 中评率
	private int in_assessment_count;// 中评数
	private int assessment_count;// 总评价数
	private int assessment_img_count;// 评价含有图片数量

	private String receive_time;

	private String goods_replenishment_time;// 补货时间
	private String goods_storage_instructions;// 储存说明
	private String goods_addnation_notes;// 特别注意事项说明
	private String goods_form;// 状态(固态还是液体) solid:固态 liquid:液态
	private String goods_research_areas;// 研究领域,
										// 一个商品有多个研究领域，点击某个研究领域可以跳转到该研究领域的商品
	private String standard_type;

	private String album_id;// 专辑id

	private String goods_count;// 分类下商品数量
	private String distance;// 距离

	private String sort_price;// 排序价格
	private String bidding_price;// 竞价价格

	private int goods_num;
	private MerchantsBean merchantsBean;
	private List<ClassBannerBean> classBannerBeans;
	private List<GoodsBean> goodsRecommendBeans;
	private List<GoodsBean> classRecommendBeans;
	private List<GoodsBean> goodsBeans;
	private List<GoodsImgBean> goodsImgBeans;
	private List<BrandBean> brandBeans;
	private List<GoodsParameterBean> goodsParameterBeans;
	private List<GoodsServiceBean> goodsServiceBeans;
	private List<GroupBuyGoodsBean> groupBuyGoodsBeans;
	private List<StandardBean> standardBeans;
	private ActivityBean activityBean;
	private List<ActivityBean> activityBeans;
	private List<GoodsLabelBean> goodsLabelBeans;
	
	public int getOrder_goods_id() {
		return order_goods_id;
	}

	public GoodsBean setOrder_goods_id(int order_goods_id) {
		this.order_goods_id = order_goods_id;
		return this;
	}

	public int getGoods_num() {
		return goods_num;
	}

	public GoodsBean setGoods_num(int goods_num) {
		this.goods_num = goods_num;
		return this;
	}

	public String getMin_pc_price() {
		return min_pc_price;
	}

	public GoodsBean setMin_pc_price(String min_pc_price) {
		this.min_pc_price = min_pc_price;
		return this;
	}

	public String getMax_pc_price() {
		return max_pc_price;
	}

	public GoodsBean setMax_pc_price(String max_pc_price) {
		this.max_pc_price = max_pc_price;
		return this;
	}

	public String getSort_price() {
		return sort_price;
	}

	public GoodsBean setSort_price(String sort_price) {
		this.sort_price = sort_price;
		return this;
	}

	public String getBidding_price() {
		return bidding_price;
	}

	public GoodsBean setBidding_price(String bidding_price) {
		this.bidding_price = bidding_price;
		return this;
	}

	public List<ClassBannerBean> getClassBannerBeans() {
		return classBannerBeans;
	}

	public GoodsBean setClassBannerBeans(List<ClassBannerBean> classBannerBeans) {
		this.classBannerBeans = classBannerBeans;
		return this;
	}

	public ActivityBean getActivityBean() {
		return activityBean;
	}

	public GoodsBean setActivityBean(ActivityBean activityBean) {
		this.activityBean = activityBean;
		return this;
	}

	public String getDistance() {
		return distance;
	}

	public GoodsBean setDistance(String distance) {
		this.distance = distance;
		return this;
	}

	public String getAlbum_id() {
		return album_id;
	}

	public GoodsBean setAlbum_id(String album_id) {
		this.album_id = album_id;
		return this;
	}

	public int getAssessment_img_count() {
		return assessment_img_count;
	}

	public GoodsBean setAssessment_img_count(int assessment_img_count) {
		this.assessment_img_count = assessment_img_count;
		return this;
	}

	public int getGood_assessment_count() {
		return good_assessment_count;
	}

	public GoodsBean setGood_assessment_count(int goods_assessment_count) {
		this.good_assessment_count = goods_assessment_count;
		return this;
	}

	public String getBad_assessment_percent() {
		return bad_assessment_percent;
	}

	public GoodsBean setBad_assessment_percent(String bad_assessment_percent) {
		this.bad_assessment_percent = bad_assessment_percent;
		return this;
	}

	public int getBad_assessment_count() {
		return bad_assessment_count;
	}

	public GoodsBean setBad_assessment_count(int bad_assessment_count) {
		this.bad_assessment_count = bad_assessment_count;
		return this;
	}

	public String getIn_assessment_percent() {
		return in_assessment_percent;
	}

	public GoodsBean setIn_assessment_percent(String in_assessment_percent) {
		this.in_assessment_percent = in_assessment_percent;
		return this;
	}

	public int getIn_assessment_count() {
		return in_assessment_count;
	}

	public GoodsBean setIn_assessment_count(int in_assessment_count) {
		this.in_assessment_count = in_assessment_count;
		return this;
	}

	public String getGoods_count() {
		return goods_count;
	}

	public GoodsBean setGoods_count(String goods_count) {
		this.goods_count = goods_count;
		return this;
	}

	public String getStandard_type() {
		return standard_type;
	}

	public GoodsBean setStandard_type(String standard_type) {
		this.standard_type = standard_type;
		return this;
	}

	public String getGoods_replenishment_time() {
		return goods_replenishment_time;
	}

	public GoodsBean setGoods_replenishment_time(String goods_replenishment_time) {
		this.goods_replenishment_time = goods_replenishment_time;
		return this;
	}

	public String getGoods_storage_instructions() {
		return goods_storage_instructions;
	}

	public GoodsBean setGoods_storage_instructions(String goods_storage_instructions) {
		this.goods_storage_instructions = goods_storage_instructions;
		return this;
	}

	public String getGoods_addnation_notes() {
		return goods_addnation_notes;
	}

	public GoodsBean setGoods_addnation_notes(String goods_addnation_notes) {
		this.goods_addnation_notes = goods_addnation_notes;
		return this;
	}

	public String getGoods_form() {
		return goods_form;
	}

	public GoodsBean setGoods_form(String goods_form) {
		this.goods_form = goods_form;
		return this;
	}

	public String getGoods_research_areas() {
		return goods_research_areas;
	}

	public GoodsBean setGoods_research_areas(String goods_research_areas) {
		this.goods_research_areas = goods_research_areas;
		return this;
	}

	public String getIs_business_buy() {
		return is_business_buy;
	}

	public GoodsBean setIs_business_buy(String is_business_buy) {
		this.is_business_buy = is_business_buy;
		return this;
	}

	public String getReceive_time() {
		return receive_time;
	}

	public GoodsBean setReceive_time(String receive_time) {
		this.receive_time = receive_time;
		return this;
	}

	public String getGoods_parameters_name() {
		return goods_parameters_name;
	}

	public GoodsBean setGoods_parameters_name(String goods_parameters_name) {
		this.goods_parameters_name = goods_parameters_name;
		return this;
	}

	public GoodsBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}

	public String getGood_assessment_percent() {
		return good_assessment_percent;
	}

	public GoodsBean setGood_assessment_percent(String good_assessment_percent) {
		this.good_assessment_percent = NumberUtils
				.KeepDecimal(Double.valueOf(good_assessment_percent == null ? "100" : good_assessment_percent), 2) + "";
		return this;
	}

	public String getSee_num() {
		return see_num;
	}

	public GoodsBean setSee_num(String see_num) {
		this.see_num = see_num;
		return this;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public GoodsBean setBrand_name(String brand_name) {
		this.brand_name = brand_name;
		return this;
	}

	public String getIs_merchants_recommend() {
		return is_merchants_recommend;
	}

	public GoodsBean setIs_merchants_recommend(String is_merchants_recommend) {
		this.is_merchants_recommend = is_merchants_recommend;
		return this;
	}

	public String getIs_exact() {
		return is_exact;
	}

	public GoodsBean setIs_exact(String is_exact) {
		this.is_exact = is_exact;
		return this;
	}

	public String getIs_goods_exact() {
		return is_goods_exact;
	}

	public GoodsBean setIs_goods_exact(String is_goods_exact) {
		this.is_goods_exact = is_goods_exact;
		return this;
	}

	public String getIs_sales_ranking() {
		return is_sales_ranking;
	}

	public GoodsBean setIs_sales_ranking(String is_sales_ranking) {
		this.is_sales_ranking = is_sales_ranking;
		return this;
	}

	public String getActivity_id() {
		return activity_id;
	}

	public GoodsBean setActivity_id(String activity_id) {
		this.activity_id = activity_id;
		return this;
	}

	public String getStorehouse_name() {
		return storehouse_name;
	}

	public GoodsBean setStorehouse_name(String storehouse_name) {
		this.storehouse_name = storehouse_name;
		return this;
	}

	public List<GoodsLabelBean> getGoodsLabelBeans() {
		return goodsLabelBeans;
	}

	public GoodsBean setGoodsLabelBeans(List<GoodsLabelBean> goodsLabelBeans) {
		this.goodsLabelBeans = goodsLabelBeans;
		return this;
	}

	public String getQrcode_img() {
		return qrcode_img;
	}

	public GoodsBean setQrcode_img(String qrcode_img) {
		this.qrcode_img = qrcode_img;
		return this;
	}

	public String getGoods_pc_price() {
		return goods_pc_price;
	}

	public GoodsBean setGoods_pc_price(String goods_pc_price) {
		this.goods_pc_price = goods_pc_price;
		return this;
	}

	public String getClass_recommend_img() {
		return class_recommend_img;
	}

	public GoodsBean setClass_recommend_img(String class_recommend_img) {
		this.class_recommend_img = class_recommend_img;
		return this;
	}

	public List<GoodsBean> getClassRecommendBeans() {
		return classRecommendBeans;
	}

	public GoodsBean setClassRecommendBeans(List<GoodsBean> classRecommendBeans) {
		this.classRecommendBeans = classRecommendBeans;
		return this;
	}

	public String getIs_class_recommend() {
		return is_class_recommend;
	}

	public GoodsBean setIs_class_recommend(String is_class_recommend) {
		this.is_class_recommend = is_class_recommend;
		return this;
	}

	public List<GoodsBean> getGoodsRecommendBeans() {
		return goodsRecommendBeans;
	}

	public GoodsBean setGoodsRecommendBeans(List<GoodsBean> goodsRecommendBeans) {
		this.goodsRecommendBeans = goodsRecommendBeans;
		return this;
	}

	public String getGoods_parameters() {
		return goods_parameters;
	}

	public GoodsBean setGoods_parameters(String goods_parameters) {
		this.goods_parameters = goods_parameters;
		return this;
	}

	public String getGoods_no() {
		return goods_no;
	}

	public GoodsBean setGoods_no(String goods_no) {
		this.goods_no = goods_no;
		return this;
	}

	public String getGoods_imgs() {
		return goods_imgs;
	}

	public GoodsBean setGoods_imgs(String goods_imgs) {
		this.goods_imgs = goods_imgs;
		return this;
	}

	public int getActivity_goods_id() {
		return activity_goods_id;
	}

	public GoodsBean setActivity_goods_id(int activity_goods_id) {
		this.activity_goods_id = activity_goods_id;
		return this;
	}

	public int getGoods_class_id() {
		return goods_class_id;
	}

	public GoodsBean setGoods_class_id(int goods_class_id) {
		this.goods_class_id = goods_class_id;
		return this;
	}

	public String getSort_type() {
		return sort_type;
	}

	public GoodsBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}

	public String getMerchants_name() {
		return merchants_name;
	}

	public GoodsBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}

	public List<ActivityBean> getActivityBeans() {
		return activityBeans;
	}

	public GoodsBean setActivityBeans(List<ActivityBean> activityBeans) {
		this.activityBeans = activityBeans;
		return this;
	}

	public String getGoods_state_show() {
		return goods_state_show;
	}

	public GoodsBean setGoods_state_show(String goods_state_show) {
		this.goods_state_show = goods_state_show;
		return this;
	}

	public int getIs_price_cut_ranking() {
		return is_price_cut_ranking;
	}

	public GoodsBean setIs_price_cut_ranking(int is_price_cut_ranking) {
		this.is_price_cut_ranking = is_price_cut_ranking;
		return this;
	}

	public int getIs_discount_ranking() {
		return is_discount_ranking;
	}

	public GoodsBean setIs_discount_ranking(int is_discount_ranking) {
		this.is_discount_ranking = is_discount_ranking;
		return this;
	}

	public String getDiscount_value() {
		return discount_value;
	}

	public GoodsBean setDiscount_value(String discount_value) {
		this.discount_value = discount_value;
		return this;
	}

	public String getPrice_cut() {
		return price_cut;
	}

	public GoodsBean setPrice_cut(String price_cut) {
		this.price_cut = price_cut;
		return this;
	}

	public String getSort() {
		return sort;
	}

	public GoodsBean setSort(String sort) {
		this.sort = sort;
		return this;
	}

	public String getIs_share() {
		return is_share;
	}

	public GoodsBean setIs_share(String is_share) {
		this.is_share = is_share;
		return this;
	}

	public int getShare_integral() {
		return share_integral;
	}

	public GoodsBean setShare_integral(int share_integral) {
		this.share_integral = share_integral;
		return this;
	}

	public String getGroup_buy_now_count() {
		return group_buy_now_count;
	}

	public GoodsBean setGroup_buy_now_count(String group_buy_now_count) {
		this.group_buy_now_count = group_buy_now_count;
		return this;
	}

	public String getClass_id() {
		return class_id;
	}

	public GoodsBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}

	public String getIs_pre_sale_id() {
		return is_pre_sale_id;
	}

	public GoodsBean setIs_pre_sale_id(String is_pre_sale_id) {
		this.is_pre_sale_id = is_pre_sale_id;
		return this;
	}

	public String getSsp_gift_id() {
		return ssp_gift_id;
	}

	public GoodsBean setSsp_gift_id(String ssp_gift_id) {
		this.ssp_gift_id = ssp_gift_id;
		return this;
	}

	public String getSsp_fresh_id() {
		return ssp_fresh_id;
	}

	public GoodsBean setSsp_fresh_id(String ssp_fresh_id) {
		this.ssp_fresh_id = ssp_fresh_id;
		return this;
	}

	public String getSsp_baby_id() {
		return ssp_baby_id;
	}

	public GoodsBean setSsp_baby_id(String ssp_baby_id) {
		this.ssp_baby_id = ssp_baby_id;
		return this;
	}

	public String getSsp_lady_id() {
		return ssp_lady_id;
	}

	public GoodsBean setSsp_lady_id(String ssp_lady_id) {
		this.ssp_lady_id = ssp_lady_id;
		return this;
	}

	public String getSsp_feature_id() {
		return ssp_feature_id;
	}

	public GoodsBean setSsp_feature_id(String ssp_feature_id) {
		this.ssp_feature_id = ssp_feature_id;
		return this;
	}

	public String getSsp_import_id() {
		return ssp_import_id;
	}

	public GoodsBean setSsp_import_id(String ssp_import_id) {
		this.ssp_import_id = ssp_import_id;
		return this;
	}

	public String getSsp_promotion_id() {
		return ssp_promotion_id;
	}

	public GoodsBean setSsp_promotion_id(String ssp_promotion_id) {
		this.ssp_promotion_id = ssp_promotion_id;
		return this;
	}

	public String getBusiness_id() {
		return business_id;
	}

	public GoodsBean setBusiness_id(String business_id) {
		this.business_id = business_id;
		return this;
	}

	public String getSatisfied_count() {
		return satisfied_count;
	}

	public GoodsBean setSatisfied_count(String satisfied_count) {
		this.satisfied_count = satisfied_count;
		return this;
	}

	public String getDissatisfied_count() {
		return dissatisfied_count;
	}

	public GoodsBean setDissatisfied_count(String dissatisfied_count) {
		this.dissatisfied_count = dissatisfied_count;
		return this;
	}

	public String getGoods_star1() {
		return goods_star1 == null ? "5" : goods_star1;
	}

	public GoodsBean setGoods_star1(String goods_star1) {
		this.goods_star1 = goods_star1;
		return this;
	}

	public String getGoods_star2() {
		return goods_star2 == null ? "5" : goods_star2;
	}

	public GoodsBean setGoods_star2(String goods_star2) {
		this.goods_star2 = goods_star2;
		return this;
	}

	public String getGoods_star3() {
		return goods_star3 == null ? "5" : goods_star3;
	}

	public GoodsBean setGoods_star3(String goods_star3) {
		this.goods_star3 = goods_star3;
		return this;
	}

	public String getIs_directly() {
		return is_directly;
	}

	public GoodsBean setIs_directly(String is_directly) {
		this.is_directly = is_directly;
		return this;
	}

	public String getType() {
		return type;
	}

	public GoodsBean setType(String type) {
		this.type = type;
		return this;
	}

	public String getGoods_title() {
		return goods_title;
	}

	public GoodsBean setGoods_title(String goods_title) {
		this.goods_title = goods_title;
		return this;
	}

	public String getIs_new() {
		return is_new;
	}

	public GoodsBean setIs_new(String is_new) {
		this.is_new = is_new;
		return this;
	}

	public String getStart_time() {
		return start_time;
	}

	public GoodsBean setStar_time(String start_time) {
		this.start_time = start_time;
		return this;
	}

	public String getEnd_time() {
		return end_time;
	}

	public GoodsBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}

	public String getGoods_sku() {
		return goods_sku;
	}

	public GoodsBean setGoods_sku(String goods_sku) {
		this.goods_sku = goods_sku;
		return this;
	}

	public String getGoods_skus() {
		return goods_skus;
	}

	public GoodsBean setGoods_skus(String goods_skus) {
		this.goods_skus = goods_skus;
		return this;
	}

	public String getGoods_storehouse() {
		return goods_storehouse;
	}

	public GoodsBean setGoods_storehouse(String goods_storehouse) {
		this.goods_storehouse = goods_storehouse;
		return this;
	}

	public String getGoods_excise_tax() {
		return goods_excise_tax;
	}

	public GoodsBean setGoods_excise_tax(String goods_excise_tax) {
		this.goods_excise_tax = goods_excise_tax;
		return this;
	}

	public String getIs_cross_border() {
		return is_cross_border;
	}

	public GoodsBean setIs_cross_border(String is_cross_border) {
		this.is_cross_border = is_cross_border;
		return this;
	}

	public String getCross_border_tax() {
		return cross_border_tax;
	}

	public GoodsBean setCross_border_tax(String cross_border_tax) {
		this.cross_border_tax = cross_border_tax;
		return this;
	}

	public String getSsp_gift() {
		return ssp_gift;
	}

	public GoodsBean setSsp_gift(String ssp_gift) {
		this.ssp_gift = ssp_gift;
		return this;
	}

	public String getSsp_fresh() {
		return ssp_fresh;
	}

	public GoodsBean setSsp_fresh(String ssp_fresh) {
		this.ssp_fresh = ssp_fresh;
		return this;
	}

	public String getSsp_baby() {
		return ssp_baby;
	}

	public GoodsBean setSsp_baby(String ssp_baby) {
		this.ssp_baby = ssp_baby;
		return this;
	}

	public String getSsp_lady() {
		return ssp_lady;
	}

	public GoodsBean setSsp_lady(String ssp_lady) {
		this.ssp_lady = ssp_lady;
		return this;
	}

	public String getSsp_feature() {
		return ssp_feature;
	}

	public GoodsBean setSsp_feature(String ssp_feature) {
		this.ssp_feature = ssp_feature;
		return this;
	}

	public String getSsp_import() {
		return ssp_import;
	}

	public GoodsBean setSsp_import(String ssp_import) {
		this.ssp_import = ssp_import;
		return this;
	}

	public String getSsp_promotion() {
		return ssp_promotion;
	}

	public GoodsBean setSsp_promotion(String ssp_promotion) {
		this.ssp_promotion = ssp_promotion;
		return this;
	}

	public String getGoods_story_url() {
		return goods_story_url;
	}

	public GoodsBean setGoods_story_url(String goods_story_url) {
		this.goods_story_url = goods_story_url;
		return this;
	}

	public String getGroup_buy_count() {
		return group_buy_count;
	}

	public GoodsBean setGroup_buy_count(String group_buy_count) {
		this.group_buy_count = group_buy_count;
		return this;
	}

	public String getPromotion_price() {
		return promotion_price;
	}

	public GoodsBean setPromotion_price(String promotion_price) {
		this.promotion_price = promotion_price;
		return this;
	}

	public String getPromotion_goods_id() {
		return promotion_goods_id;
	}

	public GoodsBean setPromotion_goods_id(String promotion_goods_id) {
		this.promotion_goods_id = promotion_goods_id;
		return this;
	}

	public String getIs_pre_sale() {
		return is_pre_sale;
	}

	public GoodsBean setIs_pre_sale(String is_pre_sale) {
		this.is_pre_sale = is_pre_sale;
		return this;
	}

	public String getSend_goods_time() {
		return send_goods_time;
	}

	public GoodsBean setSend_goods_time(String send_goods_time) {
		this.send_goods_time = send_goods_time;
		return this;
	}

	public String getGroup_buy_price() {
		return group_buy_price;
	}

	public GoodsBean setGroup_buy_price(String group_buy_price) {
		this.group_buy_price = group_buy_price;
		return this;
	}

	public List<StandardBean> getStandardBeans() {
		return standardBeans;
	}

	public GoodsBean setStandardBeans(List<StandardBean> standardBeans) {
		this.standardBeans = standardBeans;
		return this;
	}

	public List<GroupBuyGoodsBean> getGroupBuyGoodsBeans() {
		return groupBuyGoodsBeans;
	}

	public GoodsBean setGroupBuyGoodsBeans(List<GroupBuyGoodsBean> groupBuyGoodsBeans) {
		this.groupBuyGoodsBeans = groupBuyGoodsBeans;
		return this;
	}

	public String getIs_group_buy() {
		return is_group_buy;
	}

	public GoodsBean setIs_group_buy(String is_group_buy) {
		this.is_group_buy = is_group_buy;
		return this;
	}

	public String getCollection_id() {
		return collection_id;
	}

	public GoodsBean setCollection_id(String collection_id) {
		this.collection_id = collection_id;
		return this;
	}

	public String getIs_collection() {
		return is_collection;
	}

	public GoodsBean setIs_collection(String is_collection) {
		this.is_collection = is_collection;
		return this;
	}

	public String getMember_id() {
		return member_id;
	}

	public GoodsBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}

	public List<GoodsParameterBean> getGoodsParameterBeans() {
		return goodsParameterBeans;
	}

	public GoodsBean setGoodsParameterBeans(List<GoodsParameterBean> goodsParameterBeans) {
		this.goodsParameterBeans = goodsParameterBeans;
		return this;
	}

	public List<GoodsServiceBean> getGoodsServiceBeans() {
		return goodsServiceBeans;
	}

	public GoodsBean setGoodsServiceBeans(List<GoodsServiceBean> goodsServiceBeans) {
		this.goodsServiceBeans = goodsServiceBeans;
		return this;
	}

	public MerchantsBean getMerchantsBean() {
		return merchantsBean;
	}

	public GoodsBean setMerchantsBean(MerchantsBean merchantsBean) {
		this.merchantsBean = merchantsBean;
		return this;
	}

	public String getGoods_desc() {
		return goods_desc;
	}

	public GoodsBean setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
		return this;
	}

	public String getExpress_free_price() {
		return express_free_price;
	}

	public GoodsBean setExpress_free_price(String express_free_price) {
		this.express_free_price = express_free_price;
		return this;
	}

	public String getGoods_url_content() {
		return goods_url_content;
	}

	public GoodsBean setGoods_url_content(String goods_url_content) {
		this.goods_url_content = goods_url_content;
		return this;
	}

	public int getAssessment_count() {
		return assessment_count;
	}

	public GoodsBean setAssessment_count(int assessment_count) {
		this.assessment_count = assessment_count;
		return this;
	}

	public String getIs_selling() {
		return is_selling;
	}

	public GoodsBean setIs_selling(String is_selling) {
		this.is_selling = is_selling;
		return this;
	}

	public String getIs_hot() {
		return is_hot;
	}

	public GoodsBean setIs_hot(String is_hot) {
		this.is_hot = is_hot;
		return this;
	}

	public String getSort_way() {
		return sort_way;
	}

	public GoodsBean setSort_way(String sort_way) {
		this.sort_way = sort_way;
		return this;
	}

	public String getMin_price() {
		return min_price;
	}

	public GoodsBean setMin_price(String min_price) {
		this.min_price = min_price;
		return this;
	}

	public String getMax_price() {
		return max_price;
	}

	public GoodsBean setMax_price(String max_price) {
		this.max_price = max_price;
		return this;
	}

	public String getSeason_id() {
		return season_id;
	}

	public GoodsBean setSeason_id(String season_id) {
		this.season_id = season_id;
		return this;
	}

	public String getLabel_id() {
		return label_id;
	}

	public GoodsBean setLabel_id(String label_id) {
		this.label_id = label_id;
		return this;
	}

	public String getYear_id() {
		return year_id;
	}

	public GoodsBean setYear_id(String year_id) {
		this.year_id = year_id;
		return this;
	}

	public String getSize_id() {
		return size_id;
	}

	public GoodsBean setSize_id(String size_id) {
		this.size_id = size_id;
		return this;
	}

	public List<BrandBean> getBrandBeans() {
		return brandBeans;
	}

	public GoodsBean setBrandBeans(List<BrandBean> brandBeans) {
		this.brandBeans = brandBeans;
		return this;
	}

	public String getParent_uuid() {
		return parent_uuid;
	}

	public GoodsBean setParent_uuid(String parent_uuid) {
		this.parent_uuid = parent_uuid;
		return this;
	}

	public String getIs_end() {
		return is_end;
	}

	public GoodsBean setIs_end(String is_end) {
		this.is_end = is_end;
		return this;
	}

	public List<GoodsImgBean> getGoodsImgBeans() {
		return goodsImgBeans;
	}

	public GoodsBean setGoodsImgBeans(List<GoodsImgBean> goodsImgBeans) {
		this.goodsImgBeans = goodsImgBeans;
		return this;
	}

	public String getParent_name() {
		return parent_name;
	}

	public GoodsBean setParent_name(String parent_name) {
		this.parent_name = parent_name;
		return this;
	}

	public String getClass1_id() {
		return class1_id;
	}

	public GoodsBean setClass1_id(String class1_id) {
		this.class1_id = class1_id;
		return this;
	}

	public String getClass1_name() {
		return class1_name;
	}

	public GoodsBean setClass1_name(String class1_name) {
		this.class1_name = class1_name;
		return this;
	}

	public String getClass2_id() {
		return class2_id;
	}

	public GoodsBean setClass2_id(String class2_id) {
		this.class2_id = class2_id;
		return this;
	}

	public String getClass2_name() {
		return class2_name;
	}

	public GoodsBean setClass2_name(String class2_name) {
		this.class2_name = class2_name;
		return this;
	}

	public int getDay_sales() {
		return day_sales;
	}

	public GoodsBean setDay_sales(int day_sales) {
		this.day_sales = day_sales;
		return this;
	}

	public int getMonth_sales() {
		return month_sales;
	}

	public GoodsBean setMonth_sales(int month_sales) {
		this.month_sales = month_sales;
		return this;
	}

	public int getYear_sales() {
		return year_sales;
	}

	public GoodsBean setYear_sales(int year_sales) {
		this.year_sales = year_sales;
		return this;
	}

	public String getBrand_id() {
		return brand_id;
	}

	public GoodsBean setBrand_id(String brand_id) {
		this.brand_id = brand_id;
		return this;
	}

	public String getExpress_price() {
		return express_price == null || "".equals(express_price) ? "0" : express_price;
	}

	public GoodsBean setExpress_price(String express_price) {
		this.express_price = express_price == null || "".equals(express_price) ? "0" : express_price;
		return this;
	}

	public List<GoodsBean> getGoodsBeans() {
		return goodsBeans;
	}

	public GoodsBean setGoodsBeans(List<GoodsBean> goodsBeans) {
		this.goodsBeans = goodsBeans;
		return this;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public GoodsBean setGoods_id(int goods_id) {
		this.goods_id = goods_id;
		return this;
	}

	public String getMerchants_id() {
		return merchants_id;
	}

	public GoodsBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public GoodsBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}

	public String getGoods_img() {
		return goods_img;
	}

	public GoodsBean setGoods_img(String goods_img) {
		this.goods_img = goods_img;
		return this;
	}

	public String getGoods_now_price() {
		return goods_now_price;
	}

	public GoodsBean setGoods_now_price(String goods_now_price) {
		this.goods_now_price = goods_now_price;
		return this;
	}

	public String getGoods_origin_price() {
		return goods_origin_price;
	}

	public GoodsBean setGoods_origin_price(String goods_origin_price) {
		this.goods_origin_price = goods_origin_price;
		return this;
	}

	public String getGoods_grade() {
		return goods_grade;
	}

	public GoodsBean setGoods_grade(String goods_grade) {
		this.goods_grade = goods_grade;
		return this;
	}

	public String getGoods_state() {
		return goods_state;
	}

	public GoodsBean setGoods_state(String goods_state) {
		this.goods_state = goods_state;
		this.goods_state_show = "1".equals(goods_state) ? "上架中" : "已下架";
		return this;
	}

	public int getGoods_stock() {
		return goods_stock;
	}

	public GoodsBean setGoods_stock(int goods_stock) {
		this.goods_stock = goods_stock;
		return this;
	}

	public String getGoods_type() {
		return goods_type;
	}

	public GoodsBean setGoods_type(String goods_type) {
		this.goods_type = goods_type;
		return this;
	}

	public String getGoods_address() {
		return goods_address;
	}

	public GoodsBean setGoods_address(String goods_address) {
		this.goods_address = goods_address;
		return this;
	}

	public String getGoods_url() {
		return goods_url;
	}

	public GoodsBean setGoods_url(String goods_url) {
		this.goods_url = goods_url;
		return this;
	}

	public String getParent_id() {
		return parent_id;
	}

	public GoodsBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}

	public String getCreate_time() {
		return create_time;
	}

	public GoodsBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}

	public String getIs_recommend_show() {
		return is_recommend_show;
	}

	public GoodsBean setIs_recommend_show(String is_recommend_show) {
		this.is_recommend_show = is_recommend_show;
		return this;
	}

	public String getIs_recommend() {
		return is_recommend;
	}

	public GoodsBean setIs_recommend(String is_recommend) {
		this.is_recommend = is_recommend;
		this.is_recommend_show = "1".equals(is_recommend) ? "推荐" : "不推荐";
		return this;
	}

	public String getIs_give_integral() {
		return is_give_integral;
	}

	public GoodsBean setIs_give_integral(String is_give_integral) {
		this.is_give_integral = is_give_integral;
		return this;
	}

	public String getGive_integral_value() {
		return give_integral_value == null || give_integral_value.equals("") ? "0" : give_integral_value;
	}

	public GoodsBean setGive_integral_value(String give_integral_value) {
		this.give_integral_value = give_integral_value;
		return this;
	}

	public String getIs_deduct_integral() {
		return is_deduct_integral;
	}

	public GoodsBean setIs_deduct_integral(String is_deduct_integral) {
		this.is_deduct_integral = is_deduct_integral;
		return this;
	}

	public String getDeduct_integral_value() {
		return deduct_integral_value;
	}

	public GoodsBean setDeduct_integral_value(String deduct_integral_value) {
		this.deduct_integral_value = deduct_integral_value;
		return this;
	}

	public String getDeduct_integral_price() {
		return deduct_integral_price;
	}

	public GoodsBean setDeduct_integral_price(String deduct_integral_price) {
		this.deduct_integral_price = deduct_integral_price;
		return this;
	}

	public String getIs_express() {
		return is_express;
	}

	public GoodsBean setIs_express(String is_express) {
		this.is_express = is_express;
		return this;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public GoodsBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}

	public String getGoods_uuid() {
		return goods_uuid;
	}

	public GoodsBean setGoods_uuid(String goods_uuid) {
		this.goods_uuid = goods_uuid;
		return this;
	}

	public String getGoods_parent_uuid() {
		return goods_parent_uuid;
	}

	public GoodsBean setGoods_parent_uuid(String goods_parent_uuid) {
		this.goods_parent_uuid = goods_parent_uuid;
		return this;
	}

	public String getSort_time() {
		return sort_time;
	}

	public GoodsBean setSort_time(String sort_time) {
		this.sort_time = sort_time;
		return this;
	}

	public int compareTo(Object o) {
		GoodsBean sdto = (GoodsBean) o;
		float otherAge = NumberUtils.Float(sdto.getGoods_now_price());
		return this.goods_now_price.compareTo(otherAge+"");
	}

}

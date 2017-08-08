package tst.project.bean.goods;

import java.util.List;

public class ShoppingCarBean {
	private int car_id;
	private String member_id;
	private String goods_id;
	private String goods_num;
	private String is_delete;
	private String merchants_id;
	private String create_time;
	private String car_type;
	private String goods_parameters;
	private String goods_parameters_name;
	private String car_totla_price;
	private String car_total_pc_price;
	private String express_price;
	private String is_cross_border;
	private GoodsBean goodsBean;
	private List<GoodsParameterBean> goodsParameterBeans;

	
	public String getGoods_parameters_name() {
		return goods_parameters_name;
	}
	
	public ShoppingCarBean setGoods_parameters_name(String goods_parameters_name) {
		this.goods_parameters_name = goods_parameters_name;
		return this;
	}
	
	public String getExpress_price() {
		return express_price;
	}
	public ShoppingCarBean setExpress_price(String express_price) {
		this.express_price = express_price;
		return this;
	}
	public String getCar_total_pc_price() {
		return car_total_pc_price;
	}
	public ShoppingCarBean setCar_total_pc_price(String car_total_pc_price) {
		this.car_total_pc_price = car_total_pc_price;
		return this;
	}
	public String getIs_cross_border() {
		return is_cross_border;
	}
	public ShoppingCarBean setIs_cross_border(String is_cross_border) {
		this.is_cross_border = is_cross_border;
		return this;
	}
	public String getCar_totla_price() {
		return car_totla_price;
	}
	public ShoppingCarBean setCar_totla_price(String car_totla_price) {
		this.car_totla_price = car_totla_price;
		return this;
	}
	public List<GoodsParameterBean> getGoodsParameterBeans() {
		return goodsParameterBeans;
	}
	public ShoppingCarBean setGoodsParameterBeans(List<GoodsParameterBean> goodsParameterBeans) {
		this.goodsParameterBeans = goodsParameterBeans;
		return this;
	}
	public String getGoods_parameters() {
		return goods_parameters;
	}
	public ShoppingCarBean setGoods_parameters(String goods_parameters) {
		this.goods_parameters = goods_parameters;
		return this;
	}
	public String getCar_type() {
		return car_type;
	}
	public ShoppingCarBean setCar_type(String car_type) {
		this.car_type = car_type;
		return this;
	}
	public GoodsBean getGoodsBean() {
		return goodsBean;
	}
	public ShoppingCarBean setGoodsBean(GoodsBean goodsBean) {
		this.goodsBean = goodsBean;
		return this;
	}
	public int getCar_id() {
		return car_id;
	}
	public ShoppingCarBean setCar_id(int car_id) {
		this.car_id = car_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public ShoppingCarBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public ShoppingCarBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getGoods_num() {
		return goods_num;
	}
	public ShoppingCarBean setGoods_num(String goods_num) {
		this.goods_num = goods_num;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public ShoppingCarBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public ShoppingCarBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ShoppingCarBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	
}

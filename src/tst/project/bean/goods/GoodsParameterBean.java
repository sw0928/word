package tst.project.bean.goods;

import java.util.List;

public class GoodsParameterBean {
	private int parameter_id;
	private String goods_id;
	private String parameter_name;
	private String parameter_type;
	private String parent_id;
	private String parameter_price;
	private String sort;
	private String is_delete;
	private String create_time;
	private String goods_no;
	private String is_select;
	private List<GoodsParameterBean> goodsParameterBeans;


	public String getIs_select() {
		return is_select;
	}
	public GoodsParameterBean setIs_select(String is_select) {
		this.is_select = is_select;
		return this;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public GoodsParameterBean setGoods_no(String goods_no) {
		this.goods_no = goods_no;
		return this;
	}
	public List<GoodsParameterBean> getGoodsParameterBeans() {
		return goodsParameterBeans;
	}
	public GoodsParameterBean setGoodsParameterBeans(List<GoodsParameterBean> goodsParameterBeans) {
		this.goodsParameterBeans = goodsParameterBeans;
		return this;
	}
	public int getParameter_id() {
		return parameter_id;
	}
	public GoodsParameterBean setParameter_id(int parameter_id) {
		this.parameter_id = parameter_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public GoodsParameterBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getParameter_name() {
		return parameter_name;
	}
	public GoodsParameterBean setParameter_name(String parameter_name) {
		this.parameter_name = parameter_name;
		return this;
	}
	public String getParameter_type() {
		return parameter_type;
	}
	public GoodsParameterBean setParameter_type(String parameter_type) {
		this.parameter_type = parameter_type;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public GoodsParameterBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public String getParameter_price() {
		return parameter_price==null||parameter_price.equals("")?"0":parameter_price;
	}
	public GoodsParameterBean setParameter_price(String parameter_price) {
		this.parameter_price = parameter_price;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public GoodsParameterBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GoodsParameterBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GoodsParameterBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}	
	
}

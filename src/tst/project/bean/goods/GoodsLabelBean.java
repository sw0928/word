package tst.project.bean.goods;

import java.util.List;

public class GoodsLabelBean {
	private int label_id;
	private String label_name;
	private String is_delete;
	private String create_time;
	private String sort;
	private String goods_id;
	private String is_select;
	private String select_way;
	private String parent_id;
	private String goods_class_id;
	private List<GoodsLabelBean> goodsLabelBeans;	
	
	public String getGoods_class_id() {
		return goods_class_id;
	}
	public GoodsLabelBean setGoods_class_id(String goods_class_id) {
		this.goods_class_id = goods_class_id;
		return this;
	}
	public List<GoodsLabelBean> getGoodsLabelBeans() {
		return goodsLabelBeans;
	}
	public GoodsLabelBean setGoodsLabelBeans(List<GoodsLabelBean> goodsLabelBeans) {
		this.goodsLabelBeans = goodsLabelBeans;
		return this;
	}
	public String getSelect_way() {
		return select_way;
	}
	public GoodsLabelBean setSelect_way(String select_way) {
		this.select_way = select_way;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public GoodsLabelBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public String getIs_select() {
		return is_select;
	}
	public GoodsLabelBean setIs_select(String is_select) {
		this.is_select = is_select;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public GoodsLabelBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public int getLabel_id() {
		return label_id;
	}
	public GoodsLabelBean setLabel_id(int label_id) {
		this.label_id = label_id;
		return this;
	}
	public String getLabel_name() {
		return label_name;
	}
	public GoodsLabelBean setLabel_name(String label_name) {
		this.label_name = label_name;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GoodsLabelBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GoodsLabelBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public GoodsLabelBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	
}

package tst.project.bean.goods;

import java.util.List;

import tst.project.bean.activity.ActivityBean;

public class FilterBean {
	private String name;
	private String type;
	private List<ActivityBean> activityBeans;
	private List<BrandBean> brandBeans;
	private List<GoodsLabelBean> goodsLabelBeans;
	private List<StoreHouseBean> storeHouseBeans;
	
	public List<StoreHouseBean> getStoreHouseBeans() {
		return storeHouseBeans;
	}
	public FilterBean setStoreHouseBeans(List<StoreHouseBean> storeHouseBeans) {
		this.storeHouseBeans = storeHouseBeans;
		return this;
	}
	public List<GoodsLabelBean> getGoodsLabelBeans() {
		return goodsLabelBeans;
	}
	public FilterBean setGoodsLabelBeans(List<GoodsLabelBean> goodsLabelBeans) {
		this.goodsLabelBeans = goodsLabelBeans;
		return this;
	}
	public List<BrandBean> getBrandBeans() {
		return brandBeans;
	}
	public FilterBean setBrandBeans(List<BrandBean> brandBeans) {
		this.brandBeans = brandBeans;
		return this;
	}
	public String getName() {
		return name;
	}
	public FilterBean setName(String name) {
		this.name = name;
		return this;
	}
	public String getType() {
		return type;
	}
	public FilterBean setType(String type) {
		this.type = type;
		return this;
	}
	public List<ActivityBean> getActivityBeans() {
		return activityBeans;
	}
	public FilterBean setActivityBeans(List<ActivityBean> activityBeans) {
		this.activityBeans = activityBeans;
		return this;
	}
	
	
}

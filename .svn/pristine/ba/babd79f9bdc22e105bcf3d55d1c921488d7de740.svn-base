package tst.project.bean.goods;

import java.util.ArrayList;
import java.util.List;

import tst.project.bean.member.CouponBean;
import tst.project.bean.merchants.MerchantsBean;

public class ShoppingCarMerchantsBean {
	private String merchants_id;
	private String express_price;
	private MerchantsBean merchantsBean;
	private List<ShoppingCarBean> shoppingCarBeans;		
	private List<ShoppingCarBean> shoppingNoCrossBorderCarBeans;//非跨境商品	
	private List<CouponBean> couponBeans;

	public List<CouponBean> getCouponBeans() {
		return couponBeans;
	}
	public ShoppingCarMerchantsBean setCouponBeans(List<CouponBean> couponBeans) {
		this.couponBeans = couponBeans;
		return this;
	}
	public String getExpress_price() {
		return express_price;
	}
	public ShoppingCarMerchantsBean setExpress_price(String express_price) {
		this.express_price = express_price;
		return this;
	}
	public List<ShoppingCarBean> getShoppingNoCrossBorderCarBeans() {
		return shoppingNoCrossBorderCarBeans;
	}
	public ShoppingCarMerchantsBean setShoppingNoCrossBorderCarBeans(List<ShoppingCarBean> shoppingNoCrossBorderCarBeans) {
		this.shoppingNoCrossBorderCarBeans = shoppingNoCrossBorderCarBeans;
		return this;
	}
	public MerchantsBean getMerchantsBean() {
		return merchantsBean;
	}
	public ShoppingCarMerchantsBean setMerchantsBean(MerchantsBean merchantsBean) {
		this.merchantsBean = merchantsBean;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public ShoppingCarMerchantsBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public List<ShoppingCarBean> getShoppingCarBeans() {
		if(shoppingCarBeans==null){
			shoppingCarBeans=new ArrayList<ShoppingCarBean>();
		}
		return shoppingCarBeans;
	}
	public ShoppingCarMerchantsBean setShoppingCarBeans(List<ShoppingCarBean> shoppingCarBeans) {
		this.shoppingCarBeans = shoppingCarBeans;
		return this;
	}
	
	
}

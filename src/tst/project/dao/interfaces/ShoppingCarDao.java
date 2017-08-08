package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.bean.goods.ShoppingCarBean;
import tst.project.bean.goods.ShoppingCarMerchantsBean;
import tst.project.bean.member.MemberBean;
import tst.project.page.PageBean;
public interface ShoppingCarDao {
	
	/**
	 * 分享购物车
	 * @param memberBean
	 * @return
	 */
	public int shareMyShoppingCar(MemberBean memberBean);
	
	/**
	 * 添加购物车
	 * @param shoppingCarBean
	 * @return
	 */
	public int insertShoppingCar(ShoppingCarBean shoppingCarBean);
	/**
	 * 购物车详情
	 * @param shoppingCarBean
	 * @return
	 */
	public ShoppingCarBean getShoppingCarByCarId(ShoppingCarBean shoppingCarBean);
	
	/**
	 * 用户购物车商品数量
	 * @param memberBean
	 * @return
	 */
	public int getMemberShoppingCarCount(MemberBean memberBean);
	
	/**
	 * 查看该商品是否已经加过购物车
	 * @return
	 */
	public ShoppingCarBean getShoppingCarByGoodsIdAndMemberId(ShoppingCarBean shoppingCarBean);
	
	/**
	 * 获得自己的购物车列表
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public List<ShoppingCarBean> getShoppingCarB2C(ShoppingCarBean shoppingCarBean) ;
	
	/**
	 * 获得自己的购物车列表(B2B2C)
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public List<ShoppingCarMerchantsBean> getShoppingCars(ShoppingCarBean shoppingCarBean,PageBean pageBean);
	/**
	 * 获得自己的购物车列表(B2B2C)
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public List<ShoppingCarMerchantsBean> getShoppingCars(ShoppingCarBean shoppingCarBean);
		
	/**
	 * 获得自己的购物车 商家列表(B2B2C)
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public List<ShoppingCarBean> getShoppingCarsByMerchants(ShoppingCarBean shoppingCarBean);
	
	/**
	 * 删除购物车
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public int deleteShoppingCar(ShoppingCarBean shoppingCarBean) ;
	
	/**
	 * 修改购物车商品数量
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public int updateShoppingCarNum(ShoppingCarBean shoppingCarBean) ;
}

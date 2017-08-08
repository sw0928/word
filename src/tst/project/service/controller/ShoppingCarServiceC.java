package tst.project.service.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.ShoppingCarBean;
import tst.project.bean.goods.ShoppingCarMerchantsBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.dao.controller.ShoppingCarDaoC;
import tst.project.dao.interfaces.ShoppingCarDao;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = { SQLException.class })
public class ShoppingCarServiceC {
	@Resource
	ShoppingCarDaoC shoppingCarDaoC;

	@Resource
	GoodsService goodsService;

	@Resource
	MerchantsService merchantsService;
	
	/**
	 * 添加购物车
	 * 
	 * @param shoppingCarBean
	 * @return
	 * @throws Exception 
	 */
	public int insertShoppingCar(ShoppingCarBean shoppingCarBean) throws Exception {
		if(shoppingCarBean!=null){
			Map<String, Object> params = new HashMap<String, Object>(2);
			params.put("ids", shoppingCarBean.getGoods_parameters().split(","));
			List<GoodsParameterBean> parameterBeans = goodsService
					.getGoodsParameterBeansByArray(params);
			float car_total_price=0;
			for (int i = 0; i < parameterBeans.size(); i++) {
				car_total_price+=Float.valueOf(parameterBeans.get(i).getParameter_price());
			}
			
			GoodsBean goodsBean=goodsService.
					getOneGoodsDetail(new GoodsBean().setGoods_id(Integer.valueOf(shoppingCarBean.getGoods_id())));
			if(goodsBean==null){
				throw new Exception("商品已下架");
			}else{
				car_total_price+=Float.valueOf(goodsBean.getGoods_now_price());
			}
			shoppingCarBean.setCar_totla_price(car_total_price+"");
		}
		return shoppingCarDaoC.insertShoppingCar(shoppingCarBean);
	}

	/**
	 * 查看该商品是否已经加过购物车
	 * 
	 * @return
	 */
	public ShoppingCarBean getShoppingCarByGoodsIdAndMemberId(
			ShoppingCarBean shoppingCarBean) {
		ShoppingCarBean shoppingCarBean2=shoppingCarDaoC
				.getShoppingCarByGoodsIdAndMemberId(shoppingCarBean);
	
		return shoppingCarBean2;
	}
	
	
	/**
	 * 获得自己的购物车列表(B2B)
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public List<ShoppingCarBean> getShoppingCarB2C(ShoppingCarBean shoppingCarBean) {
		List<ShoppingCarBean> shoppingCarBeans=shoppingCarDaoC.getShoppingCarB2C(shoppingCarBean);
		for (int i = 0; i < shoppingCarBeans.size(); i++) {
			GoodsBean goodsBean=goodsService.getOneGoodsDetail(new GoodsBean().
					setGoods_id(Integer.valueOf(shoppingCarBeans.get(i).getGoods_id())));
			shoppingCarBeans.get(i).setGoodsBean(goodsBean);
		}
		return shoppingCarBeans;
	}
	
	/**
	 * 获得自己的购物车列表(B2B2C)
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public List<ShoppingCarMerchantsBean> getShoppingCars(ShoppingCarBean shoppingCarBean,PageBean pageBean) {
		List<ShoppingCarMerchantsBean> shoppingCarMerchantsBeans=shoppingCarDaoC.getShoppingCars(shoppingCarBean,pageBean);
		for (int i = 0; i < shoppingCarMerchantsBeans.size(); i++) {
			MerchantsBean merchantsBean=merchantsService.getOneMerchantsDetail(new MerchantsBean()
											.setMerchants_id(Integer.valueOf(shoppingCarMerchantsBeans.get(i).getMerchants_id())));
			shoppingCarMerchantsBeans.get(i).setMerchantsBean(merchantsBean);
			
			
			List<ShoppingCarBean> shoppingCarBeans=getShoppingCarsByMerchants(shoppingCarBean.
															setMerchants_id(shoppingCarMerchantsBeans.get(i).getMerchants_id()));
	
		
			
			shoppingCarMerchantsBeans.get(i).setShoppingCarBeans(shoppingCarBeans);
		}
		return shoppingCarMerchantsBeans;
	}
		
	public List<ShoppingCarMerchantsBean> getShoppingCarsWithCarids(ShoppingCarBean shoppingCarBean,String[] car_ids){
		List<ShoppingCarMerchantsBean> shoppingCarMerchantsBeansTemp=new ArrayList<ShoppingCarMerchantsBean>();
		
		List<ShoppingCarMerchantsBean> shoppingCarMerchantsBeans=shoppingCarDaoC.getShoppingCars(shoppingCarBean);
		for (int i = 0; i < shoppingCarMerchantsBeans.size(); i++) {
			List<ShoppingCarBean> shoppingCarBeansTemp=new ArrayList<ShoppingCarBean>();
			List<ShoppingCarBean> shoppingCarBeans=getShoppingCarsByMerchants(shoppingCarBean.
															setMerchants_id(shoppingCarMerchantsBeans.get(i).getMerchants_id()));
			boolean is_hava=false;
			for (int j = 0; j < car_ids.length; j++) {
				for (int l = 0; l < shoppingCarBeans.size(); l++) {
					if(car_ids[j].equals(shoppingCarBeans.get(l).getCar_id()+"")){
						is_hava=true;
						shoppingCarBeansTemp.add(shoppingCarBeans.get(l));
					}
				}	
			}
			shoppingCarMerchantsBeans.get(i).setShoppingCarBeans(shoppingCarBeansTemp);
			if(is_hava){
				shoppingCarMerchantsBeansTemp.add(shoppingCarMerchantsBeans.get(i));				
			}
		}
		
		return shoppingCarMerchantsBeansTemp;
	}

	/**
	 * 获得自己的购物车 商家列表(B2B2C)
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public List<ShoppingCarBean> getShoppingCarsByMerchants(ShoppingCarBean shoppingCarBean){
		List<ShoppingCarBean> shoppingCarBeans=shoppingCarDaoC.getShoppingCarsByMerchants(shoppingCarBean);
		
		for (int i = 0; i < shoppingCarBeans.size(); i++) {
			GoodsBean goodsBean=goodsService.getOneGoodsDetail(new GoodsBean().
					setGoods_id(Integer.valueOf(shoppingCarBeans.get(i).getGoods_id())));
			shoppingCarBeans.get(i).setGoodsBean(goodsBean);
			
			if (shoppingCarBeans.get(i).getGoods_parameters() != null) {
				Map<String, Object> params = new HashMap<String, Object>(2);
				params.put("ids", shoppingCarBeans.get(i)
						.getGoods_parameters().split(","));
				List<GoodsParameterBean> parameterBeans = goodsService
						.getGoodsParameterBeansByArray(params);
				shoppingCarBeans.get(i).setGoodsParameterBeans(parameterBeans);
			}	
		}
		return shoppingCarBeans;
	}
	/**
	 * 获得自己的购物车 商家列表(B2B2C)
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public List<ShoppingCarBean> getShoppingCarsByMerchants(ShoppingCarBean shoppingCarBean,PageBean pageBean){
		List<ShoppingCarBean> shoppingCarBeans=shoppingCarDaoC.getShoppingCarsByMerchants(shoppingCarBean,pageBean);
		
		for (int i = 0; i < shoppingCarBeans.size(); i++) {
			GoodsBean goodsBean=goodsService.getOneGoodsDetail(new GoodsBean().
					setGoods_id(Integer.valueOf(shoppingCarBeans.get(i).getGoods_id())));
			shoppingCarBeans.get(i).setGoodsBean(goodsBean);
			
			if (shoppingCarBeans.get(i).getGoods_parameters() != null) {
				Map<String, Object> params = new HashMap<String, Object>(2);
				params.put("ids", shoppingCarBeans.get(i)
						.getGoods_parameters().split(","));
				List<GoodsParameterBean> parameterBeans = goodsService
						.getGoodsParameterBeansByArray(params);
				shoppingCarBeans.get(i).setGoodsParameterBeans(parameterBeans);
			}	
		}
		return shoppingCarBeans;
	}
	/**
	 * 删除购物车
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public int deleteShoppingCar(ShoppingCarBean shoppingCarBean) {
		return shoppingCarDaoC.deleteShoppingCar(shoppingCarBean);
	}

	public int deleteShoppingCars(String[] car_ids,MemberBean memberBen) throws Exception{
		for (int i = 0; i < car_ids.length; i++) {
			int num=shoppingCarDaoC.deleteShoppingCar(new ShoppingCarBean().
							setCar_id(Integer.valueOf(car_ids[i])).
							setMember_id(memberBen.getMember_id()+""));	
			if(num<=0){
				throw new Exception("删除失败");
			}
		}
		return 1;
	}
	/**
	 * 修改购物车商品数量
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public int updateShoppingCarNum(ShoppingCarBean shoppingCarBean) {
		return shoppingCarDaoC.updateShoppingCarNum(shoppingCarBean);
	}
}

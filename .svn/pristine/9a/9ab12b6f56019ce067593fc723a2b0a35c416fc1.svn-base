package tst.project.service.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.activity.ActivityBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.ShoppingCarBean;
import tst.project.bean.goods.ShoppingCarMerchantsBean;
import tst.project.bean.member.CouponBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.dao.interfaces.ShoppingCarDao;
import tst.project.page.PageBean;
import tst.project.utils.NumberUtils;

@Service
@Transactional(rollbackFor = { SQLException.class })
public class ShoppingCarService {
	@Resource
	ShoppingCarDao shoppingCarDao;

	@Resource
	GoodsServiceI goodsServiceI;

	@Resource
	MerchantsServiceI merchantsServiceI;

	@Resource
	ActivityService activityService;
	
	@Resource
	CouponService couponService;
	
	/**
	 * 添加购物车
	 * 
	 * @param shoppingCarBean
	 * @return
	 * @throws Exception
	 */
	public int insertShoppingCar(ShoppingCarBean shoppingCarBean) throws Exception {
		if (shoppingCarBean != null) {
//			Map<String, Object> params = new HashMap<String, Object>(2);
//			params.put("ids", shoppingCarBean.getGoods_parameters().split(","));
//			List<GoodsParameterBean> parameterBeans = goodsServiceI.getGoodsParameterBeansByArray(params);
//			float car_total_price = 0;
//			for (int i = 0; i < parameterBeans.size(); i++) {
//				car_total_price += Float.valueOf(parameterBeans.get(i).getParameter_price());
//			}

			GoodsBean goodsBean = goodsServiceI
					.getOneGoodsDetail(new GoodsBean().setGoods_id(Integer.valueOf(shoppingCarBean.getGoods_id())));
			if (goodsBean == null) {
				throw new Exception("商品已下架");
			} else {
				//car_total_price += Float.valueOf(goodsBean.getGoods_now_price());
			}
			//shoppingCarBean.setCar_totla_price(car_total_price + "");
		}
		return shoppingCarDao.insertShoppingCar(shoppingCarBean);
	}

	/**
	 * 用户购物车商品
	 * 
	 * @param memberBean
	 * @return
	 */
	public int getMemberShoppingCarCount(MemberBean memberBean) {
		return shoppingCarDao.getMemberShoppingCarCount(memberBean);
	}

	/**
	 * 查看该商品是否已经加过购物车
	 * 
	 * @return
	 */
	public ShoppingCarBean getShoppingCarByGoodsIdAndMemberId(ShoppingCarBean shoppingCarBean) {
		ShoppingCarBean shoppingCarBean2 = shoppingCarDao.getShoppingCarByGoodsIdAndMemberId(shoppingCarBean);

		return shoppingCarBean2;
	}
	
	/**
	 * 购物车详情
	 * @param shoppingCarBean
	 * @return
	 */
	public ShoppingCarBean getShoppingCarByCarId(ShoppingCarBean shoppingCarBean){
		return shoppingCarDao.getShoppingCarByCarId(shoppingCarBean);
	}

	/**
	 * 获得自己的购物车列表(B2B)
	 * 
	 * @param shoppingCarBean
	 * @return
	 */
	public List<ShoppingCarBean> getShoppingCarB2C(ShoppingCarBean shoppingCarBean) {
		List<ShoppingCarBean> shoppingCarBeans = shoppingCarDao.getShoppingCarB2C(shoppingCarBean);
		for (int i = 0; i < shoppingCarBeans.size(); i++) {

			GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
					new GoodsBean().setGoods_id(Integer.valueOf(shoppingCarBeans.get(i).getGoods_id())));
			shoppingCarBeans.get(i).setGoodsBean(goodsBean);
		}
		return shoppingCarBeans;
	}

	/**
	 * 获得自己的购物车列表(B2B2C)
	 * 
	 * @param shoppingCarBean
	 * @return
	 * @throws Exception 
	 */
	public List<ShoppingCarMerchantsBean> getShoppingCars(ShoppingCarBean shoppingCarBean, PageBean pageBean) throws Exception {
		List<ShoppingCarMerchantsBean> shoppingCarMerchantsBeans = shoppingCarDao.getShoppingCars(shoppingCarBean,
				pageBean);
		for (int i = 0; i < shoppingCarMerchantsBeans.size(); i++) {
			if (shoppingCarMerchantsBeans.get(i).getMerchants_id() != null
					&& !shoppingCarMerchantsBeans.get(i).getMerchants_id().equals("")) {
				
				List<CouponBean> couponBeans=couponService
						.getReceiceCoupons(new CouponBean().setMember_id(shoppingCarBean.getMember_id())
								.setMerchants_id(shoppingCarMerchantsBeans.get(i).getMerchants_id()));
				
				shoppingCarMerchantsBeans.get(i).setCouponBeans(couponBeans);
				
				MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(new MerchantsBean()
						.setMerchants_id(Integer.valueOf(shoppingCarMerchantsBeans.get(i).getMerchants_id())));
				shoppingCarMerchantsBeans.get(i).setMerchantsBean(merchantsBean);
				
				List<ShoppingCarBean> shoppingCarBeans = getShoppingCarsByMerchants(
						shoppingCarBean.setMerchants_id(shoppingCarMerchantsBeans.get(i).getMerchants_id()));
				for (int j = 0; j < shoppingCarBeans.size(); j++) {
					float car_total_price = 0;
					float car_total_pc_price = 0;
					
					if (shoppingCarBeans.get(j).getGoods_parameters() != null) {
						Map<String, Object> params = new HashMap<String, Object>(2);
						params.put("ids", shoppingCarBeans.get(j).getGoods_parameters().split(","));
						List<GoodsParameterBean> parameterBeans = goodsServiceI.getGoodsParameterBeansByArray(params);
						shoppingCarBeans.get(j).setGoodsParameterBeans(parameterBeans);
						
						String goods_parameters_name="";
						for (int h = 0; h < parameterBeans.size(); h++) {
							goods_parameters_name+=parameterBeans.get(h).getParameter_name();
							if(h<parameterBeans.size()-1){
								goods_parameters_name+=",";
							}
							car_total_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
							car_total_pc_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
						}
						shoppingCarBeans.get(j).setGoods_parameters_name(goods_parameters_name);
					}
							
					GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
							new GoodsBean().setGoods_id(Integer.valueOf(shoppingCarBeans.get(j).getGoods_id())));
					
					if (goodsBean == null) {
						throw new Exception("商品已下架");
					} else {
						car_total_price += NumberUtils.Float(goodsBean.getGoods_now_price());
						car_total_pc_price+=NumberUtils.Float(goodsBean.getGoods_pc_price());
					}
					shoppingCarBeans.get(j).setCar_totla_price(car_total_price + "");
					shoppingCarBeans.get(j).setCar_total_pc_price(car_total_pc_price+"");
					shoppingCarBeans.get(j).setGoodsBean(goodsBean);		
				}
				shoppingCarMerchantsBeans.get(i).setShoppingCarBeans(shoppingCarBeans);
			}
		}
		return shoppingCarMerchantsBeans;
	}
	
	/**
	 * 获得自己的购物车列表(B2B2C)
	 * 
	 * @param shoppingCarBean
	 * @return
	 * @throws Exception 
	 */
	public List<ShoppingCarMerchantsBean> getShoppingCarsHBR(ShoppingCarBean shoppingCarBean, PageBean pageBean) throws Exception {
		List<ShoppingCarMerchantsBean> shoppingCarMerchantsBeans = shoppingCarDao.getShoppingCars(shoppingCarBean,pageBean);
		for (int i = 0; i < shoppingCarMerchantsBeans.size(); i++) {
			if (shoppingCarMerchantsBeans.get(i).getMerchants_id() != null
					&& !shoppingCarMerchantsBeans.get(i).getMerchants_id().equals("")) {
				MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(new MerchantsBean()
						.setMerchants_id(Integer.valueOf(shoppingCarMerchantsBeans.get(i).getMerchants_id())));
				shoppingCarMerchantsBeans.get(i).setMerchantsBean(merchantsBean);
				
				
				List<ShoppingCarBean> shoppingCarBeansNoCrossBorder = getShoppingCarsByMerchants(
						shoppingCarBean.setMerchants_id(shoppingCarMerchantsBeans.get(i).getMerchants_id())
						.setIs_cross_border("0"));
				for (int j = 0; j < shoppingCarBeansNoCrossBorder.size(); j++) {
					
					float car_total_price = 0;
					float car_total_pc_price = 0;
					
					if (shoppingCarBeansNoCrossBorder.get(j).getGoods_parameters() != null) {
						Map<String, Object> params = new HashMap<String, Object>(2);
						params.put("ids", shoppingCarBeansNoCrossBorder.get(j).getGoods_parameters().split(","));
						List<GoodsParameterBean> parameterBeans = goodsServiceI.getGoodsParameterBeansByArray(params);
						shoppingCarBeansNoCrossBorder.get(j).setGoodsParameterBeans(parameterBeans);
						
						String goods_parameters_name="";
						for (int h = 0; h < parameterBeans.size(); h++) {
							goods_parameters_name+=parameterBeans.get(h).getParameter_name();
							if(h<parameterBeans.size()-1){
								goods_parameters_name+=",";
							}
							car_total_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
							car_total_pc_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
						}
						shoppingCarBeansNoCrossBorder.get(j).setGoods_parameters_name(goods_parameters_name);
					}
							
					GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
							new GoodsBean().setGoods_id(Integer.valueOf(shoppingCarBeansNoCrossBorder.get(j).getGoods_id())));
					
					if (goodsBean == null) {
						throw new Exception("商品已下架");
					} else {
						car_total_price += NumberUtils.Float(goodsBean.getGoods_now_price());
						car_total_pc_price+=NumberUtils.Float(goodsBean.getGoods_pc_price());
					}
					shoppingCarBeansNoCrossBorder.get(j).setCar_totla_price(car_total_price + "");
					shoppingCarBeansNoCrossBorder.get(j).setCar_total_pc_price(car_total_pc_price+"");
					shoppingCarBeansNoCrossBorder.get(j).setGoodsBean(goodsBean);		
				}
				shoppingCarMerchantsBeans.get(i).setShoppingNoCrossBorderCarBeans(shoppingCarBeansNoCrossBorder);		
				
				List<ShoppingCarBean> shoppingCarBeans = getShoppingCarsByMerchants(
						shoppingCarBean.setMerchants_id(shoppingCarMerchantsBeans.get(i).getMerchants_id())
						.setIs_cross_border("1"));
				for (int j = 0; j < shoppingCarBeans.size(); j++) {
					if (shoppingCarBeans.get(j).getGoods_parameters() != null) {
						Map<String, Object> params = new HashMap<String, Object>(2);
						params.put("ids", shoppingCarBeans.get(j).getGoods_parameters().split(","));
						List<GoodsParameterBean> parameterBeans = goodsServiceI.getGoodsParameterBeansByArray(params);
						shoppingCarBeans.get(j).setGoodsParameterBeans(parameterBeans);
					}
					
					float car_total_price = 0;
					float car_total_pc_price = 0;
					
					if (shoppingCarBeans.get(j).getGoods_parameters() != null) {
						Map<String, Object> params = new HashMap<String, Object>(2);
						params.put("ids", shoppingCarBeans.get(j).getGoods_parameters().split(","));
						List<GoodsParameterBean> parameterBeans = goodsServiceI.getGoodsParameterBeansByArray(params);
						shoppingCarBeans.get(j).setGoodsParameterBeans(parameterBeans);
						
						String goods_parameters_name="";
						for (int h = 0; h < parameterBeans.size(); h++) {
							goods_parameters_name+=parameterBeans.get(h).getParameter_name();
							if(h<parameterBeans.size()-1){
								goods_parameters_name+=",";
							}
							car_total_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
							car_total_pc_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
						}
						shoppingCarBeans.get(j).setGoods_parameters_name(goods_parameters_name);
					}
							
					GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
							new GoodsBean().setGoods_id(Integer.valueOf(shoppingCarBeans.get(j).getGoods_id())));
					
					if (goodsBean == null) {
						throw new Exception("商品已下架");
					} else {
						car_total_price += NumberUtils.Float(goodsBean.getGoods_now_price());
						car_total_pc_price+=NumberUtils.Float(goodsBean.getGoods_pc_price());
					}
					shoppingCarBeans.get(j).setCar_totla_price(car_total_price + "");
					shoppingCarBeans.get(j).setCar_total_pc_price(car_total_pc_price+"");
					shoppingCarBeans.get(j).setGoodsBean(goodsBean);	
					
				}
				
				shoppingCarMerchantsBeans.get(i).setShoppingCarBeans(shoppingCarBeans);

			}
		}
		return shoppingCarMerchantsBeans;
	}
	

	public List<ShoppingCarMerchantsBean> getShoppingCarsWithCarids(ShoppingCarBean shoppingCarBean, String[] car_ids) throws Exception {
		List<ShoppingCarMerchantsBean> shoppingCarMerchantsBeansTemp = new ArrayList<ShoppingCarMerchantsBean>();

		List<ShoppingCarMerchantsBean> shoppingCarMerchantsBeans = shoppingCarDao.getShoppingCars(shoppingCarBean);
		for (int i = 0; i < shoppingCarMerchantsBeans.size(); i++) {		
			List<ShoppingCarBean> shoppingCarBeansTemp = new ArrayList<ShoppingCarBean>();
			
			MerchantsBean merchantsBean=merchantsServiceI
					.getOneMerchantsDetail(new MerchantsBean().setMerchants_id(NumberUtils.Integer(shoppingCarMerchantsBeans.get(i).getMerchants_id())));
			List<ShoppingCarBean> shoppingCarBeans =
					getShoppingCarsByMerchants(shoppingCarBean.setMerchants_id(shoppingCarMerchantsBeans.get(i).getMerchants_id()));
			boolean is_hava = false;
			for (int j = 0; j < car_ids.length; j++) {
				for (int l = 0; l < shoppingCarBeans.size(); l++) {
					if (car_ids[j].equals(shoppingCarBeans.get(l).getCar_id() + "")) {
						is_hava = true;
						shoppingCarBeansTemp.add(shoppingCarBeans.get(l));
					}
				}
			}
			
			float express_price=0;
			for (int j = 0; j < shoppingCarBeansTemp.size(); j++) {
				float car_total_price = 0;
				float car_total_pc_price = 0;
				if (shoppingCarBeansTemp.get(j).getGoods_parameters() != null) {
					Map<String, Object> params = new HashMap<String, Object>(2);
					params.put("ids", shoppingCarBeansTemp.get(j).getGoods_parameters().split(","));

					List<GoodsParameterBean> parameterBeans = goodsServiceI.getGoodsParameterBeansByArray(params);
					shoppingCarBeansTemp.get(j).setGoodsParameterBeans(parameterBeans);
					
					for (int h = 0; h < parameterBeans.size(); h++) {
						car_total_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
						car_total_pc_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
					}
				}

				GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
						new GoodsBean().setGoods_id(Integer.valueOf(shoppingCarBeansTemp.get(j).getGoods_id())));
				
				if (goodsBean == null) {
					throw new Exception("商品已下架");
				} else {
					car_total_price += NumberUtils.Float(goodsBean.getGoods_now_price());
					car_total_pc_price+=NumberUtils.Float(goodsBean.getGoods_pc_price());
					if(!"1".equals(goodsBean.getIs_express())){
						if(merchantsBean==null){
							throw new Exception("该商家已不存在");
						}
						if(car_total_pc_price<NumberUtils.Float(merchantsBean.getExpress_free_price())){
							express_price+=NumberUtils.Float(goodsBean.getExpress_price());
						}
					}
				}
				
				List<ActivityBean> activityBeans = activityService.getGoodsActivity(
						new ActivityBean().setGoods_id(goodsBean.getGoods_id()));// 商品参加的活动列表

				ActivityBean activityBean = null;
				if (activityBeans != null) {
					for (int l = 0; l < activityBeans.size(); l++) {// 一个商品
																	// 只能参加一个活动
						ActivityBean activityBean2 = activityBeans.get(l);
						if (activityBean == null) {
							if ("give".equals(activityBean2.getActivity_type())
									&& NumberUtils.Integer(shoppingCarBeansTemp.get(j).getGoods_num()) >= activityBean2.getGiveBean().getGive_need_count()) {
								activityBean = activityBean2;
							} else if ("reduce".equals(activityBean2.getActivity_type())
									&& car_total_pc_price >= activityBean2.getReduceBean()
											.getReduce_need_price()) {
								activityBean = activityBean2;
							} else if ("gift".equals(activityBean2.getActivity_type())
									&& car_total_pc_price >= activityBean2.getGiftBean().getGift_need_price()) {
								activityBean = activityBean2;
							}
						} else if ("give".equals(activityBean2.getActivity_type())) {
							if (activityBean2.getGiveBean() != null
									&& activityBean2.getGiveBean().getGive_need_count() > activityBean
											.getGiveBean().getGive_need_count()
									&& NumberUtils.Integer(shoppingCarBeansTemp.get(j).getGoods_num()) >= activityBean2.getGiveBean()
											.getGive_need_count()) {
								activityBean = activityBean2;
							}
						} else if ("reduce".equals(activityBean2.getActivity_type())) {
							if (activityBean2.getReduceBean() != null
									&& activityBean2.getReduceBean().getReduce_need_price() > activityBean
											.getReduceBean().getReduce_need_price()
									&& car_total_pc_price >= activityBean2.getReduceBean()
											.getReduce_need_price()) {
								activityBean = activityBean2;
							}
						} else if ("gift".equals(activityBean2.getActivity_type())) {
							if (activityBean2.getGiftBean() != null
									&& activityBean2.getGiftBean().getGift_need_price() > activityBean
											.getGiftBean().getGift_need_price()
									&& car_total_pc_price >= activityBean2.getGiftBean().getGift_need_price()) {
								activityBean = activityBean2;
							}
						}
					}
				}

				goodsBean.setActivityBean(activityBean);
				
				shoppingCarBeansTemp.get(j).setCar_totla_price(car_total_price + "");
				shoppingCarBeansTemp.get(j).setCar_total_pc_price(car_total_pc_price+"");
				shoppingCarBeansTemp.get(j).setGoodsBean(goodsBean);
			}
			shoppingCarMerchantsBeans.get(i).setExpress_price(express_price+"");
			shoppingCarMerchantsBeans.get(i).setShoppingCarBeans(shoppingCarBeansTemp);
			if (is_hava) {
				shoppingCarMerchantsBeans.get(i).setMerchantsBean(merchantsBean);
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
	public List<ShoppingCarBean> getShoppingCarsByMerchants(ShoppingCarBean shoppingCarBean) {
		List<ShoppingCarBean> shoppingCarBeans = shoppingCarDao.getShoppingCarsByMerchants(shoppingCarBean);
		for (int i = 0; i < shoppingCarBeans.size(); i++) {
			GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
					new GoodsBean().setGoods_id(Integer.valueOf(shoppingCarBeans.get(i).getGoods_id())));
			shoppingCarBeans.get(i).setGoodsBean(goodsBean);
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
		return shoppingCarDao.deleteShoppingCar(shoppingCarBean);
	}

	public int deleteShoppingCars(String[] car_ids, MemberBean memberBen) throws Exception {
		for (int i = 0; i < car_ids.length; i++) {
			int num = shoppingCarDao.deleteShoppingCar(new ShoppingCarBean().setCar_id(Integer.valueOf(car_ids[i]))
					.setMember_id(memberBen.getMember_id() + ""));
			if (num <= 0) {
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
		return shoppingCarDao.updateShoppingCarNum(shoppingCarBean);
	}
	
	/**
	 * 修改购物车商品数量
	 * 
	 * @param shoppingCarBean
	 * @return
	 * @throws Exception 
	 */
	public int updateShoppingCarNums(List<ShoppingCarBean> shoppingCarBeans,MemberBean memberBean) throws Exception {
		if(shoppingCarBeans!=null){
			for (int i = 0; i < shoppingCarBeans.size(); i++) {
				ShoppingCarBean shoppingCarBean=shoppingCarBeans.get(i);
				int num=shoppingCarDao.updateShoppingCarNum(shoppingCarBean.setMember_id(memberBean.getMember_id()+""));
				if(num<=0){
					throw new Exception("修改失败");
				}
			}
		}
		return 1;
	}
}

package tst.project.service.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSException;

import sun.print.resources.serviceui;
import tst.project.bean.activity.ActivityBean;
import tst.project.bean.activity.AlbumBean;
import tst.project.bean.activity.NewsBean;
import tst.project.bean.banner.ClassBannerBean;
import tst.project.bean.goods.BrandBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.ShoppingCarBean;
import tst.project.bean.goods.ShoppingCarMemberBean;
import tst.project.bean.goods.ShoppingCarMerchantsBean;
import tst.project.bean.goods.ShoppingCarShareBean;
import tst.project.bean.home.HomeGoodsBean;
import tst.project.bean.home.LabelBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.merchants.TrustBean;
import tst.project.bean.merchants.TrustItemBean;
import tst.project.bean.order.OrderSWBean;
import tst.project.bean.others.CodeBean;
import tst.project.dao.interfaces.SWDao;
import tst.project.page.PageBean;
import tst.project.utils.NumberUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class SWService {
	@Resource
	SWDao swDao;

	@Resource
	ShoppingCarService shoppingCarService;

	@Resource
	CodeService codeService;

	@Resource
	GoodsServiceI goodsServiceI;

	@Resource
	MerchantsServiceI merchantsServiceI;

	@Resource
	MemberService memberService;

	@Resource
	ActivityService activityService;

	public List<Map> getShoppingCarWithShare(ShoppingCarMemberBean shoppingCarMemberBean)
			throws Exception {
		List<Map> maps = swDao.getShareMerchantsShoppingCar(
				new ShoppingCarShareBean().setMember_car_id(shoppingCarMemberBean.getMember_car_id() + ""));
		if (maps != null) {
			for (int j = 0; j < maps.size(); j++) {
				Map map = maps.get(j);

				MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
						new MerchantsBean().setMerchants_id(Integer.valueOf(map.get("merchants_id").toString())));
				map.put("merchantsBean", merchantsBean);

				List<ShoppingCarShareBean> shoppingCarShareBeans = swDao.getShareMemberShoppingCar(
						new ShoppingCarShareBean().setMember_car_id(shoppingCarMemberBean.getMember_car_id() + "")
								.setMerchants_id(map.get("merchants_id").toString()));
				if (shoppingCarShareBeans != null) {
					float express_price=0;
					for (int k = 0; k < shoppingCarShareBeans.size(); k++) {
						ShoppingCarShareBean shareBean = shoppingCarShareBeans.get(k);

						float car_total_price = 0;
						float car_total_pc_price = 0;

						if (shareBean.getGoods_parameters() != null) {
							Map<String, Object> params = new HashMap<String, Object>(2);
							params.put("ids", shareBean.getGoods_parameters().split(","));
							List<GoodsParameterBean> parameterBeans = goodsServiceI
									.getGoodsParameterBeansByArray(params);
							shareBean.setGoodsParameterBeans(parameterBeans);

							String goods_parameters_name = "";
							for (int h = 0; h < parameterBeans.size(); h++) {
								goods_parameters_name += parameterBeans.get(h).getParameter_name();
								if (h < parameterBeans.size() - 1) {
									goods_parameters_name += ",";
								}
								car_total_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
								car_total_pc_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
							}
							shareBean.setGoods_parameters_name(goods_parameters_name);
						}

						GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
								new GoodsBean().setGoods_id(Integer.valueOf(shareBean.getGoods_id())));

						if (goodsBean == null) {
							// throw new Exception("商品已下架");
						} else {
							car_total_price += NumberUtils.Float(goodsBean.getGoods_now_price());
							car_total_pc_price += NumberUtils.Float(goodsBean.getGoods_pc_price());
							if(!"1".equals(goodsBean.getIs_express())){
								if(merchantsBean==null){
									throw new Exception("该商家已不存在");
								}
								if(car_total_pc_price<NumberUtils.Float(merchantsBean.getExpress_free_price())){
									express_price+=NumberUtils.Float(goodsBean.getExpress_price());
								}
							}
						}
						shareBean.setCar_totla_price(car_total_price + "");
						shareBean.setCar_total_pc_price(car_total_pc_price + "");
						shareBean.setGoodsBean(goodsBean);
					}
					map.put("express_price",express_price+"");
				}
				map.put("shoppingCarBeans", shoppingCarShareBeans);
			}
		}

		return maps;
	}

	/**
	 * 修改分享出去的购物车数量
	 * 
	 * @return
	 */
	public int updateShareShoppingCarNum(ShoppingCarShareBean shoppingCarShareBean) {
		return swDao.updateShareShoppingCarNum(shoppingCarShareBean);
	}

	/**
	 * 修改分享出去的购物车数量
	 * 
	 * @return
	 */
	public int updateShareShoppingCarNumV2(ShoppingCarShareBean shoppingCarShareBean) {
		return swDao.updateShareShoppingCarNumV2(shoppingCarShareBean);
	}

	/**
	 * 删除分享出去的购物车
	 * 
	 * @return
	 */
	public int deleteShareShoppingCar(ShoppingCarShareBean shoppingCarShareBean) {
		return swDao.deleteShareShoppingCar(shoppingCarShareBean);
	}

	/**
	 * 获得被分享进来的购物车列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ShoppingCarMemberBean> getShareOutShoppingCar(ShoppingCarMemberBean shoppingCarMemberBean,
			PageBean pageBean) throws Exception {
		List<ShoppingCarMemberBean> shoppingCarMemberBeans = swDao.getShareOutShoppingCar(shoppingCarMemberBean,
				pageBean);
		if (shoppingCarMemberBeans != null) {
			for (int i = 0; i < shoppingCarMemberBeans.size(); i++) {
				ShoppingCarMemberBean shoppingCarMemberBean2 = shoppingCarMemberBeans.get(i);

				MemberBean memberBean = memberService.getMemberByID(
						new MemberBean().setMember_id(NumberUtils.Integer(shoppingCarMemberBean2.getMember_id())));
				shoppingCarMemberBean2.setMemberBean(memberBean);

				List<Map> maps = swDao.getShareMerchantsShoppingCar(
						new ShoppingCarShareBean().setMember_car_id(shoppingCarMemberBean2.getMember_car_id() + ""));
				if (maps != null) {
					for (int j = 0; j < maps.size(); j++) {
						Map map = maps.get(j);

						MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(new MerchantsBean()
								.setMerchants_id(Integer.valueOf(map.get("merchants_id").toString())));
						map.put("merchantsBean", merchantsBean);

						List<ShoppingCarShareBean> shoppingCarShareBeans = swDao
								.getShareMemberShoppingCar(new ShoppingCarShareBean()
										.setMember_car_id(shoppingCarMemberBean2.getMember_car_id() + "")
										.setMerchants_id(map.get("merchants_id").toString()));
						if (shoppingCarShareBeans != null) {
							for (int k = 0; k < shoppingCarShareBeans.size(); k++) {
								ShoppingCarShareBean shareBean = shoppingCarShareBeans.get(k);

								float car_total_price = 0;
								float car_total_pc_price = 0;

								if (shareBean.getGoods_parameters() != null) {
									Map<String, Object> params = new HashMap<String, Object>(2);
									params.put("ids", shareBean.getGoods_parameters().split(","));
									List<GoodsParameterBean> parameterBeans = goodsServiceI
											.getGoodsParameterBeansByArray(params);
									shareBean.setGoodsParameterBeans(parameterBeans);

									String goods_parameters_name = "";
									for (int h = 0; h < parameterBeans.size(); h++) {
										goods_parameters_name += parameterBeans.get(h).getParameter_name();
										if (h < parameterBeans.size() - 1) {
											goods_parameters_name += ",";
										}
										car_total_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
										car_total_pc_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
									}
									shareBean.setGoods_parameters_name(goods_parameters_name);
								}

								GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
										new GoodsBean().setGoods_id(Integer.valueOf(shareBean.getGoods_id())));

								if (goodsBean == null) {
									// throw new Exception("商品已下架");
								} else {
									car_total_price += NumberUtils.Float(goodsBean.getGoods_now_price());
									car_total_pc_price += NumberUtils.Float(goodsBean.getGoods_pc_price());
								}
								shareBean.setCar_totla_price(car_total_price + "");
								shareBean.setCar_total_pc_price(car_total_pc_price + "");
								shareBean.setGoodsBean(goodsBean);
							}
						}
						map.put("shoppingCarBeans", shoppingCarShareBeans);
					}
				}

				shoppingCarMemberBean2.setShoppingCarShareBeans(maps);
			}
		}
		return shoppingCarMemberBeans;
	}

	/**
	 * 获得分享出去的购物车列表
	 * 
	 * @return
	 */
	public List<ShoppingCarMemberBean> getShareIngShoppingCar(ShoppingCarMemberBean shoppingCarMemberBean,
			PageBean pageBean) {
		List<ShoppingCarMemberBean> shoppingCarMemberBeans = swDao.getShareIngShoppingCar(shoppingCarMemberBean,
				pageBean);
		if (shoppingCarMemberBeans != null) {
			for (int i = 0; i < shoppingCarMemberBeans.size(); i++) {
				ShoppingCarMemberBean shoppingCarMemberBean2 = shoppingCarMemberBeans.get(i);

				MemberBean memberBean = memberService.getMemberByID(
						new MemberBean().setMember_id(NumberUtils.Integer(shoppingCarMemberBean2.getUser_id())));
				shoppingCarMemberBean2.setMemberBean(memberBean);

				List<Map> maps = swDao.getShareMerchantsShoppingCar(
						new ShoppingCarShareBean().setMember_car_id(shoppingCarMemberBean2.getMember_car_id() + ""));
				if (maps != null) {
					for (int j = 0; j < maps.size(); j++) {
						Map map = maps.get(j);

						MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(new MerchantsBean()
								.setMerchants_id(Integer.valueOf(map.get("merchants_id").toString())));
						map.put("merchantsBean", merchantsBean);

						List<ShoppingCarShareBean> shoppingCarShareBeans = swDao
								.getShareMemberShoppingCar(new ShoppingCarShareBean()
										.setMember_car_id(shoppingCarMemberBean2.getMember_car_id() + "")
										.setMerchants_id(map.get("merchants_id").toString()));
						if (shoppingCarShareBeans != null) {
							for (int k = 0; k < shoppingCarShareBeans.size(); k++) {
								ShoppingCarShareBean shareBean = shoppingCarShareBeans.get(k);

								float car_total_price = 0;
								float car_total_pc_price = 0;

								if (shareBean.getGoods_parameters() != null) {
									Map<String, Object> params = new HashMap<String, Object>(2);
									params.put("ids", shareBean.getGoods_parameters().split(","));
									List<GoodsParameterBean> parameterBeans = goodsServiceI
											.getGoodsParameterBeansByArray(params);
									shareBean.setGoodsParameterBeans(parameterBeans);

									String goods_parameters_name = "";
									for (int h = 0; h < parameterBeans.size(); h++) {
										goods_parameters_name += parameterBeans.get(h).getParameter_name();
										if (h < parameterBeans.size() - 1) {
											goods_parameters_name += ",";
										}
										car_total_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
										car_total_pc_price += Float.valueOf(parameterBeans.get(h).getParameter_price());
									}
									shareBean.setGoods_parameters_name(goods_parameters_name);
								}

								GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
										new GoodsBean().setGoods_id(Integer.valueOf(shareBean.getGoods_id())));

								if (goodsBean == null) {
									// throw new Exception("商品已下架");
								} else {
									car_total_price += NumberUtils.Float(goodsBean.getGoods_now_price());
									car_total_pc_price += NumberUtils.Float(goodsBean.getGoods_pc_price());
								}
								shareBean.setCar_totla_price(car_total_price + "");
								shareBean.setCar_total_pc_price(car_total_pc_price + "");
								shareBean.setGoodsBean(goodsBean);
							}
						}
						map.put("shoppingCarBeans", shoppingCarShareBeans);
					}
				}

				shoppingCarMemberBean2.setShoppingCarShareBeans(maps);
			}
		}
		return shoppingCarMemberBeans;
	}

	/**
	 * 分享购物车
	 * 
	 * @param shoppingCarMemberBean
	 * @return
	 * @throws Exception
	 */
	public int shareShoppingCar(ShoppingCarMemberBean shoppingCarMemberBean, String car_ids) throws Exception {
		int num = swDao.shareShoppingCar(shoppingCarMemberBean);
		if (num > 0) {
			String[] cars = car_ids.split(",");
			for (int i = 0; i < cars.length; i++) {
				ShoppingCarBean shoppingCarBean = shoppingCarService
						.getShoppingCarByCarId(new ShoppingCarBean().setCar_id(NumberUtils.Integer(cars[i])));
				if (shoppingCarBean == null) {
					throw new Exception("此购物车不存在!");
				}
				num = swDao.insertMemberShoppingCar(new ShoppingCarShareBean().setCar_id(cars[i])
						.setGoods_id(shoppingCarBean.getGoods_id()).setGoods_num(shoppingCarBean.getGoods_num())
						.setGoods_parameters(shoppingCarBean.getGoods_parameters())
						.setMerchants_id(shoppingCarBean.getMerchants_id())
						.setMember_car_id(shoppingCarMemberBean.getMember_car_id() + ""));
				if (num <= 0) {
					throw new Exception("分享失败!");
				}
			}
		}
		return num;
	}

	/**
	 * 申请信用额度（最新）
	 * 
	 * @param trustBean
	 * @return
	 */
	public TrustBean getLastTrust(TrustBean trustBean) {
		TrustBean trustBean2 = swDao.getLastTrust(trustBean);
		if (trustBean2 != null) {
			List<TrustItemBean> trustItemBeans = swDao
					.getTrustItem(new TrustItemBean().setTrust_id(trustBean2.getTrust_id()));
			trustBean2.setTrustItemBeans(trustItemBeans);
		}
		return trustBean2;
	}

	/**
	 * 单个详情
	 * 
	 * @param trustBean
	 * @return
	 */
	public TrustBean getOneTrust(TrustBean trustBean) {
		TrustBean trustBean2 = swDao.getOneTrust(trustBean);
		if (trustBean2 != null) {
			List<TrustItemBean> trustItemBeans = swDao
					.getTrustItem(new TrustItemBean().setTrust_id(trustBean2.getTrust_id()));
			trustBean2.setTrustItemBeans(trustItemBeans);
		}
		return trustBean2;
	}

	/**
	 * 
	 * @param trustBean
	 * @return
	 */
	public List<TrustBean> getTrust(TrustBean trustBean, PageBean pageBean) {
		List<TrustBean> trustBeans = swDao.getTrust(trustBean, pageBean);
		if (trustBeans != null) {
			for (int i = 0; i < trustBeans.size(); i++) {
				TrustBean trustBean2 = trustBeans.get(i);
				List<TrustItemBean> trustItemBeans = swDao
						.getTrustItem(new TrustItemBean().setTrust_id(trustBean2.getTrust_id()));
				trustBean2.setTrustItemBeans(trustItemBeans);
			}
		}
		return trustBeans;
	}

	/**
	 * 申请信用额度
	 * 
	 * @param trustBean
	 * @return
	 * @throws Exception
	 */
	public int applyTrust(TrustBean trustBean, List<TrustItemBean> trustItemBeans) throws Exception {
		int num = swDao.applyTrust(trustBean);
		if (num >= 0) {
			if (trustItemBeans != null) {
				for (int i = 0; i < trustItemBeans.size(); i++) {
					num = swDao.applyTrustItem(trustItemBeans.get(i).setTrust_id(trustBean.getTrust_id()));
					if (num <= 0) {
						throw new Exception("申请失败！");
					}
				}
			}
		}
		return num;
	}

	/**
	 * 企业购分类
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<Map> getBusinessBuyClass(GoodsBean goodsBean) {
		List<Map> goodsBeans = swDao.getBusinessBuyClass1(goodsBean.setParent_id("-1"));
		if (goodsBeans != null) {
			for (int i = 0; i < goodsBeans.size(); i++) {
				Map goodsBean2 = goodsBeans.get(i);
				List<Map> goodsBeans2 = swDao
						.getBusinessBuyClass2(new GoodsBean().setParent_id(goodsBean2.get("goods_id").toString() + ""));
				if (goodsBeans2 != null) {
					for (int j = 0; j < goodsBeans2.size(); j++) {
						Map goodsBean3 = goodsBeans2.get(j);
						List<Map> goodsBeans3 = swDao.getBusinessBuyClass3(
								new GoodsBean().setParent_id(goodsBean3.get("goods_id").toString() + ""));
						goodsBean3.put("goodsBeans", goodsBeans3);
					}
				}
				goodsBean2.put("goodsBeans", goodsBeans2);
			}
		}
		return goodsBeans;
	}

	/**
	 * 企业购分类
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<Map> getBusinessBuyClass(GoodsBean goodsBean, String level) {
		if ("1".equals(level)) {
			return swDao.getBusinessBuyClass1(goodsBean);
		} else if ("2".equals(level)) {
			return swDao.getBusinessBuyClass2(goodsBean);
		} else {
			return swDao.getBusinessBuyClass3(goodsBean);
		}
	}

	/**
	 * 获得订单根据id
	 * 
	 * @param orderSWBean
	 * @return
	 */
	public OrderSWBean getOrderSwById(OrderSWBean orderSWBean) {
		return swDao.getOrderSwById(orderSWBean);
	}

	/**
	 * 抢单
	 * 
	 * @param orderSWBean
	 * @return
	 * @throws Exception
	 */
	public int grabOrderSW(OrderSWBean orderSWBean) throws Exception {
		int num = swDao.updateOrderSwState(orderSWBean);
		if (num > 0) {
			num = swDao.grabOrderSW(orderSWBean);
			if (num <= 0) {
				throw new Exception("抢单失败");
			}
		}
		return num;
	}

	/**
	 * 我的抢单
	 * 
	 * @return
	 */
	public List<OrderSWBean> getMemberGrabOrderSWs(OrderSWBean orderSWBean, PageBean pageBean) {
		return swDao.getMemberGrabOrderSWs(orderSWBean, pageBean);
	}

	/**
	 * 删除订单
	 * 
	 * @return
	 */
	public int deleteOrderSW(OrderSWBean orderSWBean) {
		return swDao.deleteOrderSW(orderSWBean);
	}

	/**
	 * 单个订单
	 * 
	 * @param orderSWBean
	 * @return
	 */
	public OrderSWBean getOrderSW(OrderSWBean orderSWBean) {
		return swDao.getOrderSW(orderSWBean);
	}

	/**
	 * 取消订单
	 * 
	 * @return
	 */
	public int cancelOrderSW(OrderSWBean orderSWBean) {
		return swDao.cancelOrderSW(orderSWBean);
	}

	/**
	 * 我的发单
	 * 
	 * @return
	 */
	public List<OrderSWBean> getMemberOrderSWs(OrderSWBean orderSWBean, PageBean pageBean) {
		return swDao.getMemberOrderSWs(orderSWBean, pageBean);
	}

	/**
	 * 添加订单（发单）
	 * 
	 * @return
	 * @throws Exception
	 */
	public int insertOrderSW(OrderSWBean orderSWBean, CodeBean codeBean) throws Exception {
		int num = swDao.insertOrderSW(orderSWBean);
		if (num > 0) {
			List<MemberBean> memberBeans = swDao.getMemberMerchants(new MemberBean());
			if (memberBeans != null) {
				for (int i = 0; i < memberBeans.size(); i++) {
					MemberBean memberBean = memberBeans.get(i);
					num = swDao.insertOrderSWMember(new OrderSWBean().setMember_id(memberBean.getMember_id() + "")
							.setOrder_id(orderSWBean.getOrder_id()));
					if (num <= 0) {
						throw new Exception("发单失败");
					}

					num = codeService.deleteCodeByMobileAndCode(codeBean);
					if (num <= 0) {
						throw new Exception("验证码销毁失败");
					}
				}
			}
		}
		return num;
	}

	/**
	 * 生物网站首页
	 * 
	 * @return
	 */
	public List<GoodsBean> getHomeClassWeb(GoodsBean goodsBean) {
		List<GoodsBean> goodsBeans = swDao.getGoodsClass(goodsBean.setParent_id("-1").setGoods_type("1"));
		for (int i = 0; i < goodsBeans.size(); i++) {
			GoodsBean goodsBean2 = goodsBeans.get(i);
			List<GoodsBean> goodsBeans2 = swDao
					.getGoodsClass(new GoodsBean().setParent_id(goodsBean2.getGoods_id() + "").setGoods_type("1"));

			for (int j = 0; j < goodsBeans2.size(); j++) {
				GoodsBean goodsBean3 = goodsBeans2.get(j);
				List<GoodsBean> goodsRecommendBeans = swDao.getRecommendGoods(
						new GoodsBean().setGoods_uuid(goodsBean3.getGoods_uuid() + "").setGoods_type("2"),
						new PageBean());
				goodsBean3.setGoodsRecommendBeans(goodsRecommendBeans);
			}

			goodsBean2.setGoodsBeans(goodsBeans2);

			List<ClassBannerBean> classBannerBeans = swDao
					.getClassBanners(new ClassBannerBean().setClass_id(goodsBean2.getGoods_id() + ""));
			goodsBean2.setClassBannerBeans(classBannerBeans);

			// List<GoodsBean> classRecommendBeans=swDao.
			// getClassRecommendGoods(new
			// GoodsBean().setGoods_uuid(goodsBean2.getGoods_uuid()+"").setGoods_type("2"));
			// goodsBean2.setClassRecommendBeans(classRecommendBeans);

			List<BrandBean> brandBeans = swDao.getGoodsBrands(goodsBean2);
			goodsBean2.setBrandBeans(brandBeans);
		}
		return goodsBeans;
	}

	/**
	 * 生物网站首页
	 * 
	 * @return
	 */
	public List<GoodsBean> getHomeClassWeb1(GoodsBean goodsBean) {
		List<GoodsBean> goodsBeans = null;
		goodsBeans = swDao.getGoodsClass(goodsBean.setParent_id("-1").setGoods_type("1"));
		return goodsBeans;
	}

	/**
	 * 生物网站首页
	 * 
	 * @return
	 */
	public GoodsBean getHomeClassWeb2(GoodsBean goodsBean) {
		List<GoodsBean> goodsBeans2 = swDao
				.getGoodsClass(new GoodsBean().setParent_id(goodsBean.getGoods_id() + "").setGoods_type("1"));

		for (int j = 0; j < goodsBeans2.size(); j++) {
			GoodsBean goodsBean3 = goodsBeans2.get(j);
			List<GoodsBean> goodsRecommendBeans = swDao.getRecommendGoods(
					new GoodsBean().setGoods_uuid(goodsBean3.getGoods_uuid() + "").setGoods_type("2"), new PageBean());
			goodsBean3.setGoodsRecommendBeans(goodsRecommendBeans);
		}

		goodsBean.setGoodsBeans(goodsBeans2);

		List<ClassBannerBean> classBannerBeans = swDao
				.getClassBanners(new ClassBannerBean().setClass_id(goodsBean.getGoods_id() + ""));
		goodsBean.setClassBannerBeans(classBannerBeans);

		// List<GoodsBean> classRecommendBeans=swDao.
		// getClassRecommendGoods(new
		// GoodsBean().setGoods_uuid(goodsBean2.getGoods_uuid()+"").setGoods_type("2"));
		// goodsBean2.setClassRecommendBeans(classRecommendBeans);

		List<BrandBean> brandBeans = swDao.getGoodsBrands(goodsBean);
		goodsBean.setBrandBeans(brandBeans);

		return goodsBean;
	}

	/**
	 * 团购商品列表(只是标签)
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getGroupGoodss(GoodsBean goodsBean, PageBean pageBean) {
		return swDao.getGroupGoodss(goodsBean, pageBean);
	}

	/**
	 * 店铺下推荐的商品列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getMerchantsRecommendGoods(GoodsBean goodsBean) {
		return swDao.getMerchantsRecommendGoods(goodsBean);
	}

	/**
	 * 用户对某个动态关闭详情
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsBean getOneMemberDynamicHeadlines(MerchantsBean merchantsBean) {
		return swDao.getOneMemberDynamicHeadlines(merchantsBean);
	}

	/**
	 * 用户关闭动态头条
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public int memberCloseDynamicHeadlines(MerchantsBean merchantsBean) {
		return swDao.memberCloseDynamicHeadlines(merchantsBean);
	}

	/**
	 * 店铺头条 热门店铺
	 * 
	 * @return
	 */
	public List<MerchantsBean> getHotHeadlinesMerchants(MerchantsBean merchantsBean, PageBean pageBean) {
		List<MerchantsBean> merchantsBeans = swDao.getHotHeadlinesMerchants(merchantsBean, pageBean);
		for (int i = 0; i < merchantsBeans.size(); i++) {
			List<GoodsBean> goodsBeans = getMerchantsRecommendGoods(
					new GoodsBean().setMerchants_id(merchantsBeans.get(i).getMerchants_id() + ""));
			merchantsBeans.get(i).setGoodsBeans(goodsBeans);
		}
		return merchantsBeans;
	}

	/**
	 * 店铺头条 动态店铺
	 * 
	 * @return
	 */
	public List<MerchantsBean> getDynamicHeadlinesMerchants(MerchantsBean merchantsBean, PageBean pageBean) {
		List<MerchantsBean> merchantsBeans = swDao.getDynamicHeadlinesMerchants(merchantsBean, pageBean);
		for (int i = 0; i < merchantsBeans.size(); i++) {
			List<GoodsBean> goodsBeans = getMerchantsRecommendGoods(
					new GoodsBean().setMerchants_id(merchantsBeans.get(i).getMerchants_id() + ""));
			merchantsBeans.get(i).setGoodsBeans(goodsBeans);
		}
		return merchantsBeans;
	}

	/**
	 * 发现好货 精选
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getExactGoodGoodss(GoodsBean goodsBean, PageBean pageBean) {
		return swDao.getExactGoodGoodss(goodsBean, pageBean);
	}

	/**
	 * 发现好货 专辑列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<AlbumBean> getAlbums(AlbumBean albumBean, PageBean pageBean) {
		return swDao.getAlbums(albumBean, pageBean);
	}

	/**
	 * 发现好货 专辑
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getAlbumGoodGoodss(GoodsBean goodsBean, PageBean pageBean) {
		return swDao.getAlbumGoodGoodss(goodsBean, pageBean);
	}

	/**
	 * 首页推荐商品列表
	 * 
	 * @return
	 */
	public List<GoodsBean> getHomeGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = swDao.getHomeGoods(goodsBean, pageBean);
		// if(goodsBeans==null||goodsBeans.size()>0){
		// return swDao.getHomeGoods(new GoodsBean(),pageBean);
		// }
		return goodsBeans;
	}

	/**
	 * 首页分类标签
	 * 
	 * @param homeGoodsBean
	 * @return
	 */
	public List<LabelBean> getHomeLabels(LabelBean labelBean) {
		return swDao.getHomeLabels(labelBean);
	}

	/**
	 * 波尔快报的分类列表
	 * 
	 * @param newsBean
	 * @return
	 */
	public List<NewsBean> getNewsClass(NewsBean newsBean) {
		return swDao.getNewsClass(newsBean);
	}

	/**
	 * 波尔快报的分类下商品列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getNewsGoods(NewsBean newsBean, PageBean pageBean) {
		return swDao.getNewsGoods(newsBean, pageBean);
	}

	/**
	 * 推荐快报
	 * 
	 * @param newsBean
	 * @return
	 */
	public List<NewsBean> getNewsRecommendGoods(NewsBean newsBean) {
		return swDao.getNewsRecommendGoods(newsBean);
	}

	/**
	 * 波尔快报的精选商品列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getNewsExactGoods(NewsBean newsBean, PageBean pageBean) {
		return swDao.getNewsExactGoods(newsBean, pageBean);
	}
}

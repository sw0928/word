package tst.project.service.interfaces;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.elasticsearch.search.aggregations.bucket.histogram.Histogram.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.ShopOrderCreateDiscount;
import com.iwilley.b1ec2.api.domain.ShopOrderCreateLine;
import com.iwilley.b1ec2.api.domain.ShopOrderCreatePayment;
import com.iwilley.b1ec2.api.request.ShopOrderCreateRequest;
import com.iwilley.b1ec2.api.response.ShopOrderCreateResponse;
import com.iwilley.b1ec2.sample.Constants;
import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.Refund;
import com.sun.org.apache.xpath.internal.operations.Or;

import tst.project.bean.HostBean;
import tst.project.bean.activity.ActivityBean;
import tst.project.bean.activity.GroupBuyBean;
import tst.project.bean.activity.GroupBuyGoodsBean;
import tst.project.bean.activity.GroupBuyMemberBean;
import tst.project.bean.activity.PromotionGoodsBean;
import tst.project.bean.address.AddressBean;
import tst.project.bean.address.SinceBean;
import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsImgBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.GoodsServiceBean;
import tst.project.bean.goods.ShoppingCarBean;
import tst.project.bean.goods.ShoppingCarMemberBean;
import tst.project.bean.goods.ShoppingCarShareBean;
import tst.project.bean.member.CouponBean;
import tst.project.bean.member.IntegralBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.order.AssessmentBean;
import tst.project.bean.order.AssessmentImgBean;
import tst.project.bean.order.BusinessProfitBean;
import tst.project.bean.order.InviseBean;
import tst.project.bean.order.LogisticsBean;
import tst.project.bean.order.LogisticsDetailBean;
import tst.project.bean.order.OrderActivityBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderGoodsBean;
import tst.project.bean.order.OrderLineBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.order.OrderParameterBean;
import tst.project.bean.order.OrderServiceBean;
import tst.project.bean.order.PingSettingBean;
import tst.project.bean.order.RefundBean;
import tst.project.bean.order.RefundImgBean;
import tst.project.bean.order.RefundReasonBean;
import tst.project.bean.others.PercentBean;
import tst.project.dao.interfaces.OrderDao;
import tst.project.page.PageBean;
import tst.project.utils.CreateRandom;
import tst.project.utils.HBRUtils;
import tst.project.utils.HtmlUtils;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.UUIDUtils;
import tst.project.utils.XmlUtils;

@Service
@Transactional(rollbackFor = { Exception.class })
public class OrderService {
	@Resource
	OrderDao orderDao;

	@Resource
	AddressService addressService;

	@Resource
	GoodsServiceI goodsServiceI;

	@Resource
	MerchantsServiceI merchantsServiceI;

	@Resource
	ShoppingCarService shoppingCarService;

	@Resource
	ActivityService activityService;

	@Resource
	MemberService memberService;

	@Resource
	OthersService othersService;

	@Resource
	CouponService couponService;

	@Resource
	GoodsServiceI2 goodsServiceI2;

	/**
	 * 获得订单的物流详情列表 不分页
	 * 
	 * @param map
	 * @return
	 * @throws ParseException
	 */
	public int logisticsCallBack(List<Map> maps, LogisticsDetailBean logisticsDetailBean) throws ParseException {
		int num = 0;
		LogisticsDetailBean logisticsDetailBean2 = orderDao.getLastLogistics(logisticsDetailBean);
		if (maps != null) {
			for (int i = 0; i < maps.size(); i++) {
				Map map = maps.get(i);
				if (logisticsDetailBean2 != null) {// 已经录入过
					if (TimeUtils.compareDate(map.get("ftime").toString(), logisticsDetailBean2.getLogistics_time(),
							"yyyy-MM-dd HH:mm:ss") > 0) {
						num = orderDao.insertLogisticsDetail(
								new LogisticsDetailBean().setLogistics_no(logisticsDetailBean.getLogistics_no())
										.setLogistics_time(map.get("ftime").toString())
										.setLogistics_context(map.get("context").toString()));
					}
				} else {
					num = orderDao.insertLogisticsDetail(
							new LogisticsDetailBean().setLogistics_no(logisticsDetailBean.getLogistics_no())
									.setLogistics_time(map.get("ftime").toString().trim())
									.setLogistics_context(map.get("context").toString()));
				}
			}
		}
		return num;
	}

	/**
	 * 获得订单的物流详情列表
	 * 
	 * @param map
	 * @return
	 */
	public Map getOrderLogisticsDetails(LogisticsDetailBean logisticsDetailBean, OrderBean orderBean) {
		OrderBean orderBean2 = orderDao.getOneOrderDetail(orderBean);
		LogisticsBean logisticsBean = null;
		if (orderBean2 != null) {
			logisticsBean = orderDao
					.getOneLogistics(new LogisticsBean().setLogistics_pinyin(orderBean2.getLogistics_pinyin()));
		}
		List<LogisticsDetailBean> logisticsDetailBeans = orderDao.getOrderLogisticsDetails(logisticsDetailBean);

		Map map = new HashMap();
		map.put("logisticsBean", logisticsBean);
		map.put("logisticsDetailBeans", logisticsDetailBeans);
		return map;
	}

	/**
	 * 获得订单发票内容
	 * 
	 * @param inviseBean
	 * @return
	 */
	public List<InviseBean> getOrderInviseContents(InviseBean inviseBean) {
		return orderDao.getOrderInviseContents(inviseBean);
	}

	/**
	 * 线下订单
	 * 
	 * @param orderLineBean
	 * @return
	 */
	public List<OrderLineBean> getOrderLines(OrderLineBean orderLineBean, PageBean pageBean) {
		return orderDao.getOrderLines(orderLineBean, pageBean);
	}

	public List<BusinessProfitBean> getBusinessProfitByOrderGoods(BusinessProfitBean businessProfitBean) {
		return orderDao.getBusinessProfitByOrderGoods(businessProfitBean);
	}

	/**
	 * 获得订单原因列表
	 * 
	 * @param refundReasonBean
	 * @return
	 */
	public List<RefundReasonBean> getRefundsReasons(RefundReasonBean refundReasonBean) {
		return orderDao.getRefundsReasons(refundReasonBean);
	}

	/**
	 * 用户的退款列表 各个状态统计
	 * 
	 * @param refundReasonBean
	 * @return
	 */
	public Map getMemberRefundCount(RefundBean refundBean) {
		return orderDao.getMemberRefundCount(refundBean);
	}

	/**
	 * 用户的退款列表
	 * 
	 * @param refundBean
	 * @return
	 */
	public List<RefundBean> getMemberRefunds(RefundBean refundBean, PageBean pageBean) {
		List<RefundBean> refundBeans = orderDao.getMemberRefunds(refundBean, pageBean);
		if (refundBeans != null) {
			for (int i = 0; i < refundBeans.size(); i++) {
				OrderGoodsBean orderGoodsBean = getOrderGoodssByGoods(
						new OrderGoodsBean().setOrder_id(refundBeans.get(i).getOrder_id())
								.setOrder_goods_id(Integer.valueOf(refundBeans.get(i).getOrder_goods_id())));
				refundBeans.get(i).setOrderGoodsBean(orderGoodsBean);

				List<OrderParameterBean> orderParameterBeans = orderDao.getOrderParameters(
						new OrderParameterBean().setOrder_goods_id(refundBeans.get(i).getOrder_goods_id())
								.setOrder_id(refundBeans.get(i).getOrder_id()));
				refundBeans.get(i).setOrderParameterBeans(orderParameterBeans);

				List<OrderServiceBean> orderServiceBeans = orderDao.getOrderServices(
						new OrderServiceBean().setOrder_goods_id(refundBeans.get(i).getOrder_goods_id())
								.setOrder_id(refundBeans.get(i).getOrder_id()));
				refundBeans.get(i).setOrderServiceBeans(orderServiceBeans);

				GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
						new GoodsBean().setGoods_id(Integer.valueOf(refundBeans.get(i).getGoods_id())));
				refundBeans.get(i).setGoodsBean(goodsBean);

				List<RefundImgBean> refundImgBeans = getRefundImgs(
						new RefundImgBean().setRefund_id(refundBeans.get(i).getRefund_id() + ""));
				refundBeans.get(i).setRefundImgBeans(refundImgBeans);
			}
		}
		return refundBeans;
	}

	/**
	 * 单个退款详情
	 * 
	 * @param refundBean
	 * @return
	 */
	public RefundBean getRefundDetail(RefundBean refundBean) {
		RefundBean refundBean2 = orderDao.getRefundDetail(refundBean);
		if (refundBean2 != null) {
			GoodsBean goodsBean = goodsServiceI
					.getOneGoodsDetail(new GoodsBean().setGoods_id(Integer.valueOf(refundBean2.getGoods_id())));
			refundBean2.setGoodsBean(goodsBean);

			List<OrderParameterBean> orderParameterBeans = orderDao.getOrderParameters(new OrderParameterBean()
					.setOrder_goods_id(refundBean2.getOrder_goods_id()).setOrder_id(refundBean2.getOrder_id()));
			refundBean2.setOrderParameterBeans(orderParameterBeans);

			List<OrderServiceBean> orderServiceBeans = orderDao.getOrderServices(new OrderServiceBean()
					.setOrder_goods_id(refundBean2.getOrder_goods_id()).setOrder_id(refundBean2.getOrder_id()));
			refundBean2.setOrderServiceBeans(orderServiceBeans);

			List<RefundImgBean> refundImgBeans = getRefundImgs(
					new RefundImgBean().setRefund_id(refundBean2.getRefund_id() + ""));
			refundBean2.setRefundImgBeans(refundImgBeans);
		}
		return refundBean2;
	}

	/**
	 * 单个退款图片详情
	 * 
	 * @param refundBean
	 * @return
	 */
	public List<RefundImgBean> getRefundImgs(RefundImgBean refundImgBean) {
		return orderDao.getRefundImgs(refundImgBean);
	}

	/**
	 * 查询某个商品的订单详情
	 * 
	 * @param refundBean
	 * @return
	 */
	public RefundBean getRefundByGoods(RefundBean refundBean) {
		return orderDao.getRefundByGoods(refundBean);
	}

	/**
	 * 订单退款
	 * 
	 * @param refundBean
	 * @param files
	 * @return
	 * @throws Exception
	 */
	public int refundOrder(RefundBean refundBean, String[] files) throws Exception {
		int num = insertRefund(refundBean);
		if (num > 0) {
			if (files != null) {
				for (int i = 0; i < files.length; i++) {
					int h = insertRefundImg(
							new RefundImgBean().setRefund_id(refundBean.getRefund_id() + "").setRefund_img(files[i]));
					if (h <= 0) {
						throw new Exception("退款图片入库失败");
					}
				}
			}
		}
		return num;
	}

	/**
	 * 订单退款
	 * 
	 * @param refundBean
	 * @param files
	 * @return
	 * @throws Exception
	 */
	public int refundOrder(RefundBean refundBean, List<String> files) throws Exception {
		int num = insertRefund(refundBean);
		if (num > 0) {
			if (files != null) {
				for (int i = 0; i < files.size(); i++) {
					int h = insertRefundImg(new RefundImgBean().setRefund_id(refundBean.getRefund_id() + "")
							.setRefund_img(files.get(i)));
					if (h <= 0) {
						throw new Exception("退款图片入库失败");
					}
				}
			}
		}
		return num;
	}

	/**
	 * 退款信息入库
	 * 
	 * @param refundBean
	 * @param files
	 * @return
	 * @throws Exception
	 */
	public int insertRefund(RefundBean refundBean) throws Exception {
		OrderBean orderBean = orderDao
				.getOneOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(refundBean.getOrder_id())));
		// float refund_price = Float.valueOf(refundBean.getRefund_price()) +
		// Float.valueOf(orderBean.getRefund_price());
		// float refund_give_integral =
		// Float.valueOf(refundBean.getRefund_give_integral())
		// + Float.valueOf(orderBean.getRefund_give_integral());
		// float refund_deduct_integral =
		// Float.valueOf(refundBean.getRefund_deduct_integral())
		// + Float.valueOf(orderBean.getRefund_deduct_integral());
		// int k = orderDao.updateOrderDetail(new
		// OrderBean().setOrder_id(Integer.valueOf(refundBean.getOrder_id()))
		// .setRefund_coupon_id(refundBean.getMember_coupon_id())
		// .setRefund_deduct_integral(refund_deduct_integral + "")
		// .setRefund_give_integral(refund_give_integral +
		// "").setRefund_price(refund_price + ""));
		// if (k <= 0) {
		// throw new Exception("订单状态更新失败");
		// }

		int num = orderDao.insertRefund(refundBean.setRefund_order_no(orderBean.getOrder_pay_no()));
		if (num <= 0) {
			throw new Exception("退款申请失败");
		}
		return num;
	}

	/**
	 * 退款图片信息入库
	 * 
	 * @param refundBean
	 * @param files
	 * @return
	 */
	public int insertRefundImg(RefundImgBean refundImgBean) {
		return orderDao.insertRefundImg(refundImgBean);
	}

	/**
	 * 添加订单
	 * 
	 * @param orderBean
	 * @return
	 * @throws Exception
	 */
	public String insertRechargeOrder(OrderBean orderBean) throws Exception {
		String order_no = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + CreateRandom.createRandom(false, 10);
		int num = orderDao.insertRechargeOrder(
				orderBean.setOrder_no(order_no).setOrder_actual_price(orderBean.getOrder_total_price()));
		if (num <= 0) {
			throw new Exception("下单失败！");
		}
		String order_id = orderBean.getOrder_id() + "";
		return order_id;
	}

	/**
	 * 添加订单
	 * 
	 * @param orderBean
	 * @return
	 * @throws Exception
	 */
	public Map insertOrder(OrderMerchantsBean orderMerchantsBean, String type) throws Exception {
		type = "pc".equals(type) ? "pc" : "mobile";
		
		String member_car_id=orderMerchantsBean.getMember_car_id();
		if(member_car_id!=null&&!"".equals(member_car_id)){
			int k=orderDao.updateMemberCarState(new ShoppingCarMemberBean().setMember_car_id(NumberUtils.Integer(member_car_id)));
			if(k<=0){
				throw new Exception("分享下单失败");
			}
		}
		
		AddressBean addressBean = addressService
				.getAddressById(new AddressBean().setAddress_id(Integer.valueOf(orderMerchantsBean.getAddress_id())));// 地址详情
		if (addressBean == null) {
			throw new Exception("地址不存在");
		}
		SinceBean sinceBean = null;
		if (orderMerchantsBean.getSince_id() != null && !"".equals(orderMerchantsBean.getSince_id())) {
			sinceBean = addressService
					.getOneSince(new SinceBean().setSince_id(NumberUtils.Integer(orderMerchantsBean.getSince_id())));// 地址详情
			if (sinceBean == null) {
				throw new Exception("自提点不存在");
			}
		}
		List<OrderBean> orderBeans = orderMerchantsBean.getOrderBeans();
		int num = -1;

		String shop_car_ids = orderMerchantsBean.getShopping_car_ids();
		if (shop_car_ids != null && shop_car_ids.length() > 0) {
			String[] car_ids = shop_car_ids.split(",");
			for (int i = 0; i < car_ids.length; i++) {
				int m = shoppingCarService.deleteShoppingCar(new ShoppingCarBean()
						.setCar_id(Integer.valueOf(car_ids[i])).setMember_id(orderMerchantsBean.getMember_id()));
				if (m <= 0) {
					throw new Exception("购物车删除失败");
				}
			}
		}

		PercentBean percentBean = othersService.getPercent(new PercentBean().setPercent_type("integral"));// 积分抵扣比例
		MemberBean memberBean = memberService
				.getMemberByID(new MemberBean().setMember_id(Integer.valueOf(orderMerchantsBean.getMember_id())));
		if (memberBean == null) {
			throw new Exception("用户不存在");
		}

		float order_total_actual_price = 0;// 多个订单的总金额
		if (orderBeans != null) {// 订单列表不为null
			String[] order_ids = new String[orderBeans.size()];
			float member_integral_price = (Float.valueOf(memberBean.getIntegral())
					* Float.valueOf(percentBean.getPercent_value())) / 100;

			boolean is_used_coupon = false;// 判断优惠卷是否已经用在某个商家店铺了
			float give_integral_value_total = 0;

			for (int i = 0; i < orderBeans.size(); i++) {// 订单 按商家 入库
				float give_integral_value = 0;
				float order_total_price = 0;// 订单总价
				float order_actual_price = 0;// 实际支付金额
				float express_price = 0;// 订单总邮费

				OrderBean orderBean = orderBeans.get(i);				
				orderBean.setRemark(HtmlUtils.Html2Text(orderBean.getRemark()));
				if (sinceBean != null) {
					orderBean.setSince_id(sinceBean.getSince_id() + "");
					orderBean.setSince_name(sinceBean.getSince_name());
					orderBean.setSince_mobile(orderMerchantsBean.getSince_mobile());
					orderBean.setSince_fixed_mobile(orderMerchantsBean.getSince_fixed_mobile());
					orderBean.setSince_people_name(orderMerchantsBean.getSince_people_name());
				}

				MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
						new MerchantsBean().setMerchants_id(Integer.valueOf(orderBean.getMerchants_id())));
				if (merchantsBean == null) {
					throw new Exception("此商家已下架或已删除");
				}

				orderBean.setMerchantsBean(merchantsBean);
				orderBean.setAddressBean(addressBean);
				UUIDUtils uuidUtils = new UUIDUtils(1);
				String order_no = uuidUtils.nextId(false, 1) + "";// TimeUtils.getCurrentTime("yyyyMMddHHmmss")
																	// +
																	// CreateRandom.createRandom(true,
																	// 10);
				orderBean.setOrder_state("wait_pay");// 订单状态
				orderBean.setOrder_no(order_no);// 订单号
				orderBean.setMember_id(orderMerchantsBean.getMember_id());// 用户id
				orderBean.setAddress_id(orderMerchantsBean.getAddress_id());// 地址id

				orderBean.setOrder_type(orderMerchantsBean.getOrder_type());// 订单类型
				orderBean.setMember_group_buy_id(orderMerchantsBean.getMember_group_buy_id());// 用户团购id
				orderBean.setBusiness_id(memberBean.getBusiness_id());
				orderBean.setMerchants_account_id(memberBean.getMerchants_account_id());

				num = orderDao.insertOrder(orderBean);// 订单入库
				order_ids[i] = orderBean.getOrder_id() + "";

				if (num > 0) {
					List<OrderGoodsBean> orderGoodsBeans = orderBean.getOrderGoodsBeans();
					if (orderGoodsBeans == null || orderGoodsBeans.size() <= 0) {
						throw new Exception("商品不可为空!");
					}
					for (int j = 0; j < orderGoodsBeans.size(); j++) {// 订单商品入库
						OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(j);//获得商家订单 单个商品
						
						String share_car_id=orderGoodsBean.getShare_car_id();
						if(share_car_id!=null&&!"".equals(share_car_id)){
							int k=orderDao.updateShareCarState(new ShoppingCarShareBean()
									.setShare_car_id(NumberUtils.Integer(share_car_id))
									.setOrder_id(orderBean.getOrder_id()+""));
							if(k<=0){
								throw new Exception("分享下单失败!");
							}
						}
						
						GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(new GoodsBean()
								.setGoods_id(Integer.valueOf(orderGoodsBean.getGoods_id())));// 获得商品详情
						if (goodsBean == null || "0".equals(goodsBean.getGoods_state())) {
							throw new Exception("此商品下架或者已删除");
						}

						if (goodsBean.getGoods_stock() < orderGoodsBean.getGoods_num()) {
							throw new Exception(goodsBean.getGoods_name() + "库存不足!  现有库存:" + goodsBean.getGoods_stock());
						} else {
							int goods_stock = goodsBean.getGoods_stock() - orderGoodsBean.getGoods_num();
							int k = goodsServiceI2.updateGoodsDetail(
									new GoodsBean().setGoods_id(goodsBean.getGoods_id()).setGoods_stock(goods_stock));
							if (k <= 0) {
								throw new Exception("更新商品信息失败");
							}
						}

						orderGoodsBean.setGoodsBean(goodsBean);

						double total_price = 0;

						if (type.equals("pc")) {
							orderGoodsBean.setGoods_price(goodsBean.getGoods_pc_price());
						} else {
							orderGoodsBean.setGoods_price(goodsBean.getGoods_now_price());
						}

						int k = orderDao.insertOrderGoods(orderGoodsBean.setOrder_id(orderBean.getOrder_id() + ""));
						if (k <= 0) {
							throw new Exception("商品入库失败");
						}

						GroupBuyGoodsBean groupBuyGoodsBean = new GroupBuyGoodsBean();
						if ("group_buy".equals(orderMerchantsBean.getOrder_type())) {// 团购下单
							groupBuyGoodsBean = activityService
									.getGoodsGroupBuyByMember(new GroupBuyMemberBean().setMember_group_buy_id(
											Integer.valueOf(orderMerchantsBean.getMember_group_buy_id())));
							goodsBean.setGroup_buy_price(groupBuyGoodsBean.getGroup_buy_price());
						}
						PromotionGoodsBean promotionGoodsBean = new PromotionGoodsBean();
						if ("time_limit".equals(orderMerchantsBean.getOrder_type())) {// 限时促销下单
							promotionGoodsBean = activityService.getOnePromotionGoods(
									new PromotionGoodsBean().setGoods_id(orderGoodsBean.getGoods_id())
											.setPromotion_id(orderGoodsBean.getPromotion_id()));
							if (promotionGoodsBean == null) {
								throw new Exception("此促销商品不存在");
							}

							goodsBean.setPromotion_price(promotionGoodsBean.getPromotion_price());
							goodsBean.setPromotion_goods_id(promotionGoodsBean.getPromotion_goods_id() + "");
						}

						List<OrderParameterBean> orderParameterBeans = orderGoodsBean.getOrderParameterBeans();// 订单商品参数列表
						List<OrderServiceBean> orderServiceBeans = orderGoodsBean.getOrderServiceBeans();// 订单商品
																											// 服务列表
						if (orderParameterBeans != null) {
							for (int l = 0; l < orderParameterBeans.size(); l++) {
								GoodsParameterBean goodsParameterBean = orderDao
										.getOneParameter(new GoodsParameterBean().setParameter_id(
												Integer.valueOf(orderParameterBeans.get(l).getParameter_id())));

								if (goodsParameterBean == null) {
									throw new Exception("无此参数");
								}
								OrderParameterBean orderParameterBean = new OrderParameterBean()
										.setParameter_id(goodsParameterBean.getParameter_id() + "")
										.setParameter_price(goodsParameterBean.getParameter_price());

								int m = orderDao.insertOrderParameter(
										orderParameterBean.setOrder_id(orderBean.getOrder_id() + "")
												.setOrder_goods_id(orderGoodsBean.getOrder_goods_id() + ""));
								if (m <= 0) {
									throw new Exception("商品参数入库失败");
								}
								order_actual_price += Float.valueOf(orderParameterBean.getParameter_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上参数的钱
																						// 乘以
																						// 数量

								order_total_price += Float.valueOf(orderParameterBean.getParameter_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上参数的钱
								// 乘以
								// 数量

								total_price += Float.valueOf(orderParameterBean.getParameter_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());

							}
						}
						if (orderServiceBeans != null) {
							for (int l = 0; l < orderServiceBeans.size(); l++) {

								GoodsServiceBean goodsServiceBean = orderDao.getOneService(new GoodsServiceBean()
										.setService_id(Integer.valueOf(orderServiceBeans.get(l).getService_id())));

								if (goodsServiceBean == null) {
									throw new Exception("无此服务");
								}

								OrderServiceBean orderServiceBean = new OrderServiceBean()
										.setService_id(goodsServiceBean.getService_id() + "")
										.setService_price(goodsServiceBean.getService_price());

								int m = orderDao
										.insertOrderService(orderServiceBean.setOrder_id(orderBean.getOrder_id() + "")
												.setOrder_goods_id(orderGoodsBean.getOrder_goods_id() + ""));
								if (m <= 0) {
									throw new Exception("商品服务入库失败");
								}
								order_total_price += Float.valueOf(orderServiceBean.getService_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上服务的钱乘以数量

								order_actual_price += Float.valueOf(orderServiceBean.getService_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上服务的钱乘以数量

								total_price += Float.valueOf(orderServiceBean.getService_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上服务的钱乘以数量
							}
						}

						if ("1".equals(goodsBean.getIs_give_integral())) {
							give_integral_value += Float.valueOf(goodsBean.getGive_integral_value())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 赠送积分
																					// 乘以数量
						}

						if ("0".equals(goodsBean.getIs_express())) {// 计算邮费
							express_price += Float.valueOf(goodsBean.getExpress_price());
						}

						if (orderMerchantsBean.getOrder_type().equals("goods")) {// 正常商品下单
							if ("pc".equals(type)) {
								order_total_price += Float.valueOf(goodsBean.getGoods_pc_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱
																						// 乘以
																						// 数量

								order_actual_price += Float.valueOf(goodsBean.getGoods_pc_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱
								// 乘以
								// 数量

								total_price += Float.valueOf(goodsBean.getGoods_pc_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱
								// 乘以
								// 数量
							} else {
								order_total_price += Float.valueOf(goodsBean.getGoods_now_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱
																						// 乘以
																						// 数量

								order_actual_price += Float.valueOf(goodsBean.getGoods_now_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱
								// 乘以
								// 数量

								total_price += Float.valueOf(goodsBean.getGoods_now_price())
										* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱
								// 乘以
								// 数量
							}

						} else if (orderMerchantsBean.getOrder_type().equals("group_buy")) {// 团购下单
							order_total_price += Float.valueOf(groupBuyGoodsBean.getGroup_buy_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的团购价
																					// 乘以
																					// 数量

							order_actual_price += Float.valueOf(groupBuyGoodsBean.getGroup_buy_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的团购价
							// 乘以
							// 数量

							total_price += Float.valueOf(groupBuyGoodsBean.getGroup_buy_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的团购价
							// 乘以
							// 数量
						} else if (orderMerchantsBean.getOrder_type().equals("time_limit")) {// 限时促销下单
							order_total_price += Float.valueOf(promotionGoodsBean.getPromotion_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的促销价
																					// 乘以
																					// 数量

							order_actual_price += Float.valueOf(promotionGoodsBean.getPromotion_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的促销价
							// 乘以
							// 数量

							total_price += Float.valueOf(promotionGoodsBean.getPromotion_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的促销价
							// 乘以
							// 数量
						}

						JFUtils.insertProfit(orderGoodsBean, memberBean, total_price, othersService, orderDao);// 收益分配

						num = orderDao.updateOrderGoods(new OrderGoodsBean()
								.setOrder_goods_id(orderGoodsBean.getOrder_goods_id()).setTotal_price(total_price));
						if (num <= 0) {
							throw new Exception("订单商品更新失败");
						}
					}
				}

				/*
				 * 邮费计算
				 */
				float express_free_price = Float.valueOf(merchantsBean.getExpress_free_price());// 商家设置的订单满多少免邮
				if (express_free_price > express_price) {// 满邮 大于 订单的邮费 则
															// 订单总价需加上 邮费
					order_total_price += express_price;// 订单总价 加上邮费
					order_actual_price += express_price;

					orderBean.setIs_free_express("0");// 不免邮
				} else {
					orderBean.setIs_free_express("1");// 免邮
				}

				orderBean.setExpress_free_price(NumberUtils.KeepDecimal(express_free_price, 2) + "");// 满多少包邮
				orderBean.setExpress_price(NumberUtils.KeepDecimal(express_price, 2) + "");// 邮费

				if (num > 0) {// 计算活动的钱 在加上邮费之后
					List<OrderGoodsBean> orderGoodsBeans = orderBean.getOrderGoodsBeans();

					for (int j = 0; j < orderGoodsBeans.size(); j++) {// 订单商品入库
						OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(j);// 获得商家订单
						List<ActivityBean> activityBeans = activityService.getGoodsActivity(
								new ActivityBean().setGoods_id(Integer.valueOf(orderGoodsBean.getGoods_id())));// 商品参加的活动列表

						ActivityBean activityBean = null;
						if (activityBeans != null) {
							for (int l = 0; l < activityBeans.size(); l++) {// 一个商品
																			// 只能参加一个活动
								ActivityBean activityBean2 = activityBeans.get(l);
								if (activityBean == null) {
									if ("give".equals(activityBean2.getActivity_type()) && orderGoodsBean
											.getGoods_num() >= activityBean2.getGiveBean().getGive_need_count()) {
										activityBean = activityBean2;
									} else if ("reduce".equals(activityBean2.getActivity_type())
											&& order_total_price >= activityBean2.getReduceBean()
													.getReduce_need_price()) {
										activityBean = activityBean2;
									} else if ("gift".equals(activityBean2.getActivity_type())
											&& order_total_price >= activityBean2.getGiftBean().getGift_need_price()) {
										activityBean = activityBean2;
									}
								} else if ("give".equals(activityBean2.getActivity_type())) {
									if (activityBean2.getGiveBean() != null
											&& activityBean2.getGiveBean().getGive_need_count() > activityBean
													.getGiveBean().getGive_need_count()
											&& orderGoodsBean.getGoods_num() >= activityBean2.getGiveBean()
													.getGive_need_count()) {
										activityBean = activityBean2;
									}
								} else if ("reduce".equals(activityBean2.getActivity_type())) {
									if (activityBean2.getReduceBean() != null
											&& activityBean2.getReduceBean().getReduce_need_price() > activityBean
													.getReduceBean().getReduce_need_price()
											&& order_total_price >= activityBean2.getReduceBean()
													.getReduce_need_price()) {
										activityBean = activityBean2;
									}
								} else if ("gift".equals(activityBean2.getActivity_type())) {
									if (activityBean2.getGiftBean() != null
											&& activityBean2.getGiftBean().getGift_need_price() > activityBean
													.getGiftBean().getGift_need_price()
											&& order_total_price >= activityBean2.getGiftBean().getGift_need_price()) {
										activityBean = activityBean2;
									}
								}
							}
						}

						if (activityBean != null) {// 该商品 参加了活动
							if ("give".equals(activityBean.getActivity_type())) {
								orderGoodsBean.setActivity_type("give");
								orderGoodsBean.setGive_need_count(activityBean.getGiveBean().getGive_need_count());
								orderGoodsBean.setGive_count(activityBean.getGiveBean().getGive_count());
							} else if ("reduce".equals(activityBean.getActivity_type())) {
								orderGoodsBean.setActivity_type("reduce");
								orderGoodsBean
										.setReduce_need_price(activityBean.getReduceBean().getReduce_need_price());
								orderGoodsBean.setReduce_price(activityBean.getReduceBean().getReduce_price());
								order_total_price -= activityBean.getReduceBean().getReduce_price();
								order_actual_price -= activityBean.getReduceBean().getReduce_price();
							} else if ("gift".equals(activityBean.getActivity_type())) {
								orderGoodsBean.setActivity_type("gift");
								orderGoodsBean.setGift_desc(activityBean.getGiftBean().getGift_desc());
							}
						}

						num = orderDao
								.updateOrderGoods(orderGoodsBean.setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
										.setTotal_price(orderGoodsBean.getTotal_price()));
						if (num <= 0) {
							throw new Exception("订单商品更新失败");
						}
					}
				}

				DistributionUtils.insertProfit(memberBean, new OrderBean().setOrder_id(orderBean.getOrder_id())
						.setOrder_total_price(order_total_price + ""), memberService, othersService, orderDao);// 何柏瑞的分成

				/*
				 * 会员折扣 放在邮费计算后面
				 */
				if ("business".equals(memberBean.getMember_role())) {// 用户是vip
					PercentBean percentBean2 = othersService.getPercent(new PercentBean().setPercent_type("member"));
					if (percentBean2 != null) {
						float member_discount = Float.valueOf(percentBean2.getPercent_value());
						//order_total_price=order_total_price*member_discount;
						order_actual_price = order_actual_price * member_discount;
						orderBean.setMember_discount(member_discount + "");
					}
				}

				/*
				 * 计算优惠券 需放在邮费和折扣计算后面
				 */
				if (!is_used_coupon) {// 此次下单 优惠卷未用过
					if (orderMerchantsBean.getMember_coupon_id() != null
							&& !orderMerchantsBean.getMember_coupon_id().equals("")) {// 用户选择优惠卷了
						CouponBean couponBean = couponService.getCouponByMemberCouponId(
								new CouponBean().setMember_coupon_id(orderMerchantsBean.getMember_coupon_id()));
						if (couponBean == null) {
							throw new Exception("此优惠券不可用状态");
						}

						float coupon_full_price = Float.valueOf(couponBean.getCoupon_full_price());// 满多少可用优惠券
						if (coupon_full_price <= order_total_price) {// 满足优惠券
																		// 满额条件
							order_actual_price -= Float.valueOf(couponBean.getCoupon_price());// 订单总价
																								// 减去优惠卷的钱
							is_used_coupon = true;
						}

						orderBean.setMember_coupon_id(orderMerchantsBean.getMember_coupon_id());
						orderBean.setCoupon_full_price(coupon_full_price + "");
						orderBean.setCoupon_price(couponBean.getCoupon_price());

						int k = couponService.updateCouponState(couponBean.setCoupon_state("already_used"));// 用完
																											// 更新优惠卷状态
						if (k <= 0) {
							throw new Exception("优惠卷使用失败");
						}
					}

				}

				/*
				 * 积分抵扣计算
				 */
				orderBean.setGive_integral_value(NumberUtils.KeepDecimal(give_integral_value, 2) + "");
				orderBean.setIs_deduct_integral(orderMerchantsBean.getIs_deduct_integral());
				orderBean.setDeduct_integral_percent(percentBean.getPercent_value());// 抵扣的积分的百分比

				if ("1".equals(orderMerchantsBean.getIs_deduct_integral())) {// 是否选择抵扣积分
					if (member_integral_price >= order_total_price) {// 用户积分抵扣的钱大于等于订单的钱
						give_integral_value_total += give_integral_value;

						orderBean.setDeduct_integral_value(NumberUtils.KeepDecimal(
								order_total_price * 100 / Float.valueOf(percentBean.getPercent_value()), 2) + "");
						orderBean.setDeduct_integral_price(NumberUtils.KeepDecimal(order_total_price, 2) + "");
						member_integral_price = member_integral_price - order_total_price;// 用户积分减去订单的钱
						order_actual_price = 0;// 订单实付金额为0
						orderBean.setOrder_state("wait_send");// 如果全用积分付款
																// 则订单直接变成待发货状态

						num = memberService.insertMemberIntegral(new IntegralBean()
								.setMember_id(memberBean.getMember_id() + "").setIntegral_type("order_cut")
								.setIntegral_value(orderBean.getDeduct_integral_value())
								.setRelation_id(orderBean.getOrder_id() + ""));
						if (num <= 0) {
							throw new Exception("积分详情入库失败!");
						}

						if (give_integral_value > 0) {
							num = memberService.insertMemberIntegral(new IntegralBean()
									.setMember_id(memberBean.getMember_id() + "").setIntegral_type("order_add")
									.setIntegral_value(orderBean.getGive_integral_value())
									.setRelation_id(orderBean.getOrder_id() + ""));
							if (num <= 0) {
								throw new Exception("积分详情入库失败!");
							}
						}
					} else {// 用户积分抵扣的钱小于订单的钱
						orderBean.setDeduct_integral_value(NumberUtils.KeepDecimal(
								member_integral_price * 100 / Float.valueOf(percentBean.getPercent_value()), 2) + "");
						orderBean.setDeduct_integral_price(NumberUtils.KeepDecimal(member_integral_price, 2) + "");
						order_actual_price = order_actual_price - member_integral_price;// 订单总价减去用户积分的钱
						member_integral_price = 0;// 用户积分变为0
						orderBean.setOrder_state("wait_pay");
					}
				}

				order_total_actual_price += order_actual_price;
				int m = updateOrderDetail(
						orderBean.setOrder_total_price(NumberUtils.KeepDecimal(order_total_price, 2) + "")
								.setOrder_actual_price(order_actual_price + ""));
				if (m <= 0) {
					throw new Exception("订单更新失败");
				}
			}

			if (give_integral_value_total > 0) {// 有订单全部抵扣积分了 此时把赠送积分赠送了
				memberService
						.updateMemberDetail(
								new MemberBean()
										.setMember_id(
												Integer.valueOf(
														orderMerchantsBean
																.getMember_id()))
										.setIntegral(NumberUtils.KeepDecimal(member_integral_price * 100
												/ Float.valueOf(percentBean.getPercent_value())
												+ give_integral_value_total) + ""));
			} else if ("1".equals(orderMerchantsBean.getIs_deduct_integral())) {// 是否选择抵扣积分
				memberService
						.updateMemberDetail(
								new MemberBean()
										.setMember_id(
												Integer.valueOf(
														orderMerchantsBean
																.getMember_id()))
										.setIntegral(NumberUtils.KeepDecimal(member_integral_price * 100
												/ Float.valueOf(percentBean.getPercent_value())) + ""));// 积分算完
				// 更新用户积分
			}

			if (orderMerchantsBean.getMember_coupon_id() != null
					&& !orderMerchantsBean.getMember_coupon_id().equals("")) {// 用户选择优惠卷了
				if (!is_used_coupon) {// 优惠卷满额要求 没有订单满足条件
					throw new Exception("订单金额未满足优惠卷满额要求");
				}
			}
			Map map = new HashMap();
			map.put("order_ids", Arrays.toString(order_ids).replaceAll("^\\[| |\\]$", ""));
			map.put("order_actual_price", NumberUtils.KeepDecimal(order_total_actual_price, 2) + "");
			return map;
		} else {
			return null;// 未选择商品
		}
	}

	/**
	 * 获得订单价格
	 * @param orderMerchantsBean
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> getOrderPrice(OrderMerchantsBean orderMerchantsBean) throws Exception{	
		List<Map<String, Object>> priceMaps=new ArrayList<Map<String, Object>>();
		
		List<OrderBean> orderBeans = orderMerchantsBean.getOrderBeans();
		PercentBean percentBean = othersService.getPercent(new PercentBean().setPercent_type("integral"));// 积分抵扣比例
		MemberBean memberBean = memberService
				.getMemberByID(new MemberBean().setMember_id(Integer.valueOf(orderMerchantsBean.getMember_id())));
		if (memberBean == null) {
			throw new Exception("用户不存在");
		}

		if (orderBeans != null&&orderBeans.size()>0) {// 订单列表不为null
			float member_integral_price = 0;
			if (memberBean.getMember_code() != null) {
				String xml = HBRUtils.getScore(memberBean.getMember_code());
				String error = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
				if (error != null && !"".equals(error)) {
					throw new Exception(error);
				} else {
					String integral = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "integral");
					member_integral_price = (NumberUtils.Integer(integral)
							* Float.valueOf(percentBean.getPercent_value())) / 100;

				}
			}

			boolean is_used_coupon = false;// 判断优惠卷是否已经用在某个商家店铺了
			float give_integral_value_total = 0;

			for (int i = 0; i < orderBeans.size(); i++) {// 订单 按商家 入库
				float give_integral_value = 0;

				float order_total_price = 0;// 订单总价
				float order_actual_price = 0;// 实际支付金额
				float express_price = 0;// 订单总邮费
				float cross_border_tax = 0;// 税收
				OrderBean orderBean = orderBeans.get(i);
				Map<String, Object> priceMap=new HashMap<String, Object>();
				
				MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
						new MerchantsBean().setMerchants_id(Integer.valueOf(orderBean.getMerchants_id())));
				if (merchantsBean == null) {
					throw new Exception("此商家已下架或已删除");
				}
				List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
				List<OrderGoodsBean> orderGoodsBeans = orderBean.getOrderGoodsBeans();
				
				for (int j = 0; j < orderGoodsBeans.size(); j++) {// 订单商品入库
					double total_price = 0;
					OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(j);// 获得商家订单
																			// 单个商品
					GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
							new GoodsBean().setGoods_id(Integer.valueOf(orderGoodsBean.getGoods_id())));// 获得商品详情
					if (goodsBean == null || "0".equals(goodsBean.getGoods_state())) {
						throw new Exception("此商品下架或者已删除");
					}

					List<ActivityBean> activityBeans = goodsBean.getActivityBeans();// 参加活动
					if (activityBeans != null && activityBeans.size() > 0) {
						ActivityBean activityBean = activityBeans.get(0);
						if ("give".equals(activityBean.getActivity_type())
								&& orderMerchantsBean.getOrder_type().equals("goods")) {
							if (orderGoodsBean.getGoods_num() >= activityBean.getGiveBean().getGive_need_count()) {
								int give_count = 0;
								if ("1".equals(activityBean.getGiveBean().getIs_add())) {// 可递增叠加
									orderGoodsBean.setActivity_type("give");
									orderGoodsBean
											.setGive_need_count(activityBean.getGiveBean().getGive_need_count());
									give_count = activityBean.getGiveBean().getGive_count()
											* (orderGoodsBean.getGoods_num()
													/ activityBean.getGiveBean().getGive_need_count());
									orderGoodsBean.setIs_add("1");
								} else {
									orderGoodsBean.setActivity_type("give");
									orderGoodsBean
											.setGive_need_count(activityBean.getGiveBean().getGive_need_count());
									give_count = activityBean.getGiveBean().getGive_count();
									orderGoodsBean.setIs_add("0");
								}

						
							}
						} else if ("reduce".equals(activityBean.getActivity_type())
								&& orderMerchantsBean.getOrder_type().equals("goods")) {
							List<GoodsBean> goodsBeans = new ArrayList<GoodsBean>();
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("activity_type", "reduce");
							map.put("activity_id", activityBean.getActivity_id());
							map.put("reduce_need_price", activityBean.getReduceBean().getReduce_need_price());
							map.put("reduce_price", activityBean.getReduceBean().getReduce_price());
							map.put("reduce_total_price", NumberUtils.Float(goodsBean.getGoods_now_price())
									* orderGoodsBean.getGoods_num());// 累计的价格
							map.put("is_add", activityBean.getReduceBean().getIs_add());
							boolean is_contain = false;
							for (Map map2 : maps) {
								if (map2.get("activity_id").equals(activityBean.getActivity_id())) {
									is_contain = true;
									map.put("reduce_total_price",
											NumberUtils.Float(goodsBean.getGoods_now_price())
													* orderGoodsBean.getGoods_num()
													+ NumberUtils.Float(map2.get("reduce_total_price").toString()));// 累计的价格
									goodsBeans = (List<GoodsBean>) map2.get("goodsBeans");
									break;
								}
							}
							goodsBeans.add(goodsBean.setOrder_goods_id(orderGoodsBean.getOrder_goods_id()));
							map.put("goodsBeans", goodsBeans);
							maps.add(map);
						} else if ("half".equals(activityBean.getActivity_type())
								&& orderGoodsBean.getGoods_num() >= activityBean.getHalfBean().getHalf_count()
								&& orderMerchantsBean.getOrder_type().equals("goods")) {
							orderGoodsBean.setActivity_type("half");
							orderGoodsBean.setHalf_count(activityBean.getHalfBean().getHalf_count() + "");
							orderGoodsBean.setIs_add(activityBean.getHalfBean().getIs_add());
							float half_price = 0;
							if ("1".equals(activityBean.getHalfBean().getIs_add())) {
								half_price = (orderGoodsBean.getGoods_num() / 2)
										* (NumberUtils.Float(goodsBean.getGoods_now_price()) / 2);
							} else {
								half_price = NumberUtils.Float(goodsBean.getGoods_now_price()) / 2;
							}
							orderGoodsBean.setHalf_price(half_price + "");
							//order_total_price -= half_price;

							order_actual_price -= half_price;
							total_price -= half_price;
						} else if ("exempt".equals(activityBean.getActivity_type())
								&& orderMerchantsBean.getOrder_type().equals("goods")) {
							List<GoodsBean> goodsBeans = new ArrayList<GoodsBean>();

							Map<String, Object> map = new HashMap<String, Object>();
							map.put("activity_type", "exempt");
							map.put("activity_id", activityBean.getActivity_id());
							map.put("exempt_need_count", activityBean.getExemptBean().getExempt_need_count());
							map.put("exempt_count", activityBean.getExemptBean().getExempt_count());
							map.put("exempt_total_count", orderGoodsBean.getGoods_num());
							map.put("is_add", activityBean.getExemptBean().getIs_add());
							for (Map map2 : maps) {
								if (map2.get("activity_id").equals(activityBean.getActivity_id())) {
									map.put("exempt_total_count",
											NumberUtils.Integer(map.get("exempt_total_count").toString())
													+ orderGoodsBean.getGoods_num());
									goodsBeans = (List<GoodsBean>) map2.get("goodsBeans");
									break;
								}
							}
							
							goodsBeans.add(goodsBean
									.setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
									.setGoods_num(orderGoodsBean.getGoods_num()));
							
							map.put("goodsBeans", goodsBeans);
							maps.add(map);
						}
					}

					if (orderMerchantsBean.getOrder_type().equals("goods")) {// 正常商品下单
						order_total_price += Float.valueOf(goodsBean.getGoods_now_price())
								* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱
																				// 乘以
																				// 数量

						order_actual_price += Float.valueOf(goodsBean.getGoods_now_price())
								* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱
																				// 乘以
																				// 数量
						total_price += Float.valueOf(goodsBean.getGoods_now_price())
								* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱

					} else if (orderMerchantsBean.getOrder_type().equals("time_limit")) {// 限时促销下单
						PromotionGoodsBean promotionGoodsBean = new PromotionGoodsBean();
						if ("time_limit".equals(orderMerchantsBean.getOrder_type())) {// 限时促销下单
							promotionGoodsBean = activityService.getOnePromotionGoods(
									new PromotionGoodsBean().setGoods_id(orderGoodsBean.getGoods_id())
											.setPromotion_id(orderGoodsBean.getPromotion_id()));
							if (promotionGoodsBean == null) {
								throw new Exception("此促销商品不存在");
							}

							goodsBean.setPromotion_price(promotionGoodsBean.getPromotion_price());
							goodsBean.setPromotion_goods_id(promotionGoodsBean.getPromotion_goods_id() + "");
						}

						order_total_price += Float.valueOf(promotionGoodsBean.getPromotion_price())
								* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的促销价
																				// 乘以
																				// 数量

						order_actual_price += Float.valueOf(promotionGoodsBean.getPromotion_price())
								* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的促销价
																				// 乘以
																				// 数量

						total_price += Float.valueOf(promotionGoodsBean.getPromotion_price())
								* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的促销价
																				// 乘以
																				// 数量
					} else if ("group_buy".equals(orderMerchantsBean.getOrder_type())) {// 团购下单
						GroupBuyGoodsBean groupBuyGoodsBean = new GroupBuyGoodsBean();
						groupBuyGoodsBean = activityService
								.getGoodsGroupBuyByMember(new GroupBuyMemberBean().setMember_group_buy_id(
										Integer.valueOf(orderMerchantsBean.getMember_group_buy_id())));
						goodsBean.setGroup_buy_price(groupBuyGoodsBean.getGroup_buy_price());
					}

					if ("1".equals(goodsBean.getIs_give_integral())) {
						give_integral_value += Float.valueOf(goodsBean.getGive_integral_value())
								* Float.valueOf(orderGoodsBean.getGoods_num());// 赠送积分
																				// 乘以数量
					}

					if ("0".equals(goodsBean.getIs_express())) {// 计算邮费
						express_price += Float.valueOf(goodsBean.getExpress_price());
					}

					if ("1".equals(goodsBean.getIs_cross_border())) {// 跨境商品
																		// 收跨境税
						order_total_price += NumberUtils.Float(goodsBean.getGoods_now_price())
								* NumberUtils.Float(goodsBean.getCross_border_tax()) * orderGoodsBean.getGoods_num()
								/ 100;//
						cross_border_tax += NumberUtils.Float(goodsBean.getGoods_now_price())
								* NumberUtils.Float(goodsBean.getCross_border_tax()) * orderGoodsBean.getGoods_num()
								/ 100;

						order_actual_price += cross_border_tax;// 总价加上商品的税收

						total_price += cross_border_tax;// 总价加上商品的税收
					}
				}
				
				priceMap.put("cross_border_tax", NumberUtils.KeepDecimal(cross_border_tax,2));

				if (maps.size() > 0) {
					for (int j = 0; j < maps.size(); j++) {
						Map map = maps.get(j);
						if ("reduce".equals(map.get("activity_type"))
								&& NumberUtils.Float(map.get("reduce_total_price").toString()) > NumberUtils
										.Float(map.get("reduce_need_price").toString())) {
							float reduce_price = NumberUtils.Float(map.get("reduce_price").toString());
							if ("1".equals(map.get("is_add"))) {
								reduce_price = reduce_price * NumberUtils
										.KeepDecimal((NumberUtils.Float(map.get("reduce_total_price").toString())
												/ NumberUtils.Float(map.get("reduce_need_price").toString())));
							}
							order_total_price -= reduce_price;
							order_actual_price -= reduce_price;
						} else if ("exempt".equals(map.get("activity_type"))) {
							List<GoodsBean> goodsBeans = (List<GoodsBean>) map.get("goodsBeans");
							int exempt_count = NumberUtils.Integer(map.get("exempt_count").toString());
							int exempt_need_count = NumberUtils.Integer(map.get("exempt_need_count").toString());
							if (NumberUtils.Integer(map.get("exempt_total_count").toString()) >= exempt_need_count) {
								Collections.sort(goodsBeans);// 倒序
								int exempt_now_count = 0;
								float exempt_price = 0;
								for (int k = 0; k < goodsBeans.size(); k++) {
									GoodsBean goodsBean = goodsBeans.get(k);	
									
									if (exempt_now_count + goodsBean.getGoods_num() < exempt_count) {// 还未超过最大数
										exempt_price += goodsBean.getGoods_num()
												* NumberUtils.Float(goodsBean.getGoods_now_price());
									}else if(exempt_now_count + goodsBean.getGoods_num() == exempt_count){
										exempt_price += goodsBean.getGoods_num()
												* NumberUtils.Float(goodsBean.getGoods_now_price());
										break;
									} else {
										exempt_price += (exempt_count-exempt_now_count)
												* NumberUtils.Float(goodsBean.getGoods_now_price());
										break;
									}
								}
								
								order_actual_price -= exempt_price;
							}
						}
					}
				}
				
				priceMap.put("activity_after_price", NumberUtils.KeepDecimal(order_actual_price,2));//活动之后价格
				
				/*
				 * 邮费计算
				 */
				float express_free_price = Float.valueOf(merchantsBean.getExpress_free_price());// 商家设置的订单满多少免邮
				if (express_free_price > express_price) {// 满邮 大于 订单的邮费 则订单总价需加上 邮费
					order_total_price += express_price;// 订单总价 加上邮费
					order_actual_price += express_price;

					priceMap.put("is_free_express", "0");
				} else {
					priceMap.put("is_free_express", "1");
				}
				priceMap.put("express_free_price", express_free_price);
				priceMap.put("express_price", express_price);

				/*
				 * 会员折扣 放在邮费计算后面
				 */
				if ("1".equals(memberBean.getIs_vip())) {// 用户是vip
					PercentBean percentBean2 = othersService
							.getPercent(new PercentBean().setPercent_type(memberBean.getVip_level()));
					if (percentBean2 != null) {
						float member_discount = Float.valueOf(percentBean2.getPercent_value());			
						double member_discount_price=NumberUtils.KeepDecimal(order_actual_price * (1-member_discount),2);				
						priceMap.put("discount_brfore_price", NumberUtils.KeepDecimal(order_actual_price,2));					
						order_actual_price = order_actual_price * member_discount;
						priceMap.put("member_discount", member_discount);
						priceMap.put("member_discount_price", member_discount_price);
					}
				}else{
					priceMap.put("discount_brfore_price", NumberUtils.KeepDecimal(order_actual_price,2));	
					priceMap.put("member_discount", "1");
				}

				/*
				 * 计算优惠券 需放在邮费和折扣计算后面
				 */
				if (!is_used_coupon) {// 此次下单 优惠卷未用过
					if (orderMerchantsBean.getMember_coupon_id() != null
							&& !orderMerchantsBean.getMember_coupon_id().equals("")) {// 用户选择优惠卷了
						CouponBean couponBean = couponService.getCouponByMemberCouponId(
								new CouponBean().setMember_coupon_id(orderMerchantsBean.getMember_coupon_id()));
						if (couponBean == null) {
							throw new Exception("此优惠券不可用状态");
						}

						float coupon_full_price = Float.valueOf(couponBean.getCoupon_full_price());// 满多少可用优惠券
						if (coupon_full_price <= order_total_price) {//满足优惠券 满额条件
							order_actual_price -= Float.valueOf(couponBean.getCoupon_price());// 订单总价 减去优惠卷的钱
							is_used_coupon = true;
						}

						priceMap.put("coupon_full_price", coupon_full_price);
						priceMap.put("coupon_price", couponBean.getCoupon_price());					
					}
				}

				priceMap.put("give_integral_value", NumberUtils.KeepDecimal(give_integral_value, 2));
				priceMap.put("is_deduct_integral",orderMerchantsBean.getIs_deduct_integral());
				priceMap.put("deduct_integral_percent", percentBean.getPercent_value());
				
				/*
				 * 积分抵扣计算
				 */
				double deduct_integral_value = 0;
				if ("1".equals(orderMerchantsBean.getIs_deduct_integral())) {// 是否选择抵扣积分
					if (member_integral_price >= order_total_price) {// 用户积分抵扣的钱大于等于订单的钱\
						give_integral_value_total += give_integral_value;
						deduct_integral_value = NumberUtils.KeepDecimal(
								order_total_price * 100 / Float.valueOf(percentBean.getPercent_value()), 2);
						priceMap.put("deduct_integral_value", deduct_integral_value);
						priceMap.put("deduct_integral_price", NumberUtils.KeepDecimal(order_total_price, 2));						
						member_integral_price = member_integral_price - order_total_price;// 用户积分减去订单的钱
						order_actual_price = 0;// 订单实付金额为0
					} else {// 用户积分抵扣的钱小于订单的钱
						deduct_integral_value = NumberUtils.KeepDecimal(member_integral_price * 100 / Float.valueOf(percentBean.getPercent_value()), 2);
						priceMap.put("deduct_integral_value", deduct_integral_value);
						priceMap.put("deduct_integral_price", NumberUtils.KeepDecimal(member_integral_price, 2));
						order_actual_price = order_actual_price - member_integral_price;// 订单总价减去用户积分的钱
						member_integral_price = 0;// 用户积分抵扣的钱变为0
					}
				}else{
					if (member_integral_price >= order_total_price) {// 用户积分抵扣的钱大于等于订单的钱\
						deduct_integral_value = NumberUtils.KeepDecimal(
								order_total_price * 100 / Float.valueOf(percentBean.getPercent_value()), 2);
						priceMap.put("deduct_integral_value", deduct_integral_value);
						priceMap.put("deduct_integral_price", NumberUtils.KeepDecimal(order_total_price, 2));		
					} else {// 用户积分抵扣的钱小于订单的钱
						deduct_integral_value = NumberUtils.KeepDecimal(member_integral_price * 100 / Float.valueOf(percentBean.getPercent_value()), 2);
						priceMap.put("deduct_integral_value", deduct_integral_value);
						priceMap.put("deduct_integral_price", NumberUtils.KeepDecimal(member_integral_price, 2));
					}
				}
				
				priceMap.put("order_actual_price", NumberUtils.KeepDecimal(order_actual_price,2));
				priceMaps.add(priceMap);
			}

			if (orderMerchantsBean.getMember_coupon_id() != null&& !orderMerchantsBean.getMember_coupon_id().equals("")) {// 用户选择优惠卷了
				if (!is_used_coupon) {// 优惠卷满额要求 没有订单满足条件
					throw new Exception("订单金额未满足优惠卷满额要求");
				}
			}
		} else {
			throw new Exception("无任何订单信息");
		}
		return priceMaps;
	}
	
	/**
	 * 添加订单
	 * 
	 * @param orderBean
	 * @return
	 * @throws Exception
	 */
	public String insertOrderHBR(OrderMerchantsBean orderMerchantsBean) throws Exception {
		List<OrderBean> orderBeans2 = orderMerchantsBean.getOrderBeans();
		List<OrderBean> orderBeans3 = new ArrayList<OrderBean>();

		for (int i = 0; i < orderBeans2.size(); i++) {
			OrderBean orderBean = orderBeans2.get(i);
			OrderBean orderBean2 = new OrderBean().setMerchants_id(orderBean.getMerchants_id());
			OrderBean orderBean3 = new OrderBean().setMerchants_id(orderBean.getMerchants_id());

			List<OrderGoodsBean> orderGoodsBeans = orderBean.getOrderGoodsBeans();
			List<OrderGoodsBean> orderGoodsBeans2 = new ArrayList<OrderGoodsBean>();
			List<OrderGoodsBean> orderGoodsBeans3 = new ArrayList<OrderGoodsBean>();
			for (int j = 0; j < orderGoodsBeans.size(); j++) {
				OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(j);// 获得商家订单
																		// 单个商品
				GoodsBean goodsBean = goodsServiceI
						.getOneGoodsDetail(new GoodsBean().setGoods_id(Integer.valueOf(orderGoodsBean.getGoods_id())));// 获得商品详情

				if ("1".equals(goodsBean.getIs_cross_border())) {
					orderGoodsBeans2.add(orderGoodsBean);
				} else {
					orderGoodsBeans3.add(orderGoodsBean);
				}
			}
			orderBean2.setOrderGoodsBeans(orderGoodsBeans2);
			orderBean3.setOrderGoodsBeans(orderGoodsBeans3);

			if (orderGoodsBeans2.size() > 0) {
				orderBeans3.add(orderBean2);
			}
			if (orderGoodsBeans3.size() > 0) {
				orderBeans3.add(orderBean3);
			}
		}

		orderMerchantsBean.setOrderBeans(orderBeans3);

		AddressBean addressBean = addressService
				.getAddressById(new AddressBean().setAddress_id(Integer.valueOf(orderMerchantsBean.getAddress_id())));// 地址详情
		if (addressBean == null) {
			throw new Exception("地址不存在");
		}

		List<OrderBean> orderBeans = orderMerchantsBean.getOrderBeans();
		int num = -1;

		String shop_car_ids = orderMerchantsBean.getShopping_car_ids();
		if (shop_car_ids != null && shop_car_ids.length() > 0) {
			String[] car_ids = shop_car_ids.split(",");
			for (int i = 0; i < car_ids.length; i++) {
				int m = shoppingCarService.deleteShoppingCar(new ShoppingCarBean()
						.setCar_id(Integer.valueOf(car_ids[i])).setMember_id(orderMerchantsBean.getMember_id()));
				if (m <= 0) {
					throw new Exception("购物车删除失败");
				}
			}
		}

		PercentBean percentBean = othersService.getPercent(new PercentBean().setPercent_type("integral"));// 积分抵扣比例
		// HostBean hostBean=othersService.getHost(new
		// HostBean().setHost_type("1"));
		MemberBean memberBean = memberService
				.getMemberByID(new MemberBean().setMember_id(Integer.valueOf(orderMerchantsBean.getMember_id())));
		if (memberBean == null) {
			throw new Exception("用户不存在");
		}

		if (orderBeans != null) {// 订单列表不为null
			String[] order_ids = new String[orderBeans.size()];
			float member_integral_price = 0;

			if (memberBean.getMember_code() != null) {
				String xml = HBRUtils.getScore(memberBean.getMember_code());
				String error = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
				if (error != null && !"".equals(error)) {
					throw new Exception(error);
				} else {
					String integral = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "integral");
					member_integral_price = (NumberUtils.Integer(integral)
							* Float.valueOf(percentBean.getPercent_value())) / 100;

				}
			}

			boolean is_used_coupon = false;// 判断优惠卷是否已经用在某个商家店铺了
			float give_integral_value_total = 0;

			for (int i = 0; i < orderBeans.size(); i++) {// 订单 按商家 入库
				float give_integral_value = 0;

				float order_total_price = 0;// 订单总价
				float order_actual_price = 0;// 实际支付金额
				float express_price = 0;// 订单总邮费
				float cross_border_tax = 0;// 税收
				OrderBean orderBean = orderBeans.get(i);

				MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
						new MerchantsBean().setMerchants_id(Integer.valueOf(orderBean.getMerchants_id())));
				if (merchantsBean == null) {
					throw new Exception("此商家已下架或已删除");
				}
			
				orderBean.setMerchantsBean(merchantsBean);
				orderBean.setAddressBean(addressBean);
				UUIDUtils uuidUtils = new UUIDUtils(1);
				String order_no = uuidUtils.nextId(false, 1) + "";
				orderBean.setOrder_state("wait_pay");// 订单状态
				orderBean.setOrder_no(order_no);// 订单号
				orderBean.setMember_id(orderMerchantsBean.getMember_id());// 用户id
				orderBean.setAddress_id(orderMerchantsBean.getAddress_id());// 地址id

				orderBean.setOrder_type(orderMerchantsBean.getOrder_type());// 订单类型
				orderBean.setMember_group_buy_id(orderMerchantsBean.getMember_group_buy_id());// 用户团购id
				orderBean.setBusiness_id(memberBean.getBusiness_id());
				orderBean.setMerchants_account_id(memberBean.getMerchants_account_id());

				num = orderDao.insertOrder(orderBean);// 订单入库
				order_ids[i] = orderBean.getOrder_id() + "";

				List<Map> maps = new ArrayList<Map>();
				if (num > 0) {
					List<OrderGoodsBean> orderGoodsBeans = orderBean.getOrderGoodsBeans();
					for (int j = 0; j < orderGoodsBeans.size(); j++) {// 订单商品入库
						double total_price = 0;
						OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(j);//获得商家订单 单个商品
						GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(new GoodsBean()
								.setGoods_id(Integer.valueOf(orderGoodsBean.getGoods_id())));// 获得商品详情
						if (goodsBean == null || "0".equals(goodsBean.getGoods_state())) {
							throw new Exception("此商品下架或者已删除");
						}												

						if (goodsBean.getGoods_stock() < orderGoodsBean.getGoods_num()) {
							throw new Exception("不好意思!库存不足");
						} else {
							int goods_stock = goodsBean.getGoods_stock() - orderGoodsBean.getGoods_num();

							int k = goodsServiceI2.updateGoodsDetail(new GoodsBean()
									.setGoods_id(goodsBean.getGoods_id()).setGoods_stock(goods_stock));
							if (k <= 0) {
								throw new Exception("更新商品信息失败");
							}
						}

						orderGoodsBean.setGoodsBean(goodsBean);
						orderGoodsBean.setGoods_price(goodsBean.getGoods_now_price());
						int k = orderDao.insertOrderGoods(orderGoodsBean.setOrder_id(orderBean.getOrder_id() + ""));
						if (k <= 0) {
							throw new Exception("商品入库失败");
						}

						List<ActivityBean> activityBeans = goodsBean.getActivityBeans();// 参加活动
						if (activityBeans != null && activityBeans.size() > 0) {
							ActivityBean activityBean = activityBeans.get(0);
							if ("give".equals(activityBean.getActivity_type())
									&& orderMerchantsBean.getOrder_type().equals("goods")) {
								if (orderGoodsBean.getGoods_num() >= activityBean.getGiveBean().getGive_need_count()) {
									int give_count = 0;
									if ("1".equals(activityBean.getGiveBean().getIs_add())) {// 可递增叠加
										orderGoodsBean.setActivity_type("give");
										orderGoodsBean
												.setGive_need_count(activityBean.getGiveBean().getGive_need_count());
										give_count = activityBean.getGiveBean().getGive_count()
												* (orderGoodsBean.getGoods_num()
														/ activityBean.getGiveBean().getGive_need_count());
										orderGoodsBean.setIs_add("1");
									} else {
										orderGoodsBean.setActivity_type("give");
										orderGoodsBean
												.setGive_need_count(activityBean.getGiveBean().getGive_need_count());
										give_count = activityBean.getGiveBean().getGive_count();
										orderGoodsBean.setIs_add("0");
									}

									int h = orderDao.insertOrderActivity(new OrderActivityBean()
											.setActivity_id(activityBean.getActivity_id())
											.setOrder_id(orderBean.getOrder_id())
											.setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
											.setIs_add(activityBean.getGiveBean().getIs_add()).setActivity_type("give")
											.setGive_need_count(activityBean.getGiveBean().getGive_need_count() + "")
											.setGive_actual_count(give_count+"")
											.setGive_count(activityBean.getGiveBean().getGive_count()+""));
									if (h < 0) {
										throw new Exception("添加满送活动失败!");
									}
								}
							} else if ("reduce".equals(activityBean.getActivity_type())
									&& orderMerchantsBean.getOrder_type().equals("goods")) {
								List<GoodsBean> goodsBeans = new ArrayList<GoodsBean>();
								Map<String, Object> map = new HashMap<String, Object>();
								map.put("activity_type", "reduce");
								map.put("activity_id", activityBean.getActivity_id());
								map.put("reduce_need_price", activityBean.getReduceBean().getReduce_need_price());
								map.put("reduce_price", activityBean.getReduceBean().getReduce_price());
								map.put("reduce_total_price", NumberUtils.Float(goodsBean.getGoods_now_price())
										* orderGoodsBean.getGoods_num());// 累计的价格
								map.put("is_add", activityBean.getReduceBean().getIs_add());
								boolean is_contain = false;
								for (Map map2 : maps) {
									if (map2.get("activity_id").equals(activityBean.getActivity_id())) {
										is_contain = true;
										map.put("reduce_total_price",
												NumberUtils.Float(goodsBean.getGoods_now_price())
														* orderGoodsBean.getGoods_num()
														+ NumberUtils.Float(map2.get("reduce_total_price").toString()));// 累计的价格
										goodsBeans = (List<GoodsBean>) map2.get("goodsBeans");
										break;
									}
								}
								goodsBeans.add(goodsBean.setOrder_goods_id(orderGoodsBean.getOrder_goods_id()));
								map.put("goodsBeans", goodsBeans);
								maps.add(map);
							} else if ("half".equals(activityBean.getActivity_type())
									&& orderGoodsBean.getGoods_num() >= activityBean.getHalfBean().getHalf_count()
									&& orderMerchantsBean.getOrder_type().equals("goods")) {
								orderGoodsBean.setActivity_type("half");
								orderGoodsBean.setHalf_count(activityBean.getHalfBean().getHalf_count() + "");
								orderGoodsBean.setIs_add(activityBean.getHalfBean().getIs_add());
								float half_price = 0;
								if ("1".equals(activityBean.getHalfBean().getIs_add())) {
									half_price = (orderGoodsBean.getGoods_num() / 2)
											* (NumberUtils.Float(goodsBean.getGoods_now_price()) / 2);
								} else {
									half_price = NumberUtils.Float(goodsBean.getGoods_now_price()) / 2;
								}
								orderGoodsBean.setHalf_price(half_price + "");
								//order_total_price -= half_price;

								order_actual_price -= half_price;
								total_price -= half_price;

								int h = orderDao.insertOrderActivity(new OrderActivityBean()
										.setActivity_id(activityBean.getActivity_id())
										.setOrder_id(orderBean.getOrder_id())
										.setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
										.setIs_add(activityBean.getHalfBean().getIs_add())
										.setActivity_type("half")
										.setHalf_count(activityBean.getHalfBean().getHalf_count() + "")
										.setHalf_price(half_price + ""));
								if (h < 0) {
									throw new Exception("添加半价活动");
								}
							} else if ("exempt".equals(activityBean.getActivity_type())
									&& orderMerchantsBean.getOrder_type().equals("goods")) {
								List<GoodsBean> goodsBeans = new ArrayList<GoodsBean>();

								Map<String, Object> map = new HashMap<String, Object>();
								map.put("activity_type", "exempt");
								map.put("activity_id", activityBean.getActivity_id());
								map.put("exempt_need_count", activityBean.getExemptBean().getExempt_need_count());
								map.put("exempt_count", activityBean.getExemptBean().getExempt_count());
								map.put("exempt_total_count", orderGoodsBean.getGoods_num());
								map.put("is_add", activityBean.getExemptBean().getIs_add());
								for (Map map2 : maps) {
									if (map2.get("activity_id").equals(activityBean.getActivity_id())) {
										map.put("exempt_total_count",
												NumberUtils.Integer(map.get("exempt_total_count").toString())
														+ orderGoodsBean.getGoods_num());
										goodsBeans = (List<GoodsBean>) map2.get("goodsBeans");
										break;
									}
								}
								
								goodsBeans.add(goodsBean
										.setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
										.setGoods_num(orderGoodsBean.getGoods_num()));
								
								map.put("goodsBeans", goodsBeans);
								maps.add(map);
							}
						}

						if (orderMerchantsBean.getOrder_type().equals("goods")) {// 正常商品下单
							order_total_price += Float.valueOf(goodsBean.getGoods_now_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱
																					// 乘以
																					// 数量

							order_actual_price += Float.valueOf(goodsBean.getGoods_now_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱
																					// 乘以
																					// 数量
							total_price += Float.valueOf(goodsBean.getGoods_now_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的钱

						} else if (orderMerchantsBean.getOrder_type().equals("time_limit")) {// 限时促销下单
							PromotionGoodsBean promotionGoodsBean = new PromotionGoodsBean();
							if ("time_limit".equals(orderMerchantsBean.getOrder_type())) {// 限时促销下单
								promotionGoodsBean = activityService.getOnePromotionGoods(
										new PromotionGoodsBean().setGoods_id(orderGoodsBean.getGoods_id())
												.setPromotion_id(orderGoodsBean.getPromotion_id()));
								if (promotionGoodsBean == null) {
									throw new Exception("此促销商品不存在");
								}

								goodsBean.setPromotion_price(promotionGoodsBean.getPromotion_price());
								goodsBean.setPromotion_goods_id(promotionGoodsBean.getPromotion_goods_id() + "");
							}

							order_total_price += Float.valueOf(promotionGoodsBean.getPromotion_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的促销价
																					// 乘以
																					// 数量

							order_actual_price += Float.valueOf(promotionGoodsBean.getPromotion_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的促销价
																					// 乘以
																					// 数量

							total_price += Float.valueOf(promotionGoodsBean.getPromotion_price())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 总价加上商品的促销价
																					// 乘以
																					// 数量
						} else if ("group_buy".equals(orderMerchantsBean.getOrder_type())) {// 团购下单
							GroupBuyGoodsBean groupBuyGoodsBean = new GroupBuyGoodsBean();
							groupBuyGoodsBean = activityService
									.getGoodsGroupBuyByMember(new GroupBuyMemberBean().setMember_group_buy_id(
											Integer.valueOf(orderMerchantsBean.getMember_group_buy_id())));
							goodsBean.setGroup_buy_price(groupBuyGoodsBean.getGroup_buy_price());
						}

						if ("1".equals(goodsBean.getIs_give_integral())) {
							give_integral_value += Float.valueOf(goodsBean.getGive_integral_value())
									* Float.valueOf(orderGoodsBean.getGoods_num());// 赠送积分
																					// 乘以数量
						}

						if ("0".equals(goodsBean.getIs_express())) {// 计算邮费
							express_price += Float.valueOf(goodsBean.getExpress_price());
						}

						if ("1".equals(goodsBean.getIs_cross_border())) {// 跨境商品
																			// 收跨境税
							order_total_price += NumberUtils.Float(goodsBean.getGoods_now_price())
									* NumberUtils.Float(goodsBean.getCross_border_tax()) * orderGoodsBean.getGoods_num()
									/ 100;//
							cross_border_tax += NumberUtils.Float(goodsBean.getGoods_now_price())
									* NumberUtils.Float(goodsBean.getCross_border_tax()) * orderGoodsBean.getGoods_num()
									/ 100;

							order_actual_price += cross_border_tax;// 总价加上商品的税收

							total_price += cross_border_tax;// 总价加上商品的税收
						}

						num = orderDao.updateOrderGoods(orderGoodsBean
								.setOrder_goods_id(orderGoodsBean.getOrder_goods_id()).setTotal_price(total_price));
						if (num <= 0) {
							throw new Exception("订单商品更新失败");
						}
					}
				}

				if (maps.size() > 0) {
					for (int j = 0; j < maps.size(); j++) {
						Map map = maps.get(j);
						if ("reduce".equals(map.get("activity_type"))
								&& NumberUtils.Float(map.get("reduce_total_price").toString()) > NumberUtils
										.Float(map.get("reduce_need_price").toString())) {
							float reduce_price = NumberUtils.Float(map.get("reduce_price").toString());
							if ("1".equals(map.get("is_add"))) {
								reduce_price = reduce_price * NumberUtils
										.KeepDecimal((NumberUtils.Float(map.get("reduce_total_price").toString())
												/ NumberUtils.Float(map.get("reduce_need_price").toString())));
							}
							//order_total_price -= reduce_price;
							order_actual_price -= reduce_price;

							List<GoodsBean> goodsBeans = (List<GoodsBean>) map.get("goodsBeans");
							for (int k = 0; k < goodsBeans.size(); k++) {
								int h = orderDao.insertOrderActivity(
										new OrderActivityBean().setOrder_id(orderBean.getOrder_id())
												.setActivity_id(NumberUtils.Integer(map.get("activity_id").toString()))
												.setOrder_goods_id(goodsBeans.get(k).getOrder_goods_id())
												.setIs_add(map.get("is_add").toString()).setActivity_type("reduce")
												.setReduce_actual_price(reduce_price + "")
												.setReduce_total_price(map.get("reduce_total_price").toString())
												.setReduce_need_price(map.get("reduce_need_price").toString())
												.setReduce_price(map.get("reduce_price").toString()));
								if (h < 0) {
									throw new Exception("添加满减活动");
								}
							}
						} else if ("exempt".equals(map.get("activity_type"))) {
							List<GoodsBean> goodsBeans = (List<GoodsBean>) map.get("goodsBeans");
							int exempt_count = NumberUtils.Integer(map.get("exempt_count").toString());
							int exempt_need_count = NumberUtils.Integer(map.get("exempt_need_count").toString());
							if (NumberUtils.Integer(map.get("exempt_total_count").toString()) >= exempt_need_count) {
								Collections.sort(goodsBeans);// 倒序
								int exempt_now_count = 0;
								float exempt_price = 0;
								for (int k = 0; k < goodsBeans.size(); k++) {
									GoodsBean goodsBean = goodsBeans.get(k);	
									
									if (exempt_now_count + goodsBean.getGoods_num() < exempt_count) {// 还未超过最大数
										exempt_price += goodsBean.getGoods_num()
												* NumberUtils.Float(goodsBean.getGoods_now_price());
									}else if(exempt_now_count + goodsBean.getGoods_num() == exempt_count){
										exempt_price += goodsBean.getGoods_num()
												* NumberUtils.Float(goodsBean.getGoods_now_price());
										break;
									} else {
										exempt_price += (exempt_count-exempt_now_count)
												* NumberUtils.Float(goodsBean.getGoods_now_price());
										break;
									}
								}
								
								for (int k = 0; k < goodsBeans.size(); k++) {									
									int h = orderDao.insertOrderActivity(
											new OrderActivityBean().setOrder_id(orderBean.getOrder_id())
													.setActivity_id(NumberUtils.Integer(map.get("activity_id").toString()))
													.setOrder_goods_id(goodsBeans.get(k).getOrder_goods_id())
													.setIs_add(map.get("is_add").toString())
													.setActivity_type("exempt")
													.setExempt_count(map.get("exempt_count").toString())
													.setExempt_need_count(map.get("exempt_need_count").toString())
													.setExempt_price(exempt_price+""));
									if (h < 0) {
										throw new Exception("添加满免活动");
									}
								}
								//order_total_price -= exempt_price;
								order_actual_price -= exempt_price;
							}
						}
					}
				}

				/*
				 * 邮费计算
				 */
				float express_free_price = Float.valueOf(merchantsBean.getExpress_free_price());// 商家设置的订单满多少免邮
				if (express_free_price > express_price) {// 满邮 大于 订单的邮费 则订单总价需加上 邮费
					order_total_price += express_price;//订单总价 加上邮费
					order_actual_price += express_price;
					
					orderBean.setIs_free_express("0");// 不免邮
				} else {
					orderBean.setIs_free_express("1");// 免邮
				}
				orderBean.setExpress_free_price(express_free_price + "");// 满多少包邮
				orderBean.setExpress_price(express_price + "");// 邮费

				DistributionUtils.insertProfit(memberBean, new OrderBean().setOrder_id(orderBean.getOrder_id())
						.setOrder_total_price(order_total_price + ""), memberService, othersService, orderDao);// 何柏瑞的分成

				/*
				 * 会员折扣 放在邮费计算后面
				 */
				if ("1".equals(memberBean.getIs_vip())) {// 用户是vip
					PercentBean percentBean2 = othersService
							.getPercent(new PercentBean().setPercent_type(memberBean.getVip_level()));
					if (percentBean2 != null) {
						float member_discount = Float.valueOf(percentBean2.getPercent_value());			
						double member_discount_price=NumberUtils.KeepDecimal(order_actual_price * (1-member_discount),2);
						
						order_actual_price = order_actual_price * member_discount;
						orderBean.setMember_discount(member_discount + "");
						orderBean.setMember_discount_price(member_discount_price + "");
					}
				}

				/*
				 * 计算优惠券 需放在邮费和折扣计算后面
				 */
				if (!is_used_coupon) {// 此次下单 优惠卷未用过
					if (orderMerchantsBean.getMember_coupon_id() != null
							&& !orderMerchantsBean.getMember_coupon_id().equals("")) {// 用户选择优惠卷了
						
						CouponBean couponBean = couponService.getCouponByMemberCouponId(
								new CouponBean().setMember_coupon_id(orderMerchantsBean.getMember_coupon_id()));
						if (couponBean == null) {
							throw new Exception("此优惠券不可用状态");
						}

						float coupon_full_price = Float.valueOf(couponBean.getCoupon_full_price());// 满多少可用优惠券
						if (coupon_full_price <= order_total_price) {// 满足优惠券 满额条件
							order_actual_price -= Float.valueOf(couponBean.getCoupon_price());// 订单总价 减去优惠卷的钱
							is_used_coupon = true;
						}

						orderBean.setMember_coupon_id(orderMerchantsBean.getMember_coupon_id());
						orderBean.setCoupon_full_price(coupon_full_price + "");
						orderBean.setCoupon_price(couponBean.getCoupon_price());

						int k = couponService.updateCouponState(couponBean.setCoupon_state("already_used"));//用完 更新优惠卷状态
						if (k <= 0) {
							throw new Exception("优惠卷使用失败");
						}
					}
				}

				/*
				 * 积分抵扣计算
				 */
				orderBean.setGive_integral_value(NumberUtils.KeepDecimal(give_integral_value, 2) + "");
				orderBean.setIs_deduct_integral(orderMerchantsBean.getIs_deduct_integral());
				orderBean.setDeduct_integral_percent(percentBean.getPercent_value());// 抵扣的积分的百分比

				double deduct_integral_value = 0;
				if ("1".equals(orderMerchantsBean.getIs_deduct_integral())) {// 是否选择抵扣积分
					if (member_integral_price >= order_total_price) {// 用户积分抵扣的钱大于等于订单的钱\

						give_integral_value_total += give_integral_value;

						deduct_integral_value = NumberUtils.KeepDecimal(
								order_total_price * 100 / Float.valueOf(percentBean.getPercent_value()), 2);

						orderBean.setDeduct_integral_value(deduct_integral_value + "");
						orderBean.setDeduct_integral_price(NumberUtils.KeepDecimal(order_total_price, 2) + "");
						member_integral_price = member_integral_price - order_total_price;// 用户积分减去订单的钱
						order_actual_price = 0;// 订单实付金额为0
						orderBean.setOrder_state("wait_send");// 如果全用积分付款
																// 则订单直接变成待发货状态

						num = memberService.insertMemberIntegral(new IntegralBean()
								.setMember_id(memberBean.getMember_id() + "").setIntegral_type("order_cut")
								.setIntegral_value(orderBean.getDeduct_integral_value())
								.setRelation_id(orderBean.getOrder_id() + ""));// 积分记录
						if (num <= 0) {
							throw new Exception("积分详情入库失败!");
						}

						if (give_integral_value > 0) {
							num = memberService.insertMemberIntegral(new IntegralBean()
									.setMember_id(memberBean.getMember_id() + "").setIntegral_type("order_add")
									.setIntegral_value(orderBean.getGive_integral_value())
									.setRelation_id(orderBean.getOrder_id() + ""));
							if (num <= 0) {
								throw new Exception("积分详情入库失败!");
							}
						}
					} else {// 用户积分抵扣的钱小于订单的钱
						deduct_integral_value = NumberUtils.KeepDecimal(
								member_integral_price * 100 / Float.valueOf(percentBean.getPercent_value()), 2);
						orderBean.setDeduct_integral_value(deduct_integral_value + "");
						orderBean.setDeduct_integral_price(NumberUtils.KeepDecimal(member_integral_price, 2) + "");
						order_actual_price = order_actual_price - member_integral_price;// 订单总价减去用户积分的钱
						member_integral_price = 0;// 用户积分抵扣的钱变为0
						orderBean.setOrder_state("wait_pay");
					}
				}

				if (memberBean.getMember_code() != null) {
					if ("1".equals(orderMerchantsBean.getIs_deduct_integral())) {
						String xml = HBRUtils.modifyIntegral(memberBean.getMember_code(), orderBean.getOrder_id() + "",
								(-deduct_integral_value) + "", "2", "25");
						String error = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
						if (error != null && !"".equals(error)) {
							throw new Exception(error);
						}
					}

					if (give_integral_value_total > 0) {
						String xml = HBRUtils.modifyIntegral(memberBean.getMember_code(), orderBean.getOrder_id() + "",
								give_integral_value_total + "", "1", "17");
						String error = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
						if (error != null && !"".equals(error)) {
							throw new Exception(error);
						}
					}
				}

				int m = updateOrderDetail(orderBean.setOrder_total_price(NumberUtils.KeepDecimal(order_total_price, 2) + "")
								.setOrder_actual_price(NumberUtils.KeepDecimal(order_actual_price, 2) + "")
								.setCross_border_tax(NumberUtils.KeepDecimal(cross_border_tax, 2) + ""));
				if (m <= 0) {
					throw new Exception("订单更新失败");
				}
			}

			if (orderMerchantsBean.getMember_coupon_id() != null
					&& !orderMerchantsBean.getMember_coupon_id().equals("")) {// 用户选择优惠卷了
				if (!is_used_coupon) {//优惠卷满额要求 没有订单满足条件
					throw new Exception("订单金额未满足优惠卷满额要求");
				}
			}
			return Arrays.toString(order_ids).replaceAll("^\\[| |\\]$", "");
		} else {
			return "-1";// 未选择商品
		}
	}

	/**
	 * 获得订单列表
	 * 
	 * @return
	 */
	public List<OrderBean> getOrdersByPayNo(OrderBean orderBean) {
		return orderDao.getOrdersByPayNo(orderBean);
	}

	/**
	 * 获得订单列表
	 * 
	 * @return
	 */
	public List<OrderBean> getOrders(OrderBean orderBean, PageBean pageBean) {
		List<OrderBean> orderBeans = orderDao.getOrders(orderBean, pageBean);
		for (int i = 0; i < orderBeans.size(); i++) {
			OrderBean orderBean1 = orderBeans.get(i);
			List<OrderGoodsBean> orderGoodsBeans = getOrderGoodss(
					new OrderGoodsBean().setOrder_id(orderBean1.getOrder_id() + ""));
			orderBean1.setOrderGoodsBeans(orderGoodsBeans);

			List<LogisticsDetailBean> logisticsDetailBeans = orderDao
					.getOrderLogisticsDetails(new LogisticsDetailBean().setLogistics_no(orderBean1.getLogistics_no()));
			orderBean1.setLogisticsDetailBeans(logisticsDetailBeans);

			MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
					new MerchantsBean().setMerchants_id(Integer.valueOf(orderBean1.getMerchants_id())));
			orderBean1.setMerchantsBean(merchantsBean);
		}
		return orderBeans;
	}

	/**
	 * 获得订单列表 每个状态统计
	 * 
	 * @param orderBean
	 * @return
	 */
	public Map getOrdersCount(OrderBean orderBean) {
		return orderDao.getOrdersCount(orderBean);
	}

	/**
	 * 单个订单详情
	 * 
	 * @param orderBean
	 * @return
	 */
	public OrderBean getOneOrderDetail(OrderBean orderBean) {
		OrderBean orderBean1 = orderDao.getOneOrderDetail(orderBean);
		if (orderBean1 != null) {
			List<OrderGoodsBean> orderGoodsBeans = getOrderGoodss(
					new OrderGoodsBean().setOrder_id(orderBean1.getOrder_id() + ""));
			orderBean1.setOrderGoodsBeans(orderGoodsBeans);
			for (int j = 0; j < orderGoodsBeans.size(); j++) {
				List<GoodsImgBean> goodsImgBeans = goodsServiceI
						.getGoodsImgs(new GoodsImgBean().setGoods_id(orderGoodsBeans.get(j).getGoods_id()));
				orderGoodsBeans.get(j).setGoodsImgBeans(goodsImgBeans);
			}

			MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
					new MerchantsBean().setMerchants_id(Integer.valueOf(orderBean1.getMerchants_id())));
			orderBean1.setMerchantsBean(merchantsBean);
		}
		return orderBean1;
	}

	/**
	 * 单个订单详情
	 * 
	 * @param orderBean
	 * @return
	 */
	public OrderBean getOneOrderDetailZSSG(OrderBean orderBean) {
		return orderDao.getOneOrderDetail(orderBean);
	}

	/**
	 * 订单活动列表
	 * @param orderActivityBean
	 * @return
	 */
	public List<OrderActivityBean> getOrderActivitys(OrderActivityBean orderActivityBean){
		return orderDao.getOrderActivitys(orderActivityBean);
	}
	/**
	 * 获得订单商品列表
	 * 
	 * @return
	 */
	public List<OrderGoodsBean> getOrderGoodss(OrderGoodsBean orderGoodsBean) {
		List<OrderGoodsBean> orderGoodsBeans = orderDao.getOrderGoodss(orderGoodsBean);
		for (int j = 0; j < orderGoodsBeans.size(); j++) {
			List<GoodsImgBean> goodsImgBeans = goodsServiceI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(orderGoodsBeans.get(j).getGoods_id()));
			orderGoodsBeans.get(j).setGoodsImgBeans(goodsImgBeans);

			List<OrderParameterBean> orderParameterBeans = orderDao
					.getOrderParameters(new OrderParameterBean().setOrder_id(orderGoodsBean.getOrder_id() + "")
							.setOrder_goods_id(orderGoodsBeans.get(j).getOrder_goods_id() + ""));
			orderGoodsBeans.get(j).setOrderParameterBeans(orderParameterBeans);

			List<OrderServiceBean> orderServiceBeans = orderDao
					.getOrderServices(new OrderServiceBean().setOrder_id(orderGoodsBean.getOrder_id() + "")
							.setOrder_goods_id(orderGoodsBeans.get(j).getOrder_goods_id() + ""));
			orderGoodsBeans.get(j).setOrderServiceBeans(orderServiceBeans);
		}
		return orderGoodsBeans;
	}

	/**
	 * 获得单个订单商品
	 * 
	 * @return
	 */
	public OrderGoodsBean getOrderGoodssByGoods(OrderGoodsBean orderGoodsBean) {
		OrderGoodsBean orderGoodsBean2 = orderDao.getOrderGoodssByGoods(orderGoodsBean);

		List<OrderParameterBean> orderParameterBeans = orderDao
				.getOrderParameters(new OrderParameterBean().setOrder_id(orderGoodsBean.getOrder_id() + "")
						.setOrder_goods_id(orderGoodsBean2.getOrder_goods_id() + ""));
		orderGoodsBean2.setOrderParameterBeans(orderParameterBeans);

		List<OrderServiceBean> orderServiceBeans = orderDao
				.getOrderServices(new OrderServiceBean().setOrder_id(orderGoodsBean.getOrder_id() + "")
						.setOrder_goods_id(orderGoodsBean2.getOrder_goods_id() + ""));
		orderGoodsBean2.setOrderServiceBeans(orderServiceBeans);

		return orderGoodsBean2;
	}

	/**
	 * 取消订单
	 * 
	 * @param orderBean
	 * @return
	 * @throws Exception
	 */
	public int cancelOrder(OrderBean orderBean) throws Exception {
		int num = orderDao.cancelOrder(orderBean);
		if (num > 0) {
			HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));
			MemberBean memberBean = memberService
					.getMemberByID(new MemberBean().setMember_id(Integer.valueOf(orderBean.getMember_id())));
			float member_integral = 0;
			if ("hbr".equals(hostBean.getCompany_name())) {
				String xml = "";
				xml = HBRUtils.getScore(memberBean.getMember_code());
				String integral = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "integral");
				member_integral = NumberUtils.Float(integral);// 用户现有积分
			} else {
				member_integral = NumberUtils.Float(memberBean.getIntegral());// 用户现有积分
			}
			if ("1".equals(orderBean.getIs_deduct_integral())) {// 如果抵扣积分了
																// 要先返还积分
				member_integral += Float.valueOf(orderBean.getDeduct_integral_value());
			}

//			if (orderBean.getGive_integral_value() != null) {
//				member_integral -= NumberUtils.Float(orderBean.getGive_integral_value());
//			}

			if (member_integral < 0) {
				throw new Exception("积分不足 无法取消!请联系客服!");
			}

			if ("1".equals(orderBean.getIs_deduct_integral())) {// 如果抵扣积分了
				// 要先返还积分
				if ("hbr".equals(hostBean.getCompany_name())) {
					if (memberBean.getMember_code() != null) {
						HBRUtils.modifyIntegral(memberBean.getMember_code(), orderBean.getOrder_id() + "",
								NumberUtils.KeepDecimal(orderBean.getDeduct_integral_value()) + "", "1", "22");
					}
				}
			}

			if (orderBean.getGive_integral_value() != null) {
				if ("hbr".equals(hostBean.getCompany_name())) {
					if (memberBean.getMember_code() != null) {
						HBRUtils.modifyIntegral(memberBean.getMember_code(), orderBean.getOrder_id() + "",
								-NumberUtils.KeepDecimal(orderBean.getGive_integral_value()) + "", "2", "22");
					}

				}
			}

			List<OrderGoodsBean> orderGoodsBeans = getOrderGoodss(
					new OrderGoodsBean().setOrder_id(orderBean.getOrder_id() + ""));
			if (orderGoodsBeans != null) {
				for (int i = 0; i < orderGoodsBeans.size(); i++) {
					OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(i);

					GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
							new GoodsBean().setGoods_id(Integer.valueOf(orderGoodsBean.getGoods_id())));// 获得商品详情

					int goods_stock = goodsBean.getGoods_stock() + orderGoodsBean.getGoods_num();
					int k = goodsServiceI2.updateGoodsDetail(
							new GoodsBean().setGoods_id(goodsBean.getGoods_id()).setGoods_stock(goods_stock));
					if (k <= 0) {
						throw new Exception("更新商品信息失败!请联系客服!");
					}
				}
			}

			int k = memberService.updateMemberDetail(new MemberBean()
					.setMember_id(Integer.valueOf(orderBean.getMember_id())).setIntegral(member_integral + ""));
			if (k <= 0) {
				throw new Exception("客户积分返还失败!请联系客服!");
			}

			if (orderBean.getMember_coupon_id() != null && !orderBean.getMember_coupon_id().equals("")) {// 退款优惠卷
				int h = couponService.updateCouponState(new CouponBean()
						.setMember_coupon_id(orderBean.getMember_coupon_id()).setCoupon_state("not_used"));
				if (h <= 0) {
					throw new Exception("客户优惠卷返还失败!请联系客服!");
				}
			}
		}
		return num;
	}

	/**
	 * 取消订单
	 * 
	 * @param orderBean
	 * @return
	 * @throws Exception
	 */
	public int cancelPayOrder(OrderBean orderBean) throws Exception {
		int num = orderDao.cancelOrder(orderBean);
		if (num > 0) {
			HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));
			MemberBean memberBean = memberService
					.getMemberByID(new MemberBean().setMember_id(Integer.valueOf(orderBean.getMember_id())));
			float member_integral = Float.valueOf(memberBean.getIntegral());// 用户现有积分
			if ("1".equals(orderBean.getIs_deduct_integral())) {// 如果抵扣积分了
				// 要先返还积分
				member_integral += Float.valueOf(orderBean.getDeduct_integral_value());
				if ("hbr".equals(hostBean.getCompany_name())) {
					if (memberBean.getMember_code() != null) {
						HBRUtils.modifyIntegral(memberBean.getMember_code(), orderBean.getOrder_id() + "",
								NumberUtils.KeepDecimal(orderBean.getDeduct_integral_value()) + "", "1", "22");
						// throw new
						// Exception(orderBean.getDeduct_integral_value());
					}

				}
			}

			if (orderBean.getGive_integral_value() != null) {
				member_integral -= NumberUtils.Float(orderBean.getGive_integral_value());
				if ("hbr".equals(hostBean.getCompany_name())) {
					if (memberBean.getMember_code() != null) {
						HBRUtils.modifyIntegral(memberBean.getMember_code(), orderBean.getOrder_id() + "",
								-NumberUtils.KeepDecimal(orderBean.getGive_integral_value()) + "", "2", "22");
					}

				}
			}

			if (member_integral < 0) {
				throw new Exception("积分不足 无法取消!请联系客服!");
			}

			// List<OrderGoodsBean> orderGoodsBeans = getOrderGoodss(new
			// OrderGoodsBean()
			// .setOrder_id(orderBean.getOrder_id()+""));
			// if (orderGoodsBeans != null) {
			// for (int i = 0; i < orderGoodsBeans.size(); i++) {
			// OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(i);
			//
			// GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
			// new
			// GoodsBean().setGoods_id(Integer.valueOf(orderGoodsBean.getGoods_id())));//
			// 获得商品详情
			//
			// int goods_stock = goodsBean.getGoods_stock() +
			// orderGoodsBean.getGoods_num();
			// int k = goodsServiceI2.updateGoodsDetail(
			// new
			// GoodsBean().setGoods_id(goodsBean.getGoods_id()).setGoods_stock(goods_stock));
			// if (k <= 0) {
			// throw new Exception("更新商品信息失败");
			// }
			// }
			// }

			int k = memberService.updateMemberDetail(new MemberBean()
					.setMember_id(Integer.valueOf(orderBean.getMember_id())).setIntegral(member_integral + ""));
			if (k <= 0) {
				throw new Exception("客户积分返还失败!请联系客服!");
			}

			if (orderBean.getMember_coupon_id() != null && !orderBean.getMember_coupon_id().equals("")) {// 退款优惠卷
				int h = couponService.updateCouponState(new CouponBean()
						.setMember_coupon_id(orderBean.getMember_coupon_id()).setCoupon_state("not_used"));
				if (h <= 0) {
					throw new Exception("客户优惠卷返还失败!请联系客服!");
				}
			}

			if ("online".equals(orderBean.getPay_way())) {
				PingSettingBean pingSettingBean = othersService.getPingSetting(new PingSettingBean().setPing_type("1"));
				Pingpp.apiKey = pingSettingBean.getPing_app_key();
				Pingpp.privateKeyPath = getClass().getResource("/").getFile().toString() + "/rsa_private_key.pem";
				Charge ch = Charge.retrieve(orderBean.getOrder_pay_no());//ch_id 是已付款的订单号
				Map<String, Object> refundMap = new HashMap<String, Object>();
				refundMap.put("amount", 1);// orderBean.getOrder_actual_price()
				refundMap.put("description", "退款");
				Refund re = ch.getRefunds().create(refundMap);
			} else if ("stored".equals(orderBean.getPay_way())) {
				String xml = HBRUtils.refundOrder(memberBean.getStored_code(), orderBean.getOrder_pay_no() + "",
						orderBean.getOrder_actual_price());
				String error = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
				if (error != null && !"".equals(error)) {
					throw new Exception(error);
				}
			}
		}
		return num;
	}

	/**
	 * 更新订单信息
	 * 
	 * @param orderBean
	 * @return
	 */
	public int updateOrderDetail(OrderBean orderBean) {
		return orderDao.updateOrderDetail(orderBean);
	}

	/**
	 * 删除订单
	 * 
	 * @return
	 */
	public int deleteOrder(OrderBean orderBean) {
		return orderDao.deleteOrder(orderBean);
	}

	/**
	 * 付款订单改变状态
	 * 
	 * @param orderBean
	 * @return
	 * @throws Exception
	 */
	public int paySuccessOrder(String[] order_ids, String pay_way, String password) throws Exception {
		int num = 0;
		String order_state = "wait_send";
		String member_id = "";

		float order_actual_price = 0;
		MemberBean memberBean = null;
		HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));

		for (int i = 0; i < order_ids.length; i++) {
			
			OrderBean orderBean2 = getOneOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(order_ids[i])));
			memberBean = memberService
					.getMemberByID(new MemberBean().setMember_id(Integer.valueOf(orderBean2.getMember_id())));

			if ("recharge".equals(orderBean2.getOrder_source_way())) {
				if ("hbr".equals(hostBean.getCompany_name())) {
					HBRUtils.svcardPrepay(memberBean.getStored_code(), orderBean2.getOrder_actual_price());
				} else {
					float balance = NumberUtils.Float(memberBean.getBalance())
							+ NumberUtils.Float(orderBean2.getOrder_actual_price());
					num = memberService.updateMemberDetail(
							new MemberBean().setMember_id(memberBean.getMember_id()).setBalance(balance + ""));
					if (num < 0) {
						throw new Exception("余额更新失败");
					}
					num = orderDao.payOrder(new OrderBean().setOrder_id(Integer.valueOf(order_ids[i]))
							.setOrder_state("end").setPay_way(pay_way == null ? "online" : pay_way));
					if (num < 0) {
						throw new Exception("订单更新失败");
					}
				}
			} else {
				if (!"wait_pay".equals(orderBean2.getOrder_state())) {
					throw new Exception("此订单已付款");
				}

				order_actual_price += NumberUtils.Float(orderBean2.getOrder_actual_price());

				member_id = orderBean2.getMember_id();

				float member_integral = Float.valueOf(memberBean.getIntegral());

				if ("1".equals(orderBean2.getIs_deduct_integral())) {// 抵扣积分了
					num = memberService.insertMemberIntegral(new IntegralBean().setMember_id(member_id)
							.setIntegral_type("order_cut").setIntegral_value(orderBean2.getDeduct_integral_value())
							.setRelation_id(orderBean2.getOrder_id() + ""));

					if (num <= 0) {
						throw new Exception("积分详情入库失败!");
					}
				}
				if (orderBean2.getGive_integral_value() != null && !orderBean2.getGive_integral_value().equals("")
						&& NumberUtils.Float(orderBean2.getGive_integral_value()) != 0) {
					if ("hbr".equals(hostBean.getCompany_name())) {
						String xml = HBRUtils.modifyIntegral(memberBean.getMember_code(), orderBean2.getOrder_id() + "",
								NumberUtils.KeepDecimal(orderBean2.getGive_integral_value()) + "", "1", "22");
						String error = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
						if (error != null && !"".equals(error)) {
							throw new Exception(error);
						}
					} else {
						num = memberService.updateMemberDetail(
										new MemberBean().setMember_id(memberBean.getMember_id())
												.setIntegral((member_integral
														+ NumberUtils.KeepDecimal(orderBean2.getGive_integral_value()))
														+ ""));
					}

					num = memberService.insertMemberIntegral(new IntegralBean().setMember_id(member_id)
							.setIntegral_type("order_add").setIntegral_value(orderBean2.getGive_integral_value())
							.setRelation_id(orderBean2.getOrder_id() + ""));
					if (num <= 0) {
						throw new Exception("积分详情入库失败!");
					}

					if ("wait_pay".equals(orderBean2.getOrder_state())) {// 未用积分全部付完款了
																			// 需要赠送积分
																			// 否则以赠送过
						int l = memberService.updateMemberDetail(
								new MemberBean().setMember_id(Integer.valueOf(orderBean2.getMember_id())).setIntegral(
										(member_integral + Float.valueOf(orderBean2.getGive_integral_value())) + ""));
						if (l <= 0) {
							throw new Exception("客户赠送积分失败");
						}
					}
				}

				if (orderBean2.getOrder_type().equals("group_buy")) {// 团购下的单
					int h = activityService.updateGroupBuyNum(new GroupBuyMemberBean()
							.setMember_group_buy_id(Integer.valueOf(orderBean2.getMember_group_buy_id()))
							.setGroup_buy_now_people(orderBean2.getOrderGoodsBeans().get(0).getGoods_num() + ""));
					if (h <= 0) {
						throw new Exception("更新团购数量失败");
					}

					int m = activityService
							.updateGroupBuyState(new GroupBuyBean().setMember_id(orderBean2.getMember_id())
									.setMember_group_buy_id(orderBean2.getMember_group_buy_id())
									.setGroup_buy_state("wait_send").setOrder_id(orderBean2.getOrder_id() + ""));

					if (m <= 0) {
						throw new Exception("更新团购购买状态失败");
					}

					GroupBuyGoodsBean groupBuyGoodsBean = activityService
							.getGoodsGroupBuyByMember(new GroupBuyMemberBean()
									.setMember_group_buy_id(Integer.valueOf(orderBean2.getMember_group_buy_id())));
					if (Integer.valueOf(groupBuyGoodsBean.getGroup_buy_need_people()) <= Integer
							.valueOf(groupBuyGoodsBean.getGroup_buy_now_people())) {// 团购人数已满
						order_state = "wait_send";

						String state = "wait_group_buy";
						if (orderBean2.getOrderGoodsBeans().get(0).getGoods_num() == Integer
								.valueOf(groupBuyGoodsBean.getGroup_buy_need_people())) {
							state = "wait_group_buy,wait_pay";
						} else {
							state = "wait_group_buy";
						}
						int k = orderDao.updateOrderStateByGroupBuy(new OrderBean()
								.setMember_group_buy_id(orderBean2.getMember_group_buy_id()).setOrder_state(state));// 团购人数满了
						// 之后把所有付款的订单状态改
						if (k <= 0) {
							throw new Exception("更新团购订单状态失败");
						}

						k = activityService.updateGroupBuyStateByMember(
								new GroupBuyBean().setMember_group_buy_id(orderBean2.getMember_group_buy_id()));
						if (k <= 0) {
							throw new Exception("更新团购信息状态失败");
						}
					} else {
						order_state = "wait_group_buy";
					}
				}	
				
				List<OrderGoodsBean> orderGoodsBeans = getOrderGoodss(new OrderGoodsBean().setOrder_id(order_ids[i]));
				
				List<ShopOrderCreateLine> line1 = new ArrayList<ShopOrderCreateLine>();
				for (int j = 0; j < orderGoodsBeans.size(); j++) {
					OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(j);
					GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
							new GoodsBean().setGoods_id(Integer.valueOf(orderGoodsBean.getGoods_id())));
					if("hbr".equals(hostBean.getCompany_name())){
						ShopOrderCreateLine shopOrderCreateLine1 = new ShopOrderCreateLine();
						shopOrderCreateLine1.shopLineNo = orderBean2.getOrder_no();
						shopOrderCreateLine1.outerId = goodsBean.getGoods_sku()+"";
						shopOrderCreateLine1.price = NumberUtils.Double(orderGoodsBean.getGoods_price())+orderGoodsBean.getCross_border_tax();
						shopOrderCreateLine1.quantity = orderGoodsBean.getGoods_num();
						shopOrderCreateLine1.lineUdf1 = orderGoodsBean.getOrder_goods_id()+"";
						shopOrderCreateLine1.lineUdf2 = "我是自定义字段2";
						shopOrderCreateLine1.skuName =goodsBean.getGoods_sku();
						shopOrderCreateLine1.itemName = orderGoodsBean.getGoods_name();
						shopOrderCreateLine1.lineTotal = 0;
						shopOrderCreateLine1.lineCustomTax = 0;
						shopOrderCreateLine1.lineCustomTotal = 0;
						line1.add(shopOrderCreateLine1);
					}	
					int year_sales = goodsBean.getYear_sales() + orderGoodsBean.getGoods_num();
					int day_sales = goodsBean.getDay_sales() + orderGoodsBean.getGoods_num();
					int month_sales = goodsBean.getMonth_sales() + orderGoodsBean.getGoods_num();
					int k = goodsServiceI2.updateGoodsDetail(new GoodsBean().setGoods_id(goodsBean.getGoods_id())
							.setYear_sales(year_sales).setDay_sales(day_sales).setMonth_sales(month_sales)
							.setGoods_stock(goodsBean.getGoods_stock()));
					if (k <= 0) {
						throw new Exception("更新商品信息失败");
					}

					num = orderDao.updateBusinessProfit(new BusinessProfitBean()
							.setOrder_goods_id(orderGoodsBean.getOrder_goods_id()).setProfit_state("wait_end"));
				}
				
				List<OrderActivityBean> orderActivityBeans=
						getOrderActivitys(new OrderActivityBean().setOrder_id(orderBean2.getOrder_id()));
				List<ShopOrderCreateDiscount> line2 = new ArrayList<ShopOrderCreateDiscount>();
				if(orderActivityBeans!=null){
					for (int j = 0; j < orderActivityBeans.size(); j++) {
						OrderActivityBean orderActivityBean=orderActivityBeans.get(j);
						if("hbr".equals(hostBean.getCompany_name())){
							ShopOrderCreateDiscount shopOrderCreateDiscount1 = new ShopOrderCreateDiscount();
							if("give".equals(orderActivityBean.getActivity_type())){
								shopOrderCreateDiscount1.discountName = "买"+orderActivityBean.getGive_need_count()
																		+"送"+orderActivityBean.getGive_count();
								shopOrderCreateDiscount1.discountFee = NumberUtils.Float(orderActivityBean.getGive_actual_count());
							}else if("reduce".equals(orderActivityBean.getActivity_type())){
								shopOrderCreateDiscount1.discountName = "满"+orderActivityBean.getReduce_need_price()
										+"减"+orderActivityBean.getReduce_price();
								shopOrderCreateDiscount1.discountFee = NumberUtils.Float(orderActivityBean.getReduce_actual_price());
							}else if("half".equals(orderActivityBean.getActivity_type())){
								shopOrderCreateDiscount1.discountName = "第"+orderActivityBean.getHalf_count()+"半价";
								shopOrderCreateDiscount1.discountFee = NumberUtils.Float(orderActivityBean.getHalf_price());
							}else if("exempt".equals(orderActivityBean.getActivity_type())){
								shopOrderCreateDiscount1.discountName = "满"+orderActivityBean.getExempt_need_count()
														+"免"+orderActivityBean.getExempt_count();
								shopOrderCreateDiscount1.discountFee = NumberUtils.Float(orderActivityBean.getExempt_price());
							}
							line2.add(shopOrderCreateDiscount1);
						}
					}
				}
				
				if("hbr".equals(hostBean.getCompany_name())){
					B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY, Constants.LOGIN_NAME,Constants.PASSWORD);
					ShopOrderCreateRequest requestShop = new ShopOrderCreateRequest();
					requestShop.memberNick = memberBean.getMember_account();
					requestShop.shopOrderNo = orderBean2.getOrder_no();
					requestShop.shopId =20;//NumberUtils.Integer(orderBean2.getMerchants_id());
					requestShop.orderStatus = 10;
					requestShop.shopCreatedTime =TimeUtils.getDateFromTime("yyyy-MM-dd HH:mm:ss",  orderBean2.getCreate_time());
					requestShop.customPaymentName = "微信";
					requestShop.customPaymentNo = "11";
					requestShop.customTax = 0;
					requestShop.customIdNo = memberBean.getCard_id();
					requestShop.customName=memberBean.getReal_name();
					
					requestShop.receiverName=orderBean2.getName();
					requestShop.receiverState=orderBean2.getProvince();
					requestShop.receiverCity=orderBean2.getCity();
					requestShop.receiverDistrict=orderBean2.getCountry();
					requestShop.receiverAddress=orderBean2.getDetailed_address();
					requestShop.receiverZip=orderBean2.getZip_code();
					requestShop.receiverMobile=orderBean2.getMobile();
					
					requestShop.goodsTotal=NumberUtils.Double(orderBean2.getOrder_total_price());
					requestShop.orderTotal=NumberUtils.Double(orderBean2.getOrder_actual_price());
					
					requestShop.userDefinedField1=memberBean.getReal_name()+","+memberBean.getCard_id();
					requestShop.setItemLines(line1);
					if(line2.size()>0){
						requestShop.setDiscountLines(line2);						
					}
					ShopOrderCreateResponse response = client.execute(requestShop);
				}			
				
				num = orderDao.updateDistribution(new DistributionBean().setOrder_id(order_ids[i]).setDistribution_state("wait_end"));

				num = orderDao.payOrder(new OrderBean().setOrder_id(Integer.valueOf(order_ids[i]))
						.setOrder_state(order_state).setPay_way(pay_way == null ? "online" : pay_way));
			}
		}

		if ("balance".equals(pay_way)) {
			float balance = NumberUtils.Float(memberBean.getBalance()) - order_actual_price;
			if (balance < 0) {
				throw new Exception("余额不足");
			}

			num = memberService.updateMemberDetail(
					new MemberBean().setMember_id(memberBean.getMember_id()).setBalance(balance + ""));
			if (num < 0) {
				throw new Exception("余额更新失败");
			}
		}

		if ("trust".equals(pay_way)) {
			float balance = NumberUtils.Float(memberBean.getTrust_balance()) - order_actual_price;
			if (balance < 0) {
				throw new Exception("信用额度不足");
			}

			num = memberService.updateMemberDetail(
					new MemberBean().setMember_id(memberBean.getMember_id()).setTrust_balance(balance + ""));
			if (num < 0) {
				throw new Exception("额度更新失败");
			}
		}

		if ("stored".equals(pay_way)) {
			String xml = HBRUtils.cardDealData(memberBean.getStored_code(), password,
					Arrays.toString(order_ids).replaceAll("^\\[| |\\]$", ""), order_actual_price + "");
			Document doc = XmlUtils.getDocumentByXml(xml);
			String error = XmlUtils.getValueByTagName(doc, "error");
			if (error != null && !"".equals(error)) {
				throw new Exception(error);
			}
		}

		if (hostBean != null && hostBean.getCompany_name() != null) {
			if ("fuzhuang".equals(hostBean.getCompany_name())) {
				num = memberService.updateMemberDetailVip(new MemberBean().setMember_id(Integer.valueOf(member_id)));
				if (num <= 0) {
					throw new Exception("用户升级失败!");
				}
			}
		}
		return num;
	}

	/**
	 * 确认收货
	 * 
	 * @param orderBean
	 * @return
	 */
	public int confirmOrder(OrderBean orderBean) {
		return orderDao.confirmOrder(orderBean);
	}

	/**
	 * 可追加评价订单
	 * 
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderBean> getCanAddAssessmentOrder(OrderBean orderBean, PageBean pageBean) {
		List<OrderBean> orderBeans = orderDao.getCanAddAssessmentOrder(orderBean, pageBean);
		for (int i = 0; i < orderBeans.size(); i++) {
			OrderBean orderBean1 = orderBeans.get(i);
			List<OrderGoodsBean> orderGoodsBeans = getOrderGoodss(
					new OrderGoodsBean().setOrder_id(orderBean1.getOrder_id() + ""));
			orderBean1.setOrderGoodsBeans(orderGoodsBeans);

			MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
					new MerchantsBean().setMerchants_id(Integer.valueOf(orderBean1.getMerchants_id())));
			orderBean1.setMerchantsBean(merchantsBean);
		}
		return orderBeans;
	}

	/**
	 * 评价订单
	 * 
	 * @param assessmentBeans
	 * @return
	 * @throws Exception
	 */
	public int assessmentOrder(List<AssessmentBean> assessmentBeans) throws Exception {
		int num = 0;
		String order_id = "";
		for (int i = 0; i < assessmentBeans.size(); i++) {
			AssessmentBean assessmentBean = assessmentBeans.get(i);
			order_id = assessmentBean.getOrder_id();
			assessmentBean.setAssessment_desc(HtmlUtils.Html2Text(assessmentBean.getAssessment_desc()));
			num = orderDao.insertAssessmentOrder(assessmentBean);
			List<AssessmentImgBean> assessmentImgBeans = null;
			if (num > 0) {
				assessmentImgBeans = assessmentBean.getAssessmentImgBeans();
				if (assessmentImgBeans != null) {
					for (int j = 0; j < assessmentImgBeans.size(); j++) {
						AssessmentImgBean assessmentImgBean = assessmentImgBeans.get(j);
						int k = orderDao.insertAssessmentImg(
								assessmentImgBean.setAssessment_id(assessmentBean.getAssessment_id() + ""));
						if (k <= 0) {
							throw new Exception("添加失败 回滚");
						}
					}
				}
			} else {
				throw new Exception("添加失败 回滚");
			}
			if (assessmentBean.getAssessment_type().equals("merchants")) {// 如果评价的是商家
																			// //
																			// 则更新商家的星级
				MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
						new MerchantsBean().setMerchants_id(Integer.valueOf(assessmentBean.getRelation_id())));
				int star1 = 0;
				int star2 = 0;
				int star3 = 0;
				if (merchantsBean != null) {
					star1 = NumberUtils.KeepDecimal((Float.valueOf(assessmentBean.getAssessment_star1())
							+ Float.valueOf(merchantsBean.getMerchants_star1())) / 2);

					star2 = NumberUtils.KeepDecimal((Float.valueOf(assessmentBean.getAssessment_star2())
							+ Float.valueOf(merchantsBean.getMerchants_star2())) / 2);

					star3 = NumberUtils.KeepDecimal((Float.valueOf(assessmentBean.getAssessment_star3())
							+ Float.valueOf(merchantsBean.getMerchants_star3())) / 2);
				}
				int h = orderDao.updateMerchantsStar(new MerchantsBean()
						.setMerchants_id(Integer.valueOf(assessmentBean.getRelation_id()))
						.setMerchants_star1(star1 + "").setMerchants_star2(star2 + "").setMerchants_star3(star3 + ""));
				if (h <= 0) {
					throw new Exception("更新商家星级失败 回滚");
				}
			}

			if (assessmentBean.getAssessment_type().equals("goods")) {// 如果评价的商品
				// //
				// 则更新商品的星级
				GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
						new GoodsBean().setGoods_id(Integer.valueOf(assessmentBean.getRelation_id())));

				int star1 = 0;
				int star2 = 0;
				int star3 = 0;
				int assessment_count = goodsBean.getAssessment_count() + 1;
				int good_assessment_count = goodsBean.getGood_assessment_count();
				int bad_assessment_count = goodsBean.getBad_assessment_count();
				int in_assessment_count = goodsBean.getIn_assessment_count();
				int assessment_img_count = goodsBean.getAssessment_img_count();
				if (assessmentImgBeans != null && assessmentImgBeans.size() > 0) {
					assessment_img_count += 1;
				}
				if ((NumberUtils.Double(assessmentBean.getAssessment_star1())
						+ NumberUtils.Double(assessmentBean.getAssessment_star2())
						+ NumberUtils.Double(assessmentBean.getAssessment_star3())) * 10 / 3 > 30) {
					good_assessment_count += 1;
				} else if ((NumberUtils.Double(assessmentBean.getAssessment_star1())
						+ NumberUtils.Double(assessmentBean.getAssessment_star2())
						+ NumberUtils.Double(assessmentBean.getAssessment_star3())) * 10 / 3 == 30) {
					in_assessment_count += 1;
				} else {
					bad_assessment_count += 1;
				}

				double good_assessment_percent = NumberUtils
						.KeepDecimal((float) good_assessment_count * 100 / (float) assessment_count, 2);
				double bad_assessment_percent = NumberUtils
						.KeepDecimal((float) bad_assessment_count * 100 / (float) assessment_count, 2);
				double in_assessment_percent = NumberUtils
						.KeepDecimal((float) in_assessment_count * 100 / (float) assessment_count, 2);

				if (goodsBean != null) {
					star1 = NumberUtils.KeepDecimal((NumberUtils.Float(assessmentBean.getAssessment_star1())
							+ NumberUtils.Float(goodsBean.getGoods_star1())) / 2);

					star2 = NumberUtils.KeepDecimal((NumberUtils.Float(assessmentBean.getAssessment_star2())
							+ NumberUtils.Float(goodsBean.getGoods_star2())) / 2);

					star3 = NumberUtils.KeepDecimal((NumberUtils.Float(assessmentBean.getAssessment_star3())
							+ NumberUtils.Float(goodsBean.getGoods_star3())) / 2);
				}

				int h = goodsServiceI2.updateGoodsDetailStart(new GoodsBean()
						.setGoods_id(Integer.valueOf(assessmentBean.getRelation_id())).setGoods_star1(star1 + "")
						.setGoods_star2(star2 + "").setGoods_star3(star3 + "").setAssessment_count(assessment_count)
						.setGood_assessment_count(good_assessment_count).setBad_assessment_count(bad_assessment_count)
						.setIn_assessment_count(in_assessment_count)
						.setGood_assessment_percent(good_assessment_percent + "")
						.setBad_assessment_percent(bad_assessment_percent + "")
						.setIn_assessment_percent(in_assessment_percent + "")
						.setAssessment_img_count(assessment_img_count));
				if (h <= 0) {
					throw new Exception("更新商品星级失败 回滚");
				}
			}
		}

		// num = orderDao.updateDistribution(new
		// DistributionBean().setOrder_id(order_id).setDistribution_state("end"));

		num = orderDao.assessmentOrder(new OrderBean().setOrder_id(Integer.valueOf(order_id)));
		if (num <= 0) {
			throw new Exception("订单状态改变失败 回滚");
		}
		return num;
	}

	/**
	 * 用户评价列表
	 * 
	 * @param assessmentBean
	 * @param pageBean
	 * @return
	 */
	public List<AssessmentBean> getMemberAssessments(AssessmentBean assessmentBean, PageBean pageBean) {
		List<AssessmentBean> assessmentBeans = orderDao.getMemberAssessments(assessmentBean, pageBean);
		for (int i = 0; i < assessmentBeans.size(); i++) {
			AssessmentBean assessmentBean2 = assessmentBeans.get(i);
			List<AssessmentImgBean> assessmentImgBeans = orderDao.getOrderAssessmentImgs(
					new AssessmentImgBean().setAssessment_id(assessmentBean2.getAssessment_id() + ""));
			assessmentBean2.setAssessmentImgBeans(assessmentImgBeans);

			if ("goods".equals(assessmentBean2.getAssessment_type())) {
				GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
						new GoodsBean().setGoods_id(Integer.valueOf(assessmentBean2.getRelation_id())));
				assessmentBean2.setGoodsBean(goodsBean);
			}

			if ("merchants".equals(assessmentBean2.getAssessment_type())) {
				MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
						new MerchantsBean().setMerchants_id(Integer.valueOf(assessmentBean2.getRelation_id())));
				assessmentBean2.setMerchantsBean(merchantsBean);
			}
		}
		return assessmentBeans;
	}

	/**
	 * 用户评价列表
	 * 
	 * @param assessmentBean
	 * @param pageBean
	 * @return
	 */
	public List<AssessmentBean> getMemberAssessmentsV2(AssessmentBean assessmentBean, PageBean pageBean) {
		List<AssessmentBean> assessmentBeans = orderDao.getMemberAssessmentsV2(assessmentBean, pageBean);
		for (int i = 0; i < assessmentBeans.size(); i++) {
			AssessmentBean assessmentBean2 = assessmentBeans.get(i);

			if ("goods".equals(assessmentBean2.getAssessment_type())) {
				GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
						new GoodsBean().setGoods_id(Integer.valueOf(assessmentBean2.getRelation_id())));
				assessmentBean2.setGoodsBean(goodsBean);
			}

			if ("merchants".equals(assessmentBean2.getAssessment_type())) {
				MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
						new MerchantsBean().setMerchants_id(Integer.valueOf(assessmentBean2.getRelation_id())));
				assessmentBean2.setMerchantsBean(merchantsBean);
			}

			List<AssessmentBean> assessmentBeans2 = orderDao
					.getMemberAssessments(assessmentBean2.setAssessment_type(""));
			assessmentBean2.setAssessmentBeans(assessmentBeans2);
			for (int j = 0; j < assessmentBeans2.size(); j++) {
				AssessmentBean assessmentBean3 = assessmentBeans2.get(j);
				List<AssessmentImgBean> assessmentImgBeans = orderDao.getOrderAssessmentImgs(
						new AssessmentImgBean().setAssessment_id(assessmentBean3.getAssessment_id() + ""));
				assessmentBean3.setAssessmentImgBeans(assessmentImgBeans);

			}

		}
		return assessmentBeans;
	}

	/**
	 * 评价列表
	 * 
	 * @param assessmentBean
	 * @return
	 */
	public List<AssessmentBean> getOrderAssessments(AssessmentBean assessmentBean, String type, PageBean pageBean) {
		List<AssessmentBean> assessmentBeans = new ArrayList<AssessmentBean>();
		if ("img".equals(type)) {
			assessmentBeans = orderDao.getOrderAssessmentsImg(assessmentBean, pageBean);
		} else if ("good".equals(type)) {
			assessmentBeans = orderDao.getOrderAssessmentsGood(assessmentBean, pageBean);
		} else if ("bad".equals(type)) {
			assessmentBeans = orderDao.getOrderAssessmentsBad(assessmentBean, pageBean);
		} else if ("in".equals(type)) {
			assessmentBeans = orderDao.getOrderAssessmentsIn(assessmentBean, pageBean);
		} else {
			assessmentBeans = orderDao.getOrderAssessments(assessmentBean, pageBean);
		}
		for (int i = 0; i < assessmentBeans.size(); i++) {
			AssessmentBean assessmentBean2 = assessmentBeans.get(i);
			List<AssessmentImgBean> assessmentImgBeans = orderDao.getOrderAssessmentImgs(
					new AssessmentImgBean().setAssessment_id(assessmentBean2.getAssessment_id() + ""));
			assessmentBean2.setAssessmentImgBeans(assessmentImgBeans);

			if (assessmentBean2.getMember_id() != null) {
				MemberBean memberBean = memberService
						.getMemberByID(new MemberBean().setMember_id(Integer.valueOf(assessmentBean2.getMember_id())));
				assessmentBean2.setMemberBean(memberBean);
			}
		}
		return assessmentBeans;
	}

	/**
	 * 评价图片列表
	 * 
	 * @param assessmentImgBean
	 * @return
	 */
	public List<AssessmentImgBean> getOrderAssessmentImgs(AssessmentImgBean assessmentImgBean) {
		return orderDao.getOrderAssessmentImgs(assessmentImgBean);
	}
}

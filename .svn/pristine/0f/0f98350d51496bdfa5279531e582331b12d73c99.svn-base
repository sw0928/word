package tst.project.webservice.interfaces;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.elasticsearch.search.aggregations.bucket.histogram.Histogram.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.ShopOrderCreateRequest;
import com.iwilley.b1ec2.sample.Constants;
import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import tst.project.bean.HostBean;
import tst.project.bean.activity.GroupBuyGoodsBean;
import tst.project.bean.activity.GroupBuyMemberBean;
import tst.project.bean.address.LocationBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.order.AssessmentBean;
import tst.project.bean.order.InviseBean;
import tst.project.bean.order.LogisticsDetailBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderGoodsBean;
import tst.project.bean.order.OrderLineBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.order.OrderParameterBean;
import tst.project.bean.order.OrderServiceBean;
import tst.project.bean.order.PayBean;
import tst.project.bean.order.PingOrderBean;
import tst.project.bean.order.PingSettingBean;
import tst.project.bean.order.RefundBean;
import tst.project.bean.order.RefundReasonBean;
import tst.project.bean.others.CodeBean;
import tst.project.bean.others.PercentBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.ActivityService;
import tst.project.service.interfaces.CodeService;
import tst.project.service.interfaces.GoodsServiceI;
import tst.project.service.interfaces.GoodsServiceI2;
import tst.project.service.interfaces.MemberService;
import tst.project.service.interfaces.OrderService;
import tst.project.service.interfaces.OthersService;
import tst.project.utils.AlipayUtils;
import tst.project.utils.BaiduUtils;
import tst.project.utils.CreateRandom;
import tst.project.utils.HBRUtils;
import tst.project.utils.HtmlUtils;
import tst.project.utils.HttpUtils;
import tst.project.utils.MD5Util;
import tst.project.utils.NumberUtils;
import tst.project.utils.QRCodeUtils;
import tst.project.utils.RSAUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.XmlUtils;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/orderInterfaces.api")
public class OrderInterfaces extends BaseController {
	@Resource
	MemberService memberService;

	@Resource
	OrderService orderService;

	@Resource
	ActivityService activityService;

	@Resource
	OthersService othersService;

	@Resource
	GoodsServiceI goodsServiceI;

	@Resource
	GoodsServiceI2 goodsServiceI2;

	@Resource
	CodeService codeService;
	
	/**
	 * 订单物流详情
	 * 
	 * @param orderLineBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOrderLogisticsDetails", method = RequestMethod.POST)
	public void getOrderLogisticsDetails(MemberBean memberBean,LogisticsDetailBean logisticsDetailBean,OrderBean orderBean,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, orderService.getOrderLogisticsDetails(logisticsDetailBean,orderBean));
	}
	

	/**
	 * 获得订单发票内容
	 * 
	 * @param orderLineBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOrderInviseContents", method = RequestMethod.POST)
	public void getOrderInviseContents(InviseBean inviseBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WriteObject(response, orderService.getOrderInviseContents(inviseBean));
	}

	@RequestMapping(params = "test", method = RequestMethod.POST)
	public void test(MemberBean memberBean, OrderLineBean getOrderLine, PageBean pageBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String appid = "wx0bb583c2e89057d8";
		String paternerKey = "4c6e02c0bc38b3557a27e552789c30e1";
		String attach = "测试";
		String body = "测试购买支付";
		String mch_id = "1231009902";
		String nonce_str = CreateRandom.createRandom(false, 32);
		String openid = "oMLXUs8BZLBhgpdQYeqkk0SC8f8A";
		String out_trade_no = TimeUtils.getCurrentTime("yyyyMMddHHmmss");
		String spbill_create_ip = HttpUtils.getRemortIP(request);
		String total_fee = "1";
		String trade_type = "JSAPI";
		String notify_url = "http://hbr.tstweiguanjia.com/orderInterfaces.api?test";
		String sign_type = "MD5";

		Map<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("appid", appid);
		paraMap.put("attach", attach);
		paraMap.put("body", body);
		paraMap.put("mch_id", mch_id);
		paraMap.put("nonce_str", nonce_str);

		paraMap.put("openid", openid);
		paraMap.put("out_trade_no", out_trade_no);
		paraMap.put("spbill_create_ip", spbill_create_ip);
		paraMap.put("total_fee", total_fee);
		paraMap.put("trade_type", trade_type);
		paraMap.put("notify_url", notify_url);
		paraMap.put("sign_type", sign_type);

		String wait_sign = "appid=" + appid + "&attach=" + attach + "&body=" + body + "&mch_id=" + mch_id
				+ "&nonce_str=" + nonce_str + "&notify_url=" + notify_url + "&openid=" + openid + "&out_trade_no="
				+ out_trade_no + "&sign_type=" + sign_type + "&spbill_create_ip=" + spbill_create_ip + "&total_fee="
				+ total_fee + "&trade_type=" + trade_type + "&key=" + paternerKey;

		String sign = MD5Util.md5EncodeOrigin(wait_sign).toUpperCase();

		paraMap.put("sign", sign);

		// 统一下单 https://apimchweixinqqcom/pay/unifiedorder
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

		String xml = XmlUtils.ArrayToXml(paraMap);

		String pre_id = HttpUtils.testPost(url, xml);

		WriteOnlyMsg(response, pre_id + "===" + xml);
	}

	/**
	 * 获得线下订单
	 * 
	 * @param orderLineBean
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "getOrderLines", method = RequestMethod.POST)
	public void getOrderLines(MemberBean memberBean, OrderLineBean getOrderLine, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) {		
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}		
		
		WriteObject(response,orderService.getOrderLines(getOrderLine, pageBean));
	}

	/**
	 * 获得订单原因列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getRefundsReasons", method = RequestMethod.POST)
	public void getRefundsReasons(MemberBean memberBean, RefundReasonBean refundReasonBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WriteObject(response, orderService.getRefundsReasons(refundReasonBean));
	}

	/**
	 * 用户的退款列表 各个状态统计
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberRefundCount", method = RequestMethod.POST)
	public void getMemberRefundCount(MemberBean memberBean, PageBean pageBean, RefundBean refundBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, orderService.getMemberRefundCount(refundBean));
	}

	/**
	 * 获得退款订单列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberRefunds", method = RequestMethod.POST)
	public void getRefundOrders(MemberBean memberBean, PageBean pageBean, RefundBean refundBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, orderService.getMemberRefunds(refundBean, pageBean), pageBean.getTotal());
	}

	/**
	 * 获得退款订单列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getRefundDetail", method = RequestMethod.POST)
	public void getRefundDetail(MemberBean memberBean, RefundBean refundBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, orderService.getRefundDetail(refundBean));
	}

//	/**
//	 * 订单退款(图片路径)
//	 * 
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping(params = "refundOrderNoFile", method = RequestMethod.POST)
//	public void refundOrderNoFile(MemberBean memberBean, RefundBean refundBean, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		try {
//			MemberBean memberBean2 = memberService.verificationToken(memberBean);
//			if (memberBean2 == null) {
//				WritePending(response, "token failed");
//				return;
//			}
//
//			RefundBean refundBean2 = orderService.getRefundByGoods(refundBean);
//			if (refundBean2 != null) {
//				WriteError(response, "此订单商品已申请退款");
//				return;
//			}
//
//			OrderBean orderBean1 = orderService
//					.getOneOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(refundBean.getOrder_id())));
//			if (orderBean1 == null) {
//				WriteError(response, "此订单不存在");
//				return;
//			}
//
//			if (orderBean1.getOrder_state().equals("cancle") || orderBean1.getOrder_state().equals("wait_pay")) {
//				WriteError(response, "此订单状态不可申请退款");
//				return;
//			}
//
//			OrderGoodsBean orderGoodsBean = orderService
//					.getOrderGoodssByGoods(new OrderGoodsBean().setOrder_id(refundBean.getOrder_id())
//							.setOrder_goods_id(Integer.valueOf(refundBean.getOrder_goods_id())));
//			if (orderGoodsBean == null) {
//				WriteError(response, "此订单已不存在");
//				return;
//			}
//
//			if (Integer.valueOf(orderGoodsBean.getGoods_num()) < Integer.valueOf(refundBean.getRefund_count())) {
//				WriteError(response, "退款数量大于购买数量了");
//				return;
//			}
//
//			float refund_price = 0;// 需要返回用户金钱
//
//			if (orderBean1.getOrder_type().equals("goods")) {
//				refund_price += NumberUtils.Float(orderGoodsBean.getGoods_price())
//						* Float.valueOf(refundBean.getRefund_count());
//			} else if (orderBean1.getOrder_type().equals("group_buy")) {
//				refund_price += NumberUtils.Float(orderGoodsBean.getGroup_buy_price())
//						* Float.valueOf(refundBean.getRefund_count());
//			} else if (orderBean1.getOrder_type().equals("time_limit")) {
//				refund_price += NumberUtils.Float(orderGoodsBean.getPromotion_price())
//						* Float.valueOf(refundBean.getRefund_count());
//			}
//
//			List<OrderParameterBean> orderParameterBeans = orderGoodsBean.getOrderParameterBeans();
//			for (int i = 0; i < orderParameterBeans.size(); i++) {
//				refund_price += NumberUtils.Float(orderParameterBeans.get(i).getParameter_price())
//						* NumberUtils.Float(refundBean.getRefund_count());
//			}
//
//			List<OrderServiceBean> orderServiceBeans = orderGoodsBean.getOrderServiceBeans();
//			for (int i = 0; i < orderServiceBeans.size(); i++) {
//				refund_price += NumberUtils.Float(orderServiceBeans.get(i).getService_price())
//						* NumberUtils.Float(refundBean.getRefund_count());
//			}
//
//
//			String imgs = request.getParameter("imgs");
//
//			String refund_no = TimeUtils.getCurrentTime("yyyyMMddHHmmss");
//			int num = orderService.refundOrder(refundBean.setRefund_state("wait_review")
//					.setRefund_price(refund_price + "").setRefund_no(refund_no),
//					imgs == null ? null : (imgs.length() > 0 ? imgs.split(",") : null));
//			if (num >= 0) {
//				WriteObject(response, "我们已收到您的退款申请了!请耐心等待啊");
//			} else {
//				WriteError(response, "哎呀!太遗憾了,我们没能成功收到您的退款申请!");
//			}
//		} catch (Exception e) {
//
//		}
//	}
//
//	
	
	/**
	 * 订单退款(图片路径)
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "refundOrderNoFile", method = RequestMethod.POST)
	public void refundOrderNoFile(MemberBean memberBean, RefundBean refundBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			MemberBean memberBean2 = memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}

			RefundBean refundBean2 = orderService.getRefundByGoods(refundBean);
			if (refundBean2 != null) {
				WriteError(response, "此订单商品已申请退款");
				return;
			}

			OrderBean orderBean1 = orderService
					.getOneOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(refundBean.getOrder_id())));
			if (orderBean1 == null) {
				WriteError(response, "此订单不存在");
				return;
			}

			if (orderBean1.getOrder_state().equals("cancle") || orderBean1.getOrder_state().equals("wait_pay")) {
				WriteError(response, "此订单状态不可申请退款");
				return;
			}

			OrderGoodsBean orderGoodsBean = orderService
					.getOrderGoodssByGoods(new OrderGoodsBean().setOrder_id(refundBean.getOrder_id())
							.setOrder_goods_id(Integer.valueOf(refundBean.getOrder_goods_id())));
			if (orderGoodsBean == null) {
				WriteError(response, "此订单已不存在");
				return;
			}

			if (Integer.valueOf(orderGoodsBean.getGoods_num()) < Integer.valueOf(refundBean.getRefund_count())) {
				WriteError(response, "退款数量大于购买数量了");
				return;
			}
			
			
			List<OrderGoodsBean> orderGoodsBeans=orderService.getOrderGoodss(new OrderGoodsBean().setOrder_id(refundBean.getOrder_id()));
			float total_price=0;
			for (int i = 0; i < orderGoodsBeans.size(); i++) {
				OrderGoodsBean orderGoodsBean2=orderGoodsBeans.get(i);
				if (orderBean1.getOrder_type().equals("goods")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getGoods_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				} else if (orderBean1.getOrder_type().equals("group_buy")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getGroup_buy_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				} else if (orderBean1.getOrder_type().equals("time_limit")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getPromotion_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				}
			}
			
			float base_price=0;
			if (orderBean1.getOrder_type().equals("goods")) {
				base_price += NumberUtils.Float(orderGoodsBean.getGoods_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			} else if (orderBean1.getOrder_type().equals("group_buy")) {
				base_price += NumberUtils.Float(orderGoodsBean.getGroup_buy_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			} else if (orderBean1.getOrder_type().equals("time_limit")) {
				base_price += NumberUtils.Float(orderGoodsBean.getPromotion_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			}
			float refund_price =NumberUtils.Float(orderBean1.getOrder_actual_price())*base_price/total_price;// 需要返回用户金钱
			float refund_integral_value=(NumberUtils.Float(orderBean1.getDeduct_integral_value())
					-NumberUtils.Float(orderBean1.getGive_integral_value()))*base_price/total_price;
			
			String imgs = request.getParameter("imgs");
			String refund_no = TimeUtils.getCurrentTime("yyyyMMddHHmmss");
			
			refundBean.setRefund_desc(HtmlUtils.Html2Text(refundBean.getRefund_desc()));
			int num = orderService.refundOrder(refundBean.setRefund_state("wait_review")
					.setRefund_price(NumberUtils.KeepDecimal(refund_price, 2) + "")
					.setRefund_no(refund_no)
					.setRefund_integral_value(NumberUtils.KeepDecimal(refund_integral_value, 2)+""),
					imgs == null ? null : (imgs.length() > 0 ? imgs.split(",") : null));
			if (num >= 0) {
				WriteObject(response, "我们已收到您的退款申请了!请耐心等待啊");
			} else {
				WriteError(response, "哎呀!太遗憾了,我们没能成功收到您的退款申请!");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * 订单退款(图片路径)
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "refundOrderNoFileV2", method = RequestMethod.POST)
	public void refundOrderNoFileV2(MemberBean memberBean, RefundBean refundBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			MemberBean memberBean2 = memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}

			RefundBean refundBean2 = orderService.getRefundByGoods(refundBean);
			if (refundBean2 != null) {
				WriteError(response, "此订单商品已申请退款");
				return;
			}

			OrderBean orderBean1 = orderService
					.getOneOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(refundBean.getOrder_id())));
			if (orderBean1 == null) {
				WriteError(response, "此订单不存在");
				return;
			}

			if (orderBean1.getOrder_state().equals("cancle") || orderBean1.getOrder_state().equals("wait_pay")) {
				WriteError(response, "此订单状态不可申请退款");
				return;
			}

			OrderGoodsBean orderGoodsBean = orderService
					.getOrderGoodssByGoods(new OrderGoodsBean().setOrder_id(refundBean.getOrder_id())
							.setOrder_goods_id(Integer.valueOf(refundBean.getOrder_goods_id())));
			if (orderGoodsBean == null) {
				WriteError(response, "此订单已不存在");
				return;
			}

			if (Integer.valueOf(orderGoodsBean.getGoods_num()) < Integer.valueOf(refundBean.getRefund_count())) {
				WriteError(response, "退款数量大于购买数量了");
				return;
			}
			
			
			List<OrderGoodsBean> orderGoodsBeans=orderService.getOrderGoodss(new OrderGoodsBean().setOrder_id(refundBean.getOrder_id()));
			float total_price=0;
			for (int i = 0; i < orderGoodsBeans.size(); i++) {
				OrderGoodsBean orderGoodsBean2=orderGoodsBeans.get(i);
				if (orderBean1.getOrder_type().equals("goods")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getGoods_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				} else if (orderBean1.getOrder_type().equals("group_buy")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getGroup_buy_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				} else if (orderBean1.getOrder_type().equals("time_limit")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getPromotion_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				}
			}
			
			float base_price=0;
			if (orderBean1.getOrder_type().equals("goods")) {
				base_price += NumberUtils.Float(orderGoodsBean.getGoods_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			} else if (orderBean1.getOrder_type().equals("group_buy")) {
				base_price += NumberUtils.Float(orderGoodsBean.getGroup_buy_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			} else if (orderBean1.getOrder_type().equals("time_limit")) {
				base_price += NumberUtils.Float(orderGoodsBean.getPromotion_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			}
			float refund_price =NumberUtils.Float(orderBean1.getOrder_actual_price())*base_price/total_price;// 需要返回用户金钱
			float refund_integral_value=(NumberUtils.Float(orderBean1.getDeduct_integral_value())
					-NumberUtils.Float(orderBean1.getGive_integral_value()))*base_price/total_price;
			
			String imgs = request.getParameter("imgs");
			String refund_no = TimeUtils.getCurrentTime("yyyyMMddHHmmss");
			int num = orderService.refundOrder(refundBean.setRefund_state("wait_review")
					.setRefund_price(NumberUtils.KeepDecimal(refund_price, 2) + "")
					.setRefund_no(refund_no)
					.setRefund_integral_value(NumberUtils.KeepDecimal(refund_integral_value, 2)+""),
					imgs == null ? null : (imgs.length() > 0 ? imgs.split(",") : null));
			if (num >= 0) {
				WriteObject(response, "我们已收到您的退款申请了!请耐心等待啊");
			} else {
				WriteError(response, "哎呀!太遗憾了,我们没能成功收到您的退款申请!");
			}
		} catch (Exception e) {

		}
	}
//
//	/**
//	 * 订单退款
//	 * 
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping(params = "refundOrder", method = RequestMethod.POST)
//	public void refundOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		//try {
//			HashMap<String, Object> maps = getJsonWithImgs(request, "/images/order");
//			if (maps.get("result").equals("failed")) {
//				WriteError(response, "上传失败");
//				return;
//			}
//			
//			MemberBean memberBean = new Gson().fromJson(maps.get("string").toString(), MemberBean.class);
//			RefundBean refundBean = new Gson().fromJson(maps.get("string").toString(), RefundBean.class);
//			List<String> mapFiles = (List<String>) maps.get("file");
//
//			MemberBean memberBean2 = memberService.verificationToken(memberBean);
//			if (memberBean2 == null) {
//				WritePending(response, "token failed");
//				return;
//			}
//
//			RefundBean refundBean2 = orderService.getRefundByGoods(refundBean);
//			if (refundBean2 != null) {
//				WriteError(response, "此订单商品已申请退款");
//				return;
//			}
//
//			OrderBean orderBean1 = orderService
//					.getOneOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(refundBean.getOrder_id())));
//			if (orderBean1 == null) {
//				WriteError(response, "此订单不存在");
//				return;
//			}
//
//			if (orderBean1.getOrder_state().equals("cancle") || orderBean1.getOrder_state().equals("wait_pay")) {
//				WriteError(response, "此订单状态不可申请退款");
//				return;
//			}
//
//			OrderGoodsBean orderGoodsBean = orderService
//					.getOrderGoodssByGoods(new OrderGoodsBean().setOrder_id(refundBean.getOrder_id())
//							.setOrder_goods_id(Integer.valueOf(refundBean.getOrder_goods_id())));
//			if (orderGoodsBean == null) {
//				WriteError(response, "此订单已不存在");
//				return;
//			}
//
//			if (Integer.valueOf(orderGoodsBean.getGoods_num()) < Integer.valueOf(refundBean.getRefund_count())) {
//				WriteError(response, "退款数量大于购买数量了");
//				return;
//			}
//
//			float refund_price = 0;// 需要返回用户金钱
//
//			if (orderBean1.getOrder_type().equals("goods")) {
//				refund_price += Float.valueOf(orderGoodsBean.getGoods_price())
//						* Float.valueOf(refundBean.getRefund_count());
//			} else if (orderBean1.getOrder_type().equals("group_buy")) {
//				refund_price += Float.valueOf(orderGoodsBean.getGroup_buy_price())
//						* Float.valueOf(refundBean.getRefund_count());
//			} else if (orderBean1.getOrder_type().equals("time_limit")) {
//				refund_price += Float.valueOf(orderGoodsBean.getPromotion_price())
//						* Float.valueOf(refundBean.getRefund_count());
//			}
//			
//			if("1".equals(orderGoodsBean.getIs_cross_border())){
//				refund_price += Float.valueOf(orderGoodsBean.getCross_border_tax())
//						* Float.valueOf(refundBean.getRefund_count());
//			}
//
//			if("reduce".equals(orderGoodsBean.getActivity_type())){//如果商品参加了满减活动  需要把减免的钱 先减掉
//				
//			}
//			
//			List<OrderParameterBean> orderParameterBeans = orderGoodsBean.getOrderParameterBeans();
//			for (int i = 0; i < orderParameterBeans.size(); i++) {
//				refund_price += Float.valueOf(orderParameterBeans.get(i).getParameter_price())
//						* Float.valueOf(refundBean.getRefund_count());
//			}
//
//			List<OrderServiceBean> orderServiceBeans = orderGoodsBean.getOrderServiceBeans();
//			for (int i = 0; i < orderServiceBeans.size(); i++) {
//				refund_price += Float.valueOf(orderServiceBeans.get(i).getService_price())
//						* Float.valueOf(refundBean.getRefund_count());
//			}
//
//			int num = orderService.refundOrder(
//					refundBean.setRefund_state("wait_review").setRefund_price(refund_price + ""), mapFiles);
//			if (num >= 0) {
//				WriteObject(response, "我们已收到您的退款申请了!请耐心等待啊");
//			} else {
//				WriteError(response, "哎呀!太遗憾了,我们没能成功收到您的退款申请!");
//			}
////		} catch (Exception e) {
////			WriteError(response, e.getMessage());
////		}
//	}

	
	/**
	 * 订单退款
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "refundOrder", method = RequestMethod.POST)
	public void refundOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			HashMap<String, Object> maps = getJsonWithImgs(request, "/images/order");
			if (maps.get("result").equals("failed")) {
				WriteError(response, "上传失败");
				return;
			}
			
			MemberBean memberBean = new Gson().fromJson(maps.get("string").toString(), MemberBean.class);
			RefundBean refundBean = new Gson().fromJson(maps.get("string").toString(), RefundBean.class);
			List<String> mapFiles = (List<String>) maps.get("file");

			MemberBean memberBean2 = memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}

			RefundBean refundBean2 = orderService.getRefundByGoods(refundBean);
			if (refundBean2 != null) {
				WriteError(response, "此订单商品已申请退款");
				return;
			}

			OrderBean orderBean1 = orderService
					.getOneOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(refundBean.getOrder_id())));
			if (orderBean1 == null) {
				WriteError(response, "此订单不存在");
				return;
			}

			if (orderBean1.getOrder_state().equals("cancle") || orderBean1.getOrder_state().equals("wait_pay")) {
				WriteError(response, "此订单状态不可申请退款");
				return;
			}

			OrderGoodsBean orderGoodsBean = orderService
					.getOrderGoodssByGoods(new OrderGoodsBean().setOrder_id(refundBean.getOrder_id())
							.setOrder_goods_id(Integer.valueOf(refundBean.getOrder_goods_id())));
			if (orderGoodsBean == null) {
				WriteError(response, "此订单已不存在");
				return;
			}

			if (Integer.valueOf(orderGoodsBean.getGoods_num()) < Integer.valueOf(refundBean.getRefund_count())) {
				WriteError(response, "退款数量大于购买数量了");
				return;
			}

			List<OrderGoodsBean> orderGoodsBeans=orderService.getOrderGoodss(new OrderGoodsBean().setOrder_id(refundBean.getOrder_id()));
			float total_price=0;
			for (int i = 0; i < orderGoodsBeans.size(); i++) {
				OrderGoodsBean orderGoodsBean2=orderGoodsBeans.get(i);
				if (orderBean1.getOrder_type().equals("goods")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getGoods_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				} else if (orderBean1.getOrder_type().equals("group_buy")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getGroup_buy_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				} else if (orderBean1.getOrder_type().equals("time_limit")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getPromotion_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				}
			}
			
			float base_price=0;
			if (orderBean1.getOrder_type().equals("goods")) {
				base_price += NumberUtils.Float(orderGoodsBean.getGoods_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			} else if (orderBean1.getOrder_type().equals("group_buy")) {
				base_price += NumberUtils.Float(orderGoodsBean.getGroup_buy_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			} else if (orderBean1.getOrder_type().equals("time_limit")) {
				base_price += NumberUtils.Float(orderGoodsBean.getPromotion_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			}
			float refund_price =NumberUtils.Float(orderBean1.getOrder_actual_price())*base_price/total_price;// 需要返回用户金钱
			float refund_integral_value=(NumberUtils.Float(orderBean1.getDeduct_integral_value())
					-NumberUtils.Float(orderBean1.getGive_integral_value()))*base_price/total_price;
			
			
			String imgs = request.getParameter("imgs");
			String refund_no = TimeUtils.getCurrentTime("yyyyMMddHHmmss");
			int num = orderService.refundOrder(refundBean.setRefund_state("wait_review")
					.setRefund_price(NumberUtils.KeepDecimal(refund_price, 2) + "")
					.setRefund_no(refund_no)
					.setRefund_integral_value(NumberUtils.KeepDecimal(refund_integral_value, 2)+""),
					imgs == null ? null : (imgs.length() > 0 ? imgs.split(",") : null));


			if (num >= 0) {
				WriteObject(response, "我们已收到您的退款申请了!请耐心等待啊");
			} else {
				WriteError(response, "哎呀!太遗憾了,我们没能成功收到您的退款申请!");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * 订单退款
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "refundOrderV2", method = RequestMethod.POST)
	public void refundOrderV2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			HashMap<String, Object> maps = getJsonWithImgs(request, "/images/order");
			if (maps.get("result").equals("failed")) {
				WriteError(response, "上传失败");
				return;
			}
			
			MemberBean memberBean = new Gson().fromJson(maps.get("string").toString(), MemberBean.class);
			RefundBean refundBean = new Gson().fromJson(maps.get("string").toString(), RefundBean.class);
			List<String> mapFiles = (List<String>) maps.get("file");

			MemberBean memberBean2 = memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}

			RefundBean refundBean2 = orderService.getRefundByGoods(refundBean);
			if (refundBean2 != null) {
				WriteError(response, "此订单商品已申请退款");
				return;
			}

			OrderBean orderBean1 = orderService
					.getOneOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(refundBean.getOrder_id())));
			if (orderBean1 == null) {
				WriteError(response, "此订单不存在");
				return;
			}

			if (orderBean1.getOrder_state().equals("cancle") || orderBean1.getOrder_state().equals("wait_pay")) {
				WriteError(response, "此订单状态不可申请退款");
				return;
			}

			OrderGoodsBean orderGoodsBean = orderService
					.getOrderGoodssByGoods(new OrderGoodsBean().setOrder_id(refundBean.getOrder_id())
							.setOrder_goods_id(Integer.valueOf(refundBean.getOrder_goods_id())));
			if (orderGoodsBean == null) {
				WriteError(response, "此订单已不存在");
				return;
			}

			if (Integer.valueOf(orderGoodsBean.getGoods_num()) < Integer.valueOf(refundBean.getRefund_count())) {
				WriteError(response, "退款数量大于购买数量了");
				return;
			}

			List<OrderGoodsBean> orderGoodsBeans=orderService.getOrderGoodss(new OrderGoodsBean().setOrder_id(refundBean.getOrder_id()));
			float total_price=0;
			for (int i = 0; i < orderGoodsBeans.size(); i++) {
				OrderGoodsBean orderGoodsBean2=orderGoodsBeans.get(i);
				if (orderBean1.getOrder_type().equals("goods")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getGoods_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				} else if (orderBean1.getOrder_type().equals("group_buy")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getGroup_buy_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				} else if (orderBean1.getOrder_type().equals("time_limit")) {
					total_price += NumberUtils.Float(orderGoodsBean2.getPromotion_price())
							* Float.valueOf(orderGoodsBean2.getGoods_num());
				}
			}
			
			float base_price=0;
			if (orderBean1.getOrder_type().equals("goods")) {
				base_price += NumberUtils.Float(orderGoodsBean.getGoods_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			} else if (orderBean1.getOrder_type().equals("group_buy")) {
				base_price += NumberUtils.Float(orderGoodsBean.getGroup_buy_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			} else if (orderBean1.getOrder_type().equals("time_limit")) {
				base_price += NumberUtils.Float(orderGoodsBean.getPromotion_price())
						* NumberUtils.Float(refundBean.getRefund_count());
			}
			float refund_price =NumberUtils.Float(orderBean1.getOrder_actual_price())*base_price/total_price;// 需要返回用户金钱
			float refund_integral_value=(NumberUtils.Float(orderBean1.getDeduct_integral_value())
					-NumberUtils.Float(orderBean1.getGive_integral_value()))*base_price/total_price;
			
			
			String imgs = request.getParameter("imgs");
			String refund_no = TimeUtils.getCurrentTime("yyyyMMddHHmmss");
			int num = orderService.refundOrder(refundBean.setRefund_state("wait_review")
					.setRefund_price(NumberUtils.KeepDecimal(refund_price, 2) + "")
					.setRefund_no(refund_no)
					.setRefund_integral_value(NumberUtils.KeepDecimal(refund_integral_value, 2)+""),
					imgs == null ? null : (imgs.length() > 0 ? imgs.split(",") : null));


			if (num >= 0) {
				WriteObject(response, "我们已收到您的退款申请了!请耐心等待啊");
			} else {
				WriteError(response, "哎呀!太遗憾了,我们没能成功收到您的退款申请!");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * 获得订单列表
	 * 
	 * @param memberBean
	 * @param orderBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOrders", method = RequestMethod.POST)
	public void getOrders(MemberBean memberBean, OrderBean orderBean, PageBean pageBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, orderService.getOrders(orderBean, pageBean), pageBean.getTotal());
	}

	/**
	 * 获得订单列表 每个状态统计
	 * 
	 * @param memberBean
	 * @param orderBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOrdersCount", method = RequestMethod.POST)
	public void getOrdersCount(MemberBean memberBean, OrderBean orderBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, orderService.getOrdersCount(orderBean));
	}

	/**
	 * 获得单个订单详情
	 * 
	 * @param memberBean
	 * @param orderBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneOrderDetail", method = RequestMethod.POST)
	public void getOneOrderDetail(MemberBean memberBean, OrderBean orderBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, orderService.getOneOrderDetail(orderBean));
	}

	/**
	 * 余额充值订单
	 * 
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "insertRechargeOrder", method = RequestMethod.POST)
	public void insertRechargeOrder(MemberBean memberBean, PayBean payBean, OrderBean orderBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			MemberBean memberBean2 = memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}
			if (NumberUtils.Float(orderBean.getOrder_total_price()) <= 0) {
				WriteError(response, "充值金额非法");
				return;
			}

			String order_id = orderService.insertRechargeOrder(orderBean);

			PingSettingBean pingSettingBean = othersService.getPingSetting(new PingSettingBean().setPing_type("1"));

			Pingpp.apiKey = pingSettingBean.getPing_app_key();

			Pingpp.privateKeyPath = getClass().getResource("/").getFile().toString() + "/rsa_private_key.pem";
			Map<String, Object> chargeParams = new HashMap<String, Object>();

			String order_pay_no = order_id + TimeUtils.getCurrentTime("HHmmss");

			chargeParams.put("order_no", order_pay_no);
			chargeParams.put("amount", NumberUtils.Double(orderBean.getOrder_total_price()) * 100);// total_price*100
			Map<String, String> app = new HashMap<String, String>();

			app.put("id", pingSettingBean.getPing_app_id());

			chargeParams.put("app", app);
			chargeParams.put("channel", payBean.getChannel());
			chargeParams.put("currency", "cny");
			chargeParams.put("client_ip", request.getRemoteAddr());
			chargeParams.put("subject", "余额充值");
			chargeParams.put("body", "余额充值");

			if (payBean.getChannel().equals("wx_pub")) {
				Map<String, Object> extra = new HashMap<String, Object>();
				extra.put("open_id", memberBean2.getWx_pub_openid());// 用户在商户微信公众号下的唯一标识，获取方式可参考
																		// WxPubOAuthExample.java
				chargeParams.put("extra", extra);
			} else if (payBean.getChannel().equals("alipay_pc_direct")) {
				HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));
				Map<String, Object> extra = new HashMap<String, Object>();
				extra.put("success_url", hostBean.getHost_url() + "/core.html#/");
				chargeParams.put("extra", extra);
			} else if (payBean.getChannel().equals("wx_pub_qr")) {
				Map<String, Object> extra = new HashMap<String, Object>();
				extra.put("product_id", CreateRandom.createRandom(false, 20));// 用户在商户微信公众号下的唯一标识，获取方式可参考
				// WxPubOAuthExample.java
				chargeParams.put("extra", extra);
			}

			Charge charge = Charge.create(chargeParams);
			orderService.updateOrderDetail(
					new OrderBean().setOrder_id(Integer.valueOf(order_id)).setOrder_pay_no(charge.getId()));

			if (payBean.getChannel().equals("wx_pub_qr")) {
				String file_name = TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss") + CreateRandom.createRandom(true, 6)
						+ ".png";
				QRCodeUtils.CreateQrcode(request, "/images/qrcode/wx_pub_qr/" + file_name,
						charge.getCredential().get("wx_pub_qr").toString());
				Map map=new HashMap();
				map.put("order_id", order_id);
				map.put("qrcode_img", "/images/qrcode/wx_pub_qr/" + file_name);
				WriteObject(response,map);
			} else {
				WriteObject(response, charge);
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}

	
	/**
	 * 下单
	 * 
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "insertOrder", method = RequestMethod.POST)
	public void insertOrder(MemberBean memberBean,OrderBean orderBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}
			String json = request.getParameter("json");
			OrderMerchantsBean orderMerchantsBean = new Gson().fromJson(json, OrderMerchantsBean.class);

			String type = request.getParameter("type");
		
			Map<String, String> map = orderService.insertOrder(orderMerchantsBean,type);
			if (map == null) {
				WriteError(response, "未选择商品");
			} else {				
				WriteMsg(response, map.get("order_ids"));
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}

	/**
	 * 下单
	 * 
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "insertOrderV2", method = RequestMethod.POST)
	public void insertOrderV2(MemberBean memberBean, OrderBean orderBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}
			String json = request.getParameter("json");

			OrderMerchantsBean orderMerchantsBean = new Gson().fromJson(json, OrderMerchantsBean.class);

			String type = request.getParameter("type");
			Map map = orderService.insertOrder(orderMerchantsBean, type);
			if (map == null) {
				WriteError(response, "未选择商品");
			} else {
				WriteObject(response, map);
			}
		} catch (Exception e) {
			if(e.getMessage()!=null&&e.getMessage().indexOf("库存不足")>=0){
				WritePending(response, e.getMessage());
			}else{
				WriteError(response, e.getMessage());				
			}
		}
	}

	/**
	 * 获取订单金额
	 * 
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "getOrderPrice", method = RequestMethod.POST)
	public void getOrderPrice(MemberBean memberBean, OrderBean orderBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}
			String json = request.getParameter("json");
			OrderMerchantsBean orderMerchantsBean = new Gson().fromJson(json, OrderMerchantsBean.class);
			
			WriteObject(response, orderService.getOrderPrice(orderMerchantsBean));
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 下单
	 * 
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "insertOrderHBR", method = RequestMethod.POST)
	public void insertOrderHBR(MemberBean memberBean, OrderBean orderBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}
			String json = request.getParameter("json");
			OrderMerchantsBean orderMerchantsBean = new Gson().fromJson(json, OrderMerchantsBean.class);
			
			String num = orderService.insertOrderHBR(orderMerchantsBean);
			if (num.equals("-1000")) {
				WriteError(response, "未选择商品");
			} else if (num.equals("-2000")) {
				WriteError(response, "地址已不存在");
			} else if (num.equals("-3000")) {
				WriteError(response, "此商家已下架或已删除");
			} else if (num.equals("-1")) {
				WriteError(response, "下单失败");
			} else {
				WriteMsg(response, num);
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());				
		}
	}

	/**
	 * 取消订单
	 * 
	 * @param memberBean
	 * @param orderBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "cancelOrder", method = RequestMethod.POST)
	public void cancelOrder(MemberBean memberBean, OrderBean orderBean, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}

			OrderBean orderBean1 = orderService.getOneOrderDetail(orderBean);
			if (orderBean1 != null && !orderBean1.getOrder_state().equals("wait_pay")) {
				WriteError(response, "此状态不可取消订单");
				return;
			}

			int num = orderService.cancelOrder(orderBean1);
			if (num > 0) {
				WriteMsg(response, "取消成功");
			} else {
				WriteError(response, "取消失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage() == null ? "取消失败" : e.getMessage().toString());
		}
	}

	/**
	 * 取消 已付款 待发货订单
	 * 
	 * @param memberBean
	 * @param orderBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "cancelPayOrder", method = RequestMethod.POST)
	public void cancelPayOrder(MemberBean memberBean, OrderBean orderBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}

			OrderBean orderBean1 = orderService.getOneOrderDetail(orderBean);
			if (orderBean1 != null && !orderBean1.getOrder_state().equals("wait_send")) {
				WriteError(response, "此状态不可取消订单");
				return;
			}

			int num = orderService.cancelPayOrder(orderBean1);
			if (num > 0) {
				WriteMsg(response, "取消成功");
			} else {
				WriteError(response, "取消失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage() == null ? "取消失败" : e.getMessage().toString());
		}
	}

	/**
	 * 删除已完成订单
	 * 
	 * @param memberBean
	 * @param orderBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteOrder", method = RequestMethod.POST)
	public void deleteOrder(MemberBean memberBean, OrderBean orderBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		OrderBean orderBean1 = orderService.getOneOrderDetail(orderBean);
		if (orderBean1 != null && orderBean1.getOrder_state().equals("end")
				&& !orderBean1.getOrder_state().equals("cancel")
				&& !orderBean1.getOrder_state().equals("wait_assessment")) {
			WriteError(response, "此状态订单不可删除");
			return;
		}

		if (orderBean1 == null) {
			WriteError(response, "此订单不存在");
			return;
		} else if (orderBean1.getOrder_state().equals("end")) {

		} else if (orderBean1.getOrder_state().equals("cancel")) {

		} else if (orderBean1.getOrder_state().equals("wait_assessment")) {

		} else {
			WriteError(response, "此状态订单不可删除");
			return;
		}
		int num = orderService.deleteOrder(orderBean);
		if (num > 0) {
			WriteMsg(response, "删除成功");
		} else {
			WriteError(response, "删除失败");
		}
	}

	/**
	 * 付款订单
	 * 
	 * @param memberBean
	 * @param orderBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "payOrder", method = RequestMethod.POST)
	public void payOrder(MemberBean memberBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		// OrderBean orderBean1 = orderService.getOneOrderDetail(orderBean);
		// if (orderBean1 != null &&
		// !orderBean1.getOrder_state().equals("wait_pay")) {
		// WriteError(response, "此状态不可付款下单");
		// return;
		// }

		String[] order_ids = request.getParameter("order_ids").split(",");
		int num = orderService.paySuccessOrder(order_ids, null, null);
		if (num > 0) {
			WriteMsg(response, "付款成功");
		} else {
			WriteError(response, "付款失败");
		}
	}

	/**
	 * 支付订单
	 * 
	 * @param memberBean
	 * @param orderBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "payRealOrders", method = RequestMethod.POST)
	public void payRealOrders(MemberBean memberBean, OrderBean orderBean, PayBean payBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		MemberBean memberBean2 = memberService.verificationToken(memberBean);
		String order_no = "";
		double total_price = 0;
		String body = "便宜实惠!";
		String type = request.getParameter("type");// 公司类别

		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}

		int integral = 0;
		boolean is_stock = true;// 判断库存是否有

		String[] order_ids = request.getParameter("order_ids").split(",");
		for (int i = 0; i < order_ids.length; i++) {
			OrderBean orderBean2 = orderService
					.getOneOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(order_ids[i])));
			total_price += NumberUtils.KeepDecimal(orderBean2.getOrder_actual_price(),2);
			order_no += orderBean2.getOrder_id() + "A";

			if (orderBean2.getOrder_type().equals("group_buy")) {// 团购下的单
				GroupBuyGoodsBean groupBuyGoodsBean = activityService.getGoodsGroupBuyByMember(new GroupBuyMemberBean()
						.setMember_group_buy_id(Integer.valueOf(orderBean2.getMember_group_buy_id()))
						.setGroup_buy_now_people(orderBean2.getOrderGoodsBeans().get(0).getGoods_num() + ""));
				float group_buy_now_people = Integer.valueOf(groupBuyGoodsBean.getGroup_buy_now_people());
				float group_buy_need_people = Integer.valueOf(groupBuyGoodsBean.getGroup_buy_need_people());
				if (group_buy_now_people >= group_buy_need_people) {
					WriteError(response, "下手太慢啦 人数已满");
					return;
				}

				int a = TimeUtils.compareDate(groupBuyGoodsBean.getEnd_time(),
						TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss");
				if (a <= 0) {
					WriteError(response, "该团购时间已到!");
					return;
				}
			}

			List<OrderGoodsBean> orderGoodsBeans = orderService
					.getOrderGoodss(new OrderGoodsBean().setOrder_id(order_ids[i]));
			for (int j = 0; j < orderGoodsBeans.size(); j++) {
				OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(j);
				GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(new GoodsBean().setGoods_id(Integer.valueOf(orderGoodsBeans.get(j).getGoods_id())));
				if (goodsBean.getGoods_stock() < orderGoodsBean.getGoods_num()) {
					WriteError(response,goodsBean.getGoods_name()+"库存不足");
					return;
				}
			}
		}

		if (total_price == 0) {// 如果订单已用积分付款成功 则不需要真实支付
			WritePending(response, "pay_success");
			return;
		}

		PingSettingBean pingSettingBean = othersService.getPingSetting(new PingSettingBean().setPing_type("1"));

		Pingpp.apiKey = pingSettingBean.getPing_app_key();

		Pingpp.privateKeyPath = getClass().getResource("/").getFile().toString() + "/rsa_private_key.pem";
		Map<String, Object> chargeParams = new HashMap<String, Object>();

		String order_pay_no = order_no.substring(0, order_no.length() - 1) + TimeUtils.getCurrentTime("HHmmss");

		chargeParams.put("order_no", order_pay_no);
		chargeParams.put("amount", total_price * 100);// total_price*100
		Map<String, String> app = new HashMap<String, String>();

		app.put("id", pingSettingBean.getPing_app_id());

		chargeParams.put("app", app);
		chargeParams.put("channel", payBean.getChannel());
		chargeParams.put("currency", "cny");
		chargeParams.put("client_ip", request.getRemoteAddr());
		chargeParams.put("subject", "商品购买");
		chargeParams.put("body", body.substring(0, body.length() > 20 ? 20 : body.length()));

		if (payBean.getChannel().equals("wx_pub")) {
			Map<String, Object> extra = new HashMap<String, Object>();
			extra.put("open_id", memberBean2.getWx_pub_openid());// 用户在商户微信公众号下的唯一标识，获取方式可参考
																	// WxPubOAuthExample.java
			chargeParams.put("extra", extra);
		} else if (payBean.getChannel().equals("alipay_pc_direct")) {
			HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));
			Map<String, Object> extra = new HashMap<String, Object>();
			extra.put("success_url", hostBean.getHost_url() + "/core.html#/");
			chargeParams.put("extra", extra);
		} else if (payBean.getChannel().equals("wx_pub_qr")) {
			Map<String, Object> extra = new HashMap<String, Object>();
			extra.put("product_id", CreateRandom.createRandom(false, 20));// 用户在商户微信公众号下的唯一标识，获取方式可参考
			// WxPubOAuthExample.java
			chargeParams.put("extra", extra);
		}
		Charge charge = Charge.create(chargeParams);
		for (int i = 0; i < order_ids.length; i++) {
			orderService.updateOrderDetail(
					new OrderBean().setOrder_id(Integer.valueOf(order_ids[i])).setOrder_pay_no(charge.getId()));
		}

		if (payBean.getChannel().equals("wx_pub_qr")) {
			String file_name = TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss") + CreateRandom.createRandom(true, 6)
					+ ".png";
			QRCodeUtils.CreateQrcode(request, "/images/qrcode/wx_pub_qr/" + file_name,
					charge.getCredential().get("wx_pub_qr").toString());
			WriteMsg(response, "/images/qrcode/wx_pub_qr/" + file_name);
		} else {
			WriteObject(response, charge);
		}
	}

	/**
	 *
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "payOrderAlipay", method = RequestMethod.POST)
	public void payOrderAlipay(MemberBean memberBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MemberBean memberBean2 = memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}
		String order_no = "";
		float total_price = 0;

		String[] order_ids = request.getParameter("order_ids").split(",");
		for (int i = 0; i < order_ids.length; i++) {
			OrderBean orderBean2 = orderService
					.getOneOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(order_ids[i])));
			total_price += NumberUtils.Float(orderBean2.getOrder_actual_price());

			order_no += orderBean2.getOrder_id() + "A";
		}

		if (total_price == 0) {// 如果订单已用积分付款成功 则不需要真实支付
			WritePending(response, "pay_success");
		}

		String order_pay_no = order_no.substring(0, order_no.length() - 1) + TimeUtils.getCurrentTime("HHmmss");
		String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK5tBMN+bVcUJIaqikdHhGobdjQJPpfeEJLWK0egXawbQB6isRpG7fxl8Ydi/f+Rxcm8saFe5JCeDORBnlBDvBxIuF7Kq97M727TcX2eov248SjucCvs3G22VBNLblOBCj36+ut3ZPCZxb8WrfLR09Z1p6K6t3jvxdqAWYxaYh8jAgMBAAECgYBJENfnAIXS7VgjpTrJgxbfz+MjByBWQ6qTp+13UqEKoFuquaIQjNfSW+3iNcCKl0jQKiAKphJ+1gY2c5paqxUX3mLp6/1gNZMz5eHN8zr6wpwMJpIZsamLziKzFWOaBkQ/7k4ifxExSTgDd3yGDY1g1oMwOvNzByWWfdXlz7IvmQJBAOW1r78RxPbdpzQ/REy7cxU6Ux5uUkOO9BTIChS8EKUZOz729COBNN/5SgeNJXEdYAQJPCp4OUcxTVptC56k8fUCQQDCY48BY2YA5T0w5wwOUTtEyYZZI4U8GFFvDn24QHuOedNeELJW2TiACWFvQChEo/CEzzXR+2/wHbw3iQITReW3AkA7n8xNaRxaA7Cp5B4jWKiHgwseI/6gYJPEbSQIu8QKRqFVN56pNJl35WosyZtFYB2TDp6aW3hqnUZ5yUIx3JidAkEAqycLl7ZT7n/og7E63TRKkgM6JivvOH1U3gqNSPiFkWnUX+MlkvBJHfqkbla33c/WiqkDAzJ2WZ1kxiT8zcliOwJAShk02uup7qVg+VPbon/Ijd0QD7b0meaDjkxoiG2TDHnKS26FWWIK1PCeoM5ShPKe+5C6w8e4Hi3KMmxAhklNlw==";
		double rate = AlipayUtils.getAlipayRate("2088421968201881", privateKey, "USD");

		Map<String, String> map = new HashMap<String, String>();
		map.put("service", "mobile.securitypay.pay");
		map.put("partner", "2088421968201881");
		map.put("_input_charset", "utf-8");
		map.put("out_trade_no", order_pay_no);
		map.put("subject", "荷柏瑞商品");
		map.put("payment_type", "1");
		map.put("seller_id", "artzone@hb-china.com.cn");
		// map.put("total_fee", NumberUtils.KeepDecimal(0.1/rate,
		// 2)+"");//NumberUtils.KeepDecimal(total_price/rate, 2);
		map.put("rmb_fee", total_price + "");// total_price

		map.put("forex_biz", "FP");
		map.put("currency", "USD");
		map.put("body", "很好的商品");
		map.put("notify_url", "http://hbr.tstweiguanjia.com/orderInterfaces/paySuccessOrderAlipay");

		String wait_pay = AlipayUtils.createLinkString(map);// 待签名字符串

		String sign = RSAUtils.sign(wait_pay, privateKey, "utf-8");
		map.put("notify_url",
				URLEncoder.encode("http://hbr.tstweiguanjia.com/orderInterfaces/paySuccessOrderAlipay", "utf-8"));
		map.put("sign", URLEncoder.encode(sign, "utf-8"));
		map.put("sign_type", "RSA");
		String pay = AlipayUtils.createLinkString(map);// 支付字符串

		// writeHtml(request, "/html/others/protocols.html", pay,null);
		for (int i = 0; i < order_ids.length; i++) {
			orderService
					.updateOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(order_ids[i])).setOrder_charge(pay));
		}
		WriteMsg(response, pay);
	}

	/**
	 *
	 * 储值卡余额充值
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "rechargeOrderAlipay", method = RequestMethod.POST)
	public void rechargeOrderAlipay(MemberBean memberBean, OrderBean orderBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			MemberBean memberBean2 = memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}
			if (NumberUtils.Integer(orderBean.getOrder_total_price()) < 0) {
				WriteError(response, "充值金额非法");
				return;
			}

			String order_id = orderService.insertRechargeOrder(orderBean);

			String order_pay_no = order_id + TimeUtils.getCurrentTime("HHmmss");
			String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK5tBMN+bVcUJIaqikdHhGobdjQJPpfeEJLWK0egXawbQB6isRpG7fxl8Ydi/f+Rxcm8saFe5JCeDORBnlBDvBxIuF7Kq97M727TcX2eov248SjucCvs3G22VBNLblOBCj36+ut3ZPCZxb8WrfLR09Z1p6K6t3jvxdqAWYxaYh8jAgMBAAECgYBJENfnAIXS7VgjpTrJgxbfz+MjByBWQ6qTp+13UqEKoFuquaIQjNfSW+3iNcCKl0jQKiAKphJ+1gY2c5paqxUX3mLp6/1gNZMz5eHN8zr6wpwMJpIZsamLziKzFWOaBkQ/7k4ifxExSTgDd3yGDY1g1oMwOvNzByWWfdXlz7IvmQJBAOW1r78RxPbdpzQ/REy7cxU6Ux5uUkOO9BTIChS8EKUZOz729COBNN/5SgeNJXEdYAQJPCp4OUcxTVptC56k8fUCQQDCY48BY2YA5T0w5wwOUTtEyYZZI4U8GFFvDn24QHuOedNeELJW2TiACWFvQChEo/CEzzXR+2/wHbw3iQITReW3AkA7n8xNaRxaA7Cp5B4jWKiHgwseI/6gYJPEbSQIu8QKRqFVN56pNJl35WosyZtFYB2TDp6aW3hqnUZ5yUIx3JidAkEAqycLl7ZT7n/og7E63TRKkgM6JivvOH1U3gqNSPiFkWnUX+MlkvBJHfqkbla33c/WiqkDAzJ2WZ1kxiT8zcliOwJAShk02uup7qVg+VPbon/Ijd0QD7b0meaDjkxoiG2TDHnKS26FWWIK1PCeoM5ShPKe+5C6w8e4Hi3KMmxAhklNlw==";
			double rate = AlipayUtils.getAlipayRate("2088421968201881", privateKey, "USD");

			Map<String, String> map = new HashMap<String, String>();
			map.put("service", "mobile.securitypay.pay");
			map.put("partner", "2088421968201881");
			map.put("_input_charset", "utf-8");
			map.put("out_trade_no", order_pay_no);
			map.put("subject", "荷柏瑞商品");
			map.put("payment_type", "1");
			map.put("seller_id", "artzone@hb-china.com.cn");
			// map.put("total_fee", NumberUtils.KeepDecimal(0.1/rate,
			// 2)+"");//NumberUtils.KeepDecimal(total_price/rate, 2);
			map.put("rmb_fee", NumberUtils.KeepDecimal(NumberUtils.Double(orderBean.getOrder_total_price()), 2) + "");// total_price

			map.put("forex_biz", "FP");
			map.put("currency", "USD");
			map.put("body", "很好的商品");
			map.put("notify_url", "http://hbr.tstweiguanjia.com/orderInterfaces/paySuccessOrderAlipay");

			String wait_pay = AlipayUtils.createLinkString(map);// 待签名字符串

			String sign = RSAUtils.sign(wait_pay, privateKey, "utf-8");
			map.put("notify_url",
					URLEncoder.encode("http://hbr.tstweiguanjia.com/orderInterfaces/paySuccessOrderAlipay", "utf-8"));
			map.put("sign", URLEncoder.encode(sign, "utf-8"));
			map.put("sign_type", "RSA");
			String pay = AlipayUtils.createLinkString(map);// 支付字符串

			WriteMsg(response, pay);
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}

	}

	/**
	 * 获得 alipay汇率
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAlipayRate", method = RequestMethod.POST)
	public void getAlipayRate(MemberBean memberBean, RefundReasonBean refundReasonBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK5tBMN+bVcUJIaqikdHhGobdjQJPpfeEJLWK0egXawbQB6isRpG7fxl8Ydi/f+Rxcm8saFe5JCeDORBnlBDvBxIuF7Kq97M727TcX2eov248SjucCvs3G22VBNLblOBCj36+ut3ZPCZxb8WrfLR09Z1p6K6t3jvxdqAWYxaYh8jAgMBAAECgYBJENfnAIXS7VgjpTrJgxbfz+MjByBWQ6qTp+13UqEKoFuquaIQjNfSW+3iNcCKl0jQKiAKphJ+1gY2c5paqxUX3mLp6/1gNZMz5eHN8zr6wpwMJpIZsamLziKzFWOaBkQ/7k4ifxExSTgDd3yGDY1g1oMwOvNzByWWfdXlz7IvmQJBAOW1r78RxPbdpzQ/REy7cxU6Ux5uUkOO9BTIChS8EKUZOz729COBNN/5SgeNJXEdYAQJPCp4OUcxTVptC56k8fUCQQDCY48BY2YA5T0w5wwOUTtEyYZZI4U8GFFvDn24QHuOedNeELJW2TiACWFvQChEo/CEzzXR+2/wHbw3iQITReW3AkA7n8xNaRxaA7Cp5B4jWKiHgwseI/6gYJPEbSQIu8QKRqFVN56pNJl35WosyZtFYB2TDp6aW3hqnUZ5yUIx3JidAkEAqycLl7ZT7n/og7E63TRKkgM6JivvOH1U3gqNSPiFkWnUX+MlkvBJHfqkbla33c/WiqkDAzJ2WZ1kxiT8zcliOwJAShk02uup7qVg+VPbon/Ijd0QD7b0meaDjkxoiG2TDHnKS26FWWIK1PCeoM5ShPKe+5C6w8e4Hi3KMmxAhklNlw==";
		double result = AlipayUtils.getAlipayRate("2088421968201881", privateKey, "USD");
		WriteMsg(response, result + "");
	}

	/**
	 * 余额支付
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "payBalanceSuccessOrder", method = RequestMethod.POST)
	public void payBalanceSuccessOrder(MemberBean memberBean, CodeBean codeBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			PercentBean percentBean = othersService.getPercent(new PercentBean().setPercent_type("balance_pay"));
			if (percentBean != null && !percentBean.getPercent_value().equals("true")) {
				WriteError(response, "余额支付暂不开放");
				return;
			}
			MemberBean memberBean1 = memberService.verificationToken(memberBean);
			if (memberBean1 == null) {
				WritePending(response, "token failed");
				return;
			}

			if (codeService.getCodeBeanByMobileAndCode(
					codeBean.setMobile(memberBean1.getMember_account()).setCode_type("balance_pay")
							.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
				WriteError(response, "此验证码已过期");
				return;
			}

			codeService.deleteCodeByMobileAndCode(codeBean);
			
			if (memberBean1.getBalance_password() == null || "".equals(memberBean1.getBalance_password())) {
				WriteError(response, "请先设置支付密码");
				return;
			}

			if (!memberBean1.getBalance_password().equals(MD5Util.md5Encode(memberBean.getBalance_password()))) {
				WriteError(response, "支付密码错误");
				return;
			}

			
			String[] order_ids = request.getParameter("order_ids").split(",");			
			for (int i = 0; i < order_ids.length; i++) {
				orderService.updateOrderDetail(
						new OrderBean().setOrder_id(Integer.valueOf(order_ids[i]))
						.setOrder_pay_no(Arrays.toString(order_ids).replaceAll("^\\[| |\\]$", "")));
			}		
			
			int num = orderService.paySuccessOrder(order_ids, "balance", null);
			if (num > 0) {
				WriteMsg(response, "支付成功");
			} else {
				WriteError(response, "支付失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}

	
	/**
	 * 储值卡支付
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "payStoredSuccessOrder", method = RequestMethod.POST)
	public void payStoredSuccessOrder(MemberBean memberBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			MemberBean memberBean1 = memberService.verificationToken(memberBean);
			if (memberBean1 == null) {
				WritePending(response, "token failed");
				return;
			}

			if ("".equals(memberBean1.getStored_code())) {
				WriteError(response, "未开通储值卡");
				return;
			}

			String[] order_ids = request.getParameter("order_ids").split(",");
			for (int i = 0; i < order_ids.length; i++) {
				orderService.updateOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(order_ids[i]))
						.setOrder_pay_no(Arrays.toString(order_ids).replaceAll("^\\[| |\\]$", "")));
			}

			
			int num = orderService.paySuccessOrder(order_ids, "stored", memberBean.getPassword());
			if (num > 0) {
				WriteMsg(response, "支付成功");
			} else {
				WriteError(response, "支付失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}

	/**
	 * 余额支付
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "payTrustSuccessOrder", method = RequestMethod.POST)
	public void payTrustSuccessOrder(MemberBean memberBean, CodeBean codeBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			PercentBean percentBean = othersService.getPercent(new PercentBean().setPercent_type("trust_pay"));
			if (percentBean != null && !percentBean.getPercent_value().equals("true")) {
				WriteError(response, "信用额度支付暂不开放");
				return;
			}

			MemberBean memberBean1 = memberService.verificationToken(memberBean);
			if (memberBean1 == null) {
				WritePending(response, "token failed");
				return;
			}

			if (codeService.getCodeBeanByMobileAndCode(
					codeBean.setMobile(memberBean1.getMember_account()).setCode_type("trust_pay")
							.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
				WriteError(response, "此验证码已过期");
				return;
			}

			codeService.deleteCodeByMobileAndCode(codeBean);
			
			if (memberBean1.getTrust_password() == null || "".equals(memberBean1.getTrust_password())) {
				WriteError(response, "请先设置支付密码");
				return;
			}

			if (!memberBean1.getTrust_password().equals(MD5Util.md5Encode(memberBean.getTrust_password()))) {
				WriteError(response, "支付密码错误");
				return;
			}

			String[] order_ids = request.getParameter("order_ids").split(",");
			
			for (int i = 0; i < order_ids.length; i++) {
				orderService.updateOrderDetail(
						new OrderBean().setOrder_id(Integer.valueOf(order_ids[i]))
						.setOrder_pay_no(Arrays.toString(order_ids).replaceAll("^\\[| |\\]$", "")));
			}

			
			int num = orderService.paySuccessOrder(order_ids, "trust", null);
			if (num > 0) {
				WriteMsg(response, "支付成功");
			} else {
				WriteError(response, "支付失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}

	@RequestMapping(params = "paySuccessOrder", method = RequestMethod.POST)
	public void paySuccessOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// writeHtml(request,"/html/others/about_our.html","123",null);
		String json = readJSONString(request);
		// writeHtml(request,"/html/others/about_our.html",json,null);
		PingOrderBean pingOrderBean = new Gson().fromJson(json, PingOrderBean.class);
		
		String orderNo = pingOrderBean.getData().getObject().getOrder_no();
		String[] order_ids = orderNo.substring(0, orderNo.length() - 6).split("A");
		
		int num = orderService.paySuccessOrder(order_ids, pingOrderBean.getData().getObject().getChannel(), null);
		if (num > 0) {
			WriteMsg(response, "支付成功");
		} else {
			WriteError(response, "支付失败");
		}
	}

	/**
	 * 确认收货
	 * 
	 * @param memberBean
	 * @param orderBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "confirmOrder", method = RequestMethod.POST)
	public void confirmOrder(MemberBean memberBean, OrderBean orderBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		OrderBean orderBean1 = orderService.getOneOrderDetail(orderBean);
		if (orderBean1 != null && !orderBean1.getOrder_state().equals("wait_receive")) {
			WriteError(response, "此状态不可确认收货");
			return;
		}

		int num = orderService.confirmOrder(orderBean);
		if (num > 0) {
			WriteMsg(response, "确认成功");
		} else {
			WriteError(response, "确认失败");
		}
	}

	/**
	 * 上传评价订单图片
	 * 
	 * @param merchantsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadAssessmentImg")
	public void uploadAssessmentImg(MerchantsBean merchantsBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String json = uploadFile(request, "/images/assessment/");
		if (json.equals("-1")) {
			WriteError(response, "文件不可为空");
		} else if (json.equals("-2")) {
			WriteError(response, "上传失败");
		} else {
			WriteMsg(response, json);
		}
	}

	/**
	 * 可追加评价订单
	 * 
	 * @param memberBean
	 * @param orderBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getCanAddAssessmentOrder", method = RequestMethod.POST)
	public void getCanAddAssessmentOrder(MemberBean memberBean, OrderBean orderBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, orderService.getCanAddAssessmentOrder(orderBean, pageBean), pageBean.getTotal());
	}

	/**
	 * 评价订单
	 * 
	 * @param memberBean
	 * @param orderBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "assessmentOrder", method = RequestMethod.POST)
	public void assessmentOrder(MemberBean memberBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		String json = request.getParameter("json");
		List<AssessmentBean> assessmentBeans = new Gson().fromJson(json, new TypeToken<List<AssessmentBean>>() {
		}.getType());

		if (assessmentBeans != null && assessmentBeans.size() > 0) {
			OrderBean orderBean1 = orderService.getOneOrderDetail(
					new OrderBean().setOrder_id(Integer.valueOf(assessmentBeans.get(0).getOrder_id())));
			if (orderBean1 != null && !orderBean1.getOrder_state().equals("end")
					&& !orderBean1.getOrder_state().equals("wait_assessment")) {
				WriteError(response, "此状态不可评价订单");
				return;
			}
		}

		int num = orderService.assessmentOrder(assessmentBeans);
		if (num > 0) {
			WriteMsg(response, "评价成功");
		} else {
			WriteError(response, "评价失败");
		}
	}

	/**
	 * 获得订单评价
	 * 
	 * @param memberBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOrderAssessments", method = RequestMethod.POST)
	public void getOrderAssessments(MemberBean memberBean, AssessmentBean assessmentBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String type = request.getParameter("type");
		WriteObject(response, orderService.getOrderAssessments(assessmentBean, type, pageBean), pageBean.getTotal());
	}

	/**
	 * 获得订单评价
	 * 
	 * @param memberBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberAssessments", method = RequestMethod.POST)
	public void getMemberAssessments(MemberBean memberBean, AssessmentBean assessmentBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, orderService.getMemberAssessments(assessmentBean, pageBean), pageBean.getTotal());
	}

	/**
	 * 获得订单评价
	 * 
	 * @param memberBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberAssessmentsV2", method = RequestMethod.POST)
	public void getMemberAssessmentsV2(MemberBean memberBean, AssessmentBean assessmentBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// if (memberService.verificationToken(memberBean) == null) {
		// WritePending(response, "token failed");
		// return;
		// }

		WriteObject(response, orderService.getMemberAssessmentsV2(assessmentBean, pageBean), pageBean.getTotal());
	}
}

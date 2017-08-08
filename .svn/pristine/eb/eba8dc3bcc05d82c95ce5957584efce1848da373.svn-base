package tst.project.webservice.interfaces;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.finance.CashApplyBean;
import tst.project.bean.goods.CardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.PayBean;
import tst.project.bean.order.PingOrderBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.MemberService;
import tst.project.service.interfaces.OrderService;
import tst.project.service.interfaces.ZSSGService;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/zssgInterfaces.api")
public class ZSSGInterfaces extends BaseController{	
	
	@Resource
	MemberService memberService;
	
	@Resource
	ZSSGService zssgService;
	
	@Resource
	OrderService orderService;
	

	/**
	 * 未获得佣金
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getUnDistributions", method = RequestMethod.POST)
	public void getUnDistributions(MemberBean memberBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		MemberBean memberBean2=memberService.verificationTokenZSSG(memberBean);
		if ( memberBean2== null) {
			WritePending(response, "token failed");
			return;
		}
		String type=request.getParameter("type");
		WriteObject(response, zssgService.getUnDistributionsCount(memberBean2, type, pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 申请提现列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getApplyCashs", method = RequestMethod.POST)
	public void getApplyCashs(MemberBean memberBean,CashApplyBean cashApplyBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if (memberService.verificationTokenZSSG(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}		
		WriteObject(response, zssgService.getApplyCashs(cashApplyBean.setMerchants_id(memberBean.getMember_id()+""),pageBean),pageBean.getTotal());
	}
	
	/**
	 * 申请提现
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "applyCash", method = RequestMethod.POST)
	public void applyCash(MemberBean memberBean,CashApplyBean cashApplyBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{		
		if (memberService.verificationTokenZSSG(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		int num=zssgService.applyCash(cashApplyBean.setMerchants_id(memberBean.getMember_id()+"").setCash_type("member"));
		if(num>0){
			WriteMsg(response, "申请成功");
		}else{
			WriteError(response, "申请失败");
		}
	}
	
	
	
	/**
	 * 分销的列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getDistributions", method = RequestMethod.POST)
	public void getDistributions(MemberBean memberBean,DistributionBean distributionBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if (memberService.verificationTokenZSSG(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, zssgService.getDistributionsCount(distributionBean,pageBean),pageBean.getTotal());
	}
	/**
	 * 通过激活码 升级svip
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "svipUpgradeByCard", method = RequestMethod.POST)
	public void svipUpgradeByCard(MemberBean memberBean,CardBean cardBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//try{
//			if (memberService.verificationTokenZSSG(memberBean) == null) {
//				WritePending(response, "token failed");
//				return;
//			}		
			CardBean cardBean2=zssgService.getCardDetail(cardBean);
			if(cardBean2==null){
				WriteError(response, "该卡不存在");
				return;
			}
			if("1".equals(cardBean2.getIs_used())){
				WriteError(response, "该卡已被使用过");
				return;
			}
			
			int num=zssgService.payOrder(cardBean2.setMember_id(cardBean.getMember_id()));
			if(num>0){
				WriteMsg(response, "激活成功");
			}else{
				WriteError(response, "下单失败");
			}
//		}catch(Exception e){
//			WriteError(response, e.getMessage());
//		}
	}
	
	
	/**
	 * 所有商品
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "svipUpgrade", method = RequestMethod.POST)
	public void svipUpgrade(MemberBean memberBean,OrderBean orderBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if (memberService.verificationTokenZSSG(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}		
		
		int num=zssgService.insertOrder(orderBean);
		if(num>0){
			WriteMsg(response, orderBean.getOrder_id()+"");
		}else{
			WriteError(response, "下单失败");
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
		
		MemberBean memberBean2 = memberService.verificationTokenZSSG(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}	
		
		String body = "便宜实惠!";
		OrderBean orderBean2=orderService.getOneOrderDetailZSSG(orderBean);

		Pingpp.apiKey = "sk_live_nXLavLvHO44OOGiLqTn1mTeT";
		Pingpp.privateKeyPath = getClass().getResource("/").getFile().toString() + "/rsa_private_key.pem";
		Map<String, Object> chargeParams = new HashMap<String, Object>();

		String order_pay_no = orderBean2.getOrder_no();

		chargeParams.put("order_no", order_pay_no);
		chargeParams.put("amount", Float.valueOf(orderBean2.getOrder_total_price())*100);// total_price*100
		Map<String, String> app = new HashMap<String, String>();
		app.put("id", "app_5qzfv5OWHK0S8uHu");

		chargeParams.put("app", app);
		chargeParams.put("channel", payBean.getChannel());
		chargeParams.put("currency", "cny");
		chargeParams.put("client_ip", request.getRemoteAddr());
		chargeParams.put("subject", "SVIP");
		chargeParams.put("body", body.substring(0, body.length() > 20 ? 20 : body.length()));

		if (payBean.getChannel().equals("wx_pub")) {
			Map<String, Object> extra = new HashMap<String, Object>();
			extra.put("open_id", memberBean2.getWx_pub_openid());// 用户在商户微信公众号下的唯一标识，获取方式可参考
																	// WxPubOAuthExample.java
			chargeParams.put("extra", extra);
		}
		
		Charge charge = Charge.create(chargeParams);
//		orderService.updateOrderDetail(new OrderBean()
//						 .setOrder_id(orderBean.getOrder_id())
//						 .setOrder_pay_no(charge.getId()));
		WriteObject(response, charge);
	}

	@RequestMapping(params = "payOrder", method = RequestMethod.POST)
	public void payOrder(OrderBean orderBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderBean orderBean2=orderService.getOneOrderDetailZSSG(orderBean);
		
		if(orderBean2==null){
			WriteError(response, "此订单不存在");
			return;
		}
		
		if(!"wait_pay".equals(orderBean2.getOrder_state())){
			WriteError(response, "不是待付款状态");
			return;
		}
		
		int num = zssgService.payOrder(orderBean2);	
		if (num > 0) {
			WriteMsg(response, "支付成功");
		} else {
			WriteError(response, "支付失败");
		}
	}
	
	@RequestMapping(params = "paySuccessOrder", method = RequestMethod.POST)
	public void paySuccessOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String json = readJSONString(request);
		PingOrderBean pingOrderBean = new Gson().fromJson(json, PingOrderBean.class);
		String orderNo = pingOrderBean.getData().getObject().getOrder_no();
		
		OrderBean orderBean2=zssgService.getOrderDetail(new OrderBean().setOrder_no(orderNo));
		if(orderBean2==null){
			WriteError(response, "此订单不存在");
			return;
		}
		if(!"wait_pay".equals(orderBean2.getOrder_state())){
			WriteError(response, "不是待付款状态");
			return;
		}
		
		int num = zssgService.payOrder(orderBean2);	
		if (num > 0) {
			WriteMsg(response, "支付成功");
		} else {
			WriteError(response, "支付失败");
		}
	}
}

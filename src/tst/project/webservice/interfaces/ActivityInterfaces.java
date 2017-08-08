package tst.project.webservice.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.gson.Gson;
import tst.project.bean.activity.ActivityBean;
import tst.project.bean.activity.GroupBuyBean;
import tst.project.bean.activity.GroupBuyGoodsBean;
import tst.project.bean.activity.GroupBuyMemberBean;
import tst.project.bean.activity.PromotionBean;
import tst.project.bean.activity.PromotionGoodsBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.home.OthersBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.ActivityService;
import tst.project.service.interfaces.MemberService;
import tst.project.utils.QRCodeUtils;
import tst.project.utils.TimeUtils;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/activityInterfaces.api")
public class ActivityInterfaces extends BaseController {
	@Resource
	MemberService memberService;

	@Resource
	ActivityService activityService;
	
	/**
	 * 获得其他的一些设置
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "test", method = RequestMethod.POST)
	public void test(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		String qrcode_img=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+"1.png";
		Boolean a=QRCodeUtils.CreateQrcode(request,"/images/qrcode/"+qrcode_img,"12312");
		
		List<String> result=new ArrayList<String>();
		String goods_name="海阳白黄瓜——国家地理标志商品";
		int goods_name_length=goods_name.length();
		for (int i = 0; i < goods_name_length/16; i++) {
			result.add(goods_name.substring(16*i,16*i+16));
		}
		if(goods_name_length%16!=0){
			result.add(goods_name.substring(16*(goods_name_length/16),16*(goods_name_length/16)+goods_name_length%16));
		}
		boolean d=QRCodeUtils.composeQrcodeSSP(request,
				result,"¥"+goodsBean.getGoods_now_price(),"/images/icon/white_backgroup.png",
				goodsBean.getGoods_img(), "/images/icon/fingerprint.png", 
				"/images/qrcode/"+qrcode_img,"/images/qrcode/"+qrcode_img);
		
	}

	/**
	 * 获得其他的一些设置
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getActivityClass", method = RequestMethod.POST)
	public void getActivityClass(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	

		String level=request.getParameter("level");
		WriteObject(response, activityService.getActivityClass(goodsBean,level));
	}
	
	/**
	 * 获得其他的一些设置
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getActivityOthers", method = RequestMethod.POST)
	public void getActivityOthers(MemberBean memberBean,OthersBean othersBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	

		WriteObject(response, activityService.getActivityOthers(othersBean));
	}
	
	/**
	 * 获得活动商品列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getActivityGoods", method = RequestMethod.POST)
	public void getActivityGoods(MemberBean memberBean,GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	

		WriteObject(response, activityService.getActivityGoods(goodsBean,pageBean),pageBean.getTotal());
	}
	
	
	
	
	/**
	 * 获得我的团购信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMyGroupBuys", method = RequestMethod.POST)
	public void getMyGroupBuys(MemberBean memberBean,GroupBuyBean groupBuyBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		String type=request.getParameter("type");
		WriteObject(response, activityService.getMyGroupBuys(groupBuyBean,type));
	}
	
	
	/**
	 * 获得商品的创建团购信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneGroupBuyDetail", method = RequestMethod.POST)
	public void getGoodsGroupDetail(GroupBuyMemberBean groupBuyMemberBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		WriteObject(response, activityService.getOneGroupBuyDetail(groupBuyMemberBean));
	}
	
	
	/**
	 * 获得商品的创建团购信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsGroupBuys", method = RequestMethod.POST)
	public void getGoodsGroupBuys(GroupBuyGoodsBean groupBuyGoodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		WriteObject(response, activityService.getGoodsGroupBuys(groupBuyGoodsBean));
	}
	
	/**
	 * 用户加入团购
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "memberJoinGroupBuy", method = RequestMethod.POST)
	public void memberJoinGroupBuy(MemberBean memberBean, GroupBuyMemberBean groupBuyMemberBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}

			String json = request.getParameter("json");
			OrderMerchantsBean orderMerchantsBean = new Gson().fromJson(json, OrderMerchantsBean.class);

			String order_ids = activityService.memberJoinGroupBuy(groupBuyMemberBean, orderMerchantsBean);

			if (order_ids.equals("-100")) {
				WriteError(response, "来的太慢啦,人数已满了哦");
			} else {
				WriteMsg(response, order_ids);
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage().toString());
		}
	}
	

	/**
	 * 用户创建团购
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "memberInsertGroupBuy", method = RequestMethod.POST)
	public void memberInsertGroupBuy(MemberBean memberBean, GroupBuyMemberBean groupBuyMemberBean,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}
//			GroupBuyMemberBean groupBuyMemberBean2 = activityService.getMemberGroupBuy(groupBuyMemberBean);
//			if (groupBuyMemberBean2 != null) {
//				WriteError(response, "已创建过该团购");
//				return;
//			}
			String json = request.getParameter("json");
			OrderMerchantsBean orderMerchantsBean = new Gson().fromJson(json, OrderMerchantsBean.class);

			String order_ids = activityService.memberInsertGroupBuy(groupBuyMemberBean, orderMerchantsBean, request);
			if (order_ids.equals("-1")) {
				WriteError(response, "申请失败");
			} else if (order_ids.equals("-2")) {
				WriteError(response, "二维码生成失败");
			}else {
				String [] sss=order_ids.split("#");
				GroupBuyMemberBean  groupBuyMemberBean3=new GroupBuyMemberBean();
				groupBuyMemberBean3.setOrder_id(sss[0]);
				groupBuyMemberBean3.setMember_group_buy_id(Integer.valueOf(sss[1]));
				WriteObject(response,groupBuyMemberBean3);
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage().toString());
		}
	}

	/**
	 * 促销活动列表商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getNewPromotionActivity", method = RequestMethod.POST)
	public void getNewPromotionActivity(PromotionBean promotionBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WriteObject(response, activityService.getNewPromotionActivity(promotionBean));
	}
	
	/**
	 * 促销活动列表商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getPromotionActivitys", method = RequestMethod.POST)
	public void getPromotionActivitys(PromotionBean promotionBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WriteObject(response, activityService.getPromotionActivitys(promotionBean));
	}

	/**
	 * 促销商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getPromotionGoodsClass", method = RequestMethod.POST)
	public void getPromotionGoodsClass(PromotionGoodsBean promotionGoodsBean, PageBean pageBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WriteObject(response, activityService.getPromotionGoodsClass(promotionGoodsBean));
	}

	
	/**
	 * 促销商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getPromotionGoodss", method = RequestMethod.POST)
	public void getPromotionGoodss(PromotionGoodsBean promotionGoodsBean, PageBean pageBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WriteObject(response, activityService.getPromotionGoodss(promotionGoodsBean, pageBean),pageBean.getTotal());
	}

}

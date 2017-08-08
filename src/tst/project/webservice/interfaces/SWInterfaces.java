package tst.project.webservice.interfaces;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import tst.project.bean.activity.AlbumBean;
import tst.project.bean.activity.NewsBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.ShoppingCarMemberBean;
import tst.project.bean.goods.ShoppingCarShareBean;
import tst.project.bean.home.HomeGoodsBean;
import tst.project.bean.home.LabelBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.merchants.TrustBean;
import tst.project.bean.merchants.TrustItemBean;
import tst.project.bean.order.OrderSWBean;
import tst.project.bean.others.CodeBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.CodeService;
import tst.project.service.interfaces.GoodsServiceI;
import tst.project.service.interfaces.MemberService;
import tst.project.service.interfaces.SWService;
import tst.project.utils.TimeUtils;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/swInterfaces.api")
public class SWInterfaces extends BaseController{
	@Resource
	SWService swService;

	@Resource
	MemberService memberService;
	
	@Resource
	CodeService codeService;

	@Resource
	GoodsServiceI goodsServiceI;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getShoppingCarWithShare", method = RequestMethod.POST)
	public void getShoppingCarWithShare(MemberBean memberBean,ShoppingCarMemberBean shoppingCarMemberBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try{
			MemberBean memberBean2=memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}
			
			WriteObject(response, swService.getShoppingCarWithShare(shoppingCarMemberBean));
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	
	/**
	 * 修改分享出去的购物车数量
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateShareShoppingCarNumV2", method = RequestMethod.POST)
	public void updateShareShoppingCarNumV2(MemberBean memberBean,ShoppingCarShareBean shoppingCarShareBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try{
			MemberBean memberBean2=memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}
			
			int num=swService.updateShareShoppingCarNumV2(shoppingCarShareBean);
			if(num>0){
				WriteMsg(response, "更新成功");
			}else{
				WriteError(response, "更新失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 修改分享出去的购物车数量
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateShareShoppingCarNum", method = RequestMethod.POST)
	public void updateShareShoppingCarNum(MemberBean memberBean,ShoppingCarShareBean shoppingCarShareBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try{
			MemberBean memberBean2=memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}
			
			int num=swService.updateShareShoppingCarNum(shoppingCarShareBean);
			if(num>0){
				WriteMsg(response, "更新成功");
			}else{
				WriteError(response, "更新失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	

	/**
	 * 删除分享出去的购物车
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteShareShoppingCar", method = RequestMethod.POST)
	public void deleteShareShoppingCar(MemberBean memberBean,ShoppingCarShareBean shoppingCarShareBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try{
			MemberBean memberBean2=memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}
			
			int num=swService.deleteShareShoppingCar(shoppingCarShareBean);
			if(num>0){
				WriteMsg(response, "删除成功");
			}else{
				WriteError(response, "删除失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 获得被分享进来的购物车列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getShareOutShoppingCar", method = RequestMethod.POST)
	public void getShareOutShoppingCar(MemberBean memberBean,ShoppingCarMemberBean shoppingCarMemberBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try{
			MemberBean memberBean2=memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}
			
			WriteObject(response, swService.getShareOutShoppingCar(shoppingCarMemberBean,pageBean),pageBean.getTotal());
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 获得分享出去的购物车列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getShareIngShoppingCar", method = RequestMethod.POST)
	public void getShareShoppingCar(MemberBean memberBean,ShoppingCarMemberBean shoppingCarMemberBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try{
			MemberBean memberBean2=memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}
			
			WriteObject(response, swService.getShareIngShoppingCar(shoppingCarMemberBean,pageBean),pageBean.getTotal());
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 共享购物车
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "shareShoppingCar", method = RequestMethod.POST)
	public void shareShoppingCar(MemberBean memberBean,ShoppingCarMemberBean shoppingCarMemberBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try{
			MemberBean memberBean2=memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}
			
			MemberBean memberBean3=memberService.getMemberByMobile(memberBean);
			if(memberBean3==null){
				WriteError(response, "分享人不存在！");
				return;
			}
			
			String car_ids=request.getParameter("car_ids");
			if(car_ids==null||"".equals(car_ids)){
				WriteError(response, "未选择任何购物车！");
				return;
			}
			
			int num=swService.shareShoppingCar(shoppingCarMemberBean.setUser_id(memberBean3.getMember_id()+""),car_ids);
			if(num>0){
				WriteMsg(response, "分享成功");
			}else{
				WriteError(response, "分享失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	
	
	/**
	 * 申请信用额度（最新）
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getLastTrust", method = RequestMethod.POST)
	public void getLastTrust(MemberBean memberBean,TrustBean trustBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		MemberBean memberBean2=memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, swService.getLastTrust(trustBean));
	}
	
	
	/**
	 * 申请信用额度
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneTrust", method = RequestMethod.POST)
	public void getOneTrust(MemberBean memberBean,TrustBean trustBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		MemberBean memberBean2=memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, swService.getOneTrust(trustBean));
	}
	
	/**
	 * 申请信用额度
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getTrust", method = RequestMethod.POST)
	public void getTrust(MemberBean memberBean,TrustBean trustBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		MemberBean memberBean2=memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, swService.getTrust(trustBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 申请信用额度
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "applyTrust", method = RequestMethod.POST)
	public void applyTrust(MemberBean memberBean,TrustBean trustBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		MemberBean memberBean2=memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}
		
		String json=request.getParameter("json");
		List<TrustItemBean> trustItemBeans=new Gson().fromJson(json, new TypeToken<List<TrustItemBean>>() {}.getType());
		
		int num=swService.applyTrust(trustBean,trustItemBeans);
		if(num>0){
			WriteMsg(response, "申请成功");
		}else{
			WriteError(response, "申请失败");
		}
	}
	
	
	/**
	 * 企业购分类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBusinessBuyClass", method = RequestMethod.POST)
	public void getBusinessBuyClass(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String level=request.getParameter("level");
		WriteObject(response, swService.getBusinessBuyClass(goodsBean,level));
	}
	
	@RequestMapping(params = "getBusinessBuyClasss", method = RequestMethod.POST)
	public void getBusinessBuyClasss(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, swService.getBusinessBuyClass(goodsBean));
	}
	
	
	/**
	 * 抢单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "grabOrderSW", method = RequestMethod.POST)
	public void grabOrderSW(MemberBean memberBean,OrderSWBean orderSWBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}		
		
		OrderSWBean orderSWBean2=swService.getOrderSwById(orderSWBean);
		if(orderSWBean2==null){
			WriteError(response, "此订单不存在");
			return;
		}else if(orderSWBean2.getOrder_state().equals("cancel")){
			WriteError(response, "手速太慢了哦!已被取消");
			return;
		}else if(orderSWBean2.getOrder_state().equals("end")){
			WriteError(response, "手速太慢了哦!已被人抢");
			return;
		}
		int num=swService.grabOrderSW(orderSWBean);
		if(num>0){
			WriteMsg(response, "抢单成功");
		}else{
			WriteMsg(response, "抢单失败");
		}
	}
	
	
	/**
	 * 我的抢单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberGrabOrderSWs", method = RequestMethod.POST)
	public void getMemberGrabOrderSWs(MemberBean memberBean,OrderSWBean orderSWBean,
			PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}		
		
		WriteObject(response, swService.getMemberGrabOrderSWs(orderSWBean,pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 删除订单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteOrderSW", method = RequestMethod.POST)
	public void deleteOrderSW(MemberBean memberBean,OrderSWBean orderSWBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}		
		
		int num=swService.deleteOrderSW(orderSWBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteMsg(response, "删除失败");
		}
	}
	
	/**
	 * 取消订单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "cancelOrderSW", method = RequestMethod.POST)
	public void cancelOrderSW(MemberBean memberBean,OrderSWBean orderSWBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}		
		
		OrderSWBean orderSWBean2=swService.getOrderSW(orderSWBean);
		if(orderSWBean2==null){
			WriteError(response, "订单不存在!");
			return;
		}
		if(!"wait_grab".equals(orderSWBean2.getOrder_state())){
			WriteError(response, "此订单状态不可取消!");
			return;
		}
		
		
		int num=swService.cancelOrderSW(orderSWBean);
		if(num>0){
			WriteMsg(response, "取消成功");
		}else{
			WriteMsg(response, "取消失败");
		}
	}
	
	/**
	 * 我的发单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberOrderSWs", method = RequestMethod.POST)
	public void getMemberOrderSWs(MemberBean memberBean,OrderSWBean orderSWBean,
			PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}		
		
		WriteObject(response, swService.getMemberOrderSWs(orderSWBean,pageBean),pageBean.getTotal());;
	}
	
	/**
	 * 发单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertOrderSW", method = RequestMethod.POST)
	public void insertOrderSW(MemberBean memberBean,OrderSWBean orderSWBean,CodeBean codeBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}		
		
		if(codeService.getCodeBeanByMobileAndCode(codeBean.setMobile(orderSWBean.getMember_mobile())
				.setCode_type("send_order").setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss")))==null){
			WriteError(response, "此验证码已过期");
			return;
		}
		
		int num=swService.insertOrderSW(orderSWBean,codeBean);
		if(num>0){
			WriteMsg(response, "发单成功");
		}else{
			WriteMsg(response, "发单失败");
		}
	}
	
	
	/**
	 * 生物网站首页
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeClassWeb", method = RequestMethod.POST)
	public void getHomeClassWeb(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String level=request.getParameter("level");
		if("1".equals(level)){
			WriteObject(response, swService.getHomeClassWeb1(goodsBean));		
		}else{
			WriteObject(response, swService.getHomeClassWeb2(goodsBean));		
		}
	}
	
	
	
	/**
	 * 团购商品列表(只是标签)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGroupGoodss", method = RequestMethod.POST)
	public void getGroupGoodss(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, swService.getGroupGoodss(goodsBean,pageBean),pageBean.getTotal());		
	}
	
	
	/**
	 * 店铺专辑列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAlbums", method = RequestMethod.POST)
	public void getAlbums(AlbumBean albumBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, swService.getAlbums(albumBean,pageBean));		
	}
	
	/**
	 * 用户关闭动态头条
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "memberCloseDynamicHeadlines", method = RequestMethod.POST)
	public void memberCloseDynamicHeadlines(MemberBean memberBean,MerchantsBean merchantsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(memberService.verificationToken(memberBean)==null){
			WritePending(response, "token failed");
			return;
		}
		
		MerchantsBean merchantsBean2=swService.getOneMemberDynamicHeadlines(merchantsBean);
		if(merchantsBean2!=null){
			WriteError(response, "已关闭");
			return;
		}
		
		int num=swService.memberCloseDynamicHeadlines(merchantsBean);
		if(num>0){
			WriteMsg(response, "成功关闭");
		}else{
			WriteError(response, "关闭失败");
		}
	}
	
	/**
	 * 店铺头条
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHeadlinesMerchants", method = RequestMethod.POST)
	public void getHeadlinesMerchants(MerchantsBean merchantsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String type=request.getParameter("type");
		if("hot".equals(type)){
			WriteObject(response, swService.getHotHeadlinesMerchants(merchantsBean,pageBean),pageBean.getTotal());			
		}else if("dynamic".equals(type)){
			WriteObject(response, swService.getDynamicHeadlinesMerchants(merchantsBean,pageBean),pageBean.getTotal());
		}
	}
	
	
	/**
	 * 发现好货
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodGoodss", method = RequestMethod.POST)
	public void getGoodGoodss(GoodsBean goodsBean,AlbumBean albumBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String type=request.getParameter("type");
		if("exact".equals(type)){
			WriteObject(response, swService.getExactGoodGoodss(goodsBean,pageBean),pageBean.getTotal());			
		}else if("album".equals(type)){
			WriteObject(response, swService.getAlbumGoodGoodss(goodsBean,pageBean),pageBean.getTotal());
		}
	}
	
	
	/**
	 * 首页推荐商品列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeGoods", method = RequestMethod.POST)
	public void getHomeGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(goodsBean.getGoods_id()!=0){
			GoodsBean goodsBean2=goodsServiceI.getOneGoodsDetail(goodsBean);
			goodsBean.setParent_id(goodsBean2.getParent_id());
		}
		WriteObject(response, swService.getHomeGoods(goodsBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 首页分类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeLabels", method = RequestMethod.POST)
	public void getHomeLabels(LabelBean labelBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, swService.getHomeLabels(labelBean));
	}
	
	/**
	 * 波尔快报的分类列表
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getNewsClass", method = RequestMethod.POST)
	public void getNewsClass(NewsBean newsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, swService.getNewsClass(newsBean));
	}
	
	/**
	 * 波尔快报的分类下商品列表
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getNewsGoods", method = RequestMethod.POST)
	public void getNewsGoods(NewsBean newsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, swService.getNewsGoods(newsBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 波尔快报的精选商品列表
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getNewsRecommendGoods", method = RequestMethod.POST)
	public void getNewsRecommendGoods(NewsBean newsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, swService.getNewsRecommendGoods(newsBean));
	}
	
	/**
	 * 波尔快报的精选商品列表
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getNewsExactGoods", method = RequestMethod.POST)
	public void getNewsExactGoods(NewsBean newsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, swService.getNewsExactGoods(newsBean,pageBean),pageBean.getTotal());
	}
}

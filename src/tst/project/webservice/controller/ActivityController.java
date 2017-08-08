package tst.project.webservice.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import tst.project.bean.activity.ExemptBean;
import tst.project.bean.activity.GiftBean;
import tst.project.bean.activity.GiveBean;
import tst.project.bean.activity.HalfBean;
import tst.project.bean.activity.PromotionBean;
import tst.project.bean.activity.PromotionGoodsBean;
import tst.project.bean.activity.ReduceBean;
import tst.project.bean.home.ActivityBean;
import tst.project.bean.home.HomeGoodsBean;
import tst.project.bean.home.LabelBean;
import tst.project.bean.home.OthersBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.page.PageBean;
import tst.project.service.controller.ActivityServiceC;
import tst.project.service.controller.SystemService;

@Controller
@RequestMapping("/activityController.api")
public class ActivityController extends BaseController{
	@Resource
	ActivityServiceC activityServiceC;
	
	@Resource
	SystemService systemService;
	
	/**
	 * 上传限时促销图片
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadHomeOthersImg")
	public void uploadHomeOthersImg(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/home/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
		}else{
			int num=activityServiceC.updateHomeOthers(new OthersBean().setOthers_img(json)
					.setOthers_type("time_limit"));
			if(num>0){
				WriteMsg(response, json);				
			}else{
				WriteError(response, "更新失败");
			}
		}
	}	
	
	
	/**
	 * 获得其他配置
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getActivityOthers", method = RequestMethod.POST)
	public void getActivityOthers(MerchantsAccountBean merchantsAccountBean,OthersBean othersBean,
			HttpServletRequest request,HttpServletResponse response) {	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			WriteObject(response, activityServiceC.getActivityOthers(othersBean));
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}

	/**
	 * 删除活动详情
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteActivityDetail", method = RequestMethod.POST)
	public void deleteActivityDetail(MerchantsAccountBean merchantsAccountBean,tst.project.bean.activity.ActivityBean activityBean,
			GiveBean giveBean,ReduceBean reduceBean,GiftBean giftBean,HttpServletRequest request,HttpServletResponse response) {	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			int num=activityServiceC.deleteActivityDetail(activityBean);
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
	 * 添加活动详情
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertActivityDetail", method = RequestMethod.POST)
	public void insertActivityDetail(MerchantsAccountBean merchantsAccountBean,tst.project.bean.activity.ActivityBean activityBean,
			GiveBean giveBean,ReduceBean reduceBean,GiftBean giftBean,HalfBean halfBean,ExemptBean exemptBean,HttpServletRequest request,HttpServletResponse response) throws Exception  {	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			int num=activityServiceC.insertActivityDetail(activityBean,giveBean,reduceBean,giftBean,halfBean,exemptBean);
			if(num>0){
				WriteMsg(response, "添加成功");
			}else{
				WriteError(response, "添加失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 修改活动详情
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateActivityDetail", method = RequestMethod.POST)
	public void updateActivityDetail(MerchantsAccountBean merchantsAccountBean,tst.project.bean.activity.ActivityBean activityBean,
			GiveBean giveBean,ReduceBean reduceBean,GiftBean giftBean,HalfBean halfBean,ExemptBean exemptBean,HttpServletRequest request,HttpServletResponse response) throws Exception  {	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			int num=activityServiceC.updateActivityDetail(activityBean,giveBean,reduceBean,giftBean,halfBean,exemptBean);
			if(num>0){
				WriteMsg(response, "修改成功");
			}else{
				WriteError(response, "修改失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	/**
	 * 获得活动商品列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getActivityGoods", method = RequestMethod.POST)
	public void getActivityGoods(MerchantsAccountBean merchantsAccountBean,tst.project.bean.activity.ActivityBean activityBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	

		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, activityServiceC.getActivityGoods(activityBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 获得活动商品列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteAllActivityGoods", method = RequestMethod.POST)
	public void deleteAllActivityGoods(MerchantsAccountBean merchantsAccountBean,tst.project.bean.activity.ActivityBean activityBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	

		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		System.out.print(new Gson().toJson(activityBean));
		
		int num=activityServiceC.deleteAllActivityGoods(activityBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	/** 
	 * 添加活动商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertAllActivityGoods", method = RequestMethod.POST)
	public void insertAllActivityGoods(MerchantsAccountBean merchantsAccountBean,
			tst.project.bean.activity.ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=activityServiceC.insertAllActivityGoods(activityBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	/** 
	 * 添加活动商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertActivityGoods", method = RequestMethod.POST)
	public void insertActivityGoods(MerchantsAccountBean merchantsAccountBean,
			tst.project.bean.activity.ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		tst.project.bean.activity.ActivityBean activityBean2=activityServiceC.getActivityGoodsByActivity(activityBean);
		if(activityBean2!=null){
			WriteError(response, "该商品已添加过");
			return;
		}
				
//		List<tst.project.bean.activity.ActivityBean> activityBeans=activityServiceC.getActivityGoodsByGoods(activityBean);
//		boolean is_true=false;//是否参加过别的活动
//		
//		if(activityBeans!=null){
//			for (int i = 0; i < activityBeans.size(); i++) {
//				if(!activityBean.getActivity_type().equals(activityBeans.get(i).getActivity_type())){
//					is_true=true;
//				}
//			}	
//		}
//		
//		if(is_true){
//			WriteError(response, "该商品已参加过别的活动");
//			return;
//		}
			
		int num=activityServiceC.insertActivityGoods(activityBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/** 
	 * 删除活动商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteActivityGoods", method = RequestMethod.POST)
	public void deleteActivityGoods(MerchantsAccountBean merchantsAccountBean,
			tst.project.bean.activity.ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=activityServiceC.deleteActivityGoods(activityBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	/** 
	 * 活动详情
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getActivityDetail", method = RequestMethod.POST)
	public void getActivityDetail(MerchantsAccountBean merchantsAccountBean,
			tst.project.bean.activity.ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, activityServiceC.getActivityDetail(activityBean));
	}
	
	/** 
	 * 获得所有的活动 不分页
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getActivitysNoPage", method = RequestMethod.POST)
	public void getActivitysNoPage(MerchantsAccountBean merchantsAccountBean,
			tst.project.bean.activity.ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, activityServiceC.getActivitysNoPage(activityBean));
	}
	
	/** 
	 * 获得所有的活动 分页
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getActivitys", method = RequestMethod.POST)
	public void getActivitys(MerchantsAccountBean merchantsAccountBean,
			tst.project.bean.activity.ActivityBean activityBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, activityServiceC.getActivitys(activityBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 删除首页商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteHomeGoods", method = RequestMethod.POST)
	public void deleteHomeGoods(MerchantsAccountBean merchantsAccountBean,
			HomeGoodsBean homeGoodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=activityServiceC.deleteHomeGoods(homeGoodsBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	/**
	 * 添加首页商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertHomeGoods", method = RequestMethod.POST)
	public void insertHomeGoods(MerchantsAccountBean merchantsAccountBean,
			HomeGoodsBean homeGoodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=activityServiceC.insertHomeGoods(homeGoodsBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 修改首页商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateHomeGoods", method = RequestMethod.POST)
	public void updateHomeGoods(MerchantsAccountBean merchantsAccountBean,
			HomeGoodsBean homeGoodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=activityServiceC.updateHomeGoods(homeGoodsBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	
	/**
	 * 获得首页商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeGoods", method = RequestMethod.POST)
	public void getHomeGoods(MerchantsAccountBean merchantsAccountBean,
			HomeGoodsBean homeGoodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, activityServiceC.getHomeGoods(homeGoodsBean));
	}
	
	
	
	/**
	 * 添加首页活动
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertHomeActivity", method = RequestMethod.POST)
	public void insertHomeActivity(MerchantsAccountBean merchantsAccountBean,
			ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=activityServiceC.insertHomeActivity(activityBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	
	/**
	 * 上传商品图片
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadHomeActivityImg")
	public void uploadHomeActivityImg(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/home/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
		}else{
			WriteMsg(response, json);
		}
	}	
	/**
	 * 删除首页活动
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteHomeActivity", method = RequestMethod.POST)
	public void deleteHomeActivity(MerchantsAccountBean merchantsAccountBean,
			ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		int num=activityServiceC.deleteHomeActivity(activityBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
		
	}
	
	/**
	 * 修改首页活动
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateHomeActivity", method = RequestMethod.POST)
	public void updateHomeActivity(MerchantsAccountBean merchantsAccountBean,
			ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		int num=activityServiceC.updateHomeActivity(activityBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
		
	}
	
	/**
	 * 首页活动管理
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeActivitys", method = RequestMethod.POST)
	public void getHomeActivitys(MerchantsAccountBean merchantsAccountBean,
			ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, activityServiceC.getHomeActivitys(activityBean));
	}
	
	
	
	
	
	/**
	 * 修改首页标签
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateHomeLabel", method = RequestMethod.POST)
	public void updateHomeLabel(MerchantsAccountBean merchantsAccountBean,
			LabelBean labelBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, activityServiceC.updateHomeLabel(labelBean));
	}
	
	
	/**
	 * 上传商品图片
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadHomeLabelImg")
	public void uploadGoodsImg(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/home/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
		}else{
			WriteMsg(response, json);
		}
	}	
	
	/**
	 * 首页标签管理
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeLabels", method = RequestMethod.POST)
	public void getHomeLabels(MerchantsAccountBean merchantsAccountBean,
			LabelBean labelBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, activityServiceC.getHomeLabels(labelBean));
	}
	
	
	/**
	 * 添加限时促销的活动的商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertAllPromotionGoods", method = RequestMethod.POST)
	public void insertAllPromotionGoods(MerchantsAccountBean merchantsAccountBean,
			PromotionGoodsBean promotionGoodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=activityServiceC.insertAllPromotionGoods(promotionGoodsBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 添加限时促销的活动的商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertPromotionGoods", method = RequestMethod.POST)
	public void insertPromotionGoods(MerchantsAccountBean merchantsAccountBean,
			PromotionGoodsBean promotionGoodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=activityServiceC.insertPromotionGoods(promotionGoodsBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 添加限时促销的活动的商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updatePromotionGoods", method = RequestMethod.POST)
	public void updatePromotionGoods(MerchantsAccountBean merchantsAccountBean,
			PromotionGoodsBean promotionGoodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		PromotionGoodsBean promotionGoodsBean2=activityServiceC.getPromotionGoodssByGoodsId(promotionGoodsBean);
		if(promotionGoodsBean2!=null){
			WriteError(response, "该商品已参加这次活动");
			return;
		}
		
		int num=activityServiceC.updatePromotionGoods(promotionGoodsBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 添加限时促销的活动的商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deletePromotionGoods", method = RequestMethod.POST)
	public void deletePromotionGoods(MerchantsAccountBean merchantsAccountBean,
			PromotionGoodsBean promotionGoodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=activityServiceC.deletePromotionGoods(promotionGoodsBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	/**
	 * 获得所有限时促销的活动的商品列表
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getPromotionGoodss", method = RequestMethod.POST)
	public void getPromotionGoodss(MerchantsAccountBean merchantsAccountBean,
			PromotionGoodsBean promotionGoodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, activityServiceC.getPromotionGoodss(promotionGoodsBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 获得所有限时促销的活动列表
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getPromotions", method = RequestMethod.POST)
	public void getPromotions(MerchantsAccountBean merchantsAccountBean,PromotionBean promotionBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, activityServiceC.getPromotions(promotionBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 上传促销广告图片
	 * @param merchantsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadPromotionImg")
	public void uploadPromotionImg(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/promotion/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
		}else{
			WriteMsg(response, json);
		}
	}
	
	/**
	 * 添加促销活动
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertPromotion", method = RequestMethod.POST)
	public void insertPromotion(MerchantsAccountBean merchantsAccountBean,PromotionBean promotionBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		int num=activityServiceC.insertPromotion(promotionBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	
	/**
	 * 修改促销活动
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updatePromotion", method = RequestMethod.POST)
	public void updatePromotion(MerchantsAccountBean merchantsAccountBean,PromotionBean promotionBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		int num=activityServiceC.updatePromotion(promotionBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	
	/**
	 * 删除促销活动
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deletePromotion", method = RequestMethod.POST)
	public void deletePromotion(MerchantsAccountBean merchantsAccountBean,PromotionBean promotionBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		int num=activityServiceC.deletePromotion(promotionBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
}

package tst.project.webservice.interfaces;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tst.project.bean.activity.ActivityBean;
import tst.project.bean.address.LocationBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.home.OthersBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.merchants.MerchantsLabelBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.RankingService;
import tst.project.webservice.controller.BaseController;

/**
 * 各种排行榜
 * @author shenjiabo
 *
 */
@Controller
@RequestMapping("/rankingInterfaces.api")
public class RankingInterfaces extends BaseController{
	@Resource
	RankingService rankingService;
	
	/**
	 * 热门活动榜
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHotActivitys", method = RequestMethod.POST)
	public void getHotActivitys(MemberBean memberBean,ActivityBean activityBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	

		WriteObject(response, rankingService.getHotActivitys(activityBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 人气店铺(按销量排行)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSalesMerchantsRanking", method = RequestMethod.POST)
	public void getSalesMerchantsRanking(MerchantsBean merchantsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, rankingService.getSalesMerchantsRanking(merchantsBean,pageBean),pageBean.getTotal());		
	}
	
	/**
	 * 人气店铺(按销量排行)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSalesMerchantsRankingLabel", method = RequestMethod.POST)
	public void getSalesMerchantsRankingLabel(MerchantsLabelBean merchantsLabelBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, rankingService.getSalesMerchantsRankingLabel(merchantsLabelBean));		
	}
	
	
	/**
	 * 折扣榜
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getDiscountRanking", method = RequestMethod.POST)
	public void getDiscountRanking(GoodsBean goodsBean,LocationBean locationBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, rankingService.getDiscountRanking(goodsBean,locationBean,pageBean),pageBean.getTotal());		
	}
	
	/**
	 * 折扣榜
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getDiscountRankingClass", method = RequestMethod.POST)
	public void getDiscountRankingClass(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, rankingService.getDiscountRankingClass(goodsBean));		
	}
	/**
	 * 热卖榜
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSalesRanking", method = RequestMethod.POST)
	public void getSalesRanking(GoodsBean goodsBean,LocationBean locationBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, rankingService.getSalesRanking(goodsBean,locationBean,pageBean),pageBean.getTotal());		
	}
	
	/**
	 * 热卖榜--商品分类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSalesRankingClass", method = RequestMethod.POST)
	public void getSalesRankingClass(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, rankingService.getSalesRankingClass(goodsBean));		
	}
	
	/**
	 * 降价榜---商品分类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getPriceCutsRankingClass", method = RequestMethod.POST)
	public void getPriceCutsRankingClass(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, rankingService.getPriceCutsRankingClass(goodsBean));		
	}
	
	/**
	 * 降价榜
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getPriceCutsRanking", method = RequestMethod.POST)
	public void getPriceCutsRanking(GoodsBean goodsBean,LocationBean locationBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, rankingService.getPriceCutsRanking(goodsBean,locationBean,pageBean),pageBean.getTotal());		
	}
	
	/**
	 * 降价榜
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getPriceCutsPCRanking", method = RequestMethod.POST)
	public void getPriceCutsPCRanking(GoodsBean goodsBean,LocationBean locationBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, rankingService.getPriceCutsPCRanking(goodsBean,locationBean,pageBean),pageBean.getTotal());		
	}
}

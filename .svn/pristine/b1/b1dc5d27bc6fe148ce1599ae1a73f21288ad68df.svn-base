package tst.project.webservice.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import tst.project.bean.activity.ActivityBean;
import tst.project.bean.address.LocationBean;
import tst.project.bean.goods.BrandBean;
import tst.project.bean.goods.BrandPackageBean;
import tst.project.bean.goods.BrandPackageGoodsBean;
import tst.project.bean.goods.FilterBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsLabelBean;
import tst.project.bean.goods.StoreHouseBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.others.HtmlStyleBean;
import tst.project.bean.others.SearchBean;
import tst.project.page.PageBean;
import tst.project.service.controller.MemberServiceC;
import tst.project.service.interfaces.GoodsServiceI;
import tst.project.service.interfaces.MemberService;
import tst.project.service.interfaces.OthersService;
import tst.project.utils.TimeUtils;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/goodsInterfaces.api")
public class GoodsInterfaces extends BaseController{
	@Resource
	GoodsServiceI goodsServiceI;
	
	@Resource
	MemberService memberService;
	
	@Resource
	OthersService othersService;
	
	
	/**
	 * 获得搜热列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHotSearchs", method = RequestMethod.POST)
	public void getHotSearchs(SearchBean searchBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getHotSearchs(searchBean,pageBean));
	}
	
	
	
	/**
	 * 首页设置(服装)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeActivitys", method = RequestMethod.POST)
	public void getHomeActivitys(tst.project.bean.home.ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getHomeActivitys(activityBean));
	}
	
	
	/**
	 * 预售商品列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getPreSaleGoodss", method = RequestMethod.POST)
	public void getPreSaleGoodss(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getPreSaleGoodss(goodsBean,pageBean));
	}
	
	/**
	 * 畅销商品(真正的按销量排名)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSellingGoodsReal", method = RequestMethod.POST)
	public void getSellingGoodsReal(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getSellingGoodsReal(goodsBean.setGoods_type("1"),pageBean));
	}
	
	/**
	 * 根据父id获得所有商品分类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneGoodsClassParentNo", method = RequestMethod.POST)
	public void getOneGoodsClassParentNo(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getOneGoodsClassParentNo(goodsBean.setGoods_type("1")));
	}
	
	/**
	 * 根据父id获得所有商品分类  根据level来判断取几级分类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsClassLevel", method = RequestMethod.POST)
	public void getGoodsClassLevel(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String level=request.getParameter("level");
		WriteObject(response, goodsServiceI.getGoodsClassLevel(goodsBean.setGoods_type("1"),
				level==null?1:Integer.valueOf(level)));
	}
	/**
	 * 根据父id获得所有商品分类  根据level来判断取几级分类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsClassLevelV2", method = RequestMethod.POST)
	public void getGoodsClassLevelV2(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String level=request.getParameter("level");
		WriteObject(response, goodsServiceI.getGoodsClassLevelV2(goodsBean.setGoods_type("1"),level==null?1:Integer.valueOf(level)));
	}
	
	/**
	 * 大众交易区所有商品分类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsClassOrder", method = RequestMethod.POST)
	public void getGoodsClassOrder(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		List<GoodsBean> goodsBeans=goodsServiceI.getGoodsClassOrder(new GoodsBean().setParent_id("-1").setGoods_type("1"));
		WriteObject(response,goodsBeans);
	}
	 
	

	/**
	 * 获得该分类下的活动列表
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getFilterByClass", method = RequestMethod.POST)
	public void getFilterByClass(FilterBean filterBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		List<FilterBean> filterBeans=new ArrayList<FilterBean>();
		
		List<StoreHouseBean> storeHouseBeans=goodsServiceI.getAllStoreHouseByClass(goodsBean);
		if(storeHouseBeans!=null&&storeHouseBeans.size()>0){
			FilterBean filterBean2=new FilterBean();
			filterBean2.setName("发货地");
			filterBean2.setType("storehouse");
			filterBean2.setStoreHouseBeans(storeHouseBeans);
			filterBeans.add(filterBean2);
		}
			
		List<GoodsLabelBean> goodsLabelBeans=goodsServiceI.getAllGoodsLabelByClass(goodsBean);
		if(goodsLabelBeans!=null&&goodsLabelBeans.size()>0){
			FilterBean filterBean2=new FilterBean();
			filterBean2.setName("服务");
			filterBean2.setType("service");
			filterBean2.setGoodsLabelBeans(goodsLabelBeans);
			filterBeans.add(filterBean2);
		}
		
		List<BrandBean> brandBeans=goodsServiceI.getAllBrandByClass(goodsBean);
		if(brandBeans!=null&&brandBeans.size()>0){
			FilterBean filterBean2=new FilterBean();
			filterBean2.setName("品牌");
			filterBean2.setType("brand");
			filterBean2.setBrandBeans(brandBeans);
			filterBeans.add(filterBean2);
		}
		
		List<ActivityBean> activityBeans=goodsServiceI.getActivityByClass(goodsBean);
		if(activityBeans!=null&&activityBeans.size()>0){
			FilterBean filterBean2=new FilterBean();
			filterBean2.setName("活动");
			filterBean2.setType("activity");
			filterBean2.setActivityBeans(activityBeans);
			filterBeans.add(filterBean2);
		}
		
		
		WriteObject(response, filterBeans);
	}
	
	/**
	 * 获得该分类下的发货地列表
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllStoreHouseByClass", method = RequestMethod.POST)
	public void getAllStoreHouseByClass(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, goodsServiceI.getAllStoreHouseByClass(goodsBean));
	}
	
	/**
	 * 获得该分类下的标签列表
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllGoodsLabelByClass", method = RequestMethod.POST)
	public void getAllGoodsLabelByClass(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, goodsServiceI.getAllGoodsLabelByClass(goodsBean));
	}
	
	/**
	 * 获得该分类下的活动列表
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getActivityByClass", method = RequestMethod.POST)
	public void getActivityByClass(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, goodsServiceI.getActivityByClass(goodsBean));
	}
	
	
	/**
	 * 获得该品牌下分类列表
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getClassByBrand", method = RequestMethod.POST)
	public void getClassByBrand(GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String level=request.getParameter("level");
		WriteObject(response, goodsServiceI.getClassByBrand(goodsBean,level));
	}
	
	
	/**
	 * 获得该分类下的品牌列表
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllBrandByClass", method = RequestMethod.POST)
	public void getAllBrandByClass(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, goodsServiceI.getAllBrandByClass(goodsBean));
	}

	/**
	 * 根据各种条件 搜索商品列表
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "searchGoodsDetailList", method = RequestMethod.POST)
	public void searchGoodsDetailList(GoodsBean goodsBean,LocationBean locationBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		System.out.println(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss")+"---------------------------------");
		if(goodsBean.getGoods_name()!=null&&!"".equals(goodsBean.getGoods_name())){
			SearchBean searchBean=goodsServiceI.getHotSearch(new SearchBean()
					.setSearch_name(goodsBean.getGoods_name())
					.setSearch_type("goods"));
			if(searchBean!=null){
				goodsServiceI.updateHotSearch(searchBean);
			}else{
				goodsServiceI.inserHotSearch(new SearchBean()
						.setSearch_name(goodsBean.getGoods_name())
						.setSearch_type("goods")
						.setIs_fixed("0")
						.setSearch_count("1"));
			}
		}
		WriteObject(response, goodsServiceI.searchGoodsDetailList(goodsBean,locationBean,pageBean),pageBean.getTotal());
		System.out.println(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss")+"---------------------------------");
	}
	
	/**
	 * 获得商品详情
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneGoodsDetail", method = RequestMethod.POST)
	public void getOneGoodsDetail(GoodsBean goodsBean,MemberBean memberBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(memberBean.getBusiness_id()!=null&&!memberBean.getBusiness_id().equals("-1")){
			MemberBean memberBean2=memberService.getMemberByID(memberBean);
			if(memberBean2!=null){
				if(memberBean2.getBusiness_id()==null||memberBean2.getBusiness_id().equals("-1")){
					int num=memberService.updateMemberBusiness(memberBean);
					if(num<=0){
						WriteError(response, "查询失败");
						return;
					}
				}
			}
		}
		
		goodsServiceI.updateGoodsDetailSeenum(goodsBean);
		
		GoodsBean goodsBean1=goodsServiceI.getOneGoodsDetail(goodsBean);
		String desc=readHtml(request, goodsBean1.getGoods_url());
		
		int start=desc.indexOf("<tst>");
		int end=desc.indexOf("</tst>");
		
		if(start>0&&end>0){
			desc=desc.substring(start+5,end);
		}
		WriteObject(response,goodsBean1.setGoods_url_content(desc));
	}
	
	/**
	 * 获得品牌套餐
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBrandPackageByBrand", method = RequestMethod.POST)
	public void getBrandPackageByBrand(BrandPackageBean brandPackageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, goodsServiceI.getBrandPackageByBrand(brandPackageBean));	
	}
	/**
	 * 获得品牌详情
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBrandDetail", method = RequestMethod.POST)
	public void getBrandDetail(BrandBean brandBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		BrandBean brandBean1=goodsServiceI.getBrandDetail(brandBean);
		if(brandBean1!=null){
			String desc=readHtml(request, brandBean1.getBrand_url());
			WriteObject(response, brandBean1.setBrand_url_content(desc));		
		}else{
			WriteObject(response, brandBean1);
		}
		
	}
	/**
	 * 获得品牌套餐详情
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBrandPackageGoodsDetail", method = RequestMethod.POST)
	public void getBrandPackageGoodsDetail(BrandPackageBean brandPackageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, goodsServiceI.getBrandPackageGoodsDetail(brandPackageBean));	
	}
	
	/**
	 * 获得品牌套餐商品
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBrandPackageGoods", method = RequestMethod.POST)
	public void getBrandPackageByBrand(BrandPackageGoodsBean brandPackageGoodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, goodsServiceI.getBrandPackageGoods(brandPackageGoodsBean));	
	}
	/*
	 * -----------------------------------------新增----------------------------------------------------	
	 */
	/**
	 * 获得品牌套餐商品
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBrandPackageGoods", method = RequestMethod.POST)
	public void getBrandPackageByBrand2(BrandPackageGoodsBean brandPackageGoodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, goodsServiceI.getBrandPackageGoods(brandPackageGoodsBean));	
	}
}

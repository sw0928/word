package tst.project.webservice.interfaces;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tst.project.bean.goods.GoodsBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.GoodsServiceI;
import tst.project.webservice.controller.BaseController;

/**
 * 家纺特有的接口
 * @author shenjiabo
 *
 */
@Controller
@RequestMapping("/jfInterfaces.api")
public class JFInterfaces  extends BaseController{
	@Resource
	GoodsServiceI goodsServiceI;
	
	/**
	 * 首页最新商品(后台设置的)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getNewHotGoods", method = RequestMethod.POST)
	public void getNewHotGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getNewHotGoods(goodsBean,pageBean));
	}
	/**
	 * 首页热门商品(后台设置的)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeHotGoods", method = RequestMethod.POST)
	public void getHomeHotGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getHomeHotGoods(goodsBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 首页畅销商品(后台设置的)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeSellingGoods", method = RequestMethod.POST)
	public void getHomeSellingGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getHomeSellingGoods(goodsBean,pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 分类热门商品(后台设置的)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getClassHotGoods", method = RequestMethod.POST)
	public void getClassHotGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getClassHotGoods(goodsBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 分类畅销商品(后台设置的)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getClassSellingGoods", method = RequestMethod.POST)
	public void getClassSellingGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getClassSellingGoods(goodsBean,pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 分类下商品价格排序
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getClassPriceSortGoods", method = RequestMethod.POST)
	public void getClassPriceSortGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getClassPriceSortGoods(goodsBean,pageBean),pageBean.getTotal());
	}
}

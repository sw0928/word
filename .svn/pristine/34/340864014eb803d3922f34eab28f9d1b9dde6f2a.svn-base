package tst.project.webservice.interfaces;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.SSPClassBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.GoodsServiceI;
import tst.project.webservice.controller.BaseController;

/**
 * 顺手拍特有的接口
 * @author shenjiabo
 *
 */
@Controller
@RequestMapping("/sspInterfaces.api")
public class SSPInterfaces extends BaseController{
	@Resource
	GoodsServiceI goodsServiceI;
	

	/**
	 * 所有商品
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllGoods", method = RequestMethod.POST)
	public void getAllGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getAllGoods(goodsBean,pageBean));
	}
	

	/**
	 * 促销
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSSPGoodsClass", method = RequestMethod.POST)
	public void getSSPGoodsClass(SSPClassBean sspClassBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getSSPGoodsClass(sspClassBean));
	}
	
	/**
	 * 促销
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getPromotionGoods", method = RequestMethod.POST)
	public void getPromotionGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getPromotionGoods(goodsBean,pageBean));
	}
	
	/**
	 * 礼品
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGiftGoods", method = RequestMethod.POST)
	public void getGiftGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getGiftGoods(goodsBean,pageBean));
	}
	
	
	/**
	 * 生鲜
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getFreshGoods", method = RequestMethod.POST)
	public void getFreshGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getFreshGoods(goodsBean,pageBean));
	}
	
	/**
	 * 母婴
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBabyGoods", method = RequestMethod.POST)
	public void getBabyGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getBabyGoods(goodsBean,pageBean));
	}
	
	/**
	 * 女士
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getLadyGoods", method = RequestMethod.POST)
	public void getLadyGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getLadyGoods(goodsBean,pageBean));
	}
	
	/**
	 * 特色
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getFeatureGoods", method = RequestMethod.POST)
	public void getFeatureGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getFeatureGoods(goodsBean,pageBean));
	}
	
	/**
	 * 进口
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getImportGoods", method = RequestMethod.POST)
	public void getImportGoods(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, goodsServiceI.getImportGoods(goodsBean,pageBean));
	}
}

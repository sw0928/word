package tst.project.webservice.interfaces;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tst.project.bean.goods.GoodsBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.IntegralShopService;
import tst.project.webservice.controller.BaseController;
/**
 * 积分商城
 * @author shenjiabo
 *
 */
@Controller
@RequestMapping("/integralShopInterfaces.api")
public class IntegralShopInterfaces extends BaseController{
	@Resource
	IntegralShopService integralShopService;
	/**
	 * 获得菜谱列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getIntegralGoodss", method = RequestMethod.POST)
	public void getIntegralGoodss(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		WriteObject(response, integralShopService.getIntegralGoodss(goodsBean, pageBean));
	}
	
	
}

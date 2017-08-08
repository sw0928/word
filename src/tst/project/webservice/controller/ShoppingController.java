package tst.project.webservice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tst.project.bean.goods.ShoppingCarBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.page.PageBean;
import tst.project.service.controller.MerchantsService;
import tst.project.service.controller.ShoppingCarServiceC;
import tst.project.service.controller.SystemService;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/shoppingController.api")
public class ShoppingController extends BaseController {

	@Resource
	MerchantsService merchantsService;
	
	@Resource
	SystemService systemService;
	
	@Resource
	ShoppingCarServiceC shoppingCarServiceC;
	/**
	 * 推荐的商品分类列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	@RequestMapping(params = "insertShoppingCar", method = RequestMethod.POST)
	public void insertShoppingCar(MerchantsAccountBean merchantsAccountBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		ShoppingCarBean shoppingCarBean2=shoppingCarServiceC
				.getShoppingCarByGoodsIdAndMemberId(shoppingCarBean);
		
		if (shoppingCarBean2 != null) {
			WriteError(response, "购物车已有此商品");
			return;
		}
		
		int num = shoppingCarServiceC.insertShoppingCar(shoppingCarBean);
		if (num > 0) {
			WriteMsg(response, shoppingCarBean.getCar_id() + "");
		} else {
			WriteError(response, "添加失败");
		}
	}
	

	/** 获得自己的购物车列表
	 * 
	 * @param memberBean
	 * @param shoppingCarBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getShoppingCarB2C", method = RequestMethod.POST)
	public void getShoppingCarB2C(MerchantsAccountBean merchantsAccountBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response,
				shoppingCarServiceC.getShoppingCarB2C(shoppingCarBean));
	 }
	
	/** 获得自己的购物车列表
	 * 
	 * @param memberBean
	 * @param shoppingCarBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getShoppingCars", method = RequestMethod.POST)
	public void getShoppingCars(MerchantsAccountBean merchantsAccountBean,PageBean pageBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response,
				shoppingCarServiceC.getShoppingCars(shoppingCarBean,pageBean),pageBean.getTotal());
	 }
	/** 获得自己的购物车商品列表
	 * 
	 * @param memberBean
	 * @param shoppingCarBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getShoppingCarsByMerchants", method = RequestMethod.POST)
	public void getShoppingCarsByMerchants(MerchantsAccountBean merchantsAccountBean,
			PageBean pageBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response,
				shoppingCarServiceC.getShoppingCarsByMerchants(shoppingCarBean,pageBean),pageBean.getTotal());
	 }
	
	/** 获得自己的购物车列表
	 * 
	 * @param memberBean
	 * @param shoppingCarBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getShoppingCarsWithCarids", method = RequestMethod.POST)
	public void getShoppingCarsWithCarids(MerchantsAccountBean merchantsAccountBean,PageBean pageBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		String[] car_ids=request.getParameter("car_ids").split(",");
		WriteObject(response,
				shoppingCarServiceC.getShoppingCarsWithCarids(shoppingCarBean,car_ids));
	}
	
	@RequestMapping(params = "deleteShoppingCar", method = RequestMethod.POST)
	public void deleteShoppingCar(MerchantsAccountBean merchantsAccountBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		int num=shoppingCarServiceC.deleteShoppingCar(shoppingCarBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	@RequestMapping(params = "deleteShoppingCars", method = RequestMethod.POST)
	public void deleteShoppingCars(MerchantsAccountBean merchantsAccountBean,MemberBean memberBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		String[] car_ids=request.getParameter("car_ids").split(",");
		if(car_ids==null||car_ids.length<=0){
			WriteError(response, "请先选择要删除的商品");
			return;
		}
		int num=shoppingCarServiceC.deleteShoppingCars(car_ids,memberBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}

	@RequestMapping(params = "updateShoppingCarNum", method = RequestMethod.POST)
	public void updateShoppingCarNum(MerchantsAccountBean merchantsAccountBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=shoppingCarServiceC.updateShoppingCarNum(shoppingCarBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
}

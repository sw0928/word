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

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.ShoppingCarBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.others.CodeBean;
import tst.project.page.PageBean;
import tst.project.service.controller.GoodsService;
import tst.project.service.controller.MerchantsService;
import tst.project.service.interfaces.CodeService;
import tst.project.service.interfaces.MemberService;
import tst.project.service.interfaces.ShoppingCarService;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/shoppingCarInterfaces.api")
public class ShoppingCarInterface extends BaseController {

	@Resource
	MemberService memberService;

	@Resource
	ShoppingCarService shoppingCarService;
	
	@Resource
	CodeService codeService;
	
	@Resource 
	GoodsService goodsService;
	
	
	/**
	 * 购物车数量
	 * 
	 * @param goodsBean
	 * @return
	 */
	@RequestMapping(params = "getMemberShoppingCarCount", method = RequestMethod.POST)
	public void getMemberShoppingCarCount(MemberBean memberBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, shoppingCarService.getMemberShoppingCarCount(memberBean));
	}
	
	
	/**
	 * 添加购物车
	 * 
	 * @param goodsBean
	 * @return
	 */
	@RequestMapping(params = "insertShoppingCar", method = RequestMethod.POST)
	public void insertShoppingCar(MemberBean memberBean,
			ShoppingCarBean shoppingCarBean, GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		GoodsBean goodsBean1=goodsService.getOneGoodsDetail(goodsBean);
		
		if(goodsBean1==null||"0".equals(goodsBean1.getGoods_state())){
			WriteError(response,"此商品已下架!");
			return;
		}
		
		if(goodsBean1.getGoods_stock()<NumberUtils.Integer(shoppingCarBean.getGoods_num())){
			WriteError(response,"库存不足");
			return;
		}			
		
		ShoppingCarBean shoppingCarBean2=shoppingCarService
				.getShoppingCarByGoodsIdAndMemberId(shoppingCarBean);
		if (shoppingCarBean2 != null) {//购物车已有此商品
			int num=shoppingCarService.updateShoppingCarNum(shoppingCarBean2
					.setGoods_num(Integer.valueOf(shoppingCarBean2.getGoods_num())+Integer.valueOf(shoppingCarBean.getGoods_num())+""));
			if(num>0){
				WriteMsg(response, shoppingCarBean.getCar_id()+"");
			}else{
				WriteError(response, "添加失败");
			}
		}else{	
			int num = shoppingCarService.insertShoppingCar(shoppingCarBean);
			if (num > 0) {
				WriteMsg(response, shoppingCarBean.getCar_id() + "");
			} else {
				WriteError(response, "添加失败");
			}
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
	public void getShoppingCarB2C(MemberBean memberBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response,shoppingCarService.getShoppingCarB2C(shoppingCarBean));
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
	public void getShoppingCars(MemberBean memberBean,PageBean pageBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response,shoppingCarService.getShoppingCars(shoppingCarBean,pageBean));
	 }
	
	
	/** 获得自己的购物车列表
	 * 
	 * @param memberBean
	 * @param shoppingCarBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getShoppingCarsHBR", method = RequestMethod.POST)
	public void getShoppingCarsHBR(MemberBean memberBean,PageBean pageBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response,shoppingCarService.getShoppingCarsHBR(shoppingCarBean,pageBean));
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
	public void getShoppingCarsWithCarids(MemberBean memberBean,PageBean pageBean,
			ShoppingCarBean shoppingCarBean, CodeBean codeBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		MemberBean memberBean1=memberService.verificationToken(memberBean);
		if (memberBean1 == null) {
			WritePending(response, "token failed");
			return;
		}

		String ids=request.getParameter("car_ids");
		String[] car_ids=null;
		if(ids!=null&&ids.length()>0){
			car_ids=ids.split(",");
		}
		WriteObject(response,shoppingCarService.getShoppingCarsWithCarids(shoppingCarBean,car_ids));
	}
	
	@RequestMapping(params = "deleteShoppingCar", method = RequestMethod.POST)
	public void deleteShoppingCar(MemberBean memberBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		int num=shoppingCarService.deleteShoppingCar(shoppingCarBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	@RequestMapping(params = "deleteShoppingCars", method = RequestMethod.POST)
	public void deleteShoppingCars(MemberBean memberBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		String[] car_ids=request.getParameter("car_ids").split(",");
		if(car_ids==null||car_ids.length<=0){
			WriteError(response, "请先选择要删除的商品");
			return;
		}
		int num=shoppingCarService.deleteShoppingCars(car_ids,memberBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}

	@RequestMapping(params = "updateShoppingCarNum", method = RequestMethod.POST)
	public void updateShoppingCarNum(MemberBean memberBean,
			ShoppingCarBean shoppingCarBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		int num=shoppingCarService.updateShoppingCarNum(shoppingCarBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	
	@RequestMapping(params = "updateShoppingCarNums", method = RequestMethod.POST)
	public void updateShoppingCarNums(MemberBean memberBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		String cars=request.getParameter("cars");
		List<ShoppingCarBean> shoppingCarBeans=new Gson().fromJson(cars,new TypeToken<List<ShoppingCarBean>>() {}.getType());
		
		int num=shoppingCarService.updateShoppingCarNums(shoppingCarBeans,memberBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
}

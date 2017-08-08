package tst.project.webservice.interfaces;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsClassBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.GoodsServiceI;
import tst.project.service.interfaces.GoodsServiceI2;
import tst.project.service.interfaces.MemberService;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/goodsInterfaces2.api")
public class GoodsInterfaces2 extends BaseController{
	@Resource
	GoodsServiceI2 goodsServiceI2;
	
	@Resource
	GoodsServiceI goodsServiceI;
	
	@Resource
	MemberService memberService;
	
	
	/**
	 * 商品详情
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneGoodsDetail", method = RequestMethod.POST)
	public void getOneGoodsDetail(GoodsBean goodsBean,PageBean pageBean,
			MemberBean memberBean,HttpServletRequest request, HttpServletResponse response) {		
		
		if(memberBean.getFill_invitation_code()!=null&&!memberBean.getFill_invitation_code().equals("")){
			MemberBean memberBean2=memberService.getMemberByID(memberBean);
			if(memberBean2!=null){
				if(memberBean2.getFill_invitation_code()==null||memberBean2.getFill_invitation_code().equals("")){
					int num=memberService.updateMemberAttach(memberBean);
					if(num<=0){
						WriteError(response, "查询失败");
						return;
					}
				}
			}
		}
		goodsServiceI.updateGoodsDetailSeenum(goodsBean);
		WriteObject(response, goodsServiceI2.getOneGoodsDetail(request,goodsBean));
	}
	/**
	 * 获得参数 根据no
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsParametersByNo", method = RequestMethod.POST)
	public void getGoodsParameters(MerchantsAccountBean merchantsAccountBean,GoodsParameterBean goodsParameterBean, HttpServletRequest request,
			HttpServletResponse response) {
		try{
		
			WriteObject(response, goodsServiceI2.getGoodsParametersByNo(goodsParameterBean));
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 猜你喜欢--根据用户购买等习惯。。。。。得商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getLoveGoodsByHabit", method = RequestMethod.POST)
	public void getGoodsByHabit(GoodsBean goodsBean,PageBean pageBean,MemberBean memberBean,HttpServletRequest request, HttpServletResponse response) {		
		WriteObject(response, goodsServiceI2.getLoveGoodsByHabit(goodsBean, memberBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 猜你喜欢--根据用户购买等习惯。。。。。得分类
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getLoveClassByHabit", method = RequestMethod.POST)
	public void getLoveClassByHabit(GoodsBean goodsBean,PageBean pageBean,MemberBean memberBean,HttpServletRequest request, HttpServletResponse response) {		
		String level=request.getParameter("level");
		
		WriteObject(response, goodsServiceI2.getLoveClassByHabit(goodsBean, memberBean,level,pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 自定义多级分类
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsClasss", method = RequestMethod.POST)
	public void getGoodsClasss(GoodsClassBean goodsClassBean,HttpServletRequest request, HttpServletResponse response) {
		String level=request.getParameter("level");
		
		WriteObject(response, goodsServiceI2.getGoodsClasss(goodsClassBean,level==null?1:Integer.valueOf(level)));
	}
	
	/**
	 * 根据各种条件 搜索商品列表
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "searchGoodsDetailList", method = RequestMethod.POST)
	public void searchGoodsDetailList(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		WriteObject(response, goodsServiceI2.searchGoodsDetailList(goodsBean,pageBean),pageBean.getTotal());
	}
}

package tst.project.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.opensymphony.xwork2.util.finder.Test;

import sun.print.resources.serviceui;
import tst.project.bean.ExcelBean;
import tst.project.bean.activity.GroupBuyGoodsBean;
import tst.project.bean.banner.BannerBean;
import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.distribution.TotalDistributionBean;
import tst.project.bean.goods.CardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.page.PageBean;
import tst.project.service.controller.DistributionService;
import tst.project.service.controller.MemberServiceC;
import tst.project.service.controller.SystemService;
import tst.project.utils.ExcelUtils;
import tst.project.utils.TimeUtils;

@Controller
@RequestMapping("/distributionController.api")
public class DistributionController extends BaseController{
	@Resource
	DistributionService distributionService;
	
	@Resource
	SystemService systemService;
	
	@Resource
	MemberServiceC memberServiceC;
	
	/**
	 * 平台统计
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "exportAllDistributon", method = RequestMethod.POST)
	public void exportAllDistributon(MerchantsAccountBean merchantsAccountBean,
			DistributionBean distributionBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".xls";		
		List<ExcelBean> excelBeans=new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("账号").setType("mobile_phone"));
		excelBeans.add(new ExcelBean().setName("微信昵称").setType("user_name"));
		excelBeans.add(new ExcelBean().setName("一级vip数量").setType("vip1_count"));
		excelBeans.add(new ExcelBean().setName("金额").setType("vip1_price"));
		excelBeans.add(new ExcelBean().setName("二级vip数量").setType("vip2_count"));
		excelBeans.add(new ExcelBean().setName("金额").setType("vip2_price"));
		excelBeans.add(new ExcelBean().setName("一级非vip数量").setType("unvip1_count"));
		excelBeans.add(new ExcelBean().setName("金额").setType("unvip1_price"));
		excelBeans.add(new ExcelBean().setName("二级非vip数量").setType("unvip2_count"));
		excelBeans.add(new ExcelBean().setName("金额").setType("unvip2_price"));

		
		List<Object> memberBeans=distributionService.exportAllDistributon(distributionBean);
		
		boolean is_success=ExcelUtils.exportExcel(request.getSession().getServletContext()
				.getRealPath("/")+"/excel/"+fileName, excelBeans,memberBeans,response);
		if(is_success){
			WriteMsg(response, "/excel/"+fileName);
		}else{
			WriteError(response, "导出失败");
		}
		
	}
	
	
	
	/**
	 * vip用户导出
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "exportDistributionsExcel", method = RequestMethod.POST)
	public void exportDistributionsExcel(MerchantsAccountBean merchantsAccountBean,
			MemberBean memberBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".xls";
		
		List<ExcelBean> excelBeans=new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("ID").setType("user_id"));
		excelBeans.add(new ExcelBean().setName("昵称").setType("nick_name"));
		excelBeans.add(new ExcelBean().setName("手机号").setType("mobile_phone"));

		List<Object> memberBeans=distributionService.exportDistributionsExcel(memberBean);
		
		boolean is_success=ExcelUtils.exportExcel(request.getSession().getServletContext()
				.getRealPath("/")+"/excel/"+fileName, excelBeans,memberBeans,response);
		if(is_success){
			WriteMsg(response, "/excel/"+fileName);
		}else{
			WriteError(response, "导出失败");
		}
		
	}
	
	
	/**
	 * 不是vip用户导出
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "exportUnDistributionsExcel", method = RequestMethod.POST)
	public void exportUnDistributionsExcel(MerchantsAccountBean merchantsAccountBean,
			MemberBean memberBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".xls";
		
		List<ExcelBean> excelBeans=new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("ID").setType("user_id"));
		excelBeans.add(new ExcelBean().setName("昵称").setType("nick_name"));
		excelBeans.add(new ExcelBean().setName("手机号").setType("mobile_phone"));

		List<Object> memberBeans=distributionService.exportUnDistributionsExcel(memberBean);
		
		boolean is_success=ExcelUtils.exportExcel(request.getSession().getServletContext()
				.getRealPath("/")+"/excel/"+fileName, excelBeans,memberBeans,response);
		if(is_success){
			WriteMsg(response, "/excel/"+fileName);
		}else{
			WriteError(response, "导出失败");
		}
		
	}
	
	/**
	 * 获得佣金
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getTotalDistributionsCount", method = RequestMethod.POST)
	public void getTotalDistributionsCount(MerchantsAccountBean merchantsAccountBean,
			TotalDistributionBean totalDistributionBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, distributionService.getTotalDistributionsCount(totalDistributionBean));
	}
	
	/**
	 * 未获得佣金
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getTotalUnDistributionsCount", method = RequestMethod.POST)
	public void getTotalUnDistributionsCount(MerchantsAccountBean merchantsAccountBean,
			TotalDistributionBean totalDistributionBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, distributionService.getTotalUnDistributionsCount(totalDistributionBean));
	}
	
	/**
	 * 未获得佣金
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getUnDistributions", method = RequestMethod.POST)
	public void getUnDistributions(MerchantsAccountBean merchantsAccountBean,MemberBean memberBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		MemberBean memberBean2=memberServiceC.getOneMemberDetailZSSG(memberBean);
		
		String type=request.getParameter("type");
		
		WriteObject(response, distributionService.getUnDistributionsCount(memberBean2, type, pageBean),pageBean.getTotal());
	}
	
	/**
	 * 未获得佣金
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "exportUnDistributions", method = RequestMethod.POST)
	public void exportUnDistributions(MerchantsAccountBean merchantsAccountBean,MemberBean memberBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		MemberBean memberBean2=memberServiceC.getOneMemberDetailZSSG(memberBean);
		
		String type=request.getParameter("type");
		
		List<Object> objects=distributionService.exportUnDistributions(memberBean2, type);
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".xls";
		List<ExcelBean> excelBeans=new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("类型").setType("distribution_type"));
		excelBeans.add(new ExcelBean().setName("ID").setType("user_id"));
		excelBeans.add(new ExcelBean().setName("昵称").setType("user_name"));
		excelBeans.add(new ExcelBean().setName("手机号").setType("mobile_phone"));
		excelBeans.add(new ExcelBean().setName("佣金").setType("distribution_price"));
		excelBeans.add(new ExcelBean().setName("层级").setType("distribution_relation"));

		boolean is_success=ExcelUtils.exportExcel(request.getSession().getServletContext()
				.getRealPath("/")+"/excel/"+fileName, excelBeans,objects,response);
		if(is_success){
			WriteMsg(response, "/excel/"+fileName);
		}else{
			WriteError(response, "导出失败");
		}	
	}
	
	/**
	 * 分销的列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getDistributions", method = RequestMethod.POST)
	public void getDistributions(MerchantsAccountBean merchantsAccountBean,
			DistributionBean distributionBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, distributionService.getDistributionsCount(distributionBean,pageBean),pageBean.getTotal());
	}
	
	
	
	/**
	 * 获得分销卡列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getProfits", method = RequestMethod.POST)
	public void getProfits(MerchantsAccountBean merchantsAccountBean,DistributionBean distributionBean,PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, distributionService.getProfits(distributionBean,pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 激活码批量导入
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "loadCardExcel", method = RequestMethod.POST)
	public void loadCardExcel(MerchantsAccountBean merchantsAccountBean,CardBean cardBean,PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String json=uploadFile(request, "/excel/");
				
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
			return;
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
			return;
		}	
		
		String result=ExcelUtils.readExcel(request.getSession().getServletContext()
				.getRealPath("/")+json);		
		List<CardBean> cardBeans=new Gson().fromJson(result, new TypeToken<List<CardBean>>() {}.getType());
		int num=distributionService.insertCardGoods(cardBeans);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 获得分销卡列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getCardGoodss", method = RequestMethod.POST)
	public void getCardGoodss(MerchantsAccountBean merchantsAccountBean,CardBean cardBean,PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, distributionService.getCardGoodss(cardBean,pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 添加分销卡（特殊商品）
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertCardGoods", method = RequestMethod.POST)
	public void insertCardGoods(MerchantsAccountBean merchantsAccountBean,CardBean cardBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		String count=request.getParameter("count");//需要生成的个数	
		int num=distributionService.insertCardGoods(cardBean,Integer.valueOf(count));
		
		if(num>0){
			WriteMsg(response, "添加成功");		
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	
	/**
	 * 删除分销卡（特殊商品）
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteCardGoods", method = RequestMethod.POST)
	public void deleteCardGoods(MerchantsAccountBean merchantsAccountBean,CardBean cardBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=distributionService.deleteCardGoods(cardBean);
		if(num>0){
			WriteMsg(response, "添加成功");		
		}else{
			WriteError(response, "添加失败");
		}
	}
}

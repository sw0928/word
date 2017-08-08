package tst.project.webservice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tst.project.bean.activity.GroupBuyBean;
import tst.project.bean.finance.CashApplyBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.page.PageBean;
import tst.project.service.controller.FinanceService;
import tst.project.service.controller.SystemService;
import tst.project.service.interfaces.MemberService;

@Controller
@RequestMapping("/financeController.api")

public class FinanceController extends BaseController{
	
	@Resource
	FinanceService financeService;
	
	@Resource
	SystemService systemService;
	
	/**
	 * 获得所有的提现申请
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getCashApplys", method = RequestMethod.POST)
	public void getCashApplys(MerchantsAccountBean merchantsAccountBean,CashApplyBean cashApplyBean,
			PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, financeService.getCashApplys(cashApplyBean,pageBean),pageBean.getTotal());
	}
	
	
	
	/**
	 *申请提现
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "applyCash", method = RequestMethod.POST)
	public void applyCash(MerchantsAccountBean merchantsAccountBean,CashApplyBean cashApplyBean,
			HttpServletRequest request,
			HttpServletResponse response)  {	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
						
			MerchantsBean merchantsBean=new MerchantsBean();
			
			int num=financeService.applyCash(cashApplyBean);
			if(num>0){
				WriteMsg(response, "申请成功");
			}else{
				WriteError(response, "申请失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 *审核申请
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateApplyState", method = RequestMethod.POST)
	public void updateApplyState(MerchantsAccountBean merchantsAccountBean,CashApplyBean cashApplyBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception  {	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			int num=financeService.updateApplyState(cashApplyBean);
			if(num>0){
				WriteMsg(response, "操作成功");
			}else{
				WriteError(response, "操作失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 获得所有的提现申请
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllCashApplys", method = RequestMethod.POST)
	public void getAllCashApplys(MerchantsAccountBean merchantsAccountBean,CashApplyBean cashApplyBean,
			PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, financeService.getAllCashApplys(cashApplyBean,pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 获得所有的提现申请
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllCashApplysMember", method = RequestMethod.POST)
	public void getAllCashApplysMember(MerchantsAccountBean merchantsAccountBean,CashApplyBean cashApplyBean,
			PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, financeService.getAllCashApplysMember(cashApplyBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 获得所有的提现申请
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllCashApplysMemberZSSG", method = RequestMethod.POST)
	public void getAllCashApplysMemberZSSG(MerchantsAccountBean merchantsAccountBean,CashApplyBean cashApplyBean,
			PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, financeService.getAllCashApplysMemberZSSG(cashApplyBean,pageBean),pageBean.getTotal());
	}
}

package tst.project.webservice.interfaces;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.mail.handlers.message_rfc822;

import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderLineBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.DistributionServiceI;
import tst.project.service.interfaces.MemberService;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/distributionInterfaces.api")
public class DistributionInterfaces extends BaseController{
	@Resource
	DistributionServiceI distributionServiceI;
	
	@Resource
	MemberService memberService;
	
	/**
	 * 分销下 会员列表
	 * @param orderLineBean
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping(params = "getDistributionMembersCount", method = RequestMethod.POST)
	public void getDistributionMembersCount(MemberBean memberBean,PageBean pageBean,HttpServletRequest request,HttpServletResponse response) throws Exception{
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, distributionServiceI.getDistributionMembersCount(memberBean));
	}
	
	
	/**
	 * 分销下 会员列表
	 * @param orderLineBean
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping(params = "getDistributionMembers", method = RequestMethod.POST)
	public void getDistributionMembers(MemberBean memberBean,PageBean pageBean,HttpServletRequest request,HttpServletResponse response) throws Exception{
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, distributionServiceI.getDistributionMembers(memberBean, pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 分销下 订单列表
	 * @param orderLineBean
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping(params = "getDistributionOrders", method = RequestMethod.POST)
	public void getDistributionOrders(MemberBean memberBean, 
			DistributionBean distributionBean,PageBean pageBean,HttpServletRequest request,HttpServletResponse response) throws Exception{
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, distributionServiceI.getDistributionOrders(distributionBean, pageBean),pageBean.getTotal());
	}
}

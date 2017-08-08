package tst.project.webservice.interfaces;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sun.print.resources.serviceui;
import tst.project.bean.activity.GroupBuyBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.SignBean;
import tst.project.bean.others.PercentBean;
import tst.project.dao.interfaces.SignDao;
import tst.project.service.interfaces.MemberService;
import tst.project.service.interfaces.OthersService;
import tst.project.service.interfaces.SignService;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;
import tst.project.webservice.controller.BaseController;

/**
 * 签到系统
 * @author shenjiabo
 *
 */

@Controller
@RequestMapping("/signInterfaces.api")
public class SignInterfaces extends BaseController{
	
	@Resource
	SignService signService;
	
	@Resource
	MemberService memberService;
	
	@Resource
	OthersService othersService;
	/**
	 * 签到获取积分
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertSign", method = RequestMethod.POST)
	public void insertSign(MemberBean memberBean,SignBean signBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		String today_time=TimeUtils.getCurrentTime("yyyy-MM-dd");
		String yesterday_time=TimeUtils.getTimeDayAfter("yyyy-MM-dd", TimeUtils.getDateFromTime("yyyy-MM-dd", today_time), -1);
				
		SignBean signBean2=signService.getSignToday(signBean.setCreate_time(today_time));
		if(signBean2!=null){
			WriteError(response, "今日已签到");
			return;
		}
		
		
		PercentBean percentBean=othersService.getPercent(new PercentBean().setPercent_type("sign"));
		PercentBean percentBean1=othersService.getPercent(new PercentBean().setPercent_type("max_sign_integral"));//签到最大积分
		int max_sign_integral=NumberUtils.Integer(percentBean1.getPercent_value());
		
		int base_integral=NumberUtils.Integer(percentBean.getPercent_value());//签到的基础分	
		List<SignBean> signBeans=signService.getMonthSigns(signBean);
		int sign_continuity_count_month=0;//一个月内 连续签到次数
		int sign_total_count_month=0;//一个月内 总共签到次数
		int sign_integral=0;//签到赠送积分
	
		if(signBeans!=null && signBeans.size()>0){//当前月之前签到过
			SignBean signBean3=signBeans.get(signBeans.size()-1);
			if((yesterday_time+" 00:00:00.0").equals(signBean3.getCreate_time())){//昨天签到了
				sign_integral=signBean3.getSign_integral()>=max_sign_integral?max_sign_integral:signBean3.getSign_integral()+5;
				sign_continuity_count_month=signBean3.getSign_continuity_count_month()+1;
			}else{
				sign_integral=base_integral;
				sign_continuity_count_month=1;
			}
			sign_total_count_month=signBean3.getSign_total_count_month()+1;
		}else{//当前月从未签到过
			sign_continuity_count_month=1;
			sign_total_count_month=1;
			sign_integral=base_integral;
		}
		int num=signService.insertSign(signBean
				.setCreate_time(today_time)
				.setSign_integral(sign_integral)
				.setSign_continuity_count_month(sign_continuity_count_month)
				.setSign_total_count_month(sign_total_count_month));
		if(num>0){
			WriteMsg(response,"签到成功");
		}else{
			WriteError(response, "签到失败");
		}
	}

	/**
	 * 获得今天签到信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSignToday", method = RequestMethod.POST)
	public void getSignToday(MemberBean memberBean,SignBean signBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}		
		WriteObject(response, signService.getSignToday(signBean));
	}

	
	
	/**
	 * 当月签到统计
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMonthSignStatistics", method = RequestMethod.POST)
	public void getMonthSignStatistics(MemberBean memberBean,SignBean signBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}	
		
		WriteObject(response, signService.getMonthSignStatistics(signBean));
	}
	/**
	 * 当月签到列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMonthSigns", method = RequestMethod.POST)
	public void getMonthSigns(MemberBean memberBean,SignBean signBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}	
		
		WriteObject(response, signService.getMonthSigns(signBean));
	}
	
	/**
	 * 签到列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSigns", method = RequestMethod.POST)
	public void getSigns(MemberBean memberBean,SignBean signBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}		
		WriteObject(response, signService.getSigns(signBean));
	}
}

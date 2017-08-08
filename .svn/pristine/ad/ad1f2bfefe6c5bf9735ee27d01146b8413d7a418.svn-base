package tst.project.webservice.interfaces;

import java.sql.Time;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tst.project.bean.member.CouponBean;
import tst.project.bean.member.MemberBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.CouponService;
import tst.project.service.interfaces.MemberService;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/couponInterfaces.api")
public class CouponInterfaces extends BaseController{
	@Resource
	MemberService memberService;

	@Resource
	CouponService couponService;
	
	
	/**
	 * 可领取优惠卷列表
	 * @param memberBean
	 * @param couponBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getReceiceCoupons", method = RequestMethod.POST)
	public void getReceiceCoupons(CouponBean couponBean,PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WriteObject(response, couponService.getReceiceCoupons(couponBean,pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 用户领取优惠卷
	 * @param memberBean
	 * @param couponBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "memberReceiveCoupon", method = RequestMethod.POST)
	public void memberReceiveCoupon(MemberBean memberBean, CouponBean couponBean,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		CouponBean couponBean3=couponService.getOneCoupon(couponBean);
		if(couponBean3==null){
			WriteError(response, "此优惠卷已不存在！");
			return;
		}
		
		CouponBean couponBean2=couponService.getCouponByMemberIdAndCouponId(couponBean);
		if(couponBean2!=null){
			WriteError(response, "已经领取过了");
			return;
		}
		
		int day=NumberUtils.Integer(couponBean3.getValid_day());
		if(day<=0){
			WriteError(response, "此优惠卷数据异常!");
			return;
		}
		
		String start_time=TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss");
		String end_time=TimeUtils.getTimeDayAfter("yyyy-MM-dd HH:mm:ss", start_time, day);
		
		int num=couponService.memberReceiveCoupon(couponBean.setStart_time(start_time).setEnd_time(end_time));
		if(num>0){
			WriteMsg(response, "领取成功");
		}else{
			WriteError(response, "领取失败");
		}
	}
	
	/**
	 * 用户的优惠卷列表
	 * @param memberBean
	 * @param couponBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getCoupons", method = RequestMethod.POST)
	public void getCoupons(MemberBean memberBean, CouponBean couponBean,PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, couponService.getCoupons(couponBean,pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 用户的优惠卷列表 各个状态总数
	 * @param memberBean
	 * @param couponBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getCouponsCount", method = RequestMethod.POST)
	public void getCouponsCount(MemberBean memberBean, CouponBean couponBean,PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, couponService.getCouponsCount(couponBean));
	}
}

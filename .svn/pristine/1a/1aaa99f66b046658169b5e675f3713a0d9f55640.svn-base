package tst.project.webservice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tst.project.bean.member.CouponBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.page.PageBean;
import tst.project.service.controller.CouponServiceC;
import tst.project.service.controller.SystemService;

@Controller
@RequestMapping("/couponController.api")
public class CouponController extends BaseController {
	@Resource
	CouponServiceC couponServiceC;

	@Resource
	SystemService systemService;

	/**
	 * 优惠卷统计
	 * 
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getCouponCount", method = RequestMethod.POST)
	public void getCouponCount(MerchantsAccountBean merchantsAccountBean, CouponBean couponBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			WriteObject(response, couponServiceC.getCouponCount(couponBean));
		} catch (Exception e) {
			WriteError(response,e.getMessage());
		}
	}
	/**
	 * 分配优惠卷
	 * 
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "allocationCoupon", method = RequestMethod.POST)
	public void allocationCoupon(MerchantsAccountBean merchantsAccountBean, CouponBean couponBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			String mobile[] = request.getParameter("mobile").split(",");

			int num = couponServiceC.allocationCoupon(couponBean, mobile);
			if (num > 0) {
				WriteMsg(response, "添加成功");
			} else {
				WriteError(response, "添加失败");
			}
		} catch (Exception e) {
			WriteError(response,e.getMessage());
		}
	}

	/**
	 * 分配优惠卷
	 * 
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "allocationAllCoupon", method = RequestMethod.POST)
	public void allocationAllCoupon(MerchantsAccountBean merchantsAccountBean, CouponBean couponBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			int num = couponServiceC.allocationAllCoupon(couponBean);
			if (num > 0) {
				WriteMsg(response, "添加成功");
			} else {
				WriteError(response, "添加失败");
			}
//		} catch (Exception e) {
//			WriteError(response,e.getMessage());
//		}
	}
	
	/**
	 * 添加优惠卷
	 * 
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertCoupon", method = RequestMethod.POST)
	public void insertCoupon(MerchantsAccountBean merchantsAccountBean, CouponBean couponBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = couponServiceC.insertCoupon(couponBean);
		if (num > 0) {
			WriteMsg(response, "添加成功");
		} else {
			WriteError(response, "添加失败");
		}
	}

	/**
	 * 修改优惠卷
	 * 
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateCoupon", method = RequestMethod.POST)
	public void updateCoupon(MerchantsAccountBean merchantsAccountBean, CouponBean couponBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = couponServiceC.updateCoupon(couponBean);
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteError(response, "修改失败");
		}
	}

	/**
	 * 删除优惠卷
	 * 
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteCoupon", method = RequestMethod.POST)
	public void deleteCoupon(MerchantsAccountBean merchantsAccountBean, CouponBean couponBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = couponServiceC.deleteCoupon(couponBean);
		if (num > 0) {
			WriteMsg(response, "删除成功");
		} else {
			WriteError(response, "删除失败");
		}
	}

	/**
	 * 获得优惠卷列表
	 * 
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getCoupons", method = RequestMethod.POST)
	public void getCoupons(MerchantsAccountBean merchantsAccountBean, CouponBean couponBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, couponServiceC.getCoupons(couponBean, pageBean), pageBean.getTotal());
	}
}

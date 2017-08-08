package tst.project.webservice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.order.AssessmentBean;
import tst.project.page.PageBean;
import tst.project.service.controller.AssessmentService;
import tst.project.service.controller.SystemService;

@Controller
@RequestMapping("/assessmentController.api")
public class AssessmentController extends BaseController{
	@Resource
	SystemService systemService;
	
	@Resource
	AssessmentService assessmentService;
	/**
	 * 添加限时促销的活动的商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAssessments", method = RequestMethod.POST)
	public void getAssessments(MerchantsAccountBean merchantsAccountBean,
			AssessmentBean assessmentBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, assessmentService.getAssessments(assessmentBean,pageBean),pageBean.getTotal());	
	}
	
	/**
	 * 添加限时促销的活动的商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAssessmentDetail", method = RequestMethod.POST)
	public void getAssessmentDetail(MerchantsAccountBean merchantsAccountBean,
			AssessmentBean assessmentBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, assessmentService.getAssessmentDetail(assessmentBean));	
	}
	/**
	 * 添加限时促销的活动的商品
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteAssessment", method = RequestMethod.POST)
	public void deleteAssessment(MerchantsAccountBean merchantsAccountBean,
			AssessmentBean assessmentBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=assessmentService.deleteAssessment(assessmentBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
}

package tst.project.webservice.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import tst.project.bean.information.InformationBean;
import tst.project.bean.information.InformationImgBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.others.HtmlStyleBean;
import tst.project.page.PageBean;
import tst.project.service.controller.InformationServiceC;
import tst.project.service.controller.OthersServiceC;
import tst.project.service.controller.SystemService;
import tst.project.utils.TimeUtils;

/**
 * 
 * @author shenjiabo
 *
 */
@Controller
@RequestMapping("/informationController.api")
public class InformationController extends BaseController{
	@Resource
	SystemService systemService;
	
	@Resource
	InformationServiceC informationServiceC;
	
	@Resource
	OthersServiceC othersServiceC;
	/**
	 *添加咨询
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteInformation", method = RequestMethod.POST)
	public void deleteInformation(MerchantsAccountBean merchantsAccountBean,
			InformationBean informationBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=informationServiceC.deleteInformation(informationBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	/**
	 *修改咨询
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateInformation", method = RequestMethod.POST)
	public void updateInformation(MerchantsAccountBean merchantsAccountBean,
			InformationBean informationBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		String information_imgs=request.getParameter("information_imgs");
		
		List<InformationImgBean> informationImgBeans=new Gson().fromJson(information_imgs,new TypeToken<List<InformationImgBean>>() {}.getType());
		int num=informationServiceC.updateInformation(informationBean,informationImgBeans);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	
	/**
	 *添加咨询
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertInformation", method = RequestMethod.POST)
	public void insertInformation(MerchantsAccountBean merchantsAccountBean,
			InformationBean informationBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".html";	
		String path="/html/goods/";
		writeHtml(request, path+fileName,"知识展示",othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("information")));
		
		String information_imgs=request.getParameter("information_imgs");

		List<InformationImgBean> informationImgBeans=new Gson().fromJson(information_imgs,new TypeToken<List<InformationImgBean>>() {}.getType());

		int num=informationServiceC.insertInformation(informationBean.setInformation_url(path+fileName),informationImgBeans);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 咨询列表
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getInformations", method = RequestMethod.POST)
	public void getAssessments(MerchantsAccountBean merchantsAccountBean,
			InformationBean informationBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, informationServiceC.getInformations(informationBean,pageBean),pageBean.getTotal());
		
	}
}

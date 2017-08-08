package tst.project.webservice.interfaces;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tst.project.bean.information.InformationBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.InformationService;
import tst.project.webservice.controller.BaseController;
@Controller
@RequestMapping("/informationInterfaces.api")
public class InformationInterfaces extends BaseController{
	
	@Resource
	InformationService informationService;
	/**
	 * 获得所有咨询列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getInformationDetail", method = RequestMethod.POST)
	public void getInformationDetail(InformationBean informationBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		WriteObject(response, informationService.getInformationDetail(informationBean));
	}
	
	
	/**
	 * 获得所有咨询列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getInformations", method = RequestMethod.POST)
	public void getInformations(InformationBean informationBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		WriteObject(response, informationService.getInformations(informationBean,pageBean));
	}
	
	/**
	 * 获得所有咨询列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getRecomendInformations", method = RequestMethod.POST)
	public void getRecomendInformations(InformationBean informationBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		WriteObject(response, informationService.getRecomendInformations(informationBean));
	}
}

package tst.project.webservice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tst.project.bean.banner.BannerBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.others.HtmlStyleBean;
import tst.project.page.PageBean;
import tst.project.service.controller.BannerServiceC;
import tst.project.service.controller.OthersServiceC;
import tst.project.service.controller.SystemService;
import tst.project.utils.ExcelUtils;
import tst.project.utils.TimeUtils;

@Controller
@RequestMapping("/bannerController.api")
public class BannerController extends BaseController{
	@Resource
	SystemService systemService;
	
	@Resource
	BannerServiceC bannerServiceC;
	
	@Resource
	OthersServiceC othersServiceC;
	
	/**
	 * 获得所有广告列表
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllBanners", method = RequestMethod.POST)
	public void getAllBanners(MerchantsAccountBean merchantsAccountBean,BannerBean bannerBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, bannerServiceC.getAllBanners(bannerBean,pageBean),pageBean.getTotal());
	}
	
	@RequestMapping(params = "insertBanner", method = RequestMethod.POST)
	public void insertBanner(MerchantsAccountBean merchantsAccountBean,BannerBean bannerBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".html";	
		String path="/html/banner/";
		writeHtml(request, path+fileName,"广告展示",othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("banner")));
		
		int num=bannerServiceC.insertBanner(bannerBean.setBanner_url(path+"/"+fileName));
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 修改广告
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateBanner", method = RequestMethod.POST)
	public void updateBanner(MerchantsAccountBean merchantsAccountBean,BannerBean bannerBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=bannerServiceC.updateBanner(bannerBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 上传广告图片
	 * @param merchantsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadBannerImg")
	public void uploadBannerImg(HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/banner/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
		}else{
			WriteMsg(response, json);
		}
	}
	
	
	@RequestMapping(params = "getBannerUrlHtml")
	public void getBannerUrlHtml(HttpServletRequest request, HttpServletResponse response) {
		String url=request.getParameter("url");
		WriteOnlyMsg(response,  readHtml(request,url));
	}

	@RequestMapping(params = "setBannerUrlHtml")
	public void setBannerUrlHtml(HttpServletRequest request, HttpServletResponse response) {
		String desc=request.getParameter("desc");
		String url=request.getParameter("url");
		
		HtmlStyleBean htmlStyleBean=othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("banner"));
		
		if(writeHtml(request,url,desc,htmlStyleBean)){
			WriteMsg(response, "保存成功");
		}else{
			WriteError(response, "保存失败");
		}
	}
	
	
	/**
	 * 删除广告
	 * @param merchantsBean
	 * @param bannerBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteBanner", method = RequestMethod.POST)
	public void deleteBanner(MerchantsAccountBean merchantsAccountBean,BannerBean bannerBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=bannerServiceC.deleteBanner(bannerBean);
		
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
}

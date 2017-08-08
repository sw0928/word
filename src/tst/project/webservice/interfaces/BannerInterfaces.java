package tst.project.webservice.interfaces;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tst.project.bean.banner.BannerBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.BannerService;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/bannerInterfaces.api")
public class BannerInterfaces extends BaseController{
	@Resource
	BannerService bannerService;
	/**
	 * 获得所有模块列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllBanners", method = RequestMethod.POST)
	public void getAllBanners(BannerBean bannerBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WriteObject(response, bannerService.getAllBanners(bannerBean));
	}
		
}

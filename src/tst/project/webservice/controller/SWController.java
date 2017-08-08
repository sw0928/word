package tst.project.webservice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tst.project.bean.activity.AlbumBean;
import tst.project.bean.banner.ClassBannerBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.page.PageBean;
import tst.project.service.controller.SWServiceC;
import tst.project.service.controller.SystemService;

@Controller
@RequestMapping("/swController.api")
public class SWController extends BaseController{
	@Resource
	SystemService systemService;
	
	@Resource
	SWServiceC swServiceC;
	
	/**
	 * 
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertClassBanner", method = RequestMethod.POST)
	public void insertClassBanner(MerchantsAccountBean merchantsAccountBean,ClassBannerBean classBannerBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			int num=swServiceC.insertClassBanner(classBannerBean);
			if(num>0){
				WriteMsg(response, "添加成功");
			}else{
				WriteError(response, "添加失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateClassBanner", method = RequestMethod.POST)
	public void updateClassBanner(MerchantsAccountBean merchantsAccountBean,ClassBannerBean classBannerBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			int num=swServiceC.updateClassBanner(classBannerBean);
			if(num>0){
				WriteMsg(response, "修改成功");
			}else{
				WriteError(response, "修改失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteClassBanner", method = RequestMethod.POST)
	public void deleteClassBanner(MerchantsAccountBean merchantsAccountBean,ClassBannerBean classBannerBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			int num=swServiceC.deleteClassBanner(classBannerBean);
			if(num>0){
				WriteMsg(response, "删除成功");
			}else{
				WriteError(response, "删除失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 好货专辑商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getClassBanners", method = RequestMethod.POST)
	public void getClassBanners(MerchantsAccountBean merchantsAccountBean,ClassBannerBean classBannerBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			WriteObject(response, swServiceC.getClassBanners(classBannerBean));
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	
	
	/**
	 * 好货专辑商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getExactGoodss", method = RequestMethod.POST)
	public void getExactGoodss(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			WriteObject(response, swServiceC.getExactGoodss(goodsBean,pageBean),pageBean.getTotal());
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 添加好货专辑商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertAlbumGoods", method = RequestMethod.POST)
	public void insertAlbumGoods(MerchantsAccountBean merchantsAccountBean,AlbumBean albumBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			if(swServiceC.getAlbumGoods(albumBean)!=null){
				WriteError(response, "该商品已添加过");
				return;
			}
			
			int num=swServiceC.insertAlbumGoods(albumBean);
			if(num>0){
				WriteMsg(response, "添加成功");
			}else{
				WriteError(response, "添加失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	/**
	 * 删除好货专辑商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteAlbumGoods", method = RequestMethod.POST)
	public void deleteAlbumGoods(MerchantsAccountBean merchantsAccountBean,AlbumBean albumBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			int num=swServiceC.deleteAlbumGoods(albumBean);
			if(num>0){
				WriteMsg(response, "删除成功");
			}else{
				WriteError(response, "删除失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	/**
	 * 好货专辑商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAlbumGoodss", method = RequestMethod.POST)
	public void getAlbumGoods(MerchantsAccountBean merchantsAccountBean,AlbumBean albumBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			WriteObject(response, swServiceC.getAlbumGoodss(albumBean,pageBean),pageBean.getTotal());
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	
	/**
	 * 好货专辑
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAlbums", method = RequestMethod.POST)
	public void getAlbums(MerchantsAccountBean merchantsAccountBean,AlbumBean albumBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			WriteObject(response, swServiceC.getAlbums(albumBean,pageBean),pageBean.getTotal());
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	/**
	 *  添加 好货专辑
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertAlbum", method = RequestMethod.POST)
	public void insertAlbum(MerchantsAccountBean merchantsAccountBean,AlbumBean albumBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			int num=swServiceC.insertAlbum(albumBean);
			if(num>0){
				WriteMsg(response, "添加成功");
			}else{
				WriteError(response, "添加失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 *  修改 好货专辑
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateAlbum", method = RequestMethod.POST)
	public void updateAlbum(MerchantsAccountBean merchantsAccountBean,AlbumBean albumBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
		
			int num=swServiceC.updateAlbum(albumBean);
			if(num>0){
				WriteMsg(response, "修改成功");
			}else{
				WriteError(response, "修改失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 删除 好货专辑
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteAlbum", method = RequestMethod.POST)
	public void deleteAlbum(MerchantsAccountBean merchantsAccountBean,AlbumBean albumBean,PageBean pageBean,
			HttpServletRequest request,HttpServletResponse response) throws Exception{	
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			int num=swServiceC.deleteAlbum(albumBean);
			if(num>0){
				WriteMsg(response, "删除成功");
			}else{
				WriteError(response, "删除失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
}

package tst.project.webservice.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsClassBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.GoodsRelationClassBean;
import tst.project.bean.goods.TagBean;
import tst.project.bean.goods.TimingGoodsBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.others.HtmlStyleBean;
import tst.project.page.PageBean;
import tst.project.service.controller.GoodsService;
import tst.project.service.controller.GoodsService2;
import tst.project.service.controller.OthersServiceC;
import tst.project.service.controller.SystemService;
import tst.project.utils.ExcelUtils;
import tst.project.utils.TimeUtils;

/**
 * 描述:商品管理
 * 版本:V2.0
 * 改善优化: 一个商品 可在多个分类下  规格对应库存的问题
 * @author shenjiabo
 */

@Controller
@RequestMapping("/goodsController2.api")
public class GoodsController2 extends BaseController{
	@Resource
	SystemService systemService;
		
	@Resource
	GoodsService2 goodsService2;
	
	@Resource
	GoodsService goodsService;
	
	@Resource
	OthersServiceC othersServiceC;
	
	/**
	 * 商品销量排行
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsSales", method = RequestMethod.POST)
	public void getGoodsSales(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			WriteObject(response, goodsService2.getGoodsSales(goodsBean,pageBean),pageBean.getTotal());
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}

	
	
	/**
	 * 删除定时记录
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteTimingGoods", method = RequestMethod.POST)
	public void deleteTimingGoods(MerchantsAccountBean merchantsAccountBean,TimingGoodsBean timingGoodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			
			int num=goodsService2.deleteTimingGoods(timingGoodsBean);
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
	 * 定时记录列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getTimingGoodss", method = RequestMethod.POST)
	public void getTimingGoodss(MerchantsAccountBean merchantsAccountBean,TimingGoodsBean timingGoodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			WriteObject(response, goodsService2.getTimingGoodss(timingGoodsBean,pageBean),pageBean.getTotal());
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}

	/**
	 * 定时改价
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertGoodsTiming", method = RequestMethod.POST)
	public void insertGoodsTiming(MerchantsAccountBean merchantsAccountBean,
			GoodsBean goodsBean,TimingGoodsBean timingGoodsBean,HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}

			GoodsBean goodsBean2=goodsService2.getGoodsBySku(goodsBean);
			if(goodsBean2==null){
				WriteError(response, "此sku不存在!");
				return;
			}
			
			if(!goodsBean2.getGoods_now_price().equals(goodsBean.getGoods_now_price())){
				WriteError(response, "商品现价错误！");
				return;
			}
			
			if(!goodsBean2.getGoods_origin_price().equals(goodsBean.getGoods_origin_price())){
				WriteError(response, "商品原价错误！");
				return;
			}
			
			int num=goodsService2.insertGoodsTiming(timingGoodsBean);
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
	 * 定时改价
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "loadGoodsTimings", method = RequestMethod.POST)
	public void loadGoodsTimings(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//try{
			String json=uploadFile(request, "/excel/");	
			if(json.equals("-1")){
				WriteError(response, "文件不可为空");
				return;
			}else if(json.equals("-2")){
				WriteError(response, "上传失败");	
				return;
			}	
			
			String result=ExcelUtils.readExcel(request.getSession().getServletContext()
					.getRealPath("/")+json);	
			List<TimingGoodsBean> timingGoodsBeans=new Gson().fromJson(result, new TypeToken<List<TimingGoodsBean>>() {}.getType());
			
			if(timingGoodsBeans==null||timingGoodsBeans.size()<=0){
				WriteError(response, "数据为空!");
				return;
			}
			int num=goodsService2.loadGoodsTimings(timingGoodsBeans);
			if(num>0){
				WriteMsg(response, "添加成功");
			}else{
				WriteError(response, "添加失败");
			}
//		}catch(Exception e){
//			WriteError(response, e.getMessage());
//		}
	}
	
	
	/**
	 * 搜索商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "searchGoods", method = RequestMethod.POST)
	public void searchGoods(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			WriteObject(response, goodsService2.searchGoods(goodsBean,pageBean),pageBean.getTotal());
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 添加商品TAG
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertGoodsTag", method = RequestMethod.POST)
	public void insertGoodsTag(MerchantsAccountBean merchantsAccountBean,TagBean tagBean, HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}

			int num=goodsService2.insertGoodsTag(tagBean);
			if(num>0){
				WriteObject(response, "添加成功");
			}else{
				WriteError(response, "添加失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 修改商品TAG
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateGoodsTag", method = RequestMethod.POST)
	public void updateGoodsTag(MerchantsAccountBean merchantsAccountBean,TagBean tagBean, HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}

			int num=goodsService2.updateGoodsTag(tagBean);
			if(num>0){
				WriteObject(response, "修改成功");
			}else{
				WriteError(response, "修改失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 删除商品Tag
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteGoodsTag", method = RequestMethod.POST)
	public void deleteGoodsTag(MerchantsAccountBean merchantsAccountBean,TagBean tagBean,HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}

			int num=goodsService2.deleteGoodsTag(tagBean);
			if(num>0){
				WriteObject(response, "删除成功");
			}else{
				WriteError(response, "删除失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	
	/**
	 * 获得商品Tag
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsTags", method = RequestMethod.POST)
	public void getGoodsTags(MerchantsAccountBean merchantsAccountBean,TagBean tagBean,PageBean pageBean, HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}

			WriteObject(response, goodsService2.getGoodsTags(tagBean,pageBean),pageBean.getTotal());
			
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 修改商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateGoodsDetail", method = RequestMethod.POST)
	public void updateGoodsDetail(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean, HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
			int num=goodsService2.updateGoodsDetail(goodsBean);
			if(num>0){
				GoodsBean goodsBean2=goodsService.getOneGoodsDetail(goodsBean);
				WriteObject(response, goodsBean2);
			}else{
				WriteError(response, "保存失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 添加商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertGoodsDetail", method = RequestMethod.POST)
	public void insertGoodsDetail(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean, HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}

			String json=request.getParameter("parameters");			
			List<GoodsParameterBean> goodsParameterBeans=new Gson().fromJson(json, new TypeToken<List<GoodsParameterBean>>() {}.getType());
			
			String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".html";	
			String path="/html/goods/";
			writeHtml(request, path+fileName,"产品展示",othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("goods")));

			String sort="";
			if(goodsBean.getSort_time()==null||goodsBean.getSort_time().equals("")){
				sort=TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss");
			}else{
				sort=goodsBean.getSort_time();
			}
			
			int num=goodsService2.insertGoodsDetail(goodsBean
						.setGoods_url( path+"/"+fileName)
						.setSort_time(sort),goodsParameterBeans);
			if(num>0){
				GoodsBean goodsBean2=goodsService.getOneGoodsDetail(goodsBean);
				WriteObject(response, goodsBean2);
			}else{
				WriteError(response, "保存失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 获得商品 根据no
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsByNo", method = RequestMethod.POST)
	public void getGoodsByNo(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean, HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
		
			WriteObject(response, goodsService2.getGoodsByNo(goodsBean));
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 获得参数 根据no
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsParametersByNo", method = RequestMethod.POST)
	public void getGoodsParameters(MerchantsAccountBean merchantsAccountBean,GoodsParameterBean goodsParameterBean, HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
		
			WriteObject(response, goodsService2.getGoodsParametersByNo(goodsParameterBean));
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 删除分类下商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertGoodsParameters", method = RequestMethod.POST)
	public void insertGoodsParameters(MerchantsAccountBean merchantsAccountBean, HttpServletRequest request,
			HttpServletResponse response) {
		try{
			if(!systemService.verToken(merchantsAccountBean)){
				WritePending(response, "token failed");
				return;
			}
		
			String json=request.getParameter("parameters");
			String goods_no=request.getParameter("goods_no");
			
			List<GoodsParameterBean> goodsParameterBeans=new Gson().fromJson(json, new TypeToken<List<GoodsParameterBean>>() {}.getType());
			
			System.out.println(new Gson().toJson(goodsParameterBeans));

			String goods_no1=goodsService2.insertGoodsParameters(goodsParameterBeans,goods_no);
			WriteMsg(response, goods_no1);
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	
	/**
	 * 删除分类下商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteClassGoods", method = RequestMethod.POST)
	public void deleteClassGoods(MerchantsAccountBean merchantsAccountBean,GoodsRelationClassBean goodsRelationClassBean, HttpServletRequest request,
			HttpServletResponse response) {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
	
		int num=goodsService2.deleteClassGoods(goodsRelationClassBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	/**
	 * 添加分类下商品
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertClassGoods", method = RequestMethod.POST)
	public void insertClassGoods(MerchantsAccountBean merchantsAccountBean,GoodsRelationClassBean goodsRelationClassBean, HttpServletRequest request,
			HttpServletResponse response) {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		GoodsRelationClassBean goodsRelationClassBean2=goodsService2.getClassGoodsByClassAndGodosId(goodsRelationClassBean);
		if(goodsRelationClassBean2!=null){
			WriteError(response, "该商品已添加过");
			return;
		}	
		
		int num=goodsService2.insertClassGoods(goodsRelationClassBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	
	/**
	 * 商品分类下商品列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getClassGoods", method = RequestMethod.POST)
	public void getClassGoods(MerchantsAccountBean merchantsAccountBean,
			GoodsBean goodsBean, PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService2.getClassGoods(goodsBean,pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 添加商品分类
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertGoodsClass", method = RequestMethod.POST)
	public void insertGoodsClass(MerchantsAccountBean merchantsAccountBean,GoodsClassBean goodsClassBean, HttpServletRequest request,
			HttpServletResponse response) {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService2.insertGoodsClass(goodsClassBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 修改商品分类
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateGoodsClass", method = RequestMethod.POST)
	public void updateGoodsClass(MerchantsAccountBean merchantsAccountBean,GoodsClassBean goodsClassBean, HttpServletRequest request,
			HttpServletResponse response) {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService2.updateGoodsClass(goodsClassBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	

	/**
	 * 修改商品分类
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateClassExpress", method = RequestMethod.POST)
	public void updateClassExpress(MerchantsAccountBean merchantsAccountBean,GoodsClassBean goodsClassBean, HttpServletRequest request,
			HttpServletResponse response) {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		
		
		int num=goodsService2.updateClassExpress(goodsClassBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 删除商品分类
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteGoodsClass", method = RequestMethod.POST)
	public void deleteGoodsClass(MerchantsAccountBean merchantsAccountBean,GoodsClassBean goodsClassBean, HttpServletRequest request,
			HttpServletResponse response) {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService2.deleteGoodsClass(goodsClassBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	/**
	 * 获得商品分类
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsClasss", method = RequestMethod.POST)
	public void getGoodsClasss(MerchantsAccountBean merchantsAccountBean,
			GoodsClassBean goodsClassBean, PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService2.getGoodsClasss(goodsClassBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 获得商品分类
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsClasssNoPage", method = RequestMethod.POST)
	public void getGoodsClasssNoPage(MerchantsAccountBean merchantsAccountBean,
			GoodsClassBean goodsClassBean, HttpServletRequest request,
			HttpServletResponse response) {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService2.getGoodsClasssNoPage(goodsClassBean));
	}
}

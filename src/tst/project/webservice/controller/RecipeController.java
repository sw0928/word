package tst.project.webservice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.others.HtmlStyleBean;
import tst.project.bean.recipe.RecipeBean;
import tst.project.bean.recipe.RecipeFoodBean;
import tst.project.bean.recipe.RecipeImgBean;
import tst.project.page.PageBean;
import tst.project.service.controller.OthersServiceC;
import tst.project.service.controller.RecipeServiceC;
import tst.project.service.controller.SystemService;
import tst.project.utils.TimeUtils;

@Controller
@RequestMapping("/recipeController.api")
public class RecipeController extends BaseController{
	@Resource
	RecipeServiceC recipeServiceC;
	
	@Resource
	SystemService systemService;
	
	@Resource
	OthersServiceC othersServiceC;
	/**
	 * 添加菜谱的材料
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertRecipeFood", method = RequestMethod.POST)
	public void insertRecipeFood(MerchantsAccountBean merchantsAccountBean,
			RecipeFoodBean recipeFoodBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		int num=recipeServiceC.insertRecipeFood(recipeFoodBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 上传商品图片
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadRecipeFoodImg")
	public void uploadGoodsImg(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/recipe/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
		}else{
			WriteMsg(response, json);
		}
	}	
	
	/**
	 * 修改菜谱的材料
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateRecipeFood", method = RequestMethod.POST)
	public void updateRecipeFood(MerchantsAccountBean merchantsAccountBean,
			RecipeFoodBean recipeFoodBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		int num=recipeServiceC.updateRecipeFood(recipeFoodBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	
	/**
	 * 删除菜谱的材料
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteRecipeFood", method = RequestMethod.POST)
	public void deleteRecipeFood(MerchantsAccountBean merchantsAccountBean,
			RecipeFoodBean recipeFoodBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		int num=recipeServiceC.deleteRecipeFood(recipeFoodBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	/**
	 * 单个菜谱的食谱详情
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getRecipeFoods", method = RequestMethod.POST)
	public void getRecipeFoods(MerchantsAccountBean merchantsAccountBean,
			RecipeFoodBean recipeFoodBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, recipeServiceC.getRecipeFoods(recipeFoodBean.setParent_id("-1")));
	}
	
	/**
	 * 添加菜谱详情
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertRecipe", method = RequestMethod.POST)
	public void insertRecipe(MerchantsAccountBean merchantsAccountBean,RecipeBean recipeBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".html";	
		String path="/html/goods/";
		writeHtml(request, path+fileName,"食谱展示",othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("recipe")));
		
		int num=recipeServiceC.insertRecipe(recipeBean.setRecipe_url(path+"/"+fileName));
		if(num>0){
			WriteObject(response, recipeServiceC.getRecipeDetail(recipeBean));
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 修改菜谱详情
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateRecipe", method = RequestMethod.POST)
	public void updateRecipe(MerchantsAccountBean merchantsAccountBean,RecipeBean recipeBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
	
		int num=recipeServiceC.updateRecipe(recipeBean);
		if(num>0){
			WriteObject(response, recipeServiceC.getRecipeDetail(recipeBean));
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 删除菜谱详情
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteRecipe", method = RequestMethod.POST)
	public void deleteRecipe(MerchantsAccountBean merchantsAccountBean,RecipeBean recipeBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
	
		int num=recipeServiceC.deleteRecipe(recipeBean);
		if(num>0){
			WriteObject(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	/**
	 * 单个菜谱详情
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getRecipeDetail", method = RequestMethod.POST)
	public void getRecipeDetail(MerchantsAccountBean merchantsAccountBean,RecipeBean recipeBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, recipeServiceC.getRecipeDetail(recipeBean));
	}
	
	
	/**
	 * 删除菜谱图片
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteRecipeImg", method = RequestMethod.POST)
	public void deleteRecipeImg(MerchantsAccountBean merchantsAccountBean,RecipeImgBean recipeImgBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, recipeServiceC.deleteRecipeImg(recipeImgBean));
	}

	@RequestMapping(params = "getRecipeUrlHtml")
	public void getGoodsUrlHtml(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request, HttpServletResponse response) {
		String url=request.getParameter("url");
		WriteOnlyMsg(response,  readHtml(request,url));
	}

	@RequestMapping(params = "setRecipeUrlHtml")
	public void setGoodsUrlHtml(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request, HttpServletResponse response) {
		String desc=request.getParameter("desc");
		String url=request.getParameter("url");
		if(writeHtml(request,url,desc,othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("recipe")))){
			WriteMsg(response, "保存成功");
		}else{
			WriteError(response, "保存失败");
		}
	}
	
	/**
	 * 更新菜谱图片
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateRecipeImg", method = RequestMethod.POST)
	public void updateRecipeImg(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		String json=getObjectJson(request, "/images/recipe/");
		
		//MerchantsAccountBean merchantsAccountBean=new Gson().fromJson(json, MerchantsAccountBean.class);
		RecipeImgBean recipeImgBean=new Gson().fromJson(json, RecipeImgBean.class);
		
//		if(!systemService.verToken(merchantsAccountBean)){
//			WritePending(response, "token failed");
//			return;
//		}
		
		int num=recipeServiceC.updateRecipeImg(recipeImgBean);
		if(num>0){
			WriteObject(response, recipeImgBean);
		}else{
			WriteError(response, "上传失败");
		}
	}
	
	/**
	 * 获得菜谱列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getRecipes", method = RequestMethod.POST)
	public void getRecipes(MerchantsAccountBean merchantsAccountBean,RecipeBean recipeBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, recipeServiceC.getRecipes(recipeBean, pageBean),pageBean.getTotal());
	}
	
	/**
	 * 获得菜谱图片列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getRecipeImgs", method = RequestMethod.POST)
	public void getRecipeImgs(MerchantsAccountBean merchantsAccountBean,
			RecipeImgBean recipeImgBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, recipeServiceC.getRecipeImgs(recipeImgBean));
	}
	
	/**
	 * 上传菜谱图片
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadRecipeImg", method = RequestMethod.POST)
	public void uploadRecipeImg(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String json=getObjectJson(request, "/images/recipe/");
		
		//MerchantsAccountBean merchantsAccountBean=new Gson().fromJson(json, MerchantsAccountBean.class);
		RecipeImgBean recipeImgBean=new Gson().fromJson(json, RecipeImgBean.class);
		
//		if(!systemService.verToken(merchantsAccountBean)){
//			WritePending(response, "token failed");
//			return;
//		}
		
		int num=recipeServiceC.insertRecipeImg(recipeImgBean);
		if(num>0){
			WriteObject(response, recipeImgBean);
		}else{
			WriteError(response, "上传失败");
		}
	}
	
}

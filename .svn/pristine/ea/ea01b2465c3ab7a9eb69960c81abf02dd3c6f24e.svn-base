package tst.project.webservice.interfaces;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tst.project.bean.others.CodeBean;
import tst.project.bean.recipe.RecipeBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.RecipeService;
import tst.project.webservice.controller.BaseController;

/**
 *食谱接口
 * @author shenjiabo
 */

@Controller
@RequestMapping("/recipeInterfaces.api")
public class RecipeInterfaces extends BaseController{
	@Resource
	RecipeService recipeService;
	/**
	 * 获得菜谱列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getRecipes", method = RequestMethod.POST)
	public void getRecipes(RecipeBean recipeBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		WriteObject(response, recipeService.getRecipes(recipeBean, pageBean));
	}
	
	/**
	 * 获得菜谱详情
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneRecipeDetail", method = RequestMethod.POST)
	public void getOneRecipeDetail(RecipeBean recipeBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		RecipeBean recipeBean2=recipeService.getOneRecipeDetail(recipeBean);
		String repice_url_desc=readHtml(request, recipeBean2.getRecipe_url());
		recipeBean2.setRecipe_url_desc(repice_url_desc);
		WriteObject(response, recipeBean2);
	}
}

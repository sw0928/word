package tst.project.service.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.recipe.RecipeBean;
import tst.project.bean.recipe.RecipeFoodBean;
import tst.project.bean.recipe.RecipeImgBean;
import tst.project.dao.controller.RecipeDaoC;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class RecipeServiceC {
	@Resource
	RecipeDaoC recipeDaoC;
	
	/**
	 * 添加菜谱的材料
	 * @param recipeFoodBean
	 * @return
	 */
	public int insertRecipeFood(RecipeFoodBean recipeFoodBean){
		return recipeDaoC.insertRecipeFood(recipeFoodBean);
	}
	
	/**
	 * 修改菜谱的材料
	 * @param recipeFoodBean
	 * @return
	 */
	public int updateRecipeFood(RecipeFoodBean recipeFoodBean){
		return recipeDaoC.updateRecipeFood(recipeFoodBean);
	}
	
	/**
	 * 删除菜谱的材料
	 * @param recipeFoodBean
	 * @return
	 */
	public int deleteRecipeFood(RecipeFoodBean recipeFoodBean){
		return recipeDaoC.deleteRecipeFood(recipeFoodBean);
	}
	
	/**
	 * 添加菜谱详情
	 * @param recipeBean
	 * @return
	 */
	public int insertRecipe(RecipeBean recipeBean){
		return recipeDaoC.insertRecipe(recipeBean);
	}
	
	/**
	 * 修改菜谱详情
	 * @param recipeBean
	 * @return
	 */
	public int updateRecipe(RecipeBean recipeBean){
		return recipeDaoC.updateRecipe(recipeBean);
	}
	/**
	 * 删除菜谱详情
	 * @param recipeBean
	 * @return
	 */
	public int deleteRecipe(RecipeBean recipeBean){
		return recipeDaoC.deleteRecipe(recipeBean);
	}
	
	
	/**
	 * 单个菜谱详情
	 * @param recipeBean
	 * @return
	 */
	public RecipeBean getRecipeDetail(RecipeBean recipeBean){
		return recipeDaoC.getRecipeDetail(recipeBean);
	}
	/**
	 * 删除食谱图片
	 * @param recipeImgBean
	 * @return
	 */
	public int deleteRecipeImg(RecipeImgBean recipeImgBean){
		return recipeDaoC.deleteRecipeImg(recipeImgBean);
	}
	
	/**
	 * 修改食谱图片
	 * @param recipeImgBean
	 * @return
	 */
	public int updateRecipeImg(RecipeImgBean recipeImgBean){
		return recipeDaoC.updateRecipeImg(recipeImgBean);
	}
	
	/**
	 * 添加食谱图片
	 * @param recipeImgBean
	 * @return
	 */
	public int insertRecipeImg(RecipeImgBean recipeImgBean){
		return recipeDaoC.insertRecipeImg(recipeImgBean);
	}
	
	/**
	 * 美食列表
	 * @param recipeBean
	 * @param pageBean
	 * @return
	 */
	public List<RecipeBean> getRecipes(RecipeBean recipeBean,PageBean pageBean){
		return recipeDaoC.getRecipes(recipeBean, pageBean);
	}
	
	/**
	 * 获得菜谱图片列表
	 * 
	 * @param recipeBean
	 * @return
	 */
	public List<RecipeImgBean> getRecipeImgs(RecipeImgBean recipeImgBean) {
		return recipeDaoC.getRecipeImgs(recipeImgBean);
	}

	/**
	 * 获得菜谱食材列表
	 * 
	 * @param recipeBean
	 * @return
	 */
	public List<RecipeFoodBean> getRecipeFoods(RecipeFoodBean recipeFoodBean) {
		List<RecipeFoodBean> recipeFoodBeans = recipeDaoC.getRecipeFoods(recipeFoodBean);
		if (recipeFoodBeans != null) {
			for (int i = 0; i < recipeFoodBeans.size(); i++) {
				List<RecipeFoodBean> recipeFoodBeans2 = recipeDaoC.getRecipeFoods(
						new RecipeFoodBean().setParent_id(recipeFoodBeans.get(i).getRecipe_food_id() + "")
								.setRecipe_id(recipeFoodBeans.get(i).getRecipe_id()));
				recipeFoodBeans.get(i).setRecipeFoodBeans(recipeFoodBeans2);
			}
		}
		return recipeFoodBeans;
	}
}

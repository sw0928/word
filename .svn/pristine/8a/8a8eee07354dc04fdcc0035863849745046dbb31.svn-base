package tst.project.dao.controller;

import java.util.List;

import tst.project.bean.recipe.RecipeBean;
import tst.project.bean.recipe.RecipeFoodBean;
import tst.project.bean.recipe.RecipeImgBean;
import tst.project.page.PageBean;

public interface RecipeDaoC {

	/**
	 * 添加菜谱的材料
	 * @param recipeFoodBean
	 * @return
	 */
	public int insertRecipeFood(RecipeFoodBean recipeFoodBean);
	
	/**
	 * 修改菜谱的材料
	 * @param recipeFoodBean
	 * @return
	 */
	public int updateRecipeFood(RecipeFoodBean recipeFoodBean);
	
	
	/**
	 * 删除菜谱的材料
	 * @param recipeFoodBean
	 * @return
	 */
	public int deleteRecipeFood(RecipeFoodBean recipeFoodBean);
	
	/**
	 * 添加菜谱详情
	 * @param recipeBean
	 * @return
	 */
	public int insertRecipe(RecipeBean recipeBean);
	
	/**
	 * 修改菜谱详情
	 * @param recipeBean
	 * @return
	 */
	public int updateRecipe(RecipeBean recipeBean);
	/**
	 * 删除菜谱详情
	 * @param recipeBean
	 * @return
	 */
	public int deleteRecipe(RecipeBean recipeBean);
	/**
	 * 单个菜谱详情
	 * @param recipeBean
	 * @return
	 */
	public RecipeBean getRecipeDetail(RecipeBean recipeBean);
	
	/**
	 * 删除食谱图片
	 * @param recipeImgBean
	 * @return
	 */
	public int deleteRecipeImg(RecipeImgBean recipeImgBean);
	
	/**
	 * 修改食谱图片
	 * @param recipeImgBean
	 * @return
	 */
	public int updateRecipeImg(RecipeImgBean recipeImgBean);
	
	/**
	 * 修改食谱图片
	 * @param recipeImgBean
	 * @return
	 */
	public int insertRecipeImg(RecipeImgBean recipeImgBean);
	
	/**
	 * 美食列表
	 * @param recipeBean
	 * @param pageBean
	 * @return
	 */
	public List<RecipeBean> getRecipes(RecipeBean recipeBean,PageBean pageBean);

	/**
	 * 获得菜谱图片列表
	 * @param recipeBean
	 * @return
	 */
	public List<RecipeImgBean> getRecipeImgs(RecipeImgBean recipeBean);
	
	/**
	 * 获得菜谱材料列表
	 * @param recipeBean
	 * @return
	 */
	public List<RecipeFoodBean> getRecipeFoods(RecipeFoodBean recipeFoodBean);
}

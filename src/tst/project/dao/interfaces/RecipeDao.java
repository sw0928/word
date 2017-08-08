package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.recipe.RecipeBean;
import tst.project.bean.recipe.RecipeFoodBean;
import tst.project.bean.recipe.RecipeImgBean;
import tst.project.page.PageBean;

public interface RecipeDao {
	/**
	 * 获得菜谱详情
	 * @param recipeBean
	 * @return
	 */
	public RecipeBean getOneRecipeDetail(RecipeBean recipeBean);
	
	/**
	 * 获得菜谱列表
	 * @param recipeBean
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

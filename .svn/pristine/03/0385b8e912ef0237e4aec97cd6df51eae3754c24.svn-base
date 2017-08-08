package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.recipe.RecipeBean;
import tst.project.bean.recipe.RecipeFoodBean;
import tst.project.bean.recipe.RecipeImgBean;
import tst.project.dao.interfaces.RecipeDao;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class RecipeService {

	@Resource
	RecipeDao recipeDao;

	/**
	 * 获得菜谱详情
	 * 
	 * @param recipeBean
	 * @return
	 */
	public RecipeBean getOneRecipeDetail(RecipeBean recipeBean) {
		RecipeBean recipeBean2 = recipeDao.getOneRecipeDetail(recipeBean);
		if (recipeBean2 != null) {
			List<RecipeImgBean> recipeImgBeans = getRecipeImgs(
					new RecipeImgBean().setRecipe_id(recipeBean2.getRecipe_id() + ""));
			recipeBean2.setRecipeImgBeans(recipeImgBeans);

			List<RecipeFoodBean> recipeFoodBeans = getRecipeFoods(
					new RecipeFoodBean().setRecipe_id(recipeBean2.getRecipe_id() + "").setParent_id("-1"));
			recipeBean2.setRecipeFoodBeans(recipeFoodBeans);
		}
		return recipeBean2;
	}

	/**
	 * 获得菜谱列表
	 * 
	 * @param recipeBean
	 * @return
	 */
	public List<RecipeBean> getRecipes(RecipeBean recipeBean, PageBean pageBean) {
		List<RecipeBean> recipeBeans = recipeDao.getRecipes(recipeBean, pageBean);
		if (recipeBeans != null) {
			for (int i = 0; i < recipeBeans.size(); i++) {
				List<RecipeImgBean> recipeImgBeans = getRecipeImgs(
						new RecipeImgBean().setRecipe_id(recipeBeans.get(i).getRecipe_id() + ""));
				recipeBeans.get(i).setRecipeImgBeans(recipeImgBeans);

				List<RecipeFoodBean> recipeFoodBeans = getRecipeFoods(
						new RecipeFoodBean().setRecipe_id(recipeBeans.get(i).getRecipe_id() + "").setParent_id("-1"));
				recipeBeans.get(i).setRecipeFoodBeans(recipeFoodBeans);
			}
		}
		return recipeBeans;
	}

	/**
	 * 获得菜谱图片列表
	 * 
	 * @param recipeBean
	 * @return
	 */
	public List<RecipeImgBean> getRecipeImgs(RecipeImgBean recipeImgBean) {
		return recipeDao.getRecipeImgs(recipeImgBean);
	}

	/**
	 * 获得菜谱食材列表
	 * 
	 * @param recipeBean
	 * @return
	 */
	public List<RecipeFoodBean> getRecipeFoods(RecipeFoodBean recipeFoodBean) {
		List<RecipeFoodBean> recipeFoodBeans = recipeDao.getRecipeFoods(recipeFoodBean);
		if (recipeFoodBeans != null) {
			for (int i = 0; i < recipeFoodBeans.size(); i++) {
				List<RecipeFoodBean> recipeFoodBeans2 = recipeDao.getRecipeFoods(
						new RecipeFoodBean().setParent_id(recipeFoodBeans.get(i).getRecipe_food_id() + "")
								.setRecipe_id(recipeFoodBeans.get(i).getRecipe_id()));
				recipeFoodBeans.get(i).setRecipeFoodBeans(recipeFoodBeans2);
			}
		}
		return recipeFoodBeans;
	}
}

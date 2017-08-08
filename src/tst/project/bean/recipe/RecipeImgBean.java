package tst.project.bean.recipe;

public class RecipeImgBean {
	private int recipe_img_id;
	private String recipe_id;
	private String recipe_img;
	private String is_delete;
	private String create_time;
	private String sort;
	public int getRecipe_img_id() {
		return recipe_img_id;
	}
	public RecipeImgBean setRecipe_img_id(int recipe_img_id) {
		this.recipe_img_id = recipe_img_id;
		return this;
	}
	public String getRecipe_id() {
		return recipe_id;
	}
	public RecipeImgBean setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
		return this;
	}
	public String getRecipe_img() {
		return recipe_img;
	}
	public RecipeImgBean setRecipe_img(String recipe_img) {
		this.recipe_img = recipe_img;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public RecipeImgBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public RecipeImgBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public RecipeImgBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	
	
}

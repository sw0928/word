package tst.project.bean.recipe;

import java.util.List;

public class RecipeFoodBean {
	private int recipe_food_id;
	private String recipe_id;
	private String food_name;
	private String food_img;
	private String create_time;
	private String is_delete;
	private String parent_id;
	private String food_count;
	private List<RecipeFoodBean> recipeFoodBeans;
	

	
	public String getFood_count() {
		return food_count;
	}
	public RecipeFoodBean setFood_count(String food_count) {
		this.food_count = food_count;
		return this;
	}
	public List<RecipeFoodBean> getRecipeFoodBeans() {
		return recipeFoodBeans;
	}
	public RecipeFoodBean setRecipeFoodBeans(List<RecipeFoodBean> recipeFoodBeans) {
		this.recipeFoodBeans = recipeFoodBeans;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public RecipeFoodBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public int getRecipe_food_id() {
		return recipe_food_id;
	}
	public RecipeFoodBean setRecipe_food_id(int recipe_food_id) {
		this.recipe_food_id = recipe_food_id;
		return this;
	}
	public String getRecipe_id() {
		return recipe_id;
	}
	public RecipeFoodBean setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
		return this;
	}
	public String getFood_name() {
		return food_name;
	}
	public RecipeFoodBean setFood_name(String food_name) {
		this.food_name = food_name;
		return this;
	}
	public String getFood_img() {
		return food_img;
	}
	public RecipeFoodBean setFood_img(String food_img) {
		this.food_img = food_img;
		return this;
	}
	
	public String getCreate_time() {
		return create_time;
	}
	public RecipeFoodBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public RecipeFoodBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	
}

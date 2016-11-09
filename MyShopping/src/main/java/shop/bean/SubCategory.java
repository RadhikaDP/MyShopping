package shop.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class SubCategory {
	private int id;
	@NotEmpty(message="category cannot be empty")
	private String category;
	@NotEmpty(message="subcategory cannot be empty")
	private String subcategory;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
}

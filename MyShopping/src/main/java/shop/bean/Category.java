package shop.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class Category {
	private int id;
	@NotEmpty

	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

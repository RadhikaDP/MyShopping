package shop.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class Product {
	private int id;
	@NotEmpty(message="subcategory cannot be empty")
	private String subcategory;
	@NotEmpty(message="productname cannot be empty")
	private String productname;
	@NotEmpty(message="productbrand cannot be empty")
	private String productbrand;
	private double price;
	@NotEmpty(message="description cannot be empty")
	private String description;
	private int subid;
	@NotEmpty(message="subcategory cannot be empty")
	private String category;
	@NotEmpty(message="subcategory cannot be empty")
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductbrand() {
		return productbrand;
	}
	public void setProductbrand(String productbrand) {
		this.productbrand = productbrand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
	
}

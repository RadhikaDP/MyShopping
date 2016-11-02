package shop.service;

import java.util.List;
import shop.bean.Category;

public interface CategoryService {
	public List<Category> getUserList();
	public Category getcategoryId(int id);
	public int delete(int id);
	public int update(Category c);
	public int save(Category cat);

}

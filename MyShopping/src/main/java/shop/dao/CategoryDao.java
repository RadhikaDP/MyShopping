package shop.dao;

import java.util.List;
import shop.bean.*;

public interface CategoryDao {
	public List<Category> getUserList();
	public Category getcategoryId(int id);
	public int delete(int id);
	public int update(Category c);
	public int save(Category cat);

}

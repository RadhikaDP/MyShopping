package shop.dao;

import java.util.List;
import shop.bean.*;

public interface SubCategoryDao {
	public List<SubCategory> getList();
	public SubCategory getsubcategoryId(int id);
	public int delete(int id);
	public int update(SubCategory c);
	public int save(SubCategory cat);
}

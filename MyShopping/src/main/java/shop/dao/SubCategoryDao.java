package shop.dao;

import java.util.List;
import shop.bean.*;

public interface SubCategoryDao {
	public List<SubCategory> getList();
	public List<String> getcategoryList();
	public List<String> getallcategory();
	public List<String> getcatofsub();
	public SubCategory getsubcategoryId(int id);
	public int delete(int id);
	public int update(SubCategory c);
	public int save(SubCategory cat,String category,String subcategory);

}

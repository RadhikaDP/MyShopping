package shop.dao;

import java.util.List;

import shop.bean.SubCategory2;

public interface SubCategory2Dao {
	public List<SubCategory2> getList();
	public SubCategory2 getsubcategory2Id(int id);
	public int delete(int id);
	public int update(SubCategory2 c);
	public int save(SubCategory2 cat);

}

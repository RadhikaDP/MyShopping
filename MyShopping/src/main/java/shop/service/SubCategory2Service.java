package shop.service;

import java.util.List;
import shop.bean.SubCategory2;

public interface SubCategory2Service {
	public List<SubCategory2> getList();
	public SubCategory2 getsubcategoryId(int id);
	public int delete(int id);
	public int update(SubCategory2 c);
	public int save(SubCategory2 cat);


}

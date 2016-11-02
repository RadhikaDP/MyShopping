package shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.SubCategory;
import shop.bean.SubCategory2;
import shop.dao.SubCategory2Dao;
import shop.service.SubCategory2Service;

public class SubCategory2ServiceImpl implements SubCategory2Service{
	@Autowired
	private SubCategory2Dao sub2Dao2;

	@Override
	public List<SubCategory2> getList() {
		// TODO Auto-generated method stub
		return sub2Dao2.getList();
	}

	@Override
	public SubCategory2 getsubcategoryId(int id) {
		// TODO Auto-generated method stub
		return sub2Dao2.getsubcategory2Id(id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return sub2Dao2.delete(id);
	}

	@Override
	public int update(SubCategory2 c) {
		// TODO Auto-generated method stub
		return sub2Dao2.update(c);
	}

	@Override
	public int save(SubCategory2 cat) {
		// TODO Auto-generated method stub
		return sub2Dao2.save(cat);
	}



}

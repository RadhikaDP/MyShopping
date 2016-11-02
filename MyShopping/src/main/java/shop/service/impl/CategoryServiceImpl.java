package shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.Category;
import shop.dao.CategoryDao;
import shop.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao catDao;
	@Override
	public List<Category> getUserList() {
		return catDao.getUserList();
		
	}
	@Override
	public Category getcategoryId(int id) {
		
		return catDao.getcategoryId(id);
	}
	@Override
	public int delete(int id) {
		
		return catDao.delete(id);
	}
	@Override
	public int update(Category c) {
	
		return catDao.update(c);
	}
	@Override
	public int save(Category cat) {
		return catDao.save(cat);
	}


}

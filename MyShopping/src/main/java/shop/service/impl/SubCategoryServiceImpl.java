package shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.SubCategory;
import shop.dao.SubCategoryDao;
import shop.service.SubCategoryService;

public class SubCategoryServiceImpl implements SubCategoryService{
	@Autowired
	private SubCategoryDao subDao;
	@Override
	public List<SubCategory> getList() {
		return subDao.getList();
	}

	@Override
	public SubCategory getsubcategoryId(int id) {
		return subDao.getsubcategoryId(id);
	}

	@Override
	public int delete(int id) {
		return subDao.delete(id);
	}

	@Override
	public int update(SubCategory c) {
		return subDao.update(c);
	}

	@Override
	public int save(SubCategory cat,String category,String subcategory) {
		return subDao.save(cat,category,subcategory);
	}

	@Override
	public List<String> getcategoryList() {
		return subDao.getcategoryList();
	}

	@Override
	public List<String> getallcategory() {

		return subDao.getallcategory();
	}

	@Override
	public List<String> getcatofsub() {
		
		return subDao.getcatofsub();
	}



}

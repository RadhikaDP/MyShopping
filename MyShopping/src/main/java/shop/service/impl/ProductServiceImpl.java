package shop.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.Product;
import shop.bean.SubCategory2;
import shop.dao.ProductDao;
import shop.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getList() {
		return productDao.getList();
	}

	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	public int delete(int id) {
		return productDao.delete(id);
	}

	@Override
	public int update(Product c) {
		return productDao.update(c);
	}

	@Override
	public int save(Product c) {
		return productDao.save(c);
	}

	@Override
	public List<Product> getProductList(int id) {
		// TODO enerated method stub
		return productDao.getProductList(id);
	}

	

}

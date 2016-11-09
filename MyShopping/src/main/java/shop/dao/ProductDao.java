package shop.dao;

import java.util.List;

import shop.bean.Product;
import shop.bean.SubCategory2;



public interface ProductDao {
	public List<Product> getList();
	public Product getProductById(int id);
	public int delete(int id);
	public int update(Product c);
	public int save(Product c);
	public List<Product> getProductList(String id);
}

package shop.service;

import java.util.List;
import shop.bean.Product;
import shop.bean.SubCategory2;

public interface ProductService {
	public List<Product> getList();
	public Product getProductById(int id);
	public int delete(int id);
	public int update(Product c);
	public int save(Product c);
	public List<Product> getProductList(int id);
	public List<Product> getbysubname(String id);

	
}

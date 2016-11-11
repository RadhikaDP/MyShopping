package shop.dao;

import java.util.List;
import shop.bean.Cart;



public interface CartDao {

	public int delete(int id);
	public List<Cart> getCartproducts(String username);
	int save(int proid, String username, String proname);

}

package shop.dao;

import java.util.List;

import shop.bean.Cart;


public interface CartDao {

	public int delete(int id);
	public List<Cart> getCartproducts(int id);
	public int save(int proid, int userid);
}

package shop.service;

import java.util.List;

import shop.bean.Cart;
import shop.bean.Users;

public interface CartService {
	public int delete(int id);
	public List<Cart> getCartproducts(String username);
	public int save(int proid, String username,String proname);

}

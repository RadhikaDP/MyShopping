package shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.Cart;
import shop.dao.CartDao;
import shop.service.CartService;

public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cartDao;


	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return cartDao.delete(id);
	}

	@Override
	public List<Cart> getCartproducts(int id) {
		// TODO Auto-generated method stub
		return cartDao.getCartproducts(id);
	}

	@Override
	public int save(int proid, int userid) {
		return cartDao.save(proid, userid);
		
	}

}

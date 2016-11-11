package shop.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.Address;
import shop.bean.Order;

import shop.dao.OrderDao;
import shop.service.OrderService;

public class OrderServiceDaoImpl implements OrderService{
	@Autowired
private OrderDao orderDao;
	@Override
	public List<Order> getOrders(String username) {

		return orderDao.getOrders(username);
	}
	@Override
	public int Addorder(String proname, String username, int quantity, BigDecimal total) {
		
		return orderDao.Addorder(proname, username, quantity, total);
	}
	@Override
	public int addAddress(Address ad) {
		
		return orderDao.addAddress( ad);
	}
	@Override
	public int cancelorder(int id) {
		
		return orderDao.cancelorder(id);
	}


}

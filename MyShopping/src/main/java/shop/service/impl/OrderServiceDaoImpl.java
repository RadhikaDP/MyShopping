package shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.Order;

import shop.dao.OrderDao;
import shop.service.OrderService;

public class OrderServiceDaoImpl implements OrderService{
	@Autowired
private OrderDao order;
	@Override
	public List<Order> getOrders() {

		return order.getOrders();
	}

}

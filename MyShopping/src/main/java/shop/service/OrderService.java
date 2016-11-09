package shop.service;

import java.util.List;

import shop.bean.Address;
import shop.bean.Order;

public interface OrderService {
	public List<Order> getOrders(String username);
	public int Addorder(String proname,String username,int quantity,double total);
	public int addAddress(Address ad);
	public int cancelorder(int id);
}

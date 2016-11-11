package shop.dao;

import java.math.BigDecimal;
import java.util.List;

import shop.bean.Address;
import shop.bean.Order;



public interface OrderDao {
	
	public int Addorder(String proname,String username,int quantity,BigDecimal total);
	public int addAddress(Address ad);
	public List<Order> getOrders(String username);
	public int cancelorder(int id);
}

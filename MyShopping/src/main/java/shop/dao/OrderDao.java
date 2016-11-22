package shop.dao;

import java.math.BigDecimal;
import java.util.List;

import shop.bean.Address;
import shop.bean.Order;
import shop.bean.Product;



public interface OrderDao {
	
	public int Addorder(String proname,String username,int quantity,BigDecimal total);
	public int addAddress(Address ad,int orderid);
	public List<Order> getOrders(String username);
	public int cancelorder(int id, String proname, int quantity);
}

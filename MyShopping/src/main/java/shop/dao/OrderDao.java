package shop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import shop.bean.Address;
import shop.bean.Order;
import shop.dao.OrderDao;

public class OrderDaoImp implements OrderDao{
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}

	@Override
	public int Addorder(String proname, String username, int quantity, double total) {
		
		String sql="insert into public.order(username,total,quantity,proname) values('"+username+"',"+  total+","+ quantity +",'"+ proname +"')";  
	    return template.update(sql); 
		
	}
	@Override
	public int addAddress(Address ad) {
		String sql="insert into public.address(flatno,locality,town,state,pincode) values('"+ad.getFlatno()+"','"+  ad.getLocality()+"','"+ ad.getTown() +"','"+ ad.getState() +"','"+ad.getPincode()+"')";  
	    return template.update(sql); 
		
	}
	@Override
	public List<Order> getOrders(String username) {
		  return template.query("select * from public.order where username='"+username+"'",new RowMapper<Order>(){  
		        public Order mapRow(ResultSet rs, int row) throws SQLException {  
		          Order e=new Order();  
		            e.setId(rs.getInt(1));  
		            e.setProductname(rs.getString(5));
		            e.setUsername(rs.getString(2));  
		            e.setTotal(rs.getDouble(3)); 
		            e.setQuantity(rs.getInt(4));
		            return e;  
		        }  
		    }); 
	}
}


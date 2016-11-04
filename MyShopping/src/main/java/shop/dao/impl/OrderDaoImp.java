package shop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import shop.bean.Order;
import shop.dao.OrderDao;

public class OrderDaoImp implements OrderDao{
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}
	@Override
	public List<Order> getOrders() {
		 
			    return template.query("select * from public.order",new RowMapper<Order>(){  
			        public Order mapRow(ResultSet rs, int row) throws SQLException {  
			        	Order e=new Order();  
			            e.setProductid(rs.getInt(1));  
			            e.setUsername(rs.getInt(3)); 
			            e.setOrderid(rs.getInt(2)); 
			            return e;  
			        }  
			    });
	
			    
}
}

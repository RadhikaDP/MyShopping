package shop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import shop.bean.Cart;
import shop.dao.CartDao;

public class CartDaoImp implements CartDao{
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}


	@Override
	public int delete(int id) {
	    String sql="delete from public.cart where id="+id+"";  
	    return template.update(sql);  
	}

	@Override
	public List<Cart> getCartproducts(int id) {
		  return template.query("select * from public.cart where cartid="+id,new RowMapper<Cart>(){  
		        public Cart mapRow(ResultSet rs, int row) throws SQLException {  
		          Cart e=new Cart();  
		            e.setCartid(rs.getInt(1));  
		            e.setCustomerid(rs.getInt(2));  
		            e.setProductid(rs.getInt(3)); 
		            return e;  
		        }  
		    }); 
	}
	@Override
	public int save(int proid, int userid) {
		 String sql="insert into public.cart(customerid,productid) values("+userid+","+proid+")";  
		    return template.update(sql); 
		
	}

}

package shop.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import shop.bean.Cart;
import shop.bean.Users;
import shop.dao.CartDao;
import shop.validate.AESCrypt;
import shop.validate.WarningMsg;

public class CartDaoImp implements CartDao{
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}

	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public int delete(int id) {
	    String sql="delete from public.cart where cartid="+id+"";  
	    return template.update(sql);  
	}

	@Override
	public List<Cart> getCartproducts(String username) {
		  return template.query("select * from public.cart where username='"+username+"'",new RowMapper<Cart>(){  
		        public Cart mapRow(ResultSet rs, int row) throws SQLException {  
		          Cart e=new Cart();  
		            e.setCartid(rs.getInt(1));  
		            e.setUsername(rs.getString(3));  
		            e.setProductid(rs.getInt(2)); 
		            e.setProductname(rs.getString(4));
		            return e;  
		        }  
		    }); 
	}
	@Override
	public int save(int proid, String username,String proname) {
		
		boolean check= checkexistance(proid,username);
		if(check==true){
			String msg="Already added to cart";
			WarningMsg.showDialog(msg);
			return 0 ;
		}
		 String sql="insert into public.cart(username,productid,productname) values('"+username+"',"+proid+",'"+proname+"')";  
		 String msg1="Successfully Added to cart";
		 WarningMsg.showDialog(msg1);
		    return template.update(sql); 

		
	}

   public boolean checkexistance(int proid,String username){

		boolean b=false;
		try{

			String query = " select username from cart where productid = ? and username = ? ";
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1, proid);
			pstmt.setString(2, username);	
			
		ResultSet count=pstmt.executeQuery();
		
		int size=0;
		 try {
		        while(count.next()){
		            size++;
		        }
		    }
		 catch(Exception ex) {
			    return false;
			}
		
		if(size==1){
			b=true;
		}
		else {
			b=false;
		}
		
		}

	catch ( Exception e) {
		e.printStackTrace();
	}
		return b;
		
	
	   

   }



}

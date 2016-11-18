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
import shop.dao.CartDao;
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
	/**
	 * 
	 * @param dataSource : database connection details are passed to datasource.
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
/**
 * delete() method : cart details are deleted with given id.
 * @param id : cart id 
 */
	@Override
	public int delete(int id) {
	    String sql="delete from public.cart where cartid="+id+"";  
	    return template.update(sql);  
	}
/**
 * getCartproducts() : returns collection of Cart of loged user 
 */
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
	/**
	 * save() method : checkexistance() method is called to check whether product already exists in cart ,If product does not exists in cart saves username, product id , product name into database.
	 * @param username : username of loged user.
	 * @param proname : name of the product to insert into cart.
	 * @param proid : product id 
	 */
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
/**
 * checkexistance() method ; takes two parameters username and product id to check whether product exist in cart.
 * @param proid : product id
 * @param username : username of loged user.
 * @return
 */
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
		}

	catch ( Exception e) {
		e.printStackTrace();
	}
		return b;
		
	
	   

   }



}

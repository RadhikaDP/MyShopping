package shop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import shop.bean.Product;
import shop.dao.ProductDao;

public class ProductDaoImp implements ProductDao {
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}
	@Override
	public List<Product> getList() {
	    return template.query("select * from public.products",new RowMapper<Product>(){  
	        public Product mapRow(ResultSet rs, int row) throws SQLException {  
	        	Product e=new Product();  
	            e.setId(rs.getInt(1));  
	            e.setSubcategory(rs.getString(6));
	            e.setProductname(rs.getString(2)); 	 
	            e.setProductbrand(rs.getString(3));
	            e.setPrice(rs.getDouble(4));
	            e.setDescription(rs.getString(5));
	            e.setSubid(rs.getInt(7));
		           e.setCategory(rs.getString(8));
	            return e;  
	        }  
	    });
	}

	@Override
	public Product getProductById(int id) {
		 String sql="select * from public.products where id=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Product>(Product.class));  
	}

	@Override
	public int delete(int id) {
	    String sql="delete from public.products where id="+id+"";  
	    return template.update(sql); 
	}

	@Override
	public int update(Product c) {
	    String sql="update public.products set subcategory='"+c.getSubcategory()+"',productname='"+c.getProductname()+"',productbrand='"+c.getProductbrand()+"',price='"+c.getPrice()+"',description='"+c.getDescription()+"' where id="+c.getId()+"";  
	    return template.update(sql); 
	}

	@Override
	public int save(Product c) {
		String sub,cat;
		sub=c.getSubcategory();
		cat= c.getCategory();
		int subid=getsubid(cat,sub);
		System.out.println(subid);
	    String sql="insert into public.products(subcategory,productname,productbrand,price,description,subid,category) values('"+c.getSubcategory() +"','"+  c.getProductname()+"','"+   c.getProductbrand() +"','"+  c.getPrice() +"','"+  c.getDescription() +"',"+c.getSubid()+",'"+c.getCategory() +"')";  
	    return template.update(sql); 
	}
	
	public int getsubid(String cat,String sub){
		String sql="select id from subcategory where category='"+cat+"' and subcategory='"+sub+"'";
		return template.update(sql);
	}
	
	
	public List<Product> getProductList(int id) {
		String sql="select * from public.products where subid='"+id+"'";
	    return template.query(sql,new RowMapper<Product>(){  
	        public Product mapRow(ResultSet rs, int row) throws SQLException {  
	            Product e=new Product();  
	           e.setId(rs.getInt(1));   
	           e.setSubcategory(rs.getString(6));
	           e.setProductname(rs.getString(2));
	           e.setProductbrand(rs.getString(3));
	           e.setPrice(rs.getDouble(4));
	           e.setDescription(rs.getString(5));
	           e.setSubid(rs.getInt(7));
	           e.setCategory(rs.getString(8));
	            return e;  
	        }  
	    });
	}

	public List<Product> getbysubname(String id) {
		String sql="select * from public.products where subcategory='"+id+"'";
	    return template.query(sql,new RowMapper<Product>(){  
	        public Product mapRow(ResultSet rs, int row) throws SQLException {  
	            Product e=new Product();  
	           e.setId(rs.getInt(1));   
	           e.setSubcategory(rs.getString(6));
	           e.setProductname(rs.getString(2));
	           e.setProductbrand(rs.getString(3));
	           e.setPrice(rs.getDouble(4));
	           e.setDescription(rs.getString(5));
	           e.setSubid(rs.getInt(7));
	           e.setCategory(rs.getString(8));
	            return e;  
	        }  
	    });
	}

	
}

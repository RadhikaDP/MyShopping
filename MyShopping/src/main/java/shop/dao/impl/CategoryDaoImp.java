package shop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import shop.bean.Category;
import shop.dao.CategoryDao;

public class CategoryDaoImp implements CategoryDao{
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}

	@Override
	public List<Category> getUserList() {
		
			
	    return template.query("select * from public.category",new RowMapper<Category>(){  
	        public Category mapRow(ResultSet rs, int row) throws SQLException {  
	            Category e=new Category();  
	            e.setId(rs.getInt(1));  
	            e.setCategory(rs.getString(2));  	           
	            return e;  
	        }  
	    });  
		
	}

	@Override
	public Category getcategoryId(int id) {
		
		 String sql="select * from public.category where id=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Category>(Category.class));  
	}
	@Override
	public int delete(int id) {
	    String sql="delete from public.category where id="+id+"";  
	    return template.update(sql);  
	}

	@Override
	public int update(Category c) {
	    String sql="update public.category set category='"+c.getCategory()+"' where id="+c.getId()+"";  
	    return template.update(sql);  
	}

	@Override
	public int save(Category cat) {
	    String sql="insert into public.category(category) values('"+cat.getCategory()+"')";  
	    return template.update(sql); 
	}

}

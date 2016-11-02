package shop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import shop.bean.SubCategory;
import shop.dao.SubCategoryDao;

public class SubCategoryDaoImp implements SubCategoryDao {
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}
	@Override
	public List<SubCategory> getList() {
	    return template.query("select * from public.subcategory",new RowMapper<SubCategory>(){  
	        public SubCategory mapRow(ResultSet rs, int row) throws SQLException {  
	            SubCategory e=new SubCategory();  
	           e.setId(rs.getInt(1));   
	           e.setCategory(rs.getString(2));
	           e.setSubcategory(rs.getString(3));
	            return e;  
	        }  
	    });
	}

	@Override
	public SubCategory getsubcategoryId(int id) {
		 String sql="select * from public.subcategory where id=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<SubCategory>(SubCategory.class)); 
	}

	@Override
	public int delete(int id) {
	    String sql="delete from public.subcategory where id="+id+"";  
	    return template.update(sql);	}

	@Override
	public int update(SubCategory c) {
	    String sql="update public.subcategory set category='"+c.getCategory()+"',subcategory='"+c.getSubcategory()+"' where id="+c.getId()+"";  
	    return template.update(sql); 	}

	@Override
	public int save(SubCategory cat) {
		
	    String sql="insert into public.subcategory(category,subcategory) values('"+cat.getCategory()+"','"+cat.getSubcategory()+"')";  
	    return template.update(sql); 	}

}

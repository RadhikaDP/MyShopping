package shop.dao.impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import shop.bean.SubCategory2;
import shop.dao.SubCategory2Dao;

public class SubCategory2DaoImp implements SubCategory2Dao {
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}
	@Override
	public List<SubCategory2> getList() {
	    return template.query("select * from public.subcategory2",new RowMapper<SubCategory2>(){  
	        public SubCategory2 mapRow(ResultSet rs, int row) throws SQLException {  
	            SubCategory2 e=new SubCategory2();  
	           e.setId(rs.getInt(1));   
	           e.setSubcategory(rs.getString(2));
	           e.setSubcategory2(rs.getString(3));
	            return e;  
	        }  
	    });
	}

	@Override
	public SubCategory2 getsubcategory2Id(int id) {
		 String sql="select * from public.subcategory2 where id=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<SubCategory2>(SubCategory2.class)); 
	
	}

	@Override
	public int delete(int id) {
		  String sql="delete from public.subcategory2 where id="+id+"";  
		    return template.update(sql);
		}

	@Override
	public int update(SubCategory2 c) {
		String sql="update public.subcategory2 set subcategory='"+c.getSubcategory()+"',subcategory2='"+c.getSubcategory2()+"' where id="+c.getId()+"";  
	    return template.update(sql); 
	}

	@Override
	public int save(SubCategory2 cat) {
	    String sql="insert into public.subcategory2(subcategory,subcategory2) values('"+cat.getSubcategory()+"','"+cat.getSubcategory2()+"')";  
	    return template.update(sql);
	}


}

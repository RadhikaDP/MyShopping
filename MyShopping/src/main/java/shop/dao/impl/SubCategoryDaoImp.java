package shop.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import shop.bean.SubCategory;
import shop.dao.SubCategoryDao;
import shop.validate.WarningMsg;

public class SubCategoryDaoImp implements SubCategoryDao {
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
	/**
	 * returns Collection of subcategory
	 */
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
/**
 * returns list of all subcategories from subcategory table.
 */
	@Override
	public List<String> getcategoryList() {
	    return template.query("select subcategory from public.subcategory",new RowMapper<String>(){  
	        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
	           return rs.getString(1);
	              
	        }  
	    });
	}
	/**
	 * returns list of all categories from category table.
	 */
	@Override
	public List<String> getallcategory() {
	    return template.query("select category from public.category",new RowMapper<String>(){  
	        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
	           return rs.getString(1);
	              
	        }  
	    });
	}
/**
 * returns subcategory based on id.
 */
	@Override
	public SubCategory getsubcategoryId(int id) {
		 String sql="select * from public.subcategory where id=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<SubCategory>(SubCategory.class)); 
	}
/**
 * deletes subcategory based on id.
 */
	@Override
	public int delete(int id) {
	    String sql="delete from public.subcategory where id="+id+"";  
	    return template.update(sql);	}
/**
 * updates subcategory with new edited values from jsp.
 */
	@Override
	public int update(SubCategory c) {
	    String sql="update public.subcategory set category='"+c.getCategory()+"',subcategory='"+c.getSubcategory()+"' where id="+c.getId()+"";  
	    return template.update(sql); 	}
/**
 * checks combination of category and subcategory  existance if exists then returns back to same page else new category and subcategory will be added
 */
	@Override
	public int save(SubCategory cat,String category,String subcategory) {
		boolean check= checkcatexistance(category,subcategory);
		if(check==true){
			String msg="This subcategory already exist";
			WarningMsg.showDialog(msg);
			return 0 ;
		}
		 String sql="insert into public.subcategory(category,subcategory) values('"+cat.getCategory()+"','"+cat.getSubcategory()+"')";  
		 String msg1="Successfully Added to Subcategory";
		 WarningMsg.showDialog(msg1);
		    return template.update(sql); 
		
		 	}
 	
	    
    public boolean checkcatexistance(String category,String subcategory){

			boolean b=false;
			try{

				String query = " select category from subcategory where category = ? and subcategory = ? ";
				PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
				pstmt.setString(1, category);
				pstmt.setString(2, subcategory);	
				
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
    /**
     * returns category from subcategory
     */
	@Override
	public List<String> getcatofsub() {
		 return template.query("select category from public.subcategory",new RowMapper<String>(){  
		        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
		           return rs.getString(1);
		              
		        }  
		    });
	}

}

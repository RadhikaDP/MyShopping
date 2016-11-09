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
	public List<String> getcategoryList() {
	    return template.query("select subcategory from public.subcategory",new RowMapper<String>(){  
	        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
	           return rs.getString(1);
	              
	        }  
	    });
	}
	
	@Override
	public List<String> getallcategory() {
	    return template.query("select category from public.category",new RowMapper<String>(){  
	        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
	           return rs.getString(1);
	              
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
	@Override
	public List<String> getcatofsub() {
		 return template.query("select category from public.subcategory",new RowMapper<String>(){  
		        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
		           return rs.getString(1);
		              
		        }  
		    });
	}

	@Override
	public List<String> getmensubcat() {
		 return template.query("select subcategory from public.subcategory where category='Men'",new RowMapper<String>(){  
		        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
		           return rs.getString(1);
		              
		        }  
		    });
	}
	@Override
	public List<String> getwomensubcat() {
		 return template.query("select subcategory from public.subcategory where category='Women'",new RowMapper<String>(){  
		        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
		           return rs.getString(1);
		              
		        }  
		    });
	}
	@Override
	public List<String> getbookssubcat() {
		 return template.query("select subcategory from public.subcategory where category='Books'",new RowMapper<String>(){  
		        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
		           return rs.getString(1);
		              
		        }  
		    });
	}
	@Override
	public List<String> getbabysubcat() {
		 return template.query("select subcategory from public.subcategory where category='Baby and Kids'",new RowMapper<String>(){  
		        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
		           return rs.getString(1);
		              
		        }  
		    });
	}
	@Override
	public List<String> getecsubcat() {
		 return template.query("select subcategory from public.subcategory where category='Electronic Devices'",new RowMapper<String>(){  
		        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
		           return rs.getString(1);
		              
		        }  
		    });
	}
}

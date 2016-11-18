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
	
	/**
	 * JdbcTemplate is autowired .
	 * database connection details are passed to datasource and autowired with JdbcTemplate.
	 */
	
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}
    /**
     * getUserList() method : used to get category table .
     */
	@Override
	public List<Category> getUserList() {
		
		  /**
				 * RowMapper interface allows to map a row of the relations with the instance of Category class.
				 *  It iterates the ResultSet internally and adds it into the collection.
		         *   RowMapper adds the data of ResultSet into the Category collection.
		         *   It defines only one method mapRow that accepts ResultSet instance and int as the parameter list
				 */

				
	    return template.query("select * from public.category",new RowMapper<Category>(){  
	        public Category mapRow(ResultSet rs, int row) throws SQLException {  
	            Category e=new Category();  
	            e.setId(rs.getInt(1));  
	            e.setCategory(rs.getString(2));  	           
	            return e;  
	        }  
	    });  
		
	}
	/**
	 * getcategoryId() method : used to get category details based on id.
	 * @param id : represents category id.
	 * @return : Object of type Category with category details.
	 */
	@Override
	public Category getcategoryId(int id) {
		
		 String sql="select * from public.category where id=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Category>(Category.class));  
	}
	/**
	 * delete() method :deletes category row based on id param.
	 * @param id : represents category id.
	 * @return : returns 1 if deletion is successful else returns 0.
	 */
	@Override
	public int delete(int id) {
	    String sql="delete from public.category where id="+id+"";  
	    return template.update(sql);  
	}
	
	/**
	 * update() method : updates category details .
	 * @param c : object of type Category having category details to update.
	 * @return : returns 1 if deletion is successful else returns 0.
	 */

	@Override
	public int update(Category c) {
	    /*String sql="update public.category set category='"+ c.getCategory()+"' where id="+c.getId()+"";  */
		String sql="update public.category set category = ? where id= ? ";  
	    return template.update(sql,c.getCategory(),c.getId()); 
	    
		/*String sql="update public.category set category = :man where id= :woman ";
	    Map<String, Object> param = new HashMap<>();
	    param.put("man", c.getCategory());
	    param.put("woman", c.getId());
	    return template.update(sql,param);*/
	}

	/**
	 * save() method : inserts new category  to database.
	 * @param cat : Object of type Category having category values to insert.
	 */
	@Override
	public int save(Category cat) {
		String sql=null;	
	    sql="insert into public.category(category) values('"+cat.getCategory()+"')";  
	    return template.update(sql); 
	}

}

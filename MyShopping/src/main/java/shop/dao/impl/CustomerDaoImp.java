package shop.dao.impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import shop.bean.Users;
import shop.dao.CustomerDao;
import shop.validate.AESCrypt;

public class CustomerDaoImp implements CustomerDao{
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}
	@Override
	public int save(Users p) throws Exception {
	    String sql="insert into public.user(username,password,email,phone) values('"+p.getUsername()+"','"+AESCrypt.encrypt(p.getPassword())+"','"+p.getEmail()+"','"+p.getPhone()+"')";  
	    return template.update(sql); 
	}

	@Override
	public int update(Users p) {
	    String sql="update public.user set username='"+p.getUsername()+"', email='"+p.getEmail()+"', phone='"+p.getPhone()+"' where id="+p.getId()+"";  
	    return template.update(sql);  
	}

	@Override
	public int delete(int id) {
	    String sql="delete from public.user where id="+id+"";  
	    return template.update(sql);  
	}

	@Override
	public Users getEmpById(int id) {
	    String sql="select * from public.user where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Users>(Users.class));  
	}

	@Override
	public List<Users> getCustomers() {
	    return template.query("select * from public.user",new RowMapper<Users>(){  
	        public Users mapRow(ResultSet rs, int row) throws SQLException {  
	            Users e=new Users();  
	            e.setId(rs.getInt(1));  
	            e.setUsername(rs.getString(2));  
	            e.setEmail(rs.getString(4));  
	            e.setPhone(rs.getString(5));  
	            return e;  
	        }  
	    });  
	}

}

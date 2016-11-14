package shop.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import shop.bean.Users;
import shop.dao.RegDao;
import shop.validate.MD5withsalt;
public class RegDaoImp implements RegDao {
	
	
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}
	/*
	 * database connection details are passed to datasource.
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * isRegSuccesful() method : This method register new user. 
	 * It encripts user password using AES Encription algorithm and  Inserts user details into user table , on success returns true else false.
	 */
	@Override
	public boolean isRegSuccesful(Users regBean)  {

		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		
		boolean b=false;
		try{
			
			
		    String sql="insert into public.user(username,password,email,phone) values('"+regBean.getUsername()+"','"+MD5withsalt.getSecurePassword(regBean.getPassword())+"','"+regBean.getEmail()+"','"+regBean.getPhone()+"')";  
		    int i = template.update(sql);
		
		if(i==1){
			b=true;
			System.out.println(b);
		}
		else {
			b=false;
		}
		
		}
	catch (DuplicateKeyException e) {
		System.out.println("EmailId Already  Exist");
		
			}
	catch (Exception e) {
		e.printStackTrace();
	}
		return b;
		
	}

}

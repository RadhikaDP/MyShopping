package shop.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import shop.bean.Users;
import shop.dao.RegDao;
import shop.validate.MD5withsalt;
import shop.validate.WarningMsg;
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
	 * @throws SQLException 
	 */
	@Override
	public boolean isRegSuccesful(Users regBean) throws SQLException  {

		JdbcTemplate template = new JdbcTemplate(dataSource);
			
		boolean b=false;
		try{
			
			
		    String sql="insert into public.user(username,password,email,phone) values('"+regBean.getUsername()+"','"+MD5withsalt.getSecurePassword(regBean.getPassword())+"','"+regBean.getEmail()+"','"+regBean.getPhone()+"')";  
		    int i = template.update(sql);
		
		if(i==1){
			b=true;
			
		}
		
		
		}
	catch (DuplicateKeyException e) {
		String msg="User already exist ";
		WarningMsg.showDialog(msg);
		
		
			}
	catch (Exception e) {
		e.printStackTrace();
	}
			int userid = getuserid(regBean.getUsername());
			String sql ="insert into public.userroles(userid,roleid) values("+userid+","+ 1 +")";
			template.update(sql);
			
		return b;
		
	}
public int getuserid(String username) throws SQLException{
	String sql1 = "select id from public.user where username ='"+username+"'";
	PreparedStatement pstmt = dataSource.getConnection().prepareStatement(sql1);		
	int userid =0;
		ResultSet result = pstmt.executeQuery();
		while(result.next()){			
			userid = result.getInt(1);								
		}
		return userid;
}
}

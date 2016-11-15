package shop.dao.impl;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import shop.validate.AESCrypt;
import shop.bean.Admin;
import shop.bean.Login;
import shop.dao.AdminDao;


public class AdminDaoImp implements AdminDao{

	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}
	/**
	 * Database connection details are passed to datasource.
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	/**
	 * authenticateUser() method : This method takes username and password from  login page and checks whether username and password exists in database .
	 */
	@Override
	public boolean authenticateUser(Login login) throws SQLException  {
			
		System.out.println(login.getUsername());
		System.out.println(login.getRole());
		System.out.println(login.getPassword());
		boolean b=false;
		try{

			String query = "Select username from admin where username = ? and password = ? ";
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, login.getUsername());
			
			String encryptedPassword = AESCrypt.encrypt(login.getPassword());
			
			pstmt.setString(2, encryptedPassword);			
			
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
			System.out.println(b);
		}
		else {
			b=false;
		}
		
		}

	catch (Exception e) {
		e.printStackTrace();
	}
		return b;
		
	}
	

	
}

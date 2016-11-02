package shop.dao.impl;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import shop.validate.AESCrypt;
import shop.bean.Admin;
import shop.dao.AdminDao;


public class AdminDaoImp implements AdminDao{

	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public boolean authenticateUser(Admin login) throws SQLException  {

		
		
		System.out.println(login.getUsername());
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

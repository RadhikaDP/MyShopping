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
	public boolean authenticateAdmin(Login login) throws SQLException  {

		boolean b=false;
		try{
			String pass=null;
			
			String query = "Select password from admin where username = ? ";
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, login.getUsername());
			
			String encryptedPassword = AESCrypt.encrypt(login.getPassword());			
			ResultSet result=pstmt.executeQuery();
			while(result.next()){
				pass=result.getString(1);
			}
			b=encryptedPassword.equals(pass);
			
			logger.info("admin login successful");
			
		}

	catch (Exception e) {
		e.printStackTrace();
	}
		return b;
		
	}
	

	
}

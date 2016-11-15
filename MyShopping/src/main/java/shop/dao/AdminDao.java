package shop.dao;


import java.sql.SQLException;

import shop.bean.Admin;
import shop.bean.Login;


public interface AdminDao {
	
	public  boolean authenticateUser(Login login) throws SQLException  ;
}

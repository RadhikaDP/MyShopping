package shop.dao;


import java.sql.SQLException;

import shop.bean.Admin;


public interface AdminDao {
	
	public  boolean authenticateUser(Admin login) throws SQLException  ;
}

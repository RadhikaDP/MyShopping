package shop.dao;


import java.sql.SQLException;
import shop.bean.Login;


public interface AdminDao {
	
	public  boolean authenticateAdmin(Login login) throws SQLException  ;
}

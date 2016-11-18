package shop.dao;


import java.sql.SQLException;
import shop.bean.Login;
import shop.bean.Users;

public interface LoginDao {
	
	public  boolean authenticateUser(Login login) throws SQLException  ;

	boolean isActive(String username, Users user) throws SQLException;


	public String getrole(int id) throws SQLException;

}

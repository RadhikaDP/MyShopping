package shop.service;

import java.sql.SQLException;

import shop.bean.Login;
import shop.bean.Users;

public interface LoginService {
	public abstract boolean authenticateUser(Login login) throws SQLException;

	boolean isActive(String username, Users user) throws SQLException;

	public abstract String getrole(int id) throws SQLException;
}

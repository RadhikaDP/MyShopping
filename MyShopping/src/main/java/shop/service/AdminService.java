package shop.service;

import java.sql.SQLException;

import shop.bean.Login;


public interface AdminService {
	public abstract boolean authenticateAdmin(Login login) throws SQLException;
}

package shop.service;

import java.sql.SQLException;

import shop.bean.Admin;
import shop.bean.Login;


public interface AdminService {
	public abstract boolean authenticateUser(Login login) throws SQLException;
}

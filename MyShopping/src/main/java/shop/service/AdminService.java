package shop.service;

import java.sql.SQLException;

import shop.bean.Admin;


public interface AdminService {
	public abstract boolean authenticateUser(Admin login) throws SQLException;
}

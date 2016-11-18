package shop.dao;

import java.sql.SQLException;

import shop.bean.Users;
public interface RegDao {
	public boolean isRegSuccesful(Users regBean) throws SQLException;

	public int getuserid(String username) throws SQLException;
}

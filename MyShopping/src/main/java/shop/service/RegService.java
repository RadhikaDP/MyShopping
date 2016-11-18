package shop.service;

import java.sql.SQLException;

import shop.bean.Users;
public interface RegService {
	public boolean isRegSuccesful(Users regBean) throws SQLException;

	public int getuserid(String username) throws SQLException;
}

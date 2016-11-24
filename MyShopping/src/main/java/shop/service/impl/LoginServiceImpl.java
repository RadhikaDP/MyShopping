package shop.service.impl;


import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.Login;
import shop.bean.Users;
import shop.dao.LoginDao;
import shop.service.LoginService;

public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean authenticateUser(Login login) throws SQLException{	
		return loginDao.authenticateUser(login);
	}
	@Override
	public boolean isActive(String username, Users user) throws SQLException {
		
		return loginDao.isActive(username, user);
	}

	@Override
	public String getrole(int id) throws SQLException {
		return loginDao.getrole(id);
	}


}

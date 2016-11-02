package shop.service.impl;


import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.Admin;
import shop.dao.AdminDao;
import shop.service.AdminService;


public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Override
	public boolean authenticateUser(Admin login) throws SQLException{	
		return adminDao.authenticateUser(login);
	}
}

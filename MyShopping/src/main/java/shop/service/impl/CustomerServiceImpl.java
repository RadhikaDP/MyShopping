package shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.Users;
import shop.dao.CustomerDao;
import shop.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	@Autowired
private CustomerDao custDao;

@Override
public int save(Users p) throws Exception {
	return custDao.save(p);
}

@Override
public int update(Users p) {
	
	return custDao.update(p);	
}

@Override
public int delete(int id) {
	
	return custDao.delete(id);
}

@Override
public Users getEmpById(int id) {

	return custDao.getEmpById(id);
}

@Override
public List<Users> getCustomers() {
	
	return custDao.getCustomers();
}

}

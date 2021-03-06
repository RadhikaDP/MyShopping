package shop.dao;


import java.util.List;

import shop.bean.Users;

public interface CustomerDao {

	public int save(Users p) throws Exception;
	public int update(Users p);
	public int delete(int id);
	public Users getEmpById(int id);
	public List<Users> getCustomers();
}

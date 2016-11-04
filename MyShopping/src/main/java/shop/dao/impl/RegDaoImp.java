package shop.dao.impl;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import shop.bean.Users;
import shop.dao.RegDao;
import shop.validate.AESCrypt;

public class RegDaoImp implements RegDao {
	
	
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public boolean isRegSuccesful(Users regBean)  {

		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		
		boolean b=false;
		try{
			System.out.println(regBean.getUsername());
			
		    String sql="insert into public.user(username,password,email,phone) values('"+regBean.getUsername()+"','"+AESCrypt.encrypt(regBean.getPassword())+"','"+regBean.getEmail()+"','"+regBean.getPhone()+"')";  
		    int i = template.update(sql);
		
		if(i==1){
			b=true;
			System.out.println(b);
		}
		else {
			b=false;
		}
		
		}
	catch (DuplicateKeyException e) {
		System.out.println("EmailId Already  Exist");
		
			}
	catch (Exception e) {
		e.printStackTrace();
	}
		return b;
		
	}

}

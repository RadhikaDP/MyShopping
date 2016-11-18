package shop.dao.impl;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import shop.bean.Login;
import shop.bean.Users;
import shop.dao.LoginDao;
import shop.validate.MD5withsalt;

public class LoginDaoImp implements LoginDao {

	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * authenticateUser() method : checks authentication of user from database.
	 */
	@Override
	public boolean authenticateUser(Login login) throws SQLException {

		boolean b = false;
		
		try {
			String databasepasss;
			String q1="Select password from public.user where username= ?";
			PreparedStatement preparestmt = dataSource.getConnection().prepareStatement(q1);
			preparestmt.setString(1, login.getUsername());
			ResultSet result = preparestmt.executeQuery();
			while(result.next()){
				
				 databasepasss =result.getString(1);

				String arryofstring[] = databasepasss.split(":");
				
				String databasePass = arryofstring[0];
				
				String databaseSalt =arryofstring[1];
								
				byte[] salted =MD5withsalt.fromHex(databaseSalt);
							
				String checkpass=MD5withsalt.checksecurepassword(login.getPassword(),salted);
							
				 b = databasePass.equals(checkpass);
											
			}
			
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return b;

	}

	@Override
	public boolean isActive(String username, Users user) throws SQLException {

		String state = user.getUserState();
		if (state.equals("active")) {
			return true;
		}

		return false;
	}

	@Override
	public String getrole(int id) throws SQLException {
		String sql1 = "select roleid from public.userroles where userid ="+id;
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(sql1);		
		int roleid =0;
		String role = null;
			ResultSet result = pstmt.executeQuery();
			while(result.next()){			
				roleid = result.getInt(1);								
			}
			String sql2 = "select role from public.roles where id ="+roleid;
			 pstmt = dataSource.getConnection().prepareStatement(sql2);
			 result = pstmt.executeQuery();
			while(result.next()){			
				role = result.getString(1);								
			}
			System.out.println(role +"role of user");
		return role;

		
	}

}
package shop.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Users {
	private int id;
	@NotEmpty(message="UserName cannot be empty")
	private String username;
	@NotEmpty(message="Password cannot be empty")
	private String password;
	@Email
	@NotEmpty(message="email cannot be empty")
	private String email;
	@NotEmpty(message="phone cannot be empty")
	private String phone;
	
	String userState="active";
	
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

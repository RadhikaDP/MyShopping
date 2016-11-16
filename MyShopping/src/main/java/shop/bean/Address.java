package shop.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {
	private int orderid;
	@NotEmpty(message="flatno cannot be empty")
private String flatno;
	@NotEmpty(message="locality cannot be empty")
private String locality;
	@NotEmpty(message="town cannot be empty")
private String country;
	@NotEmpty(message="country cannot be empty")
private String town;
	@NotEmpty(message="state cannot be empty")
private String state;
	@NotEmpty(message="pincode cannot be empty")
private String pincode;

	private String productname;
	
public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
public String getFlatno() {
	return flatno;
}
public void setFlatno(String flatno) {
	this.flatno = flatno;
}
public String getLocality() {
	return locality;
}
public void setLocality(String locality) {
	this.locality = locality;
}
public String getTown() {
	return town;
}
public void setTown(String town) {
	this.town = town;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

}

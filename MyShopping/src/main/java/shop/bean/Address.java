package shop.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {
	@NotEmpty(message="flatno cannot be empty")
private String flatno;
	@NotEmpty(message="locality cannot be empty")
private String locality;
	@NotEmpty(message="town cannot be empty")
private String town;
	@NotEmpty(message="state cannot be empty")
private String state;
	@NotEmpty(message="pincode cannot be empty")
private String pincode;
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


}

package shop.bean;

public class Cart {
private int cartid;
private String username;
private int productid;
private String productname;

public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}

}

package shop.bean;

public class Order {
private int orderid;
private int productid;
private int username;
private double total;
private int quantity;


public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public int getUsername() {
	return username;
}
public void setUsername(int username) {
	this.username = username;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}

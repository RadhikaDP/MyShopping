package shop.dao.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import shop.bean.Address;
import shop.bean.Order;
import shop.dao.OrderDao;

public class OrderDaoImp implements OrderDao {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Addorder() inserts username, product name, price and quantity of product
	 * into order table.
	 */
	@Override
	public int Addorder(String proname, String username, int quantity, BigDecimal price) {

		BigDecimal total = calculateCost(quantity, price);

		String sql = "insert into public.order(username,total,quantity,proname) values('" + username + "'," + total
				+ "," + quantity + ",'" + proname + "')";
		 template.update(sql);
		int orderid =0;
		try {
			orderid = getorderid(proname, username, quantity);
			return orderid;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderid;

	}

	// inserts address details into address table.
	@Override
	public int addAddress(Address ad,int orderid) {
		String sql = "insert into public.address(flatno,locality,town,state,pincode,orderid) values('" + ad.getFlatno() + "','"
				+ ad.getLocality() + "','" + ad.getTown() + "','" + ad.getState() + "','" + ad.getPincode() + "',"+orderid+")";
		return template.update(sql);

	}

	/**
	 * getOrders() ; returns collection of orders made by the user.
	 */
	@Override
	public List<Order> getOrders(String username) {
		return template.query("select * from public.order where username='" + username + "'", new RowMapper<Order>() {
			public Order mapRow(ResultSet rs, int row) throws SQLException {
				Order e = new Order();
				e.setId(rs.getInt(1));
				e.setProductname(rs.getString(5));
				e.setUsername(rs.getString(2));
				e.setTotal(rs.getBigDecimal(3));
				e.setQuantity(rs.getInt(4));
				return e;
			}
		});
	}

	/**
	 * deletes order from order table with orderid as id
	 */
	@Override
	public int cancelorder(int id) {
		String sql = "delete from public.order where orderid=" + id + "";
		return template.update(sql);
	}

	public BigDecimal calculateCost(int Quantity, BigDecimal Price) {
		BigDecimal itemCost = BigDecimal.ZERO;
		BigDecimal totalCost = BigDecimal.ZERO;
		itemCost = Price.multiply(new BigDecimal(Quantity));
		totalCost = totalCost.add(itemCost);
		return totalCost;
	}

	private int getorderid(String proname, String username, int quantity) throws SQLException {
		String query = "Select orderid from public.order where proname = ? and username = ? and quantity = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, proname);
		pstmt.setString(2, username);
		pstmt.setInt(3, quantity);
		int a =0;
			ResultSet i = pstmt.executeQuery();
			while(i.next()){
				
				a=	i.getInt(1);				
				return a;	
				
			}
			return a;
	}
}

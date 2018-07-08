package pl.cars.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.cars.util.DbUtil;

public class CustomerDAO {

	private int id;
	private String name;
	private String surName;
	private Date birthDate;
	private int telNumber;

	public CustomerDAO() {

	}

	

	public CustomerDAO(String name, String surName, Date birthDate, int telNumber) {
		super();
		this.name = name;
		this.surName = surName;
		this.birthDate = birthDate;
		this.telNumber = telNumber;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurName() {
		return surName;
	}



	public void setSurName(String surName) {
		this.surName = surName;
	}



	public Date getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	public int getTelNumber() {
		return telNumber;
	}



	public void setTelNumber(int telNumber) {
		this.telNumber = telNumber;
	}



	@Override
	public String toString() {
		return "CustomerDAO [id=" + id + ", name=" + name + ", surName=" + surName + ", birthDate=" + birthDate
				+ ", telNumber=" + telNumber + "]";
	}



	public static List<CustomerDAO> loadAll() {

		String sql = "SELECT * FROM Customer";
		PreparedStatement stmt = null;
		try {
			stmt = DbUtil.getConn().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getCustomersFromStatement(stmt);
	}

	public void customerAdd() {
		try {
			PreparedStatement stmt = DbUtil.getConn()
					.prepareStatement("INSERT INTO Customer " + "(name,surname, birthdate, telnumber) VALUES (?, ?, ?, ?)");
			stmt.setString(1, this.name);
			stmt.setString(2, this.surName);
			stmt.setDate(3, this.birthDate);
			stmt.setInt(4, this.telNumber);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteCustomer(int id) {

		String sql = "DELETE FROM Customer WHERE id = ? ";
		if (id > 0) {
			try {
				PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
				stmt.setInt(1, id);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateCustomer(int id) {

		String sql = "UPDATE Customer SET name=?, surname=?, birthdate=?, telnumber=? WHERE id=?";
		if (id > 0) {
			try {
				PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
				stmt.setString(1, this.name);
				stmt.setString(2, this.surName);
				stmt.setDate(3, this.birthDate);
				stmt.setInt(4, this.telNumber);
				stmt.setInt(5, this.id);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static List<CustomerDAO> getCustomersFromStatement(PreparedStatement stmt) {

		List<CustomerDAO> list = new ArrayList<>();
		ResultSet rs;
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				CustomerDAO customer = new CustomerDAO();
				customer.id = rs.getInt("id");
				customer.name = rs.getString("name");
				customer.surName = rs.getString("surname");
				customer.birthDate = rs.getDate("birthdate");
				customer.telNumber = rs.getInt("telnumber");
				list.add(customer);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}

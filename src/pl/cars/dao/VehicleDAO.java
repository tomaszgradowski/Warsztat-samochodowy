package pl.cars.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.cars.util.DbUtil;

public class VehicleDAO {

	private int id;
	private String model;
	private String brandName;
	private int year;
	private String registrationNumber;
	private Date carReviewDate;
	private int customerId;

	public VehicleDAO() {

	}

	public VehicleDAO(String model, String brandName, int year, String registrationNumber, Date carReviewDate,
			int customerId) {
		super();
		this.model = model;
		this.brandName = brandName;
		this.year = year;
		this.registrationNumber = registrationNumber;
		this.carReviewDate = carReviewDate;
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getCarReviewDate() {
		return carReviewDate;
	}

	public void setCarReviewDate(Date carReviewDate) {
		this.carReviewDate = carReviewDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "VehicleDAO [id=" + id + ", model=" + model + ", brandName=" + brandName + ", year=" + year
				+ ", registrationNumber=" + registrationNumber + ", carReviewDate=" + carReviewDate + ", customerId="
				+ customerId + "]";
	}

	public void vehicleAddToCustomer(int id) {

	}

	public void vehicleAddNoCustomerId() {
		String sql = "INSERT INTO Vehicle (model, brand_name, year, registration_number, car_review_date )  VALUES (?, ?, ?, ?, ?) ";

		try {
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setString(1, this.model);
			stmt.setString(2, this.brandName);
			stmt.setInt(3, this.year);
			stmt.setString(4, this.registrationNumber);
			stmt.setDate(5, this.carReviewDate);
			// stmt.setInt(6, "null");
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void vehicleAdd() {
		String sql = "INSERT INTO Vehicle (model, brand_name, year, registration_number, car_review_date, customer_id )  VALUES (?, ?, ?, ?, ?, ?) ";

		try {
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setString(1, this.model);
			stmt.setString(2, this.brandName);
			stmt.setInt(3, this.year);
			stmt.setString(4, this.registrationNumber);
			stmt.setDate(5, this.carReviewDate);
			stmt.setInt(6, this.customerId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void vehicleUpdate(int id) {
		String sql = "UPDATE Vehicle SET model=?, brand_name=?, year=?, registration_number=?, car_review_date=?, customer_id=? WHERE id = ? ";
		if (id > 0) {
			try {
				PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
				stmt.setString(1, this.model);
				stmt.setString(2, this.brandName);
				stmt.setInt(3, this.year);
				stmt.setString(4, this.registrationNumber);
				stmt.setDate(5, this.carReviewDate);
				stmt.setInt(6, this.customerId);
				stmt.setInt(7, this.id);

				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void vehicleDelete(int id) {
		String sql = "DELETE FROM Vehicle WHERE id = ? ";
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

	public static List<VehicleDAO> showAll() {
		String sql = "SELECT * FROM Vehicle ";
		PreparedStatement stmt = null;
		try {
			stmt = DbUtil.getConn().prepareStatement(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getVehicleFromStatement(stmt);
	}

	public static List<VehicleDAO> customerVehicleShowById(int id) {

		String sql = "SELECT * FROM Vehicle WHERE customer_id = ?";
		PreparedStatement stmt = null;
		try {
			stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, id);
			// stmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getVehicleFromStatement(stmt);
	}

	public static List<VehicleDAO> getVehicleFromStatement(PreparedStatement stmt) {
		List<VehicleDAO> list = new ArrayList<>();
		ResultSet rs;

		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				VehicleDAO vehicle = new VehicleDAO();
				vehicle.id = rs.getInt("id");
				vehicle.brandName = rs.getString("brand_name");
				vehicle.model = rs.getString("model");
				vehicle.year = rs.getInt("year");
				vehicle.registrationNumber = rs.getString("registration_number");
				vehicle.carReviewDate = rs.getDate("car_review_date");
				vehicle.customerId = rs.getInt("customer_id");

				list.add(vehicle);
				// "CREATE TABLE Vehicle (id INT AUTO_INCREMENT, model VARCHAR(255), brand_name
				// VARCHAR(255),"
				// + " year INT, registration_number VARCHAR(255)\n" +
				// ", car_review_date DATE, customer_id INT , PRIMARY KEY (id) , FOREIGN KEY
				// (customer_id) REFERENCES Customer(id));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

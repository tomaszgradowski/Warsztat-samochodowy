package pl.cars.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.cars.util.DbUtil;

public class EmployeeDAO {

	private int id;
	private String name;
	private String surname;
	private String adress;
	private String telNumber;
	private String note;
	private double workHourCosts;

	public EmployeeDAO() {

	}

	public EmployeeDAO(String name, String surname, String adress, String telNumber, String note, double workHourCosts) {
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.telNumber = telNumber;
		this.note = note;
		this.workHourCosts = workHourCosts;

	}

	public void employeeAdd() {
		String sql = "INSERT INTO Employee ( name, surname, adress, tel_number, note, work_hour_costs) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setString(1, this.name);
			stmt.setString(2, this.surname);
			stmt.setString(3, this.adress);
			stmt.setString(4, this.telNumber);
			stmt.setString(5, this.note);
			stmt.setDouble(6, this.workHourCosts);
		
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void employeeUpdate(int id) {
		String sql = "UPDATE Employee SET  name=?, surname=?, adress=?, tel_number=?, note=?, "
				+ "work_hour_costs=? WHERE id = ?";
		try {
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setString(1, this.name);
			stmt.setString(2, this.surname);
			stmt.setString(3, this.adress);
			stmt.setString(4, this.telNumber);
			stmt.setString(5, this.note);
			stmt.setDouble(6, this.workHourCosts);
	
			stmt.setInt(7, this.id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void employeeDelete(int id) {

		String sql = "DELETE FROM Employee WHERE id=? ";
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

	public static List<EmployeeDAO> loadAll() {

		String sql = "SELECT * FROM Employee";
		PreparedStatement stmt = null;
		try {
			stmt = DbUtil.getConn().prepareStatement(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAllEmployees(stmt);
	}

	// id, name, surname, adress, tel_number, note, work_hour_costs, order_id
	public static List<EmployeeDAO> getAllEmployees(PreparedStatement stmt) {
		List<EmployeeDAO> list = new ArrayList<>();
		ResultSet rs;
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				EmployeeDAO employee = new EmployeeDAO();
				employee.id = rs.getInt("id");
				employee.name = rs.getString("name");
				employee.surname = rs.getString("surname");
				employee.adress = rs.getString("adress");
				employee.telNumber = rs.getString("tel_number");
				employee.note = rs.getString("note");
				employee.workHourCosts = rs.getDouble("work_hour_costs");

				list.add(employee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getWorkHourCosts() {
		return workHourCosts;
	}

	public void setWorkHourCosts(double workHourCosts) {
		this.workHourCosts = workHourCosts;
	}

	@Override
	public String toString() {
		return "EmployeeDAO [id=" + id + ", name=" + name + ", surname=" + surname + ", adress=" + adress
				+ ", telNumber=" + telNumber + ", note=" + note + ", workHourCosts=" + workHourCosts + "]";
	}

	


}

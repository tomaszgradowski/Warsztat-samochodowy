package pl.cars.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.cars.util.DbUtil;

public class StatusDAO {

	private int id;
	private String type;
	
	
	public void statusAdd() {
		String sql = "INSERT INTO Status (type) VALUES (?) ";
		try {
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setString(1, this.type);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void statusUpdate(int id) {
		String sql = "UPDATE Status SET  type=? WHERE id=? ";
		try {
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setString(1, this.type);
			stmt.setInt(2, this.id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void statusDelete (int id) {
		String sql = "DELETE FROM Status WHERE id=? ";
		try {
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<StatusDAO> loadAll(){
		String sql = "SELECT * FROM Status ";
		PreparedStatement stmt = null;
		try {
			stmt = DbUtil.getConn().prepareStatement(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAllStatus(stmt);
	}
	
	
	public static List<StatusDAO> getAllStatus(PreparedStatement stmt) {
		List<StatusDAO> list = new ArrayList<>();
		ResultSet rs;
		try {
			rs = stmt.executeQuery();
			while(rs.next()) {
				StatusDAO status = new StatusDAO();
				status.id = rs.getInt("id");
				status.type = rs.getString("type");
				list.add(status);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public StatusDAO() {

	}

	public StatusDAO(String type) {

		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "StatusDAO [id=" + id + ", type=" + type + "]";
	}

}

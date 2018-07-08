package pl.cars.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.cars.util.DbUtil;

public class OrdersDAO {

	// id, repair_date, repair_start_date_planned, repair_start_date, employee_id,
	// problem_description, repair_description,
	// status_id, vehicle_id, repair_costs_for_client, part_costs, work_hour_cost,
	// work_hour_quantity

	private int id;
	private Date repairDate;
	private Date repairStartDatePlanned;
	private Date repairStartDate;
	private int employeeId;
	private String problemDescription;
	private String repairDecription;
	private int statusId;
	private int vehicleId;
	private double repairCostForClient;
	private double partCosts;
	private double workHourCost;
	private double workHourQuantity;

	// id, repair_date, repair_start_date_planned, repair_start_date, employee_id,
	// problem_description, repair_description, status_id, vehicle_id,
	// repair_costs_for_client,
	// part_costs, work_hour_cost, work_hour_quantity

	public void ordersAdd() {
		String sql = "INSERT INTO Orders ( repair_date, repair_start_date_planned, "
				+ "repair_start_date, employee_id, problem_description, repair_description,"
				+ " status_id, vehicle_id, repair_costs_for_client, part_costs,"
				+ " work_hour_cost, work_hour_quantity) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setDate(1, this.repairDate);
			stmt.setDate(2, this.repairStartDatePlanned);
			stmt.setDate(3, this.repairStartDate);
			stmt.setInt(4, this.employeeId);
			stmt.setString(5, this.problemDescription);
			stmt.setString(6, this.repairDecription);
			stmt.setInt(7, this.statusId);
			stmt.setInt(8, this.vehicleId);
			stmt.setDouble(9, this.repairCostForClient);
			stmt.setDouble(10, this.partCosts);
			stmt.setDouble(11, this.workHourCost);
			stmt.setDouble(12, this.workHourQuantity);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ordersUpdate(int id) {
		String sql = "UPDATE Orders SET repair_date=?, " + "repair_start_date_planned=?, repair_start_date=?,"
				+ " employee_id=?, problem_description=?, repair_description=?,"
				+ " status_id=?, vehicle_id=?, repair_costs_for_client=?, part_costs=?, "
				+ "work_hour_cost=?, work_hour_quantity=? WHERE id = ?";
		try {
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setDate(1, this.repairDate);
			stmt.setDate(2, this.repairStartDatePlanned);
			stmt.setDate(3, this.repairStartDate);
			stmt.setInt(4, this.employeeId);
			stmt.setString(5, this.problemDescription);
			stmt.setString(6, this.repairDecription);
			stmt.setInt(7, this.statusId);
			stmt.setInt(8, this.vehicleId);
			stmt.setDouble(9, this.repairCostForClient);
			stmt.setDouble(10, this.partCosts);
			stmt.setDouble(11, this.workHourCost);
			stmt.setDouble(12, this.workHourQuantity);
			stmt.setInt(13, this.id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void OrdersDelete(int id) {
		String sql = "DELETE FROM Orders WHERE id = ?";
		try {
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<OrdersDAO> loadAll() {
		String sql = "SELECT * FROM Orders";
		PreparedStatement stmt = null;
		try {
			stmt = DbUtil.getConn().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAllStatusFromStatement(stmt);
	}

	public static List<OrdersDAO> getAllStatusFromStatement(PreparedStatement stmt) {
		List<OrdersDAO> list = new ArrayList<>();
		ResultSet rs;

		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				OrdersDAO orders = new OrdersDAO();
				orders.id = rs.getInt("id");
				orders.repairDate = rs.getDate("repair_date");
				orders.repairStartDatePlanned = rs.getDate("repair_start_date_planned");
				orders.repairStartDate = rs.getDate("repair_start_date");
				orders.employeeId = rs.getInt("employee_id");
				orders.problemDescription = rs.getString("problem_description");
				orders.repairDecription = rs.getString("repair_description");
				orders.statusId = rs.getInt("status_id");
				orders.vehicleId = rs.getInt("vehicle_id");
				orders.repairCostForClient = rs.getDouble("repair_costs_for_client");
				orders.partCosts = rs.getDouble("part_costs");
				orders.workHourCost = rs.getDouble("work_hour_cost");
				orders.workHourQuantity = rs.getDouble("work_hour_quantity");

				list.add(orders);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public OrdersDAO() {

	}

	public OrdersDAO(Date repairDate, Date repairStartDatePlanned, Date repairStartDate, int employeeId,
			String problemDescription, String repairDecription, int statusId, int vehicleId, double repairCostForClient,
			double partCosts, double workHourCost, double workHourQuantity) {
		super();
		this.repairDate = repairDate;
		this.repairStartDatePlanned = repairStartDatePlanned;
		this.repairStartDate = repairStartDate;
		this.employeeId = employeeId;
		this.problemDescription = problemDescription;
		this.repairDecription = repairDecription;
		this.statusId = statusId;
		this.vehicleId = vehicleId;
		this.repairCostForClient = repairCostForClient;
		this.partCosts = partCosts;
		this.workHourCost = workHourCost;
		this.workHourQuantity = workHourQuantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}

	public Date getRepairStartDatePlanned() {
		return repairStartDatePlanned;
	}

	public void setRepairStartDatePlanned(Date repairStartDatePlanned) {
		this.repairStartDatePlanned = repairStartDatePlanned;
	}

	public Date getRepairStartDate() {
		return repairStartDate;
	}

	public void setRepairStartDate(Date repairStartDate) {
		this.repairStartDate = repairStartDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getRepairDecription() {
		return repairDecription;
	}

	public void setRepairDecription(String repairDecription) {
		this.repairDecription = repairDecription;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public double getRepairCostForClient() {
		return repairCostForClient;
	}

	public void setRepairCostForClient(double repairCostForClient) {
		this.repairCostForClient = repairCostForClient;
	}

	public double getPartCosts() {
		return partCosts;
	}

	public void setPartCosts(double partCosts) {
		this.partCosts = partCosts;
	}

	public double getWorkHourCost() {
		return workHourCost;
	}

	public void setWorkHourCost(double workHourCost) {
		this.workHourCost = workHourCost;
	}

	public double getWorkHourQuantity() {
		return workHourQuantity;
	}

	public void setWorkHourQuantity(double workHourQuantity) {
		this.workHourQuantity = workHourQuantity;
	}

	@Override
	public String toString() {
		return "OrdersDAO [id=" + id + ", repairDate=" + repairDate + ", repairStartDatePlanned="
				+ repairStartDatePlanned + ", repairStartDate=" + repairStartDate + ", employeeId=" + employeeId
				+ ", problemDescription=" + problemDescription + ", repairDecription=" + repairDecription
				+ ", statusId=" + statusId + ", vehicleId=" + vehicleId + ", repairCostForClient=" + repairCostForClient
				+ ", partCots=" + partCosts + ", workHourCost=" + workHourCost + ", workHourQuantity="
				+ workHourQuantity + "]";
	}

}

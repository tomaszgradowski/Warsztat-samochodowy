package pl.cars.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.cars.dao.CustomerDAO;
import pl.cars.dao.VehicleDAO;

/**
 * Servlet implementation class VehicleAdd
 */
@WebServlet("/VehicleAdd")
public class VehicleAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehicleAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CustomerDAO> list = CustomerDAO.loadAll();
		request.setAttribute("customer", list);
		request.setAttribute("action", request.getParameter("action"));
		request.getRequestDispatcher("vehicle_form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VehicleDAO vehicle = new VehicleDAO();
		vehicle.setModel(request.getParameter("model"));
		vehicle.setBrandName(request.getParameter("brand_name"));
		vehicle.setRegistrationNumber(request.getParameter("registration_number"));
		vehicle.setYear(Integer.valueOf(request.getParameter("year")));
		vehicle.setCarReviewDate(Date.valueOf(request.getParameter("car_review_date")));
		
		if(!request.getParameter("customer_id").equals("null")) {
			
		vehicle.setCustomerId(Integer.valueOf(request.getParameter("customer_id")));
		System.out.println("customer id różny od null");
		vehicle.vehicleAdd();
		System.out.println("dodaję noweg klienta: " + vehicle.toString());
		}
		else {
			System.out.println("customer id rowny null");
			vehicle.vehicleAddNoCustomerId();;
			System.out.println("dodaję noweg klienta: " + vehicle.toString());
		}


		
		

		System.out.println("Nowy pojzd został dodany");

		response.sendRedirect("/Warsztat_samochodowy/VehicleAll");
	}

}

package pl.cars.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.cars.dao.CustomerDAO;
import pl.cars.dao.VehicleDAO;

/**
 * Servlet implementation class VehicleSetCustomer
 */
@WebServlet("/VehicleSetCustomer")
public class VehicleSetCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehicleSetCustomer() {
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
		
		request.setAttribute("customerChecked", request.getParameter("customerChecked"));
		
		request.setAttribute("customer", list);
		VehicleDAO vehicle = new VehicleDAO();
		vehicle.setId(Integer.valueOf(request.getParameter("id")));
		vehicle.setModel(request.getParameter("model"));
		vehicle.setBrandName(request.getParameter("brandName"));
		vehicle.setYear(Integer.valueOf(request.getParameter("year")));
		vehicle.setCarReviewDate(Date.valueOf(request.getParameter("carReviewDate")));
		vehicle.setRegistrationNumber(request.getParameter("registrationNumber"));
		vehicle.setCustomerId(Integer.valueOf(request.getParameter("customerId")));
		vehicle.setId(Integer.valueOf(request.getParameter("id")));

		HttpSession session = request.getSession();
		session.setAttribute("vehicle", vehicle);
		System.out.println("pobrane id to : " + request.getParameter("id"));
		request.getRequestDispatcher("customer_list.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		VehicleDAO vehicle = (VehicleDAO) session.getAttribute("vehicle");
		request.getAttribute("customerChecked");
		System.out.println("atrybut" + request.getAttribute("customerChecked"));
		System.out.println("Przed ustawieniem customerID : " + vehicle.toString());
		try {
			int customerId = Integer.valueOf(request.getParameter("customer_id"));
			vehicle.setCustomerId(customerId);
			System.out.println("Po ustawieniu customerID : " + vehicle.toString());

			vehicle.vehicleUpdate(vehicle.getId());

			System.out.println("Pojazd został zaktualizowany");

			response.sendRedirect("/Warsztat_samochodowy/VehicleAll");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("customerChecked", false);
			System.out.println("przekierowano");
			response.sendRedirect("/Warsztat_samochodowy/VehicleSetCustomer" + "?id=" + vehicle.getId() + "&model="
					+ vehicle.getModel() + "&brandName=" + vehicle.getBrandName() + "&year=" + vehicle.getYear()
					+ "&registrationNumber=" + vehicle.getRegistrationNumber() + "&carReviewDate="
					+ vehicle.getCarReviewDate() + "&customerId=" + vehicle.getCustomerId() + "&customerChecked=false");

		}

	}

}

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
 * Servlet implementation class VehicleUpdate
 */
@WebServlet("/VehicleUpdate")
public class VehicleUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehicleUpdate() {
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
		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("model", request.getParameter("model"));
		request.setAttribute("brandName", request.getParameter("brandName"));
		request.setAttribute("year", request.getParameter("year"));
		request.setAttribute("registrationNumber", request.getParameter("registrationNumber"));
		request.setAttribute("carReviewDate", request.getParameter("carReviewDate"));
		request.setAttribute("customerId", request.getParameter("customerId"));
		request.setAttribute("action", request.getParameter("action"));

		System.out.println("pobrane id to : " + request.getParameter("id") );
		request.getRequestDispatcher("vehicle_form.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VehicleDAO vehicle = new VehicleDAO();
		try {
	
	
			vehicle.setId(Integer.valueOf(request.getParameter("id")));
			vehicle.setModel(request.getParameter("model"));
			vehicle.setBrandName(request.getParameter("brandName"));
			vehicle.setYear(Integer.valueOf(request.getParameter("year")));
			vehicle.setCarReviewDate(Date.valueOf(request.getParameter("carReviewDate")));
			vehicle.setRegistrationNumber(request.getParameter("registrationNumber"));
			vehicle.setCustomerId(Integer.valueOf(request.getParameter("customerId")));
			vehicle.setId(Integer.valueOf(request.getParameter("id")));
			System.out.println("id" + request.getParameter("id"));

			System.out.println("Aktualizowny Pojazd: " + vehicle.toString());

			vehicle.vehicleUpdate(vehicle.getId());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			e.getMessage();
			//vehicle.vehicleUpdate(vehicle.getId());
		}

		System.out.println("Pojazd został zaktualizowany");

		response.sendRedirect("/Warsztat_samochodowy/VehicleAll");

	}

}

package pl.cars.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import pl.cars.dao.VehicleDAO;

/**
 * Servlet implementation class VehicleShowByCustomerId
 */
@WebServlet("/VehicleShowByCustomerId")
public class VehicleShowByCustomerId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleShowByCustomerId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idStr = request.getParameter("id");
		int id = Integer.valueOf(idStr);
		request.setAttribute("customer_id", id);
		
		System.out.println("Id użytkownika: " + id);
		System.out.println("Przed wywołanem metody");
		List<VehicleDAO> list =  VehicleDAO.customerVehicleShowById(id);
		System.out.println(Arrays.toString(list.toArray()));
		System.out.println("pobrano listę");
		request.setAttribute("vehicle", list);
		Enumeration<String> str = request.getAttributeNames();
		while(str.hasMoreElements()) {
			System.out.println(str.nextElement());
		}
		
		request.getRequestDispatcher("vehicle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}

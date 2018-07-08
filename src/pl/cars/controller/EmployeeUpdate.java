package pl.cars.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.cars.dao.EmployeeDAO;

/**
 * Servlet implementation class EmployeeUpdate
 */
@WebServlet("/EmployeeUpdate")
public class EmployeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//
//		request.setAttribute("name", request.getParameter("name"));
//		request.setAttribute("surname", request.getParameter("surname"));
//		request.setAttribute("adress", request.getParameter("adress"));
//		request.setAttribute("telNumber", request.getParameter("telNumber"));
//		request.setAttribute("workHourCosts", request.getParameter("workHourCosts"));
//		request.setAttribute("id", request.getParameter("id"));

		request.setAttribute("action", request.getParameter("action"));

		request.getRequestDispatcher("employee_form.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeDAO emp = new EmployeeDAO();
		try {
			String idStr = request.getParameter("id");
			System.out.println("Przekazane id to: " + idStr);

			emp.setId(Integer.valueOf(request.getParameter("id")));
			emp.setName(request.getParameter("name"));
			emp.setSurname(request.getParameter("surname"));
			emp.setNote(request.getParameter("note"));
			emp.setTelNumber(request.getParameter("telNumber"));
			emp.setAdress(request.getParameter("adress"));
			emp.setWorkHourCosts(Double.valueOf(request.getParameter("workHourCosts")));
			System.out.println("Aktualizowny Pojazd: " + emp.toString());
			
			System.out.println("Pracownik: " + emp.toString());
			emp.employeeUpdate(emp.getId());
			
			
			System.out.println("zaktualizowano pracownika");
			emp.employeeUpdate(emp.getId());

		} catch (

		NumberFormatException e) {
			e.printStackTrace();
			e.getMessage();
			//emp.employeeUpdate(emp.getId());
		}

		System.out.println("Dane pracownika zostały zaktualizowane");

		response.sendRedirect("/Warsztat_samochodowy/EmployeeAll");

	}

}

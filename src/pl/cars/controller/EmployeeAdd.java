package pl.cars.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.cars.dao.EmployeeDAO;

/**
 * Servlet implementation class EmployeeAdd
 */
@WebServlet("/EmployeeAdd")
public class EmployeeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("action", request.getParameter("action"));

		request.getRequestDispatcher("employee_form.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeDAO emp = new EmployeeDAO();
		emp.setName(request.getParameter("name"));
		emp.setSurname(request.getParameter("surname"));
		emp.setAdress(request.getParameter("adress"));
		emp.setTelNumber(request.getParameter("telNumber"));
		emp.setWorkHourCosts(Double.valueOf(request.getParameter("workHourCosts")));
		emp.setNote(request.getParameter("note"));
	
		System.out.println(emp.toString());
		emp.employeeAdd();
		System.out.println("Dodano pracownika");
		
		
		response.sendRedirect("/Warsztat_samochodowy/EmployeeAll");
		
		
		
	}

}

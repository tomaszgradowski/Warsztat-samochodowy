package pl.cars.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pl.cars.dao.EmployeeDAO;

/**
 * Servlet implementation class EmplloyeeDelete
 */
@WebServlet("/EmployeeDelete")
public class EmployeeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String[] idStr = request.getParameterValues("id");
		// int id = Integer.valueOf(request.getParameter("id"));
		int id = 0;
		for (int i = 0; i < idStr.length; i++) {
			id = Integer.valueOf(idStr[i]);
			System.out.println("id: " + id);
			EmployeeDAO.employeeDelete(id);
			System.out.println("Usunieto pracownika o id: " + id);

		}
		response.sendRedirect("/Warsztat_samochodowy/EmployeeAll");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}

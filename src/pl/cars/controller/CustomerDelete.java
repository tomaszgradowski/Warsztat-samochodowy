package pl.cars.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.cars.dao.CustomerDAO;

/**
 * Servlet implementation class CustomerDelete
 */
@WebServlet("/CustomerDelete")
public class CustomerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] idStr = request.getParameterValues("id");
		// int id = Integer.valueOf(request.getParameter("id"));
		int id = 0;
		for (int i = 0; i < idStr.length; i++) {
			id = Integer.valueOf(idStr[i]);
			CustomerDAO.deleteCustomer(id);
			System.out.println("Usunieto klienta o id: " + id);

		}

		response.sendRedirect("/Warsztat_samochodowy/CustomerAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

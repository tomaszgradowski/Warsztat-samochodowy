package pl.cars.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.cars.dao.CustomerDAO;

/**
 * Servlet implementation class CustomerUpdate
 */
@WebServlet("/CustomerUpdate")
public class CustomerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setAttribute("action", request.getParameter("action"));
		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("surname", request.getParameter("surname"));
		request.setAttribute("birthdate", request.getParameter("birthdate"));
		request.setAttribute("telnumber", request.getParameter("telnumber"));
	
		request.getRequestDispatcher("customer_form.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CustomerDAO customer = new CustomerDAO();
		
		customer.setId(Integer.valueOf(request.getParameter("id")));
		System.out.println("Przekazane id to: " + request.getParameter("id"));
		customer.setName(request.getParameter("name"));
		customer.setSurName(request.getParameter("surname"));
		customer.setBirthDate(Date.valueOf(request.getParameter("birthdate")));
		customer.setTelNumber(Integer.valueOf(request.getParameter("telnumber")));
		
		System.out.println("Aktualizowny klient: " + customer.toString());
		
		customer.updateCustomer(customer.getId());
		
		System.out.println("Klient został zaktualizowany");
		response.sendRedirect("/Warsztat_samochodowy/CustomerAll");
		
	}

}

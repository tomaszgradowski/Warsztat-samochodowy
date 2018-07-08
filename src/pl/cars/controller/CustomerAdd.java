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
 * Servlet implementation class CustomerAdd
 */
@WebServlet("/CustomerAdd")
public class CustomerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAdd() {
        super();
        // TODO Auto-generated constructor stub
    }


    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("action", request.getParameter("action"));
		request.getRequestDispatcher("customer_form.jsp").forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//dodanie do bazy
		CustomerDAO customer = new CustomerDAO();
		customer.setName(request.getParameter("name"));
		customer.setSurName(request.getParameter("surname"));
		customer.setBirthDate(Date.valueOf(request.getParameter("birthdate")));
		customer.setTelNumber(Integer.valueOf(request.getParameter("telnumber")));
		
		System.out.println("dodaję noweg klienta: " + customer.toString());
				
		customer.customerAdd();
		
		System.out.println("Nowy klient został dodoany");
		
		response.sendRedirect("/Warsztat_samochodowy/CustomerAll");
		
		
	}

}

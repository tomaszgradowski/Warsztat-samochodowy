package pl.cars.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.cars.dao.SmsDAO;

/**
 * Servlet implementation class SendSMS
 */
@WebServlet("/SendSMS")
public class SendSMS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendSMS() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("telnumber", request.getParameter("telnumber"));
		request.setAttribute("id", request.getParameter("id"));
		
		request.getRequestDispatcher("sms_form.jsp").forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String urlStr = SmsDAO.buildUrl(request.getParameter("message"), request.getParameter("to"));
		System.out.println(urlStr);
		
		
	}

}

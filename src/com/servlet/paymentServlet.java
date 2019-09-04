package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.payment;
import com.service.payment_service;

/**
 * Servlet implementation class paymentServlet
 */
@WebServlet("/paymentServlet")
public class paymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("ordercompletemsg.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String cardName = request.getParameter("cardname");
		String cardNumber = request.getParameter("cardnumber");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String cvc = request.getParameter("cvc");
		String email = request.getParameter("email");
		String contactNumber = request.getParameter("conNumber");
		
		payment pay = new payment();
		
		pay.setCardName(cardName);
		pay.setCardNumber(cardNumber);
		pay.setMonth(month);
		pay.setYear(year);
		pay.setCvc(cvc);
		pay.setEmail(email);
		pay.setContactNumber(contactNumber);
		
		payment_service ser = new payment_service();
		
		ser.addPayment(pay);
	}

}

package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.*;
import com.service.addRepairService;
/**
 * Servlet implementation class repairServlet
 */
@WebServlet("/repairServlet")
public class repairServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public repairServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("addReparing.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String contactNumber = request.getParameter("contactNumber");
		String date = request.getParameter("date");
		String itemId = request.getParameter("itemId");
		String description = request.getParameter("des");
		String ptype = request.getParameter("ptype");
		float amount = Float.parseFloat(request.getParameter("amount"));
		
		repair r = new repair();
		
		r.setName(name);
		r.setAddress(address);
		r.setContactNumber(contactNumber);
		r.setDate(date);
		r.setItemId(itemId);
		r.setDescription(description);
		r.setPtype(ptype);
		r.setAmount(amount);
		
		addRepairService rep = new addRepairService();
		rep.repair(r);
		
	}

}

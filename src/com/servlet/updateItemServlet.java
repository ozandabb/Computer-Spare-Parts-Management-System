package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.item;
import com.service.updateItemService;

/**
 * Servlet implementation class updateItemServlet
 */
@WebServlet("/updateItemServlet")
public class updateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("admin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String productid = request.getParameter("pid");
		String productName = request.getParameter("pname");
		String productType = request.getParameter("ptype");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("des");
		
		item it = new item();
		
		it.setProductid(productid);
		it.setProductName(productName);
		it.setProductType(productType);
		it.setQuantity(quantity);
		it.setPrice(price);
		it.setDescription(description);
		
		updateItemService up = new updateItemService();
		up.updateItem(it);
		
	}

}

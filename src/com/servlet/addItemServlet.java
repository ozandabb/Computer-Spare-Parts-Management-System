package com.servlet;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;
import com.service.*;

/**
 * Servlet implementation class addItemServlet
 */
@WebServlet("/addItemServlet")
public class addItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("addItems.jsp");
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
		
		addItemService add = new addItemService();
		add.item(it);
	}

}

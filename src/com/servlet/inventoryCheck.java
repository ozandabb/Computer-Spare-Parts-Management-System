package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.*;
import com.util.db_con;
import com.util.*;

/**
 * Servlet implementation class inventoryCheck
 */
@WebServlet("/inventoryCheck")
public class inventoryCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inventoryCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //private static Connection con;
	private static PreparedStatement ps;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try{
			String sql = "select pid, productName, productType, quantity, price from item";
			ps = ((Connection) con).prepareStatement(sql);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			
			String str = "<style>\r\n" + 
					"table {\r\n" + 
					"  border-collapse: collapse;\r\n" + 
					"  width: 100%;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"th, td {\r\n" + 
					"  text-align: left;\r\n" + 
					"  padding: 8px;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"tr:nth-child(even){background-color: #f2f2f2}\r\n" + 
					"\r\n" + 
					"th {\r\n" + 
					"  background-color: #4CAF50;\r\n" + 
					"  color: white;\r\n" + 
					"}\r\n" + 
					"</style> <table> <tr> <th>Product ID</th> <th>Product Name</th> <th>Product Type</th> <th>Quantity</th> <th>Price</th> </tr>";
			
			while(rs.next()) {
				str += "<tr> <td>" + rs.getString(1) + "</td> <td>" + rs.getString(2) + "</td> <td>" + rs.getString(3) + "</td> <td>" + rs.getInt(4) + "</td> <td>" + rs.getFloat(5) + "</td> </tr>"; 
			}
			
			str += "</table>";
			out.println(str);
		}catch(Exception e) {
			System.err.println(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}

package com.servlet;

import java.io.IOException;
import com.model.login;
import com.service.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		login log = new login();
		
		log.setUserName(uname);
		log.setPassword(pwd);
		
		loginService serv = new loginService();
		
		final HttpSession session = request.getSession(false);
		
		if(serv.validate(log.getUserName(),log.getPassword()) == true){
			//HttpSession session = request.getSession();
			//session = request.getSession();
			session.setAttribute("uname", "pwd");
			response.sendRedirect("desktop_Spare.jsp");
		}
		else if(uname.equals("admin") && pwd.equals("admin123")) {
			//HttpSession session = request.getSession();
			//session = request.getSession();
			session.setAttribute("uname", "pwd");
			response.sendRedirect("admin.jsp");
			
		}
		else if(uname.equals("manager") && pwd.equals("manager123")) {
			//HttpSession session = request.getSession();
			//session = request.getSession();
			session.setAttribute("uname", "pwd");
			response.sendRedirect("manager.jsp");
			
		}
		else if(uname.equals("employee") && pwd.equals("employee123")) {
			//HttpSession session = request.getSession();
			//session = request.getSession();
			session.setAttribute("uname", "pwd");
			response.sendRedirect("employee.jsp");
			
		}
		else {
			response.sendRedirect("login_reg.jsp");
		}
	}

}

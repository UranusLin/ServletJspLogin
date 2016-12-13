package com.LoginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String errorcode = "";
		
		if(uname.equals("uranuslin")&&pass.equals("123456"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("LoginSucess.jsp");
		}
		else
		{
			if (uname.isEmpty()||pass.isEmpty())
			{
				errorcode="Your username or password was null !";
				request.setAttribute("error_c", errorcode);
				request.getRequestDispatcher("LoginFail.jsp").forward(request, response);
			}
			else if (uname.equals("uranuslin") && !pass.equals("123456"))
			{
				errorcode="Your password was wrong !";
				request.setAttribute("error_c", errorcode);
				request.getRequestDispatcher("LoginFail.jsp").forward(request, response);
			}
			else
			{
				errorcode="User is not exist";
				request.setAttribute("error_c", errorcode);
				request.getRequestDispatcher("LoginFail.jsp").forward(request, response);
			}
			
		}
	}

	

}

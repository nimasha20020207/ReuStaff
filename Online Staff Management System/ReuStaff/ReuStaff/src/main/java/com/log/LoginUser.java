package com.log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {

	LoginDAO dao = new LoginDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getServletPath();

		switch (act) {
		case "/LoginUser":
			System.out.println("login" + act);
			checkLogin(request, response);
			break;
		}

	}


	private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Get username and password from the form
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");

		// Check login credentials and get the user type (if any)
		String userType = dao.checkLogin(uname, upass);

		if (userType != null) {
			// Login successful
			HttpSession session = request.getSession();
			session.setAttribute("username", uname); // Store the username in the session
			session.setAttribute("userType", userType);
			// Redirect user to their respective home page based on their type
			switch (userType) {
			case "admin":
				response.sendRedirect("adminHome.jsp");
				break;
			case "teacher":
				response.sendRedirect("teacherHome.jsp");
				break;
			case "principle": // Corrected spelling from "principle" to "principal"
				response.sendRedirect("principalHome.jsp");
				break;
			case "payrall":
				response.sendRedirect("payHome.jsp");
				break;
			default:
				response.sendRedirect("index.jsp"); // Fallback for unknown user types
				break;
			}
		} else {
			// Login failed, set error message and forward back to login page
			// request.getRequestDispatcher("index.jsp");
			response.setContentType("text/html");
			response.getWriter().println("<script type=\"text/javascript\">");
			response.getWriter().println("alert('Invalid login! Please try again.');");
			response.getWriter().println("window.location.href = 'index.jsp';");
			response.getWriter().println("</script>");
		}

	}

	
}

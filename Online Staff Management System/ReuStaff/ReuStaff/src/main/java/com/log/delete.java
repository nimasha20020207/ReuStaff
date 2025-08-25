package com.log;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deletu")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginDAO dao = new LoginDAO();

	// Handles POST requests to this servlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getServletPath();
		switch (act) {
		case "/deletu":
			System.out.println("login" + act);
			deleteuser(request, response);
		}

	}

	// Method to delete a user from the database
	private void deleteuser(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String mid = request.getParameter("memberid");
		mid = mid != null ? mid.trim() : "";
		System.out.println("Attempting to delete user with ID1: " + mid);
		dao.deleteUser(mid);
		System.out.println("Attempting to delete user with ID: " + mid);

		String alertMessage = "User deleted";

		// Write a JavaScript alert to the response to inform the user that the deletion was successful
		response.getWriter().println("<script type=\"text/javascript\">");
		response.getWriter().println("alert('" + alertMessage + "');");
		response.getWriter().println("window.location.href = 'adduser.jsp';");
		response.getWriter().println("</script>");

	}
}

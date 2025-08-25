package com.log;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class insertuser extends HttpServlet {
	
	LoginDAO dao = new LoginDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getServletPath();
		
		switch (act) {
		case "/insert":
			System.out.println("login" + act);
			insertUser(request, response);
		}	

	}

private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mid = request.getParameter("id");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String type = request.getParameter("type");

		user pt = new user(mid, name, mail, type);
		LoginDAO dao = new LoginDAO();
		dao.addNewuser(pt);

		System.out.println("Patient added to system");

		String alertMessage = "Data update";
		response.getWriter().println("<script type=\"text/javascript\">");
		response.getWriter().println("alert('" + alertMessage + "');");
		response.getWriter().println("window.location.href = 'adduser.jsp';");
		response.getWriter().println("</script>");
		
	}
}

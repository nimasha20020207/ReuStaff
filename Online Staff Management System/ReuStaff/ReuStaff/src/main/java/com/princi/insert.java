package com.princi;

//Import necessary classes for servlet functionality
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Annotation to define the servlet URL pattern
@WebServlet("/inserte")

public class insert extends HttpServlet{
	PriDAO dao = new PriDAO();
	
	// Handle POST requests
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getServletPath();
		
		switch (act) {
		case "/inserte":
			System.out.println("login" + act);
			insertUser(request, response);
		}	

	}
	
	// Method to insert user data into the database

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String mid = request.getParameter("id");
			String name = request.getParameter("name");
			String mail = request.getParameter("InCharge");
			String type = request.getParameter("Date");

			event pt = new event(mid, name, mail, type);
			PriDAO dao = new PriDAO();
			dao.addNewuser(pt);

			System.out.println("Patient added to system");

			// Send an alert message and redirect the user to addevent.jsp
			String alertMessage = "Data update";
			response.getWriter().println("<script type=\"text/javascript\">");
			response.getWriter().println("alert('" + alertMessage + "');");
			response.getWriter().println("window.location.href = 'addevent.jsp';");
			response.getWriter().println("</script>");
			
		
	}

}

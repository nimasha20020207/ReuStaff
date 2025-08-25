package com.princi;

//Import necessary classes for servlet functionality
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Annotation to define the servlet URL pattern
@WebServlet("/updateuu")
public class eventget extends HttpServlet{
	private static final long serialVersionUID = 1L;
	PriDAO dao = new PriDAO();

	// Handle GET requests
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getServletPath();
		switch (act) {
		case "/updateuu":
			System.out.println("up" + act);
			showdata(request, response);
		}

	}

	// Method to retrieve and display event data for updating
	private void showdata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eid = request.getParameter("eventid");

		event oldevent = dao.selectOldevent(eid);

		RequestDispatcher rd = request.getRequestDispatcher("updatevent.jsp");
		request.setAttribute("ptss", oldevent);
		rd.forward(request, response);
	}
	

}

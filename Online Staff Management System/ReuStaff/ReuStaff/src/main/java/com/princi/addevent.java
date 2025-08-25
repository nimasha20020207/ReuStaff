package com.princi;

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

@WebServlet("/addevent")

public class addevent extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// Creating an instance of PriDAO to interact with the database
	PriDAO dao = new PriDAO();  
	
	// Handling POST requests made to this servlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getServletPath();

		switch (act) {
		case "/addevent":
			System.out.println("login" + act);
			showuser(request, response);
		}
	}
	
	// Method to fetch user events from the database and forward them to a JSP page
	private void showuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<event> us = new ArrayList<>();
		us = dao.getallevent();
		request.setAttribute("pts", us);
		System.out.println(us);
		RequestDispatcher rd = request.getRequestDispatcher("addevent.jsp");
		rd.forward(request, response);
		
		
	}

}

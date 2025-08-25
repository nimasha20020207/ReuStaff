package com.log;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getServletPath();
		switch (act) {
		
		case "/logout":
			System.out.println(act);
			userlogout(request,response);
			
		
		}
	}
	private void userlogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sa=request.getSession();
		sa.removeAttribute("logout");
		
		response.sendRedirect("home.jsp");
		
		
		
	}
	

}

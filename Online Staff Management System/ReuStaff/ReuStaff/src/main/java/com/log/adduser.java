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

@WebServlet("/adduser")
public class adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDAO dao = new LoginDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getServletPath();

		switch (act) {
		case "/adduser":
			System.out.println("login" + act);
			showuser(request, response);
		}
	}

	private void showuser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<user> us = new ArrayList<>();
		us = dao.getallusers();
		request.setAttribute("pts", us);
		RequestDispatcher rd = request.getRequestDispatcher("adduser.jsp");
		rd.forward(request, response);

	}
}
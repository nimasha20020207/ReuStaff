package com.log;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateu")
public class getuserd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginDAO dao = new LoginDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getServletPath();
		switch (act) {
		case "/updateu":
			System.out.println("up" + act);
			showdata(request, response);
		}

	}

	private void showdata(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mid = request.getParameter("memberid");

		user olduser = dao.selectOlduser(mid);

		RequestDispatcher rd = request.getRequestDispatcher("updateu.jsp");
		request.setAttribute("ptss", olduser);
		rd.forward(request, response);
	}
}

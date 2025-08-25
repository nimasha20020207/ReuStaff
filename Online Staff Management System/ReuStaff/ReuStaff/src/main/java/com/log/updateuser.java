package com.log;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateuser")
public class updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LoginDAO dao = new LoginDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act=request.getServletPath();
		 switch(act) {
		 case"/updateuser":
			 System.out.println("up"+act);
			 update(request,response);
		 }
	}
		
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String mid=request.getParameter("id");
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String type=request.getParameter("type");
		
		user updateuser=new user(mid,name,mail,type);
		boolean check=dao.updateOlduser(updateuser);
		
		if(check) {
			  String alertMessage="User User Updated";
			  response.getWriter().println("<script type=\"text/javascript\">");
			  response.getWriter().println("alert('" + alertMessage + "');");
			  response.getWriter().println("window.location.href = 'adduser.jsp';");
			  response.getWriter().println("</script>");
		}else {
			System.out.println("Failed to update");
		}
		
	
		
	}
	
}
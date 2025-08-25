package com.princi;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/updatevent")
public class updateevent extends HttpServlet{
	private static final long serialVersionUID = 1L;
	PriDAO dao = new PriDAO();
	
// Handle POST requests
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act=request.getServletPath();
		 switch(act) {
		 case"/updatevent":
			 System.out.println("up"+act);
			 updatevent(request,response);
		 }
	}

//Method to handle event updates
private void updatevent(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	// Retrieve event details from the request parameters
	String mid = request.getParameter("id");
	String name = request.getParameter("name");
	String mail = request.getParameter("InCharge");
	String type = request.getParameter("Date");

	event updatevent = new event(mid, name, mail, type);
	
	boolean check=dao.updateOlduser(updatevent);
	
	if(check) {
		  String alertMessage="User User Updated";
		  // If the update is successful, show an alert and redirect to the addevent.jsp page
		  response.getWriter().println("<script type=\"text/javascript\">"); 		  
		  response.getWriter().println("alert('" + alertMessage + "');");
		  response.getWriter().println("window.location.href = 'addevent.jsp';");
		  response.getWriter().println("</script>");
	}else {
		System.out.println("Failed to update");
	}
	
}

}

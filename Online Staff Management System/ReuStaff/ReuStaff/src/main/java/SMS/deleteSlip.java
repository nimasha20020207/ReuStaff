package SMS;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteSlip")
public class deleteSlip extends HttpServlet{

	private static final long serialVersionUID=1L;
	
	PayrollDAO dao=new PayrollDAO();
	
    //handle get requests
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String act=req.getServletPath();
		
		switch(act) {
		case"/deleteSlip":
			deleteSlip(req,res);
			System.out.println("payslipDeleted");
			}
	}
	//method to delete a pay slip
			private void deleteSlip(HttpServletRequest req, HttpServletResponse res) throws IOException {
				
				int id=Integer.parseInt(req.getParameter("id"));//get pay slip ID from request
				dao.delete(id);//delete pay slip using data access object
				
				System.out.println("slip deleted");//verifying whether the pay slip deleted or not
				res.sendRedirect("paySlipRecord");//redirect back to pay slip record page
				
			
			}


}

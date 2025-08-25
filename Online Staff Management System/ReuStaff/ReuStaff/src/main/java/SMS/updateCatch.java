package SMS;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateCatch")
public class updateCatch extends HttpServlet{

private static final long serialVersionUID=1L;
	
	PayrollDAO dao=new PayrollDAO();
	
    //handle get requests
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String act=req.getServletPath();
		
		switch(act) {
		case"/updateCatch":
			updateCatch(req,res);
			System.out.println("FormUpdated"+act);
			}
	}
	//method to handle updating a pay slip
			private void updateCatch(HttpServletRequest req, HttpServletResponse res) throws IOException {
				
				int id=Integer.parseInt(req.getParameter("PayID"));
				String staffmemID=req.getParameter("staffID");
				String month=req.getParameter("month");
				float Bonus=Float.parseFloat(req.getParameter("bonusAmount"));
				float Basic=Float.parseFloat(req.getParameter("basicAmount"));
				float Total=Float.parseFloat(req.getParameter("salaryTotal"));
				String payrollOfficerID=req.getParameter("issuedBy");
				
				//create a new pay slip object with updated values
				paySlip updatedSlip=new paySlip(id,staffmemID,month,Bonus,Basic,Total,payrollOfficerID);
				//update the pay slip using data access object
				boolean check=dao.updatePaySlip(updatedSlip);
				
				if(check) {
					res.sendRedirect("payrollPaySlip.jsp");
				}
				else {
					System.out.println("failed to update");
				}
		}
}

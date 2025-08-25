package SMS;

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


@WebServlet("/PayslipForm")
public class PayslipForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PayrollDAO dao=new PayrollDAO();
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String act=req.getServletPath();
		
		//switch between different actions based on the url path
		switch(act) {
			case "/PayslipForm":
				checkPaySlip(req,res);
				System.out.println("Issue Payslip"+act);
		}
		
	}
	
	private void checkPaySlip(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//catching form data
		int pid=Integer.parseInt(req.getParameter("PayID"));
		String ID=req.getParameter("staffID");
		String Month=req.getParameter("month");
		float bonus=Float.parseFloat(req.getParameter("bonusAmount"));
		float basic=Float.parseFloat(req.getParameter("basicAmount"));
		float total= Float.parseFloat(req.getParameter("salaryTotal"));
		String payrollOfficer=req.getParameter("issuedBy");
		
		//create a new pay slip object with given data
		paySlip ps=new paySlip(pid,ID,Month,bonus,basic,total,payrollOfficer);
	
		dao.addNewPayslip(ps);//add the new pay slip using data access object
		System.out.println("Payslip added to system");//verifying whether pay slip added to the system or not
		res.sendRedirect("payrollPaySlip.jsp");//re direct to the pay slip issuing page
		
		
		
	}


}

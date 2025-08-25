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

@WebServlet("/paySlipRecord")
public class paySlipRecord extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	PayrollDAO dao=new PayrollDAO();
	
	// Handle GET requests
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String act=req.getServletPath();
		

		switch(act) {
			case "/paySlipRecord":
				showPaySlips(req,res);
				System.out.println("viewd slip inbox"+act);
		}
		
	}
	
	// Method to retrieve and display the list of issued payslips
	private void showPaySlips(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<paySlip> pList=new ArrayList<>();
		
		pList=dao.getIssuedPayslips();
		req.setAttribute("pt", pList);
		System.out.println(pList);
		
		// Forward the request to the paySlipRecord.jsp page for displaying the records
		RequestDispatcher rd=req.getRequestDispatcher("paySlipRecord.jsp");
		rd.forward(req, res);
	}

}

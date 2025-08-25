package SMS;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update extends HttpServlet{
	
	private static final long serialVersionUID=1L;
	
	PayrollDAO dao=new PayrollDAO();
	
    //handle get requests
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String act=req.getServletPath();
		
		switch(act) {
		case"/update":
			showUpdateForm(req,res);
			System.out.println("viewdUpdatingForm"+act);
			}
	}
	
	//method to show pay slip updating form
			private void showUpdateForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
				int id=Integer.parseInt(req.getParameter("id"));
				paySlip slip=dao.selectUpdateSlip(id);
				RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
				System.out.println(slip);
				req.setAttribute("pslip",slip);
				rd.forward(req, res);
			
		}


}

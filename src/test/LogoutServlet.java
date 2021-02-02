package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html");
		Cookie ck[]=req.getCookies();
		ck[0].setValue("");
		ck[0].setMaxAge(0);
		res.addCookie(ck[0]);
		req.setAttribute("msg", "Loged out successfully");
		RequestDispatcher rd=req.getRequestDispatcher("login_error.jsp");
		rd.forward(req, res);
	}
}

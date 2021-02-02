package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/reg1")
public class RegServlet1 extends HttpServlet{
	public ServletContext sct;
	public RegBean rb;
	@Override
	public void init() throws ServletException{
		sct=this.getServletContext();
		rb=new RegBean();
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException
	,IOException{
		res.setContentType("text/html");
		String uName=req.getParameter("uname");
		String pWord=req.getParameter("pword");
		String fName=req.getParameter("fname");
		String lName=req.getParameter("lname");
		rb.setuName(uName);
		rb.setpWord(pWord);
		rb.setfName(fName);
		rb.setlName(lName);
		sct.setAttribute("beanRef",rb);
		RequestDispatcher rd=req.getRequestDispatcher("input2.html");
		rd.forward(req, res);
	}

}

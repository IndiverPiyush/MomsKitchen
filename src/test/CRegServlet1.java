package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/creg1")
public class CRegServlet1 extends HttpServlet{
	public ServletContext sct;
	public CRegBean crb;
	@Override
	public void init() throws ServletException{
		sct=this.getServletContext();
		crb=new CRegBean();
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException
	,IOException{
		res.setContentType("text/html");
		String cuName=req.getParameter("cuname");
		String cpWord=req.getParameter("cpword");
		String cfName=req.getParameter("cfname");
		String clName=req.getParameter("clname");
		crb.setCuName(cuName);
		crb.setCpWord(cpWord);
		crb.setCfName(cfName);
		crb.setClName(clName);
		sct.setAttribute("beanRef",crb);
		RequestDispatcher rd=req.getRequestDispatcher("cinput2.html");
		rd.forward(req, res);
	}

}

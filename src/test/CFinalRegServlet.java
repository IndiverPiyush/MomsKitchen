package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/cfinal")
public class CFinalRegServlet extends HttpServlet{
	public Connection con;
	public CRegBean crb;
	public ServletContext sct;
	@Override
	public void init() throws ServletException{
		con=DBConnection.getcon();
		sct=this.getServletContext();
		crb=(CRegBean)sct.getAttribute("beanRef");
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html");
		try {
			PreparedStatement ps=con.prepareStatement("insert into client19 values(?,?,?,?,?,?,?,?)");
			ps.setString(1, crb.getCuName());
			ps.setString(2, crb.getCpWord());
			ps.setString(3, crb.getCfName());
			ps.setString(4, crb.getClName());
			ps.setString(5, crb.getCaddr());
			ps.setString(6, crb.getCmid());
			ps.setString(7, crb.getCloc());
			ps.setString(8, crb.getCmob());
			int ck=ps.executeUpdate();
			if(ck>0)
			{
				req.setAttribute("msg", "User Registered Successfully.....");
				RequestDispatcher rd=req.getRequestDispatcher("login_error.jsp");
				rd.forward(req, res);
			}
		}catch(Exception e) {}
		}
	}
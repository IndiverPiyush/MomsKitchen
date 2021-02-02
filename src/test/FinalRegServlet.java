package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/final")
public class FinalRegServlet extends HttpServlet{
	public Connection con;
	public RegBean rb;
	public ServletContext sct;
	@Override
	public void init() throws ServletException{
		con=DBConnection.getcon();
		sct=this.getServletContext();
		rb=(RegBean)sct.getAttribute("beanRef");
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html");
		try {
			PreparedStatement ps=con.prepareStatement("insert into Momchef values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, rb.getuName());
			ps.setString(2, rb.getpWord());
			ps.setString(3, rb.getfName());
			ps.setString(4, rb.getlName());
			ps.setString(5, rb.getAddr());
			ps.setString(6, rb.getMid());
			ps.setString(7, rb.getLoc());
			ps.setLong(8, rb.getAccno());
			ps.setString(9, rb.getIfsc());
			ps.setString(10, rb.getMob());
			int k=ps.executeUpdate();
			if(k>0)
			{
				req.setAttribute("msg", "User Registered Successfully.....");
				RequestDispatcher rd=req.getRequestDispatcher("login_error.jsp");
				rd.forward(req, res);
			}
		}catch(Exception e) {}
		}
	}
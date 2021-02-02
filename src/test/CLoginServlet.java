package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/clog")
public class CLoginServlet extends HttpServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con=DBConnection.getcon();
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html");
		String CuName=req.getParameter("cuname");
		String CpWord=req.getParameter("cpword");
		try {
			PreparedStatement ps=con.prepareStatement("select * from Client19 where CUNAME=? and CPWORD=?");
			ps.setString(1, CuName);
			ps.setString(2, CpWord);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				CRegBean crb=new CRegBean();
				crb.setCuName(rs.getString(1));
				crb.setCpWord(rs.getString(2));
				crb.setCfName(rs.getString(3));
				crb.setClName(rs.getString(4));
				crb.setCaddr(rs.getString(5));
				crb.setCmid(rs.getString(6));
				crb.setCloc(rs.getString(7));
				crb.setCmob(rs.getString(8));
				ServletContext sct=this.getServletContext();
				sct.setAttribute("CbeanRef",crb);
				Cookie ck=new Cookie("cname",rs.getString(3));
				res.addCookie(ck);
				req.setAttribute("cfname", rs.getString(3));
				RequestDispatcher rd=req.getRequestDispatcher("clogin_success.jsp");
				rd.forward(req, res);
			}else {
				req.setAttribute("msg", "invalid Uname or Pword");
				RequestDispatcher rd=req.getRequestDispatcher("login_error.jsp");
				rd.forward(req, res);
			}
		}catch(Exception e) {}
	}
	}
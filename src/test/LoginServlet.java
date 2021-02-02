package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con=DBConnection.getcon();
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html");
		String uName=req.getParameter("uname");
		String pWord=req.getParameter("pword");
		try {
			PreparedStatement ps=con.prepareStatement("select * from Momchef where UNAME=? and PWORD=?");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				RegBean rb=new RegBean();
				rb.setuName(rs.getString(1));
				rb.setpWord(rs.getString(2));
				rb.setfName(rs.getString(3));
				rb.setlName(rs.getString(4));
				rb.setAddr(rs.getString(5));
				rb.setMid(rs.getString(6));
				rb.setLoc(rs.getString(7));
				rb.setAccno(rs.getLong(8));
				rb.setIfsc(rs.getString(9));
				rb.setMob(rs.getString(10));
				ServletContext sct=this.getServletContext();
				sct.setAttribute("beanRef",rb);
				Cookie ck=new Cookie("name",rs.getString(3));
				res.addCookie(ck);
				req.setAttribute("fname", rs.getString(3));
				RequestDispatcher rd=req.getRequestDispatcher("login_Success.jsp");
				rd.forward(req, res);
			}else {
				req.setAttribute("msg", "invalid Uname or Pword");
				RequestDispatcher rd=req.getRequestDispatcher("login_error.jsp");
				rd.forward(req, res);
			}
		}catch(Exception e) {}
	}
	}
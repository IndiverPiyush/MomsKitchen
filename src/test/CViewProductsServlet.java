package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@SuppressWarnings("serial")
@WebServlet("/viewdish")
public class CViewProductsServlet extends HttpServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con=DBConnection.getcon();
	}
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) 
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ServletContext sct=this.getServletContext();
		String cfName=(String)sct.getAttribute("cfName");
		pw.println("Welcome ADMIN:"+cfName+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("CLink.html");
		rd.include(req,res);
		RequestDispatcher rdss=req.getRequestDispatcher("DataRetrieve.jsp");
		rdss.forward(req,res);
		try {
			PreparedStatement ps=con.prepareStatement("select * from dish19");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				pw.println("<br>"+rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getString(3)+"&nbsp&nbsp"+rs.getString(4)+"&nbsp&nbsp"+rs.getString(5)+"&nbsp&nbsp"+rs.getString(6));
			}
		}catch(Exception e) {e.printStackTrace();}
	}
}

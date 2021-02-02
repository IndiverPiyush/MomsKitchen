package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/finaldish")
public class AddDishServlet extends GenericServlet{
	public ServletContext sct;
	public Dish db;
	@Override
	public void init() throws ServletException{
		sct=this.getServletContext();
		db=new Dish();
	}
	@Override
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String dName=req.getParameter("dName");
		String dPrice=req.getParameter("dPrice");
		String tpa=req.getParameter("tpa");
		String delivery=req.getParameter("delivery");
		String phno=req.getParameter("phno");
		String availability=req.getParameter("availability");
		
		db.setdName(dName);
		db.setdPrice(dPrice);
		db.setTpa(tpa);
		db.setDelivery(delivery);
		db.setPhno(phno);
		db.setAvailability(availability);
		RequestDispatcher rd=req.getRequestDispatcher("link.html");
		rd.include(req,res);
		AddDishDAO abd=new AddDishDAO();
		int z=abd.addDish(db);
		if(z>0)
		{
			pw.println("<br>Product Added Successfully.....");
		}
	}
	

}


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="utf-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body background="background5.jpg" opacity>
<h1><marquee>WELCOME TO MOM's Kitchen</marquee></h1>
<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from dish19");
	while(rs.next())
	{
%>
<table align="center" border="1" width="100" style="width:100%" class="table table-dark table-striped">
<tbody>
<tr>
<th width="16%">Dish Name</th>
<th width="16%">Price</th>
<th width="16%">Available for</th>
<th width="16%">Delivery Option</th>
<th width="16%">Phone No.</th>
<th width="16%">Availability</th>
</tr>
<tr>
<td width="16%"><%=rs.getString(1) %></td>
<td width="16%"><%=rs.getString(2) %></td>
<td width="16%"><%=rs.getString(3) %></td>
<td width="16%"><%=rs.getString(4) %></td>
<td width="16%"><%=rs.getString(5) %></td>
<td width="16%"><%=rs.getString(6) %></td>
</tr>
</tbody>
</table>
<%
  }
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
</body>
</html>
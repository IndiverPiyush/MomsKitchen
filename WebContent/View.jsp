<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="test.RegBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
RegBean rb=(RegBean)application.getAttribute("beanRef");
out.println(".........Registration Details.........");
out.println("<br>UserName:" + rb.getuName());
out.println("<br>Password:" + rb.getpWord());
out.println("<br>FirstName:" + rb.getfName());
out.println("<br>LastName:" + rb.getlName());
out.println("<br>Address:" + rb.getAddr());
out.println("<br>Location:" + rb.getLoc());
out.println("<br>PhoneNo:" + rb.getMob());
out.println("<br>MailId:" + rb.getMid());
out.println("<br>AccountNo:" + rb.getAccno());
out.println("<br>IFSC:" + rb.getIfsc());
out.println("<br>");
%>
<form action="final" method="post">
<input type = "submit" value="Register">
</form>
</body>
</html>
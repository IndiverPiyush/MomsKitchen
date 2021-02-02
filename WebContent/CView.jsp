<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="test.CRegBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
CRegBean crb=(CRegBean)application.getAttribute("beanRef");
out.println(".........Registration Details.........");
out.println("<br>UserName:" + crb.getCuName());
out.println("<br>Password:" + crb.getCpWord());
out.println("<br>FirstName:" + crb.getCfName());
out.println("<br>LastName:" + crb.getClName());
out.println("<br>Address:" + crb.getCaddr());
out.println("<br>Location:" +crb.getCloc());
out.println("<br>PhoneNo:" + crb.getCmob());
out.println("<br>MailId:" + crb.getCmid());
out.println("<br>");
%>
<form action="cfinal" method="post">
<input type = "submit" value="Register">
</form>
</body>
</html>
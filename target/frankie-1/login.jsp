<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">${message}</font>
<form action="loginUser" method="post">
UserName:<input type="text" name="mailid"/></br>
PassWord:<input type="password" name="pwd"/></br>
<input type="submit" value="login"/>
</form>
<a href="goToprofilePage">Click Here</a> for profile page
</body>
</html>
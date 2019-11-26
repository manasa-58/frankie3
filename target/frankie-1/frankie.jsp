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
	<form action="Registerform" method="post">
		Name:<input type="text" name="name" /></br>
		 Mail Id:<input type="text"name="mailid" /></br> 
			Mobile:<input type="text" name="mobile" /></br> 
			Password:<input type="password" name="password" /></br> 
			City:<input type="text" name="city" /></br>
		<input type="submit" value="register" /></br>
		<a href="login.jsp">Click Here</a> for login page
</form>
<a href="profile.jsp">Click Here</a> for profile page
<br><br><br>
<form action="testIoc">
<input type="submit" value="TestIoc"/>
</form>
</body>
</html>
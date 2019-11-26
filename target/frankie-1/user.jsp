<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function editUser(){
	alert('Edit button triggered!!')
}
function deleteUser(mailid){
	alert(mailid + 'Delete button triggered!!')
	//--- delete request mailId
	document.forms[0].action="${pageContext.request.contextPath}/deleteUser?mailid="+mailid;
	document.forms[0].method="post";
	document.forms[0].submit();
}
</script>
</head>
<body>
<font color="red">${msg}</font>
	<form action="">
		<table border="1">
			<tr>
				<th>mailid</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Password</th>
				<th>City</th>
			</tr>
			<core:forEach var="user" items="${userData}">
				<tr>
					<td>${user.mailid}</td>
					<td>${user.name}</td>
					<td>${user.mobile}</td>
					<td>${user.password}</td>
					<td>${user.city}</td>
					<td><input type name="button" onclick="editUser()"value="Edit"/></td>
					<td><input type name="button" onclick="deleteUser('${user.mailid}')" value="Delete"/></td>
				</tr>
			</core:forEach>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function editItem(itemId){
	alert(itemId + 'Edit button triggered!!')
	document.forms[0].action="${pageContext.request.contextPath}/editItemView?itemId="+itemId;
	document.forms[0].method="post";
	document.forms[0].submit();
}
function deleteItem(itemId){
	alert(itemId + 'Delete button triggered!!')
	//--- delete request itemId
	document.forms[0].action="${pageContext.request.contextPath}/deleteItem?itemId="+itemId;
	document.forms[0].method="post";
	document.forms[0].submit();
}
</script>
</head>
<body>
<font color="red">${msg}</font>
Click here for<a href="logout">logout</a>
	<form action="">
		<table border="1">
			<tr>
				<th>ItemId</th>
				<th>Item</th>
				<th>Price</th>
				<th>Veg/NonVeg</th>
				<th>Qty</th>
			</tr>
			<core:forEach var="item" items="${menuData}">
				<tr>
					<td>${item.itemid}</td>
					<td>${item.item}</td>
					<td>${item.price}</td>
					<td>${item.typeOfItem}</td>
					<td>${item.qty}</td>
					<td><input type name="button" onclick="editItem(${item.itemid})"value="Edit" /></td>
					<td><input type name="button" onclick="deleteItem(${item.itemid})" value="Delete" /></td>
				</tr>
			</core:forEach>
		</table>
	</form>
</body>
</html>
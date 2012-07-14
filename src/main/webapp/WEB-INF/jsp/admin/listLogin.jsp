<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Login (JSP)</title>
</head>
<body>

	<h1>Users</h1>

	<h3>Following are the logins stored in the database.</h3>

	<c:url var="addLoginUrl" value="addLogin" />

	<table style="border: 1px solid; width: 500px; text-align: center">
		<thead style="background: #fcf">
			<tr>
				<th>User Id</th>
				<th>Username</th>
				<th>Enabled</th>
				<th>Authority</th>
				<th colspan="3"></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.userId}" /></td>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.enabled}" /></td>
					<td><c:out value="${user.authority.authorityName}" /></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<p>
		<a href="${addLoginUrl}">Add a Login</a>
	</p>
	<p>
		<a href="../admin">Go to Admin Welcome page</a>
	</p>
	<p>
		<a href="../member">Go to Member Welcome page</a>
	</p>
	<p>
		<a href="../">Go to Home page</a>
	</p>

</body>
</html>
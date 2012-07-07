<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New Login</title>
</head>
<body>

	<h1>Create New User</h1>

	<c:url var="saveUrl" value="addLogin" />
	<form:form  commandName="userAttribute" method="POST"
		action="${saveUrl}">
		<table>
			<tr>
				<td><form:label path="username">User Name:</form:label></td>
				<td><form:input path="username" /></td>
			</tr>

			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:input type="password" path="password" /></td>
			</tr>

			<tr>
				<td><form:label path="enabled">Enabled :</form:label></td>
				<td><form:input path="enabled" /></td>
			</tr>
<%-- 
			<tr>
				<form:label path="authority">Authority:</form:label>
				<form:select path="authority" itemValue="authorityName">
					<c:forEach items="${authorities}" var="auth">
						<form:option value="${auth.getAuthorityName()}" itemLabel="${auth.getAuthorityName()}"></form:option>
					</c:forEach>
				</form:select>
			</tr>
 --%>
 			<tr>
				<form:label path="authority.authority_id">Authority:</form:label>
				<form:select path="authority.authority_id" items="${authorities}" itemValue="authority_id" itemLabel="authorityName" >
<%-- 					<form:options items="${authorities}" itemValue="authorityName" itemLabel="authorityName" />			 --%>		
 				</form:select>
 			</tr>
		</table>

		<input type="submit" value="Save" />
	</form:form>

</body>
</html>
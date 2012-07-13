<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send Mail Form</title>
</head>
<body>
	<form:form commandName="mailDataKey" method="POST" action="mailForm">
		<table>
			<tr>
				<td><form:label path="from">From:</form:label></td>
				<td><form:input path="from" /></td>
			</tr>

			<tr>
				<td><form:label path="to">To:</form:label></td>
				<td><form:input path="to" /></td>
			</tr>
			
			<tr>
				<td><form:label path="subject">Subject:</form:label></td>
				<td><form:input path="subject" /></td>
			</tr>
			
			<tr>
				<td><form:label path="body">Body:</form:label></td>
				<td><form:input path="body" /></td>
			</tr>
			
		</table>

		<input type="submit" value="Send Mail" />
	</form:form>

</body>
</html>
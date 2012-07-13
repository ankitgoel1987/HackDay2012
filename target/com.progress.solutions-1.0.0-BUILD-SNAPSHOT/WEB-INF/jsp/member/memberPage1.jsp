<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- This is needed for the logout to work properly. -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEMBER PAGE 1 (JSP)</title>
    </head>
    <body>
    	<h3>Welcome member.</h3>
        <p>This is a member welcome page.</p>
        
        <p><a href='<spring:url value="/j_spring_security_logout" htmlEscape="true" />'>Logout</a></p>
        <p><a href="admin">Go to Admin welcome page</a></p>
        <p><a href="admin/listLogin">Show Logins</a></p>
        <p><a href="">Go to Home page</a></p>
    </body>
</html>
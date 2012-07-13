<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.security.Principal"%>
<%@page
	import="org.springframework.security.authentication.UsernamePasswordAuthenticationToken"%>
<%@page import="java.util.List"%>
<%@page
	import="org.springframework.security.core.authority.GrantedAuthorityImpl"%>
<%@page import="com.progress.jpa.Users"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INDEX (JSP)</title>
</head>
<body>

	<%
		Principal p1 = (Principal) session.getAttribute("principal");
		Principal p2 = (Principal) request.getAttribute("principal");

		out.println(p1 + " ---- " + p2 + " ---- ");
	%>

	<%
		boolean authenticated = false;
		String authority = "";
		Users user = new Users();
		UsernamePasswordAuthenticationToken principal = (UsernamePasswordAuthenticationToken) request
				.getAttribute("principal");
		if (principal != null) {
			authenticated = principal.isAuthenticated();
			if (authenticated == false) {
				authority = "";
				user = new Users();
			} else {
				user = (Users) principal.getPrincipal();
				List authorities = ((List) principal.getAuthorities());
				if (authorities.size() > 0) {
					GrantedAuthorityImpl auth = (GrantedAuthorityImpl) authorities
							.get(0);
					authority = auth.getAuthority();
				}
			}
		}
	%>
	<p>This is the index/home page.</p>
	<p>
		<a href="member">Go to Member welcome page (memberPage1)</a>
	</p>
	<p>
		<a href="admin">Go to Admin welcome page (adminPage1)</a>
	</p>
	<p>
		<a href="">Go to Home Page (index page)</a>
	</p>
	<p>
		<a href="login">Go to Login page</a>
	</p>
	<br />
	<p>
		<a href="mailForm">Send Mail Form</a>
	</p>
	<p>
		<a href="fbAuth">Click this to get Facebook Authentication</a>
	</p>


</body>
</html>
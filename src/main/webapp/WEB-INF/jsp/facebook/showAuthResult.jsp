<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facebook Authentication Result</title>
</head>
<body>
	<h3>Returned from Facebook...</h3>

	<form:form commandName="authTokenHolder" method="POST" action="FbPost"
		name="hiddenForm">
		<form:input type="hidden" name="authTokenAttrib" path="authToken" />
		<input type="submit" name="Post A Message" onclick="postAMessage(this.form)"/>
	</form:form>

	<script type="text/javascript">
	function postAMessage(form){
		document.write("called postamessage method");
		//var hiddenForm = document.forms["hiddenForm"];
		var urlFragment = window.location.hash.substring(1);
		var arrayOfParams = urlFragment.split("&");
		for ( var i = 0; i < arrayOfParams.length; i++) {
			if (arrayOfParams[i].indexOf("access_token") == 0) {
				var accessTokenWithValue = arrayOfParams[i].split("=");
				var accessToken = accessTokenWithValue[1];
				document.writeln("The Facebook Access Token Found:  "
						+ accessToken);
				form.authTokenAttrib.value = accessToken;
				document.writeln("<br>The populated form data value "+form.authTokenAttrib.value);
			}
		}
		document.write("<br>submitting form");
		form.submit();
	}
	</script>
	<br />
	<br />
</body>
</html>
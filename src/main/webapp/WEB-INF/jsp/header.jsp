<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="org.springframework.security.authentication.UsernamePasswordAuthenticationToken"%>
<%@page import="java.util.List"%>
<%@page
	import="org.springframework.security.core.authority.GrantedAuthorityImpl"%>
<%@page import="com.progress.jpa.Users"%>
<!DOCTYPE html >
<html>
<head>
<script>
	function initialize_map() {
		// Check for geo-location support
		//	if (navigator.geolocation) {
		// Use method getCurrentPosition to get coordinates
		//		navigator.geolocation.getCurrentPosition(function(position) {
		// Access them accordingly
		//			console.log(position);
		//			var currentLatLng = new google.maps.LatLng(
		//					position.coords.latitude, position.coords.longitude);

		var currentLatLng = new google.maps.LatLng(17.46651, 78.36321659999999);

		var myOptions = {
			center : currentLatLng,
			zoom : 8,
			mapTypeId : google.maps.MapTypeId.ROADMAP,
			streetViewControl : false,
			panControl : false,
			mapTypeControl : false,
			//				zoomControlOptions : {
			//					style : google.maps.ZoomControlStyle.SMALL
			//				}
			zoomControl : false
		};
		map = new google.maps.Map(document.getElementById("map_canvas"),
				myOptions);
		map.setCenter(currentLatLng);
		//			console.log(currentLatLng);
		//			showMarker(currentLatLng);
		//		});
		//	}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Golf Club</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-responsive.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/modifiedBootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/datepicker.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/loadSocialSdk.js" />"></script>
<link rel="shortcut icon"
	href="<c:url value="/resources/img/icon.ico" />" />
</head>
<body>
	<div id="fb-root"></div>
	<script>
		//Loading FB SDK
		load_FB_sdk('361202527286458');
		loadTwitter();
	</script>

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
	<div class="container">
		<!-- Top container -->
		<div class="container"
			style="height: 106px; background-color: #f5f5f5;">
			<!-- Banner -->
			<!-- Banner Image  -->

			<img class="banner-image" alt="banner image"
				style="height: 106px; width: 77%"
				src="<c:url value="/resources/img/top_backgroundImage_1.jpg" />
			" />

			<!-- Social Integration -->
			<div class="banner-top-right" style="height: 80px; width: 20%;">
				<address>
					<strong>Golf Club</strong><br> Manikonda Village, Gachibowli<br>
				</address>
				<div>
					<div class="pull-left" style="width: 40%">
						<a href="https://twitter.com/share" class="twitter-share-button"
							data-url="http://progress_ankit.cloudfoundry.com/home">Tweet</a>

					</div>

					<div style="width: 45%" class="fb-like fb-Button pull-right"
						data-href="http://localhost:8080/BootstrapSampleProject/learningBootstrap.jsp"
						data-send="false" data-layout="button_count" data-width="20"
						data-show-faces="false" data-action="Like" data-font="segoe ui"></div>
				</div>
			</div>

		</div>
		<!-- Navigation bar -->
		<div class="container">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container">
						<ul class="nav">
							<a class="brand" href="home">Golf Club </a>
							<li class="divider-vertical"></li>
							<li class="active"><a href="home">Home</a></li>
							<li class="divider-vertical"></li>
							<li><a href="location">Explore</a></li>
							<li class="divider-vertical"></li>
							<li><a href="gallery">Gallery</a></li>

						</ul>
						<%
							if (authenticated) {
						%>
						<ul class="nav pull-right">
							<li class="dropdown" id="SignIn"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"><img alt="user Pic"
									src="https://fbcdn-profile-a.akamaihd.net/hprofile-ak-snc4/273986_669104098_85932325_q.jpg"
									height="20px" width="20px"> <%
 	out.println(user.getName());
 %> <b class="caret"></b> </a>
								<ul class="dropdown-menu">
									<li><a href="accountsettings">Account settings</a></li>
									<li><a href="bookteetime">Book Tee Time</a></li>
									<li><a href="myBookings">My Bookings</a></li>
									<li class="divider"></li>
									<li><a href="golfCourseMemberList">List og Golf Course
											Members</a></li>
									<li><a href="golfCourseList">List of Golf Courses</a></li>
									<li class="divider"></li>
									<li><a href="gcRegistration">GolfCourseRegistration</a></li>
									<li class="divider"></li>
									<li><a
										href='<spring:url value="/j_spring_security_logout" htmlEscape="true" />'>Sign
											out</a></li>
								</ul></li>
						</ul>
						<%
							} else {
						%>

						<ul class="nav pull-right">
							<li><a data-toggle="modal" href="#myModal">Create an
									account</a></li>
							<li class="divider-vertical"></li>
							<li class="dropdown" id="SignIn"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"> Sign in <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li>

										<form id="login_form" class="form-vertical"
											action="j_spring_security_check" method="POST"
											style="margin: 15px;">
											<fieldset>
												<div class="control-group">
													<label class="control-label" for="j_username">E-mail</label>
													<div class="controls">
														<input type="text" class="input-large" name="j_username"
															id="j_username">
													</div>
													<label class="control-label" for="j_password">Password</label>
													<div class="controls">
														<input type="password" class="input-large"
															name="j_password" id="j_password">
													</div>
													<div class="form-inline">
														<button type="submit" class="btn pull-left">Sign
															in</button>
													</div>
												</div>
											</fieldset>
										</form>
									</li>
								</ul></li>
						</ul>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>

		<!-- Model for register form -->

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">x</button>
				<h3>Create account</h3>
			</div>
			<div class="modal-body" style="height: 370px;">
				<div id="formOne">
					<iframe
						src="https://www.facebook.com/plugins/registration?
             client_id=361202527286458&
             redirect_uri=http://localhost:8080/solutions/registerNewUser&
             fields=[
                { 'name':'name' },
                { 'name':'birthday' },
                { 'name':'gender' },
                { 'name':'location' },
                { 'name':'phone', 'description':'Phone Number', 'type':'text' },
                { 'name':'email' },
                { 'name':'password' },
                ]"
						scrolling="
						auto" frameborder="no" style="border: none"
						allowTransparency="true" width="100%" height="360px"> </iframe>
				</div>

			</div>

		</div>
	</div>
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
		<div class="container container-top">
			<!-- Banner -->
			<div class="row show-grid">
				<!-- Banner Image  -->
				<div class="span10">
					<img class="banner-image" alt="banner image"
						src="<c:url value="/resources/img/top_backgroundImage_1.jpg"/>" />
				</div>
				<!-- Social Integration -->
				<div class="banner-top-right span2 offset10">
					<div>
						<address>
							<strong>Golf Club</strong><br> 795 Folsom Ave, Suite 600<br>
						</address>
						<div>
							<div class="pull-left" style="width: 40%">
								<a href="https://twitter.com/share" class="twitter-share-button"
									data-url="http://localhost:8080/BootstrapSampleProject/learningBootstrap.jsp">Tweet</a>
								<script>
									
								</script>
							</div>

							<div style="width: 45%" class="fb-like fb-Button pull-right"
								data-href="http://localhost:8080/BootstrapSampleProject/learningBootstrap.jsp"
								data-send="false" data-layout="button_count" data-width="20"
								data-show-faces="false" data-action="Like" data-font="segoe ui"></div>
						</div>
					</div>


				</div>

			</div>
		</div>
		<!-- Navigation bar -->
		<div class="container">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container">
						<ul class="nav">
							<a class="brand" href="home">Happy Golf Club </a>
							<li class="divider-vertical"></li>
							<li class="active"><a href="home">Home</a></li>
							<li class="divider-vertical"></li>
							<li><a href="location">Explore</a></li>
							<li class="divider-vertical"></li>
							<li><a href="#">Services</a></li>
							<li><a href="gallery">Gallery</a></li>
							<li><a href="#">About Us</a></li>
							<li class="divider-vertical"></li>
							<li><a href="confirmReg">Confirm Registration</a></li>
							<li><a href="confirmBooking">Confirm Booking</a></li>
							<li><a href="sendReminder">Send Reminder</a></li>

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

										<form class="well form-vertical"
											action="j_spring_security_check" method="POST">
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
				<h3>Modal header</h3>
			</div>
			<div class="modal-body">
				<div id="formOne">
					<iframe
						src="https://www.facebook.com/plugins/registration?
             client_id=361202527286458&
             redirect_uri=http://localhost:8080/BootstrapSampleProject/sample.jsp&
             fields=name,birthday,gender,location,email,password"
						scrolling="auto" frameborder="no" style="border: none"
						allowTransparency="true" width="100%" height="330"> </iframe>
				</div>

				<div id="formTwo">
					<p>Two fine body</p>
				</div>

				<div id="formThree">
					<p>Three fine body</p>
				</div>

			</div>

		</div>
	</div>
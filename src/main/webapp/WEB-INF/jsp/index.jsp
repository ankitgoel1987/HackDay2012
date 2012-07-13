<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Golf Club</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-responsive.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/modifiedBootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/loadFBSdk.js" />"></script>
</head>
<body>
	<div id="fb-root"></div>
	<script>
		//Loading FB SDK
		load_FB_sdk('361202527286458');
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
			<div class=" top-right">
				<div>
					<address>
						<strong>Contact us:</strong><br> <a href="mailto:#">pavan@gmail.com</a>
					</address>
				</div>
				<div>
					<a href="https://twitter.com/share" class="twitter-share-button"
						data-url="http://localhost:8080/BootstrapSampleProject/learningBootstrap.jsp">Tweet</a>
					<script>
						!function(d, s, id) {
							var js, fjs = d.getElementsByTagName(s)[0];
							if (!d.getElementById(id)) {
								js = d.createElement(s);
								js.id = id;
								js.src = "//platform.twitter.com/widgets.js";
								fjs.parentNode.insertBefore(js, fjs);
							}
						}(document, "script", "twitter-wjs");
					</script>
				</div>
				<div class="fb-like fb-Button"
					data-href="http://localhost:8080/BootstrapSampleProject/learningBootstrap.jsp"
					data-send="false" data-layout="button_count" data-width="20"
					data-show-faces="false" data-action="Like" data-font="segoe ui"></div>
			</div>
		</div>

		<div class="container">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container">
						<ul class="nav">
							<a class="brand" href="#">Happy Golf Club </a>
							<li class="divider-vertical"></li>
							<li class="active"><a href="#">Home</a></li>
							<li class="divider-vertical"></li>
							<li><a href="#">Explore</a></li>
							<li class="divider-vertical"></li>
							<li><a href="#">Services</a></li>
							<li class="divider-vertical"></li>
							<li><a href="#">Link</a></li>

						</ul>
						<%
							if (authenticated) {
						%>
						<ul class="nav pull-right">
							<li class="dropdown" id="SignIn"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"><img alt="user Pic"
									src="https://fbcdn-profile-a.akamaihd.net/hprofile-ak-snc4/273986_669104098_85932325_q.jpg"
									height="20px" width="20px"> <% out.println(user.getName()); %> <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Account settings</a></li>
									<li><a href="#">Recent activities</a></li>
									<li><a href="#">Booking</a></li>
									<li class="divider"></li>
									<li><a href='<spring:url value="/j_spring_security_logout" htmlEscape="true" />'>Sign out</a></li>
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
														<input type="password" class="input-large" name="j_password"
															id="j_password">
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

		<!-- Photo slide show -->

		<div id="myCarousel" class="carousel slide container">
			<div class="carousel-inner">
				<div class="item">
					<img src="./image/glyphicons-halflings.png" alt="iamge 1">
					<div class="carousel-caption">
						<h4>First Thumbnail label</h4>
						<p>Image 1.</p>
					</div>
				</div>
				<div class="item">
					<img src="./image/glyphicons-halflings-white.png" alt="image 2">
					<div class="carousel-caption">
						<h4>Second Thumbnail label</h4>
						<p>Image 2.</p>
					</div>
				</div>
				<div class="item active">
					<img src="./image/top_backgroundImage_1.jpg" alt="image 3">
					<div class="carousel-caption">
						<h4>Third Thumbnail label</h4>
						<p>Image 3.</p>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="right carousel-control" href="#myCarousel"
				data-slide="next">&rsaquo;</a>
		</div>

		<div class="container">

			<div class="hero-unit pull-left-intro">
				<p>Introduction of golf course</p>

			</div>

			<div class="accordion pull-right-events" id="accordion2">
				<strong>Latest News & Events</strong>
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseOne"> Collapsible
							Group Item #1 </a>
					</div>
					<div id="collapseOne" class="accordion-body collapse in">
						<div class="accordion-inner">Anim pariatur cliche
							reprehenderit, enim eiusmod high life accusamus terry richardson
							ad squid. 3 wolf moon officia aute, non cupidatat skateboard
							dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch
							3 wolf moon tempor, sunt aliqua put a bird on it squid
							single-origin coffee nulla assumenda shoreditch et. Nihil anim
							keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
							sapiente ea proident. Ad vegan excepteur butcher vice lomo.
							Leggings occaecat craft beer farm-to-table, raw denim aesthetic
							synth nesciunt you probably haven't heard of them accusamus
							labore sustainable VHS.</div>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseTwo"> Collapsible
							Group Item #2 </a>
					</div>
					<div id="collapseTwo" class="accordion-body collapse">
						<div class="accordion-inner">Anim pariatur cliche
							reprehenderit, enim eiusmod high life accusamus terry richardson
							ad squid. 3 wolf moon officia aute, non cupidatat skateboard
							dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch
							3 wolf moon tempor, sunt aliqua put a bird on it squid
							single-origin coffee nulla assumenda shoreditch et. Nihil anim
							keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
							sapiente ea proident. Ad vegan excepteur butcher vice lomo.
							Leggings occaecat craft beer farm-to-table, raw denim aesthetic
							synth nesciunt you probably haven't heard of them accusamus
							labore sustainable VHS.</div>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseThree"> Collapsible
							Group Item #3 </a>
					</div>
					<div id="collapseThree" class="accordion-body collapse">
						<div class="accordion-inner">Anim pariatur cliche
							reprehenderit, enim eiusmod high life accusamus terry richardson
							ad squid. 3 wolf moon officia aute, non cupidatat skateboard
							dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch
							3 wolf moon tempor, sunt aliqua put a bird on it squid
							single-origin coffee nulla assumenda shoreditch et. Nihil anim
							keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
							sapiente ea proident. Ad vegan excepteur butcher vice lomo.
							Leggings occaecat craft beer farm-to-table, raw denim aesthetic
							synth nesciunt you probably haven't heard of them accusamus
							labore sustainable VHS.</div>
					</div>
				</div>
			</div>
		</div>

		<div class="container well">

			<div class="footer-list-one">
				<strong>About us</strong>
				<ul>
					<li>Lorem ipsum dolor sit amet</li>
					<li>Consectetur adipiscing elit</li>
					<li>Integer molestie lorem at massa</li>
					<li>Facilisis in pretium nisl aliquet</li>
					<li>Nulla volutpat aliquam velit
						<ul>
							<li>Phasellus iaculis neque</li>
							<li>Purus sodales ultricies</li>
							<li>Vestibulum laoreet porttitor sem</li>
							<li>Ac tristique libero volutpat at</li>
						</ul>
					</li>
					<li>Faucibus porta lacus fringilla vel</li>
					<li>Aenean sit amet erat nunc</li>
					<li>Eget porttitor lorem</li>
				</ul>


			</div>
			<div class="footer-list-two">
				<strong>Team</strong>
				<ul>
					<li>Lorem ipsum dolor sit amet</li>
					<li>Consectetur adipiscing elit</li>
					<li>Integer molestie lorem at massa</li>
					<li>Facilisis in pretium nisl aliquet</li>
					<li>Nulla volutpat aliquam velit
						<ul>
							<li>Phasellus iaculis neque</li>
							<li>Purus sodales ultricies</li>
							<li>Vestibulum laoreet porttitor sem</li>
							<li>Ac tristique libero volutpat at</li>
						</ul>
					</li>
					<li>Faucibus porta lacus fringilla vel</li>
					<li>Aenean sit amet erat nunc</li>
					<li>Eget porttitor lorem</li>
				</ul>

			</div>
			<div class="footer-list-three">
				<strong>Contact us</strong>
				<ul>
					<li>Lorem ipsum dolor sit amet</li>
					<li>Consectetur adipiscing elit</li>
					<li>Integer molestie lorem at massa</li>
					<li>Facilisis in pretium nisl aliquet</li>
					<li>Nulla volutpat aliquam velit
						<ul>
							<li>Phasellus iaculis neque</li>
							<li>Purus sodales ultricies</li>
							<li>Vestibulum laoreet porttitor sem</li>
							<li>Ac tristique libero volutpat at</li>
						</ul>
					</li>
					<li>Faucibus porta lacus fringilla vel</li>
					<li>Aenean sit amet erat nunc</li>
					<li>Eget porttitor lorem</li>
				</ul>

			</div>
		</div>
	</div>
	<script
		src="///ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script src="<c:url value="/resources/js/sample.js" />"></script>
</body>
</html>
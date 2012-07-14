<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Golf Club Booking</title>
<link href="./css/bootstrap.css" rel="stylesheet">
<link href="./css/bootstrap-responsive.css" rel="stylesheet">
<link href="./css/modifiedBootstrap.css" rel="stylesheet">
<link href="./css/datepicker.css" rel="stylesheet">
<link href="./css/app.css" rel="stylesheet">
<link href="./css/style.css" rel="stylesheet">
</head>
<body>
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_GB/all.js#xfbml=1&appId=361202527286458";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<div class="container-top well">
		<div class=" pull-right-top">
			<div>
				<address>
					<strong>Contact us:</strong><br> <a href="mailto:#">gijoe@gmail.com</a>
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
				data-show-faces="false" data-action="Like" data-font="segoe ui">
			</div>
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

					<ul class="nav pull-right">
						<li class="dropdown" id="SignIn"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"><img alt="user Pic"
								src="https://fbcdn-profile-a.akamaihd.net/hprofile-ak-snc4/273986_669104098_85932325_q.jpg"
								height="20px" width="20px"> User name <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">Account settings</a></li>
								<li><a href="#">Recent activities</a></li>
								<li><a href="#">Booking</a></li>
								<li class="divider"></li>
								<li><a href="#">Sign out</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- Model for enter booking details form -->

	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">x</button>
			<h3>Booking form</h3>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
				class="btn btn-primary">Confirm booking</a>
		</div>
	</div>
	<div class="container" style="margin-left: 10%;">

		<table class="table table-striped table-bordered">
			<thead>
			</thead>
			<tbody>
				<form action="#" id="contact-form" class="form-horizontal">
					<fieldset>
						<legend> Your infromation Form </legend>
						<div class="control-group">
							<label class="control-label" for="name">Golf Club Name</label>
							<div class="controls">
								<input type="text" class="input-xlarge" name="name" id="name">
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="name">Branding Image</label>
							<div class="controls">
								<input class="input-file" id="fileInput" type="file">
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="name">Home Page Menu
								Name</label>
							<div class="controls">
								<input type="text" class="input-xlarge" name="name" id="name">
							</div>
						</div>
						
						
						<div class="control-group">
							<label class="control-label" for="name">Home Page</label>
							<div class="controls">
								<input type="text" class="input-xlarge" name="name" id="name">
							</div>
						</div>
						
						
						<div class="control-group">
							<label class="control-label" for="name">Facility Page</label>
							<div class="controls">
								<input type="text" class="input-xlarge" name="name" id="name">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="name">Facility Page Menu Name</label>
							<div class="controls">
								<input type="text" class="input-xlarge" name="name" id="name">
							</div>
						</div>
						
						
						<div class="control-group">
							<label class="control-label" for="name">Theme Dropdown(colors)</label>
							<div class="controls">
								<select id="select01">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="name">Location Golf
								Course lat long</label>
							<div class="controls">
								<input type="text" class="input-xlarge" name="name" id="name">
							</div>
						</div>

						<div class="form-actions">
							<button type="submit" class="btn">Submit</button>
							<button type="reset" class="btn">Cancel</button>
						</div>
					</fieldset>
				</form>
			</tbody>
		</table>
	</div>

	<div class="container well footer">
		<div class="footer-list-one">
			<strong>About us</strong>
		</div>

		<div class="footer-list-two">
			<strong>Team</strong>
		</div>

		<div class="footer-list-three">
			<strong>Contact us</strong>
		</div>
	</div>

	<script
		src="///ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

	<!-- Validate Plugin -->
	<script src="./js/jquery.validate.min.js"></script>

	<script src="./js/bootstrap.js"></script>
	<script src="./js/sample.js"></script>
</body>
</html>
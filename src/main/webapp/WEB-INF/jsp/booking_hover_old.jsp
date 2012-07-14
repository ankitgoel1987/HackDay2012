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
		<div class="modal-body">
			<div id="formOne">
				<select id="select01">
					<option>something</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
			</div>


		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
				class="btn btn-primary">Confirm booking</a>
		</div>
	</div>
	<div class="container">

		<table class="table table-striped table-bordered">
			<thead>
			<div class="input-append date" id="datepicker" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
				<input class="span2" size="16" type="text" value="12-02-2012" readonly="true">
				<span class="add-on"><i class="icon-th"></i></span>
			</div>
			
				<tr>
					<th>Timings</th>
					<th>Weather</th>
					<th>Availability</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>6:00AM-7:00AM</td>
					<td>
						<div style="width: 128px;">

							<table>
								<thead>
									<tr>
										<th>Overcast</th>
										<th>61 F</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><img alt="weather icon"
											src="http://icons-ak.wxug.com/i/c/k/cloudy.gif"></td>
										<td style="vertical-align: middle;">78%</td>
									</tr>
								</tbody>
							</table>

						</div>
					</td>
					<td id="r1c3">Availability detail <a id="r1c4"
						class="btn btn-primary" data-toggle="modal" href="#myModal">Book</a></td>
				</tr>

				<tr>
					<td>7:00AM-8:00AM</td>
					<td>

						<div style="width: 128px;">

							<table>
								<thead>
									<tr>
										<th>Overcast</th>
										<th>61 F</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><img alt="weather icon"
											src="http://icons-ak.wxug.com/i/c/k/cloudy.gif"></td>
										<td style="vertical-align: middle;">78%</td>
									</tr>
								</tbody>
							</table>

						</div>

					</td>
					<td id="r2c3">Availability detail <a id="r2c4"
						class="btn btn-primary" data-toggle="modal" href="#myModal">Book</a></td>
				</tr>

				<tr>
					<td>8:00AM-9:00AM</td>
					<td>

						<div style="width: 128px;">

							<table>
								<thead>
									<tr>
										<th>Overcast</th>
										<th>61 F</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><img alt="weather icon"
											src="http://icons-ak.wxug.com/i/c/k/cloudy.gif"></td>
										<td style="vertical-align: middle;">78%</td>
									</tr>
								</tbody>
							</table>

						</div>

					</td>
					<td id="r3c3">Availability detail <a id="r3c4"
						class="btn btn-primary" data-toggle="modal" href="#myModal">Book</a></td>
				</tr>
				
				<tr>
					<td>9:00AM-10:00AM</td>
					<td>
						<div style="width: 145px;">
							<div style="float: left; vertical-align: middle;">
								<img alt="weather icon"
									src="http://icons-ak.wxug.com/i/c/k/cloudy.gif"
									style="padding-top: 20%;">
							</div>
							<table style="float: right;">
								<thead>
									<tr>
										<th colspan="2"
											style="vertical-align: middle; text-align: center;">Overcast</th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td style="vertical-align: middle; text-align: center;">61
											F</td>
										<td style="vertical-align: middle; text-align: center;">78%</td>
									</tr>

								</tbody>
							</table>

						</div>
					</td>




					<td id="r4c3">Availability detail <a id="r4c4"
						class="btn btn-primary" data-toggle="modal" href="#myModal">Book</a>
						<a id="example" href="#" class="btn btn-danger" rel="popover"
						data-content="And here's some amazing content. It's very engaging. right?"
						data-original-title="A Title">hover for popover</a>
					</td>
				</tr>

				<tr>
					<td>10:00AM-11:00AM</td>
					<td>Weather Box</td>
					<td>Availability detail</td>
				</tr>

				<tr>
					<td>11:00AM-12:00PM</td>
					<td>Weather Box</td>
					<td>Availability detail</td>
				</tr>

				<tr>
					<td>12:00PM-1:00PM</td>
					<td>Weather Box</td>
					<td>Availability detail</td>
				</tr>

				<tr>
					<td>1:00PM-2:00PM</td>
					<td>Weather Box</td>
					<td>Availability detail</td>
				</tr>

				<tr>
					<td>2:00PM-3:00PM</td>
					<td>Weather Box</td>
					<td>Availability detail</td>
				</tr>

				<tr>
					<td>3:00PM-4:00PM</td>
					<td>Weather Box</td>
					<td>Availability detail</td>
				</tr>

				<tr>
					<td>4:00PM-5:00PM</td>
					<td>Weather Box</td>
					<td>Availability detail</td>
				</tr>

				<tr>
					<td>5:00PM-6:00PM</td>
					<td>Weather Box</td>
					<td>Availability detail</td>
				</tr>
			</tbody>
		</table>


	</div>

	<div class="container well footer">

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


	<script
		src="///ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="./js/bootstrap.js"></script>
	<script src="./js/sample.js"></script>
</body>
</html>
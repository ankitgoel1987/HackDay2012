<jsp:include page="header.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="json.parse.hourlydata.*"%>
<%@page import="java.util.ArrayList"%>




<!-- Model for enter booking details form -->

<div class="modal hide fade" id="myModal">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">x</button>
		<h3>Booking form</h3>
	</div>
	<div class="modal-body">
		<div id="formOne">
			<select id="select01">
				<option>1</option>
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
			<tr>
				<th>Timings</th>
				<th>Weather</th>
				<th>Availability</th>
			</tr>
		</thead>
		<tbody>
			<div class="modal hide fade" id="myNewModal">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">x</button>
					<h3>Booking form</h3>
				</div>
				<div class="modal-body">
					<div id="formOne">
						<select id="select01">
							<option>1</option>
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


			<%
				//TODO:The current date will come from javascript
				ArrayList alist = WeatherAPI_New.get12HourList("14", "7", "2012");
			
				for (int i = 0; i < alist.size(); i++) {
					MyHourlyData data = (MyHourlyData) alist.get(i);
					int hour1 = data.getDate().getHours();
					int hour2 = hour1 + 1;
					String condition = data.getCondition();
					String temp = data.getTemp().getValue();
					String icon_url = data.getIconUrl();
					String humidity = data.getHumidity();
			%>

			<tr>
				<td><%=hour1%> - <%=hour2%> AM</td>
				<td>
					<div style="width: 145px;">
						<div style="float: left; vertical-align: middle;">
							<img alt="weather icon" src="<%=icon_url%>"
								style="padding-top: 20%;">
						</div>
						<table style="float: right;">
							<thead>
								<tr>
									<th colspan="2"
										style="vertical-align: middle; text-align: center;"><%=condition%></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="vertical-align: middle; text-align: center;"><%=temp%>
										F</td>
									<td style="vertical-align: middle; text-align: center;"><%=humidity%></td>
								</tr>
							</tbody>
						</table>
					</div>
				</td>

				<td id="r4c3">Availability detail <a id="r4c4"
					class="btn btn-primary" data-toggle="myNewModal" href="#myNewModal">Book</a>
					<a id="example" href="#" class="btn btn-danger" rel="popover"
					data-content="And here's some amazing content. It's very engaging. right?"
					data-original-title="A Title">hover for popover</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>

<jsp:include page="footer.jsp" />
</html>
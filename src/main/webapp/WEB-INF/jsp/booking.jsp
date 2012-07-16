<jsp:include page="header.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="json.parse.hourlydata.*"%>
<%@page import="java.util.*"%>
<%@page import="com.progress.jpa.HourlyData"%>




<!-- Model for enter booking details form -->

<div class="modal hide fade" id="myNewModal">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">x</button>
		<h3>Booking form</h3>
	</div>
	<div class="modal-body">
		<form class="form-horizontal">
			<fieldset>
				<div>
					<div class="control-group">
						<label class="control-label" for="input01">Selected date</label>
						<div class="controls">
							<input type="text" class="input-xlarge disabled"
								id="selected_date" disabled>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="input01">Selected slot</label>
						<div class="controls">
							<input type="text" class="input-xlarge disabled"
								id="selected_slot" disabled>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="input01">Number of
							golfers</label>
						<div class="controls">
							<select class="input-xlarge" id="select01">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn" data-dismiss="modal">Close</a> <input
			type="button" class="btn btn-primary" value="Confirm Booking">
	</div>
</div>

<div class="container">
	<!-- Date picker -->

	<%
		//TODO:The current date will come from javascript
		String date = (String) request.getAttribute("date");
	%>

	<form method="POST" action="bookteetime" id="contact-form"
		class="form-horizontal">
		<div class="input-append date" id="datepicker-to"
			data-date="<%=date%>" data-date-format="dd-mm-yyyy">

			<input id="date-selector" size="16" type="text"
				name=date-selector-to value="<%=date%>" readonly> <span
				class="add-on"><i class="icon-th"></i></span>
			<button type="submit" class="btn btn-primary">Show Schedule</button>
		</div>
	</form>

	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Timings</th>
				<th>Weather</th>
				<th>Slots Left</th>
			</tr>
		</thead>
		<tbody>


			<%
				//TODO:The current date will come from javascript
				Map reservationDetailsMap = (Map) request
						.getAttribute("reservationDetailsMap");
				Map hourlyDetailsMap = (Map) request.getAttribute("hourlyDataMap");
				Map capacityDetailsMap = (Map) request.getAttribute("capacityMap");

				for (Iterator iterator = reservationDetailsMap.keySet().iterator(); iterator
						.hasNext();) {
					String timeRange = iterator.next().toString();
					HourlyData data = (HourlyData) hourlyDetailsMap.get(timeRange);
					int maxcapacity = (Integer) capacityDetailsMap.get(timeRange);
					int noofGolfers = (Integer) reservationDetailsMap
							.get(timeRange);
					boolean weatherDataAvailable = true;
					String condition = "";
					String temp = "";
					String icon_url = "";
					String humidity = "";
					if (data == null) {
						weatherDataAvailable = false;
					} else {
						condition = data.getCondition();
						temp = data.getTemperature();
						icon_url = data.getIconUrl();
						humidity = data.getHumidity();
					}
					int slotsRemaining = maxcapacity - noofGolfers;
			%>

			<tr>
				<td><%=timeRange%></td>
				<td>
					<%
						if (weatherDataAvailable) {
					%>
					<div style="width: 250px;">
						<div style="float: left; vertical-align: middle;">
							<img alt="weather icon" src="<%=icon_url%>"
								style="padding-top: 20%;">
						</div>
						<table style="float: left; margin-left: 5%;">
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
					</div> <%
 	} else {
 %> Weather data not available <%
 	}
 %>
				</td>
				<%
					if (slotsRemaining > 0) {
				%>
				<td id="r4c3"><%=slotsRemaining%> <a id="<%=timeRange%>"
					class="btn btn-primary" data-toggle="modal" href="#myNewModal">Book</a></td>
				<%
					} else {
				%>
				<td id="r4c3"><%=slotsRemaining%></td>
				<%
					}
				%>


			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>

<jsp:include page="footer.jsp" />
</html>
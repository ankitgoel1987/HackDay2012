<jsp:include page="header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Middle part for booking table -->
<div class="container">
	<div>

		<c:url var="searchURL" value="searchMyBookings" />
		<c:url var="cancelBookingURL" value="cancelMyBooking" />

		<form:form commandName="searchBookings" method="POST"
			action="${searchURL}" class="form-horizontal">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="input01">Search by
						booking ID</label>
					<div class="controls">
						<!-- Make this type ahead -->
						<form:input path="searchText" class="input-xlarge" id="searchText" />
						<button type="submit" class="btn btn-primary">Search</button>
					</div>
				</div>
			</fieldset>
		</form:form>

	</div>
	<form class="form-horizontal"
		action="${cancelBookingURL}" method="POST">
		<div>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>Confirmation Id</th>
						<th>Booking Date</th>
						<th>Match Date</th>
						<th>Number of Golfers</th>
						<th>Booking Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${reservationdetailsList.reservationDetails}"
						var="temp">
						<tr>
							<td><input type="checkbox" id="${temp.confirmationNumber}" name="${temp.confirmationNumber}" /></td>
							<td><c:out value="${temp.confirmationNumber}" /></td>
							<td><c:out value="${temp.bookingDateTime}" /></td>
							<td><c:out value="${temp.teeDateTime}" /></td>
							<td><c:out value="${temp.noOfGolfers}" /></td>
							<td><c:out value="${temp.status}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<button type="submit" class="btn btn-danger" id="cancelMyBooking">Cancel
			Booking</button>
	</form>
</div>
<jsp:include page="footer.jsp" />
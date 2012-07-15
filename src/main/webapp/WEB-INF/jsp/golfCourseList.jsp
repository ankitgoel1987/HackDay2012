<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp" />

<!-- Middle part for booking table -->
<div class="container">
	<div>
		<form class="form-horizontal">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="input01">Search Golf
						Course</label>
					<div class="controls">
						<!-- Make this type ahead -->
						<input type="text" class="input-xlarge" id="input01">
						<button type="submit" class="btn btn-primary">Search</button>
					</div>

				</div>

			</fieldset>
		</form>
	</div>

	<div>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>Golf Course Name</th>
					<th>Golf Course Owner</th>
					<th>E-mail</th>
					<th>Contact Number</th>
				</tr>
			</thead>
		</table>
	</div>
	<form:form commandName="reservationdetailsList" method="POST" action="" class="form-horizontal">
		<div>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>Golf CourseName</th>
						<th>Latitude</th>
						<th>Longitude</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allGolfCourses}" var="temp">
						<tr>
							<td><input type="checkbox" id="${temp.golfCourseId}" /></td>
							<td><c:out value="${temp.name}" /></td>
							<td><c:out value="${temp.latitude}" /></td>
							<td><c:out value="${temp.longitude}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<button type="submit" class="btn btn-danger">Cancel Booking</button>
	</form:form>
</div>

<jsp:include page="footer.jsp" />

<jsp:include page="header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
			<form:form commandName="user" method="POST" action="accountsettings"
				id="contact-form" class="form-horizontal">
				<fieldset>
					<legend> Your infromation Form </legend>
					
					<div class="control-group">
						<form:label path="name" class="control-label" for="name">Your Name</</form:label>
						<div class="controls">
							<form:input path="name" class="input-xlarge" name="name"
								id="name"></form:input>
						</div>
					</div>
					
					<div class="control-group">
						<form:label path="email" for="email">Email Address</form:label>
						<div class="controls">
							<form:input path="email" class="input-xlarge" name="email"	id="email"></form:input>
						</div>
					</div>
					
					<div class="control-group">
						<form:label path="phoneNumber" class="control-label" for="subject">Phone Number</form:label>
						<div class="controls">
							<form:input path="phoneNumber" class="input-xlarge"
								name="subject" id="subject"></form:input>
						</div>
					</div>

					<div class="form-actions">
						<button type="submit" class="btn">Submit</button>
						<button type="reset" class="btn">Cancel</button>
					</div>
					
				</fieldset>
			</form:form>
		</tbody>
	</table>
</div>
<jsp:include page="footer.jsp" />
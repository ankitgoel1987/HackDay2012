<jsp:include page="header.jsp" />



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
			<form action="" id="contact-form" class="form-horizontal">
				<fieldset>
					<legend> Your infromation Form </legend>
					<div class="control-group">
						<label class="control-label" for="name">Your Name</label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="name" id="name">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="email">Email Address</label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="email" id="email">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="subject">Phone Number</label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="subject"
								id="subject">
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
<jsp:include page="footer.jsp" />
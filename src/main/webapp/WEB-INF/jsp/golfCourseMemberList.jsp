<jsp:include page="header.jsp" />

<!-- Model for enter booking details form -->

<div class="modal hide fade" id="sendOfferModal">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">x</button>
		<h3>Start new offer</h3>
	</div>
	<div class="modal-body">
		<form class="form-horizontal">
			<fieldset>
				<div>
					<div class="control-group">
						<label class="control-label" for="input01">Selected slot</label>
						<div class="controls">
							<input type="text" class="input-xlarge disabled"
								id="selected_slot" disabled>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="input01">from</label>
						<div class="controls">
							<!-- Date picker -->

							<div class="input-append date" id="datepicker-from"
								data-date="12-02-2012" data-date-format="dd-mm-yyyy">
								<input id="date-selector-from" size="16" type="text"
									value="12-02-2012" readonly> <span class="add-on"><i
									class="icon-th"></i></span>
							</div>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="input01">to</label>
						<div class="controls">

							<!-- Date picker -->

							<div class="input-append date" id="datepicker-to"
								data-date="12-02-2012" data-date-format="dd-mm-yyyy">
								<input id="date-selector-to" size="16" type="text"
									value="12-02-2012" readonly> <span class="add-on"><i
									class="icon-th"></i></span>
							</div>

						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="input01">Offer
							description</label>
						<div class="controls">
							<textarea class="input-xlarge" rows="3" cols="3"
								id="offer-description"></textarea>
						</div>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn" data-dismiss="modal">Close</a> <input
			type="submit" class="btn btn-primary" value="Send offer" />
	</div>
</div>
<!-- Table for golf course details -->
<div class="container">
	<!-- Date picker -->

	<div class="input-append date" id="datepicker" data-date="12-02-2012"
		data-date-format="dd-mm-yyyy">
		<input id="date-selector" size="16" type="text" value="12-02-2012"
			readonly> <span class="add-on"><i class="icon-th"></i></span>
	</div>


	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Timings</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr id="r1" value="6:00AM-7:00AM" style="height: 50px;">
				<td style="width: 200px;">6:00AM-7:00AM <a id="r1Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>

			<tr id="r2" value="7:00AM-8:00AM" style="height: 50px;">
				<td>7:00AM-8:00AM <a id="r2Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>

			<tr id="r3" value="8:00AM-9:00AM" style="height: 50px;">
				<td>8:00AM-9:00AM<a id="r3Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>
			<tr id="r4" value="9:00AM-10:00AM" style="height: 50px;">
				<td>9:00AM-10:00AM <a id="r4Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>

			<tr id="r5" value="10:00AM-11:00AM" style="height: 50px;">
				<td>10:00AM-11:00AM <a id="r5Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>

			<tr id="r6" value="11:00AM-12:00PM" style="height: 50px;">
				<td>11:00AM-12:00PM <a id="r6Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>

			<tr id="r7" value="12:00PM-1:00PM" style="height: 50px;">
				<td>12:00PM-1:00PM<a id="r7Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>

			<tr id="r8" value="1:00PM-2:00PM" style="height: 50px;">
				<td>1:00PM-2:00PM<a id="r8Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>

			<tr id="r9" value="2:00PM-3:00PM" style="height: 50px;">
				<td>2:00PM-3:00PM<a id="r9Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>

			<tr id="r10" value="3:00PM-4:00PM">
				<td>3:00PM-4:00PM<a id="r10Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>
			
			<tr id="r11" value="4:00PM-5:00PM">
				<td>4:00PM-5:00PM<a id="r11Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>
			
			<tr id="r12" value="5:00PM-6:00PM">
				<td>5:00PM-6:00PM<a id="r12Btn"
					class="btn btn-primary btn-mini" data-toggle="modal"
					href="#sendOfferModal" style="float: right; display: none;">offer</a></td>

				<td>Availability detail</td>
			</tr>
			
		</tbody>
	</table>
</div>

<jsp:include page="footer.jsp" />
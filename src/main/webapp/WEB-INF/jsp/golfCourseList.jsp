<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />

<!-- Middle part for booking table -->
<div class="container">
	<div>
		<form class="form-horizontal">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="input01">Search Golf Course</label>
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
			<tbody>
				<tr>
					<td><input type="checkbox" name="optionsCheckboxList2"
						value="option2"></td>
					<td>Noida Golf Course</td>
					<td>Ankit Goel</td>
					<td>sethsahab@yahoo.co.in</td>
					<td>007</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="optionsCheckboxList2"
						value="option2"></td>
					<td>Noida Golf Course</td>
					<td>Ankit Goel</td>
					<td>sethsahab@yahoo.co.in</td>
					<td>007</td>
				</tr>

				<tr>
					<td><input type="checkbox" name="optionsCheckboxList2"
						value="option2"></td>
					<td>Noida Golf Course</td>
					<td>Ankit Goel</td>
					<td>sethsahab@yahoo.co.in</td>
					<td>007</td>
				</tr>

				<tr>
					<td><input type="checkbox" name="optionsCheckboxList2"
						value="option2"></td>
					<td>Noida Golf Course</td>
					<td>Ankit Goel</td>
					<td>sethsahab@yahoo.co.in</td>
					<td>007</td>
				</tr>

				<tr>
					<td><input type="checkbox" name="optionsCheckboxList2"
						value="option2"></td>
					<td>Noida Golf Course</td>
					<td>Ankit Goel</td>
					<td>sethsahab@yahoo.co.in</td>
					<td>007</td>
				</tr>

				<tr>
					<td><input type="checkbox" name="optionsCheckboxList2"
						value="option2"></td>
					<td>Noida Golf Course</td>
					<td>Ankit Goel</td>
					<td>sethsahab@yahoo.co.in</td>
					<td>007</td>
				</tr>

			</tbody>
		</table>
	</div>
	<button type="submit" class="btn btn-danger">Delete Golf course</button>
</div>

<jsp:include page="footer.jsp" />
</html>
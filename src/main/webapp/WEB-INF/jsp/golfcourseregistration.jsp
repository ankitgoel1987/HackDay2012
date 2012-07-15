<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp" />

	<!-- Model for enter golfcourse booking details form -->
	<div class="container" style="margin-left: 10%;">
	
		<table class="table table-striped table-bordered">
			<thead>
			</thead>
			<tbody>
				<form:form commandName="golfCourse" method="POST" action="gcRegistration" id="contact-form" class="form-horizontal">
					<fieldset>
						<legend> Your infromation Form </legend>
						<div class="control-group">
							<label class="control-label" for="name">Golf Club Name</label>
							<div class="controls">
								<form:input path="name" class="input-xlarge" name="name" id="name"></form:input>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="name">Branding Image</label>
							<div class="controls">
								<form:input path="bannerImageURL" class="input-xlarge" name="bannerImageURL" id="bannerImageURL"></form:input>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="name">Url Extension</label>
							<div class="controls">
								<form:input path="urlExtension" class="input-xlarge" name="urlExtension" id="urlExtension"></form:input>
							</div>
						</div>
						
						
						<div class="control-group">
							<label class="control-label" for="name">Home Page Short Text</label>
							<div class="controls">
								<form:input path="homePageShortText" class="input-xlarge" name="homePageShortText" id="homePageShortText"></form:input>
							</div>
						</div>
						
						
						<div class="control-group">
							<label class="control-label" for="name">Home Page Long Text</label>
							<div class="controls">
								<form:input path="homePageLongText"  class="input-xlarge" name="homePageLongText" id="homePageLongText"></form:input>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="name">Image URL1</label>
							<div class="controls">
								<form:input path="imageURL1" class="input-xlarge" name="imageURL1" id="imageURL1"></form:input>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="name">Image URL2</label>
							<div class="controls">
								<form:input path="imageURL2" class="input-xlarge" name="imageURL2" id="imageURL2"></form:input>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="name">Image URL3</label>
							<div class="controls">
								<form:input path="imageURL3" class="input-xlarge" name="imageURL3" id="imageURL3"></form:input>
							</div>
						</div>			

						<div class="control-group">
							<label class="control-label" for="name">Latitude</label>
							<div class="controls">
								<form:input path="latitude" type="text" class="input-xlarge" name="latitude" id="latitude"></form:input>
							</div>
						</div>
			
						<div class="control-group">
							<label class="control-label" for="name">Longitude</label>
							<div class="controls">
								<form:input path="longitude" type="text" class="input-xlarge" name="longitude" id="longitude"></form:input>
							</div>
						</div>

						<div class="form-actions">
							<form:button type="submit" class="btn">Submit</form:button>
							<form:button type="reset" class="btn">Cancel</form:button>
						</div>
						
					</fieldset>
				</form:form>
			</tbody>
		</table>
	</div>
<jsp:include page="footer.jsp"/>
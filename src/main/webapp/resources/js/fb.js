function logResponse(response) {
	if (console && console.log) {
		console.log('The response was', response);
	}
}

function load_FB_sdk(app_id) {
	window.fbAsyncInit = function() {
		FB.init({
			appId : app_id, // App ID
			channelUrl : './channel.html', // Channel File
			status : true, // check login status
			cookie : true, // enable cookies to allow the server to access the
			// session
			xfbml : true
		});

		// Additional initialization code here
		initialize_fb(app_id);
	};
}
// Load the SDK Asynchronously
(function(d) {
	var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement('script');
	js.id = id;
	js.async = true;
	js.src = "//connect.facebook.net/en_US/all.js";
	ref.parentNode.insertBefore(js, ref);
}(document));

function initialize_fb(app_id) {
	$(function() {
		// Set up so we handle click on the buttons

		$('#getLoginStatus')
				.click(
						function() {
							FB
									.getLoginStatus(function(response) {
										if (response.status === 'connected') {
											console.log(response);
										} else {
											console.log("Not Connected");
											FB
													.ui(
															{
																method : 'oauth',
																client_id : app_id,
																redirect_uri : 'http://localhost:8080/BootstrapSampleProject/FacebookFlow.jsp',
																scope : 'publish_stream',
															},
															function(response) {

																if (response != null) {
																	logResponse(response);
//																	window.opener.location.href = 'http://localhost:8080/BootstrapSampleProject/FacebookFlow.jsp';
																	//Close the window and reload the home page
																}
															});
										}
									});
						});

		$('#postToWall').click(function() {
			FB.ui({
				method : 'feed',
				link : 'http://www.google.com/'
			}, function(response) {
				// If response is null the user canceled the dialog
				if (response != null) {
					logResponse(response);
				}
			});
		});

		$('#postPictureOnWall').click(function() {
			var imgURL = "http://www.sfwgc.org/MP900402495[1].jpg";
			logResponse('invoked');
			FB.api('/me/photos', 'post', {
				message : 'photo description',
				url : imgURL
			}, function(response) {

				if (!response || response.error) {
					logResponse('Error occured');
				} else {
					logResponse('Post ID: ' + response.id);
				}

			});
		});
	});
}

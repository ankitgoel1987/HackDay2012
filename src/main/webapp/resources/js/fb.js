function logResponse(response) {
	if (console && console.log) {
		console.log('The response was', response);
	}
}
var application_key = '361202527286458';

$('.shareFB').click(function() {
	console.log("Sharing on FB");
	checkLogin(application_key, 'shareFB');

});

function postOnWall() {
	var imageURl = 'http://t.co/ZgSyVxAM';
	FB
			.ui(
					{
						method : 'feed',
						link : imageURl,
						picture : imageURl,
						description : 'Boulder Hills is blessed by Mother Nature. Huge rocks and majestic boulders provide natural coulisses, back drops and hazards. The course meanders through spectacular scenery. Ten of the eighteen holes have elevated tees and the Par threes are designed in such a way that players see all of the hole in front of them. Large expanse of greens maximise pin positions and add visual appeal. Truly wow-class. Truly inspiring. ',
						caption : 'Golf club'
					}, function(response) {
						// If response is null the user canceled the dialog
						if (response != null) {
							logResponse(response);
						}
					});
}

$('.postFB').click(function() {
	console.log("Sharing on FB");
	checkLogin(application_key, 'postFB');
});

function checkLogin(app_key, action) {
	FB
			.getLoginStatus(function(response) {
				if (response.status === 'connected') {
					console.log(response);
					if (action == 'shareFB') {

						postPicOnFB();
					} else if (action == 'postFB') {
						postOnWall();
					}
				} else {
					console.log("Not Connected");
					FB
							.ui(
									{
										method : 'oauth',
										client_id : app_key,
										redirect_uri : 'http://progress_ankit.cloudfoundry.com/gallery',
										scope : 'publish_stream',
									}, function(response) {

										if (response != null) {
											logResponse(response);
										}
									});
				}
			});
}

function postPicOnFB() {
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
}

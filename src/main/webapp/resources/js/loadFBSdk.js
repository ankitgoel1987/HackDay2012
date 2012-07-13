function load_FB_sdk(app_id) {
	window.fbAsyncInit = function() {
		FB.init({
			appId : app_id, // App ID
			channelUrl : './channel.html', // Channel File
			status : true, // check login status
			cookie : true, // enable cookies to allow the server to access the session
			xfbml : true
		});

		// Additional initialization code here
//		initialize_fb(app_id);
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

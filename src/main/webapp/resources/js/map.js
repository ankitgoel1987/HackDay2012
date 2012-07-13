var map;
$(window)
		.load(
				function() {

					var script = document.createElement("script");
					script.type = "text/javascript";
					script.src = "//maps.googleapis.com/maps/api/js?key=AIzaSyC85RmmPy7fqS-tIanAPl1oiSb99uaV_eg&sensor=false&callback=initialize_map";
					document.body.appendChild(script);
				});

function initialize_map() {
	// Check for geo-location support
//	if (navigator.geolocation) {
		// Use method getCurrentPosition to get coordinates
//		navigator.geolocation.getCurrentPosition(function(position) {
			// Access them accordingly
//			console.log(position);
//			var currentLatLng = new google.maps.LatLng(
//					position.coords.latitude, position.coords.longitude);
	
			var currentLatLng = new google.maps.LatLng(17.46651,78.36321659999999);
			
			var myOptions = {
				center : currentLatLng,
				zoom : 8,
				mapTypeId : google.maps.MapTypeId.ROADMAP,
				streetViewControl : false,
				panControl : false,
				mapTypeControl : false,
//				zoomControlOptions : {
//					style : google.maps.ZoomControlStyle.SMALL
//				}
				zoomControl: false
			};
			map = new google.maps.Map(document.getElementById("map_canvas"),
					myOptions);
			map.setCenter(currentLatLng);
//			console.log(currentLatLng);
//			showMarker(currentLatLng);
//		});
//	}
}

function showMarker(currentLatLng) {
//	var markerArray = [];
//	for ( var i in locationArray) {
//		var locationObj = locationArray[i];
//		var location = new google.maps.LatLng(locationObj.latitude,
//				locationObj.longitude);

		var marker = new google.maps.Marker({
			position : currentLatLng,
			animation : google.maps.Animation.DROP,
			map : map,
			title : "Happy Golf Club"
		});
//		addListenerToMarker(marker, locationObj, friendsArray);
//		markerArray.push(marker);
//	}

		
//	var markerCluster = new MarkerClusterer(map, markerArray);
//	console.log(markerCluster);
//	console.log(marker);

}

function addListenerToMarker(marker, locationObj, friendsArray) {
	// Creating an InfoWindow object

	var infowindow = new google.maps.InfoWindow({
		content : ''
	});
	// Adding a click listener
	google.maps.event
			.addListener(
					marker,
					'click',
					function() {
						// Set content of info window here
						// console.log("Hello ");
						// console.log(marker.title);
						// console.log(marker);
						// console.log(event);
						console.log(locationObj);
						console.log(friendsArray);
						// console.log(friendsArray.length);
						var friendInLocation = new Array();
						var count = 0;
						var infoMessage = "<table class=\"table\"><thead><tr><th><img src=\"https://graph.facebook.com/"
								+ locationObj.page_id
								+ "/picture?type=small\"/></th><th colspan=\"2\">"
								+ locationObj.name
								+ "</th><th><a href=\"#\" class=\"facebook-button apprequests\" id=\"sendMessage\" rel=\"tooltip\" title=\"Send Message\"><span class=\"plus\" >Send message</span></a></th></tr></thead><tbody>";

						for ( var i = 0; i < friendsArray.length; i++) {
							var location = friendsArray[i].current_location;
							if (location != null) {
								// console.log(location);
								var location_id = location.id;
								// console.log(location_id);
								if (location_id == locationObj.page_id) {
									friendInLocation[count] = friendsArray[i];
									count++;
									console.log(friendsArray[i]);
									infoMessage = infoMessage
											+ "<tr><td><img src=\"https://graph.facebook.com/"
											+ friendsArray[i].uid
											+ "/picture?type=small\"/></td><td colspan=\"2\">"
											+ friendsArray[i].name
											+ "</td><td>@mdo</td></tr>";
								}
							}

						}
						console.log(friendInLocation);
						infoMessage = infoMessage + '</tbody></table>';

						infowindow.setContent(infoMessage);
						infowindow.open(map, marker);
					});
}

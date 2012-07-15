$(document).ready(function() {

	$('a[rel="tooltip"]').tooltip({
		placement : 'top'
	});

	$('#datepicker').datepicker({

		format : 'mm-dd-yyyy'

	});

	$('#datepicker-from').datepicker({

		format : 'mm-dd-yyyy'

	});

	$('#datepicker-to').datepicker({

		format : 'mm-dd-yyyy'

	});

});

$('#nextBtn').click(function() {
	$('#formOne').hide();
	$('#formTwo').show();
	$('#nextBtn').text("set up social connections");
});

$('#r1c3').hover(function() {
	$('#r1c4').show(100);
}, function() {
	$('#r1c4').hide(100);
});

$('#r2c3').hover(function() {
	$('#r2c4').show(100);
}, function() {
	$('#r2c4').hide(100);
});

$('#r3c3').hover(function() {
	$('#r3c4').show(100);
}, function() {
	$('#r3c4').hide(100);
});

$('#r4c3').hover(function() {
	$('#r4c4').show(100);
}, function() {
	$('#r4c4').hide(100);
});

var checkListArray = new Array();
$('#reservationdetailsList :checkbox').click(
		function(event) {

			var $this = $(this);
			console.log($this);
			var $thisNew = event.currentTarget;
			var selectedId = $thisNew.id;
			console.log(selectedId);

			if ($this.is(':checked')) {
				console.log(checkListArray.length == 0
						|| (checkListArray.indexOf(selectedId) == -1));
				if (checkListArray.length == 0
						|| checkListArray.indexOf(selectedId) == -1) {
					console.log($thisNew.id);
					checkListArray.push(selectedId);
				}

			}

			else {

				if (checkListArray.indexOf(selectedId) != -1) {
					console.log($thisNew.id);
					checkListArray.pop(selectedId);
				}
			}

		});

$('#sads').click(function() {
	console.log(checkListArray.toString());
	window.location('cancelMyBooking');
});

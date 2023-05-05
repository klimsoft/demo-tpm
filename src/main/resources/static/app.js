$(document).ready(function() {
	$('#helloForm').submit(function(event) {
		event.preventDefault();

		var name = $('#name').val();

		$.ajax({
			type: 'GET',
			url: '/hello',
			data: { name: name },
			success: function(response) {
				$('#response').html(response);
			},
			error: function(xhr) {
				console.log(xhr.responseText);
			}
		});
	});
});
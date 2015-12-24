$(document).ready(function() {
	$('#login').click(function() {
	var username = $('#username').val();
	var password = $('#password').val();
	//$('#password').val($.sha1(password));
	var error = true;

	$.ajax({
		type: "POST",
		url: "data.php",
		dataType: "json",
		success: function(data) {
			$('#loading').fadeOut('fast');
			$.each(data, function(key, value) {
			if(username == value.username && password == value.password) {
					error = false;		

}
			});
			if( error == false) {
				document.location="save_ss.php?user_login=" + username;
			} else {
				$('#container').slideUp('slow').slideDown('slow');
				$('#username').val('');
				$('#password').val('');
				alert('Invalid username or password');
			}
		}

		});
	return false;

	});
});
var fd = new FormData();
fd.append('file', input.files[0]);

$.ajax({
	url : 'http://example.com/script.php',
	data : fd,
	processData : false,
	contentType : false,
	type : 'POST',
	success : function(data) {
		alert(data);
	}
});

function submitForm() {
	var data1 = new FormData($('input[name^="file"]'));
	$.each($('input[name^="file"]')[0].files, function(i, file) {
		data1.append(i, file);
	});

	$.ajax({
		url : "<?php echo base_url() ?>employee/dashboard2/test2",
		type : "POST",
		data : data1,
		enctype : 'multipart/form-data',
		processData : false, // tell jQuery not to process the data
		contentType : false
	// tell jQuery not to set contentType
	}).done(function(data) {
		console.log("PHP Output:");
		console.log(data);
	});
	return false;
}

$('form').submit(function(e) {
	var data;

	data = new FormData();
	data.append('file', $('#file')[0].files[0]);

	$.ajax({
		url : 'http://hacheck.tel.fer.hr/xml.pl',
		data : data,
		processData : false,
		type : 'POST',

		// This will override the content type header, 
		// regardless of whether content is actually sent.
		// Defaults to 'application/x-www-form-urlencoded'
		contentType : 'multipart/form-data',

		//Before 1.5.1 you had to do this:
		beforeSend : function(x) {
			if (x && x.overrideMimeType) {
				x.overrideMimeType("multipart/form-data");
			}
		},
		// Now you should be able to do this:
		mimeType : 'multipart/form-data', //Property added in 1.5.1

		success : function(data) {
			alert(data);
		}
	});

	e.preventDefault();
});
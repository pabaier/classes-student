const a = () => {
	console.log('hihohum');
};

const postData = (url, token, data, success) => {
	sec = {csrfmiddlewaretoken: token}
	$.ajax({
		type: "POST",
		url: url,
		data : {...sec, ...data},
		success: success,
		dataType: 'json',
	});
}

const putData = (url, token, data, success) => {
	$.ajax({
		type: "PUT",
		url: url,
		data : data,
		beforeSend: function(xhr) {
				xhr.setRequestHeader("X-CSRFToken", token);
		},
		success: success,
		dataType: 'json',
	});	
}

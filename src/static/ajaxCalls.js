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
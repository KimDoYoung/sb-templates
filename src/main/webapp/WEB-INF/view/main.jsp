<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TEST</h1>
<a href="/exception1"><strong>not</strong> controlled exception (ex: parseInt error)</a><br>
<a href="/exception2">controlled exception (ex: parseInt error)</a><br>
<a href="#" id="ajax1">ajax-1</a>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	console.log('ready...');
	$('#ajax1').on('click', function(){
		$.get('/exception-ajax1', function(data){
			console.log(data);
		}).fail(function(jqXHR, textStatus, errorThrown){
			console.log(errorThrown);
		});
	});
});
</script>
</body>
</html>
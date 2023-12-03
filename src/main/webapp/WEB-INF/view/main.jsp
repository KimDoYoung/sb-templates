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
<form action="/user" method="post">
id:<input type="text" name="id"  /> <br>
name:<input type="text" name="name" /> <br>
age:<input type="number" name="age" /> <br>
birth:<input type="text" name="birth" value="${user.birth }" /> <br>
Address:
		<input type="text" name="zip" /> <br>
		<input type="text" name="address1" /> <br>
		<input type="text" name="address2" /> <br>
<button type="submit">submit</button>		
</form>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	console.log('ready...');
});
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TEST</h1>
<p> num : ${num }
<p> str: ${str}
<c:forEach var="email" items="${emails}" varStatus="status">
	<p>${email }
</c:forEach>
<br/>
${map.name } : ${map.email }
<br/>
id:${user.username }, pw: ${user.password }
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TEST</h1>
<form action="/user" method="get">
<p>id : <input type="text" name="id" placeholder="비어 있을시 처리되는 것 확인"/>
<p>name: <input type="text" name="name" />
<p>age: <input type="text" name="age" />

<button type="submit">submit</button>
</form>
<spring:hasBindErrors name="user">
    <div class="${cssName }">
	<ul>
		<c:forEach var="error" items="${errors.allErrors}">
       	<li><spring:message message="${error}" /></li>
       </c:forEach>
   </ul>
   </div>    
</spring:hasBindErrors>
</body>
</html>
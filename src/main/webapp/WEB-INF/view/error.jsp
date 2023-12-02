<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<title>error</title>
</head>
<body>
<main class="container my-5">
		<h1>Error :  ${status }</h1>
		<p> timestamp : <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${timestamp }" />
		<p> error : ${error}
		<p> assetEDU message :<c:if test="${msg != null}"><span class="text-danger">${msg }</span></c:if>  
		<p> path : ${path}
		<br>
		<br>
		<button class="btn btn-danger btnDetail" onclick="$('#detail-area').toggle();">자세히</button>
		<div style="display:block; background-color: #F5F3D5;" id="detail-area">	
		<c:forEach var="item" items="${trace}" varStatus="status">    
    		<p><c:out value="${item}" /></p>
		</c:forEach>
		</div>
</main>
</body>
</html>

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
<a href="/exception">throw new Exception</a> <br/>
<a href="/assetedu/exception">throw new AssetEduException</a> <br/>
<a href="/assetedu/exception-json">throw new AssetEduJsonException : json형태로 error를 리턴</a> <br/>
<a href="/assetedu/exception-duplication-json">Json형태로 Duplicaton 에러를 보낸다</a> <br/>
<a href="/assetedu/define-exception-in-method">콘트롤러의 method에 특정 exception을 기술</a> <br/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>연산 요청 결과</h1>
<hr>
<h3>결과 : ${requestScope.result}</h3>
<br>
<a href="${header.referer}">입력 화면으로 돌아가기</a>
</body>
</html>
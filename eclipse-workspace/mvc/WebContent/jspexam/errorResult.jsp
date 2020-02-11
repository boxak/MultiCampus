<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 화면</title>
</head>
<body>
<h2>요청을 처리하는 동안 오류가 발생했어요...</h2>
<h3>오류의 원인 : ${requestScope.errorMsg}</h3>
<a href="${header.referer}">입력 화면으로 돌아가기</a>
</body>
</html>
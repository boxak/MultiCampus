<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%= request.getParameter("sname") %>님은 B등급입니다. 양호한 성적이시네요(^^)</h1>
<br><br>
<a href="<%= request.getHeader("referer") %>">성적 입력 화면으로</a>
</body>
</html>
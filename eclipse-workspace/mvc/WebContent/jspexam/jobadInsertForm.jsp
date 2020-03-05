<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구인 게시판 새 글 작성</title>
</head>
<body>

<div>
<form method="post" action="/mvc/jobad">
	<input type="hidden" name="action" value="insert">
	<input type="hidden" name="pgNum" value="${pgNum}">
	<input type="hidden" name="post_id" value="1">
	유저 아이디 : <input type="text" name="mem_userid"><br>
	유저 이름 : <input type="text" name="mem_username"><br>
	글 제목 : <input type="text" name="post_title"><br>
	내용 : <input type="text" name="post_content"><br>
	위치 : <input type="text" name="post_location"><br>
	시급 : <input type="number" name="post_payment"><br>
	전화번호 : <input type="text" name="post_phone"><br>
	<input type="submit" value="새 글 작성">
</form>
</div>

</body>
</html>
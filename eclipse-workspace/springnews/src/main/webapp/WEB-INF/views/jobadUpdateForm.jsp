<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="vo.JobadVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정하기</title>
</head>
<body>
<% JobadVO vo = (JobadVO)session.getAttribute("vo"); %>
<div>
	<form action="/springnews/jobad" method="post">
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="post_id" value="<%= vo.getPost_id() %>">
		유저 아이디 : <input type="text" name="mem_userid" value="<%= vo.getMem_userid() %>">
		유저 이름 : <input type="text" name="mem_username" value="<%= vo.getMem_username() %>">
		글 제목 : <input type="text" name="post_title" value="<%= vo.getPost_title() %>">
		글 내용 : <input type="text" name="post_content" value="<%= vo.getPost_content() %>">
		장소 : <input type="text" name="post_location" value="<%= vo.getPost_location() %>">
		시급: <input type="number" name="post_payment" value="<%= vo.getPost_payment() %>">
		글 제목 : <input type="text" name="post_phone" value="<%= vo.getPost_phone() %>">
		<input type="submit" value="수정 완료">
		<button onclick="location.href='/mvc/jobad?action=listone&post_id=<%= vo.getPost_id() %>'">수정 취소</button>
	</form>
</div>
</body>
</html>
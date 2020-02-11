<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div{
	
		width : 400px;
		text-align : center;
		border : 1px black solid;
		border-radius : 5px;
		margin-left : auto;
		margin-right : auto;
		margin-top : 180px;
		background-image : radial-gradient(200px,white,pink);
		text-color : #327ba8;
	}
</style>
</head>
<body>
<%

MemberVO vo = (MemberVO)request.getAttribute("info");

%>
<div>
<h2>회원 정보</h2>
<hr>
<ul style="width : 300px;">
	<li> 회원 이름 : <%= vo.getName() %></li>
	<li> 회원 계정 : <%= vo.getEmail() %></li>
	<li> 회원 암호 : <%= vo.getPw() %></li>
	<li> 회원 전화번호 : <%= vo.getTelNumber() %></li>
</ul>
</div>
</body>
</html>
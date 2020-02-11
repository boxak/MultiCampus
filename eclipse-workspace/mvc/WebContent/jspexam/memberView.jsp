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
<h1>스크립트 태그</h1>
<div>
<%

MemberVO vo = (MemberVO)request.getAttribute("info");

%>

<h2>회원 정보</h2>
<hr>
<ul style="width : 300px;">
	<li> 회원 이름 : <%= vo.getName() %></li>
	<li> 회원 계정 : <%= vo.getEmail() %></li>
	<li> 회원 암호 : <%= vo.getPw() %></li>
	<li> 회원 전화번호 : <%= vo.getTelNumber() %></li>
</ul>
</div>
<h1>액션 태그</h1>
<%
//request 객체 안에 보관되어 있는 객체를 꺼내는 작업.

%>
<jsp:useBean id="info" class="model.vo.MemberVO" scope="request" />

<div>
<h2>회원 정보</h2>
<hr>
<ul style="width : 300px;">
	<li> 회원 이름 : <jsp:getProperty name="info" property="name"/></li>
	<li> 회원 계정 : <jsp:getProperty name="info" property="email"/></li>
	<li> 회원 암호 : <jsp:getProperty name="info" property="pw"/></li>
	<li> 회원 전화번호 : <jsp:getProperty name="info" property="telNumber"/></li>
</ul>
</div>

<h1>EL</h1>
<div>
<h2>회원 정보</h2>
<hr>
<ul style="width : 300px;">
	<li> 회원 이름 : ${requestScope.info.name}</li>
	<li> 회원 계정 : ${requestScope.info.email}</li>
	
	<li> 회원 암호 : ${requestScope.info.pw}</li>
	<li> 회원 전화번호 : ${requestScope.info.telNumber}</li>
</ul>
</div>

<%


//request 객체 안에 보관되어 있는 객체를 꺼내는 작업.

%>

</body>
</html>
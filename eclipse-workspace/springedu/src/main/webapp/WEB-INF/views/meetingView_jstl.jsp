<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,vo.MeetingVO" %> 
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>미팅 스케쥴(JSTL)</title>
<style>

	img{
		width : 50px;
		height : 50px;
	
	}
	
	td{
	
		border-bottom : 1px dotted black;
	
	}

</style>
</head>
<body>
<h1>미팅 스케쥴(JSTL)</h1>
<hr>
<table>
	<tr>
		<th>이름</th>
		<th>미팅 목적</th>
		<th>미팅 시간</th>
	</tr>
	
	<c:forEach var="vo" items="${requestScope.MeetingTable}" varStatus="status">
		<tr>
			<td><c:out value="${vo.name}"></c:out> // </td>
			<td><c:out value="${vo.title}"></c:out> // </td>
			<td><c:out value="${vo.meetingDate}"></c:out></td>
			<td><a href="/mvc/meeting?delete=<c:out value='${vo.id}'></c:out>"><img src="https://image.flaticon.com/icons/png/512/1966/1966368.png"></a>
			</td>
		</tr>
	</c:forEach>
	
	
</table>
<a href="http://localhost:8000/mvc/htmlexam/meetingForm.html">미팅 홈 화면으로 돌아가기</a>
</body>
</html>
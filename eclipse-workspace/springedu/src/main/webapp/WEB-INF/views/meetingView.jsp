<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ page import="vo.MeetingVO,java.util.ArrayList,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<h1>미팅 스케쥴</h1>
<hr>
<table>
	<tr>
		<th>이름</th>
		<th>미팅 목적</th>
		<th>미팅 시간</th>
	</tr>
<%

	List<MeetingVO> list = new ArrayList<>();
	list = (ArrayList<MeetingVO>)request.getAttribute("meetingTable");
	for(MeetingVO vo : list){

%>
	
	<tr>
		<td><%= vo.getName() %> // </td>
		<td><%= vo.getTitle() %> // </td>
		<td><%= vo.getMeetingDate() %></td>
		<td><button onclick="location.href='/springedu/delete?id=<%= vo.getId() %>'"><img src="https://image.flaticon.com/icons/png/512/1966/1966368.png"></button>
		</td>
	</tr>
	<% } %>
	
</table>
<a href="http://localhost:8000/springedu/resources/meetingForm.html">미팅 홈 화면으로 돌아가기</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body style="text-align : center">
<%
	request.setCharacterEncoding("UTF-8");
%>
<%! String userName;
	String roomName;
	String [] addRequest;
	String reserDate;
	String reserTime;
%>
<%

	userName = request.getParameter("user_name");
	roomName = request.getParameter("room");
	addRequest = request.getParameterValues("additional");
	reserDate = request.getParameter("gdate");
	reserTime = request.getParameter("gtime");

%>
<h1><%= userName%>님의 예약내용</h1>
<hr>
<ul>

	<li>강의실 이름 : <%= roomName%></li>
	
	<li>
	
	<%
	
	if(addRequest==null){
		out.print("없음");
	}
	else{
		out.print(addRequest[0]);
		for(int i=1;i<addRequest.length;i++){
			out.print(", "+addRequest[i]);
		}
	}
	
	%>
	
	</li>
	<li>예약 날짜 : <%= reserDate+" "+reserTime%></li>
</ul>
<a href='<%= request.getHeader("referer") %>'>입력 화면으로</a>
</body>
</html>
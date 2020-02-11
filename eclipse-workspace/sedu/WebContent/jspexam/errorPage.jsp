<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center">
<h2>오류 발생했어욤ㅠㅠ</h2>
<h3>빠른시일내에 복구하겠습니다...</h3>
<img src="error.jpg">
<%	
    String msg = "오류 원인 : " + exception;	 //jsp 내장객체, 아무 jsp에서나 쓰지 못한다.
	System.out.println("----------------------------------------");
	System.out.println(msg);
	System.out.println("----------------------------------------");	
	exception.printStackTrace();
%>
</body>
</html>







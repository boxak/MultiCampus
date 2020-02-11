<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	div{
		border : 2px black solid;
		width : 600px;
		height : 100px;
		margin-left : auto;
		margin-right : auto;
		font-size : 60px;
		font-family : 궁서;
		padding-top : 15px;
	}	

</style>
</head>
<body style="text-align: center;">
<%! java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH시 mm분"); %>
<h1><%= sdf.format(new java.util.Date())%>에 당첨 실패... 아쉽네용 ㅜㅜ</h1>
<div>다음 번엔 꼭!</div>
<a href='<%= request.getHeader("referer") %>'>
<input type="image" src="http://www.nowpug.com/files/attach/images/237/034/142/6af6684c0a2a223c96203b81064e0aa8.jpg">
</a>
<h4>이미지를 클릭하시면 다시 로또에 응모할 수 있어요!</h4>
</body>
</html>
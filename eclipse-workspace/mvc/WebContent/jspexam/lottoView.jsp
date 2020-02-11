<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.LottoVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	LottoVO vo = (LottoVO)request.getAttribute("lotto");
	//session, request 객체에 담았으면 꺼낼 때 Object로 돌려주므로 형변환 해줘야 한다.
	//제대로 Servlet에서 값을 전달하지 못하거나 JSP에서 값을 전달받지 못하면 vo가 null이 된다.
%>
<h1><%= vo.getMsg() %></h1>
<%
	if(vo.getImgURL()!=null){
%>
	<img src="<%= vo.getImgURL() %>" width="100"><br><br>
<%
	}
%>
<%
	if(vo.isLinkDisplay()==true){
%>
	<a href="<%= request.getHeader("referer") %>">로또 응모창으로 돌아가기</a>
<%
	}
%>

</body>
</html>
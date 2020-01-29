<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	ProductVO vo = (ProductVO)session.getAttribute("product");
	if(vo==null){
		System.out.println("vo is null");
	}
%>
<h1>선택된 상품 정보는 다음과 같습니다.</h1>
<hr>
<h3>선택된 빅맥의 개수 : <%= vo.getCnt1() %></h3>
<h3>선택된 더블2x버거의 개수 : <%= vo.getCnt2() %></h3>
<h3>선택된 버거킹 와퍼의 개수 : <%= vo.getCnt3() %></h3>
</body>
</html>
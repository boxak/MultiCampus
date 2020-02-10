<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="vo.ProductVO"%>
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

<%//product 라는 id가 없으면 직접 product 이름을 가지는 세션 객체를 생성시킨다. %>
<h1>액션 태그</h1>
<jsp:useBean id="product" class="vo.ProductVO" scope="session"/>
<h1>선택된 상품 정보는 다음과 같습니다.</h1>
<hr>
<h3>선택된 빅맥의 개수 : <jsp:getProperty name="product" property="cnt1"/></h3>
<h3>선택된 더블2x버거의 개수 : <jsp:getProperty name="product" property="cnt2"/></h3>
<h3>선택된 버거킹 와퍼의 개수 : <jsp:getProperty name="product" property="cnt3"/></h3>
<a href="<%= request.getHeader("referer") %>">상품 선택 화면으로...</a>

<h1>스크립트 태그</h1>
<h1>선택된 상품 정보는 다음과 같습니다.</h1>
<hr>
<h3>선택된 빅맥의 개수 : <%= vo.getCnt1() %></h3>
<h3>선택된 더블2x버거의 개수 : <%= vo.getCnt2() %></h3>
<h3>선택된 버거킹 와퍼의 개수 : <%= vo.getCnt3() %></h3>


<h1>표현 언어(EL)</h1>
<h1>선택된 상품 정보는 다음과 같습니다.</h1>
<hr>
<h3>선택된 빅맥의 개수 : ${sessionScope.product.cnt1}</h3>
<h3>선택된 더블2x버거의 개수 : ${sessionScope.product.cnt2}</h3>
<h3>선택된 버거킹 와퍼의 개수 : ${sessionScope.product.cnt3}</h3>

<a href="${header.referer}">상품 선택 화면</a>
</body>
</html>
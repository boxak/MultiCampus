<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>위도, 경도 추출 사이트</title>
</head>
<body>
<c:choose>
	<c:when test="${ pageContext.request.method == 'GET' }">
		<h2>위도 경도가 알고 싶은 주소를 입력하세요.</h2>
		<hr>
		<form method="post" action="/sedu/jspexam/latlng.jsp">
			주소 : <input type="text" name="address" required>
			키 값 : <input type="text" name="key" required>
			<input type="submit" value="알아보기">
		</form>	
	</c:when>
	<c:otherwise>
	<c:import var="map" 
		url="https://maps.googleapis.com/maps/api/geocode/xml">
		<c:param name="address" value="${param.address}"/>
		<c:param name="language" value="ko"/>
		<c:param name="key" value="${param.key}"/>
	</c:import>
	<h1><c:out value="${param.address}"></c:out>의 위도와 경도 정보</h1>
	<%--<c:out value="${map}"></c:out>--%>
	<hr>

	<c:catch var="ex">
	<x:parse xml="${map}" varDom="xdata"/>
	<x:choose>
	<x:when select="$xdata//status='OK'">
		<ul>
			<li>주소 : <x:out select="$xdata/GeocodeResponse/result/formatted_address"/></li>
	    	<li>위도 : <x:out select="$xdata/GeocodeResponse/result/geometry/location/lat"/></li>
	   		<li>경도 : <x:out select="$xdata/GeocodeResponse/result/geometry/location/lng"/></li>
	   	</ul>
	</x:when>
	<x:when select="$xdata//status='ZERO_RESULTS'">
		<h3><c:out value="${ param.address }"/>는 지구상에 존재하지 않아요...</h3>
	</x:when>
	<x:otherwise>
		<h2>서비스 사용허가를 받지 못했습니다.</h2>
		서버로부터 전달된 에러 메시지 : 
		<x:out select="$xdata/GeocodeResponse/error_message"/>
	</x:otherwise>
	</x:choose>
	</c:catch>
	<c:if test="${ !empty ex }">
		<h2>잘못된 요청입니다...</h2>	     
	</c:if>
	</c:otherwise>
</c:choose>
</body>
</html>
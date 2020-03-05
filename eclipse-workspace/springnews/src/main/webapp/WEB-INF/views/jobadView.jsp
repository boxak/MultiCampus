<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.JobadVO,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구직 게시판</title>
</head>
<body>
<header>
<h1>${msg}</h1>
</header>
<hr>
<%

List<JobadVO> list = (List<JobadVO>)request.getAttribute("list");
JobadVO vo = (JobadVO)request.getAttribute("vo");
//System.out.println("list size : "+list.size());
if(list!=null && list.size()!=0){
%>
	<table>
	<tr>
		<th>글 번호</th>
		<th>작성자 아이디</th>
		<th>작성자 이름</th>
		<th>글 제목</th>
		<th>글 내용</th>
		<th>작성 시간</th>
		<th>조회수</th>
		<th>작성 장소</th>
		<th>시급</th>
		<th>전화번호</th>
		<th>리뷰 수</th>
	</tr>
<%
	for(JobadVO vo1 : list){
%>
	<tr>
		<th><%= vo1.getPost_id() %></th>
		<th><%= vo1.getMem_userid() %></th>
		<th><a href="/springnews/jobad?action=listWriter&mem_username=<%= vo1.getMem_username() %>"><%= vo1.getMem_username() %></a></th>
		<th>
		<a href="/springnews/jobad?action=listone&post_id=<%= vo1.getPost_id() %>"><%= vo1.getPost_title() %></a>
		</th>
		<th><%= vo1.getPost_content() %></th>
		<th><%= vo1.getPost_writedate() %></th>
		<th><%= vo1.getPost_hit() %></th>
		<th><%= vo1.getPost_location() %></th>
		<th><%= vo1.getPost_payment() %></th>
		<th><%= vo1.getPost_phone() %></th>
		<th><%= vo1.getPost_review_count() %></th>
	</tr>
	
<%
	}
%>
	</table>
<%
	out.print(request.getAttribute("pagelist"));
	//System.out.println(request.getAttribute("pagelist"));
%>
<button onclick="location.href='/springnews/resources/jobadInsertForm.jsp'">새 글 작성</button>
<button onclick="location.href='/springnews/jobad'">첫 화면으로 가기</button>
<form action="/springnews/jobad" method="get">
	<input type="hidden" name="action" value="search">
	<select name="searchType">
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="title_content">제목+내용</option>
	</select>
	<input type="text" name="key">
	<input type="submit" value="검색">
</form>
<%
}
if(request.getAttribute("snull")!=null){
%>
	<h1><%= (String)request.getAttribute("snull") %></h1>
<%
}
%>
<%
if(vo!=null){
%>
<div>
	<ul>
	<li>유저 아이디 : <%= vo.getMem_userid() %></li>
	<li>유저 이름 : <%= vo.getMem_username() %></li>
	<li>글 제목 : <%= vo.getPost_title() %></li>
	<li>글 내용 : <%= vo.getPost_content() %></li>
	<li>작성 날짜 : <%= vo.getPost_writedate() %></li>
	<li>조회수 : <%= vo.getPost_hit()+1 %></li>
	<li>장소 : <%= vo.getPost_location() %></li>
	<li>시급 : <%= vo.getPost_payment() %></li>
	<li>전화번호 : <%= vo.getPost_phone() %></li>
	<li>리뷰 수 : <%= vo.getPost_review_count() %></li>
	</ul>
	<a href="${header.referer}">목록 가기</a>
	<button onclick="location.href='/springnews/jobad?action=delete&post_id=<%= vo.getPost_id() %>'">글 삭제하기</button>
	<button onclick="location.href='/springnews/resources/jobadUpdateForm.jsp'">글 수정하기</button>
</div>
<%
}
%>
</body>
</html>
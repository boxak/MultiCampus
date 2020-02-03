<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.NewsVO,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스 게시판</title>
</head>
<body>
<h1>뉴스 게시판</h1>
<hr>
<%
	List<NewsVO> list = (List<NewsVO>)request.getAttribute("viewlist");
	if(list !=null){
%>
<table>

	<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
	</tr>
	
<%
		for(NewsVO vo : list){
%>
			<tr>
			<td class='<%= vo.getId() %>'><%= vo.getId() %></td>
			<td class='<%= vo.getId() %>'>
			<a href ='/mvc/news?action=read&id=<%= vo.getId() %>'
			onclick="showmethearticle(<%= vo.getId() %>)">
			<%= vo.getTitle() %>
			</a>
			</td>
			<td class='<%= vo.getId() %>'><%= vo.getWriter() %></td>
			<td class='<%= vo.getId() %>'><%= vo.getWritedate() %></td>
			<td class='<%= vo.getId() %>'><%= vo.getCnt() %></td>
			</tr>
<%
		}
	}
%>
</table>

<button onclick="displayDiv(1);">뉴스 작성</button>
<script>
	function displayDiv(type){
		if(type == 1){
			document.getElementById("insert").style.display='block';
		}
	}
	function showmethearticle(id){
		document.getElementById("read").style.display='block';
	}
</script>
<div id="insert"  style="display:none">
<hr><h2>뉴스 입력</h2>
<form method = "post" action = "/mvc/news">
<input type="hidden" name="action" value="insert">
작성자 : <input id="m_writer" type="text"  name="writer">
<br>
제목 :
<textarea id="m_title"  rows="3" cols="30" name = "title" ></textarea>
<br>
내용 : <textarea id="m_content" rows="10" cols="30" name="content"></textarea>
<br>
<input type = "submit" value = "저장">
<input type = "reset" value = "재작성">
<button id="cancel">취소</button>
</form>
</div>

<div id="read" style="display:none">
<%
	
	NewsVO vo = (NewsVO)request.getAttribute("view");

%>
<hr>
<h2>뉴스 내용</h2>
<form method = "post" action = "/mvc/news">
<input type="hidden" name="action" value="update">
작성자 : <input id="m_writer" type="text"  name="writer" value="<%= vo.getWriter() %>>">
<br>
제목 :
<textarea id="m_title"  rows="3" cols="30" name = "title"><%= vo.getTitle() %></textarea>
<br>
내용 : <textarea id="m_content" rows="10" cols="30" name="content"><%= vo.getContent() %></textarea>
<br>
<button id="check">확인</button>
<input type="submit" id="update" value="수정">
<button onclick="location.href='/mvc/news?action=delete&id=<%= vo.getId() %>'">삭제</button>
</form>
</div>
</body>
</html>
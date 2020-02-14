<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.NewsVO,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스 게시판</title>
<style>

	table{
		margin : auto;
		text-align : center;
		border : 1px black solid;
		border-collapse : collapse;
	}
	th,td{
	
		border : 1px black solid;
		padding-left : 10px;
		padding-right : 10px;
	
	}
	th{
	
		background-color : #666699;
	
	}
	td#newstitle:hover{
	
		font-weight : bold;
	
	}
	div#total{
	
		border : 1px black solid;
		width : 500px;
		margin : auto;
		background-color : silver;
	}
	span{
	
		vertical-align : top;
	
	}

</style>
</head>
<body style="text-align : center;">
<div id="total">
<h1 style="font-family : Times new Roman;"><a href='/springnews/newsmain'>Jiwon's News Table</a></h1>
<hr>
<%
	List<NewsVO> list = (List<NewsVO>)request.getAttribute("viewlist");
	NewsVO vo1 = (NewsVO)request.getAttribute("view");
	if(list !=null){
%>
<table style="background-color : white">

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
			<td class='<%= vo.getId() %>' id="newstitle">
			<a href ='/springnews/listOne?id=<%= vo.getId() %>'>
			<%= vo.getTitle() %>
			</a>
			</td>
			<td class='<%= vo.getId() %>'>
			<a href ='/springnews/listWriter?writer=<%= vo.getWriter() %>'>
			<%= vo.getWriter() %>
			</a>
			</td>
			<td class='<%= vo.getId() %>'><%= vo.getWritedate() %></td>
			<td class='<%= vo.getId() %>'><%= vo.getCnt() %></td>
			</tr>
<%
		}
		
%>
</table>
<hr>
<% 
		if(vo1!=null){
			
%>
			<div id="read">
			<hr>
			<h2>뉴스 내용</h2>
			<form action="/springnews/update" method="post">
			<!--<input type="hidden" name="action" value="update">-->
			<input type="hidden" name="id" value="<%= vo1.getId() %>">
			<input type="hidden" name="cnt" value="<%= vo1.getCnt() %>">
			<span>
			작성자 : <textarea rows="1" cols="30" id="m_writer" name="writer"><%= vo1.getWriter() %></textarea>
			</span>
			<br>
			제목 :
			<textarea rows="2" cols="30" id="m_title" name = "title"><%= vo1.getTitle() %></textarea>
			<br>
			내용 :
			<textarea rows="10" cols="30" id="m_content"  name="content"><%= vo1.getContent() %></textarea>
			<br>
			<button id="check" onclick="closeread();return false;">확인</button>
			<input type="submit" id="update" value="수정">
			<button onclick="location.href='/springnews/delete?id=<%= vo1.getId() %>';return false;">삭제</button>
			</form>
			</div>
<%
		}

	}
%>

<form action="/springnews/search" method="get">

<select name="searchType">
	<option value="title">제목</option>
	<option value="content">내용</option>
	<option value="title||content">제목+내용</option>
</select>
<input type="text" name="key">
<input type="submit" value="뉴스 검색">

</form>


<button onclick="displayDiv(1);return false;">뉴스 작성</button>
<div id="insert"  style="display:none">
<hr><h2>뉴스 입력</h2>
<form method = "post" action = "/springnews/insert">
<input type="hidden" name="action" value="insert">
작성자 : <input id="i_writer" type="text"  name="writer">
<br>
제목 :
<textarea id="i_title"  rows="3" cols="30" name = "title" ></textarea>
<br>
<br>
내용 : <textarea id="i_content" rows="10" cols="30" name="content"></textarea>
<br>
<input type = "submit" value = "저장">
<input type = "reset" value = "재작성">
<button id="cancel" onclick="displayDiv(2);return false;">취소</button>
</form>
</div>
</div>
<script>
	function displayDiv(type){
		var dom = document.getElementById("insert");
		if(type == 1){
			dom.style.display='block';
		}
		else if(type == 2){
			dom.style.display='none';
		}
		
	}
	
	function closeread(){
		document.getElementById("read").style.display='none';
	}
	
	
</script>
</body>
</html>
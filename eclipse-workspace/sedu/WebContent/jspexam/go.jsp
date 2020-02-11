<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! String study; 
	String gname;
%>
<% study = request.getParameter("study");
	gname = request.getParameter("gname");
	System.out.println(study);
	System.out.println(gname);
	if(study==null){
		response.sendRedirect("http://localhost:8000/sedu/html/first.html");
	}
	
	else{
		if(study.equals("javascript")){
			response.sendRedirect("http://www.w3schools.com/js/default.asp");
		}
		else if(study.equals("dom")){
			response.sendRedirect("http://www.w3schools.com/js/js_htmldom.asp");
		}
		else if(study.equals("ajax")){
			response.sendRedirect("http://www.w3schools.com/xml/ajax_intro.asp");
		}
		else if(study.equals("html")){ 
			response.sendRedirect("http://localhost:8000/sedu/html/first.html");
		}
		else if(study.equals("jsp")){%>
		
		<jsp:forward page="/html/first.jsp"> 
	  		<jsp:param name="gname" value="unico" />
	  	</jsp:forward>
	<% }
		else{
			response.sendRedirect("http://www.w3schools.com/js/js_json_intro.asp");
		}
	}%>

</body>
</html>
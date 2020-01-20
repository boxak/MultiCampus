package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitorServlet
 */
@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String visitorName=request.getParameter("gname");
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		String todayForm = today.format(formatter);
		String visitorText = request.getParameter("gtext");
		
		String display=
				"<h2>"+visitorName+"님이 "+todayForm+"에 남긴 글입니다.</h2>"
				+"<hr>"+visitorText+"<br>";
		String backURL="<a href='/sedu/html/visitorForm.html'>입력화면으로</a>";
		out.print(display);
		out.print(backURL);
	}

}

package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("pid");
		int idNumber = id.charAt(3)-'0';
		String url = "'http://localhost:8000/edu/images/"+idNumber+".png'";
		out.print("<h1>무기의 세계에 오신 것을 환영합니다~</h2>");
		out.print("<img src="+url+"><br>");
		out.print("<a href='http://localhost:8000/edu/htmlexam/productlog.html'>입력 화면으로 돌아가기.</a>");
	}

}

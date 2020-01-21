package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RedirectServlet 수행 시작");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String site=null;
		site = request.getParameter("action");
		if(site==null) {
			out.print("<h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니당..</h2>");
		}
		else {
			if(site.equals("daum")) {
				response.sendRedirect("https://www."+site+".net");
			}
			else {
				response.sendRedirect("https://www."+site+".com");
			}
			
		}
		System.out.println("MoveServlet 수행 종료");
		
	}

}

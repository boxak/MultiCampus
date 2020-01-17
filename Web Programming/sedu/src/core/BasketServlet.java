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
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String productID=request.getParameter("pid");
		out.print("<h2>선택한 상품의 ID : "+productID+"</h2>");
		out.print("<img src='/edu/images/"+productID.charAt(3)+".png' style='width : 300px; height : 150px;'>");
		out.print("<br><a href='/edu/htmlexam/productlog.html'>");
		out.print("입력화면으로 돌아가기</a>");
	}

}

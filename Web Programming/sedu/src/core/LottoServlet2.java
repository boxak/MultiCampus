package core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int luckyNum = (int)(Math.random()*6)+1;
		int inputNum = Integer.parseInt(request.getParameter("lotto_num"));
		System.out.println("전달된 값 : "+inputNum+", 추출된 값 : "+luckyNum);
		StringBuffer url = new StringBuffer("/sedu/jspexam/");
		if(luckyNum==inputNum) {
			url.append("success1.jsp");
		}
		else {
			url.append("failed1.jsp");
		}
		System.out.println(url.toString());
		response.sendRedirect(url.toString());
	}

}

package core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int luckyNum = (int)(Math.random()*6)+1;
		response.setContentType("text/html; charset=UTF-8");
		//jsp가 setContentType 자동으로 해주므로 필요없다.
		RequestDispatcher rd = null;
		//RequestDispatcher rd = request.getRequestDispatcher("/html/first.html"); //컨텍스트패스 이후 부분을 줘야 한다.
		//rd.forward(request,response);
		int inputNum = Integer.parseInt(request.getParameter("lotto_num"));
		if(luckyNum == inputNum) {
			rd = request.getRequestDispatcher("/jspexam/success.jsp");
		}
		else {
			rd = request.getRequestDispatcher("/jspexam/failed.jsp");
		}
		rd.forward(request,response);
		//
		System.out.println("전달된 값 : "+inputNum+", 추출된 값 : "+luckyNum);
	}

}

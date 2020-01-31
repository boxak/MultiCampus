package core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int luckyNum = (int)(Math.random()*6)+1;
		
		response.setContentType("text/html; charset=UTF-8");
		//jsp가 setContentType 자동으로 해주므로 필요없다.
		RequestDispatcher rd = null;
		//RequestDispatcher rd = request.getRequestDispatcher("/html/first.html"); //컨텍스트패스 이후 부분을 줘야 한다.
		//rd.forward(request,response);
		int inputNum = Integer.parseInt(request.getParameter("lotto_num"));
		
		HttpSession session = request.getSession();
		if(session.getAttribute("chance")==null) {
			session.setAttribute("chance", new int[1]);
		}
		
		int [] chance=(int[])session.getAttribute("chance");
		//System.out.println(chance[0]);
		chance[0]++;
		
		//chance[0]>=4 이면 더이상 진행하지 못하게 막는다.
		if(chance[0]>=4) {
			rd = request.getRequestDispatcher("/jspexam/impossible.jsp");
		}
		
		else {
			if(luckyNum == inputNum) {
				rd = request.getRequestDispatcher("/jspexam/success.jsp");
				chance[0]=3;
			}
			else {
				rd = request.getRequestDispatcher("/jspexam/failed.jsp");
			}
		}
		rd.forward(request,response);
		
		System.out.println("전달된 값 : "+inputNum+", 추출된 값 : "+luckyNum+", 응모 횟수 : "+chance[0]);
	}

}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/eduservlet")
public class EduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//쿼리를 하나라도 꺼낸 다음엔, setCharacterEncoding은 아무 의미가 없다!
		RequestDispatcher rd = null;
		
		String name = request.getParameter("sname");
		int score = Integer.parseInt(request.getParameter("spoint"));
		
		
		
		System.out.println("이름 : "+name+", 평균점수 : "+score);
		if(score>=90) {
			rd = request.getRequestDispatcher("/jspexam/gradeA.jsp");
		}
		else if(score>=80) {
			rd = request.getRequestDispatcher("/jspexam/gradeB.jsp");
		}
		else if(score>=70) {
			rd = request.getRequestDispatcher("/jspexam/gradeC.jsp");
		}
		else {
			rd = request.getRequestDispatcher("/jspexam/gradeD.jsp");
		}
		rd.forward(request, response);
	}

}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcservlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String operator = request.getParameter("operator");
		String msg = "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!";
		RequestDispatcher rd = null;
		//request 객체는 null인지 아닌지 확인할 필요가 없다.
		if(operator.equals("/") && num2==0) {
			request.setAttribute("errorMsg",msg);
			rd = request.getRequestDispatcher("/jspexam/errorResult.jsp");
		}
		else {
			int result=0;
			
			switch(operator){
				case "+" : result = num1+num2;
					break;
				case "-" : result = num1-num2;
					break;
				case "*" : result = num1*num2;
					break;
				case "/" : result = num1/num2;
					break;
			}
			request.setAttribute("result", result);
			rd = request.getRequestDispatcher("/jspexam/calcResult.jsp");
		}
		rd.forward(request, response);
	}


}

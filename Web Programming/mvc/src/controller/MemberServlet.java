package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.MemberVO;

@WebServlet("/memberservlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("gname");
		String tel = request.getParameter("gnumber");
		String email = request.getParameter("gemail");
		String pw = request.getParameter("gpw");
		
		name = name=="" ? "없음" : name;
		tel = tel=="" ? "없음" : tel;
		email = email=="" ? "없음" : email;
		pw = pw=="" ? "없음" : pw;
		//.equals() 메서드를 써야한다!
		
		MemberVO vo = new MemberVO(name,tel,email,pw);
		//jsp 에서 사용하는 java 클래스는 디폴트 생성자가 꼭 있어야 한다!
		request.setAttribute("info", vo);
		
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("jspexam/memberView.jsp");
		rd.forward(request, response);
	}

}
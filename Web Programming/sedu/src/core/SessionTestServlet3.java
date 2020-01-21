package core;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sessiontest3")
public class SessionTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
	    String action = request.getParameter("action");
	    HttpSession session = null;
	    String msg = "값으로 create나 destroy를 전달하시오."; 
	    if(action.equals("create")) { 
	    	session = request.getSession();// getSession(true)와 동일
	    	if(session.isNew()) //처음 만들어진건지 체크함.
	    		msg = "세션 객체가 생성됨";
	    	else 
	    		msg = "세션 객체는 이미 생성되어 있었음";    	
	    } else if (action.equals("destroy")) {
	    	session = request.getSession(false);
	    	//객체가 있으면 걔를 리턴, 없으면 null을 리턴.
	    	if(session != null) {
	    		session.invalidate();
	    		msg = "세션 객체가 삭제됨";
	    	} else 
	    		msg = "삭제할 세션 객체가 없음";    	
	    }
		 
		out.print("<h2>"+msg+"</h2>");
		out.close();
	}
}









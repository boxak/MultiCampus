package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.LottoVO;


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
		LottoVO vo =new LottoVO();
		LocalDateTime ctime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh시 mm분");
		if(chance[0]>=4) {
			vo.setMsg("더 이상 응모할 수 없어요...ㅜㅜ 브라우저를 재기동해주세요~");
		}
		
		else {
			if(luckyNum == inputNum) {
				vo.setMsg(ctime.format(formatter)+"에 당첨!! 추카추카~");
				vo.setImgURL("/edu/images/sun.png");
				chance[0]=10;
			}
			else {
				vo.setMsg(ctime.format(formatter)+"에 당첨 실패!! 아쉽아쉽~");
				vo.setImgURL("/edu/images/cloud.png");
				vo.setLinkDisplay(true);
			}
		}
		request.setAttribute("lotto", vo);
		RequestDispatcher impossible = request.getRequestDispatcher("/jspexam/lottoView.jsp");
		
		impossible.forward(request,response);
	}

}

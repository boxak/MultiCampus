package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String userName=request.getParameter("user_name");
		String roomName=request.getParameter("room");
		String [] addRequest=request.getParameterValues("additional");
		String reserDate=request.getParameter("gdate");
		String reserTime=request.getParameter("gtime");
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date to=null;
		try {
			to = transFormat.parse(reserDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat transFormatter = new SimpleDateFormat("yyyy년 MM월 dd일");
		String reserDateInfo=transFormatter.format(to);
		String reserTimeInfo="";
		int hour=Integer.parseInt(reserTime.substring(0,2));
		if(0<=hour && hour<12) {
			reserTimeInfo+="오전 ";
			reserTimeInfo+=reserTime;
		}
		else {
			reserTimeInfo+="오후 ";
			reserTimeInfo+=Integer.toString(hour-12)+reserTime.substring(2,5);
		}
		out.print("<h1>"+userName+"님의 예약내용</h1><hr>");
		out.print("<ul>");
		out.print("<li>룸 : "+roomName+"</li>");
		out.print("<li>추가 요청 사항 : ");
		if(addRequest==null) {
			out.print("없음</li>");
		}
		else {
			out.print(addRequest[0]);
			for(int i=1;i<addRequest.length;i++) {
				out.print(","+addRequest[i]);
			}
			out.print("</li>");
		}
		out.print("<li>예약 날짜 : "+reserDateInfo+" "+reserTimeInfo+"</li>");
		out.print("<hr>");
		out.print("<a href='/sedu/html/reservation.html'>예약입력 화면으로</a>");
	}

}

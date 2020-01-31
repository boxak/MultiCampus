package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MeetingJDBCDAO;
import model.vo.MeetingVO;

@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MeetingVO> list = new ArrayList<>();
		MeetingJDBCDAO mjd = new MeetingJDBCDAO();
		
		String keyword = request.getParameter("keyword");
		String delete = request.getParameter("delete");
		
		if(delete!=null) {
			System.out.println("delete "+delete);
			mjd.delete(Integer.parseInt(delete));
			list = mjd.listAll();
		}
		
		else if(keyword==null) {
			list = mjd.listAll();
		}
		else {
			list = mjd.search(keyword);
		}
		if(!list.isEmpty()) {
			
			for(MeetingVO vo : list) {
				System.out.println(vo);
			}
			System.out.println("----------------------------");
		}
		
		request.setAttribute("MeetingTable", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jspexam/meetingView.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String date = request.getParameter("meetingDate");
		
		System.out.println(date);
		
		MeetingJDBCDAO mjd = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(date);
		
		mjd.insert(vo);

		List <MeetingVO> list = new ArrayList<>();
		list = mjd.listAll();
		request.setAttribute("MeetingTable", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jspexam/meetingView.jsp");
		rd.forward(request, response);
	}

}

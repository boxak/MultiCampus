package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.JobadDAO;
import model.vo.JobadVO;

@WebServlet("/jobad")
public class JobadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String param = request.getParameter("pgNum");
		System.out.println(param);
		int pgNum = param==null || param.equals("") ? 1 : Integer.parseInt(param);
		JobadDAO dao = new JobadDAO();
		List<JobadVO> list = null;
		int count = 0;
		String linkStr = "";
		HttpSession session = request.getSession();
		if(action==null) {
			list = dao.listAll(pgNum);
			request.setAttribute("msg", "구인 게시판");
			if(list!=null && list.size()!=0) {
				request.setAttribute("list",list);
			}
			count = dao.getCount();
		}
		else if(action.equals("sort")) {
			String key = request.getParameter("key");
			list = dao.listSort(key,pgNum);
			request.setAttribute("msg", "구인 리스트("+key+"정렬)");
			if(list!=null && list.size()!=0) {
				request.setAttribute("list",list);
			}
			count = dao.getCount();
			linkStr = "&action=sort&key="+key;
		}
		else if(action.equals("listone")) {
			int post_id = Integer.parseInt(request.getParameter("post_id"));
			JobadVO vo = dao.listOne(post_id);
			if(vo!=null) {
				session.setAttribute("vo", vo);
				request.setAttribute("msg", "구인 내용");
				request.setAttribute("vo",vo);
			}
		}
		else if(action.equals("listWriter")) {
			String writer = request.getParameter("mem_username");
			list = dao.listWriter(writer, pgNum);
			request.setAttribute("msg", "구인 게시판");
			if(list!=null && list.size()!=0) {
				request.setAttribute("list",list);
				//request.setAttribute("etc", "fullListButton");
				count = dao.getCount(writer);
				linkStr = "&action=listwriter&mem_username="+writer;
			}
		}
		else if(action.equals("search")) {
			String key = request.getParameter("key");
			String searchType = request.getParameter("searchType");
			list = dao.search(key, searchType, pgNum);
			if(list!=null && list.size()!=0) {
				request.setAttribute("msg", key+"을 포함하는 글 리스트");
				request.setAttribute("list",list);
				//request.setAttribute("etc","fullListButton");
				count = dao.getCount(key,searchType);
				linkStr = "&searchType="+searchType+"&key="+key+"&action=search";
			}
			else {
				request.setAttribute("snull", key+"을 포함하는 검색글이 없습니다.");
				System.out.println("snull : "+request.getAttribute("snull"));
			}
		}
		else if(action.equals("delete")) {
			int post_id = Integer.parseInt(request.getParameter("post_id"));
			int num = dao.delete(post_id);
			System.out.println("post_id : "+post_id+", 삭제 : "+num);
			response.sendRedirect("/mvc/jobad?pgNum="+pgNum);
			return;
		}
		request.setAttribute("totalCount",count);
		request.setAttribute("pagelist",new JobadDAO().getPageLinkList(pgNum, linkStr, count));
		request.setAttribute("pgNum", pgNum);
		session.setAttribute("pgNum", pgNum);
		request.getRequestDispatcher("/jspexam/jobadView.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String post_id = request.getParameter("post_id");
		String param = request.getParameter("pgNum");
		//System.out.println("mem_userid : "+request.getParameter("mem_userid"));
		int pgNum = param==null || param.equals("") ? 1 : Integer.parseInt(param);
		
		JobadDAO dao = new JobadDAO();
		JobadVO vo = new JobadVO();
		if(post_id!=null) {
			vo.setPost_id(Integer.parseInt(post_id));
			vo.setMem_userid(request.getParameter("mem_userid"));
			vo.setMem_username(request.getParameter("mem_username"));
			vo.setPost_title(request.getParameter("post_title"));
			vo.setPost_content(request.getParameter("post_content"));
			vo.setPost_location(request.getParameter("post_location"));
			vo.setPost_payment(Integer.parseInt(request.getParameter("post_payment")));
			vo.setPost_phone(request.getParameter("post_phone"));
		}
		if(action.equals("insert")) {
			dao.insert(vo);
		}
		else if(action.equals("update")) {
			boolean flag = dao.update(vo);
			System.out.println("flag : "+flag);
		}
		response.sendRedirect("/mvc/jobad?pgNum="+pgNum);
	}

}

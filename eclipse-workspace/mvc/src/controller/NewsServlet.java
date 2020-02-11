package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.vo.NewsVO;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NewsServlet() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String key = request.getParameter("key");
		String searchType = "";
		int id = 0;
		if(request.getParameter("newsid")!=null) {
			id = Integer.parseInt(request.getParameter("newsid"));
		}
		NewsDAO nd = new NewsDAO();
		List<NewsVO> list = new ArrayList<>();
		if(action==null) {
			list = nd.listAll();
		}
		NewsVO vo = null;
		if(action!=null) {
			if(action.equals("read")) {
				vo = nd.listOne(id);
				list = nd.listAll();
			}
			else if(action.equals("delete")) {
				nd.delete(id);
				list = nd.listAll();
			}
			else if(action.contains("search")) {
				searchType = action.split("-")[1];
				list = nd.search(key, searchType);
				//System.out.println(searchType+","+key);
			}
			else if(action.equals("listwriter")) {
				//System.out.println("writer : "+key);
				list = nd.listWriter(key);
			}
		}
		/*
		if(list!=null) {
			for(NewsVO data : list) {
				System.out.println(data);
			}
		}*/
		request.setAttribute("view", vo);
		request.setAttribute("viewlist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jspexam/news.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int id = 0;
		if(request.getParameter("newsid")!=null) {
			id = Integer.parseInt(request.getParameter("newsid"));
		}
		int cnt = 0;
		if(request.getParameter("cnt")!=null) {
			cnt = Integer.parseInt(request.getParameter("cnt"));
		}
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		NewsDAO nd = new NewsDAO();
		NewsVO vo = new NewsVO();
		List<NewsVO> list = new ArrayList<>();
		if(action.equals("insert")) {
			vo.setWriter(writer);
			vo.setTitle(title);
			vo.setContent(content);
			nd.insert(vo);
		}
		else if(action.equals("update")) {
			vo.setId(id);
			vo.setWriter(writer);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCnt(cnt);
			nd.update(vo);
		}
		list = nd.listAll();
		request.setAttribute("viewlist", list);
		request.setAttribute("view", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/jspexam/news.jsp");
		rd.forward(request, response);
	}

}

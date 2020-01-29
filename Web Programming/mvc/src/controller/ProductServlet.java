package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.ProductVO;


@WebServlet("/productservlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/jspexam/productView.jsp");
		
		
		String pid = request.getParameter("pid");
		//System.out.println(vo);
		if(session.getAttribute("product")==null) {
			session.setAttribute("product", new ProductVO());
		}
		ProductVO vo = (ProductVO)session.getAttribute("product");
		System.out.printf("%d %d %d%n",vo.getCnt1(),vo.getCnt2(),vo.getCnt3());
		switch (pid) {
			case "p001" : vo.setCnt1(1);
				break;
			case "p002" : vo.setCnt2(1);
				break;
			case "p003" : vo.setCnt3(1);
				break;
		}
		
		rd.forward(request, response);
	}

}

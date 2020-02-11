package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static void printDate(String str,String id) throws IOException{
		File file = new File("C:/logtest");
		if(!file.exists()) {
			file.mkdirs();
		}
		FileWriter fw = new FileWriter("C:/logtest/mylog.txt",true);
		fw.write(str+" "+id);
		fw.write("\r\n");
		fw.close();
	}
	
	static void nowTimeInfo(String id) throws IOException{
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmm");
		String str = sdf.format(today);
		printDate(str,id);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("pid");
		HttpSession hs = null;
		hs = request.getSession();
		if(id==null || id=="") {
			out.print("이 곳 주소를 직접 입력하지 마시고 상품을 클릭해주세요!");
		}
		else if(id.equals("reset")) {
			if(hs!=null) {
				hs.removeAttribute("pid");
				out.print("");
			}
		}
		else{
			if(hs.isNew()) {
				System.out.println("객체를 새로 생성!");
			}
			else {
				System.out.println("객체는 이미 생성되어 있음.");
			}
			if(hs.getAttribute("pid")==null) {
				//session에 cnt변수가 등록이 안되어 있으면 등록하고,
				//등록되어 있으면 넣지 않는다.
				hs.setAttribute("pid",new int[10]); //데이터를 저장할 방을 등록. 반드시 객체여야 한다.
			}
			int [] session_v=(int[])hs.getAttribute("pid");
			int inx=id.charAt(3)-'0';
			session_v[inx]++;
			
			out.print("{");
			//System.out.println("{");
			for(int i=0;i<session_v.length-1;i++) {
				out.print("\"p00"+i+"\":"+session_v[i]+",");
				
				//System.out.println("{\"p00"+i+"\":"+session_v[i]+"}");
			}
			out.print("\"p00"+(session_v.length-1)+"\":"+session_v[session_v.length-1]);
			
			//System.out.println("}");
			out.print("}");
			nowTimeInfo(id);
			
		}
		out.close();
	}

}

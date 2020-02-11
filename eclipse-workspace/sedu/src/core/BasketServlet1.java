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


@WebServlet("/basket1")
public class BasketServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static void printDate(String str,String id) throws IOException{
		File file = new File("C:/logtest");
		if(!file.exists()) {
			file.mkdirs();
		}
		FileWriter fw = new FileWriter("C:/logtest/mylog.txt",true);
		fw.write(str+id);
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
		out.print("{\"pid\":\""+id+"\"}");
		out.close();
		nowTimeInfo(id);
		
	}

}

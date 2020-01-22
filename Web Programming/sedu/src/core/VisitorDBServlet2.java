package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/visitordb2")
public class VisitorDBServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//GET - visitor 테이블의 데이터들을 모두 읽어 와서 테이블 형식으로 브라우저로 출력
	//POST - 전송되는 Query 문자열을 가지고 visitor 테이블에 저장

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//doGet 메서드의 조상 메서드가 throws 하는 범위보다 더 많이 예외를 throws 하지 못함!
		
		try {
			//드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 오류");
		}
		
		//DB서버 접속, Statement 객체 생성, "SELECT * FROM VISITOR" SQL 명령문 수행
		String sql = "select name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"') writedate, memo from visitor"; 
		try (	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();			
				ResultSet rs = stmt.executeQuery(sql);) {
			out.print("<h1>방명록 리스트</h1><hr>");
			out.print("<table border='1'>");
			while(rs.next()) {
				out.print("<tr>");
				out.print("<td>"+rs.getString("name")+"</td>");
				out.print("<td>"+rs.getString("writedate")+"</td>");
				out.print("<td>"+rs.getString("memo")+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		}
		catch(SQLException e) {
			out.print("<h2>오류 발생!</h2>");
			e.printStackTrace();
		}
		out.print("<hr><a href='/sedu/html/visitorMain.html'>방명록 메인 화면으로 가기</a>");
		out.close();
	}
	//방명록 읽기
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("gname");
		String memo = request.getParameter("gtext");
		
		
		try {
			//드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 오류");
		}
		
		//DB서버 접속, Statement 객체 생성, "SELECT * FROM VISITOR" SQL 명령문 수행
		//select는 그냥 statement를 쓴다. insert는 preparedstatement를 쓰는 게 더 적합함.
		//preparedStatement는 객체 생성시 이미 sql문을 생성자 아규먼트로 줘야 한다.
		String sql = "insert into visitor values(?,sysdate,?)";
		System.out.println(sql);
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1,name);
			pstmt.setString(2,memo);
			pstmt.executeUpdate(); //->이 때, sql문을 주면 안된다. 이미 sql문이 준비되어 있기 때문.
			//executeUpdate는 close가 필요하지 않은 메서드이기 때문에 try with close 구문안에 쓸 수 없다.
			//여기까지 왔으면 예외 발생없이 잘 실행되었음을 의미함.
			out.print("<h2>방명록 저장 성공!!</h2>");
			
		}
		catch(SQLException e) {
			out.print("<h2>방명록 저장 실패!!</h2>");
			e.printStackTrace();
		}
		out.print("<hr><a href='/sedu/html/visitorMain.html'>방명록 메인 화면으로 가기</a>");
		out.close();
	}
	//방명록 작성
}

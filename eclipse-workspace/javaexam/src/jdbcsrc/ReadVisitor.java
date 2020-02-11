package jdbcsrc;
import java.sql.*;

public class ReadVisitor {

	public static void main(String[] args) throws Exception {
		
		/*
		 -JDBC 프로그램의 구현 순서
			1. JDBC Driver 로딩 - Class.forName()
			2. JDBC에 접속 - DriverManager.getConnection("jdbc url","계정","암호");
			3. Statement/PreparedStatement 객체 생성.
			4. 처리하려는 기능에 따라 sql문을 전달하고 수행시킨다.
			5. 결과 처리
					ResultSet 객체
					next() 메서드로 행단위로 옮겨감. getXXX()->각 행에 있는 각 컬럼값을 꺼낸다.
					select 명령의 수행 결과 여부에 상관없이 resultSet 객체는 리턴되다. 
			6. 종료시 close() 필수
		 */
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jdbctest","jdbctest");
		
		//System.out.println(conn);
		
		Statement stmt=conn.createStatement();
		String sql="select name,writedate,memo from visitor";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString("name")+":"
					+rs.getDate("writedate")+":"+rs.getString("memo"));
		}
		System.out.println("------------------------");
		rs.close();
	}

}

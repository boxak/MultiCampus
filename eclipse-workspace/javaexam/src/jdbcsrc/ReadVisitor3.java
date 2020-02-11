package jdbcsrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadVisitor3 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
			stmt = conn.createStatement();
			String sql = "select name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"') writedate, memo from visitor";
			//전체에 더블 인용부호로 감싸져 있으므로 "를 쓸때, \"로 사용해줘야 한다.
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				//System.out.print(rs.getString("name")+"\t");
				//System.out.print(rs.getString("writedate")+"\t");
				//System.out.println(rs.getString("memo"));
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\n");
			}
		} catch (Exception e) {
			System.err.println("오류 발생 : " + e);
			// 표준 오류 출력 메서드, System.out과 별 차이는 없다.
		} finally {
			try {
				//Null 인 상태, 즉 객체 생성 안된 상태에선 close()를 호출하면 NullPointerException이 걸린다.
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

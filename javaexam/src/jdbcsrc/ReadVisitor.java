package jdbcsrc;
import java.sql.*;

public class ReadVisitor {

	public static void main(String[] args) throws Exception {
		
		/*
		 -JDBC ���α׷��� ���� ����
			1. JDBC Driver �ε� - Class.forName()
			2. JDBC�� ���� - DriverManager.getConnection("jdbc url","����","��ȣ");
			3. Statement/PreparedStatement ��ü ����.
			4. ó���Ϸ��� ��ɿ� ���� sql���� �����ϰ� �����Ų��.
			5. ��� ó��
					ResultSet ��ü
					next() �޼���� ������� �Űܰ�. getXXX()->�� �࿡ �ִ� �� �÷����� ������.
					select ����� ���� ��� ���ο� ������� resultSet ��ü�� ���ϵǴ�. 
			6. ����� close() �ʼ�
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

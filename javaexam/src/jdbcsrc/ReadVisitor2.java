package jdbcsrc;
import java.sql.*;
import java.util.Scanner;
public class ReadVisitor2 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jdbctest","jdbctest");
		
		//System.out.println(conn);
		
		Statement stmt=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("�˻��� �̸��� �Է��ϼ���. : ");
		String searchName=sc.nextLine();
		String sql="select * from visitor "
				+ "where name = '"+searchName
				+"'";
		sc.close();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) { //getXXX()�� ������ �Լ�����.
			System.out.println(rs.getString("name")+":"
					+rs.getDate("writedate")+":"+rs.getString("memo"));
		}
		System.out.println("------------------------");
		rs.close();
		stmt.close();
		conn.close();
	}

}

package jdbcsrc;
import java.sql.*;
import java.util.Scanner;
public class ReadEmp {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
		
		//System.out.println(conn);
		
		Statement stmt=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.print("�˻��� �μ� ��ȣ�� �Է��ϼ���. : ");
		String searchDeptno=sc.next();
		String sql="select ename,sal,deptno from emp "
				+ "where deptno = '"+searchDeptno
				+"'";
		sc.close();
		ResultSet rs=stmt.executeQuery(sql);
		
		if(rs.next()) {
			do {
				System.out.println(rs.getString("ename")+":"
						+rs.getInt("sal")+":"+rs.getInt("deptno"));
			}while(rs.next());
		}
		else {
			System.out.println(searchDeptno+"�� �μ��� �ٹ��ϴ� ������ �����ϴ�.");
		}
		
		System.out.println("------------------------");
		rs.close();
		stmt.close();
		conn.close();
	}

}

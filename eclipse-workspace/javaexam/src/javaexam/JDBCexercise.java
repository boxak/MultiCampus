package javaexam;

import java.sql.*;

public class JDBCexercise {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			System.out.println("���� �߻� : "+cnfe);
		}
		String sql="select * from emp";
		String address="jdbc:oracle:thin:@localhost:1521:XE";
		try(Connection conn=DriverManager.getConnection(address,"scott","tiger");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);){
			if(rs.next()) {
				do {
					System.out.println(rs.getString("ename")+"  "+rs.getInt("sal"));
				}while(rs.next());
			}
			else {
				System.out.println("�ƹ��͵� ��µ��� ����.");
			}
		}catch(Exception e) {
			System.out.println("���� �߻� : "+ e);
		}

	}

}

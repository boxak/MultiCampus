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
		try(Connection conn=DriverManager.getConnection(address);
			)

	}

}
